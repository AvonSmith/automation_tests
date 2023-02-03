package tests;

import constants.Hobbies;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Month;

import static constants.Constants.Urls.MAIN_URL;
import static constants.Constants.UserData.*;
import static constants.Genders.MALE;

public class FormsTest extends BaseTest {

    @BeforeTest
    public void practiceForm() {
        page.open(frameworkProperties.getProperty(MAIN_URL));
        formsPage.openPracticeForm();
    }

    @Test
    public void formTest() {
        formsPage.enterFirstName(frameworkProperties.getProperty(FIRST_NAME))
                .enterLastName(frameworkProperties.getProperty(LAST_NAME))
                .enterEmail(frameworkProperties.getProperty(EMAIL))
                .pickGender(MALE)
                .enterPhoneNumber(frameworkProperties.getProperty(PHONE))
                .enterDateOfBirth(12, Month.AUGUST, 1988)
                .pickHobbies(Hobbies.SPORT, Hobbies.MUSIC)
                .enterCurrentAddress(frameworkProperties.getProperty(ADDRESS))
                .submit();
    }
}
