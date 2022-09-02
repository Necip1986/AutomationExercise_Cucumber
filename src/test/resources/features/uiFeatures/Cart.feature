Feature: Cart Function

  Background: common steps for place order
    Given Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully

  Scenario: TC_012 Add Products in Cart
    When Click on Products button
    And Hover over first product and click Add to cart
    And Click Continue Shopping button
    And Hover over second product and click Add to cart
    And Click View Cart button
    Then Verify both products are added to Cart
    And Close driver


  Scenario: TC_13 Verify Product quantity in Cart
    When Click on Products button
    When Click on View Product of first product
    Then Verify user is landed to product detail page
    When Increase quantity to "4"
    And Click Add to cart button
    And Click View Cart button
    Then Verify that product is displayed in cart page with exact quantity
    And Close driver


  Scenario: TC_017 Remove Products From Cart
    And Add products to cart
    And Click Continue Shopping button
    And Click Cart button
    Then Verify that cart page is displayed
    When Click X button corresponding to particular product
    Then Verify that product is removed from the cart
    And Close driver


  Scenario: TC_20 Search Products and Verify Cart After Login
    When Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    And Enter product name in search input and click search button
    Then Verify 'SEARCHED PRODUCTS' is visible
    Then Verify all the products related to search are visible
    When Add those products to cart
    Then Click Cart button and verify that products are visible in cart
    Then Click Signup-Login button and submit login details
    And Again, go to Cart page
    Then Verify that those products are visible in cart after login as well
    And Close driver

  @cart
  Scenario: TC_22 Add to cart from Recommended items
    When Scroll to bottom of page
    Then Verify 'RECOMMENDED ITEMS' is visible
    And Click on Add To Cart on Recommended product
    And Click Continue Shopping button
    And Click on View Cart button
    Then Verify that product is displayed in cart page
    And Close driver

