Feature: To Check then 1-2 taste Application Add to Cart Functionality

  Scenario: Add a product to the cart
    Given User navigate to the product listing page
    When User increase the quantity using the plus button
    And User click on the Add to Cart button
    Then User should see a confirmation message with the product name
    And the product should be added to the cart

  #Scenario: Request a Quote for a product
    #Given User navigate to the product listing page
    #When User click on the Request a Quote button
    #Then User should be redirected to the quote details page
    #When User increase the quantity using the plus button
    #And User fill in the quote request form with valid details
    #And User click on the Send Your Request button
    #Then an email should be triggered with an order number
    #And User should be redirected to the order confirmation page with the Order ID