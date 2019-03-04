package Pages.PaymentPages;

import BasePackage.BasePage;
import Pages.AuthPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage extends BasePage { //Страница оплаты https://gu.spb.ru/payment/

    private WebDriver driver;

    public PaymentPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//span[@id='pagetitle']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //ЗСД
    private By zsdButton = By.xpath("//a[@href='https://eservice.gu.spb.ru/portalFront/resources/portal.html#payment/Skorostnoi_diametr']");

    public boolean zsdButtonIsDisplayed(){ return $(zsdButton).isDisplayed(); }

    public AuthPage clickZsdButton(){
        $(zsdButton).click();
        this.invisibilityElementsWait(globalPreloader, preloader);
        return new AuthPage(driver);
    }

    //Росреестр
    private By rosreestrButton = By.xpath("//a[@href='https://eservice.gu.spb.ru/portalFront/resources/portal.html#payment/Ros_reestr']");

    public boolean rosreestrButtonIsDisplayed(){ return $(rosreestrButton).isDisplayed(); }

    public AuthPage clickRosreestrButton(){
        $(rosreestrButton).click();
        this.invisibilityElementsWait(globalPreloader, preloader);
        return new AuthPage(driver);
    }

    //Остальной список без логотипов
    @FindBy(xpath = "//section[@class='ac-container']/div")
    private List<WebElement> paymentList;

    public AuthPage clickPaymentList(int index){
        $(paymentList.get(index)).click();
        return new AuthPage(driver);
    }

    public boolean paymentListSize(int size){
        boolean equality = false;
        if(paymentList.size() == size) {
            equality = true;
        }
        return equality;
    }
    //Список услуг оплаты для каждого из открывающегося списка
    @FindBy(xpath = "//section[@class='ac-container']/div//ul/li")
    private List<WebElement> paymentServicesList;

    public boolean paymentServicesListSize(int size){
        boolean equality = false;
        if(paymentServicesList.size() == size) {
            equality = true;
        }
        return equality;
    }

    //Прелоадеры
    private By globalPreloader = By.xpath("//div[@id='global-preloader-div']");
    private By preloader = By.xpath("//div[@id='preloader-div']");

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
