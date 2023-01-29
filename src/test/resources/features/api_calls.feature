Feature: Demonstration of GET, POST, PUT and DELETE requests

#  POST requests
  Background:
    Given I create a user
    And I create a token

#    GET request
  Scenario: Get info about user
    Then I get user data

#    PUT request
  Scenario: Update user password
    Then I update the password

#    DELETE request
  Scenario: Delete the user
    Then I delete the user