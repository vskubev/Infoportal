package Pages.ServicesPages;

import BasePackage.BasePage;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class KindergartenPage extends BasePage { //Зачисление детей в государственные детские сады https://gu.spb.ru/188351/short/

    private WebDriver driver;

    public KindergartenPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//span[@id='pagetitle']");

    public String getServiceHeadingText() { return $(serviceHeading).getText(); }

    //Способ получения услуги
    private By eserviceMethodButton = By.xpath("//ul[@class='get-services']//a[@href='/188351/eservice/']");
    private By mfcMethodButton =
            By.xpath("//ul[@class='get-services']//a[@href='/188351/mfcservice/']");
    private By getServiceButton =
            By.xpath("//a[@href='https://eservice.gu.spb.ru/portalFront/resources/portal.html?offer=1&serviceId=511&nSR=true&nAD=true#offer']");

    public boolean eserviceMethodButtonIsDisplayed() { return $(eserviceMethodButton).isDisplayed(); }
    public boolean mfcMethodButtonIsDisplayed() { return $(mfcMethodButton).isDisplayed(); }
    public boolean getServiceButtonIsDisplayed() { return $(getServiceButton).isDisplayed(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}