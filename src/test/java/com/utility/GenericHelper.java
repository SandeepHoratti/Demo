package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericHelper extends StartWebDriver {
	
	
	
	public static void takeScreenShot(String fileName) {
		DateFormat dateFormat=new SimpleDateFormat("MM-DD-YYYY HH-MM-SS");
		Date date = new Date();
		String date1= dateFormat.format(date);	
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("Screenshots\\" + fileName + date1 + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) { }
	}
	
	public static String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}
	
	
	public static boolean isElementPresent(String locator) {
		boolean status = false;
		
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() >= 1){
			status = true;
		}else if(driver.findElements(By.name(locator)).size() >= 1 ){
			status = true;
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
			status = true;
		}else if(driver.findElements(By.xpath(locator)).size() >= 1){
			status = true;
		}else
			status = false;
		return status;
	}
	
	public static Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return (exe.executeScript(script));
		
	}
	
	public static void waitForElement(String locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
			return;
		}else if(driver.findElements(By.name(locator)).size() >= 1 ){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
			return;
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
			return;
		}else if(driver.findElements(By.xpath(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			return;
		}else
			throw new NoSuchElementException("Element Not Found : " + locator);
		
	}
	public static void waitForVisibility(WebElement element){
		 new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForClickable(WebElement element){
		new WebDriverWait(driver, 60).
			until(ExpectedConditions.
				elementToBeClickable(element));
	}
	
	public static void click(WebElement element){
		waitForVisibility(element);
		waitForClickable(element);
		element.click();
	}
	
	public static  void sendKeys(WebElement element, String value){
		waitForVisibility(element);
		waitForClickable(element);
		element.sendKeys(value);
	}
}
