	package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminCustomerPO;
import pageObjects.AdminDashboardPO;
import pageObjects.AdminLoginPO;
import pageObjects.AdminProductPO;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;

public class Search extends AbstractTest{
	WebDriver driver;
	String email, password;
	
	AdminLoginPO loginAdminPage;
	AdminDashboardPO homeAdminPage;
	AdminProductPO productAdminPage;
	AdminCustomerPO customerAdminPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);
		email = "admin@yourstore.com"; 
		password = "admin";
		
		loginAdminPage = new AdminLoginPO(driver);
		loginAdminPage.inputToEmail(email);
		loginAdminPage.inputToPasswrod(password);
		homeAdminPage = loginAdminPage.clickToLoginButton();
		
	}

	@Test
	public void TC_01_Search_Product_Name() {
		productAdminPage =  (AdminProductPO) homeAdminPage.clickToSubNavMenu("Catalog", "Products");
		productAdminPage.sleepInSecond(2);
		productAdminPage.inputToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		productAdminPage.clickToSearchButton();
		Assert.assertTrue(productAdminPage.isResultContainsKeyword("Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertEquals(productAdminPage.getSizeItemsInTableResult(), "1");
	}
	
	@Test
	public void TC_02_Search_Product_Name_Parent_Category_Unchecked_Subcategories() {
		productAdminPage.selectCategory("Computers");
		productAdminPage.checkToSearchSubCategories(false);
		productAdminPage.clickToSearchButton();
		Assert.assertTrue(productAdminPage.isNoDataMessageDisplay());
	}
	
	@Test
	public void TC_03_Search_Product_Name_Parent_Category_Checked_Subcategories() {
		productAdminPage.checkToSearchSubCategories(true);
		productAdminPage.clickToSearchButton();
		Assert.assertTrue(productAdminPage.isResultContainsKeyword("Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertEquals(productAdminPage.getSizeItemsInTableResult(), "1");
	}

	@Test
	public void TC_04_Search_Product_Name_Child_Category() {
		productAdminPage.selectCategory("Computers >> Desktops");
		productAdminPage.checkToSearchSubCategories(false);
		productAdminPage.clickToSearchButton();
		Assert.assertTrue(productAdminPage.isResultContainsKeyword("Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertEquals(productAdminPage.getSizeItemsInTableResult(), "1");
	}
	
	@Test
	public void TC_05_Search_Product_Name_Manufacturer() {
		productAdminPage.selectCategory("All");
		productAdminPage.checkToSearchSubCategories(false);
		productAdminPage.selectManufacturer("Apple");
		productAdminPage.clickToSearchButton();
		Assert.assertTrue(productAdminPage.isNoDataMessageDisplay());
	}
	

	@AfterClass
	public void afterClass() {
	}
}
