package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL_FRAMES); // Открывает страницу по указанному URL
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//Явное ожидание загрузки страницы
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("example")));
    }

    public void openIFrame() {
        driver.findElement(By.linkText("iFrame")).click(); //Клик по iFrame
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mce_0_ifr")));
        driver.switchTo().frame(iframe); //Переключение на iframe
        WebElement paragraph = driver.findElement(By.xpath("//body[@id='tinymce']/p")); //Поиск параграфа внутри iframe и проверка текста
        String expectedText = "Your content goes here.";
        assertEquals(expectedText, paragraph.getText().trim());
        driver.switchTo().defaultContent(); // выход из фрейма
    }
}
