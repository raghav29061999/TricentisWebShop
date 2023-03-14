package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;
import com.github.dockerjava.api.model.Driver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage  homePage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
		
	}
	
	@Test(priority = 4)
    public void loginPageTitleTest(){
        
		String title =  homePage.validateHomePageTitle();
        Assert.assertEquals(title, "Demo Web Shop");
    }
	
	
	
	@Test(priority =2 )
	public void listedItems() {
		
		
		Assert.assertEquals(homePage.productInCart(),1);
		Assert.assertEquals(homePage.productInWishList(),0);
	}
	
	
	
	@Test(priority = 3)
	public void searchingItem()  {
		
		
	 	Assert.assertEquals(homePage.searchOption(Testutil.searchOption_1), "Demo Web Shop. Search");
		
	}
	
	@Test(priority = 5)
	public void shoppingOptions() {
		
		Object[] list = homePage.shoppingCatogries();
//		for(int i = 0 ; i<list.length; i++)
//			System.out.println(list[i]);
		Assert.assertEquals(list, Testutil.ShoppingCatogryList);
		
	}
	
	@Test(priority = 1)
	public void computerPurchase() {
		//Object[] list = homePage.computerOptions();
//		System.out.println(list.length);
//		for(int i = 0 ; i<list.length; i++)
//			System.out.println(list[i]);
		System.out.println(homePage.computerOptions());
		Assert.assertEquals(homePage.computerOptions(), "Notebooks ");
		

	}
		
	
	
	
	@AfterMethod
    public void teardown(){
        driver.quit();
    }
	
}
