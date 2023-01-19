package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Constants.Urls.MAIN_URL;

public class AlertsFrameWindowsTest extends BaseTest {

    @BeforeTest
    public void alertsFrameWindows() {
        page.open(frameworkProperties.getProperty(MAIN_URL));
    }

    @Test
    public void alertTest() {
        afwPage.openAlerts();
        afwPage.triggerSimpleAlert();
        afwPage.triggerTimerAlert();
        afwPage.triggerConfirmAlert();
        afwPage.triggerPromtAlert();
    }

    @Test
    public void tabsAndWindowsTest() {
        afwPage.openBrowserWindows();
        afwPage.clickNewTabButton();
        afwPage.clickNewWindowButton();
        afwPage.clickNewMessageWindowButton();
    }
}
