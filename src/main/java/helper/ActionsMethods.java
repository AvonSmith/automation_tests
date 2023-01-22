package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsMethods extends Actions{

    private final Actions action;

    public ActionsMethods(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    public void doubleClickOn(WebElement element) {
        action.doubleClick(element).perform();
    }

    public void rightClickOn(WebElement element) {
        action.contextClick(element).perform();
    }

    public void oneClickOn(WebElement element) {
        action.click(element).perform();
    }

    public void dragFromTo(WebElement from, WebElement to) {
        action.dragAndDrop(from, to).perform();
    }

    public void moveElementViaCoordinates(WebElement element, int x, int y) {
        action.dragAndDropBy(element, x, y).perform();
    }
}
