Feature: Address Management for Billing and Shipping

  Scenario: Add/Edit a Billing address and ensure successful update
    Given User is logged in to the application and is redirected to the dashboard
    When User clicks on the Address menu and navigates to the Billing Address page
    And User fills in the Billing Address fields with valid data
    And User clicks the Save Address button
    Then User should see a confirmation message.


  Scenario: Add/Edit a Shipping address and ensure successful update
    Given User is logged in to the application and is redirected to the dashboard
    When User clicks on the Address menu and navigates to the Shipping Address page
    And User fills in the Shipping Address fields with valid data
    And User clicks the Save Address button
    Then User should see the confirmation message 
