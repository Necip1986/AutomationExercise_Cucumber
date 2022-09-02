Feature: Place Order function

  Background: common steps for place order
    Given Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully


  Scenario: TC_14 Place Order: Register while Checkout
    When Add products to cart
    And Click Continue Shopping button
    And Click Cart button on landing page
    Then Verify that cart page is displayed
    When Click Proceed To Checkout button
    And Click Register_Login button
    And Fill all details in Signup and create account
    Then Verify that ACCOUNT CREATED! is visible
    When Click Continue button
    Then Verify that -Logged in as username- is visible
    When Click Cart button
    And Click Proceed To Checkout btn
    Then Verify "Address Details" and "Review Your Order" are visible
    And Enter description in comment text area and click Place Order button
    And Enter payment details: Name on Card, Card Number, CVC, Expiration date
    Then Verify success message 'Congratulations! Your order has been confirmed!' is visible
    And Close driver


  Scenario: TC_15 Place Order: Register before Checkout
    When Click on Signup-Login link
    And Fill all details in Signup and create account
    Then Verify that ACCOUNT CREATED! is visible
    When Click Continue button
    Then Verify that -Logged in as username- is visible
    When Add products to cart
    And Click Continue Shopping button
    And Click Cart button on landing page
    Then Verify that cart page is displayed
    When Click Proceed To Checkout button
    Then Verify "Address Details" and "Review Your Order" are visible
    And Enter description in comment text area and click Place Order button
    And Enter payment details: Name on Card, Card Number, CVC, Expiration date
    Then Verify success message 'Congratulations! Your order has been confirmed!' is visible
    And Close driver

  @placeOrder
  Scenario: TC_15 Place Order: Register before Checkout
    When Click on Signup-Login link
    And Fill email, password and click Login button
    Then Verify that ACCOUNT CREATED! is visible
    When Click Continue button
    Then Verify that -Logged in as username- is visible
    When Add products to cart
    And Click Continue Shopping button
    And Click Cart button on landing page
    Then Verify that cart page is displayed
    When Click Proceed To Checkout button
    Then Verify "Address Details" and "Review Your Order" are visible
    And Enter description in comment text area and click Place Order button
    And Enter payment details: Name on Card, Card Number, CVC, Expiration date
    Then Verify success message 'Congratulations! Your order has been confirmed!' is visible
    And Close driver

