package helper;

import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
    private WebDriver driver;

    public Page() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void open(String url){
        driver.get(url);
    }

    public static void sleepForFewSeconds() {
        try {
            Thread.sleep (3000L);
        } catch (Exception ignored) {}
    }

//    public static void clickOn(WebElement element){
//        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element)).click();
//    }
//
//    public static WebElement waitUntilElementIsVisible(WebElement element) {
//        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.e(element));
//    }
}
