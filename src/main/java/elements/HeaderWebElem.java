package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//This presenting the header section of website
public final class HeaderWebElem {

    private static final By HEADER_SELECTOR = By.id("navbar");
    private static final By COMPANY_SELECTOR
        = By.xpath(".//a[contains(@href,'company')]");
    private static final By CAREER_SELECTOR
        = By.xpath(".//a[contains(@href,'careers')]");

    WebDriver driver;
    public WebElement headerWebElement;

    public HeaderWebElem(WebDriver driver) {
        if(driver == null)
            throw new IllegalArgumentException();

        this.driver = driver;
        this.headerWebElement = driver.findElement(HEADER_SELECTOR);
    }

    public CompanyWebElem getCompanyWebElement() {
        WebElement companyWebElement
            = headerWebElement.findElement(COMPANY_SELECTOR);
        WebElementUtilis.clickOnElementByScript(driver, companyWebElement);
        return new CompanyWebElem(driver);
    }

    public CareerWebElem getCareerWebElement() {
        WebElement careerWebElement
            = headerWebElement.findElement(CAREER_SELECTOR);
        WebElementUtilis.clickOnElementByScript(driver, careerWebElement);
        return new CareerWebElem(driver);
    }
}
