package com.nopcommerce.search;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserSearchPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Search extends AbstractTest {
	WebDriver driver;

	String username, password;
	String dataNotExist, dataRelative, dataAbsolute;
	
	UserHomePO homePage;
	UserLoginPO loginPage;
	UserSearchPO searchPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);
		
		username = "";
		password = "";
		
		dataNotExist = "Macbook Pro 2050";
		dataRelative = "Lenovo";
		dataAbsolute = "Thinkpad X1 Carbon";
		
		homePage = new UserHomePO(driver);
//		loginPage = homePage.clickToLoginLink();
//		
//		loginPage.inputToEmailTextbox(username);
//		loginPage.inputToPasswordTextbox(password);
//		loginPage.clickToLoginButton();
		
		searchPage = homePage.openSearchPage(driver);
	}

	@Test
	public void TC_01_Search_Empty_Data() {
		searchPage.clickToClickSearchButton();
		Assert.assertEquals(searchPage.getTextEmptyDataMessage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void TC_02_Search_Data_Not_Exist() {
		searchPage.inputToSearchTextBox(dataNotExist);
		searchPage.clickToClickSearchButton();
		Assert.assertEquals(searchPage.getTextDataNoExistMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_03_Search_Product_Name_Relative() {
		searchPage.inputToSearchTextBox(dataRelative);
		searchPage.clickToClickSearchButton();
		Assert.assertTrue(searchPage.isProductContainsKeyword(dataRelative));
		
	}

	@Test
	public void TC_04_Search_Product_Name_Absolute() {
		searchPage.inputToSearchTextBox(dataAbsolute);
		searchPage.clickToClickSearchButton();
		Assert.assertTrue(searchPage.isProductContainsKeyword(dataAbsolute));
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
