package Pages.MfcPages;

import BasePackage.BasePage;
import Pages.OrganizationsPages.OrganizationsPage;
import Pages.ServicesPages.InternationalPassportPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

//Страница одного офиса МФЦ (не мобильный)
public class SectorMfcPage extends BasePage {

    private WebDriver driver;

    public SectorMfcPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//h1[@class='service_name']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Верхнее меню (tab-menu)
    @FindBy(xpath = "//ul[@class='tab-menu']/li")
    private List<WebElement> tabMenuList;

    public SectorMfcPage clickTabMenuList(int index){
        $(tabMenuList.get(index)).click();
        return new SectorMfcPage(driver);
    }

    //Боковое меню
    @FindBy(xpath = "//nav[@id='navbar-example']/ul/li")
    private List<WebElement> menuList;

    public boolean menuListSize(int size){
        boolean equality = false;
        if(menuList.size() == size) {
            equality = true;
        }
        return equality;
    }

    //Фото МФЦ
    private By photoMfc = By.xpath("//div[@class='foto-mfc']/img");

    public boolean photoMfcIsDisplayed(){ return $(photoMfc).isDisplayed(); }

    //Блок контакной информации
    private By infoMfc = By.xpath("//div[@class='info-mfc']");

    public String getInfoMfcText(){ return $(infoMfc).getText(); }

    //Вкладка "Услуги"
    @FindBy(xpath = "//div[@class='abc-list-letter']/ul/li")
    private List<WebElement> alphabetFilterList;

    private By searchField = By.xpath("//input[@id='items-search-input']");

    @FindBy(xpath = "//ul[@id='js-items-list']/li")
    private List<WebElement> servicesList;

    private By internationalPassportServiceButton = By.xpath("//a[@href='/188421/']");

    private By curTotal = By.xpath("//span[@id='curTotal']");

    public SectorMfcPage typeSearchField(String searchText){
        $(searchField).sendKeys(searchText, Keys.ENTER);
        return new SectorMfcPage(driver);
    }

    public int getCurtotalInt(){
        return Integer.parseInt($(curTotal).getText());
    }

    public InternationalPassportPage clickInternationalPassportServiceButton(String searchName){
        assertThat(ExpectedConditions.textToBePresentInElement(driver.findElement(internationalPassportServiceButton), searchName));
        $(internationalPassportServiceButton).click();
        return new InternationalPassportPage(driver);
    }

    public InternationalPassportPage clickServicesList(int index){
        $(servicesList.get(index)).click();
        return new InternationalPassportPage(driver);
    }

    public InternationalPassportPage clickServicesList(int index, String searchName){
        assertThat(textToBePresentInElement(servicesList.get(index), searchName));
        $(servicesList.get(index)).click();
        return new InternationalPassportPage(driver);
    }

    public boolean alphabetFilterListSize(int size){
        boolean equality = false;
        if(alphabetFilterList.size() == size) {
            equality = true;
        }
        return equality;
    }

    public OrganizationsPage clickAlphabetFilterList(int index){
        $(alphabetFilterList.get(index)).click();
        this.invisibilityElementsWait(preloader);
        return new OrganizationsPage(driver);
    }

    public boolean servicesReviewAlphabetFilterCycle(){
        boolean equality = true;
        for (int i = 2; i < alphabetFilterList.size(); i++){
            clickAlphabetFilterList(i);

            int orgsSize = servicesList.size();

            while (isElementPresent(paginationNextButton)){
                clickPaginationNextButton();
                orgsSize = orgsSize + servicesList.size();
            }

            if (orgsSize != getCurtotalInt()) equality = false;
        }
        return equality;
    }

    //Пагинация
    private By paginationNextButton = By.xpath("//a[@title='Следующая страница']");

    public OrganizationsPage clickPaginationNextButton(){
        $(paginationNextButton).click();
        this.invisibilityElementsWait(preloader);
        return new OrganizationsPage(driver);
    }

    //Прелоадеры
    private By preloader = By.xpath("//div[@id='wait_comp_85f6cbe568b048b83589c595e0034af4']");

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
