package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsMethods {

    private final Actions action;

    public ActionsMethods(WebDriver driver) {
        action = new Actions(driver);
    }

    public void doubleClick(WebElement element) {
        action.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        action.contextClick(element).perform();
    }

    public void oneClick(WebElement element) {
        action.click(element).perform();
    }

    public void dragFromTo(WebElement from, WebElement to) {
        action.dragAndDrop(from, to).perform();
    }
}
