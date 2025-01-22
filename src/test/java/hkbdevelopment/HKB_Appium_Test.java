package hkbdevelopment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import hkbdevelopment.appium.BaseTest_General;
import hkbdevelopment.appium.BaseTest_HKB;
import io.appium.java_client.AppiumBy;

public class HKB_Appium_Test extends BaseTest_HKB {

	@Test
	public void Appium_Test() throws Exception
	{
		driver.findElement(AppiumBy.accessibilityId("Enter Username")).sendKeys("Dhananjay");			
		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/text_password")).sendKeys("abdare123");			
		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/btn_signin")).click();	//sign_in
		
		Thread.sleep(2000);
//		driver.findElement(By.className("android.widget.AutoCompleteTextView")).click();
		driver.findElement(AppiumBy.accessibilityId("Show dropdown menu")).click();
		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/layout_country")).click();
		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/btn_buy")).click();
//		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/btn_bet_number")).click();
		driver.findElement(By.id("android:id/button2")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
		Thread.sleep(5000);
		//daily transaction report
		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/btn_bet_number")).click();
//		driver.findElement(By.xpath("//android.widget.Button[contains(text(),'Number (2D/3D/4D)')]")).click(); //----element not clickable
		String txt=driver.findElement(By.id("com.hkbdevelopement.togelapp:id/text_slideshow")).getText();
		System.out.println("Daily transaction report :"+txt);
					
		driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
		Thread.sleep(5000);
//		driver.findElement(By.id("com.hkbdevButtonelopement.togelapp:id/btn_bet_even_odd")).click(); //-----------element not clickable
		driver.findElement(By.xpath("//android.widget.Button[@text()='Even/Odd']")).click();
//		driver.findElement(By.xpath("//android.widget.Button[contains(text(),'Even')]")).click();
//		driver.findElement(By.xpath("//android.widget.Button[@id='com.hkbdevelopement.togelapp:id/btn_bet_even_odd' or text()='Even/Odd']")).click();
//		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.hkbdevelopement.togelapp:id/btn_bet_even_odd']")).click();
		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/text_old_password")).sendKeys("987654321");
		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/text_password")).sendKeys("1234567");
		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/text_confirm_passw`ord")).sendKeys("1234567");
		driver.findElement(By.id("com.hkbdevelopement.togelapp:id/btn_change_password")).click();		
		Thread.sleep(5000);
	}
	
}
