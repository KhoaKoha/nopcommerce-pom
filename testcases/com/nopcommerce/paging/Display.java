package com.nopcommerce.paging;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserHomePO;
import pageObjects.UserProductDetailPO;
import pageObjects.UserProductPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Display extends AbstractTest {
	WebDriver driver;
	UserHomePO homePage;
	UserProductPO productPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);

		homePage = new UserHomePO(driver);
		productPage = homePage.clickToNoteBookSubmenu(driver);
	}

	@Test
	public void TC_05_Display_3_Items() {
		productPage.clickToDisplay3Items();
		Assert.assertTrue(productPage.isDisplay3Items());
		Assert.assertTrue(productPage.isNextIconDisplay());
		productPage.clickMoveToPage2();
		Assert.assertTrue(productPage.isPreviousIconDisplay());
	}

	@Test
	public void TC_06_Display_6_Items() {
		productPage.clickToDisplay6Items();
		Assert.assertTrue(productPage.isDisplay6Items());
		Assert.assertFalse(productPage.isPagingDisplay());
	}

	@Test
	public void TC_07_Display_9_Items() {
		productPage.clickToDisplay9Items();
		Assert.assertTrue(productPage.isDisplay9Items());
		Assert.assertFalse(productPage.isPagingDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
