package driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;

public class DriverManager {
    private static WebDriver driver;

    private static void setDriver() {
        System.out.println("Connecting to desktop browser...");
        driver = new ChromeDriver(WebDriverConfig.configChrome());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }
}
