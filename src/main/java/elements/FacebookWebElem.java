package elements;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// web element presenting facebook web element
public final class FacebookWebElem {

    private static final By FACEBOOK_ROOT_SELECTOR = By.className("_li");
    private static final By IMAGE_SELECTOR
        = By.xpath(".//a[@aria-label]/div/img");

    private final WebDriver driver;
    private final WebElement facebookRootWebElement;

    private ArrayList<String> tabs;

    public FacebookWebElem(WebDriver driver) {
        if(driver == null)
            throw new IllegalArgumentException();

        this.driver = driver;
        this.tabs = new ArrayList<String>();
        tabs.addAll(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // 1 presenting facebook page
        this.facebookRootWebElement = driver.findElement(FACEBOOK_ROOT_SELECTOR);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isMusalaProfilePictureDisplayed() {
        WebElement imagewWebElement
            = facebookRootWebElement.findElement(IMAGE_SELECTOR);
        String imageSrc = imagewWebElement.getAttribute("src");
        if(!(imageSrc.isEmpty()) && imagewWebElement.isDisplayed() == true)
            return true;
        else
            return false;
    }
}
