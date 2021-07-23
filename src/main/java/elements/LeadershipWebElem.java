package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Web element presenting the section of leadership in join us page
public final class LeadershipWebElem {

    private static final By LEADER_SHIP_SELECTOR
        = By.className("company-members");
    private static final By MEMBER_SELECTOR = By.className("member");

    private final WebDriver driver;
    private final WebElement leadershipWebElement;

    public LeadershipWebElem(WebDriver driver, WebElement webElement) {
        if(driver == null)
            throw new IllegalArgumentException();

        this.driver = driver;
        this.leadershipWebElement = webElement.findElement(LEADER_SHIP_SELECTOR);
    }

    public boolean isMemeberExist() {
        // it should return 3 as there are only 3 members
        List<WebElement> membersList
            = leadershipWebElement.findElements(MEMBER_SELECTOR);
        if(membersList.size() == 3)
            return true;
        else
            return false;
    }
}
