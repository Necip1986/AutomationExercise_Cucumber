Feature: End to End Test

  @Demo
  Scenario: Demo End2End Test
    Given Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully
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
    And Close driver

  @Demo
  Scenario Outline: Create user
    Given set uri for creating user
    And set body for post request "<name>","<job>"
    Given send post request for creating user
    Then verify that status code is 201
    Examples:
      | name    | job     |
      | Mahmut  | Doctor  |
      | Johnson | Teacher |