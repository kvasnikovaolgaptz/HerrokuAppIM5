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

public class DropDownTest {
   @Test
    public  void checkAddRemoveElement() {
        ChromeOptions options = new ChromeOptions(); // Опции всегда перед созданием драйвера
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications"); // Отключает всплывающие окна

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Неявное ожидание
        driver.get("https://the-internet.herokuapp.com/dropdown"); // Открывает страницу по указанному URL
        Select select = new Select(driver.findElement(By.id("dropdown"))); // Select-класс-обертка для тега <select>

        List<WebElement> elements = select.getOptions(); // Получили все элементы

        boolean option1Exists = false; // Проверяем наличие "Option 1"
        for (WebElement element : elements) {
            if (element.getAttribute("value").equals("1")) {
                option1Exists = true;
                break;
            }
        }

        Assert.assertTrue(option1Exists, "Опция 'Option 1' не найдена в выпадающем списке.");

        // Если опция найдена, продолжаем
        select.selectByValue("1"); // выбираем опцию (значение должно быть "1")

        // Проверяем, что первая опция выбрана
        WebElement selectedElement = select.getFirstSelectedOption();
        Assert.assertEquals(selectedElement.getAttribute("value"), "1", "Первый элемент не выбран!");

        // Выбираем второй элемент
        select.selectByValue("2");
        selectedElement = select.getFirstSelectedOption();
        Assert.assertEquals(selectedElement.getAttribute("value"), "2", "Второй элемент не выбран!");

        driver.quit(); // Закрывает полностью браузер
    }
}
