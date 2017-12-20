package com.testcases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Pages.ProjectPage;
import com.factory.DataProviderFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.GenericHelper;
import com.utility.StartWebDriver;


public class VerifyProjectPageTest extends StartWebDriver {
	
	
	
	@Test(priority=1,groups="Regression")
	public void createProjectTest(){
		/*report=new ExtentReports("./Reports/ProjectPageReport.html",true);
		logger=report.startTest("Verify Test Project Page");*/
		HomePage home= PageFactory.initElements(driver, HomePage.class);	
		String title=home.getApplicationTitle();
		Assert.assertTrue(title.contains("Homepage"));
		home.clickOnSignInLink();
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.loginBtt(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData("Login", 0, 1));
		System.out.println(driver.getTitle());
		GenericHelper.sleep(2000);
		Assert.assertTrue(login.getSuccessLoginTitle().contains("Insights"));
		ProjectPage project=PageFactory.initElements(driver, ProjectPage.class);
		project.clickOnProjectNavBar();
		Assert.assertTrue(driver.getTitle().contains("ADMIN"));
		project.clickOnAllTab();
		project.clickOnPublishedTab();
		project.clickOnDraftTab();
		project.clickOnArchivedTab();
		project.clickOnAddNewProject();		
		project.enterName(DataProviderFactory.getExcel().getData(0, 1, 2));
		Actions act=new Actions(driver);
		act.moveToElement(project.getDescriptionElement());
		act.click();		
		act.sendKeys(DataProviderFactory.getExcel().getData(0, 1, 3));
		act.build().perform();
		project.clickTruncate();
		project.clickAddButton();
		Assert.assertTrue(driver.getTitle().contains("ADMIN | Manage"));
	}
	
	@Test(priority=2,groups="smoke")
	public void testNewProjectPage(){
		/*report=new ExtentReports("./Reports/ProjectPageReport.html",true);
		logger=report.startTest("Verify Project Page");*/
		HomePage home= PageFactory.initElements(driver, HomePage.class);
		home.clickOnSignInLink();
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.clickOnForgotPasswordLink();
		Assert.assertTrue(driver.getTitle().contains("Forgot your password"));
		/*logger.log(LogStatus.PASS, "Reset PasswordPage Loaded");*/
		
	}
	
	
}
