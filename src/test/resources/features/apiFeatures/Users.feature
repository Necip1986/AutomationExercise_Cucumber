Feature: Users api


  Scenario: Get single user
    Given set the necessary path params
    Given send get request for single user
    And deserializes response to java
    And save user info to correspondent files
    Then verify that status code is 200
    Then validate user's email is "janet.weaver@reqres.in"


  Scenario: Get All users
    Given set uri
    Given send get request for all users
    And deserialize response to java
    Then verify that status code is 200
    Then validate first user's email is "michael.lawson@reqres.in"


  @usersApi
  Scenario Outline: Create user
    Given set uri for creating user
    And set body for post request "<name>","<job>"
    Given send post request for creating user
    Then verify that status code is 201
    Examples:
      | name    | job     |
      | Mahmut  | Doctor  |
      | Johnson | Teacher |


  Scenario: Update user
    Given set uri for update user
    And set body for put request
    Given send put request for update user
    Then verify that status code is 200


  Scenario: Update user
    Given set uri for delete user
    Given send delete request for update user
    Then verify that status code is 204




