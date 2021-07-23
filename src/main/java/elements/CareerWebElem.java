package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Class presenting the career page web element
public final class CareerWebElem {

    private static final By CAREER_ROOT_SELECTOR = By.id("careers");
    private static final By CHECK_OUR_POSITION_BUTTON_SELECTOR
        = By.xpath("(//a[contains(@href,'join-us')])[2]");

    private final WebDriver driver;
    private final WebElement careerWebElement;

    public CareerWebElem(WebDriver driver) {
        if(driver == null)
            throw new IllegalArgumentException();

        this.driver = driver;
        this.careerWebElement = driver.findElement(CAREER_ROOT_SELECTOR);
    }

    public JoinUsWebElem getJoinUsWebElement() {
        WebElement joinUsWebElement
            = careerWebElement.findElement(CHECK_OUR_POSITION_BUTTON_SELECTOR);
        joinUsWebElement.click();
        return new JoinUsWebElem(driver);
    }

}
