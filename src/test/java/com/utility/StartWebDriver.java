package com.utility;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



/**
 * Class to initialize browser and do initial configuration
 * @author Sandeep
 * @version 1.0
 * @since December 2017
 */
@Listeners( com.listener.CustomeWebDriverListener.class)
public class StartWebDriver  {
	
	protected static WebDriver driver = null;
	protected static ReadConfigProperty file = null;
	/*protected static ExtentReports report;
	protected static ExtentTest logger;*/
	@BeforeMethod
	public void setUp(){
		try {
			
			 file = new ReadConfigProperty();
			if("firefox".equalsIgnoreCase(file.getBrowser())){				
				System.setProperty("webdriver.gecko.driver", file.prop.getProperty("FirefoxPath"));
				driver = new FirefoxDriver();
			}else if("chrome".equalsIgnoreCase(file.getBrowser())){				
				System.setProperty("webdriver.chrome.driver", file.prop.getProperty("ChromeDriverPath"));
				driver = new ChromeDriver();
			}else if("explorer".equalsIgnoreCase(file.getBrowser())){
				String explorerPath = StartWebDriver.class.getClassLoader().getResource("resource/").getPath();
				explorerPath = explorerPath.replaceAll("bin", "src");
				System.setProperty("webdriver.ie.driver", explorerPath + "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().pageLoadTimeout(file.getPageWait(), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(file.getElementWait(), TimeUnit.SECONDS);
			driver.get(file.getUrl());
			WindowHelper.windowMaximize();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected static WebElement getElement(String locator) {
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() == 1){
			return driver.findElement(By.id(locator));
		}else if(driver.findElements(By.name(locator)).size() == 1 ){
			return driver.findElement(By.name(locator));
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() == 1){
			return driver.findElement(By.cssSelector(locator));
		}else if(driver.findElements(By.xpath(locator)).size() == 1){
			return driver.findElement(By.xpath(locator));
		}else
			throw new NoSuchElementException("No Such Element : " + locator);
		
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE){
			GenericHelper.takeScreenShot(result.getName());
		}
		try {
			if(driver != null){
				driver.close();
				driver.quit();
				driver = null;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}