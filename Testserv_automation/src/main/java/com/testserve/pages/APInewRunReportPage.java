package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class APInewRunReportPage 
{

	RemoteWebDriver driver;
	String page = "APInewRunReportPage";

	public APInewRunReportPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);
	
	public By Singlenev=repo.getBy("Singlenev");
	public By APInewRun=repo.getBy("APInewRun");
	public By APInewRunbutton=repo.getBy("APInewRunbutton");
	public By LiveAPITest=repo.getBy("LiveAPITest");
	public By SelectProject=repo.getBy("SelectProject");
	public By selectprojectoption=repo.getBy("selectprojectoption");
	public By SelectEnv=repo.getBy("SelectEnv");
	public By SelectEnvOption=repo.getBy("SelectEnvOption");
	public By Savebutton=repo.getBy("Savebutton");
	public By clickanywhere=repo.getBy("clickanywhere");
	public By dashboard=repo.getBy("dashboard");
	public By APIReport=repo.getBy("APIReport");
	public By APIReportellipse=repo.getBy("APIReportellipse");
	public By Edit=repo.getBy("Edit");
	public By TestCase=repo.getBy("TestCase");
	public By View=repo.getBy("View");
	public By negativeTc=repo.getBy("negativeTc");
	public By TCBack=repo.getBy("TCBack");
	public By ViewReport=repo.getBy("ViewReport");
	public By DetailedBack=repo.getBy("DetailedBack");
	public By checkBox=repo.getBy("checkBox");
	public By bulkupdate=repo.getBy("bulkupdate");
	public By Actionstatus=repo.getBy("Actionstatus");
	public By FixedStatus=repo.getBy("FixedStatus");
	public By CommentBox=repo.getBy("CommentBox");
	public By Updatebutton=repo.getBy("Updatebutton");
	public By BackButton=repo.getBy("BackButton");
	public By Okay=repo.getBy("Okay");
	public By History=repo.getBy("History");
	public By HistoryBack=repo.getBy("HistoryBack");
	public By MicroProject=repo.getBy("MicroProject");
	public By LoadingSpinner=repo.getBy("LoadingSpinner");
	
	public By SingleCheckbox=repo.getBy("SingleCheckbox");
	
	public By SingleComments=repo.getBy("SingleComments");
	
	public By SingleUpdate=repo.getBy("SingleUpdate");
	
	public By Accordian=repo.getBy("Accordian");
	
	public By PostBody=repo.getBy("PostBody");
	
	public By RequestBodyView=repo.getBy("RequestBodyView");
	
	public By CopyIcon=repo.getBy("CopyIcon");
	public By Filter=repo.getBy("Filter");
	
public By Past6Months=repo.getBy("Past6Months");
	
}
