package com.utility;

import org.testng.annotations.Test;

public class LoginPageComponentsTest extends StartWebDriver {

	LoginBttPage loginpage= new LoginBttPage(driver);

	
	
	// To login with valid username and password
	@Test
	public  void bttLogin(){
		
		loginpage.loginBtt();
		
	}	
	
}	
		

