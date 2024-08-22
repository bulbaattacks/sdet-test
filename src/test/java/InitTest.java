import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class InitTest {

    @Test
    void case1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("firstName");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("lastName");
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("name@example.com");
        WebElement gender = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
        gender.click();
        WebElement mobile = driver.findElement(By.cssSelector("#userNumber"));
        mobile.sendKeys("7925830426");
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        Actions actions = new Actions(driver);
        actions.moveToElement(datePicker).click().perform();
        WebElement monthSelector = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
        monthSelector.click();
        Select selectM = new Select(monthSelector);
        selectM.selectByValue("0");
        WebElement yearSelector = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
        yearSelector.click();
        Select selectY = new Select(yearSelector);
        selectY.selectByValue("1924");
        WebElement day = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]"));
        day.click();
        driver.quit();

    }
}
