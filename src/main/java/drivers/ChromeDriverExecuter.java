package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// // This class presenting chrome browser
public final class ChromeDriverExecuter extends AbstractWebDriverExecutor{

    public final WebDriver chromeDriver;

    public ChromeDriverExecuter() {
        WebDriverManager.chromedriver().setup();
        this.chromeDriver = new ChromeDriver();
    }

    @Override
    public WebDriver getDriver() {
        getMainUrl(chromeDriver);
        return chromeDriver;
    }

    @Override
    public void closeBrowserDriver() {
        chromeDriver.quit();
    }

    @Override
    public void closeDriverTab() {
        chromeDriver.close();
    }
}
