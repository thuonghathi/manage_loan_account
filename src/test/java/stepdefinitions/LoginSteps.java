package stepdefinitions;

import cucumber.api.java.en.*;
public class LoginSteps extends BaseSteps {
    private BaseSteps app = BaseSteps.getInstance();


    @Given("I navigate to the Login page")
    public void openingLoginPage() throws Throwable {
        app.getLoginPage().navigateToLogin();
    }

    @Given("I am on the Login page")
    public void iOnTheLoginPage() throws Throwable {
        app.getLoginPage().isOnLoginPage();
    }

    @When("I click register button")
    public void clickingRegisterButton() throws Throwable {
        app.getLoginPage().clickRegisterButton();
    }

    @Given("I input the email is {string} to login")
    public void i_input_the_email_is_to_login(String string) {
        app.getLoginPage().inputEmail(string);
    }

    @Given("I click login button")
    public void i_click_login_button() {
        app.getLoginPage().clickLoginButton();
    }

    @When("I input the phone number is {string}")
    public void iInputThePhoneNumberIs(String phone) {
        app.getLoginPage().inputPhone(phone);
    }

    @Given("I click login with email button")
    public void iClickLoginWithEmailButton() {
        app.getLoginPage().clickLoginEmailButton();
    }
}
