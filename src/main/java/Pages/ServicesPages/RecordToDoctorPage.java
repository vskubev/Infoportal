package Pages.ServicesPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RecordToDoctorPage extends BasePage { //Запись к врачу https://gu.spb.ru/188453/eservice/
    private WebDriver driver;

    public RecordToDoctorPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//span[@id='pagetitle']");

    public String getServiceHeadingText(){ return $(serviceHeading).getText(); }

    //Меню выбора вида предоставления услуги
    private By eserviceMethodButton = By.xpath("//a[@href='/188453/eservice/']");
    private By traditionalMethodButton = By.xpath("//a[@href='/188453/traditional/']");

    public String getEserviceMethodButtonText(){ return $(eserviceMethodButton).getText(); }
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
            By.xpath("//nav[@id='navbar-example']/button");

    @FindBy(xpath = "//ul[@class='nav']/li")
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
