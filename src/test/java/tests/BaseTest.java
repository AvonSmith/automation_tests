package tests;

import driver_manager.DriverManager;
import helper.Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.AlertsFrameWindowsPage;
import pages.ElementsPage;
import pages.FormsPage;
import utils.FrameworkProperties;

public class BaseTest {
    protected WebDriver driver = DriverManager.getDriver();
    protected ElementsPage elementsPage = new ElementsPage(driver);
    protected FormsPage formsPage = new FormsPage(driver);
    protected AlertsFrameWindowsPage afwPage = new AlertsFrameWindowsPage(driver);
    protected Page page = new Page(driver);
    protected FrameworkProperties frameworkProperties = new FrameworkProperties();

    @AfterSuite
    public void close() {
        driver.quit();
    }
}
