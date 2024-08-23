import driver.ChromeWebDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import pages.PracticeFormPage;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;


public class InitTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = ChromeWebDriver.newDriver();
    }

//    @AfterEach
//    public void close() {
//        if(this.driver != null) {
//            this.driver.close();
//            this.driver.quit();
//        }
//    }

    @Test
    void case1() throws InterruptedException {

        PracticeFormPage practiceForm = new PracticeFormPage(driver);
        practiceForm.setFirstname("Arina");
        practiceForm.setLastname("Zubova");
        practiceForm.setUserEmail("test@mail.ru");
        practiceForm.setGender("Male");
        practiceForm.setNumber("1234567890");
        practiceForm.setDateOfBirth("10 Aug 1996");
        practiceForm.setSubjects("English");
        practiceForm.uploadFile(new File("src/main/resources/testData/cat.jpeg"));
        practiceForm.setAddress("Moscow, st. Lenina, 19");
        practiceForm.setState();
        practiceForm.setCity();
        practiceForm.clickSubmit();
        practiceForm.isFormSubmitted("Thanks for submitting the form");
        practiceForm.isFilledDataShown();

    }
}
