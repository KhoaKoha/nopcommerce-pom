package pageUIs;

public class UserCheckOutPageUI {
	
	public static final String DYNAMIC_FIELD_AT_BILLING_ADDRESS = "//input[@id='BillingNewAddress_%s']";
	public static final String DYNAMIC_FIELD_AT_SHIPPING_ADDRESS = "//input[@id='ShippingNewAddress_%s']";
	
	public static final String COUNTRY_DROPDOWN_AT_BILLING_ADDRESS = "//select[@id='BillingNewAddress_CountryId']";
	public static final String STATE_DROPDOWN_AT_BILLING_ADDRESS = "//select[@id='BillingNewAddress_StateProvinceId']";
	
	public static final String COUNTRY_DROPDOWN_AT_SHIPPING_ADDRESS = "//select[@id='ShippingNewAddress_CountryId']";
	public static final String STATE_DROPDOWN_AT_SHIPPING_ADDRESS = "//select[@id='ShippingNewAddress_StateProvinceId']";
	
	public static final String ADDRESS_DROPDOWN_AT_SHIPPING_ADDRESS = "//select[@name='shipping_address_id']";
	
	public static final String SAME_ADDRESS_CHECKBOX = "//input[@id='ShipToSameAddress']";

	public static final String CONTINUE_BUTTON_AT_BILLING_ADDRESS = "//div[@id='billing-buttons-container']//input";
	public static final String CONTINUE_BUTTON_AT_SHIPPING_ADDRESS = "//div[@id='shipping-buttons-container']//input";
	public static final String CONTINUE_BUTTON_AT_SHIPPING_METHOD = "//div[@id='shipping-method-buttons-container']//input";
	public static final String CONTINUE_BUTTON_AT_PAYMENT_METHOD = "//div[@id='payment-method-buttons-container']//input";
	public static final String CONTINUE_BUTTON_AT_PAYMENT_INFORMATION = "//div[@id='payment-info-buttons-container']//input";
	public static final String CONFIRM_BUTTON_AT_CONFIRM_ORDER = "//div[@id='confirm-order-buttons-container']//input";
	
	
	
	public static final String BILLING_INFO = "//div[@class='billing-info']//li";
	public static final String PAYMENT_METHOD_INFO = "//div[@class='payment-method-info']//span[@class='value']";
	public static final String SHIPPING_INFO = "//div[@class='shipping-info']//ul/li";
	public static final String SHIPPING_METHOD = "//label[text()='Ground ($0.00)']//preceding-sibling::input";
	public static final String PAYMENT_METHOD = "//label[text()='Check / Money Order']//preceding-sibling::input";
	
	public static final String PAYMENT_INFOR = "//div[@class='section payment-info']";
	
	
	public static final String DYNAMIC_CONFIRM_ORDER_BILLING_ADDRESS = "//div[@class='billing-info']//ul/li[@class='%s']";
	public static final String DYNAMIC_CONFIRM_ORDER_SHIPPING_ADDRESS = "//div[@class='shipping-info']//ul/li[@class='%s']";
	
	public static final String CONFIRM_ORDER_PAYMENT_METHOD = "//li[@class='payment-method']/span[last()]";
	public static final String CONFIRM_ORDER_SHIPPING_METHOD = "//li[@class='shipping-method']/span[last()]";
	
	public static final String CONFIRM_ORDER_PRODUCTS_NAME = "//a[@class='product-name']";
	public static final String CONFIRM_ORDER_PRODUCT_TOTAL_PRICE = "//span[@class='product-subtotal']";
	public static final String CONFIRM_ORDER_TOTAL_BILL = "//tr[@class='order-total']//strong";
	
	public static final String SUCCESS_ORDER_MESSAGE = "//div[@class='section order-completed']/div[@class='title']";
	public static final String ORDER_NUMBER = "//div[@class='section order-completed']//div[@class='order-number']";
	
}
