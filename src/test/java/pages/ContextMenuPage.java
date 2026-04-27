package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ContextMenuPage extends BasePage {

    private final By hotSpot = By.id("hot-spot");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL); // Открывает страницу по указанному URL
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hotSpot));
    }

    public void checkAlert() {
        //Явное ожидание загрузки страницы
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));//вынести
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hot-spot")));//вынести
        WebElement hotspot = driver.findElement(By.id("hot-spot"));
        //правый клик по элементу
        Actions actions = new Actions(driver);
        actions
                .contextClick(hotspot)
                .perform();
        //Переход к алерту
        Alert alert = driver.switchTo().alert();
        // валидация текста на алерте
        String expectedText = "You selected a context menu";
        String textAlert = alert.getText();
        System.out.println(textAlert + " Текст алерта");
        assertEquals(expectedText, textAlert);
        //Закрытие алерта
        alert.accept();
        //Проверка исчезновения алерта
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    }
}
