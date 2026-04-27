package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    WebDriver driver;

    @Test
    public void checkDynamicControls() {
        dynamicControlsPage.open();
        dynamicControlsPage.checkRemove();
    }
}
