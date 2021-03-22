package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.text.ParseException;

public class OnBoardingStep {
    private BaseSteps app = BaseSteps.getInstance();

    @Then("I am on the Onboarding page")
    public void i_am_on_the_Onboarding_page() {
        app.getOnboardingPage().isOnBoardingPage();
    }

    @Given("I choose type of company is Business")
    public void iChooseTypeOfCompanyIsBusiness() {
        app.getOnboardingPage().chooseBusinessOrNonBusiness("Business");
        app.getOnboardingPage().isOnRegistrationPage();
    }

    @Given("I click countinue button at Completed Page")
    public void iClickCountinueButtonAtCompletedPage() {
        app.getOnboardingPage().clickContinueButton();
        app.getOnboardingPage().isOnIncorporatePage();
    }

    @When("I click My Info button")
    public void iClickMyInfoButton() {
        app.getOnboardingPage().chooseInfoOrStandard("MyInfo");
        app.getOnboardingPage().isOnIncorporatePage();
    }

    @When("I click Standard button")
    public void iClickStandardButton() {
        app.getOnboardingPage().chooseInfoOrStandard("Standard");

    }

    @And("I am on the Detail View Page")
    public void iAmOnTheDetailViewPage() {
        app.getOnboardingPage().isOnPersonalViewPage();
    }

    @And("I click started edit info")
    public void iClickStartedEditInfo() {
        app.getOnboardingPage().clickContinueEditButton();
        app.getOnboardingPage().isOnPersonalEditPage();
    }

    @And("I input Identity Card Number")
    public void iInputIdentityCardNumber() {
        app.getOnboardingPage().inputIdentityCard();
    }

    @And("I select day of birth is {string}")
    public void iSelectDayOfBirthIs(String arg0) throws ParseException, InterruptedException {
        app.getOnboardingPage().selectDayOfBirth(arg0);
    }

    @Then("I click submit button")
    public void iClickSubmitButton() throws InterruptedException {
        app.getOnboardingPage().clickSubmitButton();

    }

    @And("I select Nationality is {string}")
    public void iSelectNationalityIs(String arg0) {
        app.getOnboardingPage().chooseNationality(arg0);
    }

    @And("I select Gender is {string}")
    public void iSelectGenderIs(String arg0) {
        app.getOnboardingPage().chooseGender(arg0);
    }

    @And("I select products interested is {string}")
    public void iSelectProductsInterestedIs(String arg0) {
        app.getOnboardingPage().chooseProductsInterested(arg0);
    }

    @And("I am on the Business View Page")
    public void iAmOnTheBusinessViewPage() {
        app.getOnboardingPage().isOnBusinessViewPage();
    }

    @And("I click started edit Business")
    public void iClickStartedEditBusiness() {
        app.getOnboardingPage().clickContinueEditButton();
        app.getOnboardingPage().isOnBusinessEditPage();
    }

    @And("I input Business Name")
    public void iInputBusinessName() {
        app.getOnboardingPage().inputBusinessName();
    }

    @And("I select Registration Parent Type is {string}")
    public void iSelectRegistrationParentTypeIs(String arg0) {
        app.getOnboardingPage().selectRegistrationParentType(arg0);
    }

    @And("I input random Business Registration Number")
    public void iInputRandomBusinessRegistrationNumber() {
        app.getOnboardingPage().inputBusinessNumber();
    }

    @And("I input Business website")
    public void iInputBusinessWebsite() {
        app.getOnboardingPage().inputBusinessWebsite();
    }

    @And("I select Registration Type is {string}")
    public void iSelectRegistrationTypeIs(String arg0) {
        app.getOnboardingPage().selectRegistrationType(arg0);
    }

    @And("I select Industry is {string}")
    public void iSelectIndustryIs(String arg0) {
        app.getOnboardingPage().selectIndustry(arg0);
    }

    @And("I select Sub Industry is {string}")
    public void iSelectSubIndustryIs(String arg0) {
        app.getOnboardingPage().selectSubIndustry(arg0);
    }

    @And("I am on the Identify View page")
    public void iAmOnTheIdentifyViewPage() {
        app.getOnboardingPage().isOnIdentifyViewPage();
    }
}
