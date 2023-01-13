package tests;

import data_provider.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static constants.Constants.Selectors.IMPRESSIVE_RADIOBUTTON;
import static constants.Constants.Selectors.YES_RADIOBUTTON;
import static constants.Constants.Urls.MAIN_URL;

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
}
