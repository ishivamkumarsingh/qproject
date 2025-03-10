package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DesktopsPage {
    static WebDriver driver;

    public DesktopsPage(WebDriver driver) {
        this.driver = driver;
    }

    private static By firstDesktop = By.xpath("(//input[@value='Add to cart'])[1]");
    private By cartLink = By.xpath("//span[@class='cart-label']");

    public static void selectFirstDesktop() {
        driver.findElement(firstDesktop).click();
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}
