# new feature
# Tags: optional

Feature: Login

  Background:
    Given John is on the login page

  Scenario: Successful Imperative Login
    When I enter "johngo" in username field
    And I enter "password123" in password field
    And I click on login submit button
    Then I should lend on my home page
    And I should see "Welcome back Me"

  Scenario: Successful Declarative Login
    When John logs in with:
      | username | password   |
      | johngo   | password13 |
      | johngo   | password23 |
    Then John should login successfully
