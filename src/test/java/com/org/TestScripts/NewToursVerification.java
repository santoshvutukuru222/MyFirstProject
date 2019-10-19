// Executing the Search Module

package com.org.TestScripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.starfish.pages.NewToursHomePageLinks;
import com.starfish.utilityclasses.DriverClass;
import com.starfish.utilityclasses.Read_PropertyFile;

public class NewToursVerification extends ExtentReportBase {
	WebDriver driver;

	/**
	 * 
	 * This test case will execute the Advanced Search with Results
	 * 
	 */
	@Test
	//@Parameters({ "browser","searchValue" })
	public void langingPageVerification() throws Exception {
		String browser="chrome";
		System.out.println(browser);

		test = extent.createTest("Opening the URL of the NewTours");

		driver = DriverClass.getDriver(browser);

		

		Read_PropertyFile obj_url = new Read_PropertyFile();

		driver.get(obj_url.Passurl());

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		test.log(Status.PASS, "**** Opened the URL New Tours succefully ****");
		
		NewToursHomePageLinks newToursHomePageLinks = new NewToursHomePageLinks(driver);
		HashMap<String,String> returnedValues=newToursHomePageLinks.getHyperlinks();
		
		for(String keyValue:returnedValues.keySet()) {
			
			System.out.println("The Key is " + keyValue +" and the value is "+ returnedValues.get(keyValue) );
			test.log(Status.PASS, "The Key is " + keyValue +" and the value is "+ returnedValues.get(keyValue));
		}

	}

	/*@Test
	@Parameters({ "searchValue" })
	public void search(String searchValue) {
		LandingPage landingPageVerification = new LandingPage(driver);
		landingPageVerification.search(searchValue);

	}*/

}
