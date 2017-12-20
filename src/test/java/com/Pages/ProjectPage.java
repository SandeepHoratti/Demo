package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.GenericHelper;

public class ProjectPage {
WebDriver driver;
	
	public ProjectPage(WebDriver driver){
	this.driver=driver;	
	}
	
	@FindBy(xpath="//a[normalize-space(text())='Projects']")
	WebElement projectNavBar;
	
	@FindBy(xpath="//a[text()='Add new project']")
	WebElement addNewProject;
	
	@FindBy(xpath="//span[text()='All']")
	WebElement filteryByAll;
	
	@FindBy(xpath="//span[text()='Published']/following-sibling::span")
	WebElement filteryByPublished;
	
	@FindBy(xpath="//span[text()='Draft']/following-sibling::span")
	WebElement filteryByDraft;
	
	@FindBy(xpath="//span[text()='Archived']/following-sibling::span")
	WebElement filteryByArchived;
	
	@FindBy(xpath="//label[text()='Name']/../input")
	WebElement name;
	
	@FindBy(xpath="//label[text()='Description']/..//div[2]/span[text()='Type something']")
	WebElement description;
	
	@FindBy(xpath="//label[text()='Truncate Description']/../input[2]")
	WebElement truncateDescription;	
	
	@FindBy(xpath="//input[@value='Add']")
	WebElement addbutton;
	
	public WebElement getDescriptionElement(){
		return description;
	}
	
	public void clickAddButton(){
		GenericHelper.click(addbutton);
	}
	
	public void clickTruncate(){
		GenericHelper.click(truncateDescription);
	}
	
	public void enterName(String nameofproject){
		GenericHelper.sendKeys(name,nameofproject);
	}
	
	public void enterDescription(String descriptionofproject){
		GenericHelper.sendKeys(description,descriptionofproject);
	}
	
	public void clickDescription(){
		GenericHelper.click(description);
	}
	
	public void clickOnAddNewProject(){
		//addNewProject.click();
		GenericHelper.click(addNewProject);
	}
	
	public void clickOnProjectNavBar(){
		projectNavBar.click();
	}
	
	public void clickOnAllTab(){
		filteryByAll.click();
	}
	
	public void clickOnPublishedTab(){
		filteryByPublished.click();
	}
	
	public void clickOnDraftTab(){
		filteryByPublished.click();
	}
	
	public void clickOnArchivedTab(){
		filteryByArchived.click();
	}
}
