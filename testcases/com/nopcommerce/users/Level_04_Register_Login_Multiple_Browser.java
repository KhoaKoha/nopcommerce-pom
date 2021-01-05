package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;

public class Level_04_Register_Login_Multiple_Browser extends AbstractTest {
	WebDriver driver;
	
	Select select;
	String firstName, lastName, birthDay, birthMonth, birthYear, email, company, password, confirmPassword;

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);

		firstName = "Auto Test";
		lastName = "Hybrid Pom";
		email = "hybridpom" + java.time.LocalTime.now().toString().replace(".", ":").replace(":", "") + "@outlook.com";
		company = "FPT University";
		password = "123456";
		confirmPassword = "123456";
		birthDay = "18";
		birthMonth = "April";
		birthYear = "1999";

		
	}

	@Test
	public void TC_01_Register() {
		homePage = new UserHomePO(driver);
		homePage.clickToRegisterLink();

		registerPage = new UserRegisterPO(driver);

		registerPage.clickToGenderMaleRadioButton();

		registerPage.inputToFirstNameTextbox(firstName);

		registerPage.inputToLastNameTextbox(lastName);

		registerPage.selectDayDropdown(birthDay);

		registerPage.selectMonthDropdown(birthMonth);

		registerPage.selectYearDropdown(birthYear);

		registerPage.inputToEmailTextbox(email);

		registerPage.inputToCompanyTextbox(company);

		registerPage.inputToPasswordTextbox(password);

		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		registerPage.clickToLogoutLink();

		homePage = new UserHomePO(driver);
	}

	@Test
	public void TC_02_Login() {
		homePage.clickToLoginLink();

		loginPage = new UserLoginPO(driver);

		loginPage.inputToEmailTextbox(email);

		loginPage.inputToPasswordTextbox(password);

		loginPage.clickToLoginButton();

		homePage = new UserHomePO(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_View_My_Account() {
		homePage.clickToMyAccountLink();

		customerInforPage = new UserCustomerInforPO(driver);

		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());

		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);

		Assert.assertEquals(customerInforPage.getFLastNameTextboxValue(), lastName);

		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), birthDay);
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), birthMonth);
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), birthYear);

		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);

		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), company);
	}
	
	@AfterClass
	public void afterClass(){
		driver.close();
	}

}
