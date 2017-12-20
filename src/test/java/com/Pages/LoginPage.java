package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
	this.driver=driver;	
	}
	
	@FindBy(xpath="//label[text()='Email or Login']/../input")
	WebElement username;
	
	@FindBy(xpath="//label[text()='Password']/../input")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Sign In']")
	WebElement signInButton;
	
	@FindBy(xpath="//a[text()='Forgot password?']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[contains(text(),'receive confirmation?')]")
	WebElement didntReceiveConfirmationLink;
	
	public void loginBtt(String user,String pass){
		username.sendKeys(user);
		password.sendKeys(pass);
		signInButton.click();
	}
	
	public String getSuccessLoginTitle(){
		return driver.getTitle();
	}
	
	public void clickOnForgotPasswordLink(){
		forgotPasswordLink.click();
	}
	
	public void clickOnDidntReceiveConfirmationLink(){
		didntReceiveConfirmationLink.click();
	}
}
