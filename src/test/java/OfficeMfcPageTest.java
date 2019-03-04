import Pages.MfcPages.MfcPage;
import Pages.MfcPages.OfficesMfcPage;
import Pages.MfcPages.SectorMfcPage;
import Pages.ServicesPages.InternationalPassportPage;
import Utils.ConfigProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class OfficeMfcPageTest extends BaseTest {

    private OfficesMfcPage officesMfcPage;

    @Before
    public void setUpClass(){
        open(ConfigProperties.getTestProperty("url") + "/mfc/list/");
        officesMfcPage = new OfficesMfcPage(driver);
    }

    @Test
    public void sideBarTest(){
        officesMfcPage.clickMeniList(2);
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://gu.spb.ru/mfc/list/#2043", url);
    }

    @Test
    public void openSectorMfcPageTest(){
        SectorMfcPage sectorMfcPage = officesMfcPage.clickMfcHeadingList(0);
        Assert.assertEquals("Название сектора не совпадает с ожидаемым названием",
                "Сектор 1 многофункционального центра предоставления государственных и муниципальных услуг Адмиралтейского района",
                sectorMfcPage.getPageHeadingText());
        Assert.assertTrue("Количество районов в списке не совпадает с ожидаемым результатом", sectorMfcPage.menuListSize(18));
        Assert.assertTrue("Фото сектора МФЦ отсутствует или не отображается", sectorMfcPage.photoMfcIsDisplayed());
        Assert.assertTrue("Текст отсутствует в контейнере информации", sectorMfcPage.getInfoMfcText().contains("Адрес:"));
        Assert.assertTrue("Текст отсутствует в контейнере информации", sectorMfcPage.getInfoMfcText().contains("Телефон:"));
        Assert.assertTrue("Текст отсутствует в контейнере информации", sectorMfcPage.getInfoMfcText().contains("Часы работы:"));
    }

    @Test
    public void openServicesMfcListTest(){
        SectorMfcPage sectorMfcPage = officesMfcPage.clickMfcHeadingList(0);
        sectorMfcPage.clickTabMenuList(1);

        Assert.assertTrue("Фактическое количество услуг не соответствует ожидаемому",
                sectorMfcPage.servicesReviewAlphabetFilterCycle());
    }

    @Test
    public void openServiceTest(){
        SectorMfcPage sectorMfcPage = officesMfcPage.clickMfcHeadingList(0);
        String searchName = "Выдача заграничного паспорта гражданина РФ";
        sectorMfcPage.clickTabMenuList(1);
        sectorMfcPage.typeSearchField(searchName);

        //InternationalPassportPage internationalPassportPage = sectorMfcPage.clickServicesList(0, searchName);
        InternationalPassportPage internationalPassportPage = sectorMfcPage.clickInternationalPassportServiceButton(searchName);
        Assert.assertEquals("Выдача заграничного паспорта гражданина РФ", internationalPassportPage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", internationalPassportPage.getEserviceMethodButtonText());
        Assert.assertEquals("МФЦ", internationalPassportPage.getMfcMethodButtonText());
        Assert.assertEquals("Традиционный способ", internationalPassportPage.getTraditionalMethodButtonText());
        Assert.assertTrue(internationalPassportPage.getServiceButtonIsDisplayed());
        Assert.assertTrue(internationalPassportPage.navbarCollectionSize(10));
    }
}
