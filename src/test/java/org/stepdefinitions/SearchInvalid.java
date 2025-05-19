package org.stepdefinitions;

import org.base.BaseClass;
import org.junit.Assert;
import org.pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchInvalid extends BaseClass {

	SearchPage search = new SearchPage();

	@Given("User on the search page")
	public void user_is_on_the_search_page() {
		setupBrowser();
		openUrl("https://www.12taste.com");
	}

	@When("User searches for an invalid product")
	public void user_searches_for_an_invalid_product() {
		search.search("iaksdhuf");
		search.searchbtn();
	}

	@Then("User should see a No Results Found message")
	public void user_should_see_a_No_Results_Found_message() {
		String Expected = "No products found";
		String actual = search.noresult();

		Assert.assertEquals("message", Expected, actual);
		
		System.out.print(actual);
	}

	@Then("User closes the tab")
	public void user_closes_the_tab() {

	}

}
