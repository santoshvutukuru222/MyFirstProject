// Executing the Search Module

package com.org.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.starfish.pages.LandingPage;
import com.starfish.utilityclasses.DriverClass;
import com.starfish.utilityclasses.Read_PropertyFile;

public class LangingPageVerification extends ExtentReportBase {
	WebDriver driver;

	/**
	 * 
	 * This test case will execute the Advanced Search with Results
	 * 
	 */
	@Test
	@Parameters({ "browser","searchValue" })
	public void langingPageVerification(String browser,String searchValue ) throws Exception {
		System.out.println(browser+searchValue);

		test = extent.createTest("Opening the URL of the NewTours");

		driver = DriverClass.getDriver(browser);

		

		Read_PropertyFile obj_url = new Read_PropertyFile();

		driver.get(obj_url.Passurl());

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		test.log(Status.PASS, "**** Opened the URL succefully ****");
		
		LandingPage landingPageVerification = new LandingPage(driver);
		landingPageVerification.search(searchValue);

	}

	/*@Test
	@Parameters({ "searchValue" })
	public void search(String searchValue) {
		LandingPage landingPageVerification = new LandingPage(driver);
		landingPageVerification.search(searchValue);

	}*/

}
