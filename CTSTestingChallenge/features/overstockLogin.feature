#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: overstock login

  @tag1
  Scenario: Testing login page with positive credentials
   

  @tag1
  Scenario: To test the login page with right credentials
    Given open firefox browser
    Given overstock page is loaded
    When clicked on the account and click on signin
    And enter username as ctschallenge20@gmail.com and password as Challenge2018
    And clicked on the sign in button
    Then logged in successfully
    And closed the browser
