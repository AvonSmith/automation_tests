package helper;

import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsMethods {

    private WebDriver driver;

    public ActionsMethods() {
        driver = DriverManager.getDriver();
    }

    public void doubleClick(WebElement element) {
        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(driver);
        action.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(driver);
        action.contextClick(element).perform();
    }

    public void oneClick(WebElement element) {
        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(driver);
    action.click(element).perform();
    }
}
