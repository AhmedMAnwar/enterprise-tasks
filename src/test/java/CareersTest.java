import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.ChromeDriverExecuter;
import elements.ApplyFormWebElem;
import elements.ApplyFormWebElem.ErrorMessageWebElem;
import elements.HomeWebElem;
import elements.JobPositionPageWebElem;
import elements.JoinUsWebElem;

//Careers test cases
public final class CareersTest extends TestSuiteConfiguration{

    private static final String LOCATION_NAME = "Anywhere";
    private static final String POSITION_NAME
        = "Experienced Automation QA Engineer";
    private static final String CV_LINK = "src/test/resources/dummyfile";

    WebDriver driver;

    ChromeDriverExecuter chromerDriverExecuter;
    HomeWebElem homewebElement;
    JoinUsWebElem joinUsWebElement;
    JobPositionPageWebElem jobPositionPageWebElement;

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browserName) {
        driver = getDriverInstance(browserName);

        homewebElement = new HomeWebElem(driver);
        joinUsWebElement
            = homewebElement.getHeaderWebElement().getCareerWebElement()
            .getJoinUsWebElement();
    }

    @Test(priority = 1)
    public void isJoinUsUrlLoaded() {
        assertEquals(joinUsWebElement.getUrl(), propertiesFile.getJoinUsUrl());
    }

    @Test(priority = 2)
    public void isJobMainSectionsLoaded() {
        jobPositionPageWebElement
            = joinUsWebElement.getPositionPageWebElement(LOCATION_NAME,
                                                         POSITION_NAME);
        assertEquals(jobPositionPageWebElement.isMainSectionExist(), true);
    }

    @Test(priority = 3, dataProvider = "ApplicationFormDataProvider")
    public void testApplicationFormValidation(String name, String email,
                                              String number, String cv,
                                              String linkdinProfile) {
        ApplyFormWebElem applyFormWebElement = jobPositionPageWebElement
            .getApplyFormWebElement();
        applyFormWebElement.fillOutApplyForm(name, email, number, cv,
                                             linkdinProfile);
        ErrorMessageWebElem ErrorMessageWebElement = applyFormWebElement
            .getErrorMessageWebElement();
        assertEquals(ErrorMessageWebElement.isErrorMessageFired(), true);
        applyFormWebElement.closeForm();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @DataProvider(name="ApplicationFormDataProvider")
    public String[][] getDataFromDataprovider(){
    return new String[][]
        {
            { "", "test@gmail.com", "00201067721442", CV_LINK, "http:" },
            { "test1", "test@", "00201067721442", "", "test" },
            { "test1", "test@gmail", "", CV_LINK, "" },
            { "test1", "test.com", "00201067721442", CV_LINK, "test" },
            { "test1", "test@/gamil.com", "00201067721442", CV_LINK, "test" }
        };

    }
}
