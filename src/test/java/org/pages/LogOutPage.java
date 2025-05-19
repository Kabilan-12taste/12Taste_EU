package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.By;

public class LogOutPage extends BaseClass{

	private By centerlogoutbutton = By.xpath("//a[contains(@href, 'action=logout')]");

	// Locators of side Logout button

	private By sidelogoutbutton = By.xpath("//a[@class='nav-link' and contains(text(), 'Log out')]");

	public void centerlogout() {

		clickElement(driver.findElement(centerlogoutbutton));
	}

	public void sidelogout() {
		clickElement(driver.findElement(sidelogoutbutton));
	}
}
