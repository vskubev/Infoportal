import Pages.LegislationPages.LawPage;
import Pages.LegislationPages.LegislationPage;
import Pages.LegislationPages.RegulatedService;
import Utils.ConfigProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LegislationPageTest extends BaseTest {

    private LegislationPage legislationPage;

    @Before
    public void setUpClass() {
        open(ConfigProperties.getTestProperty("url") + "/laws/");
        legislationPage = new LegislationPage(driver);
    }

    @Test
    public void openLawPageTest(){
        LawPage lawPage = legislationPage.clickLawList(4);
        Assert.assertEquals("Административный регламент местной администрации внутригородского муниципального" +
                " образования Санкт-Петербурга муниципальный округ Купчино по предоставлению муниципальной услуги по выдачи" +
                " разрешения на вступление в брак лицам, достигшим шестнадцати лет", lawPage.getPageHeadingText());
        Assert.assertTrue(lawPage.documentSaveButtonIsDisplayed());
    }

    @Test
    public void openAdministrativeRegulationOfPublicServicesPageTest(){
        legislationPage.clickMenuSideList(3);
        Assert.assertEquals("Административные регламенты государственных услуг", legislationPage.getFilterPageHeadingText());
        Assert.assertTrue("Ожидаемое количество услуг не соответствует фактическому",
                legislationPage.lawsReviewCycle() == legislationPage.getNumberOfServices());
    }

    @Test
    public void openRegulatedServicePageTest(){
        RegulatedService regulatedService = legislationPage.clickRegulatedService();
        Assert.assertEquals("Предоставление меры социальной поддержки в виде оплаты полной стоимости путевок в " +
                "организации отдыха детей и молодежи и их оздоровления", regulatedService.getPageHeadingText());
        Assert.assertEquals("МФЦ", regulatedService.getMfcMethodButtonText());
        Assert.assertEquals("Традиционный способ", regulatedService.getTraditionalMethodButtonText());
        Assert.assertTrue(regulatedService.mfcMapButtonIsDisplayed());
        Assert.assertTrue(regulatedService.navbarCollectionSize(11));
    }

}
