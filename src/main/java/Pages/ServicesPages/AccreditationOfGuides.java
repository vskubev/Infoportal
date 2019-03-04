package Pages.ServicesPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


//Аккредитация экскурсоводов и гидов-переводчиков https://gu.spb.ru/188729/eservice/
public class AccreditationOfGuides extends BasePage {

    private WebDriver driver;

    public AccreditationOfGuides(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By serviceHeading = By.xpath("//span[@id='pagetitle']");

    public String getServiceHeadingText(){ return $(serviceHeading).getText(); }

    //Меню выбора вида предоставления услуги
    private By activeMethodButton = By.xpath("//ul[@class='tab-menu tab-icons']/li[@class='active']");

    public String getActiveMethodButtonText(){ return $(activeMethodButton).getText(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
