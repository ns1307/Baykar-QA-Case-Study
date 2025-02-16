@smoke
Feature: Language Change Functionality


  @changeLanguage
  Scenario Outline: User should be able to change site language
    Given User visits the Baykartech <language> site and views the site in that language
    When User clicks on the language change button
    Then the old language should appear on the button and the site URL should be different from old <language>
    Examples:
      | language |
      | tr       |
      | en       |


  @validatePageContentLanguageChange
  Scenario: When the language is changed, the page content should be updated
    Given User visits the Baykartech tr site and views the site in that language
    When User clicks on the language change button
    Then Page titles, menu items, and content should be updated to reflect the new language

  @verifyLanguageOptions
  Scenario: Provided languages should be statically verified
    Given The list of languages provided by the site is known
    And User sees one of the languages from the list on the language change button
    Then The supported languages in the HTML should match the known list


