Feature: 06_To Check then 1-2 taste Application Request a Quote Functionality

 Scenario: Request a Quote for a product
    Given User navigate to the product listing pages
    When User click on the Request a Quote button
    And User should be redirected to the quote details page
    And User fill in the quote request form with valid details
    And User click on the Send Your Request button
    And an email should be triggered with an order number
    Then User should be redirected to the order confirmation page with the Order ID