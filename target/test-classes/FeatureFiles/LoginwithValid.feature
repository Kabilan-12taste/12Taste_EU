Feature: To Check the 1-2 Taste Application Login Functionality

  Scenario: Verify user can log in with valid credentials
    Given the user is on the login page
    When the user enters a valid email
    And the user enters a valid password
    And the user clicks the login button
    Then the user should be redirected to the dashboard