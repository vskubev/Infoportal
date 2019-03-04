package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MobileAppPage extends BasePage { //Мобильное приложение «Госуслуги Санкт‑Петербурга» https://gu.spb.ru/mobile-app/ и страницы приложения в маркетах (AppStore & Google Play)

    private WebDriver driver;

    public MobileAppPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Страница мобильных приложений на портале
    private By mobileAppHeading = By.xpath("//span[@id='pagetitle']");

    public String getMobileAppHeadingText(){ return $(mobileAppHeading).getText(); }

    //AppStore
    private By appStoreHeading = By.xpath("//h1[@class='product-header__title app-header__title']");

    public String getAppStoreHeadingText(){
        return $(appStoreHeading).getText();
    }

    //Google Play
    private By googlePlayHeading = By.xpath("//h1[@class='AHFaub']");

    public String getGooglePlayHeadingText(){
        return $(googlePlayHeading).getText();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}