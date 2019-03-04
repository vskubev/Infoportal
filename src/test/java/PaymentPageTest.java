import Pages.AuthPage;
import Pages.PaymentPages.PaymentInteractivePage;
import Pages.PaymentPages.PaymentPage;
import Utils.ConfigProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaymentPageTest extends BaseTest {

    private PaymentPage paymentPage;

    @Before
    public void setUpClass() {
        open(ConfigProperties.getTestProperty("url") + "/payment/");
        paymentPage = new PaymentPage(driver);
    }

    @Test
    public void openZsdPaymentPageTest(){
        AuthPage authPage = paymentPage.clickZsdButton();
        Assert.assertTrue(authPage.authorizeButtonIsDisplayed());

        authPage.authorization(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));

        PaymentInteractivePage paymentInteractivePage = authPage.clickSignInButtonFromPaymentPage();
        Assert.assertEquals("Оплата услуг Западного скоростного диаметра", paymentInteractivePage.getPageHeadingText());
        Assert.assertTrue(paymentInteractivePage.payZsdButtonIsDisplayed());

        paymentInteractivePage.clickLogoutButton();
    }

    @Test
    public void openRosreestrPaymentPageTest(){
        AuthPage authPage = paymentPage.clickRosreestrButton();
        Assert.assertTrue(authPage.authorizeButtonIsDisplayed());

        authPage.authorization(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));

        PaymentInteractivePage paymentInteractivePage = authPage.clickSignInButtonFromPaymentPage();
        Assert.assertEquals("Оплата услуг Росреестра", paymentInteractivePage.getPageHeadingText());
        Assert.assertTrue(paymentInteractivePage.payRosreestrButtonIsDisplayed());

        paymentInteractivePage.clickLogoutButton();
    }

}
