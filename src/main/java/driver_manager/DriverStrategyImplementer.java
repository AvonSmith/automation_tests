package driver_manager;

public class DriverStrategyImplementer {
    public static DriverStrategy setDriver(String browser) {
        switch (browser) {
            case "chrome":
                return new Chrome();
            case "firefox":
                return new Firefox();
            default:
                return null;
        }
    }
}
