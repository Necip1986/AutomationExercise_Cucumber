Feature: Products function

  Background: Common steps for products function
    Given Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully

  Scenario: Verify All Products and product detail page
    When Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    When Click on View Product of first product
    Then Verify user is landed to product detail page
    Then Verify that detail detail is visible: product name, category, price, availability, condition, brand
    And Close driver


  Scenario: Search Product
    When Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    When Enter product name in search input and click search button
    Then Verify 'SEARCHED PRODUCTS' is visible
    Then Verify all the products related to search are visible
    And Close driver


  Scenario: TC_018 View Category Products
    Then Verify that categories are visible on left side bar
    When Click on Women category
    And Click on any category link under Women category, for example: Dress
    Then Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'
    When On left side bar, click on any sub-category link of Men category
    Then Verify that user is navigated to that category page
    And Close driver


  Scenario: TC_19 View & Cart Brand Products
    When Click on Products button
    Then Verify that Brands are visible on left side bar
    When Click on any brand name
    Then Verify that user is navigated to brand page and brand products are displayed
    And On left side bar, click on any other brand link
    Then Verify that user is navigated to that brand page and can see products
    And Close driver

  @products
  Scenario: TC_21 Add review on product
    When Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    And Click on View Product button
    Then Verify 'Write Your Review' is visible
    When Enter name, email and review
    And Click submit button
    Then Verify success message 'Thank you for your review.' is visible
    And Close driver