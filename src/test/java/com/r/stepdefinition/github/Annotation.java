package com.r.stepdefinition.github;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Annotation {

	WebDriver driver = null;
	
	@Given("^I am on Github login page$")
	public void goToFacebookLoginPage () {
		
		if (driver == null) {
			System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			driver.navigate().to("https://github.com/login/");
			Assert.assertEquals("https://github.com/login/", driver.getCurrentUrl());
		}
	}
	
	@Given("^I enter username as (.*)$")
	public void enterUsername ( String username ) {
		driver.findElement(By.id("login_field")).sendKeys(username);
	}
	
	@Given("^I enter password as (.*)$")
	public void enterPassword ( String password ) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@Given ("^I press the login button$")
	public void clickLogin () {
		driver.findElement(By.name("commit")).click();
	}
	
	@Then("Login should fail")
	public void checkLoginFail () {
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://github.com/session"));
	}
	
	@Then("^Relogin option should be available$")
	public void reloginOptionShouldBeAvailable () {
		Assert.assertNotNull(driver.findElement(By.name("commit")));
	}
	
	@Then ("^Login should succeed$")
	public void loginShouldSucceed () {
		Assert.assertNotNull(driver);
		if (driver != null) {
			Assert.assertEquals("https://github.com/", driver.getCurrentUrl());
			Assert.assertNotNull(driver.findElement(By.className("logout-form")));
		}
		
	}
	
	@Then("^Close the browser$")
	public void closeBrowser () {
		if (driver != null) {
			driver.close();
		}
	}
	
}
