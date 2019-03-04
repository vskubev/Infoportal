package BasePackage;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    public <V> V assertThat(Function<? super WebDriver, V> condition){
        return (new WebDriverWait(getWebDriver(), 10)).until(condition);
    }

    public WebElement $(By locator){
        return assertThat(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement $(WebElement element){
        return assertThat(ExpectedConditions.visibilityOf(element));
    }

    public void invisibilityElementsWait(By locator){
        assertThat(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void invisibilityElementsWait(By locator1, By locator2){
        assertThat(ExpectedConditions.invisibilityOfElementLocated(locator1));
        assertThat(ExpectedConditions.invisibilityOfElementLocated(locator2));
    }

    public void open(String url){
        getWebDriver().get(url);
    }

    public boolean isElementPresent(By locator){
        try {
            getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            getWebDriver().findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } finally{
            getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

}
