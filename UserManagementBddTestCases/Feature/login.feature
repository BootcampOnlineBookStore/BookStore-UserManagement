Feature: Login Test

@valid
Scenario: Successful login with valid credentials
Given User is on Home Page
When User clicks the Login button
When User enters email and password
Then User Clicks on login button , eventually gets logged in


@invalid
Scenario: Unsuccessful login with invalid credentials
Given User is on BookStoreUserManagement page
When user clicks the Login  button
When User enter email and and invalid password
And User clicks on login
Then User Should get a message "Password is Wrong, Check your Password"