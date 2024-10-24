package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver  driver = null;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy (name = "user-name")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	
	
	public void loginToApplication(String uname, String pass) {
		username.clear();
		password.clear();
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	 public boolean isLoginSuccessful() {
	        // Check if the current URL contains "dashboard", indicating a successful login
	        return driver.getCurrentUrl().contains("inventory");
	    }

	    public void goToLoginPage() {
	        // Navigate back to the login page
	        driver.get("https://www.saucedemo.com/");
	        try {
	            // Adding a small wait to ensure the page loads before the next action
	            Thread.sleep(2000);  // Optional: You can use WebDriverWait here for a better approach
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}