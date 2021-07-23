package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.footer.CompanyPageFooterWebElem;

// Class presenting the company page web element
public final class CompanyWebElem {

    private static final By COMPANY_SELECTOR = By.id("company");

    private WebDriver driver;
    private WebElement companyWebElement;

    public CompanyWebElem(WebDriver driver) {
        if(driver == null)
            throw new IllegalArgumentException();

        this.driver = driver;
        this.companyWebElement = WebElementUtilis
                .waitUnitlVisbilityOfElement(driver, COMPANY_SELECTOR);
    }

    public String getCompanyPageUrl() {
        return driver.getCurrentUrl();
    }

    public LeadershipWebElem getLeaderShipWebElement() {
        return new LeadershipWebElem(driver, companyWebElement);
    }

    public CompanyPageFooterWebElem getCompanyPageFooterWebElement() {
        return new CompanyPageFooterWebElem(driver);
    }
}
