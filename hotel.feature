@web @regression
Feature: Hotel Dropdown feature


  @dropdown
  Scenario Outline: Verify room count dropdown
    Given I am on hotels.com home page
    Then I select rooms as "<select_rooms>"
    And I verify displayed "<number_of_room_dropdown>"

    Examples:
    | select_rooms  | number_of_room_dropdown |
    | 2             | Room 2:                 |
    | 3             | Room 3:                 |





    @propertyClass
    Scenario Outline: Verify user can only view the result by selected property class
      Given I am on hotels.com home page
      Then I click search button to get default locations search result screen
      When I select property class "<stars>"
      Then I verify hotels on search result system displays only "<stars>"

      Examples:
        | stars   |
        | 5 stars |
        | 4 stars |
        | 3 stars |

#    @radius
#    Scenario Outline: List of all of hotel within 10 miles radius of airport or downtown
#      Given I am on default locations search result screen
#      Then I verify system displays all hotels within 10 miles radius of airport
#      And I verify Hilton Hotel is within radius


   @deal
   Scenario: Verify todays deal price value
     Given I am on hotels.com home page
     Then I click search button to get default locations search result screen
     Then I verify todays deal is less than $200