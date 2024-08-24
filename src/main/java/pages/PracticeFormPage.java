package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.UtilKey;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PracticeFormPage {

    private static final String PAGE_URL = "https://demoqa.com/automation-practice-form";

    private final WebDriver driver;

    @FindBy(xpath = "//h1")
    WebElement header;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "gender-radio-1")
    WebElement gender;

    @FindBy(css = "#userNumber")
    WebElement number;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirth;

    @FindBy(css = "#subjectsInput")
    WebElement subjects;

    @FindBy(xpath = "//*[@id=\"uploadPicture\"]")
    WebElement file;

    @FindBy(css = "#currentAddress")
    WebElement address;

    @FindBy(css = "#react-select-3-input")
    WebElement state;

    @FindBy(css = "#react-select-4-input")
    WebElement city;

    @FindBy(id = "submit")
    WebElement sbmt;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement successPopup;

    @FindBy(css = "body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr > td")
    List<WebElement> successTable;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void verifyHeader() {
        String getHeaderText = header.getText().trim();
        Assertions.assertEquals("Practice Form", getHeaderText);
    }

    public void setFirstname(String userFirstname) {
        firstName.sendKeys(userFirstname);
    }

    public void setLastname(String userLastname) {
        lastName.sendKeys(userLastname);
    }

    public void setUserEmail(String userEmail) {
        email.sendKeys(userEmail);
    }

    public void setGender() {
        ((JavascriptExecutor) driver).executeScript(Gender.MALE.label, gender);
    }

    public void setNumber(String userNumber) {
        number.sendKeys(userNumber);
    }

    public void setDateOfBirth(String userDateOfBirth) {
        dateOfBirth.sendKeys(Keys.chord(UtilKey.control(), "a"));
        dateOfBirth.sendKeys(userDateOfBirth);
        dateOfBirth.sendKeys(Keys.chord(Keys.ENTER));
    }

    public void setSubjects(String userSubjects) {
        subjects.sendKeys(userSubjects);
        subjects.sendKeys(Keys.DOWN);
        subjects.sendKeys(Keys.ENTER);
    }

    public void uploadFile(File userFile) {
        file.sendKeys(userFile.getAbsolutePath());
    }

    public void setAddress(String userAddress) {
        address.sendKeys(userAddress);
    }

    public void setState() {
        state.sendKeys(Keys.DOWN);
        state.sendKeys(Keys.ENTER);
    }

    public void setCity() {
        city.sendKeys(Keys.DOWN);
        city.sendKeys(Keys.ENTER);
    }

    public void clickSubmit() {
        sbmt.click();
    }

    public String isFormSubmitted() {
        return successPopup.getText();
    }

    public Set<String> parseSuccessTable() {
        Set<String> set = new HashSet<>();
        boolean isSecondValue = false;
        for (WebElement t : successTable) {
            if (isSecondValue) {
                set.add(t.getText());
                isSecondValue = false;
            } else {
                isSecondValue = true;
            }
        }
        return set;
    }

    enum Gender {
        MALE("arguments[0].checked = true;"),
        FEMALE("arguments[1].checked = true;"),
        OTHER("arguments[2].checked = true;");

        public final String label;

        Gender(String label) {
            this.label = label;
        }
    }
}
