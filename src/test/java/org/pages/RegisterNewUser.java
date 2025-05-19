package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterNewUser extends BaseClass{
		// Locators for registration form elements
		private By firstNameField = By.id("first_name");
		private By lastNameField = By.id("last_name");
		private By emailField = By.id("reg_email");
		private By registerButton = By.name("register");
	    private By welcomeMessage = By.xpath("//a[@class='btn-link' and contains(text(), 'Welcome back')]");


		// Method to enter First Name
		public void enterFirstName(String firstName) {

			enterText(driver.findElement(firstNameField), firstName);
		}

		// Method to enter Last Name
		public void enterLastName(String lastName) {

			enterText(driver.findElement(lastNameField), lastName);
		}

		// Method to enter Email
		public void enterEmail(String email) {
			enterText(driver.findElement(emailField), email);
		}

		// Method to click Register Button
		public void clickRegisterButton() {
			clickElement(driver.findElement(registerButton));
		}

		public void getWelcomeMessageText() {
	        WebElement welcomemessage = driver.findElement(welcomeMessage);
	        String wel = welcomemessage.getText();
	        System.out.println("Hey!" + wel);
	        
	    }
		// Method to check if registration form is displayed
		public boolean isRegistrationFormDisplayed() {
			return driver.findElement(firstNameField).isDisplayed();
		}


}