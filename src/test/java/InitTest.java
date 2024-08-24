import driver.ChromeWebDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.PracticeFormPage;

import java.io.File;
import java.util.Set;

class InitTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = ChromeWebDriver.newDriver();
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }
    }

    @Test
    @DisplayName("Тест заполнения формы регистрации.")
    void fillStudentRegistrationForm() {
        PracticeFormPage practiceForm = new PracticeFormPage(driver);
        practiceForm.open();
        practiceForm.verifyHeader();

        practiceForm.setFirstname("Arina");
        practiceForm.setLastname("Zubova");
        practiceForm.setUserEmail("test@mail.ru");
        practiceForm.setGender();
        practiceForm.setNumber("1234567890");
        practiceForm.setDateOfBirth("10 Aug 1996");
        practiceForm.setSubjects("English");
        practiceForm.uploadFile(new File("src/main/resources/testData/cat.jpeg"));
        practiceForm.setAddress("Moscow, st. Lenina, 19");
        practiceForm.setState();
        practiceForm.setCity();
        practiceForm.clickSubmit();

        Assertions.assertEquals("Thanks for submitting the form", practiceForm.isFormSubmitted());

        Set<String> tableValues = practiceForm.parseSuccessTable();
        Assertions.assertTrue(tableValues.contains("Arina Zubova"));
        Assertions.assertTrue(tableValues.contains("test@mail.ru"));
        Assertions.assertTrue(tableValues.contains("1234567890"));
        Assertions.assertTrue(tableValues.contains("10 August,1996"));
        Assertions.assertTrue(tableValues.contains("English"));
        Assertions.assertTrue(tableValues.contains("cat.jpeg"));
        Assertions.assertTrue(tableValues.contains("Moscow, st. Lenina, 19"));
        Assertions.assertTrue(tableValues.contains("NCR Delhi"));
    }
}
