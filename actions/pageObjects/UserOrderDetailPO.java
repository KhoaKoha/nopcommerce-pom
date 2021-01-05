package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCheckOutPageUI;
import pageUIs.UserOrderDetailPageUI;
import pageUIs.UserOrderPageUI;

public class UserOrderDetailPO extends AbstractPage{
	WebDriver driver;

	public UserOrderDetailPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getNumberOrder(String texta) {
		return texta.substring(texta.length()-4);
	}
	
	public boolean compareOrderNumber(String orderNumber) {
		if (getNumberOrder(getElementText(driver, UserOrderDetailPageUI.ORDER_NUMBER).trim()).contains(orderNumber)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isOrderDetailProductNameDisplay(String...valueItem) {
		return isResultContainsKeyword(driver, UserOrderDetailPageUI.PRODUCTS_NAME, valueItem);
	}
	
	public String getOrderDetailProductTotalPrice() {
		return getElementText(driver, UserOrderDetailPageUI.PRODUCT_TOTAL_PRICE);
	}
	
	
	public String getOrderDetailPaymentMethod() {
		return getElementText(driver, UserOrderDetailPageUI.PAYMENT_METHOD).trim();
	}
	

	public String getOrderDetailShippingMethod() {
		return getElementText(driver, UserOrderDetailPageUI.SHIPPING_METHOD).trim();
	}
	
	public String getOrderDetailTotal() {
		return getElementText(driver, UserOrderDetailPageUI.TOTAL_BILL);
	}
	
	public String getOrderDetailShippingAddress_FullName() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_SHIPPING_ADDRESS, "name").trim();
	}


	public String getOrderDetailShippingAddress_Email() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_SHIPPING_ADDRESS, "email").trim();
	}


	public String getOrderDetailShippingAddress_Phone() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_SHIPPING_ADDRESS, "phone").trim();
	}


	public String getOrderDetailShippingAddress_Address1() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_SHIPPING_ADDRESS, "address1").trim();
	}


	public String getOrderDetailShippingAddress_Address2() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_SHIPPING_ADDRESS, "address2").trim();
	}


	public String getOrderDetailShippingAddress_Country() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_SHIPPING_ADDRESS, "country").trim();
	}


	public String getOrderDetailShippingAddress_State() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_SHIPPING_ADDRESS, "city-state-zip").trim();
	}

	
	
	public String getOrderDetailBillingAddress_FullName() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_BILLING_ADDRESS, "name").trim();
	}


	public String getOrderDetailBillingAddress_Email() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_BILLING_ADDRESS, "email").trim();
	}


	public String getOrderDetailBillingAddress_Phone() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_BILLING_ADDRESS, "phone").trim();
	}


	public String getOrderDetailBillingAddress_Address1() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_BILLING_ADDRESS, "address1").trim();
	}


	public String getOrderDetailBillingAddress_Address2() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_BILLING_ADDRESS, "address2").trim();
	}


	public String getOrderDetailBillingAddress_Country() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_BILLING_ADDRESS, "country").trim();
	}


	public String getOrderDetailBillingAddress_State() {
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_BILLING_ADDRESS, "city-state-zip").trim();
	}


	public String setCityStateZipAtOrderDetailPage(String city, String state, String zip) {
		String textElement = city + "," + state + "," + zip;
		if (state.contains("Other")) {
			textElement = city + "," + zip;
		}
		return textElement;
	}
	
	public UserCartPO clickToReOrder() {
		clickToElement(driver, UserOrderDetailPageUI.RE_ORDER_BUTTON);
		return PageGeneratorManager.getUserCartPage(driver);
	}

}
