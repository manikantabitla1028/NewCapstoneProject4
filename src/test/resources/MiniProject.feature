Feature: Mini Project with Selenium and BDD

  Scenario: Verify multiple functionalities on the website
    Given I launch the application "http://the-internet.herokuapp.com/"
    Then I verify the title of the page is "The Internet"
    When I click on "A/B Testing" link
    Then I verify the text on the page is "A/B Test Control"
    And I navigate back to the home page
    When I click on "Dropdown" link
    And I select "Option 1" from the dropdown
    Then I verify the dropdown value is selected
    And I navigate back to the home page
    When I click on "Frames" link
    Then I verify the following links are present on the Frames page:
      | Nested Frames |
      | iFrame        |