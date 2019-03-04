package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PrivateOfficePage extends BasePage {//Личный кабинет интерактивный портал
    private WebDriver driver;

    public PrivateOfficePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private By accountName = By.xpath("//a[@id='userOffice']");
    private By logoutButton = By.xpath("//a[@id='logout']");

    private By privateOfficeHeading = By.xpath("//div[@class='col-lg-9 col-md-8']//h1");

    public String getAccountNameText(){ return $(accountName).getText(); }

    public boolean logoutButtonIsDisplayed(){ return $(logoutButton).isDisplayed(); }

    public String getPrivateOfficeHeadingText(){ return $(privateOfficeHeading).getText(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
