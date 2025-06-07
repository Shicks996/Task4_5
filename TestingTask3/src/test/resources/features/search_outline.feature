Feature: Product Search

  Scenario Outline: User searches for various products

    Given the user is on the Wiggle homepage
    When the user searches for "<keyword>"
    Then search results for "<keyword>" are shown

    Examples:
      | keyword     |
      | helmet      |
      | bike        |
      | jersey      |