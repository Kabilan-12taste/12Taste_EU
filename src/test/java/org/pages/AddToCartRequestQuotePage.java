package org.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartRequestQuotePage extends BaseClass {
	private By addToCartButton = By
			.xpath("(//button[text()='Add to cart']");
	private By increaseQuantityButton = By.xpath("//a[@class='qtyBtn plus']");
	private By decreaseQualityButton = By.xpath("//a[@class='qtyBtn minus']");
	private By confirmationMessage = By.xpath("//div[contains(@class, 'woocommerce-message')]");
	private By clearlist = By.xpath("//button[contains(@class, 'ywraq_clean_list') and contains(text(),'Clear List')]");
	private By downloadlist = By.id("ywraq-list-to-pdf");
	private By updatelist = By.xpath("//input [@value = 'Update List']");

	private By productclick = By.xpath("//button[contains(@class, 'single_add_to_cart_button') and text()='Add to cart']");


	private By searchfiled = By.id("dgwt-wcas-search-input-3");

	public void search(String productname) throws AWTException {
		enterText(driver.findElement(searchfiled), productname);
		pressEnter();
	}

	public void productclick() {
		clickElement(driver.findElement(productclick));
	}

	public void clickAddToCart() {
		clickElement(driver.findElement(addToCartButton));
	}

	public String getConfirmationMessage() {
		return driver.findElement(confirmationMessage).getText();
	}

	
	public void clickincreasebtn() {
		WebElement plusButton = driver.findElement(increaseQuantityButton);

		Actions actions = new Actions(driver);
		actions.moveToElement(plusButton).click().perform();
	}

	public void clickdecrasebtn() {
		WebElement minusButton = driver.findElement(decreaseQualityButton);

		Actions actions = new Actions(driver);
		actions.moveToElement(minusButton).click().perform();
	}

	public void clearlist() {
		clickElement(driver.findElement(clearlist));
	}

	public void updatelist() {
		clickElement(driver.findElement(updatelist));
	}

	public void downloadlist() {
		clickElement(driver.findElement(downloadlist));
	}


	public boolean isCartCountUpdated(String expectedCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // ✅ updated for Selenium 4

		try {
			WebElement cartCountElement = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'cart-count')]")));

			boolean isUpdated = wait
					.until(ExpectedConditions.textToBePresentInElement(cartCountElement, expectedCount));

			if (isUpdated) {
				System.out.println(" Cart count updated successfully! Current count: " + expectedCount);
			} else {
				System.out.println("Cart count mismatch. Expected: " + expectedCount + ", but found: "
						+ cartCountElement.getText());
			}

			return isUpdated;
		} catch (TimeoutException e) {
			System.out
					.println("Cart count verification failed: Expected " + expectedCount + " but not updated in time.");
			return false;
		}
	}

	

}