import BasePackage.ConciseAPI;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest extends ConciseAPI {

    public WebDriver driver;
    public ChromeOptions options = new ChromeOptions();

    @Override
    public WebDriver getWebDriver() { return driver; }

    @Before
    public void setUp() throws Exception {

        //Work computer

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\skubyev\\IdeaProjects\\Infoportal\\drivers\\chromedriver.exe");
        options.addArguments("user-data-dir=C:\\Users\\skubyev\\AppData\\Local\\Google\\Chrome\\User Data");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //Home computer

        /*System.setProperty("webdriver.chrome.driver", "/Users/skubev/IdeaProjects/gu.spb.ru/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();*/

        //System.setProperty("webdriver.gecko.driver", "/Users/skubev/IdeaProjects/gu.spb.ru/drivers/geckodriver");
        //driver = new FirefoxDriver();

        //Remote Jenkins
        /*driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.chrome());
        driver = webdriver.Remote("http://localhost:4444/wd/hub", webdriver.DesiredCapabilities.FIREFOX);*/
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
