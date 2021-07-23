package elements.footer;

import org.openqa.selenium.By;

import elements.ContactUsFormWebElem;
import elements.FacebookWebElem;
// Class presenting the base footer web element
public abstract class AbstractFooterWebElem {

    protected static final By CONTACT_US_SELECTOR
    = By.xpath(".//button[contains(@class,'contact-label')]");
    protected static final By FACEBOOK_SELECTOR
    = By.xpath(".//a[contains(@href,'facebook')]");

    public abstract ContactUsFormWebElem getContactUsWebElement();
    public abstract FacebookWebElem getFacebookWebElem();
}
