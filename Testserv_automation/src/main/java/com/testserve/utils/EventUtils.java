package com.testserve.utils;

import java.awt.AWTException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testserve.pages.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class EventUtils {

	public String getTextOfWebelement(RemoteWebDriver driver, WebElement element, int timeOut, ExtentTest test) {
		BasePage report = new BasePage(driver, test);
		String text = "";
		if (waitUntilElementIsPresent(driver, element, timeOut)) {
			text = element.getText();
			System.out.println("Text Of The Element:-" + text);
			report.logStatus("info", "Text of the element is:-" + text);
		} else {
			report.logStatus("error", "Unable to get the text of the element due to element not present");
		}
		return text;
	}

	/***
	 * Name of Function :- getWebelements Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Syste Function Description :- To get the list of
	 * a WebElements
	 * 
	 * @return List
	 */
	public List<WebElement> getWebelements(RemoteWebDriver driver, By locator, int timeOut, ExtentTest test) {
		BasePage report = new BasePage(driver, test);
		List<WebElement> ele = null;
		if (locator != null) {
			if (waitUntilElementIsVisible(driver, locator, timeOut)
					|| waitUntilElementIsPresent(driver, locator, timeOut)) {
				ele = driver.findElements(locator);

				report.logStatus("info", "get webelements");
			} else {
				report.logStatus("error", "Unable to get webelement");
			}
		}
		return ele;
	}

	/***
	 * Name of Function :- getWebelement Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :- To get the
	 * WebElement
	 * 
	 * @return WebElement
	 */
	public WebElement getWebelement(RemoteWebDriver driver, By locator, int timeOut, ExtentTest test) {
		BasePage report = new BasePage(driver, test);
		WebElement ele = null;
		if (locator != null) {
			if (waitUntilElementIsVisible(driver, locator, timeOut)) {
				ele = driver.findElement(locator);

				report.logStatus("info", "get webelement");
			} else {
				report.logStatus("error", "Unable to get webelement");
			}
		}
		return ele;
	}

	/***
	 * Name of Function :- clearContent Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :- this method clear
	 * the text in the input field
	 */
	public void clearContent(RemoteWebDriver driver, By locator) {
		driver.findElement(locator).sendKeys("");
	}

	/***
	 * Name of Function :- getTextOfWebelements Developed By :- Ifocus Automation
	 * Team Organization Name :- Ifocus Systec Function Description :- To get the
	 * List of a WebElements by Locator
	 * 
	 * @return ArrayList
	 */

	public ArrayList<String> getTextOfWebelements(RemoteWebDriver driver, By locator, int timeOut, ExtentTest test) {
		BasePage report = new BasePage(driver, test);
		String text = "";
		ArrayList<String> textContent = new ArrayList<>();
		if (locator != null) {
			if (waitUntilElementIsVisible(driver, locator, timeOut)) {
				List<WebElement> ele = driver.findElements(locator);
				for (int i = 0; i < ele.size(); i++) {
					text = ele.get(i).getText();
					textContent.add(text);
				}
				report.logStatus("info", "Text of the element is:-" + text);
			} else {
				report.logStatus("error", "Unable to get the text of the element due to element not present");
			}
		}
		return textContent;
	}

	/***
	 * Name of Function :- getTextOfWebelement Developed By :- Ifocus Automation
	 * Team Organization Name :- Ifocus Systec Function Description :- To get the
	 * Text of a Web Element by Locator
	 * 
	 * @return String
	 */

	public String getTextOfWebelement(RemoteWebDriver driver, By locator, int timeOut, ExtentTest test) {
		BasePage report = new BasePage(driver, test);
		String text = "";
		if (locator != null) {
			if (waitUntilElementIsPresent(driver, locator, timeOut)
					|| waitUntilElementIsVisible(driver, locator, timeOut)) {

				if (Web_Constants.PROJECT.contains("WEB")) {
					text = driver.findElement(locator).getAttribute("innerText");
				} else {

					try {
						text = driver.findElement(locator).getText();
					} catch (Exception e) {
						report.logStatus("error", "Unable to get the text of the element due to element not present");

					}

				}

				report.logStatus("info", "Text of the element is:-" + text);
			} else {
				report.logStatus("error", "Unable to get the text of the element due to element not present");
			}
		}
		return text;
	}

	/***
	 * Name of Function :- getValueOfWebelement Developed By :- Ifocus Automation
	 * Team Organization Name :- Ifocus Systec Function Description :- To get the
	 * Text of a WebElement by Locator using Attribute
	 * 
	 * @return String
	 */
	public String getValueOfWebelement(RemoteWebDriver driver, By locator, int timeOut, ExtentTest test, String value) {
		BasePage report = new BasePage(driver, test);
		String text = "";
		if (locator != null) {
			if (waitUntilElementIsPresent(driver, locator, timeOut)) {
				text = driver.findElement(locator).getAttribute(value);

				report.logStatus("info", "Text of the element is:-" + text);
			} else {
				report.logStatus("error", "Unable to get the text of the element due to element not present");
			}
		}
		return text;
	}

	/***
	 * Name of Function :- getSizeOfWebelement Developed By :- Ifocus Automation
	 * Team Organization Name :- Ifocus Systec Function Description :- To get the
	 * WebElement Dimension
	 * 
	 * @return Dimension
	 */
	public Dimension getSizeOfWebelement(RemoteWebDriver driver, WebElement element, int timeOut, ExtentTest test) {
		BasePage report = new BasePage(driver, test);
		Dimension count = null;

		if (waitUntilElementIsVisible(driver, element, timeOut)) {
			count = element.getSize();

			report.logStatus("info", "count of the element is:-" + count);
		} else {
			report.logStatus("error", "Unable to get the count of the element due to element not present");
		}

		return count;
	}

	/***
	 * Name of Function :- dismissAlert Developed By :- Ifocus Automation Team Date
	 * Description :- To dismiss Alert
	 */

	public void dismissAlert(RemoteWebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/***
	 * Name of Function :- acceptAlert Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :- To accept Alert
	 */
	public void acceptAlert(RemoteWebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/***
	 * Name of Function :- switchToFrame Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :- To switch to frame
	 * by Index
	 */
	public void switchToFrame(RemoteWebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	/***
	 * Name of Function :- switchToFrame Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :- To switch to frame
	 * by Name
	 */
	public void switchToFrame(RemoteWebDriver driver, String name) {

		driver.switchTo().frame(name);

	}

	/***
	 * Name of Function :- switchToDefaultContent Developed By :- Ifocus Automation
	 * Team Organization Name :- Ifocus Systec Function Description :- To switch to
	 * Default Content
	 */
	public void switchToDefaultContent(RemoteWebDriver driver) {

		driver.switchTo().defaultContent();

	}

	/***
	 * Name of Function :- switchToFrame Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :- To switch to Frame
	 * by web element
	 */
	public void switchToFrame(RemoteWebDriver driver, WebElement element) {

		if (waitUntilElementIsPresent(driver, element, 20)) {
			driver.switchTo().frame(element);
		}

	}

	/***
	 * Name of Function :- switchToFrame Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :- To switch to Frame
	 * by locator
	 */
	public void switchToFrame(RemoteWebDriver driver, By locator) {

		if (waitUntilElementIsVisible(driver, locator, 10)) {
			driver.switchTo().frame(driver.findElement(locator));
			System.out.println("swiched to frame");
		}

	}

	/***
	 * Name of Function :- switchToFrame Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :- To switch to Frame
	 * by index
	 */
	public void switchToFrameIndex(RemoteWebDriver driver, int num) {

		driver.switchTo().frame(num);

	}

	/***
	 * Name of Function :- sleep Developed By :- Ifocus Automation Team Organization
	 * Name :- Ifocus Systec Function Description :- To wait for particular seconds
	 */
	public void sleep(int seconds) {

		String sec = String.valueOf(seconds) + "000";
		Integer time = Integer.parseInt(sec);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

		}
	}

	/***
	 * Name of Function :- waitUntilPageLoaded Developed By :- Ifocus Automation
	 * Team Organization Name :- Ifocus Systec Function Description :- To wait until
	 * page gets loaded
	 */
	public void waitUntilPageLoaded(RemoteWebDriver driver) {

		Object status = "";

		while (!status.toString().equalsIgnoreCase("complete")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			status = js.executeScript("return document.readyState");
		}

	}

	/***
	 * Name of Function :- scrollToTop Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :- To Scroll To Top
	 * Of The Page
	 */
	public void scrollToTop(RemoteWebDriver driver) {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)", "");

	}

	/***
	 * Name of Function :- getCurrentUrl Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :-To get the Current
	 * URL
	 * 
	 * @return String
	 */
	public String getCurrentUrl(RemoteWebDriver driver, ExtentTest test) {
		BasePage basePage = new BasePage(driver, test);
		String currentURL = "";

		currentURL = driver.getCurrentUrl();
		basePage.logStatus("info", "Current Page Url:-" + currentURL);

		return currentURL;
	}

	/***
	 * Name of Function :- getPageTitle Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :-To get the Current
	 * Page Title
	 * 
	 * @return String
	 */
	public String getPageTitle(RemoteWebDriver driver, ExtentTest test) {
		BasePage basePage = new BasePage(driver, test);
		basePage.logStatus("info", "Current Page Title:-" + driver.getTitle());
		return driver.getTitle();
	}

	/***
	 * Name of Function :- clickOnElement Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :-To click the
	 * element by webElement
	 */
	public void clickOnElement(RemoteWebDriver driver, WebElement elementToClick, String typeOfElement, int timeOut,
			ExtentTest test) throws Exception {
		BasePage basePage = new BasePage(driver, test);
		boolean isElementClicked = false;

		if (elementToClick != null) {

			if (waitUntilElementIsPresent(driver, elementToClick, timeOut)) {
				try {
					elementToClick.click();
					isElementClicked = true;
				} catch (StaleElementReferenceException | ElementClickInterceptedException ECIR) {
					elementToClick.click();
					isElementClicked = true;
				}
			}

		}

		if (isElementClicked) {
			basePage.logStatus("info", "User clicked on " + typeOfElement);
		} else {
			basePage.logStatus("error", "User unable to click on " + typeOfElement);
		}
	}

	/***
	 * Name of Function :- clickOnElement Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :-To click the
	 * element by locator
	 */
	public void clickOnElement(RemoteWebDriver driver, By elementToClick, String typeOfElement, int timeOut,
			ExtentTest test) {
		BasePage basePage = new BasePage(driver, test);
		boolean isElementClicked = false;

		if (elementToClick != null) {
			if (waitUntilElementIsVisible(driver, elementToClick, timeOut)) {
				try {
					driver.findElement(elementToClick).click();
					isElementClicked = true;
				} catch (Exception e) {
					try {

						clickUsingJavaScript(driver, elementToClick);

						isElementClicked = true;
					} catch (Exception e1) {

					}
				}
			}
		}

		if (isElementClicked) {
			basePage.logStatus("info", "User clicked on " + typeOfElement);
		} else {
			basePage.logStatus("error", "User unable to click on " + typeOfElement);
		}
	}

	/***
	 * Name of Function :- clickOnElement Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :-To click the
	 * element by locator
	 */
	// To click the element by locator
	public void clickOnElement(RemoteWebDriver driver, By elementToClick, String typeOfElement, int timeOut) {
		boolean isElementClicked = false;

		if (elementToClick != null) {
			if (waitUntilElementIsVisible(driver, elementToClick, timeOut)) {
				try {
					driver.findElement(elementToClick).click();
					isElementClicked = true;
				} catch (Exception e) {
					try {
						driver.findElement(elementToClick).click();
						isElementClicked = true;
					} catch (Exception e1) {

					}
				}
			}
		}

		if (isElementClicked) {

			System.out.println("User clicked on :-" + typeOfElement);
		} else {
			System.out.println("User unable to click on :-" + typeOfElement);
		}
	}

	/***
	 * Name of Function :- clickOnElement Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :-To click the
	 * element by webElement using javascript
	 */
	public void ClickOnElement(RemoteWebDriver driver, By elementToClick, String typeOfElement, int timeOut,
			ExtentTest test) {
		BasePage basePage = new BasePage(driver, test);
		boolean isElementClicked = false;

		if (elementToClick != null) {
			if (waitUntilElementIsPresent(driver, elementToClick, 20)) {
				scrollToParticularElement(driver, elementToClick);
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();",
							driver.findElement(elementToClick));
					isElementClicked = true;
				} catch (StaleElementReferenceException | ElementClickInterceptedException ECIR) {
					driver.findElement(elementToClick).click();
					isElementClicked = true;
				}
			} else {
				basePage.logStatus("info", "Not able to find the element");
			}
		}

		if (isElementClicked) {
			basePage.logStatus("info", "User clicked on " + typeOfElement);
		} else {
			basePage.logStatus("error", "User unable to click on " + typeOfElement);
		}
	}

	/***
	 * Name of Function :- enterValue Developed By :- Ifocus Automation Team
	 * Function Description :-To enter the value in the field
	 */
	public void enterValue(RemoteWebDriver driver, By locator, String valueToEnter, String typeOfField, int timeOut,
			ExtentTest test) {
		boolean isValueEntered = false;
		BasePage basePage = new BasePage(driver, test);
		try {
			if (locator != null) {
				if (waitUntilElementIsVisible(driver, locator, timeOut)) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].value = '';", driver.findElement(locator));
					driver.findElement(locator).sendKeys(valueToEnter);
					isValueEntered = true;
				} else {
					basePage.logStatus("error", typeOfField + " is not visible waiting till " + timeOut + " seconds");
				}
			} else {
				basePage.logStatus("error", "Not able to find the element" + typeOfField);
			}

		} catch (Exception e) {
			basePage.logStatus("error", "User unable to enter " + " in " + typeOfField);
		}
		if (isValueEntered) {
			basePage.logStatus("info", "User entered the value " + " in " + typeOfField);
		} else {
			basePage.logStatus("error", "User unable to enter " + " in " + typeOfField);
		}
	}

	/***
	 * Name of Function :- enterValue Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :-To enter the value
	 * in the field
	 */
	public void enterValue(RemoteWebDriver driver, WebElement element, String valueToEnter, String typeOfField,
			int timeOut, ExtentTest test) {

		boolean isValueEntered = false;
		BasePage basePage = new BasePage(driver, test);
		if (element != null) {
			if (waitUntilElementIsVisible(driver, element, timeOut)) {
				element.clear();
				element.sendKeys(valueToEnter);
				isValueEntered = true;
			} else {
				basePage.logStatus("error", typeOfField + " is not visible waiting till " + timeOut + " seconds");
			}
		} else {
			basePage.logStatus("error", "Not able to find the element" + typeOfField);
		}

		if (isValueEntered) {
			basePage.logStatus("info", "User entered the value " + " in " + typeOfField);
		} else {
			basePage.logStatus("error", "User unable to enter " + " in " + typeOfField);
		}
	}

	/***
	 * Name of Function :- moveToElementAndClick Developed By :- Ifocus Automation
	 * Team Organization Name :- Ifocus Systec Function Description :-To move to the
	 * element and click
	 */
	public void moveToElementAndClick(RemoteWebDriver driver, WebElement element, String typeOfElement, int timeOut,
			ExtentTest test) {

		boolean isElementClicked = false;
		BasePage basePage = new BasePage(driver, test);
		if (element != null) {
			if (waitUntilElementIsVisible(driver, element, timeOut)) {
				try {
					Actions act = new Actions(driver);
					act = act.moveToElement(element);
					act.click().build().perform();
					isElementClicked = true;
				} catch (Exception e) {
					basePage.logStatus("error", "Unable to Click on  the element:-" + typeOfElement);
				}
			} else {
				basePage.logStatus("info", typeOfElement + " is not visible waiting till " + timeOut + " seconds");
			}
		} else {
			basePage.logStatus("info", "Unable to find the element:-" + typeOfElement);
		}

		if (isElementClicked) {
			basePage.logStatus("info", "User clicked on " + typeOfElement);
		} else {
			basePage.logStatus("error", "User unable click " + typeOfElement);

		}

	}

	/***
	 * Name of Function :- moveToElementAndClick Developed By :- Ifocus Automation
	 * Team Organization Name :- Ifocus Systec Function Description :-To move to the
	 * element and click
	 */
	public void moveToElementAndClick(RemoteWebDriver driver, By locator, String typeOfElement, int timeOut,
			ExtentTest test) {

		boolean isElementClicked = false;
		BasePage basePage = new BasePage(driver, test);

		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(mouseOverScript, driver.findElement(locator));
		driver.findElement(locator).click();
		isElementClicked = true;

		if (isElementClicked) {
			basePage.logStatus("info", "User clicked on " + typeOfElement);
		} else {
			basePage.logStatus("error", "User unable click " + typeOfElement);

		}

	}

	public void enterUsingkeyboardActions(RemoteWebDriver driver) {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}

	/***
	 * Name of Function :- switchToLatestWindow Developed By :- Ifocus Automation
	 * Team Organization Name :- Ifocus Systec Function Description :-To switch To
	 * Latest Window
	 */
	public void switchToLatestWindow(RemoteWebDriver driver, ExtentTest test) {

		BasePage basePage = new BasePage(driver, test);
		Set<String> windows = driver.getWindowHandles();
		for (String winHandle : windows) {
			driver.switchTo().window(winHandle);
			sleep(2);
			basePage.logStatus("info", "Switched to the window");
			sleep(2);
		}
	}

	/***
	 * Name of Function :- switchToParenttWindow Developed By :- Ifocus Automation
	 * Team Organization Name :- Ifocus Systec Function Description :-To switch To
	 * parent Window
	 */
	public void switchToParenttWindow(RemoteWebDriver driver, ExtentTest test) {

		Set<String> windows = driver.getWindowHandles();
		List<String> windowHandles = new ArrayList<String>(windows);
		driver.switchTo().window(windowHandles.get(0));

	}

	/***
	 * Name of Function :- switchToParticularWindow Developed By :- Ifocus
	 * Automation Team Organization Name :- Ifocus Systec Function Description :-To
	 * Switch to particular Window Session
	 */
	public void switchToParticularWindow(RemoteWebDriver driver, String sessionId, ExtentTest test) {
		BasePage basePage = new BasePage(driver, test);
		driver.switchTo().window(sessionId);
		basePage.logStatus("info", "user is on particular window");
	}

	/***
	 * Name of Function :- scrollToParticularElement Developed By :- Ifocus
	 * Automation Team Organization Name :- Ifocus Systec Function Description :-To
	 * scroll to particular element by web element
	 */
	public void scrollToParticularElement(RemoteWebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * Name of Function :- scrollToParticularElement Developed By :- Ifocus
	 * Automation Team Organization Name :- Ifocus Systec Function Description :-To
	 * scroll to particular element by locator
	 */
	public void scrollToParticularElement(RemoteWebDriver driver, By locator) {
		try {
			waitUntilElementIsPresent(driver, locator, 10);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-400)");
			waitUntilElementIsVisible(driver, locator, 5);

		} catch (Exception e) {

		}
	}

	/***
	 * Name of Function :- scrollTillEnd Developed By :- Ifocus Automation Team
	 * Organization Name :- Ifocus Systec Function Description :-Scroll To Page End
	 */
	public void scrollTillEnd(RemoteWebDriver driver) throws Exception {
		for (int i = 0; i < 30; i++) {
			try {

				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(500);

			} catch (Exception e) {
				break;
			}
		}
	}

	/***
	 * Name of Function :- waitUntilElementIsVisible Developed By :- Ifocus
	 * Automation Team Organization Name :- Ifocus Systec Function Description :-To
	 * wait until element is visible by web element
	 * 
	 * @return boolean
	 */
	public boolean waitUntilElementIsVisible(RemoteWebDriver driver, WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	/***
	 * Name of Function :- waitUntilElementIsVisible Developed By :- Ifocus
	 * Automation Team Organization Name :- Ifocus Systec Function Description :-To
	 * wait until element is visible by locator
	 * 
	 * @return boolean
	 */
	public boolean waitUntilElementIsVisible(RemoteWebDriver driver, By locator, int timeOut) {
		boolean isElementEnabled = false;
		// if (waitUntilElementIsPresent(driver, locator, timeOut)) {
		if (locator != null) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

				isElementEnabled = waitUntilElementIsDisplayed(driver, locator, timeOut);

			} catch (Exception e) {
				isElementEnabled = false;

			}
		}
		// }
		return isElementEnabled;
	}

	public String getTimeStampEpoch() {
		Instant instant = Instant.now();
		// java.util.Date date= new java.util.Date();
		Long time = instant.getEpochSecond();
		time = time;
		return time.toString();
	}

	/***
	 * Name of Function :- waitUntilElememtIsClickable Developed By :- Ifocus
	 * Automation Team Organization Name :- Ifocus Systec Function Description :-To
	 * wait until element is clickable
	 * 
	 * @return boolean
	 */
	public boolean waitUntilElememtIsClickable(RemoteWebDriver driver, WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	/***
	 * Name of Function :- waitUntilElememtIsClickable Developed By :- Ifocus
	 * Automation Team Organization Name :- Ifocus Systec Function Description :-To
	 * wait until element is clickable
	 * 
	 * @return boolean
	 */
	public boolean waitUntilElememtIsClickable(RemoteWebDriver driver, By locator, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			// e.printStackTrace();
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	/***
	 * Name of Function :- waitUntilElementIsPresent Developed By :- Ifocus
	 * Automation Team Organisation Name :- Ifocus Systec Function Description :-To
	 * wait until element is present by Webelement
	 * 
	 * @return boolean
	 */
	public boolean waitUntilElementIsPresent(RemoteWebDriver driver, WebElement element, int timeout) {
		boolean isElementPresent = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementPresent = true;
		} catch (Exception e) {
			isElementPresent = false;
			e.printStackTrace();
		}
		return isElementPresent;
	}

	/***
	 * Name of Function :- waitUntilElementIsPresent Developed By :- Ifocus
	 * Automation Team Organisation Name :- Ifocus Systec Function Description :-To
	 * wait until element is present by locator
	 * 
	 * @return boolean
	 */
	public boolean waitUntilElementIsPresent(RemoteWebDriver driver, By locator, int timeout) {
		boolean isElementPresent = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementPresent = true;
		} catch (Exception e) {
			isElementPresent = false;
		}
		return isElementPresent;
	}

	/***
	 * Name of Function :- refreshPage Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Function Description :-To refresh the page
	 */
	public void refreshPage(RemoteWebDriver driver, ExtentTest test) {
		EventUtils eventutils = new EventUtils();
		boolean isPageRefresh = false;
		BasePage report = new BasePage(driver, test);
		try {
			if (driver != null) {
				driver.navigate().refresh();
				isPageRefresh = true;
			}
		} catch (Exception e) {

		}
		if (!isPageRefresh) {
			report.logStatus("error", "Unable to refresh the page");
		}
		eventutils.sleep(5);

	}

	/***
	 * Name of Function :- scrollToElement Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Function Description :-To scroll to the
	 * specific element
	 */
	public void scrollToElement(RemoteWebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		} catch (StaleElementReferenceException e) {
			sleep(2);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		}
	}

	/***
	 * Name of Function :- scrollToElement Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Function Description :-To scroll to the
	 * specific Locator
	 */
	public void scrollToElement(RemoteWebDriver driver, By locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));

		} catch (Exception e) {
			sleep(2);
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));

			} catch (Exception e1) {

			}
		}
	}

	/***
	 * Name of Function :- mouseHoverToElement Developed By :- Ifocus Automation
	 * Team Organisation Name :- Ifocus Systec Function Description :-To mousehover
	 * to element by webelement
	 */
	public void mouseHoverToElement(RemoteWebDriver driver, WebElement element, int timeout, ExtentTest test) {
		BasePage report = new BasePage(driver, test);
		try {

			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();

		} catch (Exception e) {
			report.logStatus("error", "Unable to mouse hover to the element");
		}
	}

	/***
	 * Name of Function :- mouseHoverToElement Developed By :- Ifocus Automation
	 * Team Organisation Name :- Ifocus Systec Function Description :-To mousehover
	 * to element by locator
	 */
	public void mouseHoverToElement(RemoteWebDriver driver, By locator, int timeout, ExtentTest test) {
		BasePage report = new BasePage(driver, test);
		try {

			if (waitUntilElementIsPresent(driver, locator, timeout)) {

				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(locator)).build().perform();

			}

		} catch (Exception e) {
			e.printStackTrace();
			report.logStatus("error", "Unable to mouse hover to the element");
		}
	}

	/***
	 * Name of Function :- clickUsingJavaScript Developed By :- Ifocus Automation
	 * Team Organisation Name :- Ifocus Systec Date :- 27-Jan-2022 Function
	 * Description :-to click on the webelement using javascript locator
	 */
	public void clickUsingJavaScript(RemoteWebDriver driver, By locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));

	}

	/***
	 * Name of Function :- scrollDownBy500 Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Date :- 27-Jan-2022 Function Description
	 * :-To scroll by co-ordinates 500
	 */
	public void scrollDownBy500(RemoteWebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");

	}

	/***
	 * Name of Function :- scrollDownBy200 Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Date :- 27-Jan-2022 Function Description
	 * :-To scroll by co-ordinates 200
	 */
	public void scrollDownBy200(RemoteWebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

	}

	/***
	 * Name of Function :- navigateBack Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Function Description :-To Navigate Back
	 */
	public void navigateBack(RemoteWebDriver driver, ExtentTest test) {
		BasePage report = new BasePage(driver, test);
		driver.navigate().back();

	}

	/***
	 * Name of Function :- scrollDownUp Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Function Description :-To scroll to the
	 * Bottom and Top Of the Page
	 */
	public void scrollDownUp(RemoteWebDriver driver) {
		try {
			scrollTillEnd(driver);
			scrollToTop(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * Name of Function :- waitUntilElementAreVisible Developed By :- Ifocus
	 * Automation Team Organisation Name :- Ifocus Systec Function Description :-To
	 * wait until elements are visible by web element
	 * 
	 * @return boolean
	 */
	public boolean waitUntilElementAreVisible(RemoteWebDriver driver, List<WebElement> element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	/***
	 * Name of Function :- close Developed By :- Ifocus Automation Team Organisation
	 * Name :- Ifocus Systec Function Description :-To Close The browser
	 */
	public void close(RemoteWebDriver driver) {
		driver.close();
	}

	/***
	 * Name of Function :- navigateToUrl Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Function Description :-To Navigate to
	 * Given URL
	 */
	public void navigateToUrl(RemoteWebDriver driver, String URL) {

		driver.get(URL);

	}

	/***
	 * Name of Function :- navigateBack Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Function Description :-To Navigate to Back
	 * Page
	 */
	public void navigateBack(RemoteWebDriver driver) {

		driver.navigate().back();

	}

	/***
	 * Name of Function :- navigateForward Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Function Description :-To Navigate to next
	 * Page
	 */
	public void navigateForward(RemoteWebDriver driver, String URL) {
		driver.navigate().forward();
	}

	/***
	 * Name of Function :- ClickOutsidePopup Developed By :- Ifocus Automation Team
	 * Organisation Name :- Ifocus Systec Function Description :- Action on the
	 * offsets
	 * 
	 * @param driver
	 * @param test
	 * @param 1st    offset
	 * @param 2nd    offset
	 *
	 */
	public void ClickOutsidePopup(RemoteWebDriver driver, ExtentTest test, int num1, int num2) {
		try {
			Actions action = new Actions(driver);
			action.moveByOffset(num1, num2).click().build().perform();
		} catch (Exception e) {

		}
	}

	// Scroll down to element by 100
	public void scrollDownBy100(RemoteWebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}

	// To click the element by locator
	public void clickOnElementjavaScrpit(RemoteWebDriver driver, By elementToClick, String typeOfElement, int timeOut,
			ExtentTest test) {
		BasePage basePage = new BasePage(driver, test);
		boolean isElementClicked = false;

		try {
			Thread.sleep(1000);
			driver.findElement(elementToClick).click();
			isElementClicked = true;
		} catch (Exception e) {
			driver.findElement(elementToClick).click();
			isElementClicked = true;
		}

		if (isElementClicked) {
			basePage.logStatus("info", "User clicked on " + typeOfElement);
		} else {
			basePage.logStatus("error", "User unable to click on " + typeOfElement);
		}
	}

	// Click on element using click method
	public void clickElement(RemoteWebDriver driver, By elementToClick, ExtentTest test) {
		try {
			driver.findElement(elementToClick).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String gettingText(RemoteWebDriver driver, By elementId) {
		String text = "";
		try {
			text = driver.findElement(elementId).getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return text;
	}

	public boolean waitUntilElementIsDisplayed(RemoteWebDriver driver, By locator, int timeOut) {
		boolean isElementVisible = false;
		if (locator != null) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				for (int i = 0; i < timeOut * 2; i++) {
					try {
						if (driver.findElement(locator).isDisplayed()) {
							isElementVisible = true;
							break;
						}
					} catch (Exception e) {
					}
//	                       Thread.sleep(500);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return isElementVisible;
	}

	public boolean waitUntilElementVisiblity(RemoteWebDriver driver, By locator, int timeOut) {
		boolean isElementEnabled = false;
		if (locator != null) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				for (int i = 0; i < 80 * timeOut; i++) {
					try {
						wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
						isElementEnabled = true;
						break;
					} catch (Exception e) {
					}

				}

			} catch (Exception e) {
				isElementEnabled = false;

			}
		}
		return isElementEnabled;
	}


		
	}

	
		
	
