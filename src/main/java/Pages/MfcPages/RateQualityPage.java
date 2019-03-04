package Pages.MfcPages;

import BasePackage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RateQualityPage extends BasePage { //Оценить качество услуг МФЦ https://gu.spb.ru/mfc/evaluation/

    private WebDriver driver;

    public RateQualityPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
