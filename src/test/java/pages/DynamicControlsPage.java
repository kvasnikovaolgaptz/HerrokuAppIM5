package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControlsPage extends BasePage {

    private final By BUTTON_REMOVE = By.xpath("//*[text() = 'Remove']");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL_DYNAMIC_CONTROLS); // Открывает страницу по указанному URL
    }

    public void checkRemove() {
        driver.findElement(BUTTON_REMOVE).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));//дожидаемся надписи “It’s gone”
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        //Проверка, что инпут disabled
        assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled(),
                "Инпут должен быть disabled");
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();//Клик по Enable
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled(),
                "Инпут должен быть enabled");  //Проверка, что инпут enabled

    }
}
