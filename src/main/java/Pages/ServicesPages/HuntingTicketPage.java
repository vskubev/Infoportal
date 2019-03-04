package Pages.ServicesPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HuntingTicketPage extends BasePage { //Выдача и аннулирование охотничьих билетов единого федерального образца https://gu.spb.ru/188765/short/
    private WebDriver driver;

    public HuntingTicketPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//span[@id='pagetitle']");

    public String getServiceHeadingText() { return $(serviceHeading).getText(); }

    //Способ получения услуги
    private By eserviceMethodButton = By.xpath("//ul[@class='get-services']//a[@href='/188765/eservice/']");
    private By mfcMethodButton =
            By.xpath("//ul[@class='get-services']//a[@href='/188765/mfcservice/']");
    private By traditionalMethodButton =
            By.xpath("//ul[@class='get-services']//a[@href='/188765/traditional/']");
    private By getServiceButton = By.xpath("//a[@href='https://eservice.gu.spb.ru/portalFront/resources/portal.html?serviceId=298.0.10.01.1#dynamicService']");

    public boolean eserviceMethodButtonIsDisplayed() { return $(eserviceMethodButton).isDisplayed(); }
    public boolean mfcMethodButtonIsDisplayed() { return $(mfcMethodButton).isDisplayed(); }
    public boolean traditionalMethodButtonIsDisplayed() { return $(traditionalMethodButton).isDisplayed(); }
    public boolean getServiceButtonIsDisplayed() { return $(getServiceButton).isDisplayed(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
