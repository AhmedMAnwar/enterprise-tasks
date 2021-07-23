package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.footer.MainPageFooterWebElem;

// Web element presenting the home page of musala web application
public class HomeWebElem {

    private static final By HOME_SELECTOR = By.tagName("main");

    private WebDriver driver;

    private WebElement homElement;

    public HomeWebElem(WebDriver driver) {
        if(driver == null) {
            throw new IllegalArgumentException();
        }
        this.driver = driver;
        this.homElement = driver.findElement(HOME_SELECTOR);
    }

    public HeaderWebElem getHeaderWebElement() {
        return new HeaderWebElem(driver);
    }

    public MainPageFooterWebElem getFooterWebElement() {
        return new MainPageFooterWebElem(driver, homElement);
    }
}
