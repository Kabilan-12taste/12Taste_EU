package org.stepdefinitions;

import java.awt.AWTException;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.pages.PaymentPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentSteps extends BaseClass {

	PaymentPage paymentpage = new PaymentPage();
	AddToCartRequestQuoteSteps addtocart = new AddToCartRequestQuoteSteps();
	AddressManagementSteps address = new AddressManagementSteps();

	@Given("User is on the cart page after adding items")
	public void user_is_on_the_cart_page_after_adding_items() throws AWTException, InterruptedException {
		addtocart.user_navigate_to_the_product_listing_page();
		// addtocart.user_increase_the_quantity_using_the_plus_button();
		addtocart.user_click_on_the_Add_to_Cart_button();
		paymentpage.viewtocartbtn();
	}

	@When("User clicks on the Proceed to Checkout button")
	public void user_clicks_on_the_Proceed_to_Checkout_button() {
		paymentpage.clickProcessToPayment();
	}

	@Then("User is navigated to the Billing Details page")
	public void user_is_navigated_to_the_Billing_Details_page() {
		String expectedurl = "https://www.12taste.com/checkout/";
		String currentURL = getCurrentURL();
		Assert.assertEquals("Both are same", expectedurl, currentURL);
	}

	@When("User enters valid billing details and clicks Continue")
	public void user_enters_valid_billing_details_and_clicks_Continue() {
		address.user_fills_in_the_billing_address_fields_with_valid_data();
	}

	@Then("User is navigated to the Shipping Details page")
	public void user_is_navigated_to_the_Shipping_Details_page() {
		paymentpage.toShippingDetails();
	}

	@When("User enters valid shipping details and clicks Continue")
	public void user_enters_valid_shipping_details_and_clicks_Continue() {
		paymentpage.toOrderComments();
	}

	@Then("User is navigated to the Order Comments page")
	public void user_is_navigated_to_the_Order_Comments_page() {
		String expectedurl = "https://www.12taste.com/checkout/";
		String currentURL = getCurrentURL();
		Assert.assertEquals("User is in order comments page", expectedurl, currentURL);
	}

	@When("User enters order comments and clicks Continue")
	public void user_enters_order_comments_and_clicks_Continue() {
		paymentpage.ordertypecomments();
		paymentpage.topayment();
	}

	@Then("User is navigated to the Payment Options page")
	public void user_is_navigated_to_the_Payment_Options_page() {
		String expectedurl = "https://www.12taste.com/checkout/";
		String currentURL = getCurrentURL();
		Assert.assertEquals("User is in payment page", expectedurl, currentURL);
	}

	@When("User selects the Payment Method payment option")
	public void user_selects_the_Payment_Method_payment_option() {
		System.out
				.println("Please select a payment method manually. Automation will resume once a method is selected.");
		paymentpage.waitForPaymentSelection();
		System.out.println("Payment method detected. Resuming automation...");
	}

	@When("User agrees to the terms and conditions")
	public void user_agrees_to_the_terms_and_conditions() {
		paymentpage.acceptTermsAndConditions();
	}

	@When("User clicks on the Process to Payment button")
	public void user_clicks_on_the_Process_to_Payment_button() {
		paymentpage.proceedToPayment();
	}

	@Then("A QR code should appear for UPI payments")
	public void a_QR_code_should_appear_for_UPI_payments() {
		paymentpage.verifyOrderConfirmation();
	}
}
