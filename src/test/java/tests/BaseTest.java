package tests;

import driver_manager.DriverSingleton;
import helper.Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.AlertsFrameWindowsPage;
import pages.ElementsPage;
import pages.FormsPage;
import pages.InteractionsPage;
import utils.FrameworkProperties;

import static constants.Constants.ConnectorsVariables.*;

public class BaseTest {
    protected FrameworkProperties frameworkProperties = new FrameworkProperties();
    protected DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty(CHROME));
    protected WebDriver driver = DriverSingleton.getDriver();
    protected ElementsPage elementsPage = new ElementsPage(driver);
    protected FormsPage formsPage = new FormsPage(driver);
    protected AlertsFrameWindowsPage afwPage = new AlertsFrameWindowsPage(driver);
    protected InteractionsPage interactionsPage = new InteractionsPage(driver);
    protected Page page = new Page(driver);

    @AfterSuite
    public void close() {
        DriverSingleton.closeInstance();
    }
}
