package com.testserver.testRunner.Sanity;

import com.testserve.utils.ReportConfigurations;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue ="com.testserve.sanity.stepDefination", monochrome = false, dryRun = false, features = {
"src/test/resources/featurefile/FeedBack.feature" }, plugin = {"json:target/cucumber-json-report.json"}, tags = {"@Feedback"})

public class FeedBackRunner extends ReportConfigurations
{

}
