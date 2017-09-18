package po;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.BackgroundTypes;

public class SlotMachinePage extends PageObject {

    private final static Logger logger = LoggerFactory.getLogger(SlotMachinePage.class);

    public SlotMachinePage (WebDriver driver) {
        super(driver);
    }

    @FindBy (css = ".btnChangeBackground")
    WebElementFacade changeBackgroundButton;

    @FindBy (css = "#changeable_background_1")
    WebElementFacade changeableGrayBackground;

    @FindBy (css = "#changeable_background_2")
    WebElementFacade changeableSeaBackground;

    @FindBy (css = "#changeable_background_3")
    WebElementFacade changeableCandyBackground;

    @FindBy (css = "#changeable_background_4")
    WebElementFacade changeableBlueBackground;

    public SlotMachinePage clickChangeBackgroundButton() {
        logger.debug("Click 'Change Background' button");
        changeBackgroundButton.waitUntilPresent().then().click();
        return this;
    }

    public boolean assertBackgroundColor(BackgroundTypes texture) {
        findBy("#" + texture + "").waitUntilPresent().then().clear();
        return true;
    }

}
