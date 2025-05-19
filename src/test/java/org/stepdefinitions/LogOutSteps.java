package org.stepdefinitions;

import org.base.BaseClass;
import org.junit.Assert;
import org.pages.LogOutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOutSteps extends BaseClass {

	LoginWithValid loginforlogout = new LoginWithValid();
	LogOutPage logout = new LogOutPage();

	@Given("the user logs into the application")
	public void the_user_logs_into_the_application() {
		loginforlogout.the_user_is_on_the_login_page();
		loginforlogout.the_user_enters_a_valid_email();
		loginforlogout.the_user_enters_a_valid_password();
		loginforlogout.the_user_clicks_the_login_button();
	}

	@When("the user clicks the center not username logout button")
	public void the_user_clicks_the_center_not_username_logout_button() {
		logout.centerlogout();

	}

	@Then("the user should be redirected to the login page")
	public void the_user_should_be_redirected_to_the_login_page() {
		String exceptedURL = "https://www.12taste.com/my-account/";
		String currentURL = getCurrentURL();

		Assert.assertEquals("The URL's are not the same", exceptedURL, currentURL);
	}

	@Given("the user logs into the application again")
	public void the_user_logs_into_the_application_again() {
		loginforlogout.the_user_enters_a_valid_email();
		loginforlogout.the_user_enters_a_valid_password();
		loginforlogout.the_user_clicks_the_login_button();
	}

	@When("the user clicks the side module logout button")
	public void the_user_clicks_the_side_module_logout_button() {
		logout.sidelogout();

	}

	@Then("the user should be redirected to the again login page")
	public void the_user_should_be_redirected_to_the_again_login_page() {
		String exceptedURL = "https://www.12taste.com/my-account/";
		String currentURL = getCurrentURL();

		Assert.assertEquals("The URL's are not the same", exceptedURL, currentURL);

	}

}
