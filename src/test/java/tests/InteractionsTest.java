package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Constants.Selectors.*;
import static constants.Constants.Urls.MAIN_URL;
import static constants.Variables.*;

public class InteractionsTest extends BaseTest{

    @BeforeTest
    public void interactions() {
        page.open(frameworkProperties.getProperty(MAIN_URL));
    }

    @Test
    public void moveElementsTest() {
        interactionsPage.openSortable();
        interactionsPage.moveElements(LIST, FROM, TO);
        Assert.assertEquals(getElementMovedTo(), getElementMovedFrom());
    }

    @Test
    public void resizableTest() {
        interactionsPage.openResizable();
        interactionsPage.resizeArea(20, 30);
    }

    @Test
    public void droppableTest() {
        interactionsPage.openDroppable();
        interactionsPage.dropElement();
    }
}
