import Pages.OrganizationsPages.ArchiveCommittee;
import Pages.OrganizationsPages.OrganizationsPage;
import Utils.ConfigProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OrganizationsPageTest extends BaseTest {

    private OrganizationsPage organizationsPage;

    @Before
    public void setUpClass() {
        open(ConfigProperties.getTestProperty("url") + "/orgs/classifier/");
        organizationsPage = new OrganizationsPage(driver);
    }

    @Test
    public void openOrganizationPageTest(){
        ArchiveCommittee archiveCommittee = organizationsPage.clickArchiveCommitteeButton();
        Assert.assertEquals("Архивный комитет Санкт-Петербурга", archiveCommittee.getPageHeadingText());
        Assert.assertEquals("Общая информация", archiveCommittee.getTabMenuListText(0));
        Assert.assertEquals("Контактная информация", archiveCommittee.getTabMenuListText(1));
        Assert.assertEquals("Услуги", archiveCommittee.getTabMenuListText(2));
        Assert.assertEquals("Подведомственные организации", archiveCommittee.getTabMenuListText(3));
        Assert.assertTrue(archiveCommittee.getCommonInformationText().contains("Архивный комитет Санкт‑Петербурга — исполнительный орган, " +
                "который проводит государственную политику в области архивного дела на территории Санкт‑Петербурга, координирует деятельность " +
                "в этой области иных органов исполнительной власти."));

        archiveCommittee.clickTabMenuList(1);
        Assert.assertTrue(archiveCommittee.getContactInformationText().contains("Адрес: 191015, Санкт-Петербург, Таврическая ул., д. 39"));
        Assert.assertTrue(archiveCommittee.getContactInformationText().contains("Телефон: (812) 576-54-02"));
        Assert.assertTrue(archiveCommittee.getContactInformationText().contains("Сайт: https://spbarchives.ru/web/group/archive_committee"));

        archiveCommittee.clickTabMenuList(2);
        Assert.assertTrue(archiveCommittee.servicesListSize(3));
        Assert.assertEquals("Выдача разрешения на временный вывоз документов", archiveCommittee.getServicesListText(0));
        Assert.assertEquals("Проставление апостиля на архивных документах", archiveCommittee.getServicesListText(1));
        Assert.assertEquals("Экспертиза ценности документов", archiveCommittee.getServicesListText(2));

        archiveCommittee.clickTabMenuList(3);
        Assert.assertTrue(archiveCommittee.orgsListSize(1));
        Assert.assertEquals("Государственные архивы Санкт-Петербурга", archiveCommittee.getOrgsListText(0));
    }

    @Test
    public void openSphereActivityFilter(){
        organizationsPage.clickSphereActivityButton();
        Assert.assertEquals("По сферам деятельности", organizationsPage.getActiveFilterText());
        Assert.assertTrue(organizationsPage.menuSideListSize(16));
        Assert.assertTrue("Фактическое количество услуг не соответствует ожидаемому",
                organizationsPage.organizationsReviewCycle());
    }

    @Test
    public void openOrganizationFromSpherePageTest(){
        organizationsPage.clickSphereActivityButton();

        ArchiveCommittee archiveCommittee = organizationsPage.clickArchiveCommitteeButton();
        Assert.assertEquals("Архивный комитет Санкт-Петербурга", archiveCommittee.getPageHeadingText());
        Assert.assertEquals("Общая информация", archiveCommittee.getTabMenuListText(0));
        Assert.assertEquals("Контактная информация", archiveCommittee.getTabMenuListText(1));
        Assert.assertEquals("Услуги", archiveCommittee.getTabMenuListText(2));
        Assert.assertEquals("Подведомственные организации", archiveCommittee.getTabMenuListText(3));
    }

    @Test
    public void alphabetFilterTest(){
        organizationsPage.typeSearchField("Федеральная антимонопольная служба");
        Assert.assertTrue(organizationsPage.federalAntimonopolyButtonIsDisplayed());

        organizationsPage.clickAlphabetFilterList(18);
        Assert.assertTrue(organizationsPage.federalAntimonopolyButtonIsDisplayed());
        Assert.assertTrue("Фактическое количество услуг не соответствует ожидаемому",
                organizationsPage.organizationsReviewAlphabetFilterCycle());
    }

}
