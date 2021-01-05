package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserAddressesPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOrdersPO;
import pageObjects.UserRegisterPO;

public class Level_08_Register_Login_Rest_Parameter extends AbstractTest {
	WebDriver driver;
	
	Select select;
	String firstName, lastName, birthDay, birthMonth, birthYear, email, company, password, confirmPassword;

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserAddressesPO addressesPage;
	UserOrdersPO orderPage;
	UserMyProductReviewPO myProductReviewPage;

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
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
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

		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_View_My_Account() {
		customerInforPage = homePage.clickToMyAccountLink();

		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());

		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);

		Assert.assertEquals(customerInforPage.getFLastNameTextboxValue(), lastName);

		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), birthDay);
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), birthMonth);
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), birthYear);

		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);

		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), company);
	}
	
	@Test
	public void TC_04_Switch_Page_Solution_1() {
		// Customer Infor -> Address 
		addressesPage = (UserAddressesPO) customerInforPage.openLinkByPageName(driver, "Addresses");
		
		// Address -> My Product Review 
		myProductReviewPage = (UserMyProductReviewPO) addressesPage.openLinkByPageName(driver, "My product reviews");
		
		// My Product Review -> Order 
		orderPage = (UserOrdersPO) myProductReviewPage.openLinkByPageName(driver, "Orders");
		
		// Order -> Address
		addressesPage = (UserAddressesPO) orderPage.openLinkByPageName(driver, "Addresses");
		
		// Address -> Customer Infor
		customerInforPage = (UserCustomerInforPO) addressesPage.openLinkByPageName(driver, "Customer info");
	}
	
	@Test
	public void TC_05_Switch_Page_Solution_2() {
		// Customer Infor -> Address 
		customerInforPage.openLinkByPage(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver); 
		
		// Address -> My Product Review 
		addressesPage.openLinkByPage(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		// My Product Review -> Order 
		myProductReviewPage.openLinkByPage(driver, "Orders");
		orderPage = PageGeneratorManager.getUserOrdersPage(driver);
		
		// Order -> Address
		orderPage.openLinkByPage(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		// Address -> Customer Infor
		addressesPage.openLinkByPage(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
	@AfterClass
	public void afterClass(){
		driver.close();
	}

}
