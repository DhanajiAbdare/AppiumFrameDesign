package hkbdevelopment.appium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

//This class is not used in our framework just use required methods of this class in another class
public class AndroidActions {

		public static AndroidDriver driver;
		public AndroidActions(AndroidDriver driver)		//constructor
		{
			this.driver = driver;
		}
		public double getFormattedAmount(String amount)
		{
			double price = Double.parseDouble(amount.substring(1));		//index '0' represent $ sign & count from index '1'
			return price;
		}
		public void longClickGesture(WebElement ele)
		{
			((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
					ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
		}
		public void scrollToEndAction()
		{
			boolean canScrollMore;
			do
			{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
			}while(canScrollMore);
		}
		public void scrollToText(String text)
		{
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		}
		public void swipeAction(WebElement ele, String direction)
		{
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
					"elementId",((RemoteWebElement)ele).getId(),
				    "direction", direction,
				    "percent", 0.75
			));
		}
//	public void swipeAction()
//	{
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//			    "left", 100, "top", 100, "width", 200, "height", 200,
//			    "direction", "left",
//			    "percent", 0.75
//			));
	
//	public String getScreenshot_path(String testCaseName, AppiumDriver driver) throws IOException
//	{
////	1.screenshot capture & place in folder	2.extent report pick file & attach to report	
//		File source = driver.getScreenshotAs(OutputType.FILE);	//virtually copy the screenshot
//		String destinationFile = System.getProperty("user.dir")+"\\reports" +testCaseName+ ".png";
//		FileUtils.copyFile(source, new File(destinationFile));
//		return destinationFile;			
//	}
}
