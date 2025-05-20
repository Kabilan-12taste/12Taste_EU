package org.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdefinitions.JVMReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
		        "src/test/resources/FeatureFiles/01_Login.feature",
		        "src/test/resources/FeatureFiles/02_AccountDetails.feature",
		        "src/test/resources/FeatureFiles/03_Address_Management.feature",
		        "src/test/resources/FeatureFiles/04_Search.feature",
		        "src/test/resources/FeatureFiles/05_AddToCart.feature",
		        "src/test/resources/FeatureFiles/06_Quote.feature",
		        "src/test/resources/FeatureFiles/07_PaymentProcess.feature",
		        "src/test/resources/FeatureFiles/08_PasswordReset.feature",
		        "src/test/resources/FeatureFiles/09_Logout.feature",
		        "src/test/resources/FeatureFiles/10_Registration.feature",
		        "src/test/resources/FeatureFiles/11_SearchInvalid.feature"
		    },
    glue = "org.stepdefinitions",
    tags = "not @skip",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/CucumberReport.html",  
        "json:target/cucumber-reports/CucumberReport.json",
        "junit:target/cucumber-reports/CucumberReport.xml",
        "rerun:target/failed_scenarios.txt"
    },
    monochrome = true
)
public class TestRunner {
	 @AfterClass
	    public static void generateReport() {
	        System.out.println("Generating JVM Report...");
	        JVMReport.generateJVMReport("target/cucumber-reports/CucumberReport.json");
	    }
}
