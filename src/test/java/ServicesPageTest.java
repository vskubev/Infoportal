import Pages.MainPage;
import Pages.ServicesCategoryPages;
import Pages.ServicesPage;
import Pages.ServicesPages.ResidentParkingPermitServicePage;
import Utils.ConfigProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ServicesPageTest extends BaseTest {

    private ServicesPage servicesPage;

    @Before
    public void setUpClass(){
        open(ConfigProperties.getTestProperty("url") + "/services/");
        servicesPage = new ServicesPage(driver);
    }

    //Тесты на блок фильтров
    @Test
    public void onlinePhysicalPersonIncompleteFamilyCheckboxesTest(){
        servicesPage.clickSmartFilterList(0, 3, 14);

        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Выдача справок для получения государственной социальной стипендии", servicesPage.getServiceText(188121));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Денежные выплаты на оплату жилого помещения и коммунальных услуг отдельным категориям граждан", servicesPage.getServiceText(188209));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячная доплата к пенсии по случаю потери кормильца", servicesPage.getServiceText(187889));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячная компенсационная выплата детям из многодетных семей, получающим пенсию по потере кормильца", servicesPage.getServiceText(187925));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячная социальная выплата студенческой семье", servicesPage.getServiceText(187931));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячное пособие на ребенка в возрасте от 1,5 до 7 лет", servicesPage.getServiceText(187911));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячное пособие на ребенка в возрасте от рождения до 1,5 лет", servicesPage.getServiceText(187897));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячное пособие на ребенка школьного возраста", servicesPage.getServiceText(187901));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Компенсация за вред, нанесенный здоровью вследствие чернобыльской катастрофы, компенсация на оздоровление и компенсации семьям за потерю кормильца",
                servicesPage.getServiceText(188081));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Компенсация по оплате жилых помещений, коммунальных услуг, услуг телефонной связи членам семей погибших военнослужащих", servicesPage.getServiceText(188203));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Невзимание родительской платы за присмотр и уход за детьми в образовательных организациях, компенсация части родительской платы за присмотр и " +
                        "уход за детьми в образовательных организациях", servicesPage.getServiceText(188379));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Организация временного трудоустройства", servicesPage.getServiceText(188261));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Организация проведения оплачиваемых общественных работ", servicesPage.getServiceText(188253));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Предоставление объектов государственного дачного фонда", servicesPage.getServiceText(188139));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ремонт индивидуальных жилых домов, принадлежащих членам семей военнослужащих, потерявшим кормильца", servicesPage.getServiceText(188205));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Социальная адаптация безработных граждан на рынке труда", servicesPage.getServiceText(188247));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Социальные выплаты для приобретения или строительства жилых помещений по целевой программе «Молодежи — доступное жилье»", servicesPage.getServiceText(188475));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Социальные выплаты для приобретения или строительства жилых помещений по целевой программе «Развитие долгосрочного жилищного кредитования в Санкт-Петербурге»",
                servicesPage.getServiceText(188477));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Экстренная социальная помощь", servicesPage.getServiceText(188127));
    }

    @Test
    public void traditionalLegalPersonMilitaryPersonnelCheckboxes(){
        servicesPage.clickSmartFilterList(2, 4, 6);

        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Прием заявлений на получение льгот по налогам", servicesPage.getServiceText(188327));
    }

    @Test
    public void withMfcLegalPersonRadioactivityPersonCheckboxesTest(){
        servicesPage.clickSmartFilterList(1, 4, 10);

        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Прием заявлений на получение льгот по налогам", servicesPage.getServiceText(188327));
    }

    @Test
    public void onlinePhysicalPersonLargeFamilyCheckboxesTest(){
        servicesPage.clickSmartFilterList(0, 3, 13);

        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ведение жилищных учётов нуждающихся в жилых помещениях (улучшении жилищных условий)", servicesPage.getServiceText(188505));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Внесение в Реестр записи о парковочном разрешении многодетной семьи", servicesPage.getServiceText(188875));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Выдача направлений на бесплатное зубопротезирование для отдельных категорий граждан", servicesPage.getServiceText(188085));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Выдача свидетельства многодетной семьи", servicesPage.getServiceText(188029));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Выдача справок для получения государственной социальной стипендии", servicesPage.getServiceText(188121));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежегодная компенсационная выплата на детей из многодетных семей", servicesPage.getServiceText(187907));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячная денежная выплата семьям при рождении третьего или последующих детей в период с 1 января 2013 года до достижения ребенком 3 лет",
                servicesPage.getServiceText(187941));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячная компенсационная выплата детям из многодетных семей, получающим пенсию по потере кормильца", servicesPage.getServiceText(187925));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячная социальная выплата матерям, родившим (усыновившим) и воспитавшим 5 и более детей и получающим пенсию", servicesPage.getServiceText(187919));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячное пособие на ребенка в возрасте от 1,5 до 7 лет", servicesPage.getServiceText(187911));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячное пособие на ребенка в возрасте от рождения до 1,5 лет", servicesPage.getServiceText(187897));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячное пособие на ребенка школьного возраста", servicesPage.getServiceText(187901));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Организация временного трудоустройства", servicesPage.getServiceText(188261));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Организация проведения оплачиваемых общественных работ", servicesPage.getServiceText(188253));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Предоставление многодетным семьям земельных участков для индивидуального жилищного или дачного строительства", servicesPage.getServiceText(188493));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Предоставление многодетным семьям транспортного средства", servicesPage.getServiceText(187973));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Предоставление объектов государственного дачного фонда", servicesPage.getServiceText(188139));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Рассмотрение заявлений о распоряжении средствами (частью средств) материнского (семейного) капитала", servicesPage.getServiceText(187961));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Сертификат «Материнский (семейный) капитал в Санкт-Петербурге»", servicesPage.getServiceText(187963));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Социальная адаптация безработных граждан на рынке труда", servicesPage.getServiceText(188247));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Социальные выплаты гражданам для приобретения или строительства жилых помещений", servicesPage.getServiceText(188487));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Социальные выплаты для приобретения или строительства жилых помещений по целевой программе «Развитие долгосрочного жилищного кредитования в Санкт-Петербурге»",
                servicesPage.getServiceText(188477));
    }

    @Test
    public void onlinePhysicalPersonOrphansCheckboxesTest(){
        servicesPage.clickSmartFilterList(0, 3, 7);

        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Возмещение расходов на обучение детей-сирот и детей, оставшихся без попечения родителей", servicesPage.getServiceText(187997));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Возмещение стоимости проезда к месту отдыха, лечения и обратно детям-сиротам", servicesPage.getServiceText(188001));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Выдача справок для получения государственной социальной стипендии", servicesPage.getServiceText(188121));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Единовременное денежное пособие и компенсация на покупку одежды, обуви, мягкого инвентаря и оборудования детям-сиротам и детям, оставшимся без попечения родителей",
                servicesPage.getServiceText(188003));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Единовременное пособие выпускникам образовательных учреждений из числа детей-сирот и детей, оставшихся без попечения родителей, при поступлении в образовательные учреждения",
                servicesPage.getServiceText(188005));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Единовременное пособие при передаче ребенка в семью за счет средств бюджета Санкт-Петербурга", servicesPage.getServiceText(188011));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Единовременное пособие при передаче ребенка на воспитание в семью (за счет средств федерального бюджета)", servicesPage.getServiceText(187993));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежегодное пособие на приобретение учебной литературы и письменных принадлежностей детям-сиротам и детям, оставшимся без попечения родителей",
                servicesPage.getServiceText(188007));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячная денежная компенсация на питание детей в образовательных организациях", servicesPage.getServiceText(187935));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячная пожизненная денежная компенсация лицам, подвергшимся политическим репрессиям и впоследствии реабилитированным", servicesPage.getServiceText(188119));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Невзимание родительской платы за присмотр и уход за детьми в образовательных организациях, компенсация части родительской платы за присмотр и уход за детьми в образовательных организациях",
                servicesPage.getServiceText(188379));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Оплата жилого помещения и коммунальных услуг детям-сиротам и детям, оставшимся без попечения родителей", servicesPage.getServiceText(188213));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Оформление бесплатного проезда к месту жительства и обратно к месту учебы детям-сиротам", servicesPage.getServiceText(187999));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Предоставление жилых помещений специализированного жилищного фонда в домах системы социального обслуживания населения лицам, нуждающимся в постоянном уходе и наблюдении",
                servicesPage.getServiceText(188539));
    }

    @Test
    public void traditionalLegalPersonPoorFamilyCheckboxesTest(){
        servicesPage.clickSmartFilterList(2, 4, 12);

        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Продажа гражданам жилых помещений государственного жилищного фонда Санкт-Петербурга целевым назначением", servicesPage.getServiceText(188515));
    }

    @Test
    public void onlinePhysicalPersonRepressionPersonCheckboxesTest(){
        servicesPage.clickSmartFilterList(0, 3, 11);

        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Выдача направлений на бесплатное зубопротезирование для отдельных категорий граждан", servicesPage.getServiceText(188085));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Выдача путевок на оздоровительный отдых различным категориям граждан", servicesPage.getServiceText(188089));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Выдача удостоверения бывшим несовершеннолетним узникам концлагерей", servicesPage.getServiceText(188035));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Денежные выплаты на оплату жилого помещения и коммунальных услуг отдельным категориям граждан", servicesPage.getServiceText(188209));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Единовременная денежная выплата на погребение", servicesPage.getServiceText(188131));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Ежемесячная пожизненная денежная компенсация лицам, подвергшимся политическим репрессиям и впоследствии реабилитированным", servicesPage.getServiceText(188119));
    }

    @Test
    public void withMfcLegalPersonDisabledCheckboxesTest(){
        servicesPage.clickSmartFilterList(1, 4, 8);

        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Прием заявлений на получение льгот по налогам", servicesPage.getServiceText(188327));
    }

    @Test
    public void withMfcLegalPersonVeteranWowCheckboxesTest(){
        servicesPage.clickSmartFilterList(1, 4, 15);

        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Прием заявлений на получение льгот по налогам", servicesPage.getServiceText(188327));
    }

    @Test
    public void traditionalPhysicalPersonConsumerRightsProtectionCheckboxesTest(){
        servicesPage.clickSmartFilterList(2, 3, 9);

        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Консультирование жителей муниципального образования по вопросам создания ТСЖ и формирования земельных участков", servicesPage.getServiceText(188241));
    }

    //Тесты на строку поиска и фильтрацию
    @Test
    public void searchFieldTest(){
        String searchQuery = "заграничного паспорта";
        servicesPage.typeSearchField(searchQuery);
        Assert.assertTrue(servicesPage.getServiceText(188421).contains(searchQuery));
        Assert.assertTrue(servicesPage.getServiceText(330515).contains(searchQuery));
    }

    @Test
    public void searchFieldFilterAlphabetTest(){
        servicesPage.clickFilterAlphabetIfArrow();
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Аккредитация региональных спортивных федераций", servicesPage.getServiceText(188823));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Аккредитация экскурсоводов и гидов-переводчиков", servicesPage.getServiceText(188729));

        servicesPage.clickFilterAlphabet();
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Экстренная социальная помощь", servicesPage.getServiceText(188127));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Экспертиза ценности документов", servicesPage.getServiceText(188391));
    }

    @Test
    public void searchFieldFilterByPopularTest(){
        servicesPage.clickFilterPopularityButton();
        Assert.assertTrue(servicesPage.isArrowDownPopularityButtonPresent());

        servicesPage.clickFilterPopularityButton();
        Assert.assertTrue(servicesPage.isArrowUpPopularityButtonPresent());
    }

    //Тесты на категории услуг
    @Test
    public void servicesCategoryTest(){
        ServicesCategoryPages servicesCategoryPages = servicesPage.clickCategory(0);
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Внесение исправлений и изменений в записи актов гражданского состояния", servicesCategoryPages.getCivilStatusActServiceText(0));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Выдача (высылка) повторных свидетельств и справок о государственной регистрации актов гражданского состояния", servicesCategoryPages.getCivilStatusActServiceText(1));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Государственная регистрация заключения брака", servicesCategoryPages.getCivilStatusActServiceText(2));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Государственная регистрация перемены имени", servicesCategoryPages.getCivilStatusActServiceText(3));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Государственная регистрация расторжения брака", servicesCategoryPages.getCivilStatusActServiceText(4));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Государственная регистрация рождения", servicesCategoryPages.getCivilStatusActServiceText(5));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Государственная регистрация смерти", servicesCategoryPages.getCivilStatusActServiceText(6));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Государственная регистрация установления отцовства", servicesCategoryPages.getCivilStatusActServiceText(7));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Государственная регистрация усыновления (удочерения)", servicesCategoryPages.getCivilStatusActServiceText(8));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Истребование личных документов о государственной регистрации актов гражданского состояния", servicesCategoryPages.getCivilStatusActServiceText(9));
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Проставление апостиля на документах, выданных органами записи актов гражданского состояния", servicesCategoryPages.getCivilStatusActServiceText(10));
    }

    //Тесты выбора и проверки страницы услуги
    @Test
    public void openServiceInfoPageTest(){
        ResidentParkingPermitServicePage residentParkingPermitServicePage = servicesPage.clickServiceButton(188871);
        Assert.assertEquals("Ожидаемое и фактическое наименование услуги не совпадают",
                "Внесение в Реестр записи о парковочном разрешении жителя", residentParkingPermitServicePage.getServiceHeadingText());
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
