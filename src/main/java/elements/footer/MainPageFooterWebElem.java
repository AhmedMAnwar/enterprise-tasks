package elements.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.ContactUsFormWebElem;
import elements.FacebookWebElem;
import elements.WebElementUtilis;

// Class presenting the footer of home page
public final class MainPageFooterWebElem extends AbstractFooterWebElem {

    private static final By MAIN_PAGE_FOOTER_SELECTOR = By.className("contacts");

    private WebElement MainPageFooterWebElement;
    private WebDriver driver;
    
    public MainPageFooterWebElem(WebDriver driver, WebElement webElement) {
        if (driver ==  null)
            throw new IllegalArgumentException();

        this.driver = driver;
        this.MainPageFooterWebElement
            = webElement.findElement(MAIN_PAGE_FOOTER_SELECTOR);
        WebElementUtilis.scrollToView(driver, MainPageFooterWebElement);
    }

    @Override
    public ContactUsFormWebElem getContactUsWebElement() {
        WebElement contactUsElement
            = MainPageFooterWebElement.findElement(CONTACT_US_SELECTOR);
        contactUsElement.click();
        return new ContactUsFormWebElem(driver);
    }

    @Override
    public FacebookWebElem getFacebookWebElem() {
        // TODO Auto-generated method stub
        return null;
    }

}
