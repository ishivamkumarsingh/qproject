package utility;

import org.openqa.selenium.WebDriver;
import stepdefinitions.Hooks;

public class DriverFactory {
    public static WebDriver getDriver() {
        return Hooks.driver;
    }
}