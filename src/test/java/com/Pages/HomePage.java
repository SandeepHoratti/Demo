package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, HomePage.class);
//		this.driver=driver;
	}
	
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement signInLink;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement registerLink;
	
	public void clickOnSignInLink(){
		signInLink.click();
	}
	
	
	/*public LoginPage clickOnSignInLink1(){
		signInLink.click();
		//return LoginPage.class ;
	}*/
	
	public void clickOnRegisterLink(){
		registerLink.click();
	}
	
	public String getApplicationTitle(){
		return driver.getTitle();
	}
	
	public HomePage getTitle(){
		
		
		
		return this;
	}
}
