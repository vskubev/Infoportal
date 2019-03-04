package Pages.ServicesPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InnPage extends BasePage { //Узнай свой ИНН https://gu.spb.ru/188297/eservice/
    private WebDriver driver;

    public InnPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//span[@id='pagetitle']");

    public String getServiceHeadingText(){ return $(serviceHeading).getText(); }

    //Меню выбора вида предоставления услуги
    private By eserviceMethodButton = By.xpath("//a[@href='/188297/eservice/']");

    public String getEserviceMethodButtonText(){ return $(eserviceMethodButton).getText(); }

    //Блок быстрого перехода по информации
    private By getServiceButton =
            By.xpath("//a[@href='https://eservice.gu.spb.ru/portalFront/resources/portal.html?widget=inn#openPlatform']");

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
