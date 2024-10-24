package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	public static ExtentReports  reports = null;
	public static ExtentSparkReporter sparks = null;
    public static	ExtentTest test = null;
    public static WebDriver driver = null;
    
    
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "/Users/ameyaathale/Documents/Selenium_Automation_Workspace/chromedriver-mac-x64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

    }
    
    public void reportIn() {
    	reports = new ExtentReports();
    	sparks = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/ExtentReport.html");
    	reports.attachReporter(sparks);
    }


}
