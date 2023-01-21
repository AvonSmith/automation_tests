package pages;

import helper.ActionsMethods;
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
    }
    private final ActionsMethods action;

    @FindBy(xpath = "//*[text()='Interactions']")
    private WebElement interactions;

    @FindBy(xpath = "//span[text()='Sortable']")
    private WebElement sortable;

    @FindBy(xpath = "//a[@id='demo-tab-grid']")
    private WebElement gridMapping;

    @FindBy(xpath = "//a[@id='demo-tab-list']")
    private WebElement listMapping;

    @FindBy(xpath = "//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']")
    private List<WebElement> listOfElements;

    @FindBy(xpath = "//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action']")
    private List<WebElement> gridOfElements;

    public void openSortable() {
        interactions.click();
        sortable.click();
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
}
