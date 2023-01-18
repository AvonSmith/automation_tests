package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsMethods {

    private WebDriver driver;

    public ActionsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
    }

    public void oneClick(WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }
}
