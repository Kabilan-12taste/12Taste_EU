Feature: 04_To Check the 1-2 Taste Application Search Functionality

  Scenario: Search for a valid product and apply random filters
    Given User is on the search page
    When User searches for a valid product
    And User selects random one from Application Area
    And User selects Best Selling from Default Sorting
    And User selects random Dietary Certification filters
    And User selects random Labels & Marks filters
    And User applies the filters
    Then User should see relevant search results
  

 