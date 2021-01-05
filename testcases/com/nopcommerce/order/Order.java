package com.nopcommerce.order;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserCartPO;
import pageObjects.UserCheckoutPO;
import pageObjects.UserHomePO;
import pageObjects.UserMyAccountInFooterPO;
import pageObjects.UserOrderDetailPO;
import pageObjects.UserOrdersPO;
import pageObjects.UserProductDetailPO;
import pageObjects.UserProductPO;
import pageObjects.UserRegisterPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Order extends AbstractTest {
	WebDriver driver;
	String firstName1, lastName1, email1, company1, country1, state1, city1, address1_1, address2_1, zip1, phoneNumber1, faxNumber1;
	String firstName2, lastName2, email2, company2, country2, state2, city2, address1_2, address2_2, zip2, phoneNumber2, faxNumber2;
	String birthDay, birthMonth, birthYear, password, confirmPassword;
	String orderNumber;
	UserHomePO homePage;
	UserProductPO productPage;
	UserProductDetailPO productDetailPage;
	UserCartPO cartPage;
	UserCheckoutPO checkoutPage;
	UserRegisterPO registerPage;
	UserMyAccountInFooterPO myAccountPage;
	UserOrdersPO orderPage;
	UserOrderDetailPO orderDetailPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowser(browserName, urlValue);
		
		homePage = new UserHomePO(driver);
		firstName1 = "Automation FC";
		lastName1 = "Test";
		email1 = "automationfc" + new Random().nextInt(1000) + "@gmail.com";
		company1 = "FPT";
		country1 = "Viet Nam";
		state1 = "Other";
		city1 = "Ho Chi Minh";
		address1_1 = "123 Ky Con";
		address2_1 = "456 Tran Hung Dao";
		zip1 = "700000";
		phoneNumber1 = "0123456789";
		faxNumber1 = "987654321";

		firstName2 = "Automation FC Selenium";
		lastName2 = "Test Auto";
		email2 = "automationfc" + new Random().nextInt(1000) + "@gmail.com";
		company2 = "FPT";
		country2 = "United States";
		state2 = "California";
		city2 = "HNA";
		address1_2 = "12 45St";
		address2_2 = "12 45St";
		zip2 = "500000";
		phoneNumber2 = "0983216547";
		faxNumber2 = "985632147";

		birthDay = "18";
		birthMonth = "April";
		birthYear = "1999";
		password = "123456";
		confirmPassword = "123456";

		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstNameTextbox(firstName1);
		registerPage.inputToLastNameTextbox(lastName1);
		registerPage.selectDayDropdown(birthDay);
		registerPage.selectMonthDropdown(birthMonth);
		registerPage.selectYearDropdown(birthYear);
		registerPage.inputToEmailTextbox(email1);
		registerPage.inputToCompanyTextbox(company1);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.openHomePage(driver);
	}

	@Test
	public void TC_01_Add_Product_To_Cart() {
		homePage.hoverToDynamicMenuInNav(driver, "Computers");
		productPage = homePage.clickToSubMenuInNav(driver, "Desktops");

		productDetailPage = productPage.clickToDynamicProduct("Build your own computer");
		productDetailPage.selectProcessor("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		productDetailPage.selectRam("8GB [+$60.00]");
		productDetailPage.clickToHDD("400 GB [+$100.00]");
		productDetailPage.clickToOS("Vista Premium [+$60.00]");
		productDetailPage.clickToSoftware("Total Commander [+$5.00]");
		productDetailPage.clickToAddToCart();
		Assert.assertEquals(productDetailPage.getAddToCartSuccessMessage(), "The product has been added to your shopping cart");

		productDetailPage.clickToCloseMessageInBar();
		productDetailPage.scrollToTopPage(driver);
		productDetailPage.hoverMouseToCartInHeader(driver);

		Assert.assertEquals(productDetailPage.getNumberOfProductAtIconCart(driver), "(" + 1 + ")");
		Assert.assertEquals(productDetailPage.getNumberOfProductAtCartPopup(), "There are 1 item(s) in your cart.");
		Assert.assertEquals(productDetailPage.getNameProductAtCartPopup(), "Build your own computer");
		Assert.assertEquals(productDetailPage.getTotalAtCartPopup(), "$1,440.00");
	}

	@Test
	public void TC_02_Edit_Product_In_Cart() {
		cartPage = productDetailPage.opeCartInHeader(driver);
		productDetailPage = cartPage.clickToEdit();
		productDetailPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
		productDetailPage.selectRam("4GB [+$20.00]");
		productDetailPage.clickToHDD("320 GB");
		productDetailPage.clickToOS("Vista Home [+$50.00]");
		productDetailPage.clickToSoftware("Microsoft Office [+$50.00]", "Acrobat Reader [+$10.00]");
		productDetailPage.inputQualityProducts("2");
		productDetailPage.clickToUpdateCart();

		Assert.assertEquals(productDetailPage.getPrice(), "$1,330.00");
		Assert.assertEquals(productDetailPage.getAddToCartSuccessMessage(), "The product has been added to your shopping cart");

		productDetailPage.clickToCloseMessageInBar();
		productDetailPage.scrollToTopPage(driver);
		productDetailPage.hoverMouseToWishlistInHeader(driver);
		productDetailPage.hoverMouseToCartInHeader(driver);

		Assert.assertEquals(productDetailPage.getNumberOfProductAtIconCart(driver), "(" + 2 + ")");
		Assert.assertEquals(productDetailPage.getNumberOfProductAtCartPopup(), "There are 2 item(s) in your cart.");
		Assert.assertEquals(productDetailPage.getNameProductAtCartPopup(), "Build your own computer");
		Assert.assertEquals(productDetailPage.getTotalAtCartPopup(), "$2,660.00");

	}

	@Test
	public void TC_03_Remove_From_Cart() {
		cartPage = productDetailPage.opeCartInHeader(driver);
		// coi lại hàm click remove checkbox trong table
		cartPage.clickToRemoveCheckbox();
		cartPage.clickToUpdateCart();
		// Assert.assertTrue(cartPage.isNoItemsInCart());
	}

	@Test
	public void TC_04_Update_Cart() {
		cartPage.hoverToDynamicMenuInNav(driver, "Computers");
		productPage = cartPage.clickToSubMenuInNav(driver, "Desktops");
		productDetailPage = productPage.clickToDynamicProduct("Lenovo IdeaCentre 600 All-in-One PC");
		productDetailPage.clickToAddToCart();
		productDetailPage.clickToCloseMessageInBar();
		productDetailPage.scrollToBottomPageByJS(driver);
		cartPage = productDetailPage.opeCartInFooter(driver);
		cartPage.inputToQuality("5");
		cartPage.clickToUpdateCart();
		Assert.assertEquals(cartPage.getTotalPriceInPerItem(), "$2,500.00");

		// update and then remove
		cartPage.clickToRemoveCheckbox();
		cartPage.clickToUpdateCart();
		homePage = cartPage.openHomePage(driver);
	}

	@Test
	public void TC_05_06_07_Checkout_Order_Payment_By_Cheque_And_Pre_Pre_Order() {
		homePage.hoverToDynamicMenuInNav(driver, "Computers");
		productPage = homePage.clickToSubMenuInNav(driver, "Notebooks");
		productDetailPage = productPage.clickToDynamicProduct("Apple MacBook Pro 13-inch");
		productDetailPage.inputQualityProducts("2");
		productDetailPage.clickToAddToCart();

		productDetailPage.clickToCloseMessageInBar();
		cartPage = productDetailPage.opeCartInHeader(driver);

		cartPage.selectGiftWrapping("No");
		cartPage.clickToTerm();
		checkoutPage = cartPage.clickToCheckOut();

		/* BILLING ADDRESS */
		checkoutPage.clickToShipSamAddress(); // coi lai cho nay
		checkoutPage.inputToFirstNameAtBilling(firstName1);
		checkoutPage.inputToLastNameAtBilling(lastName1);
		checkoutPage.inputToEmailAtBilling(email1);
		checkoutPage.inputToCompanyAtBilling(company1);
		checkoutPage.selectCountryDropdownAtBilling(country1);
		checkoutPage.selectStateDropdownAtBilling(state1);
		checkoutPage.inputToCityAtBilling(city1);
		checkoutPage.inputToAddress1AtBilling(address1_1);
		checkoutPage.inputToAddress2AtBilling(address2_1);
		checkoutPage.inputToZipCodeAtBilling(zip1);
		checkoutPage.inputToPhoneNumberAtBilling(phoneNumber1);
		checkoutPage.inputToFaxNumberAtBilling(faxNumber1);
		checkoutPage.clickToContinueAtBillingAddress();

		/** SHIPPING ADDRESS **/
		checkoutPage.selectAddressInShipingAddress("New Address");
		checkoutPage.inputToFirstNameAtShipping(firstName2);
		checkoutPage.inputToLastNameAtShipping(lastName2);
		checkoutPage.inputToEmailAtShipping(email2);
		checkoutPage.inputToCompanyAtShipping(company2);
		checkoutPage.selectCountryDropdownAtShipping(country2);
		checkoutPage.selectStateDropdownAtShipping(state2);
		checkoutPage.inputToCityAtShipping(city2);
		checkoutPage.inputToAddress1AtShipping(address1_2);
		checkoutPage.inputToAddress2AtShipping(address2_2);
		checkoutPage.inputToZipCodeAtShipping(zip2);
		checkoutPage.inputToPhoneNumberAtShipping(phoneNumber2);
		checkoutPage.inputToFaxNumberAtShipping(faxNumber2);
		checkoutPage.clickToContinueAtShippingAddress();

		/** SHIPPING METHOD **/
		checkoutPage.clickToShippingMethod();
		checkoutPage.clickToContinueAtShippingMethod();

		/** PAYMENT METHOD **/
		checkoutPage.clickToPaymentMethod();
		checkoutPage.clickToContinueAtPaymentMethod();

		/** PAYMENT INFORMATION **/
		Assert.assertTrue(checkoutPage.isPaymentInforDisplay());
		checkoutPage.clickToContinueAtPaymentInformation();

		/** CONFIRM ORDER **/
		Assert.assertEquals(checkoutPage.getConfirmBillingAddress_FullName(), firstName1 + " " + lastName1);
		Assert.assertEquals(checkoutPage.getConfirmBillingAddress_Email(), "Email: " + email1);
		Assert.assertEquals(checkoutPage.getConfirmBillingAddress_Phone(), "Phone: " + phoneNumber1);
		Assert.assertEquals(checkoutPage.getConfirmBillingAddress_Address1(), address1_1);
		Assert.assertEquals(checkoutPage.getConfirmBillingAddress_Address2(), address2_1);
		Assert.assertEquals(checkoutPage.getConfirmBillingAddress_Country(), country1);
		Assert.assertEquals(checkoutPage.getConfirmBillingAddress_State(), checkoutPage.setCityStateZipAtConfirmOrder(city1, state1, zip1));

		Assert.assertEquals(checkoutPage.getConfirmShippingAddress_FullName(), firstName2 + " " + lastName2);
		Assert.assertEquals(checkoutPage.getConfirmShippingAddress_Email(), "Email: " + email2);
		Assert.assertEquals(checkoutPage.getConfirmShippingAddress_Phone(), "Phone: " + phoneNumber2);
		Assert.assertEquals(checkoutPage.getConfirmShippingAddress_Address1(), address1_2);
		Assert.assertEquals(checkoutPage.getConfirmShippingAddress_Address2(), address2_2);
		Assert.assertEquals(checkoutPage.getConfirmShippingAddress_Country(), country2);
		Assert.assertEquals(checkoutPage.getConfirmShippingAddress_State(), checkoutPage.setCityStateZipAtConfirmOrder(city2, state2, zip2));

		Assert.assertEquals(checkoutPage.getConfirmPaymentMethod(), "Check / Money Order");
		Assert.assertEquals(checkoutPage.getConfirmShippingMethod(), "Ground");
		Assert.assertTrue(checkoutPage.isConfirmOrderProductNameDisplay("Apple MacBook Pro 13-inch"));
		Assert.assertEquals(checkoutPage.getConfirmProductTotalPrice(), "$3,600.00");
		Assert.assertEquals(checkoutPage.getConfirmTotal(), "$3,600.00");

		checkoutPage.clickToConfirm();

		Assert.assertEquals(checkoutPage.getSuccessOrderMessage(), "Your order has been successfully processed!");
		Assert.assertTrue(checkoutPage.isOrderNumberDisplay());
		orderNumber = checkoutPage.getOrderNumber().trim();

		myAccountPage = checkoutPage.openMyAccountInFooterPage(driver);
		orderPage = myAccountPage.openOrdersPage(driver);
		assertTrue(orderPage.compareOrderNumber(orderNumber));

		orderDetailPage = orderPage.clickToDetail();
		assertTrue(orderDetailPage.compareOrderNumber(orderNumber));
		Assert.assertTrue(orderDetailPage.isOrderDetailProductNameDisplay("Apple MacBook Pro 13-inch"));
		Assert.assertEquals(orderDetailPage.getOrderDetailProductTotalPrice(), "$3,600.00");
		Assert.assertEquals(orderDetailPage.getOrderDetailTotal(), "$3,600.00");
		Assert.assertEquals(orderDetailPage.getOrderDetailPaymentMethod(), "Check / Money Order");
		Assert.assertEquals(orderDetailPage.getOrderDetailShippingMethod(), "Ground");
		
		Assert.assertEquals(orderDetailPage.getOrderDetailBillingAddress_FullName(), firstName1 + " " + lastName1);
		Assert.assertEquals(orderDetailPage.getOrderDetailBillingAddress_Email(), "Email: " + email1);
		Assert.assertEquals(orderDetailPage.getOrderDetailBillingAddress_Phone(), "Phone: " + phoneNumber1);
		Assert.assertEquals(orderDetailPage.getOrderDetailBillingAddress_Address1(), address1_1);
		Assert.assertEquals(orderDetailPage.getOrderDetailBillingAddress_Address2(), address2_1);
		Assert.assertEquals(orderDetailPage.getOrderDetailBillingAddress_Country(), country1);
		Assert.assertEquals(orderDetailPage.getOrderDetailBillingAddress_State(), orderDetailPage.setCityStateZipAtOrderDetailPage(city1, state1, zip1));

		Assert.assertEquals(orderDetailPage.getOrderDetailShippingAddress_FullName(), firstName2 + " " + lastName2);
		Assert.assertEquals(orderDetailPage.getOrderDetailShippingAddress_Email(), "Email: " + email2);
		Assert.assertEquals(orderDetailPage.getOrderDetailShippingAddress_Phone(), "Phone: " + phoneNumber2);
		Assert.assertEquals(orderDetailPage.getOrderDetailShippingAddress_Address1(), address1_2);
		Assert.assertEquals(orderDetailPage.getOrderDetailShippingAddress_Address2(), address2_2);
		Assert.assertEquals(orderDetailPage.getOrderDetailShippingAddress_Country(), country2);
		Assert.assertEquals(orderDetailPage.getOrderDetailShippingAddress_State(), orderDetailPage.setCityStateZipAtOrderDetailPage(city2, state2, zip2));
		
		cartPage = orderDetailPage.clickToReOrder();
		cartPage.inputToQuality("10");
		cartPage.clickToUpdateCart();
		cartPage.selectGiftWrapping("No");
		cartPage.clickToTerm();
		checkoutPage = cartPage.clickToCheckOut();
		checkoutPage.clickToContinueAtBillingAddress();
		checkoutPage.clickToContinueAtShippingMethod();;
		checkoutPage.clickToContinueAtPaymentMethod();
		checkoutPage.clickToContinueAtPaymentInformation();
		checkoutPage.sleepInSecond(60);
		checkoutPage.clickToConfirm();
		Assert.assertEquals(checkoutPage.getSuccessOrderMessage(), "Your order has been successfully processed!");
	}


	@AfterClass
	public void afterClass() {
	}

}
