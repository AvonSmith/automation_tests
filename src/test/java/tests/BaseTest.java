package tests;

import driver_manager.DriverManager;
import helper.ActionsMethods;
import helper.Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.ElementsPage;
import utils.FrameworkProperties;

public class BaseTest {
    protected WebDriver driver = DriverManager.getDriver();
    protected ElementsPage elementsPage = new ElementsPage(driver);
    protected Page page = new Page();
    protected FrameworkProperties frameworkProperties = new FrameworkProperties();
    protected ActionsMethods action = new ActionsMethods();

    @AfterSuite
    public void close() {
        driver.quit();
    }
}
