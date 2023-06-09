package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v106.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class HomePage extends TestBase{

	@FindBy(xpath ="//div[@class = 'header-links-wrapper']//div[@class = 'header-links']//ul//li//a[@class = 'account']")
    WebElement LoggedInUser;
	
	@FindBy(className = "cart-qty")
	WebElement CartQuantity;
	
	@FindBy(className = "wishlist-qty")
	WebElement WishListQuantity;
	
	@FindBy(id = "small-searchterms")
	WebElement SearchBox;
	
	@FindBy(xpath = "//input[@value = 'Search']")
	WebElement SearchBtn;
	
	@FindBy(xpath = "//ul[@class='list']//li")
	List<WebElement> ShoppingOptions;
	
	@FindBy(xpath = "//div[@class = 'header-menu']//ul[@class='top-menu']//li//ul[@class = 'sublist firstLevel']//li//a[contains(text() , 'Desktops')]")
	WebElement SubListShoppingOptions_Computer;
	
	@FindBy(xpath = "//div[@class = 'header-menu']//ul[@class='top-menu']//li//a[@href='/electronics']")
	List<WebElement> SubListShoppingOptions_Electronics;
	
	SearchPage search = new SearchPage();
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String validateHomePageTitle() {
		
		return driver.getTitle();
		
	
	}
	
	
	public int productInCart(){
		
		return Integer.parseInt(CartQuantity.getText().substring(1, CartQuantity.getText().length()- 1));	
		
	}
	
	public int productInWishList(){
		
		return Integer.parseInt(WishListQuantity.getText().substring(1, WishListQuantity.getText().length()- 1));	
		
	}
	
	
	public String searchOption(String searchText) {
		

		 return search.BasicSearch(searchText); //<title>Demo Web Shop. Search</title>
		
	}
	
	
	public 	Object[] shoppingCatogries(){
		
		
		 Object[] list  = func.pullingWebList(ShoppingOptions);
		 	 
		 return  list;
	}
	
	
	public String computerOptions(){
		
//		List<WebElement> list_12 = SubListShoppingOptions_Computer;
//		ArrayList<String> list_21 = new ArrayList<String>();
//		
//		for(WebElement p : list_12) {
//			list_21.add(String.valueOf(p.getText()));
//			System.out.println(p.toString());
//			//System.out.println(list_2);
//		}
//	 Object[] list  = list_21.toArray();
		
		return SubListShoppingOptions_Computer.getText();
	 	 
	 //return  list;
		
	}
	
	public ArrayList<String> electronicOptions(){
			
			List<WebElement> list_1 = SubListShoppingOptions_Electronics;
			ArrayList<String> list = new ArrayList<String>();
			
			for(WebElement p : list_1) 
				list.add(String.valueOf(p.getText()));
		 
		 return  list;
		 
			
		}
	
	
	
	
	
	



	
	
	
	
	
	

}
