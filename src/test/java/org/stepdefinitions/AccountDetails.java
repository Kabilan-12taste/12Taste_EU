package org.stepdefinitions;

import org.base.BaseClass;
import org.junit.Assert;
import org.pages.Accountdetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountDetails extends BaseClass {

	Accountdetails acc = new Accountdetails();
	LoginWithValid login = new LoginWithValid();

	
	
	@Given("User should logged in to the application")
	public void user_should_logged_in_to_the_application() {
		setupBrowser();
		openUrl("https://www.12taste.com/my-account/");
		login.the_user_enters_a_valid_email();
		login.the_user_enters_a_valid_password();
		login.the_user_clicks_the_login_button();
		acc.actdetailspage();

	}

	@When("User enter new data with first name,last name, display name, email address, new password, and confirm password")
	public void user_enter_new_data_with_first_name_last_name_display_name_email_address_new_password_and_confirm_pass() {
		acc.enterNewAccountDetails("Test", "Test", "Test", "test_email@12taste.com", "test_email@12taste.com", "test_email@12taste.com",
				"test_email@12taste.com");
	}

	@When("User click the save changes button")
	public void user_click_the_save_change_button() {
		acc.clickSaveButton();
	}

	@Then("User should see a success message saying")
	public void user_should_see_a_success_message_saying() {
		String Expected_Message = "Account details changed successfully.";
		String successMessage = acc.getSuccessMessage();

		Assert.assertEquals("Changes message mismatch!", Expected_Message, successMessage);

	}

	// Saving the changes with mismatched
	// password--------------------------------------------------------------------------------------------------

	@Given("User logged in to the application")
	public void user_logged_in_to_the_application() {
		setupBrowser();
		openUrl("https://www.12taste.com/my-account/");
		login.the_user_enters_a_valid_email();
		login.the_user_enters_a_valid_password();
		login.the_user_clicks_the_login_button();
		acc.actdetailspage();

	}

	@When("User enter new data with first name,last name, display name, mail address, new password, and confirm password")
	public void user_enter_new_data_with_first_name_last_name_display_name_email_address_new_pass_and_confirm_pass() {
		acc.enterNewAccountDetails("Test", "Test", "Test", "test_email@12taste.com", "test_email@12taste.com", "test_email@12taste.com",
				"test_email@taste.com");

	}

	@When("User click the save changes button1")
	public void user_click_the_save_change1_button() {
		acc.clickSaveButton();

	}

	@Then("User should see an error message saying")
	public void user_should_see_an_error_message_saying() {
		String Expected_Message = "New passwords do not match.";
		String ErrorMessage = acc.getErrorMessage();

		Assert.assertEquals("Changes message mismatch!", Expected_Message, ErrorMessage);

	}

	// Saving the changes without changing the password
	// -----------------------------------------------------------------------------------------

	@Given("User log in to the application")
	public void user_login_to_the_application() {
		setupBrowser();
		openUrl("https://www.12taste.com/my-account/");
		login.the_user_enters_a_valid_email();
		
		login.the_user_enters_a_valid_password();
		login.the_user_clicks_the_login_button();
		acc.actdetailspage();
	}

	@When("User enter new data with first name,last name, display name, email address, new pass, and confirm pass")
	public void user_enter_new_data_with_first_name_last_name_display_name_mail_address_new_pass_and_confirm_pass() {
		acc.enterNewAccountDetails("Test", "Test", "Test", "test_email@12taste.com", "test_email@12taste.com", "",
				"");
	}

	@When("User click the save changes button2")
	public void user_click_the_save_change2_button() {
		acc.clickSaveButton();
	}

	@Then("User should see an error msg saying")
	public void user_should_see_an_error_msg_saying() {
		String Expected_Message = "Please fill out all password fields.";
		String errorMessage = acc.getErrorMessage();
		
		Assert.assertEquals("message", Expected_Message, errorMessage);

	}

}
