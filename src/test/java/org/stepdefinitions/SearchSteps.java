package org.stepdefinitions;

import org.base.BaseClass;
import org.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends BaseClass {

	SearchPage search = new SearchPage();

	@Given("User is on the search page")
	public void user_is_on_the_search_page() {
		setupBrowser();
		openUrl("https://www.12taste.com");
	}

	@When("User searches for a valid product")
	public void user_searches_for_a_valid_product() {
		search.search("Milk");
		search.searchbtn();
	}

	@When("User selects random one from Application Area")
	public void user_selects_random_one_from_Application_Area() {
		search.selectOneApplicationArea();
	}

	@When("User selects Best Selling from Default Sorting")
	public void user_selects_Best_Selling_from_Default_Sorting() {
		search.selectOneDefaultSorting();
	}

	@When("User selects random Dietary Certification filters")
	public void user_selects_random_Dietary_Certification_filters() throws InterruptedException {
		search.selectOneDietaryCertification();
		search.applyFilters();

	}

	@When("User selects random Labels & Marks filters")
	public void user_selects_random_Labels_Marks_filters() throws InterruptedException {
		
		//search.selectOneLabelAndMark();

	}

	@When("User applies the filters")
	public void user_applies_the_filters() {
		//search.applyFilters();
	}

	@Then("User should see relevant search results")
	public void user_should_see_relevant_search_results() {
		System.out.print("All cases has excuted successfully");
	}

}
