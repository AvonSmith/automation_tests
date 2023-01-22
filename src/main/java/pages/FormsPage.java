package pages;

import constants.Genders;
import constants.Hobbies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Month;
import java.util.*;

public class FormsPage extends BasePage {

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Forms']")
    private WebElement forms;

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceForm;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement userEmail;

    @FindBy(xpath = "//div[@class='custom-control custom-radio custom-control-inline']")
    private List<WebElement> radioButtons;

    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement userNumber;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirthInput;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement months;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement years;

    @FindBy(xpath = "//div[@class='react-datepicker__month']")
    private WebElement days;

    @FindBy(xpath = "//div[@role='option']")
    private List<WebElement> daysSelectors;

    @FindBy(xpath = "//div[@class='custom-control custom-checkbox custom-control-inline']")
    private List<WebElement> checkbox;

    @FindBy(xpath = "//*[@id='currentAddress']")
    private WebElement currentAddress;

    @FindBy(xpath = "//input[@id='react-select-9-input']")
    private WebElement states;

    @FindBy(xpath = "//span[@class='css-1laao21-a11yText']")
    private List<WebElement> stateSelectors;

    @FindBy(xpath = "//div[@id='city']")
    private WebElement cities;

    @FindBy(xpath = "//div[@id='city']//div[@class=' css-1uccc91-singleValue']")
    private List<WebElement> citySelectors;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    private String dateFormat = "";

    public void openPracticeForm() {
        forms.click();
        practiceForm.click();
    }

    public FormsPage enterFirstName(String userFirstName) {
        firstName.sendKeys(userFirstName);
        return this;
    }

    public FormsPage enterLastName(String userLastName) {
        lastName.sendKeys(userLastName);
        return this;
    }

    public FormsPage enterEmail(String email) {
        userEmail.sendKeys(email);
        return this;
    }

    public FormsPage pickGender(Genders gender) {
        radioButtons.get(gender.ordinal()).click();
        return this;
    }

    public FormsPage enterPhoneNumber(String phoneNumber) {
        userNumber.sendKeys(phoneNumber);
        return this;
    }

    private String firstCapitalLetter(String word) {
        return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public FormsPage enterDateOfBirth(Integer day, Month month, Integer year) {
        dateOfBirthInput.click();
        Select monthSelector = new Select(months);
        monthSelector.selectByVisibleText(firstCapitalLetter(month.toString()));
        Select yearSelector = new Select(years);
        yearSelector.selectByVisibleText(year.toString());
        for (WebElement date : daysSelectors) {
            if (date.getAttribute("aria-label").contains(firstCapitalLetter(month.toString())) &&
                    date.getAttribute("aria-label").contains(day.toString())) {
                date.click();
                dateFormat = day + " " + firstCapitalLetter(month.toString()).substring(0, 3) + " " + year;
                break;
            }
        }
        return this;
    }

    public FormsPage pickHobbies(Hobbies... hobbies) {
        for (Hobbies hobby : hobbies) {
            checkbox.get(hobby.ordinal()).click();
        }
        return this;
    }

    public FormsPage enterCurrentAddress(String address) {
        currentAddress.sendKeys(address);
        return this;
    }

    public WebElement getState() {
        return states;
    }

    public String getDate() {
        return dateFormat;
    }

    public Boolean dateResult() {
        return dateOfBirthInput.getAttribute("value").contains(dateFormat);
    }

    public void submit() {
        submitButton.click();
    }
}
