import Pages.MfcPages.*;
import Utils.ConfigProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MfcPageTest extends BaseTest {

    private MfcPage mfcPage;

    @Before
    public void setUpClass(){
        open(ConfigProperties.getTestProperty("url") + "/mfc/");
        mfcPage = new MfcPage(driver);
    }

    //Открытие услуг по жизненным ситуациям
    @Test
    public void openLifeServicesTest(){
        LifeServicesPage lifeServicesPage = mfcPage.clickLifeServicesList(2);
        Assert.assertEquals("ЖИЗНЕННАЯ СИТУАЦИЯ «УТРАТА ДОКУМЕНТОВ»", lifeServicesPage.getLifeServiceHeadingText());
        Assert.assertFalse(lifeServicesPage.isElementPresent());
        Assert.assertTrue(lifeServicesPage.lifeServicesListSize(9));

        driver.get("https://gu.spb.ru/mfc/");

        mfcPage.clickLifeServicesList(3);
        Assert.assertEquals("ЖИЗНЕННАЯ СИТУАЦИЯ «ИНДИВИДУАЛЬНОЕ ЖИЛИЩНОЕ СТРОИТЕЛЬСТВО»", lifeServicesPage.getLifeServiceHeadingText());
        Assert.assertFalse(lifeServicesPage.isElementPresent());
        Assert.assertTrue(lifeServicesPage.lifeServicesListSize(9));

        driver.get("https://gu.spb.ru/mfc/");

        mfcPage.clickLifeServicesList(4);
        Assert.assertEquals("ЖИЗНЕННАЯ СИТУАЦИЯ «ОТКРЫТИЕ СВОЕГО ДЕЛА»", lifeServicesPage.getLifeServiceHeadingText());
        Assert.assertFalse(lifeServicesPage.isElementPresent());
        Assert.assertTrue(lifeServicesPage.lifeServicesListSize(9));

        driver.get("https://gu.spb.ru/mfc/");

        mfcPage.clickLifeServicesList(5);
        Assert.assertEquals("ЖИЗНЕННАЯ СИТУАЦИЯ «УТРАТА БЛИЗКОГО ЧЕЛОВЕКА»", lifeServicesPage.getLifeServiceHeadingText());
        Assert.assertFalse(lifeServicesPage.isElementPresent());
        Assert.assertTrue(lifeServicesPage.lifeServicesListSize(9));

        driver.get("https://gu.spb.ru/mfc/");

        mfcPage.clickLifeServicesList(6);
        Assert.assertEquals("ЖИЗНЕННАЯ СИТУАЦИЯ «ПЕРЕМЕНА ИМЕНИ»", lifeServicesPage.getLifeServiceHeadingText());
        Assert.assertFalse(lifeServicesPage.isElementPresent());
        Assert.assertTrue(lifeServicesPage.lifeServicesListSize(9));

        driver.get("https://gu.spb.ru/mfc/");

        mfcPage.clickLifeServicesList(7);
        Assert.assertEquals("ЖИЗНЕННАЯ СИТУАЦИЯ «ПРИОБРЕТЕНИЕ ЖИЛЬЯ»", lifeServicesPage.getLifeServiceHeadingText());
        Assert.assertFalse(lifeServicesPage.isElementPresent());
        Assert.assertTrue(lifeServicesPage.lifeServicesListSize(9));

        driver.get("https://gu.spb.ru/mfc/");

        mfcPage.clickLifeServicesList(8);
        Assert.assertEquals("ЖИЗНЕННАЯ СИТУАЦИЯ «СМЕНА МЕСТА ЖИТЕЛЬСТВА»", lifeServicesPage.getLifeServiceHeadingText());
        Assert.assertFalse(lifeServicesPage.isElementPresent());
        Assert.assertTrue(lifeServicesPage.lifeServicesListSize(9));
    }

    @Test
    public void openBirthChildServiceTest(){
        LifeServicesPage lifeServicesPage = mfcPage.clickLifeServicesList(0);
        Assert.assertEquals("ЖИЗНЕННАЯ СИТУАЦИЯ «РОЖДЕНИЕ РЕБЕНКА»", lifeServicesPage.getLifeServiceHeadingText());
        Assert.assertTrue(lifeServicesPage.isElementPresent());
        Assert.assertTrue(lifeServicesPage.lifeServicesListSize(9));

        lifeServicesPage.clickRecordToMfcButton();
        Assert.assertEquals("Запись на прием в МФЦ", lifeServicesPage.getModalHeadingText());

        RecordPage recordPage = lifeServicesPage.clickMoreButton();
        Assert.assertEquals("ПРЕДВАРИТЕЛЬНАЯ ЗАПИСЬ НА ПРИЕМ В МФЦ", recordPage.getRecordPageHeadingText());
    }

    @Test
    public void openRetirementServiceTest(){
        LifeServicesPage lifeServicesPage = mfcPage.clickLifeServicesList(1);
        Assert.assertEquals("ЖИЗНЕННАЯ СИТУАЦИЯ «ВЫХОД НА ПЕНСИЮ»", lifeServicesPage.getLifeServiceHeadingText());
        Assert.assertTrue(lifeServicesPage.isElementPresent());
        Assert.assertTrue(lifeServicesPage.lifeServicesListSize(9));

        lifeServicesPage.clickRecordToMfcButton();
        Assert.assertEquals("Запись на прием в МФЦ", lifeServicesPage.getModalHeadingText());

        RecordPage recordPage = lifeServicesPage.clickMoreButton();
        Assert.assertEquals("ПРЕДВАРИТЕЛЬНАЯ ЗАПИСЬ НА ПРИЕМ В МФЦ", recordPage.getRecordPageHeadingText());
    }

    //Открыть офисы МФЦ
    @Test
    public void openOfficeMfcPageTest(){
        OfficesMfcPage officeMfcPage = mfcPage.clickOfficeMfcButton();
        Assert.assertEquals("Название заголовка не совпадает с ожидаемым", "ОФИСЫ МФЦ",
                officeMfcPage.getPageHeadingText());
        Assert.assertTrue("Количество районов в боковом меню не совпадает с ожидаемым",
                officeMfcPage.menuListSize(18));
        Assert.assertTrue("Изображение МФЦ не отображается", officeMfcPage.imageMfcIsDisplayed());
        Assert.assertTrue("Фактический текст в контейнере МФЦ не совпадает с ожидаемым",
                officeMfcPage.textMfcIsDisplayed());
        Assert.assertTrue("Блок мобильного МФЦ содержит кнопку подробнее или ссылку в заголовке",
                officeMfcPage.mobileMfcTestButtonIsDisplayed());
    }

    //Открыть Все услуги МФЦ
    @Test
    public void openMfcAllServicesPageTest(){
        MfcAllServicesPage mfcAllServicesPage = mfcPage.clickMfcAllServicesButton();
        Assert.assertEquals("ВСЕ УСЛУГИ МФЦ",  mfcAllServicesPage.getPageHeadingText());
        Assert.assertTrue(mfcAllServicesPage.alphabetFilterListSize(21));
        Assert.assertTrue(mfcAllServicesPage.searchFieldIsDisplayed());
        Assert.assertTrue(mfcAllServicesPage.servicesListSize(30));
    }

    //Открыть пресс-центр
    @Test
    public void openPressCenterPageTest(){
        PressCenterPage pressCenterPage = mfcPage.clickPressCentrButton();
        Assert.assertEquals("НОВОСТИ МФЦ", pressCenterPage.getPageHeadingText());
        Assert.assertTrue(pressCenterPage.paginationListSize(10));

        pressCenterPage.clickNewsHeadingList(0);
        Assert.assertEquals("Новости", pressCenterPage.getNewsCategoryText());

        pressCenterPage.clickBackToButton();
        Assert.assertEquals("НОВОСТИ МФЦ", pressCenterPage.getPageHeadingText());

        pressCenterPage.clickNewsMoreButtonList(0);
        Assert.assertEquals("Новости", pressCenterPage.getNewsCategoryText());
    }

    //Открыть страницу О МФЦ
    @Test
    public void openAboutMfcPageTest(){
        AboutMfcPage aboutMfcPage = mfcPage.clickAboutMfcButton();
        Assert.assertEquals("О МФЦ", aboutMfcPage.getPageHeadingText());
        Assert.assertTrue(aboutMfcPage.menuListSize(6));
    }

    //Открыть страницу Обратная связь МФЦ
    @Test
    public void openFeedbackPageTest(){
        FeedbackPage feedbackPage = mfcPage.clickFeedbackButton();
        Assert.assertEquals("ОБРАТНАЯ СВЯЗЬ МФЦ", feedbackPage.getPageHeadingText());
        Assert.assertEquals("ПОСЛЕДНИЕ ОТЗЫВЫ", feedbackPage.getLastReviewHeadingText());
        Assert.assertTrue(feedbackPage.menuListSize(3));
        Assert.assertTrue(feedbackPage.createFeedbackButtonIsDisplayed());
        Assert.assertTrue(feedbackPage.rateQualityButtonIsDisplayed());
    }

}
