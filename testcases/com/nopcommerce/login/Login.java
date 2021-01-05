package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login extends AbstractTest {
	WebDriver driver;
	
	UserHomePO homePage;
	UserLoginPO loginPage;
	UserRegisterPO registerPage;
	
	String email, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);

		email = "testpom125@gmail.com";
		password = "123456";

		homePage = new UserHomePO(driver);
		
		homePage.clickToLoginLink();
		loginPage = new UserLoginPO(driver);
	}

	@Test
	public void TC_01_Login_Empty_Data() {
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmptyInvalidDataLoginMessage(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		loginPage.inputToEmailTextbox("1234Test");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmptyInvalidDataLoginMessage(), "Wrong email");
	}

	@Test
	public void TC_03_Login_Unregister() {
		loginPage.inputToEmailTextbox("testpom1234@gmail.com");
		loginPage.inputToPasswordTextbox("12345678");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getAccountLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_04_Registered_Login_Empty_Password() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getAccountLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_05_Registered_Login_Incorrect_Password() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getAccountLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_06_Registered_Login_Correct_Password() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		homePage = new UserHomePO(driver); 
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
