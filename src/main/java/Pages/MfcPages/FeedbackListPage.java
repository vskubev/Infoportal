package Pages.MfcPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.soap.SAAJResult;
import java.util.List;

public class FeedbackListPage extends BasePage { //Отзывы по работе МФЦ https://gu.spb.ru/mfc/comment/list/

    private WebDriver driver;

    public FeedbackListPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //Заголовок
    private By pageHeading = By.xpath("//div[@class='col-lg-12']//h2");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Пагинация
    @FindBy(xpath = "//nav[@class='pagi pagi-desktop']/ul/li")
    private List<WebElement> paginationList;

    public boolean paginationListSize(int size){
        boolean equality = false;
        if(paginationList.size() == size) {
            equality = true;
        }
        return equality;
    }

    //Список отзывов
    @FindBy(xpath = "//div[@class='simpleContent']//a")
    private List<WebElement> feedbackHeadingList;

    public FeedbackListPage clickFeedbackHeadingList(int index){
        $(feedbackHeadingList.get(index)).click();
        return new FeedbackListPage(driver);
    }

    //Страница выбранного отзыва

    private By feedbackPageHeading = By.xpath("//h1[@class='service_name']");
    private By backToButton = By.xpath("//div[@id='navigation']//h6//a");

    public boolean feedbackPageHeadingIsDisplayed(){ return $(feedbackPageHeading).isDisplayed(); }
    public String getFeedbackPageHeadingText(){ return $(feedbackPageHeading).getText(); }

    public boolean backToButtonIsDisplayed(){ return $(backToButton).isDisplayed(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
