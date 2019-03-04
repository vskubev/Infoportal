import Pages.MfcPages.MfcAllServicesPage;
import Pages.MfcPages.MfcPage;
import Pages.ServicesPages.AccreditationOfGuides;
import Utils.ConfigProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MfcAllServicesPageTest extends BaseTest {

    private MfcAllServicesPage mfcAllServicesPage;

    @Before
    public void setUpClass(){
        open(ConfigProperties.getTestProperty("url") + "/mfc/services/");
        mfcAllServicesPage = new MfcAllServicesPage(driver);
    }

    @Test
    public void clickRecordToMfcButton(){
        mfcAllServicesPage.clickRecordToMfcButton();
        Assert.assertEquals("Название заголовка не совпадает с ожидаемым",
                "ПРЕДВАРИТЕЛЬНАЯ ЗАПИСЬ НА ПРИЕМ В МФЦ", mfcAllServicesPage.getPageRecordHeadingText());
        Assert.assertTrue("В фактическом тексте не содержится ожидаемый",
                mfcAllServicesPage.getPageInformationText().contains("Предварительная запись на прием или выдачу " +
                "документов в МФЦ Санкт-Петербурга осуществляется по телефону 573-90-00 ежедневно с 09.00 до 21.00 или при " +
                "личном обращении в МФЦ в часы работы центра."));
    }

    @Ignore
    public void filterCheckboxesFirstTest(){
        mfcAllServicesPage.clickSmartFilterList(0, 3, 5);
        Assert.assertTrue("Ожидаемое количество услуг не соответствует фактическому", mfcAllServicesPage.servicesListSize(1));
        mfcAllServicesPage.clickClearButton();
    }

    @Ignore
    public void filterCheckboxesSecondTest(){
        mfcAllServicesPage.clickSmartFilterList(1, 4, 15);
        Assert.assertTrue("Ожидаемое количество услуг не соответствует фактическому",
                mfcAllServicesPage.servicesListSize(2));
        mfcAllServicesPage.clickClearButton();
    }

    @Ignore
    public void filterCheckboxesThirdTest(){
        mfcAllServicesPage.clickSmartFilterList(1, 2, 11);
        Assert.assertTrue("Ожидаемое количество услуг не соответствует фактическому",
                mfcAllServicesPage.servicesListSize(1));
        mfcAllServicesPage.clickClearButton();
    }

    @Ignore
    public void filterCheckboxesFourthTest(){
        mfcAllServicesPage.clickSmartFilterList(10, 15);
        Assert.assertTrue("Ожидаемое количество услуг не соответствует фактическому",
                mfcAllServicesPage.servicesListSize(9));
        mfcAllServicesPage.clickClearButton();
    }

    @Test
    public void clickEserviceMethodTest(){
        AccreditationOfGuides accreditationOfGuides = mfcAllServicesPage.clickMethodOfServicesList(6);
        Assert.assertEquals("Активная вкладка не соответствует ожидаемой",
                "Электронный способ", accreditationOfGuides.getActiveMethodButtonText());
    }

    @Test
    public void  clickMfcMethodTest(){
        AccreditationOfGuides accreditationOfGuides = mfcAllServicesPage.clickMethodOfServicesList(7);
        Assert.assertEquals("Активная вкладка не соответствует ожидаемой",
                "МФЦ", accreditationOfGuides.getActiveMethodButtonText());
    }

    @Test
    public void clickTraditionalMethodTest(){
        AccreditationOfGuides accreditationOfGuides = mfcAllServicesPage.clickMethodOfServicesList(8);
        Assert.assertEquals("Активная вкладка не соответствует ожидаемой",
                "Традиционный способ", accreditationOfGuides.getActiveMethodButtonText());
    }
}
