import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import po.SlotMachinePage;
import utilities.DriverFactory;
import utilities.PropertiesReader;

public class BaseTest extends PropertiesReader {

    private final static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected WebDriver driver;

    SlotMachinePage slotMachinePage;


    @BeforeClass
    public void setup() {
        logger.info("------- Starting Tests -------");
        driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
        slotMachinePage = new SlotMachinePage(driver);
    }

    @BeforeMethod
    public void testSetup() {
        driver.get(PropertiesReader.getApplicationUrl());
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }
}
