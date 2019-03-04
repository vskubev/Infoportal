package Pages.MfcPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AboutMfcPage extends BasePage { //О МФЦ https://gu.spb.ru/mfc/about/

    private WebDriver driver;

    public AboutMfcPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок страницы
    private By pageHeading = By.xpath("//div[@class='col-lg-12']/h2");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Боковое меню
    @FindBy(xpath = "//nav[@class='menu-side']/ul/li")
    private List<WebElement> menuList;

    public boolean menuListSize(int size){
        boolean equality = false;
        if(menuList.size() == size) {
            equality = true;
        }
        return equality;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
