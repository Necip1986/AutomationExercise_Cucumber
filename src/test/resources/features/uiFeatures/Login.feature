Feature: Login function

  Background: Common steps for login function
    When Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully
    When Click on Signup-Login link
    Then Verify -Login to your account- is visible



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
      | adnan1234@gmail.com    | adna    |



  Scenario: Login User with incorrect email and password
    Given Enter incorrect email address and password
    And Click login button
    Then  Verify error -Your email or password is incorrect!- is visible
    And Close driver

  @login
  Scenario: Login User with correct email and password
    Given Enter correct email address and password
    And Click login button
    Then Verify that -Logged in as username- is visible
    When  Click Logout button
    Then Verify that user is navigated to login page
    And Close driver