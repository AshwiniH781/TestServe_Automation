package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class FeedBackPage
{

	RemoteWebDriver driver;
	String page = "FeedBackPage";

	public FeedBackPage(RemoteWebDriver driver) {
		this.driver = driver;
		// page = "LoginPage";
	}

	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);
	public By FeedBack=repo.getBy("FeedBack");
	public By Name=repo.getBy("Name");
	public By Role=repo.getBy("Role");
	public By Comments=repo.getBy("Comments");
	public By Submit=repo.getBy("Submit");
	public By Ratings=repo.getBy("Ratings");
	public By Logout=repo.getBy("Logout");
	public By Download=repo.getBy("Download");
	public By SortBy=repo.getBy("SortBy");
	public By HighttoLow=repo.getBy("HighttoLow");
	public By Toggle=repo.getBy("Toggle");
	public By TestservLogo=repo.getBy("TestservLogo");
	public By Dashboard=repo.getBy("Dashboard");
	
	
}