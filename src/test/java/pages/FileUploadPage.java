package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class FileUploadPage extends BasePage {

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL_FILE_UPLOAD); // Открывает страницу по указанному URL
    }

    public void fileUpload() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //Явное ожидание загрузки страницы
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("example")));
        File file = new File("src/test/resources/FILE.txt"); //Загрузка файла
        driver.findElement(By.cssSelector("[type=file]")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();  //Клик по Upload
        WebElement uploadedFileName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files"))
        ); //Ожидание завершения загрузки и появления результата

        String actualFileName = uploadedFileName.getText(); //Имя файла на странице совпадает
        String expectedFileName = "FILE.txt";
        assertEquals(expectedFileName, actualFileName, "Имя загруженного файла не совпадает с ожидаемым");
    }
}
