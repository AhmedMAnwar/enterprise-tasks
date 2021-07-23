import org.openqa.selenium.WebDriver;

import drivers.ChromeDriverExecuter;
import drivers.FirefoxDriverExecuter;
import properties.PropertiesFile;

public class TestSuiteConfiguration {

    protected PropertiesFile propertiesFile = new PropertiesFile();

    public WebDriver getDriverInstance(String browserName) {
        // this return instance of chrome driver
        if(browserName.equals(propertiesFile.getChromeValue()))
            return new ChromeDriverExecuter().getDriver();

        // this return instance of firefox driver
        else if(browserName.equals(propertiesFile.getFirefoxValue()))
            return new FirefoxDriverExecuter().getDriver();

        return null;
    }
}
