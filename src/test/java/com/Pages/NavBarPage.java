package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.GenericHelper;

public class NavBarPage {
WebDriver driver;

public NavBarPage(WebDriver driver){
	this.driver=driver;
}

@FindBy(xpath="//a[normalize-space(text())='Dashboard']")
WebElement dashboardNav;

@FindBy(xpath="//a[normalize-space(text())='Projects']")
WebElement projectNav;

@FindBy(xpath="//a[normalize-space(text())='hubs']")
WebElement hubsNav;

@FindBy(xpath="//a[normalize-space(text())='Pages']")
WebElement pagesNav;

@FindBy(xpath="//a[normalize-space(text())='People']")
WebElement peopleNav;

@FindBy(xpath="//a[normalize-space(text())='Analytics']")
WebElement analyticsNav;

@FindBy(xpath="//a[normalize-space(text())='Email']")
WebElement emailNav;

@FindBy(xpath="//a[normalize-space(text())='Site']")
WebElement siteNav;

@FindBy(xpath="//i[@class='fa fa-list']")
WebElement activityNav;

@FindBy(xpath="//span[text()='Start']")
WebElement peopleStart;

@FindBy(xpath="//span[text()='Next']")
WebElement peopleNext;

@FindBy(xpath="//div[text()='×']")
WebElement peopleClose;

@FindBy(xpath="//a[normalize-space(text())='EngagementHQ']")
WebElement ehqLogoNav;

public void clickDashboard(){
	GenericHelper.click(dashboardNav);
}

public void clickProject(){
	GenericHelper.click(projectNav);
}

public void clickHubs(){
	GenericHelper.click(hubsNav);
}

public void clickPages(){
	GenericHelper.click(pagesNav);
}

public void clickPeople(){
	GenericHelper.click(peopleNav);
}

public void clickAnalytics(){
	GenericHelper.click(analyticsNav);
}

public void clickEmail(){
	GenericHelper.click(emailNav);
}

public void clickSite(){
	GenericHelper.click(siteNav);
}

public void clickActivity(){
	GenericHelper.click(activityNav);
}

public void clickPeopleStartButton(){
	GenericHelper.click(peopleStart);
}

public void clickPeopleNextButton(){
	GenericHelper.click(peopleNext);
}

public void clickPeopleCloseButton(){
	GenericHelper.click(peopleClose);
}

public void clickEhqLogo(){
	GenericHelper.click(ehqLogoNav);
}

}
