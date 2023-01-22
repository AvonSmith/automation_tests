package pages;

import helper.ActionsMethods;
import helper.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static constants.Constants.Selectors.GRID;
import static constants.Constants.Selectors.LIST;
import static constants.Variables.setElementMovedFrom;
import static constants.Variables.setElementMovedTo;
import static helper.Page.sleepForFewSeconds;

public class InteractionsPage extends BasePage{
    public InteractionsPage(WebDriver driver) {
        super(driver);
        action = new ActionsMethods(driver);
        page = new Page(driver);
    }
    private final ActionsMethods action;

    private final Page page;

    @FindBy(xpath = "//*[text()='Interactions']")
    private WebElement interactions;

    @FindBy(xpath = "//span[text()='Sortable']")
    private WebElement sortable;

    @FindBy(xpath = "//span[text()='Resizable']")
    private WebElement resizable;

    @FindBy(xpath = "//span[text()='Droppable']")
    private WebElement droppable;

    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement draggableElement;

    @FindBy(xpath = "//div[@class='simple-drop-container']//div[@id='droppable']")
    private WebElement droppablePlace;

    @FindBy(xpath = "//a[@id='demo-tab-grid']")
    private WebElement gridMapping;

    @FindBy(xpath = "//a[@id='demo-tab-list']")
    private WebElement listMapping;

    @FindBy(xpath = "//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']")
    private List<WebElement> listOfElements;

    @FindBy(xpath = "//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action']")
    private List<WebElement> gridOfElements;

    @FindBy(xpath = "//div[@id='resizableBoxWithRestriction']//span[@class='react-resizable-handle react-resizable-handle-se']")
    private WebElement draggingPoint;

    public void openSortable() {
        interactions.click();
        sortable.click();
    }

    public void openResizable() {
        interactions.click();
        resizable.click();
    }

    public void openDroppable() {
        interactions.click();
        droppable.click();
    }

    public void moveElements(String mapping, int from, int to) {
        if (mapping.equals("list")) {
            listMapping.click();
            sleepForFewSeconds();
            setElementMovedFrom(movedElement(mapping, from));
            action.dragFromTo(listOfElements.get(from), listOfElements.get(to));
        }else if (mapping.equals("grid")) {
            gridMapping.click();
            sleepForFewSeconds();
            setElementMovedFrom(movedElement(mapping, from));
            action.dragFromTo(gridOfElements.get(from), gridOfElements.get(to));
        } else {
            Assert.fail("Wrong mapping selector");
        }
        setElementMovedTo(movedElement(mapping, to));
    }

    private String movedElement(String mapping, int index) {
        if (mapping.equals(LIST)) {
            return listOfElements.get(index).getText();
        } else if (mapping.equals(GRID)) {
            return gridOfElements.get(index).getText();
        } else {
            return null;
        }
    }

    public void resizeArea(int x, int y) {
        sleepForFewSeconds();
        action.moveElementViaCoordinates(draggingPoint, x, y);
    }

    public void dropElement() {
        sleepForFewSeconds();
        action.dragFromTo(draggableElement, droppablePlace);
    }
}
