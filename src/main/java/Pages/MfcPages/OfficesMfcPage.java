package Pages.MfcPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//Офисы МФЦ https://gu.spb.ru/mfc/list/
public class OfficesMfcPage extends BasePage {

    private WebDriver driver;

    public OfficesMfcPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//div[@id='sv-content']//div[@class='col-lg-12']//h2");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Боковое меню
    @FindBy(xpath = "//nav[@id='navbar-example']/ul/li")
    private List<WebElement> menuList;

    public OfficesMfcPage clickMeniList(int index){
        $(menuList.get(index)).click();
        return this;
    }

    public boolean menuListSize(int size){
        boolean equality = false;
        if(menuList.size() == size) {
            equality = true;
        }
        return equality;
    }

    //Список МФЦ
    @FindBy(xpath = "//div[@class='item-mfc']")
    private List<WebElement> mfcList;

    @FindBy(xpath = "//div[@class='foto-mfc']/img")
    private List<WebElement> mfcPhotoList;

    @FindBy(xpath = "//div[@class='item-mfc']//h4/a")
    private List<WebElement> mfcHeadingList;

    public boolean isItMobileMfc(int index){
        boolean equality = false;
        String textMfc = $(mfcList.get(index)).getText();
        if(textMfc.contains("МОБИЛЬНЫЙ МФЦ")) equality = true;
        return equality;
    }

    public boolean imageMfcIsDisplayed(){
        boolean equality = true;
        for (int i = 0; i < mfcPhotoList.size(); i++){
            if (!mfcPhotoList.get(i).isDisplayed()) equality = false;
        }
        return equality;
    }

    public boolean textMfcIsDisplayed(){
        boolean equality = true;
        for (int i = 0; i < mfcList.size(); i++){
            String textMfc = $(mfcList.get(i)).getText();
            if (!isItMobileMfc(i) && !textMfc.contains("Адрес:") && !textMfc.contains("Телефон:")) equality = false;
            if (isItMobileMfc(i) && !textMfc.contains("Адрес:") && !textMfc.contains("Дни работы, еженедельно:")) equality = false;
        }
        return equality;
    }

    public boolean mobileMfcTestButtonIsDisplayed(){
        boolean equality = true;
        for (int i = 0; i < mfcList.size(); i++){
            String textMfc = mfcList.get(i).getText();
            if(isItMobileMfc(i) && textMfc.contains("Подробнее →"))equality = false;
        }
        return equality;
    }

    public SectorMfcPage clickMfcHeadingList(int index){
        $(mfcHeadingList.get(index)).click();
        return new SectorMfcPage(driver);
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
