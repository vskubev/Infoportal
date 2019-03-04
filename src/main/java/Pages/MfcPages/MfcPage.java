package Pages.MfcPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MfcPage extends BasePage { //Страница МФЦ https://gu.spb.ru/mfc/

    private WebDriver driver;

    public MfcPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Выделенный значок МФЦ
    private By activeButton = By.xpath("//nav[@class='menu']//li/a[@class='active']");

    public String getActiveButtonText(){
        $(activeButton);
        return $(activeButton).getText();
    }

    //Верхнее меню
    @FindBy(xpath = "//div[@class='collapseMenu']/nav[@class='menu menu-mfc']/ul/li")
    private List<WebElement> mfcMenuList;

    public OfficesMfcPage clickOfficeMfcButton(){
        $(mfcMenuList.get(1)).click();
        return new OfficesMfcPage(driver);
    }

    public MfcAllServicesPage clickMfcAllServicesButton(){
        $(mfcMenuList.get(2)).click();
        return new MfcAllServicesPage(driver);
    }

    public PressCenterPage clickPressCentrButton(){
        $(mfcMenuList.get(3)).click();
        return new PressCenterPage(driver);
    }

    public AboutMfcPage clickAboutMfcButton(){
        $(mfcMenuList.get(4)).click();
        return new AboutMfcPage(driver);
    }

    public FeedbackPage clickFeedbackButton(){
        $(mfcMenuList.get(5)).click();
        return new FeedbackPage(driver);
    }

    //Услуги по жизненным ситуациям
    private By lifeServicesHeading = By.xpath("//div[@class='grid-zs-mfc']/h4");

    @FindBy(xpath = "//div[@class='grid-cat mfc-zs']/div")
    private List<WebElement> lifeServicesList;

    public String getLifeServicesHeadingText(){ return $(lifeServicesHeading).getText(); }

    public LifeServicesPage clickLifeServicesList(int index){
        $(lifeServicesList.get(index)).click();
        return new LifeServicesPage(driver);
    }

    //Новости МФЦ
    private By mfcNewsHeading = By.xpath("//h2/a[@href='/mfc/news/']");

    public String getMfcNewsHeadingText(){ return $(mfcNewsHeading).getText(); }

    //Популярные услуги
    private By popularServicesHeading = By.xpath("//h2[contains(text(),'Популярные услуги МФЦ')]");

    public String getPopularServicesHeadingText(){ return $(popularServicesHeading).getText(); }

    //Услуги росреестра
    private By rosreestrServicesHeading = By.xpath("//h2[contains(text(),'Услуги Росреестра')]");

    public String getRosreestrServicesHeadingText(){ return $(rosreestrServicesHeading).getText(); }

    //Карта МФЦ
    private By mfcMap = By.xpath("//ymaps[@class='ymaps-2-1-72-events-pane ymaps-2-1-72-user-selection-none']");

    public boolean mfcMapIsDisplayed(){ return $(mfcMap).isDisplayed(); }

    //о МФЦ
    private By aboutMfcHeading = By.xpath("//h2/a[@href='/mfc/about/']");

    public String getAboutMfcHeadingText(){ return $(aboutMfcHeading).getText(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
