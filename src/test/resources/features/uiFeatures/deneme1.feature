Feature: Deneme test


  Background: Common steps for login function
    When Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully
    When Click on Signup-Login link
    Then Verify -Login to your account- is visible



  @regression
  Scenario Outline: Login User with correct email and password
    Given Enter correct email address and password "<email>" , "<password>"
    And Click login button
    Then Verify that -Logged in as username- is visible
    When Click Delete Account button
    Then Verify that 'ACCOUNT DELETED!' is visible and click Continue button
    And Close driver
    Examples:
      | email                  | password |
      | mehmet762946@gmail.com | ahmet    |
      | mehmet1234@gmail.com   | ahmet    |
      | adnan1234@gmail.com    | adna     |