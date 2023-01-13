package tests;

import data_provider.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Constants.Selectors.*;
import static constants.Constants.Urls.MAIN_URL;
import static helper.Page.sleepForFewSeconds;

public class    ElementsTest extends BaseTest{

    @BeforeGroups(groups = "elements")
    public void elements() {
        page.open(frameworkProperties.getProperty(MAIN_URL));
        elementsPage.openTextBox();
    }

    @Test(groups = "elements", dataProvider = "params", dataProviderClass = DataProviders.class)
    public void fullNameField(String params) {
        elementsPage.enter(elementsPage.fullName(), params)
                    .submit();
        Assert.assertEquals(elementsPage.getOutput(elementsPage.getOutputFullName()), params);
    }

    @Test(groups = "elements", dataProvider = "email", dataProviderClass = DataProviders.class)
    public void emailField(String email) {
        elementsPage.enter(elementsPage.email(), email)
                    .submit();
        Assert.assertEquals(elementsPage.getOutput(elementsPage.getOutputEmail()), email);
    }

    @Test(groups = "elements", dataProvider = "address", dataProviderClass = DataProviders.class)
    public void currentAddressTextArea(String address) {
        elementsPage.enter(elementsPage.currentAddress(), address)
                    .submit();
        Assert.assertEquals(elementsPage.getOutput(elementsPage.getOutputCurrentAddress()), address);
    }

    @Test(groups = "elements", dataProvider = "address", dataProviderClass = DataProviders.class)
    public void permananetAddressTextArea(String address) {
        elementsPage.enter(elementsPage.permanentAddress(), address)
                    .submit();
        Assert.assertEquals(elementsPage.getOutput(elementsPage.getOutputPermanentAddress()), address);
    }

    @BeforeGroups(groups = "checkbox")
    public void checkbox() {
        page.open(frameworkProperties.getProperty(MAIN_URL));
        elementsPage.openCheckbox();
    }

    @Test(groups = "checkbox")
    public void checkAllCheckBoxes() {
        elementsPage.checkAllCheckBoxes();
        Assert.assertTrue(elementsPage.checkboxState());
    }

    @BeforeGroups(groups = "radiobutton")
    public void radiobutton() {
        page.open(frameworkProperties.getProperty(MAIN_URL));
        elementsPage.openRadiobutton();
    }

    @Test(groups = "radiobutton")
    public void radiobuttonTest() {
        elementsPage.pickRadioButton(YES_RADIOBUTTON);
        Assert.assertTrue(elementsPage.radioButtonResult());
        elementsPage.pickRadioButton(IMPRESSIVE_RADIOBUTTON);
        Assert.assertFalse(elementsPage.radioButtonResult());
    }

    @BeforeGroups(groups = "buttons")
    public void buttons() {
        page.open(frameworkProperties.getProperty(MAIN_URL));
        elementsPage.openButtons();
    }

    @Test(groups = "buttons")
    public void buttonsTest() {
        action.doubleClick(elementsPage.getDoubleClickButton());
        Assert.assertTrue(elementsPage.getDoubleClickMessage());
        action.rightClick(elementsPage.getRightClickButton());
        Assert.assertTrue(elementsPage.getRightClickMessage());
        action.oneClick(elementsPage.getOneClickButton());
        Assert.assertTrue(elementsPage.getDynamicClickMessage());
    }

    @BeforeGroups(groups = "dynamicProperties")
    public void dynamicProperties() {
        page.open(frameworkProperties.getProperty(MAIN_URL));
        elementsPage.openDynamicProperties();
    }

    @Test(groups = "dynamicProperties")
    public void dynamicPropertiesTest() {
        page.waitUntilElementIsClickable(elementsPage.getEnableAfterButton());
        page.waitUntilElementIsVisible(elementsPage.getVisibleAfterButton());
        page.waitUntilChangeColor(elementsPage.getColorChangeButton(), COLOR_ATTRIBUTE, RED_COLOR);
    }
}
