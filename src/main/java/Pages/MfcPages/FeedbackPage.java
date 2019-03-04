package Pages.MfcPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FeedbackPage extends BasePage { //Обратная связь МФЦ https://gu.spb.ru/mfc/feedback/

    private WebDriver driver;

    public FeedbackPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//div[@id='sv-content']//div[@class='col-lg-12']//h2");

    public String getPageHeadingText(){ return driver.findElement(pageHeading).getText(); }

    //Боковое меню
    @FindBy(xpath = "//nav[@class='menu-side ']/ul/li")
    private List<WebElement> menuList;

    public boolean menuListSize(int size){
        boolean equality = false;
        if(menuList.size() == size) {
            equality = true;
        }
        return equality;
    }

    public FeedbackListPage clickMenuListToFeedback(){
        menuList.get(1).click();
        return new FeedbackListPage(driver);
    }

    public QualityOfServicesPage clickMenuListToQuality(){
        $(menuList.get(2)).click();
        return new QualityOfServicesPage(driver);
    }

    //Кнопки оставить отзыв/оценить качество
    private By createFeedbackButton = By.xpath("//div[@class='block-tile']//a[@href='/mfc/comment/']");
    private By rateQualityButton = By.xpath("//div[@class='block-tile']//a[@href='/mfc/evaluation/']");

    public boolean createFeedbackButtonIsDisplayed(){ return driver.findElement(createFeedbackButton).isDisplayed(); }

    public CreateFeedbackPage clickCreateFeedbackButton(){
        $(createFeedbackButton).click();
        return new CreateFeedbackPage(driver);
    }

    public boolean rateQualityButtonIsDisplayed(){ return driver.findElement(rateQualityButton).isDisplayed(); }

    public RateQualityPage clickRateQualityButton(){
        $(rateQualityButton).click();
        return new RateQualityPage(driver);
    }

    //Последние отзывы
    private By lastReviewHeading = By.xpath("//h2/a[@href='/mfc/comment/list/']");

    public String getLastReviewHeadingText(){ return $(lastReviewHeading).getText(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
