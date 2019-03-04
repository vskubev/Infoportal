package Pages;

import java.io.File;

import BasePackage.BasePage;
import Pages.PaymentPages.PaymentInteractivePage;
import Pages.ServicesPages.ResidentParkingPermitInteractivePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasePage {
    private WebDriver driver;

    public AuthPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //страница "Войти"
    private By signInHeading = By.xpath("//h1[text()='Войти на Портал']");
    private By authorizeButton = By.xpath("//div/a[@href='https://eservice.gu.spb.ru/portalFront/oauth/authorize']");

    public boolean signInHeadingIsDisplayed() { return $(signInHeading).isDisplayed(); }

    public boolean authorizeButtonIsDisplayed(){
        return $(authorizeButton).isDisplayed();
    }

    public AuthPage clickAuthorizeButton(){
        $(authorizeButton).click();
        return this;
    }
    //страница ЕСИА с вводом лог/пас
    private By loginField = By.xpath("//input[@id='mobileOrEmail']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By signInButton = By.xpath("//div[@class='line-btns']/button[@data-bind='click: loginByPwd']");

    public AuthPage typeLogin(String login){
        $(loginField).click();
        $(loginField).clear();
        $(loginField).sendKeys(login);
        return this;
    }

    public AuthPage typePassword(String password){
        $(passwordField).click();
        $(passwordField).clear();
        $(passwordField).sendKeys(password);
        return this;
    }

    public AuthPage authorization(String login, String password){
        this.invisibilityElementsWait(globalPreloader, preloader);
        clickAuthorizeButton();
        typeLogin(login);
        typePassword(password);
        return this;
    }

    public ResidentParkingPermitInteractivePage clickSignInButtonFromService(){
        $(signInButton).click();
        this.invisibilityElementsWait(globalPreloader, preloader);
        return new ResidentParkingPermitInteractivePage(driver);
    }

    public PrivateOfficePage clickSignInButtonFromMainPage(){
        $(signInButton).click();
        this.invisibilityElementsWait(globalPreloader, preloader);
        return new PrivateOfficePage(driver);
    }

    public PaymentInteractivePage clickSignInButtonFromPaymentPage(){
        $(signInButton).click();
        this.invisibilityElementsWait(globalPreloader, preloader);
        return new PaymentInteractivePage(driver);
    }

    //Прелоадеры
    private By globalPreloader = By.xpath("//div[@id='global-preloader-div']");
    private By preloader = By.xpath("//div[@id='preloader-div']");

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
