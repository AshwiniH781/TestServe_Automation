package com.testserv.testRunner.Smoke;

import com.testserve.utils.ReportConfigurations;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue ="com.testserv.smoke.stepDefination", monochrome = false, dryRun = false, features = {
"src/test/resources/Smokefeaturefile/FeedBack.feature" }, plugin = {"json:target/cucumber-json-report.json"}, 
		tags = {"@Feedback"})


public class FeedBackRunner extends ReportConfigurations {

}
