package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class UserPage 
{

	RemoteWebDriver driver;
	String page = "UserPage";

	public UserPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);
	public By Userbutton=repo.getBy("Userbutton");
	public By CreateNewUser=repo.getBy("CreateNewUser");
	public By UserName=repo.getBy("UserName");
	public By Password=repo.getBy("Password");
	public By Email=repo.getBy("Email");
	public By SelectRole=repo.getBy("SelectRole");
	public By SelectOption=repo.getBy("SelectOption");
	public By Profiledp=repo.getBy("Profiledp");
	public By ProfileOption=repo.getBy("ProfileOption");
	public By Save=repo.getBy("Save");
	
	
	
	
	
}

