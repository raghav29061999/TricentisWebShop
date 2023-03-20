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
	public void searchResultVerification() {
		
		Object[] list = sp.VerifyingSearchResult(Testutil.searchOption_1);
		for(int i = 0 ; i<list.length; i++)
			System.out.println(list[i]);
	}
	
}
