package pages;

import helper.ActionsMethods;
import helper.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static helper.Page.sleepForFewSeconds;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
        actions = new ActionsMethods(driver);
        page = new Page(driver);
    }
    private ActionsMethods actions;
    private Page page;

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

    @FindBy(xpath = "//span[text()='Radio Button']")
    private WebElement radioButton;

    @FindBy(xpath = "//span[text()='Buttons']")
    private WebElement buttons;

    @FindBy(xpath = "//span[text()='Dynamic Properties']")
    private WebElement dynamicProperties;

    @FindBy(xpath = "//span[@class='rct-checkbox']")
    private List<WebElement> checkboxList;

    @FindBy(xpath = "//button[@aria-label='Expand all']")
    private WebElement expandList;

    @FindBy(xpath = "//*[contains(@class, 'rct-icon rct-icon-')][contains(@class, 'check')] ")
    private List<WebElement> checkBoxState;

    @FindBy(xpath = "//label[@for='yesRadio']")
    private WebElement yesRadioButton;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement impressiveRadioButton;

    @FindBy(xpath = "//span[@class='text-success']")
    private WebElement radioButtonResult;

    @FindBy(xpath = "//button[@id='doubleClickBtn']")
    private WebElement doubleClickButton;

    @FindBy(xpath = "//button[@id='rightClickBtn']")
    private WebElement rightClickButton;

    @FindBy(xpath = "//button[text()='Click Me'] ")
    private WebElement oneClickButton;

    @FindBy(xpath = "//button[@id='enableAfter']")
    private WebElement enableAfterButton;

    @FindBy(xpath = "//button[@id='colorChange']")
    private WebElement colorChangeButton;

    @FindBy(xpath = "//button[@id='visibleAfter'] ")
    private WebElement visibleAfterButton;

    @FindBy(xpath = "//*[@id='doubleClickMessage']")
    private WebElement doubleClickMessage;

    @FindBy(xpath = "//*[@id='rightClickMessage']")
    private WebElement rightClickMessage;

    @FindBy(xpath = "//*[@id='dynamicClickMessage']")
    private WebElement dynamicClickMessage;

    public void pickRadioButton(String radioButton) {
        switch (radioButton) {
            case "Yes":
                yesRadioButton.click();
                break;
            case "Impressive":
                impressiveRadioButton.click();
                break;
            default:
                System.out.println("Wrong radio button selection parameter!");
        }
    }


    // For the 'Yes' use assertTrue, for the 'Impressive' use assertFalse
    public Boolean radioButtonResult() {
        String text = radioButtonResult.getText();
        return "Yes".equals(text) ? Boolean.TRUE : "Impressive".equals(text) ? Boolean.FALSE : null;
    }

    public ElementsPage enter(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public void checkAllCheckBoxes() {
        expandList.click();
        //checkboxes should be checked from the bottom because first checkbox triggers the others
        for (int i = checkboxList.size() - 1; i >= 0; i--) {
            if (checkBoxState.get(i).getAttribute("class").contains("uncheck"))
            checkboxList.get(i).click();
        }
    }

    public Boolean checkboxState() {
        return checkBoxState.stream().allMatch(x -> x.getAttribute("class").equals("rct-icon rct-icon-check"));
    }

    public String getOutput(WebElement element) {
        return element.getText().split(":")[1];
    }

    public void doubleClickButton() {
        page.waitUntilElementIsClickable(doubleClickButton);
        actions.doubleClickOn(doubleClickButton);
    }

    public void rightClickButton() {
        actions.rightClickOn(rightClickButton);
    }

    public void oneClickButton() {
        actions.oneClickOn(oneClickButton);
    }

    public void enableAfterButton() {
        page.waitUntilElementIsClickable(enableAfterButton).click();
    }

    public void visibleAfterButton() {
        page.waitUntilElementIsVisible(visibleAfterButton).click();
    }

    public void colorChangeButton(String attribute, String color) {
        page.waitUntilChangeColor(colorChangeButton, attribute, color);
    }

    public void openTextBox() {
        elements.click();
        textBox.click();
    }

    public void openCheckbox() {
        elements.click();
        checkBox.click();
    }

    public void openRadiobutton() {
        elements.click();
        radioButton.click();
    }

    public void openButtons() {
        elements.click();
        buttons.click();
    }

    public void openDynamicProperties() {
        elements.click();
        dynamicProperties.click();
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

    public Boolean getDoubleClickMessage() {
        return doubleClickMessage.isDisplayed();
    }

    public Boolean getRightClickMessage() {
        return rightClickMessage.isDisplayed();
    }

    public Boolean getDynamicClickMessage() {
        return dynamicClickMessage.isDisplayed();
    }
}
