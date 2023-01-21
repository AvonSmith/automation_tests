package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Constants.Selectors.*;
import static constants.Constants.Urls.MAIN_URL;
import static constants.Variables.*;
import static helper.Page.sleepForFewSeconds;

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
}
