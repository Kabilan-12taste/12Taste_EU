package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Accountdetails extends BaseClass {

	private By actdetails = By.xpath("//a[normalize-space()='Account details']");
	// Locators for Account details input fields
	private By firstNameField = By.id("account_first_name");
	private By lastNameField = By.id("account_last_name");
	private By displayNameField = By.id("account_display_name");
	private By emailField = By.id("account_email");
	private By currentPasswordField = By.id("password_current");
	private By newPasswordField = By.id("password_1");
	private By confirmPasswordField = By.id("password_2");
	private By saveButton = By.xpath("//button[@name='save_account_details']");
	private By successMessage = By.xpath("//div [@class ='woocommerce-message']");
	private By errorMessage = By
			.xpath("//div[@class='woocommerce-notices-wrapper']//ul[@class='woocommerce-error']/li");

	public void enterNewAccountDetails(String firstName, String lastName, String displayName, String email,
			String oldpass, String newPassword, String confirmPassword) {
		enterText(driver.findElement(firstNameField), firstName);
		enterText(driver.findElement(lastNameField), lastName);
		enterText(driver.findElement(displayNameField), displayName);
		enterText(driver.findElement(emailField), email);
		enterText(driver.findElement(currentPasswordField), oldpass);
		enterText(driver.findElement(newPasswordField), newPassword);
		enterText(driver.findElement(confirmPasswordField), confirmPassword);
	}

	public void actdetailspage() {
		clickElement(driver.findElement(actdetails));
	}

	public void clickSaveButton() {
		WebElement saveChangesButton = driver.findElement(By.xpath("//button[@name='save_account_details']"));

		// Use JavaScript to scroll to the button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", saveChangesButton);

		// Click the button using JavaScript
		js.executeScript("arguments[0].click();", saveChangesButton);
		//clickElement(driver.findElement(saveButton));
	}

	public String getSuccessMessage() {
		return driver.findElement(successMessage).getText();
	}

	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}

}
