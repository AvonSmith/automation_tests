package data_provider;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "params")
    public static Object[][] params(){
        return new Object[][] {{"Avon Smith"}, {"1234567890"}, {"! #$%&'*+-/=?^_`{|}~"}, {"Петр Саныч"}};
    }
}
