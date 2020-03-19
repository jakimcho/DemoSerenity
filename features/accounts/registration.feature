# new feature
# Tags: optional

Feature: Account Registration

  As a new comer
  I want to register new account
  In order to use site functionalities

  <h3>Acceptance Criteria</h3>
  <ul>
  <li>System should validate user input</li>
  <li>System should create new account upon valid user data submit</li>
  <li>System should fail registration upon invalid data</li>
  <li>Correct error messages are displayed for the invalid data/li>
  </ul>

  Scenario: Successful Registration
    Given John is on the login page
    And he has started an account registration with "jhondsnow[4a]@south.go" email
    When John enters his personal details:
      | title | firstName | lastName | password        | dataOfBirth      |
      | Mr.   | John[3A]  | Snow[5a] | password123[4] | 28-February-1985 |
    And he enters his address details:
      | address | city  | state  | zip   | country       | mobilePhone | addressAlias |
      | gate 13 | South | Alaska | 14253 | United States | 42342342343 | TheWall      |
    And he submits his registration details
    Then the registration is successful
    And John is logged in successfully

  Scenario Outline: Unsuccessful Registration
    ! System should not allow user registration with invalid data
    Given John is on the login page
    And he has started an account registration with "jhondsnow@south.go" email
    When John enters his personal details:
      | title   | firstName    | lastName    | password   | dataOfBirth     |
      | <title> | <first_name> | <last_name> | <password> | <data_of_birth> |
    And he enters his address details:
      | address   | city   | state   | zip   | country   | mobilePhone    | addressAlias    |
      | <address> | <city> | <state> | <zip> | <country> | <mobile_phone> | <address_alias> |
    And he submits his registration details
    Then error "<error_message>" message should display

    Examples:
      | title | first_name | last_name | password    | data_of_birth    | address | city  | state  | zip   | country       | mobile_phone | address_alias | error_message |
      | Mr.   | John       | Snow      | password123 | 28-February-1985 | gate 13 | South | Alaska | 14253 | United States | 42342342343  | TheWall       | ??            |
      | Mr.   | John       | Snow      | password123 | 28-February-1985 | gate 13 | South | Alaska | 14253 | United States | 42342342343  | TheWall       | ??            |
      | Mr.   | John       | Snow      | password123 | 28-February-1985 | gate 13 | South | Alaska | 14253 | United States | 42342342343  | TheWall       | ??            |
      | Mr.   | John       | Snow      | password123 | 28-February-1985 | gate 13 | South | Alaska | 14253 | United States | 42342342343  | TheWall       | ??            |
      | Mr.   | John       | Snow      | password123 | 28-February-1985 | gate 13 | South | Alaska | 14253 | United States | 42342342343  | TheWall       | ??            |
      | Mr.   | John       | Snow      | password123 | 28-February-1985 | gate 13 | South | Alaska | 14253 | United States | 42342342343  | TheWall       | ??            |