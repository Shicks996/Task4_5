Feature: Search with empty input
  As a user
  I want to be notified when I click search without entering text
  So that I understand why no results are shown

  Scenario: User clicks search button without entering input
    Given the user is on the Wiggle homepage
    When the user clicks the search icon without typing anything
    Then the user should stay on the homepage or see a validation message