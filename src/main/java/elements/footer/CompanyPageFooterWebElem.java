package elements.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.ContactUsFormWebElem;
import elements.FacebookWebElem;
import elements.HeaderWebElem;
import elements.WebElementUtilis;

// Class presenting the footer of company page
public final class CompanyPageFooterWebElem extends AbstractFooterWebElem{

    private static final By COMPANY_PAGE_FOOTER_SELECTOR
        = By.className("footer-links");

    private final WebDriver driver;
    private final WebElement companyPageFooterWebElement;

    public CompanyPageFooterWebElem(WebDriver driver) {
        if(driver == null)
            throw new IllegalArgumentException();

        this.driver = driver;
        this.companyPageFooterWebElement
            = driver.findElement(COMPANY_PAGE_FOOTER_SELECTOR);
        WebElementUtilis.scrollToView(driver, companyPageFooterWebElement);
    }

    @Override
    public ContactUsFormWebElem getContactUsWebElement() {
     // to be implemented
        return null;
    }

    @Override
    public FacebookWebElem getFacebookWebElem() {
        WebElement facebookElement
            = companyPageFooterWebElement.findElement(FACEBOOK_SELECTOR);
        HeaderWebElem headerWebElement = new HeaderWebElem(driver);
        WebElementUtilis.waitUnitlVisbilityOfElement
            (driver, headerWebElement.headerWebElement);
        facebookElement.click();
        return new FacebookWebElem(driver);
    }
}
