package Pages;

import BasePackage.BasePage;
import Pages.DocumentsBlanksPages.DocumentsBlanksPage;
import Pages.LegislationPages.LegislationPage;
import Pages.MfcPages.MfcPage;
import Pages.OrganizationsPages.OrganizationsPage;
import Pages.PaymentPages.PaymentPage;
import Pages.SearchPages.ResultSearchPage;
import Pages.ServicesPages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Авторизация
    private By signInButton = By.xpath("//a[@id='login']");

    public AuthPage clickSignInButton(){
        $(signInButton).click();
        return new AuthPage(driver);
    }

    //каталог услуг
    @FindBy(xpath = "//div[@class='mw']/ul/li")
    private List<WebElement> serviceCatalogList;

    private By serviceCatalogButton = By.xpath("//label[text()=' Каталог услуг']");
    private By servicesListButton = By.xpath("//a[@href='/services/'][text()='Полный список услуг']");

    public MainPage clickServicesCatalogButton() {
        $(serviceCatalogButton).click();
        return this;
    }

        //Открыть выпадающий список Каталог услуг и перейти в полный список услуг
    public ServicesPage clickServicesListButton() {
        this.clickServicesCatalogButton();
        $(servicesListButton).click();
        return new ServicesPage(driver);
    }

    public String getServiceFromCatalogText(int index){
        return $(serviceCatalogList.get(index)).getText();
    }

    //Поисковая строка
    private By searchField = By.xpath("//input[@placeholder='Поиск']");

    public ResultSearchPage searchByServices(String request){
        $(searchField).sendKeys(request, Keys.ENTER);
        return new ResultSearchPage(driver);
    }

    //Верхнее меню синяя полоса под лого
    @FindBy(xpath = "//nav[@class='menu']//ul/li")
    private List<WebElement> upperMenuList;

    public MfcPage clickMfcButton(){
        $(upperMenuList.get(0)).click();
        return new MfcPage(driver);
    }

    public OrganizationsPage clickOrganizationsButton(){
        $(upperMenuList.get(1)).click();
        return new OrganizationsPage(driver);
    }

    public PaymentPage clickPaymentButton(){
        $(upperMenuList.get(3)).click();
        return new PaymentPage(driver);
    }

    public LegislationPage clickLegislationButton(){
        $(upperMenuList.get(4)).click();
        return new LegislationPage(driver);
    }

    public DocumentsBlanksPage clickDocumentsBlanksButton(){
        $(upperMenuList.get(5)).click();
        return new DocumentsBlanksPage(driver);
    }

    //Мобильное приложение
    private By nextCarouselSlideButton = By.xpath("//div[@id='banner-slider']//button[@type='button'][contains(text(),'Next')]");//Стрелка вправо для верхней карусели

    public MainPage clickNextCarouselSlideButton(){
        $(nextCarouselSlideButton).click();
        return this;
    }

    public boolean mobileAppButtonIsDisplayed(){
        return driver.findElement(mobileAppButton).isDisplayed();
    }

    public MainPage mobileAppCShouldBeDisplayed() {
        while (!mobileAppButtonIsDisplayed()) {
            this.clickNextCarouselSlideButton();
        }
        return this;
    }

    private By mobileAppButton = By.xpath("//a[@href='/mobile-app/']");
    private By appStoreButton = By.xpath("//div[@class='about-apps']//a[@href='https://itunes.apple.com/ru/app/gosuslugi-sankt-peterburga/id595073853']");
    private By googlePlayButton = By.xpath("//div[@class='about-apps']//a[@href='https://play.google.com/store/apps/details?id=com.fls.gosuslugispb']");

    public MobileAppPage clickMobileAppButton(){
        $(mobileAppButton).click();
        return new MobileAppPage(driver);
    }

    public MobileAppPage clickAppStoreButton(){
        $(appStoreButton).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        /*driver.close();
        driver.switchTo().window(tabs.get(0));*/

        return new MobileAppPage(driver);
    }

    public MobileAppPage clickGooglePlayButton(){
        $(googlePlayButton).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        /*driver.close();
        driver.switchTo().window(tabs.get(0));*/

        return new MobileAppPage(driver);
    }

    //Карусель услуг
    private By nextCarouselServiceButton = By.xpath("//div[@id='service-slider']/button[@class='slick-next slick-arrow']"); //стрелка "вправо" на нижнем слайдере услуг

    public MainPage clickNextCarouselServiceButton(){
        $(nextCarouselServiceButton).click();
        return this;
    }

    public boolean serviceFromCarouselIsDisplayed(int id){
        return driver.findElement(By.xpath("//a[@href='/" + id + "/']")).isDisplayed();
    }

    public MainPage serviceFromCarouselShouldBeDisplayed(int id) {
        while (!this.serviceFromCarouselIsDisplayed(id)) {
                this.clickNextCarouselServiceButton();
        }
        return this;
    }

    private By kindergartenServiceButton = By.xpath("//a[@href='/188351/']");
    private By firstGradeServiceButton = By.xpath("//a[@href='/188357/']");
    private By recordToDoctorServiceButton = By.xpath("//a[@href='/188453/']");
    private By parkingPermitServiceButton = By.xpath("//a[@href='/news/otkryt-priem-zayavleniy-na-vydachu-lgotnykh-parkov/']");
    private By medicalPolicyServiceButton = By.xpath("//a[@href='/188449/']");
    private By huntingTicketServiceButton = By.xpath("//a[@href='/188765/']");
    private By childPayoutServiceButton = By.xpath("//a[@href='/187899/']");
    private By innServiceButton = By.xpath("//a[@href='/188297/']");
    private By taxDebtServiceButton = By.xpath("//a[@href='/188299/']");
    private By internationalPassportServiceButton = By.xpath("//a[@href='/188421/']");
    private By motherCapitalServiceButton = By.xpath("//a[@href='/187961/']");
    private By dataChangeCarownerServiceButton = By.xpath("//a[@href='/448007/']");
    private By payGovernmentServiceButton = By.xpath("//a[@href='/464211/']");

    public KindergartenPage clickKindergartenServiceButton(){
        $(kindergartenServiceButton).click();
        return new KindergartenPage(driver);
    }

    public FirstGradePage clickFirstGradeServiceButton(){
        $(firstGradeServiceButton).click();
        return new FirstGradePage(driver);
    }

    public RecordToDoctorPage clickRecordToDoctorServiceButton(){
        $(recordToDoctorServiceButton).click();
        return new RecordToDoctorPage(driver);
    }

    public ParkingPermitPage clickParkingPermitServiceButton(){
        $(parkingPermitServiceButton).click();
        return new ParkingPermitPage(driver);
    }

    public MedicalPolicyPage clickMedicalPolicyServiceButton(){
        $(medicalPolicyServiceButton).click();
        return new MedicalPolicyPage(driver);
    }

    public HuntingTicketPage clickHuntingTicketServiceButton(){
        $(huntingTicketServiceButton).click();
        return new HuntingTicketPage(driver);
    }

    public ChildPayoutPage clickChildPayoutServiceButton(){
        $(childPayoutServiceButton).click();
        return new ChildPayoutPage(driver);
    }

    public InnPage clickInnServiceButton(){
        $(innServiceButton).click();
        return new InnPage(driver);
    }

    public TaxDebtPage clickTaxDebtServiceButton(){
        $(taxDebtServiceButton).click();
        return new TaxDebtPage(driver);
    }

    public InternationalPassportPage clickInternationalPassportServiceButton(){
        $(internationalPassportServiceButton).click();
        return new InternationalPassportPage(driver);
    }

    public MotherCapitalPage clickMotherCapitalServiceButton(){
        $(motherCapitalServiceButton).click();
        return new MotherCapitalPage(driver);
    }

    public DataChangeCarownerPage clickDataChangeCarownerServiceButton(){
        $(dataChangeCarownerServiceButton).click();
        return new DataChangeCarownerPage(driver);
    }

    public PayGovernmentPage clickPayGovernmentServiceButton(){
        this.assertThat(ExpectedConditions.elementToBeClickable(payGovernmentServiceButton));
        $(payGovernmentServiceButton).click();
        return new PayGovernmentPage(driver);
    }

    //Каталог услуг
    @FindBy(xpath = "//div[@class='grid-cat']//h3")
    private List<WebElement> servicesCatalogList;

    public boolean servicesCatalogListSize(int size){
        boolean equality = false;
        if(servicesCatalogList.size() == size) {
            equality = true;
        }
        return equality;
    }

    //Новости
    private By newsHeading = By.xpath("//h2/a[text()='Новости']");

    public boolean newsHeadingIsDisplayed(){ return $(newsHeading).isDisplayed(); }

    //СМИ о нас
    private By massMediaHeading = By.xpath("//h2/a[text()='Новости']");

    public boolean massMediaHeadingIsDisplayed(){ return $(massMediaHeading).isDisplayed(); }

    //Полезная информация
    private By usefulInformationHeading = By.xpath("//h2/a[text()='Новости']");

    public boolean usefulInformationHeadingIsDisplayed(){ return $(usefulInformationHeading).isDisplayed(); }

    //Футер
    private By usefullinksButton = By.xpath("//label[@for='usefullinks']");

    @FindBy(xpath = "//nav[@class='nav-footer']//li")
    private List<WebElement> navFooterList;

    @FindBy(xpath = "//div[@class='block-footer']/div")
    private List<WebElement> blockFooterList;

    public boolean booleanusefullinksButtonIsDisplayed(){ return $(usefullinksButton).isDisplayed(); }

    public boolean navFooterListSize(int size){ //5
        boolean equality = false;
        if(navFooterList.size() == size) {
            equality = true;
        }
        return equality;
    }

    public boolean blockFooterListSize(int size){ //5
        boolean equality = false;
        if(blockFooterList.size() == size) {
            equality = true;
        }
        return equality;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
