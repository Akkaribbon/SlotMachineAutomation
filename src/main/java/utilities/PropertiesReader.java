package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties;
    private static String propertiesLocation = "src/main/resources/slot.properties";


    static String getPropertyValue(String key) {
        if (properties == null) {
            readProperties();
        }
        String value = System.getProperty(key);
        if (value == null) {
            value = properties.getProperty(key);
        }
        return value;
    }

    private static void readProperties() {
        try {
            File propertiesFile = new File(propertiesLocation).getCanonicalFile();
            FileInputStream propertiesStream = new FileInputStream(propertiesFile);
            properties = new Properties();
            properties.load(propertiesStream);

            propertiesStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getApplicationUrl() {
        return getPropertyValue("applicationUrl");
    }

    public static String getBrowser() {
        return getPropertyValue("browser");
    }
}
