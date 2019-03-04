package Pages.ServicesPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayGovernmentPage extends BasePage {//Взаиморасчеты с государством https://gu.spb.ru/464211/eservice/
    private WebDriver driver;

    public PayGovernmentPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//span[@id='pagetitle']");

    public String getServiceHeadingText(){ return $(serviceHeading).getText(); }

    //Меню выбора вида предоставления услуги
    private By eserviceMethodButton = By.xpath("//a[@href='/464211/eservice/']");

    public String getEserviceMethodButtonText(){ return $(eserviceMethodButton).getText(); }

    //Блок быстрого перехода по информации
    private By getServiceButton =
            By.xpath("//a[@href='https://eservice.gu.spb.ru/portalFront/resources/portal.html?widget=settlement#openPlatform']");

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
