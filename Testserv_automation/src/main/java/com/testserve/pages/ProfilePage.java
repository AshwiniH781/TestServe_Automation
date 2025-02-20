package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class ProfilePage 
{
	RemoteWebDriver driver;
	String page = "ProfilePage";

	public ProfilePage(RemoteWebDriver driver) {
		this.driver = driver;
		
		
	}

	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);
	public By Profile=repo.getBy("Profile");
	public By CreateNewProfile=repo.getBy("CreateNewProfile");
	public By ProfileName=repo.getBy("ProfileName");
	public By APITesting=repo.getBy("APITesting");
	public By Project=repo.getBy("Project");
	public By Feedback=repo.getBy("Feedback");
	public By Des=repo.getBy("Des");
	public By SaveProfile=repo.getBy("SaveProfile");
	public By ProfileImage=repo.getBy("ProfileImage");
	public By CameraIcon=repo.getBy("CameraIcon");
	public By Browse=repo.getBy("Browse");
	public By Updatebutton=repo.getBy("Updatebutton");
	public By EditPassword=repo.getBy("EditPassword");
	
	public By oldPassword=repo.getBy("oldPassword");
	public By NewPassword=repo.getBy("NewPassword");
	public By ConfirmPasword=repo.getBy("ConfirmPasword");

	
	





}

