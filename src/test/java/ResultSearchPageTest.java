import Pages.MainPage;
import Pages.MfcPages.MfcPage;
import Pages.SearchPages.ResultSearchPage;
import Pages.ServicesPages.ResidentParkingPermitServicePage;
import Utils.ConfigProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResultSearchPageTest extends BaseTest {

    MainPage mainPage;

    @Before
    public void setUpClass() {
        open(ConfigProperties.getTestProperty("url"));
        mainPage = new MainPage(driver);
    }

    //Поиск через поисковую строку
    @Test
    public void searchByServicesTest(){
        String request = "парковочном разрешении";
        ResultSearchPage resultSearchPage = mainPage.searchByServices(request);
        Assert.assertEquals("Ожидаемый заголовок страницы не соответствует актуальному",
                "Поиск", resultSearchPage.getPageHeadingText());
        Assert.assertTrue("Заголовок услуги из результатов поиска не содержит ожидаемый текст запроса",
                resultSearchPage.searchResultsContainsRequestStringCycle(request));

        ResidentParkingPermitServicePage residentParkingPermitServicePage = resultSearchPage.clickSearchResultList(0);
        Assert.assertEquals("Внесение в Реестр записи о парковочном разрешении жителя", residentParkingPermitServicePage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", residentParkingPermitServicePage.getMethodOfServiceText("eservice"));
        Assert.assertEquals("МФЦ", residentParkingPermitServicePage.getMethodOfServiceText("mfcservice"));
        Assert.assertEquals("Общее описание", residentParkingPermitServicePage.getServiceDescriptionHeadingText());
        Assert.assertEquals("7800000010000054139", residentParkingPermitServicePage.getRegistryNumberText());
        Assert.assertTrue(residentParkingPermitServicePage.navbarCollectionSize(11));
        Assert.assertTrue(residentParkingPermitServicePage.getServiceButtonIsDisplayed());

        residentParkingPermitServicePage.clickMethodOfServiceButton("mfcservice");
        Assert.assertTrue(residentParkingPermitServicePage.mfcMapButtonIsDisplayed());
        Assert.assertTrue(residentParkingPermitServicePage.recordToMfcButtonIsDisplayed());
    }

    @Test
    public void tagsCloudTest(){
        String request = "парковочном разрешении";
        ResultSearchPage resultSearchPage = mainPage.searchByServices(request);

        resultSearchPage.clickTagsCloudList(3);
        Assert.assertTrue("Количество отображаемых услуг не совпадает с ожидаемым результатом",
                resultSearchPage.searchResultListSize(1));
        Assert.assertTrue("Ожидаемый заголовок услуги не соответствует актуальному",
                resultSearchPage.getSearchResultListText(0).contains("парковочном разрешении"));
    }

    @Test
    public void filteringByCriteriaTest(){
        String request = "парковочном разрешении";
        ResultSearchPage resultSearchPage = mainPage.searchByServices(request);

        resultSearchPage.clickServiceFilterList(1);
        Assert.assertTrue("Ожидаемое количество отображаемых услуг не соответствует фактическому",
                resultSearchPage.searchResultListSize(3));

        resultSearchPage.clickServiceFilterList(6);
        Assert.assertTrue("Ожидаемое количество отображаемых услуг не соответствует фактическому",
                resultSearchPage.searchResultListSize(4));
    }

    @Test
    public void clickMfcButton(){
        String request = "парковочном разрешении";
        ResultSearchPage resultSearchPage = mainPage.searchByServices(request);

        resultSearchPage.clickSelectSearchList(1);
        Assert.assertTrue("Текст услуги из результатов поиска не содержит ожидаемый текст запроса",
                resultSearchPage.searchResultsContainsRequestStringCycle("парковочн"));

        MfcPage mfcPage = resultSearchPage.clickSearchMfcResultList(0);
        Assert.assertEquals("Фактическая и ожидаемая активные кнопки - различны",
                "МФЦ", mfcPage.getActiveButtonText());
    }

    @Test
    public void clickAllPortalButton(){
        String request = "парковочном разрешении";
        ResultSearchPage resultSearchPage = mainPage.searchByServices(request);

        resultSearchPage.clickSelectSearchList(2);
        Assert.assertTrue("Текст услуги из результатов поиска не содержит ожидаемый текст запроса",
                resultSearchPage.searchResultsContainsRequestStringCycle("парковоч"));

        ResidentParkingPermitServicePage residentParkingPermitServicePage = resultSearchPage.clickSearchResultList(0);
        Assert.assertEquals("Внесение в Реестр записи о парковочном разрешении жителя", residentParkingPermitServicePage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", residentParkingPermitServicePage.getMethodOfServiceText("eservice"));
        Assert.assertEquals("МФЦ", residentParkingPermitServicePage.getMethodOfServiceText("mfcservice"));
        Assert.assertEquals("Общее описание", residentParkingPermitServicePage.getServiceDescriptionHeadingText());
        Assert.assertEquals("7800000010000054139", residentParkingPermitServicePage.getRegistryNumberText());
        Assert.assertTrue(residentParkingPermitServicePage.navbarCollectionSize(11));
        Assert.assertTrue(residentParkingPermitServicePage.getServiceButtonIsDisplayed());

        residentParkingPermitServicePage.clickMethodOfServiceButton("mfcservice");
        Assert.assertTrue(residentParkingPermitServicePage.mfcMapButtonIsDisplayed());
        Assert.assertTrue(residentParkingPermitServicePage.recordToMfcButtonIsDisplayed());
    }
}
