package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public final String BASE_URL = "https://the-internet.herokuapp.com/context_menu";
    public final String BASE_URL_DYNAMIC_CONTROLS = "https://the-internet.herokuapp.com/dynamic_controls";
    public final String BASE_URL_FILE_UPLOAD = "https://the-internet.herokuapp.com/upload";
    public final String BASE_URL_FRAMES = "https://the-internet.herokuapp.com/frames";
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
