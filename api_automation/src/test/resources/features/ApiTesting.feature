Feature: Api Automation

  @regression
  Scenario: Testing GET Call
    Given User initializes the baseurl as "https://reqres.in/"
    When User fires the GET call to url "api/users/2"
    Then User verifies the Success status code