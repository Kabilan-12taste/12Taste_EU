package org.pages;

import java.time.Duration;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {

	// **Locators**
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By loginButton = By.name("login");
	
	// **Locator for the welcome message inside <a> tag**
    private By welcomeMessage = By.xpath("//a[@class='btn-link' and contains(text(), 'Welcome back')]");


	// **Methods**
	public void enterUsername(String username) {
		enterText(driver.findElement(usernameField), username);
	}

	public void enterPassword(String password) {
		enterText(driver.findElement(passwordField), password);
	}

	public void clickLogin() {
		clickElement(driver.findElement(loginButton));
	}
	

    // **Method to get the welcome message text**
    public void getWelcomeMessageText() {
        WebElement welcomemessage = driver.findElement(welcomeMessage);
        String wel = welcomemessage.getText();
        System.out.println("Hey!" + wel);
        
    }

    // **Method to check if Dashboard is displayed**
    public boolean isDashboardDisplayed() {
        return driver.findElement(welcomeMessage).isDisplayed();
    }
    


    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ updated for Selenium 4

        // Wait for the login button to be clickable
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("login")));

        // Print button properties for debugging
        System.out.println("Login Button Displayed: " + loginBtn.isDisplayed());
        System.out.println("Login Button Enabled: " + loginBtn.isEnabled());

        // Handle overlays that might block the click
        List<WebElement> overlays = driver.findElements(By.cssSelector("div[class*='overlay'], div[class*='modal']"));
        for (WebElement overlay : overlays) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", overlay);
        }

        // Try clicking normally, then fall back to JavaScript click
        try {
            loginBtn.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("ElementClickInterceptedException occurred. Using JavaScript click.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
        }
    }

}