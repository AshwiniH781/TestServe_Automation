package com.testserve.utils;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.event.EventUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


import com.aventstack.extentreports.ExtentTest;


public class Utilities {

	public String service_url;

	public String getDataFromPropertyFile(String propertyFile, String key) {

		String fileName = "";

		fileName = System.getProperty("user.dir") + "\\PropertyFiles\\" + "SearchContents.properties";

		String value = "";

		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.get(key).toString();
		} catch (IOException e) {

		}
		return value;
	}
	
	public String getTimeStamp_sec() {

		String timeStamp = "";
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		timeStamp = timeStamp + (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DAY_OF_MONTH) + c.get(Calendar.HOUR)
				+ c.get(Calendar.MINUTE) + c.get(Calendar.SECOND) + c.get(Calendar.MILLISECOND);

		return timeStamp;
	}
	
	public String replaceHexadeciValuetoUnichar(String base64String) {
		int i = 1;
		// String
		// base64String="eyJldmVudCI6ICJNYXN0aGVhZCBJbXByZXNzaW9uIiwicHJvcGVydGllcyI6IHsiJG9zIjogIldpbmRvd3MiLCIkYnJvd3NlciI6ICJDaHJvbWUiLCIkcmVmZXJyZXIiOiAiaHR0cHM6Ly93d3cudm9vdC5jb20vIiwiJHJlZmVycmluZ19kb21haW4iOiAid3d3LnZvb3QuY29tIiwiJGN1cnJlbnRfdXJsIjogImh0dHBzOi8vd3d3LnZvb3QuY29tLyIsIiRicm93c2VyX3ZlcnNpb24iOiA3MiwiJHNjcmVlbl9oZWlnaHQiOiA3NjgsIiRzY3JlZW5fd2lkdGgiOiAxMzY2LCJtcF9saWIiOiAid2ViIiwiJGxpYl92ZXJzaW9uIjogIjIuMjYuMCIsInRpbWUiOiAxNTQ4ODM3NjM0Ljk3MywiZGlzdGluY3RfaWQiOiAiMTY4OWRkMTJkMmZiLTBlYjAzZjg4MmZhMjMyLTU3YjE0M2EtMTAwMjAwLTE2ODlkZDEyZDMwMmNkIiwiJGRldmljZV9pZCI6ICIxNjg5ZGQxMmQyZmItMGViMDNmODgyZmEyMzItNTdiMTQzYS0xMDAyMDAtMTY4OWRkMTJkMzAyY2QiLCIkaW5pdGlhbF9yZWZlcnJlciI6ICJodHRwczovL3d3dy52b290LmNvbS8iLCIkaW5pdGlhbF9yZWZlcnJpbmdfZG9tYWluIjogInd3dy52b290LmNvbSIsIkZpcnN0IFRpbWUiOiBmYWxzZSwiRGV2aWNlIjogIkRlc2t0b3AiLCJVc2VyIFR5cGUiOiAiVHJhZGl0aW9uYWwiLCJHZW5yZSBTZWxlY3RlZCI6ICIiLCJMYW5ndWFnZSBTZWxlY3RlZCI6ICIgRW5nbGlzaCwgSGluZGkiLCJBZ2UiOiAiMTQiLCJHZW5kZXIiOiAiTSIsIkZpcnN0IE5hbWUiOiAiVGVzdCIsIkxhc3QgTmFtZSI6ICJUZXN0IiwiRW1haWwiOiAidGVzdDUyNzg1MkBnbWFpbC5jb20iLCJQbGF0Zm9ybSI6ICJXZWIiLCJEYXRlIjogIjIwMTktMDEtMzBUMDg6NDA6MzQuMDc0WiIsIkZpcnN0IFZpc2l0IERhdGUiOiAiMjAxOS0wMS0zMFQwODo0MDozMy4xMjVaIiwiTG9jYXRpb24iOiAiIiwiV2F0Y2ggSGlzdG9yeSBDbGVhcmVkIjogIiIsIkRheSBvZiBXZWVrIjogIldlZG5lc2RheSIsIklzIEZyb20gU2VhcmNoPyI6ICJObyIsIkNsaWNrZWQgVmlzaXQgQWQ%2FIjogZmFsc2UsIk1hc3RoZWFkIE1lbnUiOiAiaG9tZSIsIk1hc3RoZWFkIEFkIFNlcnZlciI6ICJERlAiLCJDYW1wYWlnbiBJRCI6IDI0Nzg2NTUzOTYsIkFkdmVydGlzZXIgSUQiOiA0NjMyMzIwMTExLCJ0b2tlbiI6ICJiNTdiOTJlZGNhOWRlNThjYWQ1YTYxM2E3ZDgyMDM0YiJ9fQ%3D%3D";
		for (char letter = ' '; letter < 274; letter++) {
			char asciichar = letter;
			int asciivalue = (int) asciichar;
			String hexvalue = ("%" + Integer.toHexString(asciivalue).toUpperCase());
			if (base64String.contains(hexvalue)) {
				base64String = base64String.replaceAll(hexvalue, "" + letter);
			}
			System.out.println("Base 64 String post replacing with hexa values was: " + base64String);

		}
		return base64String;

	}

	public String getCredentialsFromPropertyFile(String key) {

		String fileName = "";
		
		fileName = System.getProperty("user.dir") + "\\PropertyFiles\\Credentials.properties";
			
		String value = "";

		switch (key) {
		case "PremiumUserEmail": {
			value = System.getProperty("PremiumUserName");
			break;
		}

		case "PremiumUserPassword": {
			value = System.getProperty("PremiumPassword");
			break;
		}

		case "FreeUserEmail": {
			value = System.getProperty("FreeUserName");
			break;
		}

		case "FreeUserPassword": {
			value = System.getProperty("FreePassword");
			break;
		}

		default: {
			break;
		}
		}

		if (value == "" || value == null) {
			try {
				FileInputStream fis = new FileInputStream(fileName);
				Properties prop = new Properties();
				prop.load(fis);
				value = prop.getProperty(key);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	// To generate random Password. generatePwd renamed to generateRandomPassword
	public String generateRandomPassword() {
		
		String strRandom = "";
		String strAlpha = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		String strNumerics = "0123456789";
		String strSpecial = "@$#";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		StringBuilder strRandomAlpha = new StringBuilder(9);
		StringBuilder strRandomSpecial = new StringBuilder(9);
		for (int i = 0; i < 4; i++) {
			strRandomAlpha.append(strAlpha.charAt(rnd.nextInt(strAlpha.length())));
			strRandomNumber.append(strNumerics.charAt(rnd.nextInt(strNumerics.length())));
			strRandomSpecial.append(strSpecial.charAt(rnd.nextInt(strSpecial.length())));

		}
		strRandom = strRandomAlpha.toString() +"As"+ strRandomSpecial.toString() + strRandomNumber.toString();
		String pwd = strRandom;
		return pwd;
	}

	public String generateNo() {
		Random rnd = new Random();
		int i = rnd.nextInt(9);
		String num="1"+i;
		return num;
	}
	
public String generateRandomConfirmPassword() {
		
		String strRandom = "";
		String strAlpha = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		String strNumerics = "0123456789";
		String strSpecial = "@$#";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		StringBuilder strRandomAlpha = new StringBuilder(9);
		StringBuilder strRandomSpecial = new StringBuilder(9);
		for (int i = 0; i < 4; i++) {
			strRandomAlpha.append(strAlpha.charAt(rnd.nextInt(strAlpha.length())));
			strRandomNumber.append(strNumerics.charAt(rnd.nextInt(strNumerics.length())));
			strRandomSpecial.append(strSpecial.charAt(rnd.nextInt(strSpecial.length())));

		}
		strRandom = strRandomAlpha.toString() +"As"+ strRandomSpecial.toString() + strRandomNumber.toString();
		String pwd = strRandom;
		return pwd;
	}

	
	
	public String generatePostalCodeNo() {
		String strRandom = "";
		String strNumbers = "0123456789";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 6; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		String postalNumber = "3" + strRandom;
		System.out.println("Random Generated Postal Number: "+postalNumber);
		return postalNumber;
	}

	public String generateEmailid() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 5; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		String email = strRandom + "@" + "gmail" + ".in";
		return email;
	}
	
	public String generateMobileNumber() {
		String strRandom = "";
		String strNumbers = "0123456789";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 9; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		String mobileNumber = "3" + strRandom;
		System.out.println("Random Generated Mobile Number: "+mobileNumber);
		return mobileNumber;
	}

	public String generateRandomUserName() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 8; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		
		return strRandom;
	}

	public String generateRandomorderId() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 8; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		
		return strRandom;
	}
	public String generateRandomRole() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 8; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		
		return strRandom;
	}
	public String generateRandomCompanyName() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 8; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		
		return strRandom;
	}
	
	public String generateRandomProjectName() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 8; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		
		return strRandom;
	}
	
	public String generateRandomDescription() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 8; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();	
		return strRandom;
	}
	public String generateRandomProfileName() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 8; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		
		return strRandom;
	}
	
	public String generateRandomCreditName() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 8; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();	
		return strRandom;
	}
	// To take the screen shot
	public String captureScreenshot(WebDriver driver, boolean screenshotToFile) throws IOException {

		String screenShotFilePath = "";
		String screenShotName = "";
		String returnString = "";
		BaseTest configMethod = new BaseTest();
		try {
			if (!screenshotToFile) {

				String Base64StringOfScreenshot = "";
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
				String sDate = sdf.format(date);
				FileUtils.copyFile(src, new File(configMethod.screenShotFilePath + "image_" + sDate + ".png"));

				byte[] fileContent = FileUtils.readFileToByteArray(src);
				Base64StringOfScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
				returnString = Base64StringOfScreenshot;

			} else if (screenshotToFile) {
				if (Web_Constants.OS.equalsIgnoreCase("Windows")) {
					screenShotFilePath = configMethod.screenShotFilePath + configMethod.className + "_"
							+ configMethod.hour + "\\";
				}

				createFolder(screenShotFilePath);
				screenShotName = configMethod.methodName + "_" + getTimeStampWithsec() + ".png";
				TakesScreenshot ts = (TakesScreenshot) driver;
				File ScreenShot = ts.getScreenshotAs(OutputType.FILE);
				String destpath = "";

				destpath = screenShotFilePath + screenShotName;

				File destPath = new File(destpath);

				FileUtils.moveFile(ScreenShot, destPath);

				returnString = destpath;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnString;
	}

	// To convert compress the base64 screenshot
	public String createResizedCopy(String base64String, int scaledWidth, int scaledHeight, boolean preserveAlpha) {
		try {

			byte[] decodedBytes = Base64.getDecoder().decode(base64String);
			BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(decodedBytes));
			int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
			BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
			Graphics2D g = scaledBI.createGraphics();
			if (preserveAlpha) {
				g.setComposite(AlphaComposite.Src);
			}
			g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(scaledBI, "gif", bos);
			String imageString = Base64.getEncoder().encodeToString(bos.toByteArray());

			g.dispose();
			return imageString;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String generateRandomname() {
		String strRandomname = "";
		String strNumbers = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 8; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandomname = strRandomNumber.toString();
		return strRandomname;
	}

	public String generateRandomId() {
		String strRandomname = "";
		String strNumbers = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 6; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandomname = strRandomNumber.toString() + "003";
		return strRandomname;
	}

	// Method To Create Folder
	public void createFolder(String foldPath) {
		File f = new File(foldPath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	// To get the time stamp with seconds
	public String getTimeStampWithsec() {

		String timeStamp = "";
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		timeStamp = timeStamp + (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DAY_OF_MONTH) + c.get(Calendar.HOUR)
		+ c.get(Calendar.MINUTE) + c.get(Calendar.SECOND) + c.get(Calendar.MILLISECOND);

		return timeStamp;
	}

	// To get the time stamp with seconds
	public String getDayOfTheMonth() {

		String dateStamp = "";
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);

		dateStamp = String.valueOf(c.get(Calendar.DAY_OF_MONTH));

		return dateStamp;
	}
	
	public String getSpecificFormat() {
		String dateStamp = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd");  
			Date date = new Date();  
			dateStamp = formatter.format(date);
			System.out.println(dateStamp);  
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dateStamp ;
	}

	// To get the time stamp with seconds
		public String getLastDateOfTheMonth() {

			String dateStamp = "";
			Date d = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			
			dateStamp = String.valueOf(c.getActualMaximum(Calendar.DATE));
			return dateStamp;
		}
		
	// To get the Time Stamp in Date and Time Format
	public String getTimeStamp() {
		Date d = new Date();
		return d.toString().replace(":", "_").replace(" ", "_");
	}

	
	public static String getTimeStampEpoch() {
		Instant instant = Instant.now();
		// java.util.Date date= new java.util.Date();
		Long time = instant.getEpochSecond();
		time = time;
		return time.toString();
	}
	
	public static String getTimeStampEpochAfter() {
		Instant instant = Instant.now();
		// java.util.Date date= new java.util.Date();
		Long time = instant.getEpochSecond();
		time = time+100;
		return time.toString();
	}

	public String generateRandomMobNo(int n) {
		Random ran=new Random();
		String s="";
		for (int i = 0; i <=n; i++) {
			s=s+String.valueOf(ran.nextInt(++i));
			i--;
		}
		return s;  
	}
	
	public String generateRandomCharater(int i) {
		Random ran = new Random();
		String s="AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
		return String.valueOf(s.charAt(ran.nextInt(i)));
	}
	
}
