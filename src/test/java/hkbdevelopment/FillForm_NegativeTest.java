package hkbdevelopment;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import hkbdevelopment.appium.BaseTest_General;
import io.appium.java_client.AppiumBy;


public class FillForm_NegativeTest extends BaseTest_General {

	@Test
	public void fillFormTest_negativeFlow() throws Exception
	{
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dhananjay");
//		driver.hideKeyboard();

		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();	
		
		//click on dropdown,scroll the dropdown options,click on perticular text
		driver.findElement(By.id("android:id/text1")).click();	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//capture toast messages in appium
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMsg, "Please enter your name");
		System.out.println("Toast message displayed is :"+toastMsg);
		Thread.sleep(5000);
	}
}
