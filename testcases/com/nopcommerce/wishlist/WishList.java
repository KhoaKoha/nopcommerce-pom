package com.nopcommerce.wishlist;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserCartPO;
import pageObjects.UserHomePO;
import pageObjects.UserProductDetailPO;
import pageObjects.UserWishListInHeaderPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class WishList extends AbstractTest{
	WebDriver driver;
	UserHomePO homePage;
	UserProductDetailPO productDetailPage;
	UserWishListInHeaderPO wishlistPageInHeader;
	UserCartPO cartPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);
		
		homePage = new UserHomePO(driver); 
		
	}

	@Test
	public void TC_01_Add_To_WishList() {
		productDetailPage = homePage.clickBuyAppleMacbookPro();
		productDetailPage.clickToAddToWishlist();
		Assert.assertEquals(productDetailPage.getWishlistSuccessMessage(), "The product has been added to your wishlist");
		productDetailPage.clickToCloseWishListNotiButton();
		wishlistPageInHeader = productDetailPage.openWishListPageInHeader(driver);
		
		Assert.assertEquals(wishlistPageInHeader.getTextProductNameInWishlistPage(), "Apple MacBook Pro 13-inch");
		
		wishlistPageInHeader.clickToLinkWishlistSharing();
		
		Assert.assertEquals(wishlistPageInHeader.getTextProductNameInWishlistPage(), "Apple MacBook Pro 13-inch");
	}
	
	@Test
	public void TC_02_Add_Product_To_Cart_From_Wishlist() {
		homePage = wishlistPageInHeader.openHomePage(driver);
		wishlistPageInHeader = homePage.openWishListPageInHeader(driver);
		
		wishlistPageInHeader.clickToCheckboxAddToCart();
		cartPage = wishlistPageInHeader.clickToAddToCartButton();
		
		Assert.assertTrue(cartPage.isDirectPageToCartPage());
		Assert.assertEquals(cartPage.getProductNameInCart(), "Apple MacBook Pro 13-inch");
		Assert.assertEquals(cartPage.getQualityProductsInWishlistIcon(), "(0)");
		
		homePage = cartPage.openHomePage(driver);
	}
	
	@Test
	public void TC_03_Remove_Product_In_Wishlist() {
		productDetailPage = homePage.clickBuyAppleMacbookPro();
		productDetailPage.clickToAddToWishlist();
		Assert.assertEquals(productDetailPage.getWishlistSuccessMessage(), "The product has been added to your wishlist");
		productDetailPage.clickToCloseWishListNotiButton();
		wishlistPageInHeader = productDetailPage.openWishListPageInHeader(driver);
		
		Assert.assertEquals(wishlistPageInHeader.getTextProductNameInWishlistPage(), "Apple MacBook Pro 13-inch");
		wishlistPageInHeader.clickToRemove();
		wishlistPageInHeader.clickToUpdateWishlist();
		
		Assert.assertEquals(wishlistPageInHeader.getTextWishlistEmptyMessage(), "The wishlist is empty!");
		Assert.assertEquals(wishlistPageInHeader.getQualityProductsInWishlistIcon(), "(0)");
	}
	

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
