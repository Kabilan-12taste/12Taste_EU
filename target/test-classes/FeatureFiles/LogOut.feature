Feature: To Check the 1-2 Taste Application Log Out Functionality

  Scenario: Verify user can log out with valid credentials
    Given the user logs into the application
    When the user clicks the center not username logout button
    Then the user should be redirected to the login page
    Given the user logs into the application again
    When the user clicks the side module logout button
	Then the user should be redirected to the again login page