package base;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListeners extends BaseTest  implements ITestListener {
	
	ExtentReports extent = ExtentReporter.getReporterObject();
    ExtentTest test;

	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "Test Started");
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.INFO, "Test has Passed");
		
		
		try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName() + getDateTime() , driver),
					result.getMethod().getMethodName());
					
		} catch (IOException ioe) {
			ioe.printStackTrace();
			
		}
		
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		
		test.log(Status.INFO, "Test has Failed");
		try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName() + getDateTime() , driver),
					result.getMethod().getMethodName());
					
		} catch (IOException ioe) {
			ioe.printStackTrace();
			
		}
		
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.INFO, "Test has Skipped");
		
	}
	public void onTestFailedButWithinSucessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
		test.log(Status.INFO, "Test has finished");
		extent.flush();
		
	}
	
	
	
	
	
	
	
 
}
