Feature: Testing ZigWheels Website
@smoke @regression
  Scenario: Getting informations of Upcoming Bikes using Chrome Browser
    Given user is on ZigWheels.com website
    And verifying the logo of webpage
    When Navigating to upcoming bikes
    Then Informations of upcoming bikes
@smoke
  Scenario: Getting popular models of Used Cars using Chrome Browser
    When Navigating to used cars
    Then popular models of used cars
@smoke @regression
  Scenario: Getting error in login page using Chrome Browser
    When Open signin using google page
    Then Capturing error