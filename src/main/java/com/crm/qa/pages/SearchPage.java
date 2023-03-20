package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class SearchPage extends TestBase{

	@FindBy(id = "small-searchterms")
	WebElement SearchBox;
	
	@FindBy(xpath = "//input[@value = 'Search']")
	WebElement SearchBtn;
	
	@FindBy(xpath = "//h2//a")
	List<WebElement> SearchResults;
	
	
	public SearchPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String BasicSearch(String searchText) {
		
		SearchBox.sendKeys(searchText);
		SearchBtn.click();
		driver.manage().timeouts().pageLoadTimeout(Testutil.INTERNAL_PAGE_LOAD, TimeUnit.SECONDS);
	 	driver.manage().timeouts().implicitlyWait(Testutil.INTERNAL_IMPLICIT_WAIT, TimeUnit.SECONDS);
	 	
		return driver.getTitle();
	}
	
	
	
	public Object[] VerifyingSearchResult(String searchText) {
		
		 BasicSearch(searchText);		 
		 Object[] list = func.pullingWebList(SearchResults);
		 return list;
				 		
	}
	
	
}
