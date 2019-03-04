package Pages.MfcPages;

import BasePackage.BasePage;
import Pages.ServicesPage;
import Pages.ServicesPages.AccreditationOfGuides;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

//Все услуги МФЦ https://gu.spb.ru/mfc/services/
public class MfcAllServicesPage extends BasePage {

    private WebDriver driver;

    public MfcAllServicesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок страницы
    private By pageHeading = By.xpath("//div[@class='col-lg-12']/h2");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Фильтр по услугам
    @FindBy(xpath = "//div[@class='abc-list-letter']/ul/li/a")
    private List<WebElement> alphabetFilterList;

    private By searchField = By.xpath("//input[@id='items-search-input']");

    public boolean alphabetFilterListSize(int size){ //21
        boolean equality = false;
        if(alphabetFilterList.size() == size) {
            equality = true;
        }
        return equality;
    }

    public boolean searchFieldIsDisplayed(){ return $(searchField).isDisplayed(); }

    //Смарт фильтр
    @FindBy(xpath = "//span[@class='bx-filter-input-checkbox']")
    private List<WebElement> smartFilterList;

    @FindBy(xpath = "//span[text()='Льготные категории']")
    private WebElement preferentialCategoriesFilterHeading;

    @FindBy(xpath = "//span[text()='Наличие записи на прием']")
    private WebElement recordAvailabilityFilterHeading;

    private By clearButton = By.xpath("//input[@id='del_filter']");

    public MfcAllServicesPage clickClearButton(){
        $(clearButton).click();
        return this;
    }

    public MfcAllServicesPage clickSmartFilterList(int index, int index2){
        if(!smartFilterList.get(index).isDisplayed()) {
            $(preferentialCategoriesFilterHeading).click();
            $(recordAvailabilityFilterHeading).click();
        }
        smartFilterList.get(index).click();

        if(!smartFilterList.get(index2).isDisplayed()) {
            $(preferentialCategoriesFilterHeading).click();
            $(recordAvailabilityFilterHeading).click();
        }
        smartFilterList.get(index2).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new MfcAllServicesPage(driver);
    }

    public MfcAllServicesPage clickSmartFilterList(int index, int index2, int index3){
        if(!smartFilterList.get(index).isDisplayed()) {
            $(preferentialCategoriesFilterHeading).click();
            $(recordAvailabilityFilterHeading).click();
        }
        smartFilterList.get(index).click();

        if(!smartFilterList.get(index2).isDisplayed()) {
            $(preferentialCategoriesFilterHeading).click();
            $(recordAvailabilityFilterHeading).click();
        }
        smartFilterList.get(index2).click();

        if(!smartFilterList.get(index3).isDisplayed()) {
            $(preferentialCategoriesFilterHeading).click();
            $(recordAvailabilityFilterHeading).click();
        }
        smartFilterList.get(index3).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new MfcAllServicesPage(driver);
    }

    //Список услуг МФЦ
    @FindBy(xpath = "//ul[@id='js-items-list']/li")
    private List<WebElement> servicesList;

    @FindBy(xpath = "//ul[@id='js-items-list']/li//span/a")
    private List<WebElement> methodsofServicesList;

    public boolean servicesListSize(int size){
        boolean equality = false;
        if(servicesList.size() == size) {
            equality = true;
        }
        return equality;
    }

    public AccreditationOfGuides clickMethodOfServicesList(int index){
        $(methodsofServicesList.get(index)).click();
        return new AccreditationOfGuides(driver);
    }

    //Запись в МФЦ
    private By recordToMfcButton = By.xpath("//a[@href='/mfc/record/']");

    public MfcAllServicesPage clickRecordToMfcButton(){
        $(recordToMfcButton).click();
        return new MfcAllServicesPage(driver);
    }

    //Страница предварительной записи на прием в МФЦ
    private By pageRecordHeading = By.xpath("//div[@class='col-lg-12']//h2");
    private By pageInformation = By.xpath("//div/article");

    public String getPageRecordHeadingText(){ return $(pageRecordHeading).getText(); }
    public String getPageInformationText(){ return $(pageInformation).getText(); }

    //Прелоадеры
    private By preloader = By.xpath("//div[@id='wait_comp_4c396e076fafa34694ee823d9a3d1e85']");

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
