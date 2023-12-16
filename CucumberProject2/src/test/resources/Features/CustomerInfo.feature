Feature: Create user
   @sanity
  Scenario: Add New Customer
    Given User launch chrome browser
    When user should enter valid url"https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And user click on login button
    Then Page name should be "Dashboard / nopCommerce administration"
    And Click on customer menu
    And Click on Customer item
    Then User can view add user page
    When User enter customer info
    And click on save button
    Then User can view confiirmation massage "The new customer has been added successfully."
    And Close browser

   @regression
  Scenario: Search email
    Given User launch chrome browser
    When user should enter valid url"https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And user click on login button
    Then Page name should be "Dashboard / nopCommerce administration123"
    And Click on customer menu
    And Click on Customer item
    And Enter customer email
    And Click on search button
    Then User should found email in the search table
    And Close browser
