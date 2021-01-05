package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminDashboardPO;
import pageObjects.AdminLoginPO;
import pageObjects.AdminProductPO;
import pageObjects.AdminProductDetailPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoDirectly extends AbstractTest{
	WebDriver driver;
	String email, password;
	
	AdminLoginPO loginAdminPage;
	AdminDashboardPO homeAdminPage;
	AdminProductPO productAdminPage;
	AdminProductDetailPO productDetailAdminPage;
	
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
	public void TC_06_Go_Direct() {
		productAdminPage =  (AdminProductPO) homeAdminPage.clickToSubNavMenu("Catalog", "Products");
		productAdminPage.sleepInSecond(2);
		productAdminPage.inputToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		productAdminPage.inputToProductSKU("LE_IC_600");
		productDetailAdminPage = productAdminPage.clickToGoSKU();
		Assert.assertEquals(productDetailAdminPage.getProductNameField(), "Lenovo IdeaCentre 600 All-in-One PC");
	}

	@AfterClass
	public void afterClass() {
	}

}
