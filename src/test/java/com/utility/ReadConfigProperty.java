package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperty {

	
	protected InputStream input = null;
	protected Properties prop = null;
	
	public ReadConfigProperty() {
		try {
			/*String path = ReadConfigProperty.class.getClassLoader().getResource("Configuration/").getPath();
			//path = path.replaceAll("bin", "src");
			input = new FileInputStream(path + "config.properties");*/
			//input = ReadConfigProperty.class.getClassLoader().getResourceAsStream("resource/config.properties");
			input = new FileInputStream("./Configuration\\config.properties");
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public String getUrl() {
		if(prop.getProperty("url") == null)
			return "";
		return prop.getProperty("url");
	}
	
	public String getBrowser() {
		if(prop.getProperty("browser") == null)
			return "";
		return prop.getProperty("browser");
	}
	
	public String getUsername() {
		if(prop.getProperty("Username") == null)
			return "";
		return prop.getProperty("Username");
	}
	
	public String getPassword() {
		if(prop.getProperty("Password") == null)
			return "";
		return prop.getProperty("Password");
	}
	
	public int getElementWait() {
		if(prop.getProperty("ElementWait") == null)
			return 0;
		return Integer.parseInt(prop.getProperty("ElementWait"));
	}
	
	public int getPageWait() {
		if(prop.getProperty("PageLoadWait") == null)
			return 30;
		return Integer.parseInt(prop.getProperty("PageLoadWait"));
	}
	
	public String getDbName() {
		if(prop.getProperty("DbName") == null)
			return "";
		return prop.getProperty("DbName");
	}
	
	public String getDbUserName() {
		if(prop.getProperty("DbUserName") == null)
			return "";
		return prop.getProperty("DbUserName");
	}
	
	public String getDbPassword() {
		if(prop.getProperty("DbPassword") == null)
			return "";
		return prop.getProperty("DbPassword");
	}
	
	public String getHost() {
		if(prop.getProperty("DbHost") == null)
			return "";
		return prop.getProperty("DbHost");
	}
	
	public String getMethodName() {
		if(prop.getProperty("Mname") == null)
			return "";
		return prop.getProperty("Mname");
	}

}
