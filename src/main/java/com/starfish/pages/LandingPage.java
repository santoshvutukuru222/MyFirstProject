package com.starfish.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.starfish.utilityclasses.BaseFunc;

public class LandingPage extends BaseFunc {

	WebDriver driver;
	By searchId = By.id("s");
	By searchButton = By.id("searchsubmit");

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		System.out.println("came in to login page");

	}

	public void search(String searchValue) {
		
		System.out.println("Before search");
		enterText(driver, searchId, searchValue);
		click(driver, searchButton, "Clicking on the Search Button");
		
		//driver.findElement(searchId).sendKeys(searchValue);
		
		System.out.println("after search");

	}

}
