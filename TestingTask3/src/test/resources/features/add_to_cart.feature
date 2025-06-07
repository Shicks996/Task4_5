Feature: Add a product to cart

  Scenario: Search for a product and add it to the cart

    Given the user is on the Wiggle homepage
    When the user searches for "helmet"
    And the user clicks on the first product
    And the user adds the product to the cart
    Then the product should appear in the shopping cart