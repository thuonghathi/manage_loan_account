
Feature: Input detail account

  Background:  I register new account
    Given I navigate to the Login page
    And I am on the Login page
    When I click register button
    Then I am on the Registration page
    Given I input full name is "interviewer"
    When I input the email is "@yopmail.com"
    Given I select the country is "Argentina"
    And I input ramdom the phone number
    And I select the role in company is "Director"
    And I hear about company from "Google"
    And I input promo code is "AC001"
    And I agree with terms and condition
    And I click countinue button
    And I enter phone OTP
    Then I am on the Completed Page

  @editinfo
  Scenario Outline:  input info new account
    Given I click countinue button at Completed Page
    When I choose type of company is Business
    And I click Standard button
    And I am on the Detail View Page
    And I click started edit info
    # user is on personal detai
    And I input Identity Card Number
    And I select day of birth is "10-10-1990"
    And I select Nationality is "Albania"
    And I select Gender is "Female"
    And I select products interested is "Debit Account"
    And I click submit button
    And I enter phone OTP
    # user is on business-view
    And I am on the Business View Page
    And I click started edit Business
    And I input Business Name
    And I select Registration Parent Type is "<Parent type>"
    And I select Registration Type is "<type>"
    And I input random Business Registration Number
    And I input Business website
    And I select Industry is "<Industry>"
    And I select Sub Industry is "<Sub Industry>"
    Then I click submit button
    And I am on the Identify View page

    Examples:
      | Parent type       | type                          | Industry      | Sub Industry |
      | Limited companies | Limited Liability Partnership | Manufacturing | Chemicals    |