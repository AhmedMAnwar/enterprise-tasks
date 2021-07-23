package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

// Web element presenting join us page.
public final class JoinUsWebElem {

    private static final By JOIN_US_ROOT_SELECTOR = By.id("join-us");
    private static final By jOIN_US_SECTION_SELECTOR = By.className("join-us");
    private static final By DROP_DOWN_SELECTOR = By.id("get_location");
    private static final By CARD_JOB_SELECTOR
        = By.className("card-container");
    private static final By JOB_TITLE_SELECTOR
        = By.className("card-jobsHot__title");
    private static final By JOB_LINK_SELECTOR
        = By.className("card-jobsHot__link");

    private final WebDriver driver;
    private WebElement joinUsWebElement;
    private WebElement joinUsSectionWebElement;

    public JoinUsWebElem(WebDriver driver) {
        if(driver == null)
            throw new IllegalArgumentException();

        this.driver = driver;
        this.joinUsWebElement = driver.findElement(JOIN_US_ROOT_SELECTOR);
        this.joinUsSectionWebElement
            = joinUsWebElement.findElement(jOIN_US_SECTION_SELECTOR);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    private void selectLocationFromDropDown(String locationName) {
        if(!WebElementUtilis.isStale(joinUsWebElement, jOIN_US_SECTION_SELECTOR)) {
            joinUsWebElement = driver.findElement(JOIN_US_ROOT_SELECTOR);
            joinUsSectionWebElement
                = joinUsWebElement.findElement(jOIN_US_SECTION_SELECTOR);
        }

        WebElementUtilis.scrollToView(driver, joinUsSectionWebElement);
        WebElement locationDropDownWebElement
            = joinUsSectionWebElement.findElement(DROP_DOWN_SELECTOR);
        Select location = new Select(locationDropDownWebElement);
        location.selectByValue(locationName);
    }

    private WebElement getPositionTitleWebElementIfAny(String positionName) {
        List<WebElement> jobList = getJobList();
        for (WebElement job : jobList) {
            WebElement positionTitleWebElement
                = job.findElement(JOB_TITLE_SELECTOR);
            if(positionTitleWebElement.getText().equals(positionName))
                return job;
        }
        return null;
    }

    private WebElement selectLocationAndPosition(String locationName,
                                                 String positionName) {
        selectLocationFromDropDown(locationName);
        WebElement positionTitleWebElement
            = getPositionTitleWebElementIfAny(positionName);
        return positionTitleWebElement;
    }

    private List<WebElement> getJobList() {
        List<WebElement> jobList
            = driver.findElements(CARD_JOB_SELECTOR);
        return jobList;
    }

    public void printPositionsInfoByLocation(String location) {
        selectLocationFromDropDown(location);
        List<WebElement> jobList = getJobList();
        for (WebElement job : jobList) {
            System.out.println("Location : " + location);
            System.out.println("Position :" + job
                               .findElement(JOB_TITLE_SELECTOR).getText());
            System.out.println("More info :" + job.findElement(JOB_LINK_SELECTOR)
                               .getAttribute("href"));
            System.out.println();
        }
    }

    public JobPositionPageWebElem getPositionPageWebElement(String locationName,
                                                            String positionName) {
        WebElement positionWebElement =
            selectLocationAndPosition(locationName, positionName);
        WebElementUtilis.scrollToView(driver, positionWebElement);
        positionWebElement.click();
        return new JobPositionPageWebElem(driver);
    }
}
