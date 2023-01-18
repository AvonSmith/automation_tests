package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Constants.Urls.MAIN_URL;

public class AlertsFrameWindowsTest extends BaseTest {

    @BeforeTest
    public void alertsFrameWindows() {
        page.open(frameworkProperties.getProperty(MAIN_URL));
        afwPage.openBrowserWindows();
    }

    @Test
    public void alertTest() {
        afwPage.triggerSimpleAlert();
        afwPage.triggerTimerAlert();
        afwPage.triggerConfirmAlert();
        afwPage.triggerPromtAlert();
    }
}
