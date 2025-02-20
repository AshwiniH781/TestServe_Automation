package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class CompanyPage 
{
	RemoteWebDriver driver;
	String page = "CompanyPage";

	public CompanyPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	
	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);

	public  By logo=repo.getBy("logo");
	public By companypage=repo.getBy("Companypage");
	public By companybutton=repo.getBy("companybutton");
	public By createnewcompanybutton=repo.getBy("createnewcompanybutton");
	public By companynamefiled=repo.getBy("companynamefiled");
	public By usernamefield=repo.getBy("usernamefield");
	public By emailidfield=repo.getBy("emailidfield");
	public By passwordfield=repo.getBy("passwordfield");
	public By savebutton=repo.getBy("savebutton");
	public By profilefield=repo.getBy("profilefield");
	public By descriptionprofile=repo.getBy("descriptionprofile");
	public By Assignmodule=repo.getBy("Assignmodule");
	public By projectbutton=repo.getBy("projectbutton");
	public By usercheckbox=repo.getBy("usercheckbox");
	public By profilecheckbox=repo.getBy("profilecheckbox");
	public By savebuttonprofile=repo.getBy("savebuttonprofile");
	public By creditnamefield=repo.getBy("creditnamefield");
	public By LicensedUsers=repo.getBy("LicensedUsers");
	public By LicensedAPIRuns=repo.getBy("LicensedAPIRuns");
	public By dashboardusage=repo.getBy("dashboardusage");
	public By excessapinewrun=repo.getBy("excessapinewrun");
	public By creditexpirydata=repo.getBy("creditexpirydata");
	public By creditdescription=repo.getBy("creditdescription");
	public By createbutton=repo.getBy("createbutton");
	public By Credit=repo.getBy("Credit");
	public By TestData=repo.getBy("TestData");
	public By AIGenartion=repo.getBy("AIGenartion");
	public By Sumbit=repo.getBy("Sumbit");
	public By EditIcon=repo.getBy("EditIcon");
	
	public By Update=repo.getBy("Update");
	
	public By ViewIcon=repo.getBy("ViewIcon");
	
	public By NextButton=repo.getBy("NextButton");
	
	public By ProfileNext=repo.getBy("ProfileNext");
	
	public By Back=repo.getBy("Back");
	
}
