package org.pages;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LostPassword extends BaseClass{

	   // Locators
    private By lostPasswordLink = By.linkText("Lost your password?");
    private By lostusername = By.id("user_login");
    private By resetbutton = By.xpath("//button [@value ='Reset password']");
    private By passwordresetconfirmationmsg = By.xpath("//div[contains(text(), 'Password reset email has been sent')]");

   

    // Click "Lost your password?" link
    public void clickLostPasswordLink() {
        clickElement(driver.findElement(lostPasswordLink));
    }

    public void enteremailforreset(String emailforlost) {
    	enterText(driver.findElement(lostusername), emailforlost);
    }
    
    public void clickresetpassword() {
    	clickElement(driver.findElement(resetbutton));
    }
    
    public void resetmailconfirmation() {
    	String resetmsg = getElementText(driver.findElement(passwordresetconfirmationmsg));
    	
    	String actualmsg = "Password reset email has been sent.";
    	
		Assert.assertEquals("The URL's are not the same", resetmsg, actualmsg);

    }
}