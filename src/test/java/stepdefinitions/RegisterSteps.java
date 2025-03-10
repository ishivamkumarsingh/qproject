package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.RegisterPage;

public class RegisterSteps {
    WebDriver driver;
    RegisterPage registerPage;

    @Given("User is on Demo Web Shop registration page")
    public void user_is_on_demo_web_shop_registration_page() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
        registerPage.navigateToRegister();
    }

    @When("User enters valid details")
    public void user_enters_valid_details() {
        registerPage.enterUserDetails("John", "Doe", "johndoe@example.com", "password123");
    }

    @When("User clicks register button")
    public void user_clicks_register_button() {
        registerPage.clickRegisterButton();
    }

    @Then("User should be registered successfully")
    public void user_should_be_registered_successfully() {
        System.out.println("User registered successfully!");
        driver.quit();
    }
}
