package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// This class presenting firefox browser
public final class FirefoxDriverExecuter extends AbstractWebDriverExecutor{

    public final WebDriver firfoxDriver;

    public FirefoxDriverExecuter() {
        WebDriverManager.firefoxdriver().setup();
        this.firfoxDriver = new FirefoxDriver();
    }

    @Override
    public WebDriver getDriver() {
        getMainUrl(firfoxDriver);
        return firfoxDriver;
    }

    @Override
    public void closeBrowserDriver() {
        firfoxDriver.quit();
    }

    @Override
    public void closeDriverTab() {
        firfoxDriver.close();
    }
}
