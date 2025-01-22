package hkbdevelopment.appium;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest_General {

	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	
	@BeforeClass 				//execute once before all @Test annotations
	public void configAppium() throws Exception
	{
		//Start appium server
		//Thread.sleep(2000);
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\hkb-d\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();			
			
		//Setting up all uiautomator options & invoking app
		UiAutomator2Options options = new UiAutomator2Options();	//class itself is an uiautomator2
		options.setDeviceName("Swara");
//		below statement is required if app is hybrid & not required if it is native(for only hybrid app)
		options.setChromedriverExecutable("C:\\Users\\hkb-d\\eclipse-workspace\\Appium\\Drivers\\chromedriver.exe"); 
		
		options.setApp("C:\\Users\\hkb-d\\eclipse-workspace\\AppiumFrameworkDesign1\\src\\test\\java\\Resource\\General-Store.apk");
//		options.setApp("C:\\Users\\hkb-d\\eclipse-workspace\\AppiumFrameworkDesign1\\src\\test\\java\\Resource\\app-debug.apk");
//		options.setApp("C:\\Users\\hkb-d\\eclipse-workspace\\AppiumFrameworkDesign1\\src\\test\\java\\Resource\\ApiDemos-debug.apk");
			
		//Creating or initialize drivers & setting up waits
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}
	
	@AfterClass 				//execute once after all @Test annotations
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
}
