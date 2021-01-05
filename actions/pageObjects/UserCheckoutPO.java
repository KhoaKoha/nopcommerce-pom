package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCheckOutPageUI;

public class UserCheckoutPO extends AbstractPage {
	WebDriver driver;

	public UserCheckoutPO(WebDriver driver) {
		this.driver = driver;
	}

	/***************** BILLING *****************************/
	public void inputToFirstNameAtBilling(String firstName) {
		sendKeyToElement(driver, firstName, UserCheckOutPageUI.DYNAMIC_FIELD_AT_BILLING_ADDRESS, "FirstName");
	}

	public void inputToLastNameAtBilling(String lastName) {
		sendKeyToElement(driver, lastName, UserCheckOutPageUI.DYNAMIC_FIELD_AT_BILLING_ADDRESS, "LastName");
	}

	public void inputToEmailAtBilling(String email) {
		sendKeyToElement(driver, email, UserCheckOutPageUI.DYNAMIC_FIELD_AT_BILLING_ADDRESS, "Email");

	}

	public void selectCountryDropdownAtBilling(String country) {
		selectItemByVisible(driver, UserCheckOutPageUI.COUNTRY_DROPDOWN_AT_BILLING_ADDRESS, country);

	}

	public void inputToCompanyAtBilling(String company) {
		sendKeyToElement(driver, company, UserCheckOutPageUI.DYNAMIC_FIELD_AT_BILLING_ADDRESS, "Company");

	}

	public void selectStateDropdownAtBilling(String state) {
		selectItemByVisible(driver, UserCheckOutPageUI.STATE_DROPDOWN_AT_BILLING_ADDRESS, state);

	}

	public void inputToCityAtBilling(String city) {
		sendKeyToElement(driver, city, UserCheckOutPageUI.DYNAMIC_FIELD_AT_BILLING_ADDRESS, "City");

	}

	public void inputToAddress1AtBilling(String address1) {
		sendKeyToElement(driver, address1, UserCheckOutPageUI.DYNAMIC_FIELD_AT_BILLING_ADDRESS, "Address1");

	}

	public void inputToAddress2AtBilling(String address2) {
		sendKeyToElement(driver, address2, UserCheckOutPageUI.DYNAMIC_FIELD_AT_BILLING_ADDRESS, "Address2");

	}

	public void inputToZipCodeAtBilling(String zip) {
		sendKeyToElement(driver, zip, UserCheckOutPageUI.DYNAMIC_FIELD_AT_BILLING_ADDRESS, "ZipPostalCode");

	}

	public void inputToPhoneNumberAtBilling(String phoneNumber) {
		sendKeyToElement(driver, phoneNumber, UserCheckOutPageUI.DYNAMIC_FIELD_AT_BILLING_ADDRESS, "PhoneNumber");

	}

	public void inputToFaxNumberAtBilling(String faxNumber) {
		sendKeyToElement(driver, faxNumber, UserCheckOutPageUI.DYNAMIC_FIELD_AT_BILLING_ADDRESS, "FaxNumber");

	}

	/***************** SHIPPING *****************************/
	public void inputToFirstNameAtShipping(String firstName) {
		sendKeyToElement(driver, firstName, UserCheckOutPageUI.DYNAMIC_FIELD_AT_SHIPPING_ADDRESS, "FirstName");
	}

	public void inputToLastNameAtShipping(String lastName) {
		sendKeyToElement(driver, lastName, UserCheckOutPageUI.DYNAMIC_FIELD_AT_SHIPPING_ADDRESS, "LastName");
	}

	public void inputToEmailAtShipping(String email) {
		sendKeyToElement(driver, email, UserCheckOutPageUI.DYNAMIC_FIELD_AT_SHIPPING_ADDRESS, "Email");

	}

	public void selectCountryDropdownAtShipping(String country) {
		selectItemByVisible(driver, UserCheckOutPageUI.COUNTRY_DROPDOWN_AT_SHIPPING_ADDRESS, country);
		sleepInSecond(2);

	}

	public void inputToCompanyAtShipping(String company) {
		sendKeyToElement(driver, company, UserCheckOutPageUI.DYNAMIC_FIELD_AT_SHIPPING_ADDRESS, "Company");

	}

	public void selectStateDropdownAtShipping(String state) {
		selectItemByVisible(driver, UserCheckOutPageUI.STATE_DROPDOWN_AT_SHIPPING_ADDRESS, state);

	}

	public void inputToCityAtShipping(String city) {
		sendKeyToElement(driver, city, UserCheckOutPageUI.DYNAMIC_FIELD_AT_SHIPPING_ADDRESS, "City");

	}

	public void inputToAddress1AtShipping(String address1) {
		sendKeyToElement(driver, address1, UserCheckOutPageUI.DYNAMIC_FIELD_AT_SHIPPING_ADDRESS, "Address1");

	}

	public void inputToAddress2AtShipping(String address2) {
		sendKeyToElement(driver, address2, UserCheckOutPageUI.DYNAMIC_FIELD_AT_SHIPPING_ADDRESS, "Address2");

	}

	public void inputToZipCodeAtShipping(String zip) {
		sendKeyToElement(driver, zip, UserCheckOutPageUI.DYNAMIC_FIELD_AT_SHIPPING_ADDRESS, "ZipPostalCode");

	}

	public void inputToPhoneNumberAtShipping(String phoneNumber) {
		sendKeyToElement(driver, phoneNumber, UserCheckOutPageUI.DYNAMIC_FIELD_AT_SHIPPING_ADDRESS, "PhoneNumber");

	}

