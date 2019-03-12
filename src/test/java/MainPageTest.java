import Pages.*;
import Pages.DocumentsBlanksPages.DocumentsBlanksPage;
import Pages.LegislationPages.LegislationPage;
import Pages.MfcPages.MfcPage;
import Pages.OrganizationsPages.OrganizationsPage;
import Pages.PaymentPages.PaymentPage;
import Pages.ServicesPages.*;
import Utils.ConfigProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MainPageTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void setUpClass() {
        open(ConfigProperties.getTestProperty("url"));
        mainPage = new MainPage(driver);
    }

    @Test
    public void openMainPage(){
        Assert.assertTrue(mainPage.servicesCatalogListSize(12));
        Assert.assertTrue(mainPage.newsHeadingIsDisplayed());
        Assert.assertTrue(mainPage.massMediaHeadingIsDisplayed());
        Assert.assertTrue(mainPage.usefulInformationHeadingIsDisplayed());
        Assert.assertTrue(mainPage.booleanusefullinksButtonIsDisplayed());
        Assert.assertTrue(mainPage.navFooterListSize(5));
        Assert.assertTrue(mainPage.blockFooterListSize(5));
    }

    @Test //Авторизация
    public void signInTest(){
        AuthPage authPage = mainPage.clickSignInButton();

        authPage.authorization(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));

        PrivateOfficePage privateOfficePage = authPage.clickSignInButtonFromMainPage();

        Assert.assertEquals("Скубьев В.А.", privateOfficePage.getAccountNameText());
        Assert.assertTrue(privateOfficePage.logoutButtonIsDisplayed());
        Assert.assertTrue(privateOfficePage.getPrivateOfficeHeadingText().contains("Личный кабинет"));
    }

    //Открытие вкладок из синей полосы меню
    @Test
    public void openOrganizationsPageTest(){
        OrganizationsPage organizationsPage = mainPage.clickOrganizationsButton();
        Assert.assertEquals("Справочник организаций", organizationsPage.getPageHeadingText());
        Assert.assertTrue(organizationsPage.hierarchyButtonIsDisplayed());
        Assert.assertTrue(organizationsPage.sphereActivityButtonIsDisplayed());
        Assert.assertTrue(organizationsPage.alphabetFilterListSize(20));
        Assert.assertTrue(organizationsPage.searchFieldIsDisplayed());
    }

    @Test
    public void openPaymentPageTest(){
        PaymentPage paymentPage = mainPage.clickPaymentButton();
        Assert.assertEquals("Оплата", paymentPage.getPageHeadingText());
        Assert.assertTrue(paymentPage.rosreestrButtonIsDisplayed());
        Assert.assertTrue(paymentPage.zsdButtonIsDisplayed());
        Assert.assertTrue(paymentPage.paymentListSize(9));

        paymentPage.clickPaymentList(0);
        Assert.assertTrue(paymentPage.paymentServicesListSize(60));
    }

    @Test
    public void openLegislationPageTest(){
        LegislationPage legislationPage = mainPage.clickLegislationButton();
        Assert.assertEquals("Справочник законодательства", legislationPage.getPageHeadingText());
        Assert.assertTrue(legislationPage.searchFieldIsDisplayed());
    }

    @Test
    public void openDocumentsBlanksPageTest(){
        DocumentsBlanksPage documentsBlanksPage = mainPage.clickDocumentsBlanksButton();
        Assert.assertEquals("Бланки документов", documentsBlanksPage.getPageHeadingText());
        Assert.assertTrue(documentsBlanksPage.searchFieldIsDisplayed());
        Assert.assertTrue(documentsBlanksPage.alphabetFilterListSize(21));
        Assert.assertTrue(documentsBlanksPage.menuSideListSize(8));
    }

    //Открыть и проверить каталог услуг
    @Test
    public void openServicesCatalogTest() {
        mainPage.clickServicesCatalogButton();

        Assert.assertTrue(mainPage.getServiceFromCatalogText(0).contains("Безопасность и право"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(1).contains("Бизнес"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(2).contains("Документы"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(3).contains("Здравоохранение"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(4).contains("Культура, спорт и туризм"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(5).contains("Налоги"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(6).contains("Недвижимость и ЖКХ"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(7).contains("Образование и наука"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(8).contains("Семья"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(9).contains("Социальное обеспечение"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(10).contains("Транспорт"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(11).contains("Трудовые отношения"));
        Assert.assertTrue(mainPage.getServiceFromCatalogText(12).contains("Полный список услуг"));
    }

    //Открыть каталог услуг и перейти в полный список услуг
    @Test
    public void openServicesListPageTest() {
        ServicesPage servicesPage = mainPage.clickServicesListButton();
        Assert.assertEquals("Полный список услуг", servicesPage.getServicesHeadingText());
        Assert.assertTrue(servicesPage.filterHeadingTextIsDisplayed());
        Assert.assertTrue(servicesPage.searchFieldIsDisplayed());
    }

    //Тесты на открытие услуг из карусели
    @Test
    public void openKindergartenServiceTest(){
        KindergartenPage kindergartenPage = mainPage.clickKindergartenServiceButton();
        Assert.assertEquals("Зачисление детей в государственные детские сады", kindergartenPage.getServiceHeadingText());
        Assert.assertTrue(kindergartenPage.eserviceMethodButtonIsDisplayed());
        Assert.assertTrue(kindergartenPage.mfcMethodButtonIsDisplayed());
        Assert.assertTrue(kindergartenPage.getServiceButtonIsDisplayed());
    }

    @Test
    public void openFirstGradeServiceTest(){
        FirstGradePage firstGradePage = mainPage.clickFirstGradeServiceButton();
        Assert.assertEquals("Зачисление в 1 класс следующего учебного года (2019 - 2020)", firstGradePage.getServiceHeadingText());
        Assert.assertTrue(firstGradePage.eserviceMethodButtonIsDisplayed());
        Assert.assertTrue(firstGradePage.mfcMethodButtonIsDisplayed());
        Assert.assertTrue(firstGradePage.getServiceButtonIsDisplayed());
    }

    @Test
    public void openRecordToDoctorServiceTest(){
        RecordToDoctorPage recordToDoctorPage = mainPage.clickRecordToDoctorServiceButton();
        Assert.assertEquals("Запись на прием к врачу", recordToDoctorPage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", recordToDoctorPage.getEserviceMethodButtonText());
        Assert.assertEquals("Традиционный способ", recordToDoctorPage.getTraditionalMethodButtonText());
        Assert.assertEquals("Общее описание", recordToDoctorPage.getServiceDescriptionHeadingText());
        Assert.assertEquals("7800000010000043551", recordToDoctorPage.getRegistryNumberText());
        Assert.assertTrue(recordToDoctorPage.getServiceButtonIsDisplayed());
        Assert.assertTrue(recordToDoctorPage.navbarCollectionSize(11));
    }

    @Test
    public void openParkingPermitServiceTest(){
        ParkingPermitPage parkingPermitPage = mainPage.clickParkingPermitServiceButton();
        Assert.assertEquals("О приеме заявлений на выдачу льготных парковочных разрешений", parkingPermitPage.getServiceHeadingText());
        Assert.assertTrue(parkingPermitPage.getCategoryListText(0).contains("проживающие в границах пилотной зоны"));
        Assert.assertTrue(parkingPermitPage.getCategoryListText(1).contains
                ("инвалиды I и II групп, законные представители ребенка-инвалида, а также лица, перевозящие инвалидов или детей-инвалидов"));
        Assert.assertTrue(parkingPermitPage.getCategoryListText(2).contains("один из родителей (усыновителей), опекунов (попечителей) в многодетной семье"));
    }

    @Test
    public void openMedicalPolicyServiceTest(){
        MedicalPolicyPage medicalPolicyPage = mainPage.clickMedicalPolicyServiceButton();

        Assert.assertEquals("Выдача полисов ОМС", medicalPolicyPage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", medicalPolicyPage.getEserviceMethodButtonText());
        Assert.assertEquals("МФЦ", medicalPolicyPage.getMfcMethodButtonText());
        Assert.assertEquals("Традиционный способ", medicalPolicyPage.getTraditionalMethodButtonText());

        Assert.assertTrue(medicalPolicyPage.getServiceButtonIsDisplayed());
        Assert.assertTrue(medicalPolicyPage.navbarCollectionSize(8));
    }

    @Test
    public void openHuntingTicketServiceTest(){
        HuntingTicketPage huntingTicketPage = mainPage.clickHuntingTicketServiceButton();

        Assert.assertEquals("Выдача и аннулирование охотничьих билетов единого федерального образца", huntingTicketPage.getServiceHeadingText());
        Assert.assertTrue(huntingTicketPage.eserviceMethodButtonIsDisplayed());
        Assert.assertTrue(huntingTicketPage.mfcMethodButtonIsDisplayed());
        Assert.assertTrue(huntingTicketPage.traditionalMethodButtonIsDisplayed());
        Assert.assertTrue(huntingTicketPage.getServiceButtonIsDisplayed());
    }

    @Test
    public void openChildPayoutServiceTest(){
        mainPage.serviceFromCarouselShouldBeDisplayed(187899);

        ChildPayoutPage childPayoutPage = mainPage.clickChildPayoutServiceButton();

        Assert.assertEquals("Единовременная компенсационная выплата при рождении ребенка", childPayoutPage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", childPayoutPage.getEserviceMethodButtonText());
        Assert.assertEquals("МФЦ", childPayoutPage.getMfcMEthodButtonText());
        Assert.assertEquals("Традиционный способ", childPayoutPage.getTraditionalMethodButtonText());
        Assert.assertEquals("Общее описание", childPayoutPage.getServiceDescriptionHeadingText());
        Assert.assertEquals("7800000010000005822", childPayoutPage.getRegistryNumberText());

        Assert.assertTrue(childPayoutPage.getServiceButtonIsDisplayed());
        Assert.assertTrue(childPayoutPage.navbarCollectionSize(11));
    }

    @Test
    public void openInnServiceTest(){
        mainPage.serviceFromCarouselShouldBeDisplayed(188297);

        InnPage innPage = mainPage.clickInnServiceButton();

        Assert.assertEquals("Узнай свой ИНН", innPage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", innPage.getEserviceMethodButtonText());

        Assert.assertTrue(innPage.getServiceButtonIsDisplayed());
        Assert.assertTrue(innPage.navbarCollectionSize(3));
    }

    @Test
    public void openTaxDebtServiceTest(){
        mainPage.serviceFromCarouselShouldBeDisplayed(188299);

        TaxDebtPage taxDebtPage = mainPage.clickTaxDebtServiceButton();

        Assert.assertEquals("Проверка налоговой задолженности", taxDebtPage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", taxDebtPage.getEserviceMethodButtonText());

        Assert.assertTrue(taxDebtPage.getServiceButtonIsDisplayed());
        Assert.assertTrue(taxDebtPage.navbarCollectionSize(5));
    }

    @Test
    public void openInternationalPassportServiceTest(){
        mainPage.serviceFromCarouselShouldBeDisplayed(188421);

        InternationalPassportPage internationalPassportPage = mainPage.clickInternationalPassportServiceButton();

        Assert.assertEquals("Выдача заграничного паспорта гражданина РФ", internationalPassportPage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", internationalPassportPage.getEserviceMethodButtonText());
        Assert.assertEquals("МФЦ", internationalPassportPage.getMfcMethodButtonText());
        Assert.assertEquals("Традиционный способ", internationalPassportPage.getTraditionalMethodButtonText());

        Assert.assertTrue(internationalPassportPage.getServiceButtonIsDisplayed());
        Assert.assertTrue(internationalPassportPage.navbarCollectionSize(10));
    }

    @Test
    public void openMotherCapitalServiceTest(){
        mainPage.serviceFromCarouselShouldBeDisplayed(187961);

        MotherCapitalPage motherCapitalPage = mainPage.clickMotherCapitalServiceButton();
        Assert.assertEquals("Рассмотрение заявлений о распоряжении средствами (частью средств) материнского (семейного) капитала",
                motherCapitalPage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", motherCapitalPage.getEserviceMethodButtonText());
        Assert.assertEquals("МФЦ", motherCapitalPage.getMfcMethodButtonText());
        Assert.assertEquals("Традиционный способ", motherCapitalPage.getTraditionalMethodButtonText());
        Assert.assertTrue(motherCapitalPage.getServiceButtonIsDisplayed());
        Assert.assertTrue(motherCapitalPage.navbarCollectionSize(10));
    }

    @Test
    public void openDataChangeCarownerServiceTest(){
        mainPage.serviceFromCarouselShouldBeDisplayed(448007);

        DataChangeCarownerPage dataChangeCarownerPage = mainPage.clickDataChangeCarownerServiceButton();

        Assert.assertEquals("Изменение данных собственника транспортного средства", dataChangeCarownerPage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", dataChangeCarownerPage.getEserviceMethodButtonText());

        Assert.assertTrue(dataChangeCarownerPage.getServiceButtonIsDisplayed());
        Assert.assertTrue(dataChangeCarownerPage.navbarCollectionSize(8));
    }

    @Ignore
    public void openPayGovernmentServiceTest(){
        mainPage.serviceFromCarouselShouldBeDisplayed(464211);

        PayGovernmentPage payGovernmentPage = mainPage.clickPayGovernmentServiceButton();
        Assert.assertEquals("Взаиморасчеты с государством", payGovernmentPage.getServiceHeadingText());
        Assert.assertEquals("Электронный способ", payGovernmentPage.getEserviceMethodButtonText());
        Assert.assertTrue(payGovernmentPage.getServiceButtonIsDisplayed());
        Assert.assertTrue(payGovernmentPage.navbarCollectionSize(4));
    }

    //Мобильные приложения
    @Test
    public void openMobileAppPageTest(){
        mainPage.mobileAppCShouldBeDisplayed();

        MobileAppPage mobileAppPage = mainPage.clickMobileAppButton();
        Assert.assertEquals("Мобильное приложение «Госуслуги Санкт‑Петербурга»", mobileAppPage.getMobileAppHeadingText());
    }

    @Test
    public void openAppStoreTest(){
        mainPage.mobileAppCShouldBeDisplayed();

        MobileAppPage mobileAppPage = mainPage.clickAppStoreButton();

        String url = driver.getCurrentUrl();

        Assert.assertEquals("Госуслуги Санкт-Петербурга 12+", mobileAppPage.getAppStoreHeadingText());
        Assert.assertEquals("https://itunes.apple.com/ru/app/gosuslugi-sankt-peterburga/id595073853", url);
    }

    @Test
    public void openGooglePlayTest(){
        mainPage.mobileAppCShouldBeDisplayed();

        MobileAppPage mobileAppPage = mainPage.clickGooglePlayButton();

        String url = driver.getCurrentUrl();

        Assert.assertEquals("Госуслуги Санкт-Петербурга", mobileAppPage.getGooglePlayHeadingText());
        Assert.assertEquals("https://play.google.com/store/apps/details?id=com.fls.gosuslugispb", url);
    }

    //МФЦ
    @Test
    public void openMfcPageTest(){
        MfcPage mfcPage = mainPage.clickMfcButton();
        Assert.assertEquals("УСЛУГИ ПО ЖИЗНЕННЫМ СИТУАЦИЯМ", mfcPage.getLifeServicesHeadingText());
        Assert.assertEquals("НОВОСТИ МФЦ", mfcPage.getMfcNewsHeadingText());
        Assert.assertEquals("ПОПУЛЯРНЫЕ УСЛУГИ МФЦ", mfcPage.getPopularServicesHeadingText());
        Assert.assertEquals("УСЛУГИ РОСРЕЕСТРА", mfcPage.getRosreestrServicesHeadingText());
        Assert.assertEquals("О МФЦ", mfcPage.getAboutMfcHeadingText());
        Assert.assertTrue(mfcPage.mfcMapIsDisplayed());
    }

}
