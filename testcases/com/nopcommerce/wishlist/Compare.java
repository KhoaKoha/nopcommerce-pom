package com.nopcommerce.wishlist;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserComparePO;
import pageObjects.UserHomePO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Compare extends AbstractTest {
	WebDriver driver;
	UserHomePO homePage;
	UserComparePO comparePage;

	String product1, product2;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);

		homePage = new UserHomePO(driver);
		
		product1 = "Apple MacBook Pro 13-inch";
		product2 = "HTC One M8 Android L 5.0 Lollipop";

	}

	@Test
	public void TC_01_Add_To_Compare_2_Products() {
		homePage.clickToAppleAddCompare(product1);
		Assert.assertEquals(homePage.getCompareSuccessMessage(), "The product has been added to your product comparison");
		homePage.closeMessageAddCompareSuccess();
		homePage.clickToHTCAddCompare(product2);
		Assert.assertEquals(homePage.getCompareSuccessMessage(), "The product has been added to your product comparison");
		homePage.closeMessageAddCompareSuccess();
		
		comparePage = homePage.clickToCompareProductListLink();
		Assert.assertTrue(comparePage.isDirectToComparePage());
		
		Assert.assertTrue(comparePage.isRemoveButtonDisplay());
		Assert.assertTrue(comparePage.isComparePageContainsNameProducts());
		Assert.assertTrue(comparePage.isComparePageContainsPriceProducts());
		Assert.assertTrue(comparePage.isClearListButtonDisplay());
	
		comparePage.clickToClearListButton();
		Assert.assertEquals(comparePage.getTextNoItemsComparePage(), "You have no items to compare.");
		Assert.assertTrue(comparePage.isNoProductInComparePage());
	}

	@AfterClass
	public void afterClass() {
	}

}
