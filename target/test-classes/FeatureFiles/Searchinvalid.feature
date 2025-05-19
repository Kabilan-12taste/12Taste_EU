Feature: To Check the 1-2 Taste Application Search Functionality

  Scenario: Search for an invalid product name
    Given User on the search page
    When User searches for an invalid product
    Then User should see a No Results Found message
    And User closes the tab