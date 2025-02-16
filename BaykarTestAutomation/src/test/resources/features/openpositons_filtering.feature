@smoke
Feature: Open Positions Filtering and Searching Test

  Scenario: The user should be able to filter by department and search for a position
    Given The user navigates to the open positions page in kariyer.baykartech
    When The user retrieves the list of available departments from the filters
    And The user selects a random department from the list
    And The user applies the selected department as a filter
    Then Only job postings related to the selected department should be displayed

    And The user selects a random position from the filtered job postings
    And The user enters this position into the search box and performs a search
    Then The title of each job posting in the search results should exactly match or contain the searched position
