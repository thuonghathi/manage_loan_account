@login
Feature: Login page

  Background:  I navigate to the Login page
    Given I navigate to the Login page
    And I am on the Login page

  @phone
  Scenario Outline:  Login with phone
    Given I select the country is "<country>"
    When I input the phone number is "<phone>"
    And I click login button
    Then I enter phone OTP
    And I am on the Onboarding page

    Examples:
      | country   | phone    |
      | Argentina | 88344498 |

  @email
  Scenario Outline:  Login with phone
    Given I click login with email button
    Given I input the email is "<email>" to login
    And I click login button
    Then I enter phone OTP
    And I am on the Onboarding page

    Examples:
      | email            |
      | test@yopmail.com |