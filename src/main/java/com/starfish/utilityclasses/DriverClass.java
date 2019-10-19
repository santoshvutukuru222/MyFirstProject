package com.starfish.utilityclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverClass {
	// Initializing the WebDriver
	public static WebDriver driver = null;

	// Launching the Browser and Passing the URL
	public static WebDriver getDriver(String browser) {
		try {

			if (browser.equalsIgnoreCase("chrome")) {
				if (driver == null) {
					System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
					// driver=new ChromeDriver();
					ChromeOptions Chr_obj = new ChromeOptions();
					Chr_obj.addArguments("disable-infobars");

					driver = new ChromeDriver(Chr_obj);
					
				}
			}  else if (browser.equalsIgnoreCase("IE")) {
				driver= new InternetExplorerDriver();
			}
		} catch (Exception e) {
			System.out.println("Cannot create the Webdriver Instance" + e.getMessage());
		}
		return driver;

	}

}
