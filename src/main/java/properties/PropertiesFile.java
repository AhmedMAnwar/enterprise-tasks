package properties;

import java.io.FileInputStream;
import java.util.Properties;

// This class presenting property file
public final class PropertiesFile {

    private static final String  FILE_PATH
        = "src/test/resources/config.properties";
    
    private Properties property = new Properties();

    public PropertiesFile() {
        try {
            FileInputStream file = new FileInputStream(FILE_PATH);
            property.load(file);
        }
        catch (Exception e) {
            throw new IllegalAccessError();
        }

    }

    public String getHomeUrl() {
        return property.getProperty("homeUrl");
    }

    public String getCompanyUrl() {
        return property.getProperty("companyUrl");
    }

    public String getFacebookUrl() {
        return property.getProperty("facebookUrl");
    }

    public String getJoinUsUrl() {
        return property.getProperty("joinUsUrl");
    }

    public String getChromeValue() {
        return property.getProperty("parallelTestChrome");
    }

    public String getFirefoxValue() {
        return property.getProperty("parallelTestFirefox");
    }
}
