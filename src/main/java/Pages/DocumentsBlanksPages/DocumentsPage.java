package Pages.DocumentsBlanksPages;

import BasePackage.BasePage;
import Pages.LegislationPages.LawPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//Страница документа из списка бланков и документов
public class DocumentsPage extends BasePage {

    private WebDriver driver;

    public DocumentsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//span[@id='pagetitle']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Документ
    private By documentSaveButton = By.xpath("//a[@href='/upload/iblock/f5e/akt-annulirovaniya-ohotnichego-bileta.doc']");

    public DocumentsPage clickDocumentSaveButton(){
        $(documentSaveButton).click();
        return this;
    }

    public boolean documentSaveButtonIsDisplayed(){ return $(documentSaveButton).isDisplayed(); }

    //Законодательный акт
    private By legislativeActButton  = By.xpath("//a[@href='/laws/26390/']");

    public DocumentsPage clickLegislativeActButton(){
        $(legislativeActButton).click();

        for (String tab : driver.getWindowHandles()){ // переключение на последнюю открытую вкладку
            driver.switchTo().window(tab);
        }

        return new DocumentsPage(driver);
    }

    //Страница законодательного акта
    //Заголовок
    private By pageLawHeading = By.xpath("//span[@id='pagetitle']");

    public String getPageLawHeadingText(){ return $(pageLawHeading).getText(); }

    //Регламентные услуги
    @FindBy(xpath = "//div[@class='services-list']/ul/li/div/a")
    private List<WebElement> servicesList;

    public String getServiceListText(int index){ return $(servicesList.get(index)).getText(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
