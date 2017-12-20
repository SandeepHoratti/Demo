package com.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	
	public ConfigDataProvider(){
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationUrl(){
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getFirefoxPath(){
		String firefoxPath=pro.getProperty("firefoxPath");
		return firefoxPath;
	}
	
	public String getChromePath(){
		String chromePath=pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getIEPath(){
		String IEPath=pro.getProperty("IEPath");
		return IEPath;
	}
	
	public String getUserName(){
		String userName=pro.getProperty("username");
		return userName;
	}
	
	public String getPassword(){
		String password=pro.getProperty("password");
		return password;
	}
}
