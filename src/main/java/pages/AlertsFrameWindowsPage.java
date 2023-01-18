package pages;

import helper.AlertHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsFrameWindowsPage extends BasePage{

    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
        alertHandler = new AlertHandler(driver);
    }

    private final AlertHandler alertHandler;

    @FindBy(xpath = "//*[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindows;

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alerts;

    @FindBy(xpath = "//button[@id='alertButton']")
    private WebElement alertButton;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    private WebElement timerAlertButton;

    @FindBy(xpath = "//button[@id='confirmButton']")
    private WebElement confirmButton;

    @FindBy(xpath = "//button[@id='promtButton']")
    private WebElement promtButton;

    public void triggerSimpleAlert() {
        alertButton.click();
        alertHandler.acceptAlert();
    }

    public void triggerTimerAlert() {
        timerAlertButton.click();
        alertHandler.waitUntilAlertIsPresent();
        alertHandler.acceptAlert();
    }

    public void triggerConfirmAlert() {
        confirmButton.click();
        alertHandler.acceptAlert();
        confirmButton.click();
        alertHandler.dismissAlert();
    }

    public void triggerPromtAlert() {
        promtButton.click();
        alertHandler.sendKeysToAlert("Give me the offer!");
        alertHandler.acceptAlert();
    }

    public void openBrowserWindows() {
        alertsFrameWindows.click();
        alerts.click();
    }
}
