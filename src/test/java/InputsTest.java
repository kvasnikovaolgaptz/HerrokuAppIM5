import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.Key;
import java.time.Duration;

public class InputsTest {
    @Test
    public void checkAddRemoveElement() {
        ChromeOptions options= new ChromeOptions();//опции всегда перед созданием драйвера
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");//отключает всплывающие окна
        // options.addArguments("--headles");// не открывается браузер, для тестов на удаленных серваках

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//неявное ожидание
        driver.get("https://the-internet.herokuapp.com/inputs");// открывает страницу по указанному урл
        driver.findElement(By.tagName("input")).sendKeys("привет");//вводим текст
        String text1 = driver.findElement(By.tagName("input")).getText();//получаем что вввели
        Assert.assertEquals(text1,"");//сравнивает

        driver.findElement(By.tagName("input")).sendKeys("0");//вводим цифру
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String figure  = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(figure,"1");//сравнивает

        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        figure  = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(figure,"0");//сравнивает
        driver.quit(); // закрывает полностью браузер
    }
}

