package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;

public class Page {
    private final WebDriver driver;

    private String originalWindow;

    public String getNextWindow() {
        return nextWindow;
    }

    private String nextWindow;

    public Page(WebDriver driver) {
        this.driver = driver;
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

    public void waitUntilChangeColor(WebElement element, String attribute, String value) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public void setOriginalWindow() {
        originalWindow = driver.getWindowHandle();
        System.out.println("Original page url: " + getUrl());
    }

    public void setNextPage() {
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            nextWindow = tab;
        }
    }

    public void switchTabOrWindow(String string) {
        driver.switchTo().window(string);
        System.out.println("Switched page url: " + getUrl());
    }

    public void closeTabOrWindow() {
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
