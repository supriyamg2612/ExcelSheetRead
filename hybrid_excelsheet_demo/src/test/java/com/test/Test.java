package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.base.BaseClass;
import com.listeners.MyListeners;
import com.pages.LoginPage;
import com.utility.DriverUtils;
@Listeners(MyListeners.class)
public class Test extends BaseClass {
	
	LoginPage lp = null;
	
	
	@BeforeSuite
	public void configuration() throws Exception {
		setUp();
		reportIn();
		 lp = new LoginPage(driver);
	}
	
	@AfterSuite
    public void tearDown() {
		driver.quit();
	}
	
	 @org.testng.annotations.Test
	public void loginTest() throws Exception, Exception {
		
		int rowCount = DriverUtils.getRowCount();
		for (int i = 1; i <= rowCount; i++) {
            // Get username and password from Excel
            String username = DriverUtils.getCellData(i, 0);  // 0 = first column (username)
            String password = DriverUtils.getCellData(i, 1); 
            
            System.out.println("Logging in with Username: " + username + " | Password: " + password);
            lp.loginToApplication(username, password);

            // Wait for the login process to complete
            Thread.sleep(2000);  // Adjust sleep time as per the application's speed

            // Check if the login was successful
            boolean loginSuccess = lp.isLoginSuccessful();

            // Assert the login success/failure based on the outcome
            if (loginSuccess) {
                System.out.println("Login successful for credentials: " + username + " | " + password);
                Assert.assertTrue(loginSuccess, "Login should be successful for valid credentials.");
            } else {
                System.out.println("Login failed for credentials: " + username + " | " + password);
                Assert.assertFalse(loginSuccess, "Login should fail for invalid credentials.");
            }

            // Navigate back to the login page for the next login attempt
            lp.goToLoginPage();
        }
    }
}