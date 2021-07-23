package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Web element presenting the job position page web element
public final class JobPositionPageWebElem {

    private static final By POSITION_PAGE_ROOT_SELECTOR = By.className("Jobs");
    private static final By JOB_CONTENT_TITLE_SELETOR
        = By.xpath(".//div[@class = 'content-title']/h2");
    private static final By APPLY_BUTTON_SELECTOR
        = By.xpath(".//input[@value ='Apply']");

    private final WebDriver driver;
    private final WebElement jobPositionPageRootWebElement;

    String[] jobMainSections = {"General description",
                                "Requirements", "Responsibilities",
                                "What we offer"};

    public JobPositionPageWebElem(WebDriver driver) {
        if(driver == null)
            throw new IllegalArgumentException();

        this.driver = driver;
        this.jobPositionPageRootWebElement
            = driver.findElement(POSITION_PAGE_ROOT_SELECTOR);
    }

    public boolean isMainSectionExist() {
        List<WebElement> mainSectionTitels
            = jobPositionPageRootWebElement.findElements
            (JOB_CONTENT_TITLE_SELETOR);
        for(int i = 0; i < mainSectionTitels.size(); i++) {
            if(!mainSectionTitels.get(i).getText().equals(jobMainSections[i]))
                return false;
        }
        return true;
    }

    public ApplyFormWebElem getApplyFormWebElement() {
        WebElement applyButtonWebElement
            = jobPositionPageRootWebElement.findElement(APPLY_BUTTON_SELECTOR);
        WebElementUtilis.scrollToView(driver, applyButtonWebElement);
        ApplyFormWebElem applyFormWebElem = new ApplyFormWebElem(driver);
        WebElementUtilis.ivisibilityOfElement
            (driver,applyFormWebElem.applyFormWebElement);
        WebElementUtilis.clickOnElementByScript(driver, applyButtonWebElement);
        return new ApplyFormWebElem(driver);
    }
}
