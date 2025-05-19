# update_account.feature
Feature: To Check the 1-2 Taste site Update account information in "My Account" section

  Scenario: User successfully updates account details
    Given User should logged in to the application
    When User enter new data with first name,last name, display name, email address, new password, and confirm password 
    And User click the save changes button
    Then User should see a success message saying

  Scenario: User fails to update account with mismatched passwords
    Given User logged in to the application
    When User enter new data with first name,last name, display name, mail address, new password, and confirm password 
    And User click the save changes button1
    Then User should see an error message saying

  Scenario: User updates account without changing password
    Given User log in to the application
    When User enter new data with first name,last name, display name, email address, new pass, and confirm pass
    And User click the save changes button2
    Then User should see an error msg saying
