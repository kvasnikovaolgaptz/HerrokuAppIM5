import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TyposTest {
    @Test
    public void checkAddRemoveElement() {
        ChromeOptions options= new ChromeOptions();//опции всегда перед созданием драйвера
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");//отключает всплывающие окна
        // options.addArguments("--headles");// не открывается браузер, для тестов на удаленных серваках

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert(); //мягкий  Assert
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//неявное ожидание
        for (int i = 0; i < 10; i++) {
            driver.get("https://the-internet.herokuapp.com/typos");// открывает страницу по указанному урл
            String text = driver.findElement(By.xpath("//p[2]")).getText();
            System.out.println(text);
            softAssert.assertEquals(text,"Sometimes you'll see a typo, other times you won,t.");//сравнивает
        }
        driver.quit(); // закрывает полностью браузер
        softAssert.assertAll();
    }
}
