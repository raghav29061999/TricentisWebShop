package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegisterPage;

public class UserRegister extends TestBase {
	
	RegisterPage rp;
	
	public UserRegister() {
		super();// TODO Auto-generated constructor stub
	}
		
	@BeforeMethod
	public void setup() {
		initialization();  // --> this method is directly being accessed from Base class as we have used super
		rp = new RegisterPage();
		
	}
	
	@Test(priority = 1)
	public void registerPageTitleTest(){
        
		String title =  rp.validateRegisterPageTitle();
        Assert.assertEquals(title, "Demo Web Shop. Register");
    }
	
	@Test(priority = 2)
	public void createNewAccount() {
		
		String confirmationMessage = rp.creatingNewUserAccount();
		Assert.assertEquals(confirmationMessage, "Your registration completed");
		//System.out.println(confirmationMessage);
		
	}
	
	
	@Test(priority = 3)
	public void existingAccount() {
		String accountExistMessage = rp.verifyingExistingAccount(prop.getProperty("username"));
		Assert.assertEquals(accountExistMessage, "The specified email already exists");
	}
	
	
	
	@Test(priority = 4)
	public void passwordNotMatching() {
		
		String PasswordException = rp.passwordNotMatchError();
		
		Assert.assertEquals(PasswordException, "The password and confirmation password do not match.");
	}
	
	
	
	@AfterMethod
    public void teardown(){
        driver.quit();
    }
	
	}


