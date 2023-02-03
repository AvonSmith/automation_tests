package driver_manager;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;

    private DriverSingleton(String browser) {
        instantiate(browser);
    }

    public WebDriver instantiate(String browser) {
        DriverStrategy driverStrategy = DriverStrategyImplementer.setDriver(browser);
        driver = driverStrategy.setStrategy();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }

    public static DriverSingleton getInstance(String browser) {
        if (instance == null) {
            instance = new DriverSingleton(browser);
        }

        return instance;
    }

    public static void closeInstance() {
        instance = null;
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
