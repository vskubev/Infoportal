package Pages.LegislationPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Страница справочника из законодательства
public class LawPage extends BasePage {

    private WebDriver driver;

    public LawPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//span[@id='pagetitle']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Документ
    private By documentSaveButton = By.xpath("//a[@href='/upload/iblock/0ae/ar-mo-kupchino-vydacha-razresheniya-na-vstuplenie-v-brak.doc']");

    public LawPage clickDocumentSaveButton(){
        $(documentSaveButton).click();
        return this;
    }

    public boolean documentSaveButtonIsDisplayed(){ return $(documentSaveButton).isDisplayed(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
