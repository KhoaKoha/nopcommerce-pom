package com.nopcommerce.wishlist;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserHomePO;
import pageObjects.UserProductDetailPO;
import pageObjects.UserProductPO;
import pageObjects.UserRecentlyViewedPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Recently_Viewed_Products extends AbstractTest {
	WebDriver driver;
	UserHomePO homePage;
	UserProductDetailPO productDetailPage;
	UserProductPO productPage;
	UserRecentlyViewedPO recentlyViewedPage;
	

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);
		homePage = new UserHomePO(driver);
		productPage = homePage.clickToNoteBookSubmenu(driver);
	}

	@Test
	public void TC_01_View_Recently() {
		productDetailPage = productPage.clickToAppleProduct();
		productPage = productDetailPage.backToProductsPage();
		
		productDetailPage = productPage.clickToAsusProduct();
		productPage = productDetailPage.backToProductsPage();
		
		productDetailPage = productPage.clickToHPProduct();
		productPage = productDetailPage.backToProductsPage();
		
		productDetailPage = productPage.clickToLenovoProduct();
		productPage = productDetailPage.backToProductsPage();
		
		productDetailPage = productPage.clickToSamsungProduct();
		recentlyViewedPage = productDetailPage.openRecentlyViewedProductPage(driver);
		
		Assert.assertTrue(recentlyViewedPage.isDisplay3FinalItems());
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
