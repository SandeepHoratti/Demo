package com.listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.utility.GenericHelper;

public class CustomeWebDriverListener implements ITestListener{

	ITestResult iTestResult;
	protected static ExtentReports report;
	protected static ExtentTest logger;
	public void onFinish(ITestContext arg0) {
		report.endTest(logger);
		report.flush();
		
	}

	public void onStart(ITestContext Result) {
		report=new ExtentReports("./Reports/Result.getName().html",true);
		logger=report.startTest("Verify NavBar");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult Result) {
		GenericHelper.takeScreenShot(Result.getName());    // implement logging
		
	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase Skipped is :"+Result.getName());
		
	}

	public void onTestStart(ITestResult Result) {
		System.out.println(Result.getName()+" test case started");
		logger=report.startTest(Result.getName());
		
	}

	public void onTestSuccess(ITestResult Result) {
		 System.out.println("The name of the testcase passed is :"+Result.getName());
		
	}

	public void onException(Throwable error, WebDriver driver) {
		//String testName = iTestResult.getName();
		
		System.out.println("Error occurred: " + error);
	}	
}
