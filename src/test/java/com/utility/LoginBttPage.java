package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.factory.DataProviderFactory;


public class LoginBttPage extends GenericHelper {
	
	public LoginBttPage(WebDriver driver) {
		
		
	}

	@FindAll({
		@FindBy(xpath = "//a[text()='Sign In']"),
		@FindBy(xpath = "//a[text()='Log In']")		
	})
	private WebElement signInLink;
	
	@FindBy(xpath = "//input[@id='user_email_or_login']")
	private WebElement UserName_xpath1;
	
	@FindBy(xpath = "//input[@id='user_password']")
	private WebElement PassWord_xpath1;
	
	@FindBy(xpath = "//input[@name='commit']")
	private WebElement BtnSignIn_xpath1;
		
	public void loginBtt(){
		click(signInLink);
		
		sendKeys(UserName_xpath1, DataProviderFactory.getConfig().getUserName());
		sendKeys(PassWord_xpath1, DataProviderFactory.getConfig().getPassword());
		click(BtnSignIn_xpath1);
	}
	
}
	
