package Pages.PaymentPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentInteractivePage extends BasePage { //Страницы оплат. Интерактивный портал
    private WebDriver driver;

    public PaymentInteractivePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Выход из учетки
    private By logoutButton = By.xpath("//a[@id='logout']");

    public PaymentInteractivePage clickLogoutButton(){
        $(logoutButton).click();
        return this;
    }

    private By pageHeading = By.xpath("//h1[@id='PaymentTitle']");

    private By payZsdButton = By.xpath("//button[@id='yandexFormSubmit']");
    private By payRosreestrButton = By.xpath("//button[@id='payment-rosreestr-submit']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    public boolean payZsdButtonIsDisplayed(){ return $(payZsdButton).isDisplayed(); }
    public boolean payRosreestrButtonIsDisplayed(){ return $(payRosreestrButton).isDisplayed(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
