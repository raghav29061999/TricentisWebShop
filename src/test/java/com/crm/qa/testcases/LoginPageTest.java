package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;

public class LoginPageTest extends TestBase {
	
	
	LoginPage ltc;
	HomePage homePage;
	
	public LoginPageTest() {
        super();  //it will call TestBase class constructor
    }
	
	
	@BeforeMethod
	public void setup() {
		initialization();  // --> this method is directly being accessed from Base class as we have used super
		ltc = new LoginPage();
		
	}
	
	
	@Test(priority = 1)
    public void loginPageTitleTest(){
        
		String title =  ltc.validateLoginPageTitle();
        Assert.assertEquals(title, "Demo Web Shop. Login");
    }
		
	@Test(priority = 2)
	public void buttonPresentTest() {
		boolean register_button = ltc.validateNewUserRegistration();
		boolean forgotpass_button = ltc.validateForgetPassword();
		Assert.assertTrue(forgotpass_button);
		Assert.assertTrue(register_button);
	}
		
	
	@Test(priority = 3)
	public void loginTest() {		
		 homePage  =ltc.login(prop.getProperty("username"), prop.getProperty("password"));		 		 	
	}
	
	
	
	
	@AfterMethod
    public void teardown(){
        driver.quit();
    }
	
}
