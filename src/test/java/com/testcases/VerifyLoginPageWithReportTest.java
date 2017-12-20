package com.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.factory.DataProviderFactory;

import com.utility.StartWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


public class VerifyLoginPageWithReportTest extends StartWebDriver {
	
	@Test
	public void testLoginPage(){
		report=new ExtentReports("./Reports/LoginPagesReport.html",true);
		logger=report.startTest("Verify Test Login");
		HomePage home= PageFactory.initElements(driver, HomePage.class);		
		String title=home.getApplicationTitle();
		Assert.assertTrue(title.contains("Homepage"));
		logger.log(LogStatus.INFO, "Homepage loaded and verified");
		home.clickOnSignInLink();
		logger.log(LogStatus.INFO, "Click on Sign In link");
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.loginBtt(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData("Login", 0, 1));
		logger.log(LogStatus.PASS, "Login to application");
		
		
	}
	
}
