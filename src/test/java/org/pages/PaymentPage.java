package org.pages;

import java.time.Duration;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BaseClass {

	private By billingDetails = By.xpath("//a [@class= 'nav-link active']");
	private By shippingDetails = By.xpath("//a[contains(text(),'Shipping')]");
	private By Toshippingbtn = By.xpath("//button[contains(@class, 'btnNext') and contains(text(), 'To shipping')]");
	private By orderComments = By.xpath("//button[contains(@class, 'btnNext') and contains(., 'To order comments')]");
	private By ordertypecomments = By.id("order_comments");
	private By ToPayment = By.xpath("//button[contains(@class, 'btnNext') and contains(text(), 'To payment')]");
	private By Paybyinvoice = By.id("payment_method_jetpack_custom_gateway");
	private By BankTransfer = By.id("payment_method_bacs");
	private By Creditcards = By.id("payment_method_buckaroo_creditcard");
	private By Paypal = By.id("payment_method_buckaroo_paypal");
	private By MisterCash = By.id("payment_method_buckaroo_bancontactmrcash");
	private By Checkout = By
			.xpath("//a[contains(@class, 'checkout-button') and contains(normalize-space(), 'Proceed to checkout')]");
	private By termsAndConditions = By.id("terms");
	private By ProceedToPayment = By.id("place_order");
	private By OrderIdLocator = By.xpath("//p[contains(@class, 'text-order') and contains(text(), 'Order number')]");
	private By qrCodePopup = By.id("qr_code");

	private By viewtocartbtn = By.xpath("//span[@class='iconCot']//span[@class='cart-count']");
	private By minOrderPopup = By.cssSelector(".woocommerce-info");
	private By plusButton = By.xpath("//a[contains(@class, 'qtyBtn') and contains(@class, 'plus')]");

	public void viewtocartbtn() {
		clickElement(driver.findElement(viewtocartbtn));
	}

	public void clickProcessToPayment() {
		WebElement Proceed_Payment_btn = driver.findElement(Checkout);
		Actions actions = new Actions(driver);
		actions.moveToElement(Proceed_Payment_btn).click().perform();
	}

	public void toShippingDetails() {
		WebElement toShippingButton = driver.findElement(Toshippingbtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", toShippingButton);
	}

	public void toOrderComments() {
		WebElement toOrdercommments = driver.findElement(orderComments);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", toOrdercommments);

	}

	public void ordertypecomments() {
		enterText(driver.findElement(ordertypecomments), "Testing Purpose");
	}

	public void topayment() {
		WebElement topayment = driver.findElement(ToPayment);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", topayment);
	}

	public void acceptTermsAndConditions() {
		WebElement terms = driver.findElement(termsAndConditions);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", terms);
	}

	public void proceedToPayment() {
		WebElement Payment_button = driver.findElement(ProceedToPayment);
		Actions actions = new Actions(driver);
		actions.moveToElement(Payment_button).click().perform();
	}

	public void verifyOrderConfirmation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement orderIdElement = wait.until(ExpectedConditions.visibilityOfElementLocated(OrderIdLocator));
		String orderId = orderIdElement.getText();
		System.out.println("Order Confirmation Page Opened. Order ID: " + orderId);
	}

	public boolean isQRCodeDisplayed() {
		return driver.findElement(qrCodePopup).isDisplayed();
	}

	public void waitForPaymentSelection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("Waiting for user to manually select a payment method...");

		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeSelected(driver.findElement(Paybyinvoice)),
				ExpectedConditions.elementToBeSelected(driver.findElement(BankTransfer)),
				ExpectedConditions.elementToBeSelected(driver.findElement(Creditcards)),
				ExpectedConditions.elementToBeSelected(driver.findElement(Paypal)),
				ExpectedConditions.elementToBeSelected(driver.findElement(MisterCash))));
	}

	// ✅ New logic for minimum order validation

	public boolean isMinOrderValuePopupDisplayed() {
		try {
			return driver.findElement(minOrderPopup).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getMinOrderValuePopupText() {
		try {
			return driver.findElement(minOrderPopup).getText();
		} catch (Exception e) {
			return "";
		}
	}

}
