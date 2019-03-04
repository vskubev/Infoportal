package Pages.DocumentsBlanksPages;

import BasePackage.BasePage;
import Pages.LegislationPages.LawPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.print.Doc;
import java.util.List;

//Бланки документов https://gu.spb.ru/docs/
public class DocumentsBlanksPage extends BasePage {

    private WebDriver driver;

    public DocumentsBlanksPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//span[@id='pagetitle']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Фильтрация

    private By searchField = By.xpath("//input[@id='items-search-input']");

    public boolean searchFieldIsDisplayed(){ return $(searchField).isDisplayed(); }

    public DocumentsBlanksPage typeSearchField(String searchText){
        $(searchField).sendKeys(searchText);
        return this;
    }

    @FindBy(xpath = "//div[@class='abc-list-letter']/ul/li")
    private List<WebElement> alphabetFilterList;

    public boolean alphabetFilterListSize(int size){
        boolean equality = false;
        if(alphabetFilterList.size() == size) {
            equality = true;
        }
        return equality;
    }

    public DocumentsBlanksPage clickAlphabetFilterList(int index){
        $(alphabetFilterList.get(index)).click();
        return new DocumentsBlanksPage(driver);
    }

    //Боковое меню
    @FindBy(xpath = "//nav[@class='menu-side']/ul/li/a")
    private List<WebElement> menuSideList;

    private By certificatesAndCertificatesButton = By.xpath("//ul/li/a[text()='Свидетельства, сертификаты, удостоверения']");

    public DocumentsBlanksPage clickMenuSideList(){
        $(certificatesAndCertificatesButton).click();
        return new DocumentsBlanksPage(driver);
    }

    public boolean menuSideListSize(int size){
        boolean equality = false;
        if(menuSideList.size() == size) {
            equality = true;
        }
        return equality;
    }

    //Список документов и бланков
    @FindBy(xpath = "//div[@id='js-item-list-wrapper']/ul/li")
    private List<WebElement> documentsList;

    private By cancellationHuntingTicketDoc = By.xpath("//a[@href='/docs/81284/']");

    public DocumentsPage clickCancellationHuntingTicketDoc(){
        $(cancellationHuntingTicketDoc).click();
        return new DocumentsPage(driver);
    }

    public boolean documentsListSize(int size){
        boolean equality = false;
        if(documentsList.size() == size) {
            equality = true;
        }
        return equality;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
