package Pages.LegislationPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//Страница регламентируемой услуги, входящей в документ на странице https://gu.spb.ru/laws/admin-gos/
public class RegulatedService extends BasePage {

    private WebDriver driver;

    public RegulatedService(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//span[@id='pagetitle']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Меню выбора вида предоставления услуги
    private By mfcMethodButton = By.xpath("//a[@href='/187971/mfcservice/']");
    private By traditionalMethodButton = By.xpath("//a[@href='/187971/traditional/']");

    public String getMfcMethodButtonText(){ return $(mfcMethodButton).getText(); }
    public String getTraditionalMethodButtonText(){ return $(traditionalMethodButton).getText(); }

    //Кнопка "Карта МФЦ
    private By mfcMapButton = By.xpath("//a[@href='/mfc/#mfc-map']");

    public boolean mfcMapButtonIsDisplayed(){ return $(mfcMapButton).isDisplayed(); }

    //Блок быстрого перехода по информации
    @FindBy(xpath = "//ul[@class='nav']/li")
    private List<WebElement> navbarCollection;

    public boolean navbarCollectionSize(int size){ //11
        boolean equality = false;
        if(navbarCollection.size() == size) {
            equality = true;
        }
        return equality;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
