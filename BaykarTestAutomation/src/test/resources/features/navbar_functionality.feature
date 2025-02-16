@smoke
Feature: Navbar Functionality Test

  @validateAllNavbarElements
  Scenario: Verify all navbar elements are clickable and pages open correctly
    Given User is on the Baykartech homepage
    When User clicks on each navbar element
    Then The opened page URL should match the button's href