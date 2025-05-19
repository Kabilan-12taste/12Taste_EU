package org.stepdefinitions;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JVMReport {
    public static void generateJVMReport(String jsonPath) {
    	  File reportOutputDirectory = new File("target/cucumber-reports");
          List<String> jsonFiles = new ArrayList<>();

          File jsonFile = new File(jsonPath);
          if (!jsonFile.exists()) {
              System.out.println("ERROR: Cucumber JSON file not found! Path: " + jsonPath);
              return;
          }

          jsonFiles.add(jsonPath);

          Configuration config = new Configuration(reportOutputDirectory, "12Taste EU");
          config.addClassifications("Platform", "Windows");
          config.addClassifications("Browser", "Chrome");
          config.addClassifications("Environment", "Production");

          ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
          reportBuilder.generateReports();

          System.out.println("JVM Report successfully generated at: " + reportOutputDirectory.getAbsolutePath());
      }
}
