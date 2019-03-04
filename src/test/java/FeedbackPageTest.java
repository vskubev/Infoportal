import Pages.MfcPages.FeedbackListPage;
import Pages.MfcPages.FeedbackPage;
import Pages.MfcPages.CreateFeedbackPage;
import Pages.MfcPages.QualityOfServicesPage;
import Utils.ConfigProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class FeedbackPageTest extends BaseTest {

    private FeedbackPage feedbackPage;

    @Before
    public void setUpClass(){
        open(ConfigProperties.getTestProperty("url") + "/mfc/feedback/");
        feedbackPage = new FeedbackPage(driver);
    }

    //Страница "Оставить отзыв о посещении МФЦ"
    @Test
    public void createFeedbackTest(){
        CreateFeedbackPage createFeedbackPage = feedbackPage.clickCreateFeedbackButton();
        Assert.assertEquals("Фактический и ожидаемый заголовки страницы не совпадают",
                "ОСТАВИТЬ ОТЗЫВ О МФЦ", createFeedbackPage.getPageHeadingText());
        Assert.assertTrue("Фактическое число элементов списка бокового меню не соответствует ожидаемому",
                createFeedbackPage.menuListSize(3));

        createFeedbackPage.typeFeedbackPage("тестовое сообщение", "Имя",
                "Фамилия", "email", "email@test.com", "9990001122");
        Assert.assertTrue("Кнопка отправки формы отзыва не отображается",
                createFeedbackPage.sendButtonIsDisplayed());
    }

    //Страница "Отзывы по работе МФЦ
    @Test
    public void openFeedbackListTest(){
        FeedbackListPage feedbackListPage = feedbackPage.clickMenuListToFeedback();
        Assert.assertEquals("Фактический и ожидаемый заголовки страницы не совпадают",
                "ОТЗЫВЫ ПО РАБОТЕ МФЦ", feedbackListPage.getPageHeadingText());
        Assert.assertTrue("Фактическое число элементов списка пагинации не соответствует ожидаемому",
                feedbackListPage.paginationListSize(10));

        feedbackListPage.clickFeedbackHeadingList(2);
        Assert.assertTrue(feedbackListPage.backToButtonIsDisplayed());
        Assert.assertEquals("Фактический и ожидаемый заголовки страницы не совпадают",
                "Отзыв по работе МФЦ", feedbackListPage.getFeedbackPageHeadingText());
    }

    //Страница "Оценить качество слуг МФЦ
    @Test
    public void openQualityOfServicesPaTest(){
        QualityOfServicesPage qualityOfServicesPage = feedbackPage.clickMenuListToQuality();
        Assert.assertEquals("Фактический и ожидаемый заголовки страницы не совпадают",
                "ОЦЕНИТЬ КАЧЕСТВО УСЛУГ МФЦ", qualityOfServicesPage.getPageHeadingText());
        Assert.assertTrue("Фактическое число элементов списка бокового меню не соответствует ожидаемому",
                qualityOfServicesPage.menuListSize(3));
    }
}
