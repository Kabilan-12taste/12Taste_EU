Feature: To Check the 1-2 Taste Application New Registartion Functionality

  Scenario: Verify user can Registartion with his details
    Given the user is on the registration page
    When the user enters as first name
    And the user enters last name
    And the user enters as email
    And the user clicks the register button
	Then the user should be redirected to the confirmation page