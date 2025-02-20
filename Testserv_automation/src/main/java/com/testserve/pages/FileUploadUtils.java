package com.testserve.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import com.testserve.utils.EventUtils;

public class FileUploadUtils {

	WebDriver driver;


	public FileUploadUtils (WebDriver driver) {
		this.driver = driver;

	}

	public static void uploadFile(String fileToUpload) throws AWTException {

		EventUtils eventUtils = new EventUtils();

		StringSelection str = new StringSelection(fileToUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		Robot robot = new Robot();

		robot.delay(1000);
		// press Contol+V for pasting
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.delay(1000);
		// for pressing and releasing Enter

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}