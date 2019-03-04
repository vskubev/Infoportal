package Pages.MfcPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LifeServicesPage extends BasePage { //Страницы всех услуг по жизненным ситуациям (из меню МФЦ)

    private WebDriver driver;

    public LifeServicesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Страницы
    private By lifeServiceHeading = By.xpath("//div[@class='col-lg-12']//h2");

    private By recordToMfcButton = By.xpath("//a[@type='button'][text()=' Запись в МФЦ']");

    @FindBy(xpath = "//nav[@class='menu-side icon-menu']/ul/li")
    private List<WebElement> lifeServicesList;

    public String getLifeServiceHeadingText(){ return $(lifeServiceHeading).getText(); }

    public LifeServicesPage clickRecordToMfcButton(){
        $(recordToMfcButton).click();
        return this;
    }

    public boolean isElementPresent(){
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(recordToMfcButton);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } finally{
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public boolean lifeServicesListSize(int size){
        boolean equality = false;
        if(lifeServicesList.size() == size) {
            equality = true;
        }
        return equality;
    }

    //Модальное окно "Запись на прием в МФЦ"
    private By modalHeading = By.xpath("//h4[@id='modal-mfc-req-label']");

    private By moreButton = By.xpath("//a[@class='btn']");

    public String getModalHeadingText(){
        $(modalHeading);
        return $(modalHeading).getText();
    }

    public RecordPage clickMoreButton(){
        $(moreButton).click();
        return new RecordPage(driver);
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
