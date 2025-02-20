package com.testserver.testRunner.Sanity;


import com.testserve.utils.ReportConfigurations;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "com.testserve.sanity.stepDefination", monochrome = true, dryRun = false, features = {
"src/test/resources/" }, plugin = { "json:target/cucumber-json-report.json"}, tags = {"@Sanity"})
public class SanitySuiteTestRunnerRW extends ReportConfigurations{

}