Feature: Users api


    Scenario: Get single user
      Given set the necessary path params
      Given send get request for single user
      And deserializes response to java
      And save user info to correspondent files
      Then verify that status code is 200
      Then validate user's email is "janet.weaver@reqres.in"

  @usersApi
  Scenario: Get All users
    Given set uri
    Given send get request for all users
    And deserialize response to java
    #And save user info to correspondent files
    #Then verify that status code is 200
    #Then validate user's email is "janet.weaver@reqres.in"

