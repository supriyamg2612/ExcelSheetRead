package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class MyListeners extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		test= reports.createTest(result.getName());
		System.out.println("Test execution started for the test " +  result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test Case Passed");
		System.out.println("Test execution finished for the test " +  result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case Failed");
		System.out.println("Test execution finished for the test " + result.getName()
		+ " and test case failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Case Skipped");
		System.out.println("Test execution skipped for the test " + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test suite execution started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
		System.out.println("Test suite execution finished");
		
	}

}
