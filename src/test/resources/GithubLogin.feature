Feature: annotation

	Background:
		User navigates to Github
		Given I am on Github login page
		
	Scenario Outline: Login Fail 1
		When I enter username as <username>
		And I enter password as <password>
		And I press the login button
		Then Login should fail
		But Relogin option should be available
		And Close the browser

	Examples:
		| username | password |
		| John | Doe |
		| ramit.mkj6@gmail.com | password |
		
