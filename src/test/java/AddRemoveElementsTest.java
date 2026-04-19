import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddRemoveElementsTest {


    @Test
    public void checkAddRemoveElement() {
        ChromeOptions options= new ChromeOptions();//опции всегда перед созданием драйвера
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");//отключает всплывающие окна
       // options.addArguments("--headles");// не открывается браузер, для тестов на удаленных серваках

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//неявное ожидание
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");// открывает страницу по указанному урл
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElements(By.xpath("//button[text()='Delete']"));// возвращает коллекцию
        int size = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(size,2);//сравнивает

        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        int size1 = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(size1,1);//сравнивает
       driver.quit(); // закрывает полностью браузер

    }
}
