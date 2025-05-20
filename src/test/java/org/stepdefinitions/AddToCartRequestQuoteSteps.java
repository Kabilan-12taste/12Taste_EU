package org.stepdefinitions;

import java.awt.AWTException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.AddToCartRequestQuotePage;
import org.pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartRequestQuoteSteps extends BaseClass {

	AddToCartRequestQuotePage addtocartpage = new AddToCartRequestQuotePage();
	SearchSteps search = new SearchSteps();
	LoginWithValid login = new LoginWithValid();

	@Given("User navigate to the product listing page")
	public void user_navigate_to_the_product_listing_page() throws AWTException {

		login.the_user_is_on_the_login_page();
		login.the_user_enters_a_valid_email();
		login.the_user_enters_a_valid_password();
		login.the_user_clicks_the_login_button();
		addtocartpage.search("payment test product");
		// addtocartpage.productclick();
	}

	@When("User increase the quantity using the plus button")
	public void user_increase_the_quantity_using_the_plus_button() {
		// addtocartpage.clickincreasebtn();
	}

	@When("User click on the Add to Cart button")
	public void user_click_on_the_Add_to_Cart_button() throws InterruptedException {
		// addtocartpage.clickAddToCart();
//		WebElement clck = driver.findElement(By.xpath("//button[text()='Add to cart']"));
//		clck.click();
//		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Locate the Add to Cart button
		WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[contains(@class, 'single_add_to_cart_button') and text()='Add to cart']")));

		// Scroll into view and add buffer in case a sticky header overlaps
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", addToCartButton);

		// Optional: pause briefly for layout adjustments
		Thread.sleep(500);

		// Use JavaScript to perform the click to avoid interception
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
	}

	@Then("User should see a confirmation message with the product name")
	public void user_should_see_a_confirmation_message_with_the_product_name() {
		String confirmationMessage = addtocartpage.getConfirmationMessage();
		System.out.print("Success Message:" + confirmationMessage);
	}

	@Then("the product should be added to the cart")
	public void the_product_should_be_added_to_the_cart() {
		addtocartpage.isCartCountUpdated("1");
	}

//	@When("User click on the Request a Quote button")
//	public void user_click_on_the_Request_a_Quote_button() {
//		addtocartpage.clickRequestQuote();
//
//	}
//	
//	@Then("User should be redirected to the quote details page")
//	public void user_should_be_redirected_to_the_quote_details_page() {
//		String expectedurl = "https://www.12taste.com/in/request-a-quote/";
//		String currentURL = getCurrentURL();
//
//		Assert.assertEquals("Both are same", expectedurl, currentURL);
//
//	}
//
//	@When("User fill in the quote request form with valid details")
//	public void user_fill_in_the_quote_request_form_with_valid_details() {
//		addtocartpage.fillQuoteForm("Kabilan", "Mohanraj", "mskabilan4@gmail.com", "9080672610", "1-2 taste",
//				"12345rty", "Tamil Nadu", "I need an one pack of sample");
//	}
//
//	@When("User click on the Send Your Request button")
//	public void user_click_on_the_Send_Your_Request_button() {
//		addtocartpage.clickSendRequest();
//	}
//
//	@Then("an email should be triggered with an order number")
//	public void an_email_should_be_triggered_with_an_order_number() {
//		System.out.println("Mail has been received with the order number");
//	}
//
//	@Then("User should be redirected to the order confirmation page with the Order ID")
//	public void user_should_be_redirected_to_the_order_confirmation_page_with_the_Order_ID() {
//		addtocartpage.orderno();
//	}

}
