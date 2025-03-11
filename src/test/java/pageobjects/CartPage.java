package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
 
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
   
    private By cartButton = By.xpath("//span[@class='cart-label']");
    private By shoppingCart = By.xpath("//*[@id=\"topcartlink\"]/a/span[1]");
    private By termsCheckbox = By.id("termsofservice");
    private By checkoutButton = By.xpath("//input[contains(@class,'checkout-button')]");

    public void openCart() {
        driver.findElement(cartButton).click();
    }

    public void acceptTermsAndConditions() {
        if (!driver.findElement(termsCheckbox).isSelected()) {
            driver.findElement(termsCheckbox).click();
        }
    }

    public void proceedToCheckout() {
        acceptTermsAndConditions();
        driver.findElement(checkoutButton).click();
    }
}
