package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//Все страницы категорий услуг из фильтра страницы полного списка услуг
public class ServicesCategoryPages extends BasePage {

    private WebDriver driver;

    public ServicesCategoryPages(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    @FindBy(xpath = "//span[@id='pagetitle']")
    private WebElement civilStatusActHeading;

    public String getCivilStatusActHeadingText(){ return $(civilStatusActHeading).getText(); }

    //Услуги
    @FindBy(xpath = "//ul[@id='js-items-list']/li/div/a")
    private List<WebElement> civilStatisActServicesCollection;

    public String getCivilStatusActServiceText(int i){
        return $(civilStatisActServicesCollection.get(i)).getText();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}

