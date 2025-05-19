package org.pages;

import java.time.Duration;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuotePage extends BaseClass {

	private By requestQuoteButton = By
			.xpath("//a[contains(@class, 'add-request-quote-button') and contains(text(),'Request a Quote')]");

	private By firstname = By.id("first_name");
	private By lastname = By.id("last_name");
	private By street = By.id("street_address");
	private By zipcode = By.id("zip_code");
	private By city = By.id("town__city");
	private By company_name = By.id("company");
	private By email = By.id("email");
	private By phone_no = By.id("phine_number");
	private By VAT_number = By.id("vat_");
	private By question = By.id("message");
	private By sample_checkbox = By.id("requesting_a_sample");

	private By sendRequestButton = By.xpath("//input[@class='button raq-send-request last']");

	private By order_no = By.xpath("//header/h2[contains(text(), 'Quote #')]");

	public void clickRequestQuote() {

		clickElement(driver.findElement(requestQuoteButton));
	}

	public void fillQuoteForm(String firstName, String lastName, String Street, String zip, String City, String Company,
			String Email, String phone, String VAT, String Question) {

		enterText(driver.findElement(firstname), firstName);
		enterText(driver.findElement(lastname), lastName);
		enterText(driver.findElement(street), Street);
		enterText(driver.findElement(zipcode), zip);
		enterText(driver.findElement(city), City);
		enterText(driver.findElement(company_name), Company);
		enterText(driver.findElement(email), Email);
		enterText(driver.findElement(phone_no), phone);
		selectcountry();
		selectState();
		enterText(driver.findElement(VAT_number), VAT);
		clickElement(driver.findElement(sample_checkbox));
		enterText(driver.findElement(question), Question);
	}

	public void clickSendRequest() {

		WebElement sendRequestButton = driver.findElement(By.xpath("//input[@class='button raq-send-request last']"));

		// JavaScript Click
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", sendRequestButton);
	}

	public void orderno() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ updated for Selenium 4

		// Wait for the Quote Number to be visible
		WebElement quoteElement = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/h2[contains(text(), 'Quote #')]")));

		// Extract the text (e.g., "Quote #4977093 details")
		String quoteText = quoteElement.getText();

		// Extract only the Quote Number using string manipulation
		String quoteNumber = quoteText.replaceAll("\\D+", ""); // Removes non-numeric characters

		// Print the extracted Quote Number
		System.out.println("Quote Number: " + quoteNumber);
	}

	public void selectState() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ updated for Selenium 4
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("state-country-province-dropdown-billing_select")));

		// Locate the dropdown element
		WebElement stateDropdown = driver.findElement(By.id("state-country-province-dropdown-billing_select"));

		// Select using <select> dropdown
		Select select = new Select(stateDropdown);
		select.selectByValue("Zeeland"); // Select by value
		// select.selectByVisibleText("Tamil Nadu"); // Alternatively, select by text
		System.out.println("Selected state using <select> dropdown");
	}

	public void selectcountry() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ updated for Selenium 4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-country-container")));

		// Locate the dropdown element
		WebElement countryDropdown = driver.findElement(By.id("select2-country-container"));

		// Select using <select> dropdown
		Select select = new Select(countryDropdown);
		select.selectByValue("Netherlands"); // Select by value
		// select.selectByVisibleText("Tamil Nadu"); // Alternatively, select by text
		System.out.println("Selected country using <select> dropdown");
	}
}
