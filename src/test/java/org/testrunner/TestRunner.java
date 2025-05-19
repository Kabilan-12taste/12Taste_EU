package org.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdefinitions.JVMReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\Lenovo\\eclipse-workspace\\12TasteEU\\src\\test\\resources\\FeatureFiles\\LoginwithValid.feature", // adjust if needed
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
