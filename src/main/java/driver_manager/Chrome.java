package driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;

public class Chrome implements DriverStrategy{
    @Override
    public WebDriver setStrategy() {
        return new ChromeDriver(WebDriverConfig.configChrome());
    }
}
