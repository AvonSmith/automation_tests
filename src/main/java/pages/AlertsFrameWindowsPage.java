package pages;

import helper.AlertHandler;
import helper.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsFrameWindowsPage extends BasePage{

    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
        alertHandler = new AlertHandler(driver);
        page = new Page(driver);
    }

    private final AlertHandler alertHandler;
    private final Page page;

    @FindBy(xpath = "//*[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindows;

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alerts;

    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindows;

    @FindBy(xpath = "//button[@id='alertButton']")
    private WebElement alertButton;

    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement tabButton;

    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement windowButton;

    @FindBy(xpath = "//button[@id='messageWindowButton']")
    private WebElement messageWindowButton;

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

    public void openAlerts() {
        alertsFrameWindows.click();
        alerts.click();
    }

    public void openBrowserWindows() {
        alertsFrameWindows.click();
        browserWindows.click();
    }

    public void clickNewTabButton() {
        page.setOriginalWindow();
        tabButton.click();
        page.setNextPage();
        page.switchTabOrWindow(page.getNextWindow());
        page.closeTabOrWindow();
    }

    public void clickNewWindowButton() {
        page.setOriginalWindow();
        windowButton.click();
        page.setNextPage();
        page.switchTabOrWindow(page.getNextWindow());
        page.closeTabOrWindow();
    }

    public void clickNewMessageWindowButton() {

        page.setOriginalWindow();
        messageWindowButton.click();
        page.setNextPage();
        page.switchTabOrWindow(page.getNextWindow());
        page.closeTabOrWindow();
    }
}
