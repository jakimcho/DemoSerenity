# new feature
# Tags: optional

Feature: Account Registration

  @debug
  Scenario: Successful Registration
    Given John is on the login page
    And he has started an account registration with "jhondsnow@south.go" email
    When John enters his personal details:
      | title | firstName | lastName | password    | dataOfBirth      |
      | Mr.   | John      | Snow     | password123 | 28-February-1985 |
    And he enters his address details:
      | address | city  | state  | zip   | country       | mobilePhone | addressAlias |
      | gate 13 | South | Alaska | 14253 | United States | 42342342343 | TheWall      |
    And he submits his registration details
    Then the registration is successful
    And John is logged in successfully