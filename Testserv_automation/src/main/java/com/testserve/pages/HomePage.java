package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.RepositoryUtils;

public class HomePage {
	RemoteWebDriver driver;
	String page = "HomePage";

	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	RepositoryUtils repo = new RepositoryUtils(page);
	
	public By homePage = By.id("homePage"); 
	
	public By testServe_logo = repo.getBy("testServe_logo");
	
	public By companymainTab = repo.getBy("companymainTab");
	
	public By companypage = repo.getBy("companypage");
	
	public By createNewcompany_button = repo.getBy("createNewcompany_button");
	
	public By profileTab = repo.getBy("profileTab");
	
	public By creditTab = repo.getBy("creditTab");
	
	public By updatedProfileName = repo.getBy("updatedProfileName");
	
	public By updatedCreditName = repo.getBy("updatedCreditName");
	
}


