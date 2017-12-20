package com.testcases;



import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Pages.HomePage;
import com.utility.StartWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


public class VerifyHomePageTest extends StartWebDriver {
		
	@Test(priority=1)
	public void testHomePage(){
		report=new ExtentReports("./Reports/HomePageReport.html",true);
		logger=report.startTest("Verify HomePage");
		HomePage home= PageFactory.initElements(driver, HomePage.class);		
		String title=home.getApplicationTitle();
		Assert.assertTrue(title.contains("Homepage"));
		logger.log(LogStatus.INFO, "Homepage loaded and verified");
		
	}
	
	@Test(priority=2)
	public void testSignInLink() throws Exception {
		HomePage home= PageFactory.initElements(driver, HomePage.class);
		home.clickOnSignInLink();
		Assert.assertTrue(driver.getTitle().contains("Sign in"));
		logger.log(LogStatus.PASS, "Sign in Page Loaded");
	}
	
	@Test(priority=3)
	public void testRegisterLink() throws Exception {
		HomePage home= PageFactory.initElements(driver, HomePage.class);
		home.clickOnRegisterLink();
		Assert.assertTrue(driver.getTitle().contains("Register"));
		logger.log(LogStatus.PASS, "Register Page Loaded");
	}
	


}