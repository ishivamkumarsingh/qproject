package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.xpath("//input[@value='Log in']");
    private By welcomeMessage = By.className("account");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void verifyLoginSuccess() {
        WebElement userAccount = driver.findElement(welcomeMessage);
        Assert.assertTrue(userAccount.isDisplayed(), "Login was not successful");
    }
}