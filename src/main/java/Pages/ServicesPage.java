package Pages;

import BasePackage.BasePage;
import Pages.ServicesPages.ResidentParkingPermitServicePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

//Полной список услуг https://gu.spb.ru/services/
public class ServicesPage extends BasePage {

    private WebDriver driver;

    public ServicesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By servicesHeading = By.xpath("//span[@id='pagetitle']");

    public String getServicesHeadingText(){
        return $(servicesHeading).getText();
    }

    //Фильтр по услугам
    @FindBy(xpath = "//form[@class='smartfilter']//label")
    private List<WebElement> smartFilterList;

    @FindBy(xpath = "//span[text()='Льготные категории']")
    private WebElement preferentialCategoriesFilterHeading;

    private By filterHeading = By.xpath("//h5[text()='Фильтр по услугам']");
    private By clearButton = By.xpath("//input[@id='del_filter']");

    public boolean filterHeadingTextIsDisplayed(){
        return $(filterHeading).isDisplayed();
    }

    public ServicesPage clickSmartFilterList(int index, int index2){
        if(!smartFilterList.get(index).isDisplayed()) $(preferentialCategoriesFilterHeading).click();
        smartFilterList.get(index).click();

        if(!smartFilterList.get(index2).isDisplayed()) $(preferentialCategoriesFilterHeading).click();
        smartFilterList.get(index2).click();

        this.clickFilterAlphabetIfArrow();

        return new ServicesPage(driver);
    }

    public ServicesPage clickSmartFilterList(int index, int index2, int index3){
        if (isElementPresent(arrowAlphabetButton)) this.clickFilterAlphabet();

        if(!smartFilterList.get(index).isDisplayed()) $(preferentialCategoriesFilterHeading).click();
        smartFilterList.get(index).click();

        if(!smartFilterList.get(index2).isDisplayed()) $(preferentialCategoriesFilterHeading).click();
        smartFilterList.get(index2).click();

        if(!smartFilterList.get(index3).isDisplayed()) $(preferentialCategoriesFilterHeading).click();
        smartFilterList.get(index3).click();

        this.clickFilterAlphabetIfArrow();

        return new ServicesPage(driver);
    }

    public ServicesPage clickClearButton(){
        $(clearButton).click();
        return this;
    }

    //категории под фильтром
    @FindBy(xpath = "//ul[@class='tag']/li")
    private List<WebElement> categoryList;

    public ServicesCategoryPages clickCategory(int index){
        $(categoryList.get(index)).click();
        return new ServicesCategoryPages(driver);
    }

    //Строка поиска и фильтрация
    private By searchField = By.xpath("//input[@id='items-search-input']");
    private By filterAlphabetButton = By.xpath("//a[text()='алфавиту ']");
    private By arrowAlphabetButton = By.xpath("//i[@class='js-arrow fa fa-caret-up']");
    private By filterPopularityButton = By.xpath("//a[text()='популярности ']");
    private By arrowDownPopularityButton = By.xpath("//i[@class='js-arrow fa fa-caret-down']");
    private By arrowUpPopularityButton = By.xpath("//i[@class='js-arrow fa fa-caret-up']");

    public boolean searchFieldIsDisplayed(){ return $(searchField).isDisplayed();}

    public ServicesPage typeSearchField(String searchQuery){
        $(searchField).sendKeys(searchQuery);
        return this;
    }

    public ServicesPage clickFilterAlphabet(){
        $(filterAlphabetButton).click();
        return this;
    }

    public ServicesPage clickFilterAlphabetIfArrow(){
        if(isElementPresent(arrowAlphabetButton)) $(filterAlphabetButton).click();
        return new ServicesPage(driver);
    }

    public boolean isArrowDownPopularityButtonPresent(){
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(arrowDownPopularityButton);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } finally{
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public boolean isArrowUpPopularityButtonPresent(){
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(arrowUpPopularityButton);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } finally{
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public ServicesPage clickFilterPopularityButton(){
        $(filterPopularityButton).click();
        return this;
    }

    //Получить название услуги
    public String getServiceText(int id) {
        $(By.xpath("//a[@href='/" + id + "/']"));
        return $(By.xpath("//a[@href='/" + id + "/']")).getText();
    }
    public ResidentParkingPermitServicePage clickServiceButton(int id){
        $(By.xpath("//a[@href='/" + id + "/']")).click();
        return new ResidentParkingPermitServicePage(driver);
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