	public void inputToFaxNumberAtShipping(String faxNumber) {
		sendKeyToElement(driver, faxNumber, UserCheckOutPageUI.DYNAMIC_FIELD_AT_SHIPPING_ADDRESS, "FaxNumber");

	}

	/********************************************************/

	public void selectAddressInShipingAddress(String data) {
		selectItemByVisible(driver, UserCheckOutPageUI.ADDRESS_DROPDOWN_AT_SHIPPING_ADDRESS, data);
		sleepInSecond(2);
	}

	public void clickToShippingMethod() {
		waitForElementClickable(driver, UserCheckOutPageUI.SHIPPING_METHOD);
		clickToElement(driver, UserCheckOutPageUI.SHIPPING_METHOD);

	}

	public void clickToPaymentMethod() {
		waitForElementClickable(driver, UserCheckOutPageUI.PAYMENT_METHOD);
		clickToElement(driver, UserCheckOutPageUI.PAYMENT_METHOD);

	}

	public boolean isPaymentInforDisplay() {
		return isElementDisplayed(driver, UserCheckOutPageUI.PAYMENT_INFOR);
	}

	public void clickToContinueAtBillingAddress() {
		clickToElement(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_BILLING_ADDRESS);
		sleepInSecond(2);
	}

	public void clickToContinueAtShippingAddress() {
		clickToElement(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_SHIPPING_ADDRESS);
		sleepInSecond(2);
	}

	public void clickToContinueAtShippingMethod() {
		clickToElement(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_SHIPPING_METHOD);
		sleepInSecond(2);
	}

	public void clickToContinueAtPaymentMethod() {
		clickToElement(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_PAYMENT_METHOD);
		sleepInSecond(2);
	}

	public void clickToContinueAtPaymentInformation() {
		clickToElement(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_PAYMENT_INFORMATION);
		sleepInSecond(2);
	}

	public void clickToShipSamAddress() {
		waitForElementClickable(driver, UserCheckOutPageUI.SAME_ADDRESS_CHECKBOX);
		clickToElement(driver, UserCheckOutPageUI.SAME_ADDRESS_CHECKBOX);

	}

	public String getConfirmBillingAddress_FullName() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_BILLING_ADDRESS, "name").trim();
	}

	public String getConfirmBillingAddress_Email() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_BILLING_ADDRESS, "email").trim();
	}

	public String getConfirmBillingAddress_Phone() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_BILLING_ADDRESS, "phone").trim();
	}

	public String getConfirmBillingAddress_Address1() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_BILLING_ADDRESS, "address1").trim();
	}

	public String getConfirmBillingAddress_Address2() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_BILLING_ADDRESS, "address2").trim();
	}

	public String getConfirmBillingAddress_Country() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_BILLING_ADDRESS, "country").trim();
	}

	public String getConfirmBillingAddress_State() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_BILLING_ADDRESS, "city-state-zip").trim();
	}

	public String setCityStateZipAtConfirmOrder(String city, String state, String zip) {
		String textElement = city + "," + state + "," + zip;
		if (state.contains("Other")) {
			textElement = city + "," + zip;
		}
		return textElement;
	}

	public String getConfirmShippingAddress_FullName() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_SHIPPING_ADDRESS, "name").trim();
	}

	public String getConfirmShippingAddress_Email() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_SHIPPING_ADDRESS, "email").trim();
	}

	public String getConfirmShippingAddress_Phone() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_SHIPPING_ADDRESS, "phone").trim();
	}

	public String getConfirmShippingAddress_Address1() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_SHIPPING_ADDRESS, "address1").trim();
	}

	public String getConfirmShippingAddress_Address2() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_SHIPPING_ADDRESS, "address2").trim();
	}

	public String getConfirmShippingAddress_Country() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_SHIPPING_ADDRESS, "country").trim();
	}

	public String getConfirmShippingAddress_State() {
		return getElementText(driver, UserCheckOutPageUI.DYNAMIC_CONFIRM_ORDER_SHIPPING_ADDRESS, "city-state-zip").trim();
	}

	public String getConfirmPaymentMethod() {
		return getElementText(driver, UserCheckOutPageUI.CONFIRM_ORDER_PAYMENT_METHOD).trim();
	}

	public String getConfirmShippingMethod() {
		return getElementText(driver, UserCheckOutPageUI.CONFIRM_ORDER_SHIPPING_METHOD).trim();
	}

	public String getConfirmProductTotalPrice() {
		return getElementText(driver, UserCheckOutPageUI.CONFIRM_ORDER_PRODUCT_TOTAL_PRICE);
	}

	public String getConfirmTotal() {
		return getElementText(driver, UserCheckOutPageUI.CONFIRM_ORDER_TOTAL_BILL);
	}

	public boolean isConfirmOrderProductNameDisplay(String... valueItem) {
		return isResultContainsKeyword(driver, UserCheckOutPageUI.CONFIRM_ORDER_PRODUCTS_NAME, valueItem);
	}

	public void clickToConfirm() {
		clickToElement(driver, UserCheckOutPageUI.CONFIRM_BUTTON_AT_CONFIRM_ORDER);

	}

	public String getSuccessOrderMessage() {
		return getElementText(driver, UserCheckOutPageUI.SUCCESS_ORDER_MESSAGE);
	}

	public boolean isOrderNumberDisplay() {
		return isElementDisplayed(driver, UserCheckOutPageUI.ORDER_NUMBER);
	}

	public String getOrderNumber() {
		return getFormatNumberOrder(getElementText(driver, UserCheckOutPageUI.ORDER_NUMBER));
	}

	public String getFormatNumberOrder(String texta) {
		return texta.substring(texta.length() - 4);
	}

}
