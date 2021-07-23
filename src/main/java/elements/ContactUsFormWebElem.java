package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Web element presenting contact us form
public final class ContactUsFormWebElem {

    private static final By CONTACT_SELECTOR = By.id("contact_form_pop");
    private static final By NAME_SELECTOR = By.name("your-name");
    private static final By EMAIL_SELECTOR = By.name("your-email");
    private static final By MOBILE_SELECTOR = By.name("mobile-number");
    private static final By SUBJECT_SELECTOR = By.name("your-subject");
    private static final By MESSAGE_SELECTOR = By.name("your-message");
    private static final By SEND_SELECTOR = By.xpath(".//input[@value = 'Send']");
    private static final By ERROR_SELECTOR = By.className("wpcf7-not-valid-tip");

    private WebDriver driver;

    private WebElement contactFormWebElement;
    private WebElement nameElement;
    private WebElement emailElement;
    private WebElement numberElement;
    private WebElement subjectElement;
    private WebElement messageElement;

    public ContactUsFormWebElem(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException();
        }

        this.driver = driver;
        this.contactFormWebElement = driver.findElement(CONTACT_SELECTOR);
        this.nameElement = contactFormWebElement.findElement(NAME_SELECTOR);
        this.emailElement = contactFormWebElement.findElement(EMAIL_SELECTOR);
        this.numberElement = contactFormWebElement.findElement(MOBILE_SELECTOR);
        this.subjectElement = contactFormWebElement.findElement(SUBJECT_SELECTOR);
        this.messageElement = contactFormWebElement.findElement(MESSAGE_SELECTOR);
    }

    public void fillOutContactForm(String name, String email, String number,
                                   String subject, String message) {
        clearFields();
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        numberElement.sendKeys(number);
        subjectElement.sendKeys(subject);
        messageElement.sendKeys(message);
        WebElement sendButtonElement
            = contactFormWebElement.findElement(SEND_SELECTOR);
        sendButtonElement.click();
    }

    public void clearFields() {
        nameElement.clear();
        emailElement.clear();
        numberElement.clear();
        emailElement.clear();
        subjectElement.clear();
        messageElement.clear();
    }

    public String getErrrormessage() {
        WebDriverWait driverWait = new WebDriverWait(driver, 2);
        WebElement errorMessagElement
            = driverWait.until
            (ExpectedConditions.visibilityOfElementLocated(ERROR_SELECTOR));
        return errorMessagElement.getText();
    }
}
