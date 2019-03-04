package Pages.ServicesPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ChildPayoutPage extends BasePage { //Единовременная компенсационная выплата при рождении ребенка https://gu.spb.ru/187899/eservice/
    private WebDriver driver;

    public ChildPayoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//span[@id='pagetitle']");

    public String getServiceHeadingText(){ return $(serviceHeading).getText(); }

    //Меню выбора вида предоставления услуги
    private By eserviceMethodButton = By.xpath("//a[@href='/187899/eservice/']");
    private By mfcMethodButton = By.xpath("//a[@href='/187899/mfcservice/']");
    private By traditionalMethodButton = By.xpath("//a[@href='/187899/traditional/']");

    public String getEserviceMethodButtonText(){ return $(eserviceMethodButton).getText(); }
    public String getMfcMEthodButtonText(){ return $(mfcMethodButton).getText(); }
    public String getTraditionalMethodButtonText(){ return $(traditionalMethodButton).getText(); }

    //Общее описание
    private By serviceDescriptionHeading = By.xpath("//article[@id='group-text']/h2");
    private By registryNumber = By.xpath("//article[@id='number']/p");

    public String getServiceDescriptionHeadingText(){
        return $(serviceDescriptionHeading).getText();
    }
    public String getRegistryNumberText() { return $(registryNumber).getText(); }

    //Блок быстрого перехода по информации
    private By getServiceButton =
            By.xpath("//a[@href='https://eservice.gu.spb.ru/portalFront/resources/portal.html?serviceId=33.0.10.01.1#dynamicService']");

    @FindBy(xpath = "//ul[@class='nav']/li")
    private List<WebElement> navbarCollection;

    public boolean getServiceButtonIsDisplayed() { return $(getServiceButton).isDisplayed(); }

    public boolean navbarCollectionSize(int size){
        boolean equality = false;
        if(navbarCollection.size() == size) {
            equality = true;
        }
        return equality;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
