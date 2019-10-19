package com.starfish.utilityclasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFunc {
	WebDriver driver;
	WebDriverWait wait;

	public BaseFunc(WebDriver driver) {
		this.driver = driver;
		 wait = new WebDriverWait(driver, 80);

	}


	public WebDriverWait waitRet(WebDriver driver) {
		WebDriverWait wait;
		return wait = new WebDriverWait(driver, 80);
	}

	public void waitforSeconds(double d) throws Exception {
		Thread.sleep((long) (d * 1000));
	}

	public void setImplicitWait(WebDriver driver, long d) {
		driver.manage().timeouts().implicitlyWait(d, TimeUnit.SECONDS);
	}

	public void preOfEleLocated(WebDriverWait wait, By byPath) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(byPath));
	}

	/*
	 * public void preOfEleLocated(WebDriverWait wait , WebElement ele) {
	 * wait.until(ExpectedConditions.visibilityOf(ele)); }
	 */

	public void visibilityOfEle(WebDriverWait wait, WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void visibilityOfEle(WebDriverWait wait, By byPath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(byPath));
	}

	public void invisibilityOfEle(WebDriverWait wait, By byPath) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byPath));
	}

	public void ele2bClickable(WebDriverWait wait, WebElement ele) {
		visibilityOfEle(wait, ele);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void ele2bClickableAndClick(WebDriverWait wait, WebElement ele, String elementName) {
		visibilityOfEle(wait, ele);
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		Reporter.log(elementName + " element clicked");
	}

	public void ele2bClickable(WebDriverWait wait, By byPath) throws InterruptedException {
		preOfEleLocated(wait, byPath);
		wait.until(ExpectedConditions.elementToBeClickable(byPath));
	}

	public void ele2bClickableAndClick(WebDriverWait wait, By byPath, String elementName) throws InterruptedException {

		preOfEleLocated(wait, byPath);
		wait.until(ExpectedConditions.elementToBeClickable(byPath)).click();
		// Reporter.log(elementName + " element clicked");
	}

	public void preOfAlert(WebDriver driver, WebDriverWait myWaitVar) throws Exception {
		myWaitVar.until(ExpectedConditions.alertIsPresent());
		waitforSeconds(0.5);
	}

	public static boolean isElementPresent(WebElement ele) {
		try {
			if (ele.isDisplayed())
				if (ele.isEnabled())
					return true;
			return false;
		}

		catch (StaleElementReferenceException e) {
			return false;
		} catch (Exception e) {
			System.out.println("Exception in isElementPresent");
			e.getMessage();
			e.printStackTrace();
		}
		return false;
	}

	public void highlightElement(WebDriver driver, By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');", driver.findElement(by));
	}

	public void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static boolean isElementDisplayed(WebDriver dri, By by, String description) {
		try {
			if (dri.findElement(by).isDisplayed())
				return true;
		} catch (NoSuchElementException e) {
			Reporter.log(description + "Element not displayed ", true);
			return false;
		} catch (Exception e) {
			Reporter.log("Element not displayed ", true);
			return false;
		}
		return false;
	}

	public static boolean isElementPresentBy(WebDriver dri, By by, String description)
			throws NoSuchElementException, InterruptedException {
		{
			try {
				if (dri.findElement(by) != null)
					return true;
			} catch (NoSuchElementException e) {
				Reporter.log("Element not present " + e.getMessage(), true);
				return false;
			} catch (Exception e) {
				Reporter.log("Element not present " + e.getMessage(), true);
				return false;
			}
			return false;
		}
	}

	/*
	 * public static boolean isElementPresent(WebDriver driver, By eleby) { try { if
	 * (driver.findElements(eleby).size() > 0) { return true; } }
	 * 
	 * catch (NoSuchElementException e) { e.printStackTrace();
	 * Reporter.log("Element not present " + e.getMessage(), true); return false; }
	 * catch (Exception e) { e.printStackTrace();
	 * Reporter.log("Element not present " + e.getMessage(), true); return false; }
	 * return false; }
	 */

	public static boolean isElementPresentByXPath(WebDriver dri, String xPath) {
		try {
			// waitforSeconds(2);
			dri.findElement(By.xpath(xPath)).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			Reporter.log("The below link's issue is " + e.getMessage(), true);
			return false;
		}
	}

	public static boolean isElementPresentByXPath(WebDriver dri, By by, String frame) throws Throwable {
		Thread.sleep(2000);
		try {
			dri.switchTo().frame(frame);
			dri.findElement(by).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			Reporter.log("The below link's issue is " + e.getMessage(), true);
			return false;
		}
	}

	/*
	 * public static WebElement isElementPresnt(WebDriver driver,String xpath,int
	 * time) { WebElement ele = null;
	 * 
	 * for(int i=0;i<time;i++) { try{ ele=driver.findElement(By.xpath(xpath));
	 * break; } catch(Exception e) { try { Thread.sleep(1000); } catch
	 * (InterruptedException e1) {
	 * //Reporter.log("Waiting for element to appear on DOM"); } } } return ele; }
	 */

	public void selectDrpDwnElement(WebElement drpElement, String visibleStringToSelect) throws Exception {
		try {
			Select selectDrpDwn = new Select(drpElement);
			selectDrpDwn.selectByVisibleText(visibleStringToSelect);

			if (!selectDrpDwn.getFirstSelectedOption().getText().toString().equalsIgnoreCase(visibleStringToSelect)) {
				throw new Exception();
			}
			waitforSeconds(0.25);
		} catch (Exception e) {
			Reporter.log("Exception in selectDrpDwnElement function", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void selectDrpDwnElementbyValue(WebElement drpElement, String valueStringToSelect) throws Exception {
		try {
			Select selectDrpDwn = new Select(drpElement);
			selectDrpDwn.selectByValue(valueStringToSelect);
			Thread.sleep(500);
		} catch (Exception e) {
			Reporter.log("Exception in selectDrpDwnElement function", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void click(WebElement drpElement, String elementName) {
		try {
			if (drpElement.isDisplayed()) {
				if (drpElement.isEnabled())
					drpElement.click();
				Reporter.log(elementName + " element clicked", true);
			}
		} catch (Exception e) {
			Reporter.log(elementName + " element is either not present or not clicked or is disabled");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void click(WebDriver dri, By byPath, String elementName) {
		try {
			WebElement ele = dri.findElement(byPath);

			if (ele.isDisplayed())
				if (ele.isEnabled())
					ele.click();
			Reporter.log(elementName + " element clicked", true);
		} catch (Exception e) {
			Reporter.log(elementName + " element is either not present or not clicked or is disabled", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickTab(WebDriver dri, By byPath, String elementName) {
		try {
			WebElement ele = dri.findElement(byPath);
			System.out.println("Entered in basefunct");
			if (ele.isDisplayed()) {
				System.out.println("Entered in basefunct is displayed");
				// if (ele.isEnabled())
				ele.click();
			}
			Reporter.log(elementName + " element clicked", true);
		} catch (Exception e) {
			Reporter.log(elementName + " element is either not present or not clicked or is disabled", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterText(WebElement drpElement, String textToEnter) {
		try {
			if (drpElement.isDisplayed()) {
				drpElement.sendKeys(textToEnter);
			}
		} catch (Exception e) {
			Reporter.log(drpElement.toString() + " textfield is not present or is disabled", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterText(WebDriver dri, By byPath, String textToEnter) {
		try {
			System.out.println(byPath+textToEnter);
			WebElement ele = dri.findElement(byPath);
			if (ele.isDisplayed())
				ele.sendKeys(textToEnter);
		} catch (Exception e) {
			Reporter.log(" textfield is not present or not clicked or is disabled", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterTextKeys(WebDriver dri, By byPath, Keys keystoHit) {
		try {
			WebElement ele = dri.findElement(byPath);
			if (ele.isDisplayed())
				ele.sendKeys(keystoHit);
		} catch (Exception e) {
			Reporter.log(" textfield is not present or not clicked or is disabled", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static String getText(WebDriver dri, By byPath) {
		try {
			return dri.findElement(byPath).getText();
		} catch (Exception e) {
			Reporter.log("exception in getText func in BaseFunc class", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static String getText(WebElement ele) {
		try {
			return ele.getText();
		} catch (Exception e) {
			Reporter.log("exception in getText func in BaseFunc class", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static boolean compTwoStrings(String str1, String str2) {
		return str1.equalsIgnoreCase(str2);
	}

	public static String getTimeStamp() {
		try {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy");
			String currentTimeStamp = dateFormat.format(date);
			return currentTimeStamp;
		} catch (Exception e) {
			Reporter.log("Exception in getTimeStamp fuct", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static String getTimeStamp_noSpecial() {
		try {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy - HH_mm_ss");
			String currentTimeStamp = dateFormat.format(date);
			return currentTimeStamp;
		} catch (Exception e) {
			Reporter.log("Exception in getTimeStamp fuct", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static String getTimeStamp_Wo_specialCha() {
		try {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
			String currentTimeStamp = dateFormat.format(date);
			return currentTimeStamp;
		} catch (Exception e) {
			Reporter.log("Exception in getTimeStamp fuct", true);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static String getDate() {

		Date date = new Date();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String currentTimeStamp = dateFormat.format(date);

		return currentTimeStamp;
	}

	public void acceptAlert(WebDriver driver, WebDriverWait myWaitVar) throws Exception {
		preOfAlert(driver, myWaitVar);
		Alert al = driver.switchTo().alert();
		al.accept();
		waitforSeconds(0.5);
	}
}
