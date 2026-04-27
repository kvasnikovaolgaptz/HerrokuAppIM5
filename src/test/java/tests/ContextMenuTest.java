package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {
    WebDriver driver;

    @Test
    public void checkContextMenu() {
        contextMenuPage.open();
        contextMenuPage.isPageOpened();
        contextMenuPage.checkAlert();
    }
}
