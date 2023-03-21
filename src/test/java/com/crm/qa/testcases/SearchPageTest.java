package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SearchPage;
import com.crm.qa.util.Testutil;

public class SearchPageTest extends TestBase {

	
	SearchPage sp;
	
	public SearchPageTest()	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		sp = new SearchPage();
	}
	
	
	@Test(priority = 1)
	public void searchPageTitle() {
		
		
		Assert.assertEquals(sp.BasicSearch(Testutil.searchOption_2), "Demo Web Shop. Search");
	}
	
	@Test(priority = 2)
	public void searchResultVerification_1() {
		
		Object[] list_1 = sp.VerifyingSearchResult(Testutil.searchOption_1);
//		for(int i = 0 ; i<list_1.length; i++) 
//			System.out.println(list_1[i]);
		
		Assert.assertEquals(list_1, Testutil.searchoption_1list);
	}
	
	
	@Test(priority = 3)
	public void searchResultVerification_2() {
		
		Object[] list_1 = sp.VerifyingSearchResult(Testutil.searchOption_2);
		
		Assert.assertEquals(list_1, Testutil.searchoption_2list);
		
	}
	
	
	@Test(priority = 4)
	public void validateView() {
		Assert.assertTrue(sp.VerifyView(Testutil.searchOption_2));		
	}
	
	
	
	
	
	
	@AfterMethod
    public void teardown(){
        driver.quit();
    }
}
