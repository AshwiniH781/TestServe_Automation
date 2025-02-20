package com.testserv.smoke.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class ProjectSmokePage {

	RemoteWebDriver driver;
	String page = "ProjectSmokePage";

	public ProjectSmokePage(RemoteWebDriver driver) {
		this.driver = driver;
		
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
	public By ProjectID=repo.getBy("ProjectID");
	public By CloseIcon=repo.getBy("CloseIcon");
     
	public By Delete=repo.getBy("Delete");
	
	public By DeleteButton=repo.getBy("DeleteButton");
}


