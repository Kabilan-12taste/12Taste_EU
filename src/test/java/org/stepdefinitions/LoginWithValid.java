package org.stepdefinitions;

import org.base.BaseClass;
import org.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginWithValid extends BaseClass {

    LoginPage login = new LoginPage();// Do NOT initialize here

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        setupBrowser(); // This initializes the driver
        openUrl("https://www.12taste.com/my-account/");
    }

    @When("the user enters a valid email")
    public void the_user_enters_a_valid_email() {
        System.out.println("Enter Username..");
        login.enterUsername("test_email@12taste.com");
    }

    @When("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        System.out.println("Enter Password..");
        login.enterPassword("test_email@12taste.com");
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        login.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        login.getWelcomeMessageText();
    }
}
