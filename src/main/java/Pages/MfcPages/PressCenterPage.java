package Pages.MfcPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PressCenterPage extends BasePage { //Пресс центр https://gu.spb.ru/mfc/news/

    private WebDriver driver;

    public PressCenterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//div[@class='col-lg-12']//h2");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Лента новостей
    @FindBy(xpath = "//div[@class='news-list news-list-2col']/ul/li//h4")
    private List<WebElement> newsHeadingList;

    @FindBy(xpath = "//div[@class='news-list news-list-2col']/ul/li//a[@class='newsDetails']")
    private List<WebElement> newsMoreButtonList;

    public PressCenterPage clickNewsHeadingList(int index){
        $(newsHeadingList.get(index)).click();
        return this;
    }

    public PressCenterPage clickNewsMoreButtonList(int index){
        $(newsMoreButtonList.get(index)).click();
        return this;
    }

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

    //Возврат к новостям от выбранной новости
    private By backToButton = By.xpath("//div[@id='navigation']//h6//a");
    private By newsCategory = By.xpath("//nav[@class='menu-side ']//a[@href='/mfc/news/']");

    public PressCenterPage clickBackToButton(){
        $(backToButton).click();
        return this;
    }

    public String getNewsCategoryText(){ return $(newsCategory).getText(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
