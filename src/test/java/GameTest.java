import org.testng.annotations.Test;

public class GameTest extends BaseTest {

    @Test(priority = 0)
    public void firstTest() {

        slotMachinePage.clickChangeBackgroundButton();

    }
}
