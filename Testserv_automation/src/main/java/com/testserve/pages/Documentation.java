package com.testserve.pages;

import java.rmi.Remote;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class Documentation 
{
	RemoteWebDriver driver;
	String page = "Documentation";
public Documentation(RemoteWebDriver driver) {
	this.driver = driver;
	// page = "LoginPage";
}

EventUtils eventUtils = new EventUtils();
RepositoryUtils repo = new RepositoryUtils(page);

public By Documetation=repo.getBy("Documetation");
public By  View=repo.getBy("View");
public By CICD=repo.getBy("CICD");
public By JenkinsSteps=repo.getBy("JenkinsSteps");
public By Close=repo.getBy("Close");
public By BreadCrumbs=repo.getBy("BreadCrumbs");




}
