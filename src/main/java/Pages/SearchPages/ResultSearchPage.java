package Pages.SearchPages;

import BasePackage.BasePage;
import Pages.MfcPages.MfcPage;
import Pages.ServicesPages.ResidentParkingPermitServicePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

//Страница результатов поиска с главной страницы
public class ResultSearchPage extends BasePage {

    private WebDriver driver;

    public ResultSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок страницы
    private By pageHeading = By.xpath("//span[@id='pagetitle']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Выбор элементов поиска
    @FindBy(xpath = "//div[@class='select-search']/label")
    private List<WebElement> selectSearchList;

    public ResultSearchPage clickSelectSearchList(int index){
        $(selectSearchList.get(index)).click();
        return new ResultSearchPage(driver);
    }

    //Строка поиска
    private By searchField = By.xpath("//input[@id='search-query']");

    public String getSearchFieldText(){ return $(searchField).getText(); }

    //Способ получения услуги
    @FindBy(xpath = "//section[@class='service-filter']//label")
    private List<WebElement> serviceFilterList;

    public ResultSearchPage clickServiceFilterList(int index){
        $(serviceFilterList.get(index)).click();
        this.invisibilityElementsWait(preloader);
        return new ResultSearchPage(driver);
    }

    //Облако тегов
    @FindBy(xpath = "//div[@class='search-tags-cloud']/a")
    private List<WebElement> tagsCloudList;

    @FindBy(xpath = "//div[@class='search-tags-chain']/a")
    private List<WebElement> searchTagsList;

    public ResultSearchPage clickTagsCloudList(int index){
        $(tagsCloudList.get(index)).click();
        this.invisibilityElementsWait(preloader);
        return new ResultSearchPage(driver);
    }

    public String getSearchTagsListText(int index){ return $(searchTagsList.get(index)).getText(); }

    //Список найденных результатов
    @FindBy(xpath = "//div[@class='search-list']//li")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//div[@class='search-list']//div[@class='search-header']/a")
    private List<WebElement> searchResultButtonList;

    public String getSearchResultListText(int index){
        return $(searchResultList.get(index)).getText();
    }

    public boolean searchResultsContainsRequestStringCycle(String request){
        boolean quality = true;
        for (int i = 0; i < searchResultList.size(); i++){
            if(!getSearchResultListText(i).contains(request)) quality = false;
        }
        return quality;
    }

    public boolean searchResultListSize(int size){
        boolean equality = false;
        if(searchResultList.size() == size) {
            equality = true;
        }
        return equality;
    }

    public ResidentParkingPermitServicePage clickSearchResultList(int index){
        $(searchResultButtonList.get(index)).click();
        return new ResidentParkingPermitServicePage(driver);
    }

    public MfcPage clickSearchMfcResultList(int index){
        $(searchResultButtonList.get(index)).click();
        return new MfcPage(driver);
    }

    //Прелоадеры
    private By preloader = By.xpath("//div[@id='wait_comp_bf09df2e5a818495e34c85fe739d711a']");

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
