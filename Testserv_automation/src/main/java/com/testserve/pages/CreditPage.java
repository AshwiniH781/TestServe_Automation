package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class CreditPage {

	RemoteWebDriver driver;
	String page = "CreditPage";

	public CreditPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	
	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);
	public By CreditButton=repo.getBy("CreditButton");
	
	public By EditIcon=repo.getBy("EditIcon");
	public By CreditName=repo.getBy("CreditName");
	
	public By Update=repo.getBy("Update");
	 
	public By ViewIcon=repo.getBy("ViewIcon");
	
	public By Close=repo.getBy("Close");
	
	public By liccensedAPI=repo.getBy("liccensedAPI");
	
			
	public By LicensedUser=repo.getBy("LicensedUser");
	public By DasboardUsage=repo.getBy("DasboardUsage");
	
	public By Description=repo.getBy("Description");
	
	
	
	
}
