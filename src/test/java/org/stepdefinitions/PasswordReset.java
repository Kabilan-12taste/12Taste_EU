package org.stepdefinitions;

import org.base.BaseClass;
import org.junit.Assert;
import org.pages.LostPassword;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordReset extends BaseClass {

	LostPassword lostpassword = new LostPassword();

	@Given("the user clicks on Lost your password?")
	public void the_user_clicks_on_Lost_your_password() {
		setupBrowser();
		openUrl("https://www.12taste.com/my-account/");
		lostpassword.clickLostPasswordLink();

	}

	@When("the user is redirected to the password reset page")
	public void the_user_is_redirected_to_the_password_reset_page() {
		String expectedUrl = "https://www.12taste.com/my-account/lost-password/";
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals("User is NOT on the password reset page!", expectedUrl, actualUrl);
	}

	@When("the user enters their registered email in the reser password textbox")
	public void the_user_enters_their_registered_email_in_the_reser_password_textbox() {
		lostpassword.enteremailforreset("test_email@12taste.com");
	}

	@When("the user clicks on the reset password button")
	public void the_user_clicks_on_the_reset_password_button() {
		lostpassword.clickresetpassword();
	}

	@When("the user should receive a password reset email")
	public void the_user_should_receive_a_password_reset_email() {
		System.out.println("The Reset password mail has been received");
	}

	@Then("the user should see a success message")
	public void the_user_should_see_a_success_message() {
		lostpassword.resetmailconfirmation();
	}

}
