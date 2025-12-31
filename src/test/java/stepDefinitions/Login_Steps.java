
package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class Login_Steps extends Base_PO {
    private final Login_PO login_po;

    // ✅ Cucumber needs a public zero-argument constructor
    public Login_Steps() {
        super();                // Base_PO initializes PageFactory with your driver
        this.login_po = new Login_PO();  // Create the page object yourself
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        login_po.navigateTo_WebDriverUniversity_Login_Page();
    }

    // ⚠️ Use Cucumber parameter types like {string} or {word}, not bare {}
    @When("I enter a username {string}")
    public void i_enter_a_username(String username) {
        login_po.setUsername(username);
    }

    @And("I enter a password {string}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        login_po.clickOn_Login_Button();
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
        login_po.validate_SuccessfulLogin_Message();
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        login_po.validate_UnsuccessfulLogin_Message();
    }

    @Then("I should be presented with the following login validation message {string}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        waitForAlert_And_ValidateText(expectedMessage);
    }
}
