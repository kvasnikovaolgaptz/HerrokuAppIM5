package tests;

import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test
    public void checkFileUpload() {
        fileUploadPage.open();
        fileUploadPage.fileUpload();
    }
}
