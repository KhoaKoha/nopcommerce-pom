package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserAddressesPO;
import pageObjects.UserChangePasswordPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserProductDetailPO;
import pageObjects.UserProductReviewPO;
import pageObjects.UserRegisterPO;

public class MyAccount extends AbstractTest {
	WebDriver driver;

	String firstName, lastName, birthDay, birthMonth, birthYear, email, company, password, confirmPassword;
	String newFirstName, newLastName, newBirthDay, newBirthMonth, newBirthYear, newEmail, newComapany;
	String addressFirstName, addressLastName, addressEmail, addressCompany, addressCountry, addressState, addressCity, address1, address2, addressZip, addressPhoneNumber, addressFaxNumber;
	String newPasswordChange;
	String titleReview, textReview;
	
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInfoPage;
	UserAddressesPO addressPage;
	UserChangePasswordPO changePasswordPage;
	UserMyProductReviewPO myProductReviewPage;
	UserProductDetailPO productPage;
	UserProductReviewPO productReview;
	

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);

		homePage = new UserHomePO(driver);

		firstName = "Auto Test";
		lastName = "Hybrid Pom";
		email = "hybridpom" + java.time.LocalTime.now().toString().replace(".", ":").replace(":", "") + "@outlook.com";
		company = "FPT University";
		password = "123456";
		confirmPassword = "123456";

		birthDay = "18";
		birthMonth = "April";
		birthYear = "1999";
		
		newFirstName = "Automation"; 
		newLastName = "FC"; 
		newBirthDay = "1"; 
		newBirthMonth = "January"; 
		newBirthYear = "1999"; 
		newEmail = "automationfc" + java.time.LocalTime.now().toString().replace(".", ":").replace(":", "") + "@gmail.com"; 
		newComapany = "Automation FC";
		
		addressFirstName = "Automation"; 
		addressLastName = "FC"; 
		addressEmail = "automationfc.vn@gmail.com"; 
		addressCompany = "Automation FC"; 
		addressCountry = "Viet Nam";
		addressState = "Other"; 
		addressCity  = "Da Nang";
		address1 = "123/04 Le Lai";
		address2 = "234/05 Hai Phong";
		addressZip = "500000";
		addressPhoneNumber = "0123456789";
		addressFaxNumber = "0987654321";
 
		newPasswordChange =  "654321";
		
		titleReview = "Test Reivew";
		textReview = "Product is nice";

		registerPage = homePage.clickToRegisterLink();
		
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
		
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		homePage = new UserHomePO(driver); 

	}

	@Test
	public void TC_01_Update_Customer_Info() {
		customerInfoPage = homePage.clickToMyAccountLink();
		customerInfoPage.clickToGenderFemaleRadioButton();
		customerInfoPage.inputToFirstNameTextbox(newFirstName);
		customerInfoPage.inputToLastNameTextbox(newLastName);
		customerInfoPage.selectDayDropdown(newBirthDay);
		customerInfoPage.selectMonthDropdown(newBirthMonth);
		customerInfoPage.selectYearDropdown(newBirthYear);
		customerInfoPage.inputToEmailTextbox(newEmail);
		customerInfoPage.inputToCompanyTextbox(newComapany);
		customerInfoPage.clickToSaveButton();

		Assert.assertTrue(customerInfoPage.isGenderFemaleRadioButtonSelected());
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), newFirstName);
		Assert.assertEquals(customerInfoPage.getFLastNameTextboxValue(), newLastName);

		Assert.assertEquals(customerInfoPage.getSelectedTextInDayDropdown(), newBirthDay);
		Assert.assertEquals(customerInfoPage.getSelectedTextInMonthDropdown(), newBirthMonth);
		Assert.assertEquals(customerInfoPage.getSelectedTextInYearDropdown(), newBirthYear);

		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), newEmail);
		Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), newComapany);
	}

	@Test
	public void TC_02_Add_New_Address() {
		addressPage = customerInfoPage.openAddressesPage(driver);
		addressPage.clickToAddNewButton();
		addressPage.inputToFirstName(addressFirstName);
		addressPage.inputToLastName(addressLastName);
		addressPage.inputToEmail(addressEmail);
		addressPage.inputToCompany(addressCompany);
		addressPage.selectCountryDropdown(addressCountry);
		addressPage.selectStateDropdown(addressState);
		addressPage.inputToCity(addressCity);
		addressPage.inputToAddress1(address1);
		addressPage.inputToAddress2(address2);
		addressPage.inputToZip(addressZip);
		addressPage.inputToPhoneNumber(addressPhoneNumber);
		addressPage.inputFaxNumber(addressFaxNumber);
		addressPage.clickToSaveNewButton();
		
		Assert.assertEquals(addressPage.getTitleAddress(), addressFirstName + " " + addressLastName);
	}

	@Test
	public void TC_03_Change_Password() {
		changePasswordPage = addressPage.openChangePasswrodPage(driver);
		changePasswordPage.inputToOldPassword(password);
		changePasswordPage.inputToNewPassword(newPasswordChange);
		changePasswordPage.inputToConfirmPassword(newPasswordChange);
		changePasswordPage.clickToSaveChange();
		
		Assert.assertEquals(changePasswordPage.getResultMessage(), "Password was changed");
	}

	@Test
	public void TC_04_My_Product_Review() {
		homePage = changePasswordPage.openHomePage(driver);
		productPage = homePage.clickBuyBuildYourOwnComputer();
		productReview = productPage.clickToAddYourReview();
		productReview.inputToTitleReview(titleReview);
		productReview.inputToTextReview(textReview);
		productReview.clickToRating();
		productReview.clickToSubmitReview();
		Assert.assertEquals(productReview.getResultMessage(), "Product review is successfully added.");
		
		customerInfoPage = productReview.clickToMyAccountLink();
		myProductReviewPage = customerInfoPage.openMyProductReviewPage(driver);
		Assert.assertTrue(myProductReviewPage.getTitleReviewed());
		
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
