package Pages.MfcPages;

import BasePackage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateFeedbackPage extends BasePage { //Оставить отзыв о посещении МФЦ https://gu.spb.ru/mfc/comment/

    private WebDriver driver;

    public CreateFeedbackPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//div[@class='col-lg-12']//h2");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    public CreateFeedbackPage clickPageHeading(){
        $(pageHeading).click();
        return this;
    }

    //Боковое меню
    @FindBy(xpath = "//nav[@class='menu-side ']/ul/li")
    private List<WebElement> menuList;

    public boolean menuListSize(int size){
        boolean equality = false;
        if(menuList.size() == size) {
            equality = true;
        }
        return equality;
    }

    //Выпадающий список район/адрес МФЦ
    private By addressField = By.xpath("//span[@class='selection']");

    @FindBy(xpath = "//span[@class='select2-results']/ul/li")
    private List<WebElement> adressList;

    public CreateFeedbackPage clickAdressField(){
        $(addressField).click();
        return this;
    }

    public String getAdressFieldText(){ return $(addressField).getText(); }

    public boolean adressListSize(int size){ //63
        boolean equality = false;
        if(adressList.size() == size) {
            equality = true;
        }
        return equality;
    }

    //Тема обращения
    private By topicAppealField = By.xpath("//input[@placeholder='Опишите коротко тему обращения']");
    private By errorText = By.xpath("//span[contains(text(),'Это обязательное поле')]");

    public CreateFeedbackPage typeTopicAppealField(String topic){
        $(topicAppealField).sendKeys(topic);
        this.clickPageHeading();
        return this;
    }

    //Ваше обращение
    private By yourAppealField = By.xpath("//textarea[@placeholder='Изложите подробнее суть вашего обращения']");

    public CreateFeedbackPage typeYourAppealField(String topic){
        $(yourAppealField).sendKeys(topic);
        this.clickPageHeading();
        return this;
    }

    //Фамилия и имя
    private By lastNameField = By.xpath("//input[@id='lastname']");
    private By firstNameField = By.xpath("//input[@id='firstname']");

    public CreateFeedbackPage typeLastNameField(String lastname){
        $(lastNameField).sendKeys(lastname);
        this.clickPageHeading();
        return this;
    }

    public CreateFeedbackPage typeFirstNameField(String firstname){
        $(firstNameField).sendKeys(firstname);
        this.clickPageHeading();
        return this;
    }

    //Адрес электронной почты
    private By emailField = By.xpath("//input[@type='email']");
    private By errorEmail = By.xpath("//div[@id='error-email']");

    public CreateFeedbackPage clickEmailField(){
        $(emailField).click();
        return this;
    }

    public CreateFeedbackPage typeEmailField(String email){
        this.clickEmailField();
        $(emailField).clear();
        $(emailField).sendKeys(email);
        this.clickPageHeading();
        return this;
    }

    public boolean emailFieldIsDisplayed(){ return driver.findElement(errorEmail).isDisplayed(); }

    //Мобильный телефон
    private By phoneField = By.xpath("//input[@id='phone']");

    public CreateFeedbackPage typePhoneField(String phone){
        $(phoneField).sendKeys(phone);
        this.clickPageHeading();
        return this;
    }

    //Кнопка "Отправить"
    private By sendButton = By.xpath("//a[@class='btn btn-primary']");

    public boolean sendButtonIsDisplayed(){ return $(sendButton).isDisplayed(); }

    public CreateFeedbackPage typeFeedbackPage(String appealField, String firstname, String lastname, String emailIncorrect, String email, String phone){
        this.clickAdressField();
        Assert.assertTrue(adressListSize(63));

        this.typeTopicAppealField(appealField);
        Assert.assertFalse(isElementPresent(errorText));

        this.typeYourAppealField(appealField);
        Assert.assertFalse(isElementPresent(errorText));

        this.typeLastNameField(lastname);
        Assert.assertFalse(isElementPresent(errorText));

        this.typeFirstNameField(firstname);
        Assert.assertFalse(isElementPresent(errorText));

        this.typeEmailField(emailIncorrect);
        Assert.assertTrue(this.isElementPresent(errorEmail));

        this.typeEmailField(email);
        Assert.assertFalse(this.emailFieldIsDisplayed());

        this.typePhoneField(phone);
        Assert.assertFalse(isElementPresent(errorText));

        return this;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
