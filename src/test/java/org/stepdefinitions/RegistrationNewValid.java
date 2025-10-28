package org.stepdefinitions;

import org.base.BaseClass;
import org.pages.RegisterNewUser;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationNewValid extends BaseClass {

	RegisterNewUser newuser = new RegisterNewUser();

	@Given("the user is on the registration page")
	public void the_user_is_on_the_registration_page() {
		setupBrowser();
		openUrl("https://www.12taste.com/my-account/");

	} 

	@When("the user enters as first name")
	public void the_user_enters_as_first_name() {
		newuser.enterFirstName("Test");
	}

	@When("the user enters last name")
	public void the_user_enters_last_name() {
		newuser.enterLastName("Test");
	}

	@When("the user enters as email")
	public void the_user_enters_as_email() {
		newuser.enterEmail("test_email@12taste.com");
	}

	@When("the user clicks the register button")
	public void the_user_clicks_the_register_button() {
		newuser.clickRegisterButton();
	}

	@Then("the user should be redirected to the confirmation page")
	public void the_user_should_be_redirected_to_the_confirmation_page() {
		newuser.getWelcomeMessageText();
	}

}
