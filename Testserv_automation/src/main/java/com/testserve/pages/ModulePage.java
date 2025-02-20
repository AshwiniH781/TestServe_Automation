package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class ModulePage 
{
	RemoteWebDriver driver;
	String page = "ModulePage";

	public ModulePage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);
	
public By Modulebutton=repo.getBy("Modulebutton");

public By CreateNewModule=repo.getBy("CreateNewModule");

public By ModuleName=repo.getBy("ModuleName");
 
public By OrderId=repo.getBy("OrderId");

public By Icons=repo.getBy("Icons");

public By ModulePath=repo.getBy("ModulePath");
	
public By Description=repo.getBy("Description");	

public By EditIcon=repo.getBy("EditIcon");

public By UpdateButton=repo.getBy("UpdateButton");

public By Save=repo.getBy("Save");
	
public By Check=repo.getBy("Check");

public By Delete=repo.getBy("Delete");
public By deleteButton=repo.getBy("deleteButton");
}
