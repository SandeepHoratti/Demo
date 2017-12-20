package com.testcases;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Pages.NavBarPage;
import com.factory.DataProviderFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.StartWebDriver;

public class VerifyNavBarTest extends StartWebDriver{

	@Test(priority=1,groups="Regression")
	public void createProjectTest(){
		
		/*report=new ExtentReports("./Reports/NavBar.html",true);					
		logger=report.startTest("Verify NavBar");									
		HomePage home= PageFactory.initElements(driver, HomePage.class);		*/	
		
		HomePage home = new HomePage(driver);
		
		String title=home.getApplicationTitle();
		
		
		Assert.assertTrue(title.contains("Homepage"));
//	LoginPage asdf = home.clickOnSignInLink1();
//		asdf.loginBtt(user, pass);
		
		
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.loginBtt(DataProviderFactory.getExcel().getData("Login", 0, 0), DataProviderFactory.getExcel().getData("Login", 0, 1));
		System.out.println(driver.getTitle());		
	
		
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(10, TimeUnit.SECONDS);
		wait.pollingEvery(5, TimeUnit.MILLISECONDS);
		wait.ignoring(WebDriverException.class);

		Function<WebDriver, WebElement> fun = new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver arg0) {

				return arg0.findElement(By.name("commit"));
			}
		};
		
		
		
		wait.until(fun);		
		Assert.assertTrue(login.getSuccessLoginTitle().contains("Insights"));
		NavBarPage nav=PageFactory.initElements(driver, NavBarPage.class);
		nav.clickDashboard();
		Assert.assertTrue(driver.getTitle().contains("Insights | Dashboard"));
		//logger.log(LogStatus.PASS, "Dashboard Page Loaded");
		nav.clickProject();
		Assert.assertTrue(driver.getTitle().contains("ADMIN | Projects"));
		//logger.log(LogStatus.PASS, "Project Page Loaded");
		nav.clickPages();
		Assert.assertTrue(driver.getTitle().contains("ADMIN | Pages"));
		//logger.log(LogStatus.PASS, "Pages Page Loaded");
		nav.clickPeople();
		nav.clickPeopleStartButton();
		nav.clickPeopleNextButton();
		nav.clickPeopleNextButton();
		nav.clickPeopleCloseButton();
		Assert.assertTrue(driver.getTitle().contains("ADMIN | Administrators"));
		//logger.log(LogStatus.PASS, "People Page Loaded");
		
}

	
	
	
}	