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

public class AdvanceSearch extends AbstractTest {
	WebDriver driver;

	String username, password;
	String searchKeyword;

	UserHomePO homePage;
	UserLoginPO loginPage;
	UserSearchPO searchPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);

		username = "";
		password = "";

		searchKeyword = "Apple MacBook Pro";

		homePage = new UserHomePO(driver);
//		loginPage = homePage.clickToLoginLink();
//		
//		loginPage.inputToEmailTextbox(username);
//		loginPage.inputToPasswordTextbox(password);
//		loginPage.clickToLoginButton();

		searchPage = homePage.openSearchPage(driver);
	}

	@Test
	public void TC_05_Search_Parent_Categories() {
		searchPage.inputToSearchTextBox(searchKeyword);
		searchPage.checkAdvancedSearch();
		searchPage.clickToCategoryDropdown();
		searchPage.clickToComputerInSubCategories();
		searchPage.clickToClickSearchButton();
		Assert.assertEquals(searchPage.getTextDataNoExistMessage(), "No products were found that matched your criteria.");

		searchPage = searchPage.openSearchPage(driver);
	}

	@Test
	public void TC_06_Search_Sub_Categories() {
		searchPage.inputToSearchTextBox(searchKeyword);
		searchPage.checkAdvancedSearch();
		searchPage.clickToCategoryDropdown();
		searchPage.clickToComputerInSubCategories();
		searchPage.clickToAutomaticallySearch();
		searchPage.clickToClickSearchButton();
		Assert.assertTrue(searchPage.isProductContainsKeyword(searchKeyword));

		searchPage = searchPage.openSearchPage(driver);
	}

	@Test
	public void TC_07_Search_Incorrect_Manufacturer() {
		searchPage.inputToSearchTextBox(searchKeyword);
		searchPage.checkAdvancedSearch();
		searchPage.clickToCategoryDropdown();
		searchPage.clickToComputerInSubCategories();
		searchPage.clickToAutomaticallySearch();
		searchPage.clickToManufacturer();
		searchPage.clickToHPInManufacturer();
		searchPage.clickToClickSearchButton();
		Assert.assertEquals(searchPage.getTextDataNoExistMessage(), "No products were found that matched your criteria.");

		searchPage = searchPage.openSearchPage(driver);
	}

	@Test
	public void TC_08_Search_Correct_Manufacturer() {
		searchPage.inputToSearchTextBox(searchKeyword);
		searchPage.checkAdvancedSearch();
		searchPage.clickToCategoryDropdown();
		searchPage.clickToComputerInSubCategories();
		searchPage.clickToAutomaticallySearch();
		searchPage.clickToManufacturer();
		searchPage.clickToAppleInManufacturer();
		searchPage.clickToClickSearchButton();
		Assert.assertTrue(searchPage.isProductContainsKeyword(searchKeyword));

		searchPage = searchPage.openSearchPage(driver);
	}

	
	@Test
	public void TC_09_Search_In_Price_Range() {
		searchPage.inputToSearchTextBox(searchKeyword);
		searchPage.checkAdvancedSearch();
		searchPage.clickToCategoryDropdown();
		searchPage.clickToComputerInSubCategories();
		searchPage.clickToAutomaticallySearch();
		searchPage.clickToManufacturer();
		searchPage.clickToAppleInManufacturer();
		searchPage.inputToPriceFrom("1000");
		searchPage.inputToPriceTo("2000");
		searchPage.clickToClickSearchButton();
		Assert.assertTrue(searchPage.isProductInPrice("1000","2000"));
		
		searchPage = searchPage.openSearchPage(driver);
	}

	@Test
	public void TC_10_Search_Less_Price_Range() {
		searchPage.inputToSearchTextBox(searchKeyword);
		searchPage.checkAdvancedSearch();
		searchPage.clickToCategoryDropdown();
		searchPage.clickToComputerInSubCategories();
		searchPage.clickToAutomaticallySearch();
		searchPage.clickToManufacturer();
		searchPage.clickToAppleInManufacturer();
		searchPage.inputToPriceFrom("1000");
		searchPage.inputToPriceTo("1700");
		searchPage.clickToClickSearchButton();
		Assert.assertEquals(searchPage.getTextDataNoExistMessage(), "No products were found that matched your criteria.");

		searchPage = searchPage.openSearchPage(driver);
	}

	@Test
	public void TC_11_Search_More_Price_Range() {
		searchPage.inputToSearchTextBox(searchKeyword);
		searchPage.checkAdvancedSearch();
		searchPage.clickToCategoryDropdown();
		searchPage.clickToComputerInSubCategories();
		searchPage.clickToAutomaticallySearch();
		searchPage.clickToManufacturer();
		searchPage.clickToAppleInManufacturer();
		searchPage.inputToPriceFrom("1900");
		searchPage.inputToPriceTo("5000");
		searchPage.clickToClickSearchButton();
		Assert.assertEquals(searchPage.getTextDataNoExistMessage(), "No products were found that matched your criteria.");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
