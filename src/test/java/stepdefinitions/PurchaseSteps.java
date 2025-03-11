package stepdefinitions;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageobjects.CartPage;
import pageobjects.ComputersPage;
import pageobjects.DesktopsPage;
import pageobjects.HomePage;
import utility.*;

public class PurchaseSteps {
    HomePage homePage;
    ComputersPage computersPage;
    DesktopsPage desktopsPage;
    CartPage cartPage;
    ExtentTest test;
    WebDriver driver;

    @Given("User is on Demo Web Shop homepage")
    public void user_is_on_demo_web_shop_homepage() {
        driver = Hooks.driver;
        driver.get("https://demowebshop.tricentis.com/");
        
        test = ExtentReportManager.createTest("Purchase Test");
        test.info("User is navigating to Demo Web Shop homepage");
        LoggerUtil.info("Navigating to Demo Web Shop homepage");
        
        homePage = new HomePage(driver);
        computersPage = new ComputersPage(driver);
        desktopsPage = new DesktopsPage(driver);
        cartPage = new CartPage(driver);
    }

    @When("User clicks on Computers link")
    public void user_clicks_on_computers_link() {
        LoggerUtil.info("Clicking on Computers link");
        test.info("User clicked on Computers link");
        homePage.clickOnComputers();
    }

    @When("User selects Desktops")
    public void user_selects_desktops() {
        LoggerUtil.info("Clicking on Desktops category");
        test.info("User clicked on Desktops category");
        computersPage.clickOnDesktops();
    }

    @When("User clicks on the first desktop")
    public void user_clicks_on_the_first_desktop() {
        LoggerUtil.info("Clicking on the first desktop");
        test.info("User clicked on the first desktop");
        desktopsPage.selectFirstDesktop();
    }

    @When("User adds the desktop to the cart")
    public void user_adds_the_desktop_to_the_cart() {
        LoggerUtil.info("Adding the desktop to the cart");
        test.info("User added the desktop to the cart");
        desktopsPage.goToCart();
        ScreenshotUtil.captureScreenshot(driver, "AddedToCart");
    }

    @When("User opens the cart")
    public void user_opens_the_cart() {
        LoggerUtil.info("Opening the cart");
        test.info("User opened the cart");
        cartPage.openCart();
    }

    @When("User selects I agree with the terms of service and I adhere to them unconditionally")
    public void user_selects_terms_and_conditions() {
        LoggerUtil.info("Selecting terms of service checkbox");
        test.info("User agreed with the terms of service");
        cartPage.acceptTermsAndConditions();
    }

    @When("User clicks on checkout button")
    public void user_clicks_on_checkout_button() {
        LoggerUtil.info("Clicking on checkout button");
        test.info("User clicked on checkout button");
        cartPage.proceedToCheckout();
        ScreenshotUtil.captureScreenshot(driver, "CheckoutPage");
    }

    @Then("User should be on the checkout page")
    public void user_should_be_on_checkout_page() {
        String expectedTitle = "Checkout";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            LoggerUtil.info("Checkout page title is correct: " + actualTitle);
            test.pass("Test passed: User is on the correct checkout page");
        } else {
            LoggerUtil.error("Checkout page title is incorrect. Expected: " + expectedTitle + ", but found: " + actualTitle);
            test.fail("Test failed: User is not on the correct checkout page");
            ScreenshotUtil.captureScreenshot(driver, "CheckoutPage_Error");
        }
    }
}
