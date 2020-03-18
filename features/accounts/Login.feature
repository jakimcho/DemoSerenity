# new feature
# Tags: optional

Feature: Login

  Background:
    Given John is on the login page

  Scenario: Successful Imperative Login
    When I enter "johngo@fsdfs.coy" in username field
    And I enter "password123" in password field
    And I click on login submit button
    Then I should lend on my home page
    And I should see "Welcome back Me"

  Scenario: Successful Declarative Login
    When John logs in with:
      | username         | password   |
      | johngo@fsdfs.coy | password13 |
    Then Johngo is logged in successfully