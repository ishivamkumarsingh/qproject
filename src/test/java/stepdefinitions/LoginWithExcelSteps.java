package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.LoginPage;
import utility.ExcelReader;
import utility.DriverFactory;
import java.io.IOException;

public class LoginWithExcelSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://demowebshop.tricentis.com/login");
    }

    @When("User enters credentials from {string} and sheet {string}")
    public void user_enters_credentials_from_excel(String fileName, String sheetName) throws IOException {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName;
        String username = ExcelReader.getCellValue(filePath, sheetName, 1, 0);
        String password = ExcelReader.getCellValue(filePath, sheetName, 1, 1);
        
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        loginPage.verifyLoginSuccess();
    }
}
