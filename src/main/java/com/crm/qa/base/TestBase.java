package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;

import com.crm.qa.util.Functions;
import com.crm.qa.util.Testutil;
import org.openqa.selenium.Platform;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	 public static WebDriver driver;	    
	 public static Properties prop; 
	 
	 public  Functions func = new Functions();
	 
	 
	 public TestBase() {

	        try {
	            prop = new Properties();
	            FileInputStream ip = new FileInputStream("C:\\Users\\singh\\eclipse-workspace\\DemoWebShop\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	            prop.load(ip);

	        }
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }


	    }
	 
	
	 
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("Chrome")) {
			
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			//chromeOptions.addArguments("--disable notifications");
			DesiredCapabilities cp = new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			chromeOptions.merge(cp);
			driver = new ChromeDriver(chromeOptions);
			
		
			
			
		}
		
		else if(browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        
        driver.get(prop.getProperty("url"));
        
        
		
	}
	 
	
}
