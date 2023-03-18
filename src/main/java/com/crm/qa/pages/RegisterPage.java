package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.util.*;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class RegisterPage extends TestBase {
	
	@FindBy(className ="ico-register")
    WebElement registerPageNavigation;  // click this button user is navigated to "Demo Web Shop. Register" page
	
	@FindBy(id = "register-button")
	WebElement register_button;
	
	@FindBy(id = "gender-male")
	WebElement personalDetails_GenderMale; //*[@id='gender-male']
	
	@FindBy(id = "gender-female")
	WebElement personalDetails_GenderFemale; //*[@id='gender-female']
	
	@FindBy(id = "FirstName")
	WebElement personalDetails_FirstName;
	
	@FindBy(id = "LastName")
	WebElement personalDetails_LastName;
	
	@FindBy(id = "Email")
	WebElement personalDetails_EmailId;
	
	@FindBy(id = "Password")
	WebElement personalDetails_Password;

	@FindBy(id = "ConfirmPassword")
	WebElement personalDetails_ConfirmPassword;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement personalDetails_ContinueAccount;
	
	@FindBy(xpath = "//li[text()='The specified email already exists']")
	WebElement ExistingAccountMessage;
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement AccountCreationMessage;
	
	@FindBy(xpath = "//span[@for='ConfirmPassword']")
	WebElement PasswordUnMatchMessage;
	
	
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);   
		// all the above mentioned variables will be initialized with this driver
		registerPageNavigation.click();
	 	driver.manage().timeouts().pageLoadTimeout(Testutil.INTERNAL_PAGE_LOAD, TimeUnit.SECONDS);
	 	driver.manage().timeouts().implicitlyWait(Testutil.INTERNAL_IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	
	public String validateRegisterPageTitle(){
	 	
        return driver.getTitle();
        
    }
	
	public String creatingNewUserAccount() {
		
		String x = func.randomPassword(10);
	
		
		if(func.randomNumber(1, 2)%2==0)
			personalDetails_GenderMale.click();
		else
			personalDetails_GenderFemale.click();
		
		personalDetails_FirstName.sendKeys(func.dateTime() + "1");
		personalDetails_LastName.sendKeys(func.dateTime() + "2");
		personalDetails_EmailId.sendKeys(func.dateTime() + "@gmail.com");
		personalDetails_Password.sendKeys(x);
		personalDetails_ConfirmPassword.sendKeys(x);
		register_button.click();
		String ConfirmationMessage = AccountCreationMessage.getText();
		personalDetails_ContinueAccount.click();
		return ConfirmationMessage;
		
		
	}
	
	public String verifyingExistingAccount(String un) {
		
		String x = func.randomPassword(10);
	
		
		if(func.randomNumber(1, 2)%2==0)
			personalDetails_GenderMale.click();
		else
			personalDetails_GenderFemale.click();
		
		personalDetails_FirstName.sendKeys(func.dateTime() + "1");
		personalDetails_LastName.sendKeys(func.dateTime() + "2");
		personalDetails_EmailId.sendKeys(un);
		
		personalDetails_Password.sendKeys(x);
		personalDetails_ConfirmPassword.sendKeys(x);
		register_button.click();
		
		return ExistingAccountMessage.getText();		
		
	}

	public String passwordNotMatchError() {
		
		if(func.randomNumber(1, 2)%2==0)
			personalDetails_GenderMale.click();
		else
			personalDetails_GenderFemale.click();
		
		personalDetails_FirstName.sendKeys(func.dateTime() + "1");
		personalDetails_LastName.sendKeys(func.dateTime() + "2");
		personalDetails_EmailId.sendKeys(func.dateTime() + "@gmail.com");
		personalDetails_Password.sendKeys(func.randomPassword(10));
		personalDetails_ConfirmPassword.sendKeys(func.randomPassword(10));
		register_button.click();
		String UnMatch = PasswordUnMatchMessage.getText();
		
		return UnMatch;
	}

}
