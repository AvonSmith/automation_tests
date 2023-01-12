package data_provider;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "params")
    public static Object[][] params(){
        return new Object[][] {{"Avon Smith"}, {"1234567890"}, {"! #$%&'*+-/=?^_`{|}~"}, {"Петр Саныч"}};
    }

    @DataProvider(name = "email")
    public static Object[][] email() {
        return new Object[][] {{"ivan@gmail.com"}, {"1234567890@emails.tinkoff.ru"}, {"IVAN@11111.ru"}};
    }

    @DataProvider(name = "address")
    public static Object[][] address() {
        return new Object[][] {{"Москва, Красная площадь, 1"}, {"Moscow, Krasnaya ploshchad, 1"}};
    }
}
