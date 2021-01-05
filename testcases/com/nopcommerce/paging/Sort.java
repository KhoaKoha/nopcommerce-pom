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

public class Sort extends AbstractTest {
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
	public void TC_01_Sort_Name_A_Z() {
		productPage.clickToSortByNameAZ();
		Assert.assertEquals(productPage.getActualSortByName(),productPage.getSortByNameAZ());
		
	}

	@Test
	public void TC_02_Sort_Z_A() {
		productPage.clickToSortByNameZA();
		Assert.assertEquals(productPage.getActualSortByName(),productPage.getSortByNameZA());
	}
	
	@Test
	public void TC_03_Sort_Low_To_High() {
		productPage.clickToSortByPriceLowToHigh();
		Assert.assertEquals(productPage.getActualSortByPrice(),productPage.getSortByPriceLowHigh());
	}
	
	@Test
	public void TC_04_Sort_High_To_Low() {
		productPage.clickToSortByPriceHighToLow();
		Assert.assertEquals(productPage.getActualSortByPrice(),productPage.getSortByPriceHighLow());
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
