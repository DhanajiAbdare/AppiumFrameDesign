package hkbdevelopment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hkbdevelopment.appium.BaseTest_General;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class FillForm_PositiveTest extends BaseTest_General {

	@Test
	public void fillFormTest_PositiveFlow() throws Exception
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dhananjay");
		
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();	
		
		//click on dropdown,scroll the dropdown options,click on perticular text
		driver.findElement(By.id("android:id/text1")).click();	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(5000);
	}
}
