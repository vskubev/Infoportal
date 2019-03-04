package Pages.ServicesPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InternationalPassportPage extends BasePage {
    private WebDriver driver;

    public InternationalPassportPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//span[@id='pagetitle']");

    public String getServiceHeadingText(){ return $(serviceHeading).getText(); }

    //Меню выбора вида предоставления услуги
    private By eserviceMethodButton = By.xpath("//a[@href='/188421/eservice/']");
    private By mfcMethodButton = By.xpath("//a[@href='/188421/mfcservice/']");
    private By traditionalMethodButton = By.xpath("//a[@href='/188421/traditional/']");

    public String getEserviceMethodButtonText(){ return $(eserviceMethodButton).getText(); }
    public String getMfcMethodButtonText(){ return $(mfcMethodButton).getText(); }
    public String getTraditionalMethodButtonText(){ return $(traditionalMethodButton).getText(); }

    //Блок быстрого перехода по информации
    private By getServiceButton =
            By.xpath("//a[@href='https://eservice.gu.spb.ru/portalFront/resources/portal.html?widget=foreignPass#openPlatform']");

    @FindBy(xpath = "//nav[@id='navbar-example']/ul/li")
    private List<WebElement> navbarCollection;

    public boolean getServiceButtonIsDisplayed() { return $(getServiceButton).isDisplayed(); }

    public boolean navbarCollectionSize(int size){
        boolean equality = false;
        if(navbarCollection.size() == size) { equality = true; }
        return equality;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}

