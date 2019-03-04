package Pages.OrganizationsPages;

import BasePackage.BasePage;
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

public class OrganizationsPage extends BasePage { //Организации https://gu.spb.ru/orgs/classifier/

    private WebDriver driver;

    public OrganizationsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//span[@id='pagetitle']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Фильтрация
    private By hierarchyButton = By.xpath("//a[contains(text(),'По иерархии')]");
    private By sphereActivityButton = By.xpath("//a[contains(text(),'По сферам деятельности')]");
    private By activeFilter = By.xpath("//ul[@class='tab-menu']/li[@class='active']");

    public boolean hierarchyButtonIsDisplayed(){ return $(hierarchyButton).isDisplayed(); }

    public OrganizationsPage clickHierarchyButton(){
        $(hierarchyButton).click();
        return this;
    }

    public boolean sphereActivityButtonIsDisplayed(){ return $(sphereActivityButton).isDisplayed(); }

    public OrganizationsPage clickSphereActivityButton(){
        $(sphereActivityButton).click();
        return this;
    }

    public String getActiveFilterText(){ return $(activeFilter).getText(); }

    @FindBy(xpath = "//div[@class='abc-list-letter']/ul/li")
    private List<WebElement> alphabetFilterList;

    public boolean alphabetFilterListSize(int size){
        boolean equality = false;
        if(alphabetFilterList.size() == size) {
            equality = true;
        }
        return equality;
    }

    public OrganizationsPage clickAlphabetFilterList(int index){
        $(alphabetFilterList.get(index)).click();
        return new OrganizationsPage(driver);
    }

    public boolean organizationsReviewAlphabetFilterCycle(){
        boolean equality = true;
        for (int i = 1; i < alphabetFilterList.size(); i++){
            clickAlphabetFilterList(i);
            int orgsSize = organizationsList.size();

            while (isElementPresent(paginationNextButton)){
                clickPaginationNextButton();
                orgsSize = orgsSize + organizationsList.size();
            }

            if (orgsSize != getCurtotalInt()) equality = false;
        }
        return equality;
    }

    private By searchField = By.xpath("//input[@id='items-search-input']");

    public boolean searchFieldIsDisplayed(){ return $(searchField).isDisplayed(); }

    public OrganizationsPage typeSearchField(String searchText){
        $(searchField).sendKeys(searchText);
        return this;
    }

    //Боковое меню
    @FindBy(xpath = "//nav[@class='menu-side']/ul/li/a")
    private List<WebElement> menuSideList;

    private By curTotal = By.xpath("//span[@id='curTotal']");

    public int getCurtotalInt(){
        return Integer.parseInt($(curTotal).getText());
    }

    public OrganizationsPage clickMenuSideList(int index){
        $(menuSideList.get(index)).click();
        return new OrganizationsPage(driver);
    }

    public boolean menuSideListSize(int size){
        boolean equality = false;
        if(menuSideList.size() == size) {
            equality = true;
        }
        return equality;
    }

        //Метод открывает поочереди каждую сферу деятельности и сравнивает количество организаций на странице и в массиве sphereServicesMassive
    public boolean organizationsReviewCycle(){
        boolean equality = true;
        for (int i = 0; i < menuSideList.size(); i++){
            clickMenuSideList(i);
            int orgsSize = organizationsList.size();

            while (isElementPresent(paginationNextButton)){
                clickPaginationNextButton();
                orgsSize = orgsSize + organizationsList.size();
            }

            if (orgsSize != getCurtotalInt()) equality = false;
        }
        return equality;
    }

    //Список организаций
    private By archiveCommitteeButton = By.xpath("//a[contains(text(),'Архивный комитет Санкт-Петербурга')]");
    private By federalAntimonopolyButton = By.xpath("//a[@href='/orgs/66801/?from=c']");

    @FindBy(xpath = "//ul[@id='orgs-list']/li")
    private List<WebElement> organizationsList;

    public ArchiveCommittee clickArchiveCommitteeButton(){
        $(archiveCommitteeButton).click();
        return new ArchiveCommittee(driver);
    }

    public boolean federalAntimonopolyButtonIsDisplayed(){
        $(federalAntimonopolyButton);
        return $(federalAntimonopolyButton).isDisplayed();
    }

    //Пагинация
    private By paginationNextButton = By.xpath("//a[@title='Следующая страница']");

    public OrganizationsPage clickPaginationNextButton(){
        $(paginationNextButton).click();
        return new OrganizationsPage(driver);
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
