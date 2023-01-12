package tests;

import data_provider.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Constants.Urls.MAIN_URL;
import static constants.Constants.Urls.TEXT_BOX_URL;

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
//        System.out.println(elementsPage.getFullNameOutput());
        Assert.assertEquals(elementsPage.getFullNameOutput(), params);
    }
}
