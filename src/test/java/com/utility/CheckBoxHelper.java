package com.utility;

import org.openqa.selenium.WebElement;

public class CheckBoxHelper extends StartWebDriver {
	
	public static void clickCheckBox(String locator) {
		WebElement ele = getElement(locator);
		ele.click();
	}
	
	public static boolean isChecked(String locator) {
		WebElement ele = getElement(locator);
		return ele.isSelected();
		
	}

}
