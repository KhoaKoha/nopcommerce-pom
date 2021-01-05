package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserHomePO;
import pageObjects.UserRegisterPO;
import pageUIs.UserRegisterPageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Register extends AbstractTest {
	WebDriver driver;

	String firstName, lastName, birthDay, birthMonth, birthYear, validOldEmail, invalidEmail, company, password,
			validNewEmail, invalidPassword, confirmPassword;

	UserHomePO homePage;
	UserRegisterPO registerPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);

		homePage = new UserHomePO(driver);

		firstName = "Auto Test";
		lastName = "Hybrid Pom";
		validOldEmail = "hybridpom0318@gmail.com";
		validNewEmail = "hybridpom" + java.time.LocalTime.now().toString().replace(".", ":").replace(":", "")
				+ "@outlook.com";
		invalidEmail = "hybridpom.com";
		company = "FPT University";
		invalidPassword = "123";
		password = "123456";
		confirmPassword = "123456";

		birthDay = "18";
		birthMonth = "April";
		birthYear = "1999";

	}

	@Test
	public void TC_01_Register_Empty_Data() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isElementDisplayed(driver, UserRegisterPageUI.FIRSTNAME_VALIDATION_ERROR));
		Assert.assertTrue(registerPage.isElementDisplayed(driver, UserRegisterPageUI.LASTNAME_VALIDATION_ERROR));
		Assert.assertTrue(registerPage.isElementDisplayed(driver, UserRegisterPageUI.EMAIL_VALIDATION_ERROR));
		Assert.assertTrue(registerPage.isElementDisplayed(driver, UserRegisterPageUI.PASSWORD_VALIDATION_ERROR));
		Assert.assertTrue(registerPage.isElementDisplayed(driver, UserRegisterPageUI.CONFIRM_PASSWORD_VALIDATION_ERROR));

		registerPage.clickToRegisterLink(driver);
		
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(birthDay);
		registerPage.selectMonthDropdown(birthMonth);
		registerPage.selectYearDropdown(birthYear);

		registerPage.inputToEmailTextbox(invalidEmail);

		registerPage.inputToCompanyTextbox(company);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getElementText(driver, UserRegisterPageUI.EMAIL_VALIDATION_ERROR), "Wrong email");
		registerPage.clickToRegisterLink(driver);
		
	}

	@Test
	public void TC_03_Register_Account_Exists() {
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(birthDay);
		registerPage.selectMonthDropdown(birthMonth);
		registerPage.selectYearDropdown(birthYear);

		registerPage.inputToEmailTextbox(validOldEmail);

		registerPage.inputToCompanyTextbox(company);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getElementText(driver, UserRegisterPageUI.ACCOUNT_EXISTS_ERROR),
				"The specified email already exists");
		registerPage.clickToRegisterLink(driver);
		
	}

	@Test
	public void TC_04_Register_Password_Less_6_Characters() {
	
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(birthDay);
		registerPage.selectMonthDropdown(birthMonth);
		registerPage.selectYearDropdown(birthYear);
		registerPage.inputToEmailTextbox(validNewEmail);
		registerPage.inputToCompanyTextbox(company);

		registerPage.inputToPasswordTextbox(invalidPassword);
		registerPage.clickToRegisterButton();
		
		
		/*********** Chỗ này chưa xử lí được xpath nè *************/
		Assert.assertEquals(registerPage.getElementText(driver, UserRegisterPageUI.ACCOUNT_EXISTS_ERROR),
				"Password must meet the following rules:\n" + "\n" + "must have at least 6 characters");
		registerPage.clickToRegisterLink(driver);
		
	}

	@Test
	public void TC_05_Register_Password_Not_Match() {
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(birthDay);
		registerPage.selectMonthDropdown(birthMonth);
		registerPage.selectYearDropdown(birthYear);
		registerPage.inputToEmailTextbox(validNewEmail);
		registerPage.inputToCompanyTextbox(company);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("99999999");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_VALIDATION_ERROR),
				"The password and confirmation password do not match.");
		registerPage.clickToRegisterLink(driver);
		
	}

	@Test
	public void TC_06_Register_Valid_Data() {
		
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(birthDay);
		registerPage.selectMonthDropdown(birthMonth);
		registerPage.selectYearDropdown(birthYear);
		registerPage.inputToEmailTextbox(validNewEmail);
		registerPage.inputToCompanyTextbox(company);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@AfterClass
	public void afterClass() {
	}

}
