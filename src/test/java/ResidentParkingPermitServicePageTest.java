import Pages.AuthPage;
import Pages.ServicesPages.ResidentParkingPermitInteractivePage;
import Pages.ServicesPages.ResidentParkingPermitServicePage;
import Utils.ConfigProperties;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ResidentParkingPermitServicePageTest extends BaseTest {

    private ResidentParkingPermitServicePage residentParkingPermitServicePage;

    @Before
    public void setUpClass(){
        open(ConfigProperties.getTestProperty("url") + "/188871/eservice/");
        residentParkingPermitServicePage = new ResidentParkingPermitServicePage(driver);
    }

    //Переход по якорям на странице услуги
    @Test
    public void navigationTest(){
        residentParkingPermitServicePage.clickNavbarList(3);
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://gu.spb.ru/188871/eservice/#group-cost", url);
    }

    //Переход на интерактивный портал через кнопку "Получить услугу"
    @Test
    public void openServiceInteractivePageTest(){
        AuthPage authPage = residentParkingPermitServicePage.clickGetServiceButton();

        for (String tab : driver.getWindowHandles()){ // переключение на последнюю открытую вкладку
            driver.switchTo().window(tab);
        }

        Assert.assertTrue(authPage.authorizeButtonIsDisplayed());

        authPage.authorization(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));

        ResidentParkingPermitInteractivePage residentParkingPermitInteractivePage = authPage.clickSignInButtonFromService();

        Assert.assertEquals("Внесение в Реестр парковочных разрешений жителей записи о парковочном разрешении жителя, сведений об изменении записи",
                residentParkingPermitInteractivePage.getServiceHeadingText());
        Assert.assertTrue(residentParkingPermitInteractivePage.servicePageListSize(11));
        Assert.assertTrue(residentParkingPermitInteractivePage.saveButtonIsDisplayed());
        Assert.assertTrue(residentParkingPermitInteractivePage.nextButtonIsDisplayed());
    }

    //Открытие модального окна по кнопке "Запись в МФЦ" на странице услуги
    @Test
    public void recordToMfcTest(){
        residentParkingPermitServicePage.clickMethodOfServiceButton("mfcservice");
        Assert.assertTrue(residentParkingPermitServicePage.mfcMapButtonIsDisplayed());
        Assert.assertTrue(residentParkingPermitServicePage.recordToMfcButtonIsDisplayed());

        residentParkingPermitServicePage.clickRecordToMfcButton();

        Assert.assertEquals("Телефон предварительной записи 573-90-00", residentParkingPermitServicePage.getPreRegistrationPhoneText());
        Assert.assertEquals("573-90-00", residentParkingPermitServicePage.getPhoneNumberText());
    }

}
