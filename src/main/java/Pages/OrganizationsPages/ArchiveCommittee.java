package Pages.OrganizationsPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ArchiveCommittee extends BasePage { //Страница архивного комитета https://gu.spb.ru/orgs/66603/?from=c

    private WebDriver driver;

    public ArchiveCommittee(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Заголовок
    private By pageHeading = By.xpath("//span[@id='pagetitle']");

    public String getPageHeadingText(){ return $(pageHeading).getText(); }

    //Меню общая информация/контактная информация/услуги/подведомства
    @FindBy(xpath = "//ul[@class='tab-menu']/li")
    private List<WebElement> tabMenuList;

    public String getTabMenuListText(int index){ return $(tabMenuList.get(index)).getText(); }

    public ArchiveCommittee clickTabMenuList(int index){
        $(tabMenuList.get(index)).click();
        return new ArchiveCommittee(driver);
    }

    //Вкладка общая информация
    private By commonInformation = By.xpath("//div[@class='text-clean']");

    public String getCommonInformationText(){ return $(commonInformation).getText(); }

    //Вкладка контактная информация
    private By contactsInformation = By.xpath("//div[@class='text-clean']");

    public String getContactInformationText(){ return $(contactsInformation).getText(); }

    //Вкладка услуги
    @FindBy(xpath = "//ul[@id='services-list']/li")
    private List<WebElement> servicesList;

    public boolean servicesListSize(int size){
        boolean equality = false;
        if(servicesList.size() == size) {
            equality = true;
        }
        return equality;
    }

    public String getServicesListText(int index){ return $(servicesList.get(index)).getText(); }

    //Вкладка подведомтсвенные организации
    @FindBy(xpath = "//ul[@id='orgs-list']/li")
    private List<WebElement> orgsList;

    public boolean orgsListSize(int size){
        boolean equality = false;
        if(orgsList.size() == size) {
            equality = true;
        }
        return equality;
    }

    public String getOrgsListText(int index){ return $(orgsList.get(index)).getText(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}

