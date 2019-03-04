import Pages.DocumentsBlanksPages.DocumentsBlanksPage;
import Pages.DocumentsBlanksPages.DocumentsPage;
import Utils.ConfigProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DocumentsBlanksPageTest extends BaseTest {

    private DocumentsBlanksPage documentsBlanksPage;

    @Before
    public void setUpClass() {
        open(ConfigProperties.getTestProperty("url") + "/docs/");
        documentsBlanksPage = new DocumentsBlanksPage(driver);
    }

    @Test
    public void openDocumentPageTest(){
        DocumentsPage documentsPage = documentsBlanksPage.clickCancellationHuntingTicketDoc();
        Assert.assertEquals("Фактический и ожидаемый заголовки страницы не совпадают",
                "Акт аннулирования охотничьего билета", documentsPage.getPageHeadingText());
        Assert.assertTrue("Кнопка сохранения документа не отображается",
                documentsPage.documentSaveButtonIsDisplayed());

        documentsPage.clickLegislativeActButton();
        Assert.assertEquals("Фактический и ожидаемый заголовки страницы не совпадают",
                "Административный регламент Комитета по природопользованию, охране окружающей" +
                " среды и обеспечению экологической безопасности по предоставлению государственной услуги по выдаче и " +
                "аннулированию охотничьих билетов единого федерального образца", documentsPage.getPageLawHeadingText());
        Assert.assertEquals("Выдача и аннулирование охотничьих билетов единого федерального образца", documentsPage.getServiceListText(0));
    }

    @Test
    public void openTypeDocumentsFilterTest(){
        documentsBlanksPage.clickMenuSideList();
        Assert.assertTrue("Количество услуг в списке не совпадает с ожидаемым",
                documentsBlanksPage.documentsListSize(29));
    }
}
