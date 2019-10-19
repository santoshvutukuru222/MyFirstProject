package com.starfish.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.starfish.utilityclasses.BaseFunc;

public class NewToursHomePageLinks extends BaseFunc {

	WebDriver driver;
	
	HashMap<String, String> textAndLink = new HashMap<String,String>();
	

	public NewToursHomePageLinks(WebDriver driver) {
		super(driver);
		this.driver = driver;
		System.out.println("came in to landingpage");

	}
	
	public HashMap<String, String> getHyperlinks() {
		List<WebElement> hyperlinkElement= driver.findElements(By.tagName("a"));
		
		for (WebElement webElement : hyperlinkElement) {
			
			textAndLink.put(webElement.getText(), webElement.getAttribute("href"));
			System.out.println(webElement.getText());
			
			System.out.println(webElement.getAttribute("href"));
			
		}
		
		return textAndLink;
	}

	

}
