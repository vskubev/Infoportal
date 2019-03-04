package Pages.MfcPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RecordPage extends BasePage { //Предварительная запись на прием МФЦ https://gu.spb.ru/mfc/record/

    private WebDriver driver;

    public RecordPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private By recordPageHeading = By.xpath("//div[@class='col-lg-12']//h2");

    public String getRecordPageHeadingText(){
        $(recordPageHeading);
        return $(recordPageHeading).getText();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
