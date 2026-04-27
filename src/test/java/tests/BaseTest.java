package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ContextMenuPage;
import pages.DynamicControlsPage;
import pages.FileUploadPage;
import pages.FramesPage;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    WebDriver driver;
    ContextMenuPage contextMenuPage;
    DynamicControlsPage dynamicControlsPage;
    FileUploadPage fileUploadPage;
    FramesPage framesPage;

    @BeforeMethod
    //вешается аннотация библиотеки, чтобы в классах наследниках отрабатывал этот метод перед каждым методом
    public void setUP() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
        contextMenuPage = new ContextMenuPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        fileUploadPage = new FileUploadPage(driver);
        framesPage = new FramesPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Неявное ожидание
    }

    @AfterMethod(alwaysRun = true)
    public void tearDawn() {
        driver.quit();
    }
}
