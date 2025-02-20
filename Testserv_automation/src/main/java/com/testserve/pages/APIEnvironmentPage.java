package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class APIEnvironmentPage
{
	RemoteWebDriver driver;
	String page = "APIEnvironmentPage";

	public APIEnvironmentPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	
	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);
	
	public By APItestingbutton=repo.getBy("APItestingbutton");
	public By APIEnvironmentbutton=repo.getBy("APIEnvironmentbutton");
	public By Addnewenvironment=repo.getBy("Addnewenvironment");
	public By Selectprojectdropdown=repo.getBy("Selectprojectdropdown");
	public By selectoption=repo.getBy("selectoption");
	public By Environmentname=repo.getBy("Environmentname");
	public By postmancollexctionurl=repo.getBy("postmancollexctionurl");
	public By savebutton=repo.getBy("savebutton");
	public By pickfromapi=repo.getBy("pickfromapi");
	public By selectPickAPI=repo.getBy("selectPickAPI");
	public By selctapi=repo.getBy("selctapi");
	public By login=repo.getBy("login");
	public By whatfiledfromresponse=repo.getBy("whatfiledfromresponse");
	public By managesave=repo.getBy("managesave");
	public By Nobutton=repo.getBy("Nobutton");
	public By helathtext=repo.getBy("helathtext");
	public By startButton=repo.getBy("startButton");
	public By saveHealthTestAPI=repo.getBy("saveHealthTestAPI");
	public By NextButton=repo.getBy("NextButton");
	public By ClickNode=repo.getBy("ClickNode");
	public By createprojectnode=repo.getBy("createprojectnode");
	public By Src=repo.getBy("CircleOOne");
	public By Dst=repo.getBy("Circle2");
	public By Arrowmark=repo.getBy("Arrowmark");
	public By Arrowmark2=repo.getBy("Arrowmark2");
    public By node=repo.getBy("node");
    public By responsebutton=repo.getBy("responsebutton");
    public By ResponseValue=repo.getBy("ResponseValue");
   
    public By Requestdropdown=repo.getBy("Requestdropdown");
    
    public By SelectOptions=repo.getBy("SelectOptions");
    public By SaveIcon=repo.getBy("SaveIcon");
    
    public By MasterSave=repo.getBy("MasterSave");
    
    public By SaveRelationAPI=repo.getBy("SaveRelationAPI");
    public By SubmitRelation=repo.getBy("SubmitRelation");
    public By BreadCrumbAPI=repo.getBy("BreadCrumbAPI");
    public By ellipse=repo.getBy("ellipse");
    public By Genarte=repo.getBy("Genarte");
    public By button=repo.getBy("button");
    public By Manage=repo.getBy("Manage");
    
    public By MicrosoftProject=repo.getBy("MicrosoftProject");
    		
    
    
    
		
	}


	
	
	


