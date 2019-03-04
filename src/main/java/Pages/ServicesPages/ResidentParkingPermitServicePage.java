package Pages.ServicesPages;

import BasePackage.BasePage;
import Pages.AuthPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

//Внесение в Реестр записи о парковочном разрешении жителя https://gu.spb.ru/188871/eservice/
public class ResidentParkingPermitServicePage extends BasePage {

    private WebDriver driver;

    public ResidentParkingPermitServicePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//span[@id='pagetitle']");

    public String getServiceHeadingText(){
        $(serviceHeading);
        return $(serviceHeading).getText();
    }

    //Меню выбора вида предоставления услуги
    private By eserviceMethodButton = By.xpath("//a[@href='/188871/eservice/']");
    private By mfcMethodButton = By.xpath("//a[@href='/188871/mfcservice/']");

    public String getMethodOfServiceText(String methodService){
        $(By.xpath("//a[@href='/188871/" + methodService + "/']"));
        return $(By.xpath("//a[@href='/188871/" + methodService + "/']")).getText();
    }
    public ResidentParkingPermitServicePage clickMethodOfServiceButton(String methodService){
        $(By.xpath("//a[@href='/188871/" + methodService + "/']")).click();
        return this;
    }

    //Общее описание
    private By serviceDescriptionHeading = By.xpath("//article[@id='group-text']/h2");
    private By registryNumber = By.xpath("//article[@id='number']/p");
    private By recordToMfcButton = By.xpath("//a[text()=' Запись в МФЦ']");

    public String getServiceDescriptionHeadingText(){
        return $(serviceDescriptionHeading).getText();
    }

    public String getRegistryNumberText() {
        return $(registryNumber).getText();
    }

    public boolean recordToMfcButtonIsDisplayed(){
        return $(recordToMfcButton).isDisplayed(); }

    public ResidentParkingPermitServicePage clickRecordToMfcButton(){
        $(recordToMfcButton).click();
        $(phoneNumber);
        return this;
    }

    //Блок быстрого перехода по информации
    @FindBy(xpath = "//ul[@class='nav']/li")
    private List<WebElement> navbarList;

    private By getServiceButton = By.xpath("//nav[@id='navbar-example']/" +
            "a[@href='https://eservice.gu.spb.ru/portalFront/resources/portal.html?offer=1&serviceId=795.0.10.01.1&nSR=true&nAD=true#offer']");
    private By mfcMapButton = By.xpath("//nav[@id='navbar-example']/a[@href='/mfc/#mfc-map']");

    public ResidentParkingPermitServicePage clickNavbarList(int index){
        $(navbarList.get(index)).click();
        return this;
    }

    public boolean navbarCollectionSize(int size){
        boolean equality = false;
        if(navbarList.size() == size) { equality = true; }
        return equality;
    }
    public boolean getServiceButtonIsDisplayed(){
        return $(getServiceButton).isDisplayed();
    }
    public boolean mfcMapButtonIsDisplayed(){
        return $(mfcMapButton).isDisplayed();
    }
    public String getServiceButtonText(){ return $(getServiceButton).getText(); }
    public String getMfcMapButtonText() { return $(mfcMapButton).getText(); }
    public AuthPage clickGetServiceButton(){
        $(getServiceButton).click();
        return new AuthPage(driver);
    }

    //Модальное окно Запись на прием в МФЦ
    private By preRegistrationPhone = By.xpath("//div[@class='modal-body']//h5");
    private By phoneNumber = By.xpath("//a[@href='tel:+7-812-573-90-00']");

    public String getPreRegistrationPhoneText() { return $(preRegistrationPhone).getText(); }
    public String getPhoneNumberText() { return $(phoneNumber).getText(); }

    //Прелоадеры
    private By globalPreloader = By.xpath("//div[@id='global-preloader-div']");
    private By preloader = By.xpath("//div[@id='preloader-div']");

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
