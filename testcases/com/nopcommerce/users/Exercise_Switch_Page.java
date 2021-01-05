package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserHomePO;
import pageObjects.UserMyAccountInFooterPO;
import pageObjects.UserSearchPO;
import pageObjects.UserShippingAndReturnPO;
import pageObjects.UserSiteMapPO;
import pageObjects.UserWishListInHeaderPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Exercise_Switch_Page extends AbstractTest {
	WebDriver driver;
	
	UserHomePO homePage;
	UserSearchPO searchPage;
	UserShippingAndReturnPO shippingAndReturnPage;
	UserSiteMapPO sitemapPage; 
	UserMyAccountInFooterPO myAccountInFooterPage;
	UserWishListInHeaderPO wishListInHeaderPage;
	

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);

	}
	
	@Test
	public void TC_Switch_Page() {
		homePage = PageGeneratorManager.getUserHomePage(driver);
	
		// Home Page -> Search 
		searchPage = homePage.openSearchPage(driver);
		
		// Search -> Shipping and return
		shippingAndReturnPage = searchPage.openShippindAndReturnPage(driver);
		
		// Shipping and return -> Sitemap
		sitemapPage = shippingAndReturnPage.openSiteMAPPage(driver);
		
		// Sitemap -> Footer My Account
		myAccountInFooterPage = sitemapPage.openMyAccountInFooterPage(driver);
		
		// Footer My Account -> Home Page
		homePage = myAccountInFooterPage.openHomePage(driver);
		
		// Home Page -> Header Wishlist
	//	wishListInHeaderPage = homePage.openWishListPage(driver);
		
	}
	@AfterClass
	public void afterClass(){
		driver.close();
	}

}

 


