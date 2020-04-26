Feature: Add politician details
  As a User
  I want to add politician data
  So that it will be recorded in the DB

  @smoke @enterEntity
  Scenario Outline: Verify user can add politician data with valid information
    Given I am on the homepage
    When I enter new entity with the data <fullname>, <country>, <yob>, <position>, <url>, <risk_level>
    And I select save
    Then I should see message on pop up with politician name as <fullname>
    Examples:
      | fullname        | country | yob        | position | url                              | risk_level |
      | srikanth tester | India   | 31/03/1982 | MP       | http://bbc.co.uk/srikanth-tester | Low        |
      | raj tester      | UK      | 31/10/1978 | MP       | http://bbc.co.uk/srikanth-tester | Low        |
