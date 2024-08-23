import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.time.Duration;


public class InitTest {

    @Test
    void case1() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("firstName");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("lastName");
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("name@example.com");

        WebElement fieldGender1 = driver.findElement(By.id("gender-radio-1"));
        WebElement fieldGender2 = driver.findElement(By.id("gender-radio-2"));
        WebElement fieldGender3 = driver.findElement(By.id("gender-radio-3"));
        WebElement[] fieldsGender = {fieldGender1, fieldGender2, fieldGender3};
        ((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldGender1);

        WebElement mobile = driver.findElement(By.cssSelector("#userNumber"));
        mobile.sendKeys("7925830426");

        String randomDate = "20 Aug 2020";
        WebElement fieldDate = driver.findElement(By.id("dateOfBirthInput"));
        fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldDate.sendKeys(randomDate);
        fieldDate.sendKeys(Keys.chord(Keys.ENTER));

        WebElement subjects = driver.findElement(By.cssSelector("#subjectsInput"));
        subjects.sendKeys("English");
        subjects.sendKeys(Keys.DOWN);
        subjects.sendKeys(Keys.ENTER);
        File uploadFile = new File("src/main/resources/testData/cat.jpeg");
        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        WebElement adress = driver.findElement(By.cssSelector("#currentAddress"));
        adress.sendKeys("1223333 www qq");
        WebElement state = driver.findElement(By.cssSelector("#react-select-3-input"));
        state.sendKeys(Keys.DOWN);
        state.sendKeys(Keys.ENTER);
        WebElement city = driver.findElement(By.cssSelector("#react-select-4-input"));
        city.sendKeys(Keys.DOWN);
        city.sendKeys(Keys.ENTER);
        WebElement sbmt = driver.findElement(By.id("submit"));
        Thread.sleep(300);
        sbmt.click();
        String actual = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        System.out.println(actual);
        Thread.sleep(300);

        assertThat(actual).isEqualTo("Thanks for submitting the form");
//        driver.quit();
    }
}
