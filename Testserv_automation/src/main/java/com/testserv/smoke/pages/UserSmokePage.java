package com.testserv.smoke.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class UserSmokePage {
	RemoteWebDriver driver;
	String page = "UserSmokePage";

	public UserSmokePage(RemoteWebDriver driver) {
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
	public By EditIcon=repo.getBy("EditIcon");
	public By FirstName=repo.getBy("FirstName");
	public By LastName=repo.getBy("LastName");
	public By Update=repo.getBy("Update");
	public By Client=repo.getBy("Client");
	public By ViewIcon=repo.getBy("ViewIcon");
	public By Back=repo.getBy("Back");
	public By Delete=repo.getBy("Delete");
	public By DeleteButton=repo.getBy("DeleteButton");
	
}



