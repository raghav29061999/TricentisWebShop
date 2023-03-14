package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class LoginPage extends TestBase {
	
	
	@FindBy(className ="ico-login")
    WebElement loginPageNavigation;
	
	@FindBy(id = "Email")
	WebElement username;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value = 'Register']")
	WebElement register;
	
	@FindBy(xpath = "//input[@value = 'Log in']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[@href = '/passwordrecovery']")
	WebElement forgotPass;
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);   
		// all the above mentioned variables will be initialized with this driver
		loginPageNavigation.click();
	 	driver.manage().timeouts().pageLoadTimeout(Testutil.INTERNAL_PAGE_LOAD, TimeUnit.SECONDS);
	 	driver.manage().timeouts().implicitlyWait(Testutil.INTERNAL_IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}
	
	 public String validateLoginPageTitle(){
		 	
	        return driver.getTitle();
	        
	    }
	 
	 public boolean validateNewUserRegistration(){
	        return register.isDisplayed();
	    }
	 
	 public boolean validateForgetPassword(){
	        return forgotPass.isDisplayed();
	    }
	
	
	 public HomePage login(String un, String pwd) {
		 username.sendKeys(un);
		 password.sendKeys(pwd);
		 loginButton.click();
		 
		 return new HomePage();
		
	}
	
	
	
		
	

	
	
}
