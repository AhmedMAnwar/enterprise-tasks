import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.ChromeDriverExecuter;
import elements.CompanyWebElem;
import elements.FacebookWebElem;
import elements.HomeWebElem;

// Company test cases. 
public final class CompanyTest extends TestSuiteConfiguration{

    WebDriver driver;

    ChromeDriverExecuter chromerDriverExecuter;
    HomeWebElem homewebElement;
    CompanyWebElem companyWebElement;
    FacebookWebElem faceBookWebElement;

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browserName) {
        driver = getDriverInstance(browserName);

        homewebElement = new HomeWebElem(driver);
        companyWebElement
            = homewebElement.getHeaderWebElement().getCompanyWebElement();
    }

    @Test(priority = 1)
    public void isCompanyUrlLoaded() {
        assertEquals(companyWebElement.getCompanyPageUrl(),
                     propertiesFile.getCompanyUrl(),
                     "Company page is not loaded properly");
    }

    @Test(priority = 2)
    public void isLeadershipSectionExist() {
        assertEquals(companyWebElement.getLeaderShipWebElement()
                         .isMemeberExist(), true,
                     "Leadership section doesn't exist in comapany page");
    }

    @Test(priority = 3)
    public void isFacebookUrlLoaded() {
        faceBookWebElement = companyWebElement.getCompanyPageFooterWebElement()
            .getFacebookWebElem();
        assertEquals(faceBookWebElement.getUrl(),
                     propertiesFile.getFacebookUrl(),
                     "Facebook Url is not loaded");
    }

    @Test(priority = 4)
    public void isMusalaProfileImageExist() {
        assertEquals(faceBookWebElement.isMusalaProfilePictureDisplayed(), true,
                     "Musala pofile icon doesn't exist in Facebook page");
    }

      @AfterClass 
      public void afterClass() {
          driver.quit();
      }

}
