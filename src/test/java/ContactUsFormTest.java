import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import elements.ContactUsFormWebElem;
import elements.HomeWebElem;

// Contact us test cases
public final class ContactUsFormTest extends TestSuiteConfiguration{

    WebDriver driver;

    HomeWebElem homewebElement;
    ContactUsFormWebElem contactUsWebElement;

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browserName) {
        driver = getDriverInstance(browserName);

        homewebElement = new HomeWebElem(driver);
        contactUsWebElement
            = homewebElement.getFooterWebElement().getContactUsWebElement();
    }

    @Test(dataProvider = "ContactUsFormDataProvider")
    public void testInvalidEmailAddress(String name, String email, String number,
                                        String subject, String message) {
        contactUsWebElement.fillOutContactForm(name, email, number, subject,
                                               message);
        assertEquals(contactUsWebElement.getErrrormessage(),
                     "The e-mail address entered is invalid.",
                     "No warning message for invalid email address");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @DataProvider(name="ContactUsFormDataProvider")
    public String[][] getDataFromDataprovider(){
    return new String[][]
        {
            { "test1", "test", "00201067721442", "test", "test" },
            { "test1", "test@", "00201067721442", "test", "test" },
            { "test1", "test@gmail", "00201067721442", "test", "test" },
            { "test1", "test.com", "00201067721442", "test", "test" },
            { "test1", "test@/gamil.com", "00201067721442", "test", "test" }
        };

    }

}
