package Pages.ServicesPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FirstGradePage extends BasePage { //Зачисление в 1 класс следующего учебного года https://gu.spb.ru/188357/short/
    private WebDriver driver;

    public FirstGradePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//span[@id='pagetitle']");

    public String getServiceHeadingText(){ return $(serviceHeading).getText(); }

    //Способ получения услуги

    private By eserviceMethodButton = By.xpath("//ul[@class='get-services']//a[@href='/188357/eservice/']");
    private By mfcMethodButton =
            By.xpath("//ul[@class='get-services']//a[@href='/188357/mfcservice/']");
    private By getServiceButton =
            By.xpath("//a[@href='https://eservice.gu.spb.ru/portalFront/resources/portal.html?offer=1&serviceId=700.0.10.01.1&nSR=true&nAD=true#offer']");

    public boolean eserviceMethodButtonIsDisplayed() { return $(eserviceMethodButton).isDisplayed(); }
    public boolean mfcMethodButtonIsDisplayed() { return $(mfcMethodButton).isDisplayed(); }
    public boolean getServiceButtonIsDisplayed() { return $(getServiceButton).isDisplayed(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
