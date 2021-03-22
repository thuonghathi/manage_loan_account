
Feature: Register new account

  Background:  I go to the register page
    Given I navigate to the Login page
    And I am on the Login page
    When I click register button
    Then I am on the Registration page

  @register
  Scenario Outline:  Register New Account
    Given I input full name is "<Full Name>"
    When I input the email is "<Email>"
    Given I select the country is "<country>"
    And I input ramdom the phone number
    And I select the role in company is "Director"
    And I hear about company from "Google"
    And I input promo code is "AC001"
    And I agree with terms and condition
    And I click countinue button
    And I enter phone OTP
    Then I am on the Completed Page

    Examples:
      | Full Name   | Email        | country   |
      | Interviewer | @example.com | Argentina |