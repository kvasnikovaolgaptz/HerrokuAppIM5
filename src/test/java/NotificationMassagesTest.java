import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class NotificationMassagesTest {
    @Test
    public  void notificationMassagesTest() {
        ChromeOptions options = new ChromeOptions(); // Опции всегда перед созданием драйвера
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications"); // Отключает всплывающие окна

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Неявное ожидание
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered"); // Открывает страницу по указанному URL

        driver.findElement(By.xpath("//*[contains(text(),'Click')]")).click();
        String notification = driver.findElement(By.xpath("//*[@id='flash-messages']")).getText();
        System.out.println("сообщение: "+notification);
        Assert.assertTrue(notification.contains("Action"), "Уведомление соответствует ожиданиям");
        driver.quit(); // Закрывает полностью браузер
    }
}
