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


  Scenario: TC_23 Verify address details in checkout page
    Given Click on Signup-Login link
    And Fill all details in Signup and create account
    Then Verify that ACCOUNT CREATED! is visible
    And Click Continue button
    Then Verify that -Logged in as username- is visible
    When Add products to cart
    And Click Continue Shopping button
    And Click Cart button
    Then Verify that cart page is displayed
    And Click Proceed To Checkout button
    Then Verify that the delivery address is same address filled at the time registration of account
    Then Verify that the billing address is same address filled at the time registration of account
    And Close driver

  @placeOrder
  Scenario: TC_24 Download Invoice after purchase order
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
    And Click Download Invoice button and verify invoice is downloaded successfully.
    And Click Continue button
    And Close driver



