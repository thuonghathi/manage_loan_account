package stepdefinitions;


import cucumber.api.java.en.*;

public class RegistrationStep {
    private BaseSteps app = BaseSteps.getInstance();

    @Then("I am on the Registration page")
    public void iAmOnTheRegistrationPage() throws Throwable {
        app.getRegistrationPage().isOnRegisterPage();
    }

    @Given("I input full name is {string}")
    public void i_input_full_name_is(String name) {
        app.getRegistrationPage().inputFullName(name);
    }

    @Given("I input the email is {string}")
    public void i_input_the_email_is(String email) {
        // Write code here that turns the phrase above into concrete actions
        app.getRegistrationPage().inputEmail(email);
    }

    @Given("I select the role in company is {string}")
    public void i_select_the_role_in_company_is(String string) {
        switch (string) {
            case "Director":
                app.getRegistrationPage().selectDerectorRole();
                break;
            case "Non-director":
                app.getRegistrationPage().selectNonDerectorRole();
                break;
        }
    }

    @Given("I hear about company from {string}")
    public void i_hear_about_company_from(String string) {

        app.getRegistrationPage().inputHearAboutUs(string);
    }

    @Given("I input promo code is {string}")
    public void i_input_promo_code_is(String string) {
        app.getRegistrationPage().inputPromoCode(string);
    }

    @Given("I agree with terms and condition")
    public void i_agree_with_terms_and_condition() {
        app.getRegistrationPage().checkTermCondition();
    }

    @Then("I click countinue button")
    public void i_click_countinue_button() {
        app.getRegistrationPage().clickContinueButton();

    }

    @Then("I enter phone OTP")
    public void i_enter_otp() throws InterruptedException {
        app.getRegistrationPage().inputPhoneOTP();
    }

    @Given("I select the country is {string}")
    public void iSelectTheCountryIs(String country) {
        app.getRegistrationPage().clickFlatCountry();
        app.getRegistrationPage().chooseCountry(country);
    }

    @And("I input ramdom the phone number")
    public void iInputRamdomThePhoneNumber() {
        app.getRegistrationPage().inputPhoneNumber();
    }

    @Then("I am on the Completed Page")
    public void iAmOnTheCompletedPage() throws InterruptedException {
        app.getRegistrationPage().isOnTheCompletePage();
    }
}
