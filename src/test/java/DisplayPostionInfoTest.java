import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import elements.HomeWebElem;
import elements.JobPositionPageWebElem;
import elements.JoinUsWebElem;

// Display position job info test cases
public final class DisplayPostionInfoTest  extends TestSuiteConfiguration{

    WebDriver driver;

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

    @Test(priority =  1)
    public void printSofiaLocationPositions() {
        joinUsWebElement.printPositionsInfoByLocation("Sofia");
    }

    @Test(priority = 2)
    public void printSkopjeLocationPositions() {
        joinUsWebElement.printPositionsInfoByLocation("Skopje");
    }

    @AfterMethod
    public void printNewline() {
        System.out.println("------------------");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
