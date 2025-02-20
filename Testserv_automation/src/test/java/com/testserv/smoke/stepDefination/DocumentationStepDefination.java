package com.testserv.smoke.stepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testserve.pages.CompanyPage;
import com.testserve.pages.Documentation;
import com.testserve.pages.HomePage;
import com.testserve.pages.LoginPage;
import com.testserve.pages.ProfilePage;
import com.testserve.utils.BaseTest;
import com.testserve.utils.EventUtils;
import com.testserve.utils.Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DocumentationStepDefination extends BaseTest {
	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage comp;
	ProfilePage Prof;
	Documentation doc;
	SoftAssert softAssert;
	Utilities utilities;
	
	@Before("@Documentation")
	
	public void setUp(Scenario scenario) {
		String scenarioName = getScenario(scenario);
		createTest(scenarioName);
		System.out.println("Launching the Application");
		launchApplication();

		loginPage = new LoginPage(driver);
		eventUtils = new EventUtils();
		homePage = new HomePage(driver);
		comp=new CompanyPage(driver);
		 doc=new Documentation(driver);
		 Prof=new ProfilePage(driver);
		softAssert = new SoftAssert();
		utilities = new Utilities();
}
	@Given("^Login to the company admin credentials$")
	public void login_to_the_company_admin_credentials() throws Throwable {
		createNode("Given", "users will launch the browser and enter the url");
	    String username=utilities.getCredentialsFromPropertyFile("SmokeCompanyadminUsername");
	    String Password=utilities.getCredentialsFromPropertyFile("SmokeCompanyadminPassword");
	   
	    if(eventUtils.waitUntilElementIsPresent(driver, loginPage.userName_field, 20)) {
	    	eventUtils.enterValue(driver, loginPage.userName_field, username, "Usernamefield", 20, test);
	    	logStatus("info","usersname field accept the username");
	    eventUtils.waitUntilElementIsPresent(driver, loginPage.password_field, 20);
	    	eventUtils.enterValue(driver, loginPage.password_field, Password, "Password", 20, test);
	    eventUtils.waitUntilElementIsPresent(driver, loginPage.loginButton, 20);
	    	eventUtils.clickOnElement(driver, loginPage.loginButton, "loginbutton", 20);
	    	if(eventUtils.waitUntilElementIsPresent(driver,comp.logo, 20)) {
		    	eventUtils.mouseHoverToElement(driver, comp.logo, 20, test);
	    	logStatus("info", "lands on homepage");
	    }
	    else {
	    	logStatus("error", "users will not lands on homepage");
	    }
	}
	
	}

	@When("^Click on documentation button$")
	public void click_on_documentation_button() throws Throwable {
	    createNode("When", "User will click the button and lands on the page succssfully");
	    eventUtils.waitUntilElementIsPresent(driver, doc.Documetation, 20);
	    eventUtils.clickOnElement(driver, doc.Documetation, "Documents", 20);
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/documentation/documentation"));
	    	String Actual=driver.getCurrentUrl();
	    	if(Actual.equals("https://qa.testserv.ai/documentation/documentation")) {
	    		logStatus("info", "Users lands on the documentation page");
	    	}
	    	else {
	    		logStatus("error", "Users not able to lands on the documentation page");
	    	}
	}

	@And("^Click on view document button in the jenkins$")
	public void click_on_view_document_button_in_the_jenkins() throws Throwable {
	    createNode("And", "User saw the steps for jenkins configurations");
	    if(eventUtils.waitUntilElementIsPresent(driver, doc.View, 20)) {
	    eventUtils.clickOnElement(driver, doc.View, "View", 20);
	    logStatus("info", "Users will see the Jenkins plugin pop up");
	    
	}
	    else
	    {
	    	logStatus("error", "Users will see not ableto see the Jenkins plugin pop up");
	    }
	}

	@And("^Click on cicd intigration$")
	public void click_on_cicd_intigration() throws Throwable{
	createNode("And", "User see the steps to jenkins configaration");
	eventUtils.waitUntilElementIsPresent(driver, doc.CICD, 20);
	eventUtils.ClickOnElement(driver, doc.CICD, "CI/CD", 20, mainTest);
	WebDriverWait ab=new WebDriverWait(driver, Duration.ofSeconds(20));
	ab.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Documentation/Jenkins"));
	String A=driver.getCurrentUrl();
	if(A.equals("https://qa.testserv.ai/Documentation/Jenkins")) {
		logStatus("info", "users will see the jenkins steps");
	}
	else {
		logStatus("erro", "users fails to see the jenkins steps");
	}
	}
	
	@And("^Click on jenkins file configuration steps$")
	public void click_on_jenkins_file_configuration_steps() throws InterruptedException {
	    createNode("And", "Users see the steps present in the page");
	    // Find the JenkinsSteps element
	    WebElement jenkinsStepsElement = driver.findElement(doc.JenkinsSteps);
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Check if the JenkinsSteps element is visible in the DOM
	    System.out.println("JenkinsSteps element is displayed: " + jenkinsStepsElement.isDisplayed());
	    System.out.println("JenkinsSteps element is enabled: " + jenkinsStepsElement.isEnabled());

	    // Ensure the element is within view
	    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", jenkinsStepsElement);
	    Thread.sleep(500); // Allow some time for the scroll to happen

	    // Wait until the element is visible and enabled
	    eventUtils.waitUntilElementIsPresent(driver, doc.JenkinsSteps, 40);
	    eventUtils.waitUntilElememtIsClickable(driver, doc.JenkinsSteps, 40);

	    // Verify if the element is now in view and clickable
	    if (jenkinsStepsElement.isDisplayed() && jenkinsStepsElement.isEnabled()) {
	        // Click on the Jenkins Steps element
	        eventUtils.clickOnElement(driver, doc.JenkinsSteps, "Steps", 40, test);
	        logStatus("info", "Clicked on Jenkins Steps");
	    } else {
	        logStatus("error", "Jenkins steps are not clickable or visible after scroll");
	    }
      
	    
if (eventUtils.waitUntilElementIsPresent(driver, doc.Close, 20)) {
	        eventUtils.clickOnElement(driver, doc.Close, "Close Icon", 20);
	        logStatus("info", "User closed the popup");
	    } else {
	        logStatus("error", "User was not able to close the popup");
	    }
	}


	@Then("^Click the documentation in breadcrumbs$")
	public void click_the_documentation_in_breadcrumbs() {
		if(eventUtils.waitUntilElementIsPresent(driver, doc.BreadCrumbs, 20)) {
			eventUtils.clickOnElement(driver, doc.BreadCrumbs, "Breadcrumbs", 20);
			WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(20));
			w.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Home/dashboard"));
			String AC=driver.getCurrentUrl();
			if(AC.equals("https://qa.testserv.ai/Home/dashboard")) {
				logStatus("info", "Users lands on homepage");
			}
			else
			{
				logStatus("error", "Users fails to lands on homepage");
			}
		}
	}

	@After("@Documentation")
	public void teardown() {
		
		try {
				killBrowser();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	}
	
	
	



	
	
	

