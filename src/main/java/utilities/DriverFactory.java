package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    /**
     * @return - WebDriver version based on properties: "browser"
     */
    public static WebDriver getDriver() {

        System.setProperty("webdriver.timeouts.implicitlywait", "40000");
        System.setProperty("webdriver.wait.for.timeout", "200000");

        String browser = PropertiesReader.getBrowser().toLowerCase();

        WebDriver driver;

        driver = getLocalDriver(browser);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        logger.info("Running tests using {}", driver);

        return driver;
    }

    /**
     * @param browser - one of "firefox", "chrome" or "ie". If none of those, defaults to "firefox"
     * @return - instance of WebDriver for local run
     */
    private static WebDriver getLocalDriver(String browser) {
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "browserdrivers/geckodriver.exe");
            return new FirefoxDriver();
        }
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "browserdrivers/chromedriver.exe");
            return new ChromeDriver();
        }
        if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", "browserdrivers/IEDriverServer.exe");
            return new InternetExplorerDriver();
        }

        // Default case
        return new FirefoxDriver();
    }

    /**
     * @return - FirefoxDriver with Firebug installed if possible
     */
    private static WebDriver getFirefoxDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        return new FirefoxDriver(new FirefoxBinary(
                new File(System.getProperty("user.dir")+
                        "/../tools/FirefoxPortable/FirefoxPortable.exe")
        ), profile);
    }
}