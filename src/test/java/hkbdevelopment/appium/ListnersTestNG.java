package hkbdevelopment.appium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ListnersTestNG implements ITestListener
//public class ListnersTestNG extends AndroidActions implements ITestListener  
{
//	public ListnersTestNG(AndroidDriver driver) 
//	{
//		super(driver);
//	}

	AppiumDriver driver;
	ExtentTest test;
	ExtentReports extent = ExtentReportDemo1.getReporterObject();
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		System.out.println("Test case started successfully");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case Passed successfully");		//after result is pass then control falls in this method
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//capture screenshot 
		test.fail(result.getThrowable());			//forcefully fail the test & displayed
		System.out.println("Test case Failed");
		
//		try {
//			driver = (AppiumDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		}catch(Exception e1) {
//			e1.printStackTrace();
//		}
		
//		try {
//			test.addScreenCaptureFromPath(getScreenshot_path(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed But Within Success Percentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test Failed With Timeout");
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();								//this method is compulsory to generate report
	}

}
