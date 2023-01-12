package tests;

import data_provider.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Constants.Urls.MAIN_URL;

public class ElementsTest extends BaseTest{
    @BeforeTest
    public void openTestPage() {
        page.open(frameworkProperties.getProperty(MAIN_URL));
        elementsPage.startTest();
    }

    @Test(dataProvider = "params", dataProviderClass = DataProviders.class)
    public void fullNameField(String params) {
        elementsPage.enter(elementsPage.fullName(), params)
                    .submit();
        Assert.assertEquals(elementsPage.getOutput(elementsPage.getOutputFullName()), params);
    }

    @Test(dataProvider = "email", dataProviderClass = DataProviders.class)
    public void emailField(String params) {
        elementsPage.enter(elementsPage.email(), params)
                    .submit();
        Assert.assertEquals(elementsPage.getOutput(elementsPage.getOutputEmail()), params);
    }
}
