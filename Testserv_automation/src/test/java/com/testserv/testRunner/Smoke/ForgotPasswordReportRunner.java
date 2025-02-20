package com.testserv.testRunner.Smoke;

import com.testserve.utils.ReportConfigurations;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(glue ="com.testserv.smoke.stepDefination", monochrome = false, dryRun = false, features = {
"src/test/resources/Smokefeaturefile/ForgotPasswordandReport.feature" }, plugin = {"json:target/cucumber-json-report.json"}, 
		tags = {"@ForgotPasswordReports"})

public class ForgotPasswordReportRunner extends ReportConfigurations{

}
