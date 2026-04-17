import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesTest {
    @Test
    public void checkAddRemoveElement() {
        ChromeOptions options= new ChromeOptions();//опции всегда перед созданием драйвера
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");//отключает всплывающие окна
        // options.addArguments("--headles");// не открывается браузер, для тестов на удаленных серваках

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//неявное ожидание
        driver.get("https://the-internet.herokuapp.com/checkboxes");// открывает страницу по указанному урл
        boolean checked = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertFalse(checked);
        driver.findElements(By.cssSelector("[type=checkbox]")).get(0).click();
        checked = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertTrue(checked);

        boolean anChecked = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertTrue(anChecked);
        driver.findElements(By.cssSelector("[type=checkbox]")).get(1).click();
        anChecked = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertFalse(anChecked);

        driver.quit(); // закрывает полностью браузер
    }
}
