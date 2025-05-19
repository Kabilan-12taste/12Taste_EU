Feature: To Check the 1-2 Taste Application Password Reset Functionality

  Scenario: Verify user can  set a new password with lost your password option
    Given the user clicks on Lost your password?
    When the user is redirected to the password reset page
    And the user enters their registered email in the reser password textbox
    And the user clicks on the reset password button
    And the user should receive a password reset email
	Then the user should see a success message