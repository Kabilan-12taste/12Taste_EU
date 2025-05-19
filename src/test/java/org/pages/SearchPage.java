package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SearchPage extends BaseClass {

	// Locators
	private By searchfiled = By.xpath("//input[contains(@class, 'dgwt-wcas-search-input')]");
	private By searchbutton = By.xpath("//button[contains(@class, 'dgwt-wcas-search-submit')]");
	private By applicationAreaDropdown = By.name("filter_application");
	private By defaultSortingDropdown = By.id("sortby-select");

	private By dietaryCertificationCheckboxes = By.xpath("//label[@for='dietary_gluten-free']");
	private By labelsAndMarksCheckboxes = By.xpath("//label[@for='label_artificial']");

	private By applyFiltersButton = By.xpath("(//button[@type='submit' and contains(@class, 'filter_button')])[1]");

	private By No_result = By.xpath("//p[contains(text(), 'No products found')]");

	public void search(String input) {
		enterText(driver.findElement(searchfiled), input);
	}

	public void searchbtn() {
		clickElement(driver.findElement(searchbutton));
	}

//	// Select one option from Application Area dropdown
	public void selectOneApplicationArea() {
		selectByIndex(driver.findElement(applicationAreaDropdown), 2);
	}

//
//	// Select one option from Default Sorting dropdown
	public void selectOneDefaultSorting() {
		selectByIndex(driver.findElement(defaultSortingDropdown), 2);
	}

//	// Select one checkbox from Dietary Certification
	public void selectOneDietaryCertification() throws InterruptedException {
		WebElement checkbox = driver.findElement(dietaryCertificationCheckboxes);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
		Thread.sleep(500); // Small delay
		checkbox.click();
	}

	// Select one checkbox from Labels & Marks

	public void selectOneLabelAndMark() throws InterruptedException {
		WebElement checkbox = driver.findElement(labelsAndMarksCheckboxes);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
		Thread.sleep(500); // Small delay
		checkbox.click();
	}

	// Click Apply Filters button
	public void applyFilters() {
		driver.findElement(applyFiltersButton).click();
		System.out.println("Clicked Apply Filters button.");
	}

	public String noresult() {
		WebElement message = driver.findElement(No_result);
		return getElementText(message);
	}
}
