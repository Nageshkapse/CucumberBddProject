Feature: Check Login Functionality

Scenario: Check Login Fuctionality With Valid Credential
Given User launch chrome browser
When user should enter valid url"https://admin-demo.nopcommerce.com/login"
And User enters email as "admin@yourstore.com" and password as "admin"
And user click on login button
Then Page name should be "Dashboard / nopCommerce administration"
And User click on logout
Then Page name should be "Your store. Login"
And Close browser

Scenario Outline: Check Login Fuctionality With Valid Credential DDT
Given User launch chrome browser
When user should enter valid url"https://admin-demo.nopcommerce.com/login"
And User enters email as "<email>" and password as "<password>"
And user click on login button
Then Page name should be "Dashboard / nopCommerce administration"
And User click on logout
Then Page name should be "Your store. Login"
And Close browser
Examples: 
|email|password|
|admin@yourstore.com|admin|
|admin@yourstore.com |admin|

Scenario: Check Login Fuctionality With InValid Credential
Given User launch chrome browser
When user should enter valid url"https://admin-demo.nopcommerce.com/login"
And User enters email as "test@yourstore.com" and password as "admin"
And user click on login button
Then User get warning massage