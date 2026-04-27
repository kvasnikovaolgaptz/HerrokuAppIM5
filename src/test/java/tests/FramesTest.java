package tests;

import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    public void checkFrames() {
        framesPage.open();
        framesPage.openIFrame();
    }
}
