package Pages.ServicesPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ParkingPermitPage extends BasePage { //О приеме заявлений на выдачу льготных парковочных разрешений https://gu.spb.ru/news/otkryt-priem-zayavleniy-na-vydachu-lgotnykh-parkov/
    private WebDriver driver;

    public ParkingPermitPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//h1[@class='service_name']");

    public String getServiceHeadingText() { return $(serviceHeading).getText(); }

    //Категории граждан
    @FindBy(xpath = "//div[@id='sv-content']//ul/li")
    private List<WebElement> categoryList;

    public String getCategoryListText(int index){ return $(categoryList.get(index)).getText(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
