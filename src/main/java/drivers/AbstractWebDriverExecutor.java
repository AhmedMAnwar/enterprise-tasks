package drivers;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import properties.PropertiesFile;

// This class presenting the base drvier executer of project
public abstract class AbstractWebDriverExecutor {

    private static final int IMPLICIT_VALUE_TIME = 10;
    public abstract WebDriver getDriver();

    public abstract void closeDriverTab();

    public abstract void closeBrowserDriver();

    public void getMainUrl(WebDriver driver) {
        driver.get(new PropertiesFile().getHomeUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait
            (IMPLICIT_VALUE_TIME, TimeUnit.SECONDS);
    }
}
