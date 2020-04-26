Feature: Verifying validation messages on the form
  As a User
  I want to see validation message on the form
  So that I can correct the mistakes and continue

  @smoke
  Scenario Outline: Verify user can see validation messages,when user enters invalid data
    Given I am on the homepage
    When I enter new entity with the data <fullname>, <country>, <yob>, <position>, <url>, <risk_level>
    And I select save
    Then I should see validation message as <message>
    And I should not see the modal
    Examples:
      | fullname        | country | yob        | position  | url                              | risk_level | message                          |
      |                 |         |            |           |                                  |            | Please enter details on the form |
      |                 | UK      | 31/10/1978 | MP        | http://bbc.co.uk/srikanth-tester | Low        | Please enter fullname            |
      | 3323423         | UK      | 31/10/1978 | MP        | http://bbc.co.uk/srikanth-tester | Low        | Please enter valid fullname      |
      | srikanth tester |         | 31/10/1978 | MP        | http://bbc.co.uk/srikanth-tester | Low        | Please enter country name        |
      | srikanth tester | London  | 31/10/1978 | MP        | http://bbc.co.uk/srikanth-tester | Low        | Please enter valid country name  |
      | srikanth tester | UK      | 31/10/2010 | MP        | http://bbc.co.uk/srikanth-tester | Low        | Please enter valid year of birth |
      | srikanth tester | UK      |            | MP        | http://bbc.co.uk/srikanth-tester | Low        | Please enter year of birth       |
      | srikanth tester | UK      | 31/10/1978 |           | http://bbc.co.uk/srikanth-tester | Low        | Please enter the position        |
      | srikanth tester | UK      | 31/10/1978 | 234234324 | http://bbc.co.uk/srikanth-tester | Low        | Please enter valid position      |
      | srikanth tester | UK      | 31/10/1978 | MP        |                                  | Low        | Please enter source url          |
      | srikanth tester | UK      | 31/10/1978 | MP        | bbc                              | Low        | Please enter valid source url    |
