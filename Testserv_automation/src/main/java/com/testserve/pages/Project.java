package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class Project 
{
	RemoteWebDriver driver;
	String page = "Project";

	public Project(RemoteWebDriver driver) {
		this.driver = driver;
		// page = "LoginPage";
	}

	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);
	
	public By projectmodule=repo.getBy("projectmodule");
	public By createnewProject=repo.getBy("createnewProject");
	public By projectName=repo.getBy("projectName");
	public By checkbox=repo.getBy("checkbox");
	public By savebutton=repo.getBy("savebutton");
	public By AddUser=repo.getBy("AddUser");
	public By AddUserCheckbox=repo.getBy("AddUserCheckbox");
	public By AssignUsers=repo.getBy("AssignUsers");
	public By Editicon=repo.getBy("Editicon");
	public By Editprojectname=repo.getBy("Editprojectname");
	public By Update=repo.getBy("Update");
	

}
