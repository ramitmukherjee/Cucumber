package com.r.stepdefinition.github;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:GithubLogin.feature"},
		glue = {"com.r.stepdefinition.github"}
		)
public class RunAnnotationTest {

}
