package helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandler {

    private final WebDriver driver;

    public AlertHandler(WebDriver driver) {
        this.driver = driver;
    }

    public Alert getAlert() {
        return driver.switchTo().alert();
    }

    public void acceptAlert() {
        getAlert().accept();
    }

    public void dismissAlert() {
        getAlert().dismiss();
    }

    public void sendKeysToAlert(String keys) {
        getAlert().sendKeys(keys);
    }

    public void waitUntilAlertIsPresent() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.alertIsPresent());
    }
}
