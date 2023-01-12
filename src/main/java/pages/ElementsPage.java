package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement fullName;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement email;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentAddress;

    public WebElement email() {
        return email;
    }

    public WebElement currentAddress() {
        return currentAddress;
    }

    public WebElement permanentAddress() {
        return permanentAddress;
    }

    public WebElement fullName() {
        return fullName;
    }

    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    private WebElement permanentAddress;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//p[@id='name']")
    private WebElement outputFullName;
    @FindBy(xpath = "//p[@id='email']")
    private WebElement outputEmail;
    @FindBy(xpath = "//p[@id='currentAddress']")
    private WebElement outputCurrentAddress;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    private WebElement outputPermanentAddress;
    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div[1]/div/div[2]")
    private WebElement elements;
    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textBox;

    public ElementsPage enter(WebElement element, String text) {
        element.clear();
//        element.click();
        element.sendKeys(text);
        return this;
    }

    public void enterFullName(String text) {
        fullName.click();
        fullName.sendKeys(text);
    }

    public void enterEmail(String text) {
        email.click();
        email.sendKeys(text);
    }

    public void enterCurrentAddress(String text) {
        currentAddress.click();
        currentAddress.sendKeys(text);
    }

    public void enterPermanentAddress(String text) {
        permanentAddress.click();
        permanentAddress.sendKeys(text);
    }

    public WebElement getOutputFullName() {
        return outputFullName;
    }

    public WebElement getOutputEmail() {
        return outputEmail;
    }

    public WebElement getOutputCurrentAddress() {
        return outputCurrentAddress;
    }

    public WebElement getOutputPermanentAddress() {
        return outputPermanentAddress;
    }

    public String getOutput(WebElement element) {
        return element.getText().split(":")[1];
    }

    public void startTest() {
        elements.click();
        textBox.click();
    }

    public void submit() {
        submitButton.click();
    }
}
