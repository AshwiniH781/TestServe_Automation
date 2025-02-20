package com.testserv.testRunner.Smoke;

import com.testserve.utils.ReportConfigurations;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue ="com.testserv.smoke.stepDefination", monochrome = false, dryRun = false, features = {
"src/test/resources/Smokefeaturefile/User.feature" }, plugin = {"json:target/cucumber-json-report.json"}, 
		tags = {"@User"})


public class UserRunner extends ReportConfigurations{

}
