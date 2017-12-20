package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableLibrary {
	WebDriver driver;

	/**
	 * Constructor to initialize the {@link ScriptHelper} object and in turn the objects wrapped by it
	 * @param scriptHelper The {@link ScriptHelper} object
	 * @param driver The {@link WebDriver} object
	 */
	
	public ReusableLibrary(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	public void waitForVisibility(WebElement element){
		 new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForClickable(WebElement element){
		new WebDriverWait(driver, 60).
			until(ExpectedConditions.
				elementToBeClickable(element));
	}
	
	public void click(WebElement element){
		waitForVisibility(element);
		waitForClickable(element);
		element.click();
	}
	
	public void sendKeys(WebElement element, String value){
		waitForVisibility(element);
		waitForClickable(element);
		element.sendKeys(value);
	}
	
	
	
	
	
}
