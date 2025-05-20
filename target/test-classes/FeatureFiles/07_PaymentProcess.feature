Feature: To Check the 1-2 Taste Payment Process 

  Scenario: User completes the payment process
    Given User is on the cart page after adding items
    When User clicks on the Proceed to Checkout button
    Then User is navigated to the Billing Details page
    When User enters valid billing details and clicks Continue
    Then User is navigated to the Shipping Details page
    When User enters valid shipping details and clicks Continue
    Then User is navigated to the Order Comments page
    When User enters order comments and clicks Continue
    Then User is navigated to the Payment Options page
    When User selects the Payment Method payment option
    And User agrees to the terms and conditions
    And User clicks on the Process to Payment button
    Then A QR code should appear for UPI payments
