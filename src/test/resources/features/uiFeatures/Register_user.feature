Feature: Register User

  Background: Common steps for register user
       When Navigate to url 'http://automationexercise.com'
       Then Verify that home page is visible successfully
       When Click on Signup-Login link
       Then Verify 'New User Signup!' is visible


  Scenario: Register user with valid credentials
       When Enter name and email address
       And Click Signup button
       Then Verify that -ENTER ACCOUNT INFORMATION- is visible
       When Fill details: Title, Name, Email, Password, Date of birth
       And Select checkbox -Sign up for our newsletter!-
       And Select checkbox -Receive special offers from our partners!-
       And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       And Click Create Account button
       Then Verify that ACCOUNT CREATED! is visible
       When Click Continue button
       Then Verify that -Logged in as username- is visible
       When Click Delete Account button
       Then Verify that 'ACCOUNT DELETED!' is visible and click Continue button
       And Close driver

  @registration
  Scenario: Register user with valid credentials
       When  Enter name and already registered email address
       And Click Signup button
       Then Verify error "Email Address already exist!" is visible
       And Close driver






