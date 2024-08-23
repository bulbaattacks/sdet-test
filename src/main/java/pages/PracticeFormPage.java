package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class PracticeFormPage {

    private WebDriver driver;

    private static String PAGE_URL="https://demoqa.com/automation-practice-form";

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


    // PAGE_URL где его указать? здесь или в бифор ич?
    public PracticeFormPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void setFirstname(String userFirstname){
        firstName.sendKeys(userFirstname);
    }

    public void setLastname(String userLastname){
        lastName.sendKeys(userLastname);
    }

    public void setUserEmail(String userEmail){
        email.sendKeys(userEmail);
    }

    public void setGender(String userGender){
        ((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;",gender);
    }

    public void setNumber(String userNumber){
        number.sendKeys(userNumber);
    }

    public void setDateOfBirth(String userDateOfBirth){
        dateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dateOfBirth.sendKeys(userDateOfBirth);
        dateOfBirth.sendKeys(Keys.chord(Keys.ENTER));
    }

    public void setSubjects(String userSubjects){
        subjects.sendKeys("English");
        subjects.sendKeys(Keys.DOWN);
        subjects.sendKeys(Keys.ENTER);
    }

    public void uploadFile(File userFile){
        file.sendKeys(userFile.getAbsolutePath());
    }

    public void setAddress(String userAddress){
        address.sendKeys(userAddress);
    }

    public void setState(){
        state.sendKeys(Keys.DOWN);
        state.sendKeys(Keys.ENTER);
    }

    public void setCity(){
        city.sendKeys(Keys.DOWN);
        city.sendKeys(Keys.ENTER);
    }

    public void clickSubmit(){
        sbmt.click();
    }

    public void isFormSubmitted(String submittedForm){
        successPopup.getText().contains(submittedForm);
    }

    public void isFilledDataShown(){
        firstName.isDisplayed();
        lastName.isDisplayed();
        email.isDisplayed();
        gender.isDisplayed();
        number.isDisplayed();
        dateOfBirth.isDisplayed();
        subjects.isDisplayed();
        file.isDisplayed();
        address.isDisplayed();
        state.isDisplayed();
        city.isDisplayed();
    }

}
