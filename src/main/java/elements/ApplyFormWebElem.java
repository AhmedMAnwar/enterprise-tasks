package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Web element presenting apply form 
public final class ApplyFormWebElem {

    private final static By APPLY_FORM_SELECTOR = By.id("join_us_form");
    private static final By NAME_SELECTOR = By.name("your-name");
    private static final By EMAIL_SELECTOR = By.name("your-email");
    private static final By MOBILE_SELECTOR = By.name("mobile-number");
    private static final By UPLOAD_CV_SELECTOR = By.name("uploadtextfield");
    private static final By LINKDIN_SELECTOR = By.name("linkedin");
    private static final By SEND_SELECTOR = By.xpath(".//input[@value = 'Send']");
    private static final By CLOSE_BUTTON_SELECTOR = By.id("fancybox-close");

    private final WebDriver driver;

    public final WebElement applyFormWebElement;

    private final WebElement nameElement;
    private final WebElement emailElement;
    private final WebElement numberElement;
    private final WebElement ulpoadCVElement;
    private final WebElement linkdinElement;

    public ApplyFormWebElem(WebDriver driver) {
        if(driver == null)
            throw new IllegalArgumentException();

        this.driver = driver;
        this.applyFormWebElement = driver.findElement(APPLY_FORM_SELECTOR);
        this.nameElement = applyFormWebElement.findElement(NAME_SELECTOR);
        this.emailElement = applyFormWebElement.findElement(EMAIL_SELECTOR);
        this.numberElement = applyFormWebElement.findElement(MOBILE_SELECTOR);
        this.ulpoadCVElement
            = applyFormWebElement.findElement(UPLOAD_CV_SELECTOR);
        this.linkdinElement = applyFormWebElement.findElement(LINKDIN_SELECTOR);
    }

    public void fillOutApplyForm(String name, String email, String number,
                                   String cv, String linkdinProfile) {
        clearFields();
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        numberElement.sendKeys(number);
        ulpoadCVElement.sendKeys(cv);
        linkdinElement.sendKeys(linkdinProfile);
        WebElement sendButtonElement
            = applyFormWebElement.findElement(SEND_SELECTOR);
        sendButtonElement.click();
    }

    public void clearFields() {
        nameElement.clear();
        emailElement.clear();
        numberElement.clear();
        emailElement.clear();
        ulpoadCVElement.clear();
        linkdinElement.clear();
    }

    public void closeForm() {
        driver.findElement(CLOSE_BUTTON_SELECTOR).click();
    }

    public ErrorMessageWebElem getErrorMessageWebElement() {
        return new ErrorMessageWebElem(driver, applyFormWebElement);
    }

    public final class ErrorMessageWebElem {

        private final By ERROR_MESSAGE_ROOT_SELECTOR
            = By.className("message-form");
        private final By ERROR_MESSAGE_SELECTOR
            = By.className("wpcf7-response-output");
        private final By CLOSE_ERROR_MESSAGE_SELECTOR
            = By.className("close-form");

        private final WebElement errorMessageRootWebElement;
        private final WebDriverWait driver;

        public ErrorMessageWebElem(WebDriver driver, WebElement element) {
            if(driver == null)
                throw new IllegalArgumentException();

            this.driver = new WebDriverWait(driver, 5);
            this.errorMessageRootWebElement
                = element.findElement(ERROR_MESSAGE_ROOT_SELECTOR);
        }

        public boolean isErrorMessageFired() {
            WebElement errorMessagWebElement
                = driver.until(ExpectedConditions.visibilityOf
                               (errorMessageRootWebElement
                                .findElement(ERROR_MESSAGE_SELECTOR)));
            WebElement closeButtonWebElement
                = driver.until(ExpectedConditions.visibilityOf
                               (errorMessageRootWebElement
                                .findElement(CLOSE_ERROR_MESSAGE_SELECTOR)));
                if (errorMessagWebElement.isDisplayed()) {
                    closeButtonWebElement.click();
                    return true;
                }
                return false;
        }
    }
}
