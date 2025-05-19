package org.stepdefinitions;

import org.base.BaseClass;
import org.junit.Assert;
import org.pages.AddressManagementPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressManagementSteps extends BaseClass {

	LoginWithValid login = new LoginWithValid();

	AddressManagementPage addresspage = new AddressManagementPage();

	@Given("User is logged in to the application and is redirected to the dashboard")
	public void user_is_logged_in_to_the_application_and_is_redirected_to_the_dashboard() {
		login.the_user_is_on_the_login_page();
		login.the_user_enters_a_valid_email();
		login.the_user_enters_a_valid_password();
		login.the_user_clicks_the_login_button();
	}

	// **Billing Address Scenario**
	@When("User clicks on the Address menu and navigates to the Billing Address page")
	public void user_navigates_to_the_billing_address_page() {
		addresspage.clickaddress();
		addresspage.editbilling();
	}

	@When("User fills in the Billing Address fields with valid data")
	public void user_fills_in_the_billing_address_fields_with_valid_data() {
	addresspage.fillBillingAddress("DEV", "COMP", "DEV COMP", "Netherlands", "Nijmegen", "5th Block", "1000 AA", "Nijmegen", "+31 850027748", "test_email@12taste.com");
	}

	@When("User clicks the Save Address button")
	public void user_clicks_the_save_address_button() {
		addresspage.clickSaveAddressButton();
	}
	@Then("User should see a confirmation message.")
	public void user_should_see_a_confirmation_message() {
		String expected_message = "Address changed successfully.";
		String actual_message = addresspage.getConfirmationMessage();

		Assert.assertEquals("Confirmation Message", expected_message, actual_message);
	}
	

	// **Shipping Address Scenario**
	@When("User clicks on the Address menu and navigates to the Shipping Address page")
	public void user_navigates_to_the_shipping_address_page() {
		addresspage.clickaddress();
		addresspage.editshipping();
	}

	@When("User fills in the Shipping Address fields with valid data")
	public void user_fills_in_the_shipping_address_fields_with_valid_data() {
		addresspage.fillShippingAddress("DEV", "COMP","1-2 Taste.com", "Netherlands", "Nijyam", "5th block", "1000 AA", "Nijayam");
	}
	
	@Then("User should see the confirmation message")
	public void user_should_see_the_confirmation_message() {
		String expected_message = "Address changed successfully.";
		String actual_message = addresspage.getConfirmationMessage();

		Assert.assertEquals("Confirmation Message", expected_message, actual_message);
	}
}
