package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Utilis class helping other web elements
public class WebElementUtilis {

    static WebDriverWait webDriverWait;

    public static void scrollToView(WebDriver driver, WebElement webElement) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static void clickOnElementByScript(WebDriver driver,
                                              WebElement webElement) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", webElement);
    }

    public static WebElement waitUnitlVisbilityOfElement(WebDriver driver,
                                                        WebElement webElement) {
        webDriverWait = new WebDriverWait(driver, 10);
        WebElement newWebElement
            = webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        if(newWebElement.isDisplayed() == true)
            return newWebElement;

        return null;
    }

    public static WebElement waitUnitlVisbilityOfElement(WebDriver driver,
                                                  By selector) {
        webDriverWait = new WebDriverWait(driver, 10);
        WebElement newWebElement
            = webDriverWait.until(ExpectedConditions
                                      .visibilityOfElementLocated(selector));
        if(newWebElement.isDisplayed() == true)
            return newWebElement;

        return null;
    }

    public static WebElement waitUnitlElementToBeClickable(WebDriver driver,
                                                        WebElement webElement) {
        webDriverWait = new WebDriverWait(driver, 10);
        WebElement newWebElement
            = webDriverWait.until(ExpectedConditions
                                      .elementToBeClickable(webElement));
        scrollToView(driver, newWebElement);
        return newWebElement;
    }

    public static boolean ivisibilityOfElement(WebDriver driver,
                                                  WebElement webElement) {
        webDriverWait = new WebDriverWait(driver, 5);
        return webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static boolean isStale(WebElement webElement, By selector) {
        try {
            webElement.findElement(selector);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
