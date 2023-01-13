package helper;

import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;

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
            Thread.sleep (6000L);
        } catch (Exception ignored) {}
    }

//    public static void clickOn(WebElement element){
//        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element)).click();
//    }
//
    public WebElement waitUntilElementIsClickable(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitUntilElementIsVisible(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean waitUntilChangeColor(WebElement element, String attribute, String value) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.attributeContains(element, attribute,value));
    }
}
