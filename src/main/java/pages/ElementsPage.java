package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//*[text()='Elements']")
    private WebElement elements;

    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textBox;

    @FindBy(xpath = "//span[text()='Check Box'] ")
    private WebElement checkBox;

    @FindBy(xpath = "//span[@class='rct-checkbox']")
    private List<WebElement> checkboxList;

    @FindBy(xpath = "//button[@aria-label='Expand all']")
    private WebElement expandList;

    @FindBy(xpath = "//*[contains(@class, 'rct-icon rct-icon-')][contains(@class, 'check')] ")
    private List<WebElement> checkBoxState;

    public ElementsPage enter(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public void checkAllCheckBoxes() {
        expandList.click();
        for (int i = checkboxList.size() - 1; i >= 0; i--) {
            if (checkBoxState.get(i).getAttribute("class").contains("uncheck"))
            checkboxList.get(i).click();
        }
    }

    public Boolean checkboxState() {
        boolean result = false;
        for (int i = 0; i < checkboxList.size(); i++) {
            if (checkBoxState.get(i).getAttribute("class").equals("rct-icon rct-icon-check"))
                result = true;
            else {
                result = false;
                break;
            }
        }
        return result;
    }

    public String getOutput(WebElement element) {
        return element.getText().split(":")[1];
    }

    public void openTextBox() {
        elements.click();
        textBox.click();
    }

    public void openCheckbox() {
        elements.click();
        checkBox.click();
    }

    public void submit() {
        submitButton.click();
    }

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
}
