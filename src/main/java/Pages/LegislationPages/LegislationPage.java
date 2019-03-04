package Pages.LegislationPages;


import BasePackage.BasePage;
import Pages.OrganizationsPages.OrganizationsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

//Справочник законодательства https://gu.spb.ru/laws/
public class LegislationPage extends BasePage {

    private WebDriver driver;

    public LegislationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//span[@id='pagetitle']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Фильтрация
    private By searchField = By.xpath("//input[@id='items-search-input']");

    public boolean searchFieldIsDisplayed(){ return $(searchField).isDisplayed(); }

    public LegislationPage typeSearchField(String searchText){
        $(searchField).sendKeys(searchText);
        return this;
    }

    //Боковое меню
    @FindBy(xpath = "//nav[@class='menu-side']/ul/li/a")
    private List<WebElement> menuSideList;

    public LegislationPage clickMenuSideList(int index){
        $(menuSideList.get(index)).click();
        return new LegislationPage(driver);
    }

    //Список документов и регламентов
    @FindBy(xpath = "//div[@id='js-item-list-wrapper']/ul/li")
    private List<WebElement> lawsList;

    private By numberOfServices = By.xpath("//span[@id='curTotal']");

    public LawPage clickLawList(int index){
        $(lawsList.get(index)).click();
        return new LawPage(driver);
    }

    public int lawsReviewCycle(){
        int lawsSize = lawsList.size();

        while (isElementPresent(paginationNextButton)){
            clickPaginationNextButton();
            lawsSize = lawsSize + lawsList.size();
        }

        return lawsSize;
    }

    public int getNumberOfServices(){
        $(numberOfServices);
        return Integer.parseInt($(numberOfServices).getText()) + 1;
    }

    //Пагинация
    private By paginationNextButton = By.xpath("//a[@title='Следующая страница']");

/*    private boolean isElementPresent(By locator){
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } finally{
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }*/

    public OrganizationsPage clickPaginationNextButton(){
        $(paginationNextButton).click();
        return new OrganizationsPage(driver);
    }

    //Страница фильтра "Административные регламенты государственных услуг"
    private By filterPageHeading = By.xpath("//h2");
    private By regulatedService = By.xpath("//a[@href='/187971/']");

    public String getFilterPageHeadingText(){
        $(filterPageHeading);
        return $(filterPageHeading).getText(); }

    public RegulatedService clickRegulatedService(){
        $(regulatedService).click();
        return new RegulatedService(driver);
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
