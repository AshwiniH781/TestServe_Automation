package com.testserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;

public class ForgotPasswordandReportPages {

	RemoteWebDriver driver;
	String page = "ForgotPasswordandReportPages";

	public ForgotPasswordandReportPages(RemoteWebDriver driver) {
		this.driver = driver;
	}

	
	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);
	public By ForgotPassword=repo.getBy("ForgotPassword");
	public By Filed=repo.getBy("Filed");
	public By Resend=repo.getBy("Resend");
	public By BackLogin=repo.getBy("BackLogin");
	public By Reports=repo.getBy("Reports");
	public By TrcaeserActivity=repo.getBy("TrcaeserActivity");
	public By LoginActivity=repo.getBy("LoginActivity");
	
	public By CreditReport=repo.getBy("CreditReport");
}
