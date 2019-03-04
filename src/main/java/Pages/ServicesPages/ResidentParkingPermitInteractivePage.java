package Pages.ServicesPages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResidentParkingPermitInteractivePage extends BasePage { //интерактивная часть услуги https://eservice.gu.spb.ru/portalFront/resources/portal.html?offer=1&serviceId=795.0.10.01.1&nSR=true&nAD=true#offer

    private WebDriver driver;

    public ResidentParkingPermitInteractivePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //заголовок
    private By serviceHeading = By.xpath("//h3[@id='portal-form-service-heading']");

    public String getServiceHeadingText(){ return $(serviceHeading).getText(); }

    //Пагинация
    @FindBy(xpath = "//div[@id='step-tabs-ul']/div")
    private List<WebElement> servicePagesList;

    public boolean servicePageListSize(int size){
        boolean equality = false;
        if(servicePagesList.size() == size){ equality = true; }
        return equality;
    }

    //Кнопки управления (сохранить, далее)
    private By saveButton = By.xpath("//a[@class='step-button-save btn btn-default'][text()=' Сохранить']");
    private By nextButton = By.xpath("//a[@class='btn btn-primary step-button-next'][1]");

    public boolean saveButtonIsDisplayed() { return $(saveButton).isDisplayed(); }
    public boolean nextButtonIsDisplayed() { return $(nextButton).isDisplayed(); }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
