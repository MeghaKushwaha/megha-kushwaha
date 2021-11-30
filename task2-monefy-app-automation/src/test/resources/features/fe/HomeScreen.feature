Feature: Adding expense and income to monefy app and verifying if correct values are reflected

  Scenario: Adding income Deposit to expense report
    Given income balance as '$0.00'
    And user clicks on income button
    Then user enters '90' as amount
    And clicks on choose category
    And user chooses category as 'Deposits'
    Then income balance should be '$90.00'

  Scenario: Adding income Salary to expense report
    Given income balance as '$90.00'
    And user clicks on income button
    Then user enters '90' as amount
    And clicks on choose category
    And user chooses category as 'Salary'
    Then income balance should be '$180.00'

  Scenario: Adding income Savings to expense report
    Given income balance as '$180.00'
    And user clicks on income button
    Then user enters '90' as amount
    And clicks on choose category
    And user chooses category as 'Savings'
    Then income balance should be '$270.00'

  Scenario: Adding expense Bills to expense report
    Given expense balance as '$0.00'
    And user clicks on expense button
    Then user enters '70' as amount
    And clicks on choose category
    And user chooses expense category as 'Bills'
    Then expense balance should be '$70.00'

  Scenario: Adding expense Clothes to expense report
    Given expense balance as '$70.00'
    And user clicks on expense button
    And user clicks on expense button
    Then user enters '65' as amount
    And clicks on choose category
    And user chooses expense category as 'Clothes'
    Then expense balance should be '$135.00'

  Scenario: Adding expense Eating out to expense report
    Given expense balance as '$135.00'
    And user clicks on expense button
    Then user enters '60' as amount
    And clicks on choose category
    And user chooses expense category as 'Eating out'
    Then expense balance should be '$195.00'

  Scenario: Adding expense Health to expense report
    Given expense balance as '$195.00'
    And user clicks on expense button
    Then user enters '100' as amount
    And clicks on choose category
    And user chooses expense category as 'Health'
    Then expense balance should be '$295.00'

  Scenario: Checking total balance
    Given income and expense
    Then Balance is equal to Income minus Expense



