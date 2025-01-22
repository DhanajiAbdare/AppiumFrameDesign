package hkbdevelopment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import hkbdevelopment.appium.BaseTest_General;
import hkbdevelopment.appium.BaseTest_HKB;
import io.appium.java_client.AppiumBy;

public class HKB_Login_Test extends BaseTest_HKB {

	@Test
	public void Login_PositiveTest()
	{
		WebElement username = driver.findElement(AppiumBy.accessibilityId("Enter Username"));
		username.sendKeys("Dhananjay");
		WebElement password = driver.findElement(By.id("com.hkbdevelopement.togelapp:id/text_password"));
		password.sendKeys("abdare123");
		
		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/btn_signin")).click();	//sign_in
	}
	
//	@Test(dependsOnMethods="Login_PositiveTest")
//	public void Login_NegativeTest()
//	{
////		WebElement username = driver.findElement(AppiumBy.accessibilityId("Enter Username"));
////		username.sendKeys("Dhananjay");
////		WebElement password = driver.findElement(By.id("com.hkbdevelopement.togelapp:id/text_password"));
////		password.sendKeys("abdare123");	
////		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/btn_signin")).click();	//sign_in
//		
//		driver.findElement(AppiumBy.className("android.widget.TextView")).click();		//forgot password
//	}
}
