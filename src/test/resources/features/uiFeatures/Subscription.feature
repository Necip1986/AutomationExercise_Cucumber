Feature: Subscription function


  Scenario: Verify Subscription in home page
    Given Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully
    When Scroll down to footer
    Then Verify text 'SUBSCRIPTION' is visible
    Given Enter email address in input and click arrow button
    Then Verify success message 'You have been successfully subscribed!' is visible
    And Close driver

  @subscription
  Scenario: Verify Subscription in Cart page
    Given Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully
    When Click Cart button
    When Scroll down to footer
    Then Verify text 'SUBSCRIPTION' is visible
    Given Enter email address in input and click arrow button
    Then Verify success message 'You have been successfully subscribed!' is visible
    And Close driver

