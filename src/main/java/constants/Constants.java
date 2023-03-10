package constants;

public class Constants {
    public static class TimeoutVariable {
        public static final int IMPLICIT_WAIT = 20;
        public static final int EXPLICIT_WAIT = 20;
    }
    public static class ConnectorsVariables {
        public static final String CHROME = "chrome";
        public static final String FIREFOX = "firefox";
        public static final String SELENIUM_URL = "http://localhost:4444/wd/hub";
    }
    public static class Urls {
        public static final String MAIN_URL = "main_url";
        public static final String TEXT_BOX_URL = "text_box_url";
        public static final String CHECK_BOX_URL = "check_box_url";
        public static final String RADIO_BUTTON_URL = "radio_button_url";
        public static final String WEB_TABLES_URL = "web_tables_url";
        public static final String BUTTONS_URL = "buttons_url";
        public static final String LINKS_URL = "links_url";
        public static final String DYNAMIC_PROPERTIES_URL = "dynamic_properties_url";
    }
    public static class Selectors {
        public static final String YES_RADIOBUTTON = "Yes";
        public static final String IMPRESSIVE_RADIOBUTTON = "Impressive";
        public static final String COLOR_ATTRIBUTE = "color";
        public static final String RED_COLOR = "rgba(220, 53, 69, 1)";
        public static final int FROM = 3;
        public static final int TO = 5;
        public static final String LIST = "list";
        public static final String GRID = "grid";
    }
    public static class UserData {
        public static final String FIRST_NAME = "firstname";
        public static final String LAST_NAME = "lastname";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String ADDRESS = "address";
    }
}
