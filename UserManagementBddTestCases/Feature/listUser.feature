Feature: display user's list
Scenario: login as an admin and display all users
Given User is on the Home Page
When User clicks Login button
When User enters his email and password
When User Clicks on the login button , eventually gets logged in
When the homepage is displayed, the user clicks on listuser button
Then the user gets navigated to listuser page where all users are displayed
