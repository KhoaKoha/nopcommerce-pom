package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminDashboardPO;
import pageObjects.AdminLoginPO;
import pageObjects.AdminProductPO;
import pageObjects.PageGeneratorManager;

public class Level_09_Register_Login_Web_Data_Table extends AbstractTest {
	WebDriver driver;

	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductPO productPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);

		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productPage = (AdminProductPO) dashboardPage.clickToSubNavMenu("Catalog", "Products");
	}

	
	public void TC_01_Paging() {
		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPagingActivateByIndex("2")); 
		
		productPage.goToPageAtTableByIndex("1");
		productPage.isPagingActivateByIndex("1"); 

		productPage.goToPageAtTableByIndex("3");
		productPage.isPagingActivateByIndex("3"); 
		
		productPage.goToPageAtTableByIndex("2");
		productPage.isPagingActivateByIndex("2"); 
		
		productPage.goToPageAtTableByIndex("1");
		productPage.isPagingActivateByIndex("1"); 
	}

	
	public void TC_02_Select_Deselect_All() {
		// Select All
		productPage.checkToSelectAllCheckBox();
		Assert.assertTrue(productPage.areProductsCheckboxChecked());
		
		// Deselect All 
		productPage.unCheckToSelectAllCheckBox();
		Assert.assertTrue(productPage.areProductsCheckboxUnChecked());
		
		// Special check
		productPage.checkToProductCheckboxByName("$25 Virtual Gift Card");
		productPage.checkToProductCheckboxByName("First Prize Pies");
		productPage.checkToProductCheckboxByName("Apple MacBook Pro 13-inch");
		productPage.checkToProductCheckboxByName("Custom T-Shirt");
	}
	

	@Test
	public void TC_03_Displayed() {
		Assert.assertTrue(productPage.areProductDetailDisplayed("Adobe Photoshop CS4", "AD_CS4_PH", "75", "10000" , "Simple", "true"));
		Assert.assertTrue(productPage.areProductDetailDisplayed("Apple iCam", "APPLE_CAM", "1300", "10000" , "Simple", "true"));
		Assert.assertTrue(productPage.areProductDetailDisplayed("Custom T-Shirt", "CS_TSHIRT", "15", "10000" , "Simple", "true"));
	}
	

	@Test
	public void TC_04_Edit() {

	}

	@AfterClass
	public void afterClass() {

	}

}
