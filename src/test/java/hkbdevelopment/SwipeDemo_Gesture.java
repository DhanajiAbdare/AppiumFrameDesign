package hkbdevelopment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;

import hkbdevelopment.appium.AndroidActions;
import hkbdevelopment.appium.BaseTest_API;
import hkbdevelopment.appium.BaseTest_General;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class SwipeDemo_Gesture extends BaseTest_API 
{
	AndroidActions act = new AndroidActions(driver);
	@Test
	public void SwipeDemoGesture() throws Exception
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		
		WebElement firstImg = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
//		Assert.assertEquals(null, null),
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
		
		Thread.sleep(2000);
		act.swipeAction(firstImg,"left");

		//after swipe the value of first attribute should be false
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
		Thread.sleep(2000);
	}
}
