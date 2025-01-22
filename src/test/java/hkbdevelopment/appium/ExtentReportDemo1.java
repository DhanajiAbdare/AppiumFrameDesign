package hkbdevelopment.appium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo1 extends BaseTest_General
	{
		static ExtentReports extent;
		@BeforeMethod
		public static ExtentReports getReporterObject()
		{
			//ExtentReports, ExtentSparkReporter -->2 classes are used
			String path = System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path) ; //this class is responsible to create .html file & do some configurations ie. helper class
			reporter.config().setReportName("Web Automation Test_Results");
			reporter.config().setDocumentTitle("Test Results");
			
			extent = new ExtentReports() ;	//this is the main class that drive our test automation
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Dhananjay Abdare");
			return extent;	
			
		}
//		@Test
//		public void initialDemo() throws Exception
//		{
//			ExtentTest test = extent.createTest("initialDemo");	//object is monitoring the reports
//			System.setProperty("webdriver.chrome.driver", "Downloads\\chromedriver.exe");
//			WebDriver driver = new ChromeDriver();
//			driver.get("https://www.google.com/");
//		}
	}


