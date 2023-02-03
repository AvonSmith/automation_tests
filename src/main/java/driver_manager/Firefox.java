package driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;

public class Firefox implements DriverStrategy{
    @Override
    public WebDriver setStrategy() {
        return new FirefoxDriver(WebDriverConfig.configFirefox());
    }
}
