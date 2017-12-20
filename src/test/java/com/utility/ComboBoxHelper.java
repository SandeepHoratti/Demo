package com.utility;

import org.openqa.selenium.support.ui.Select;

public class ComboBoxHelper extends StartWebDriver {
	
	private static Select sel = null;
	
	public static void select(String locator,int index) {
		sel = new Select(getElement(locator));
		sel.selectByIndex(index);
	}
	
	public static void select(String locator,String value) {
		sel = new Select(getElement(locator));
		sel.selectByValue(value);
	}
	
	public static void selectByVisibleText(String locator,String text) {
		sel = new Select(getElement(locator));
		sel.selectByVisibleText(text);
	}

}
