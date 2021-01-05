package pageUIs;

public class UserSearchPageUI {
	public static final String SEARCH_BUTTON = "//input[@class='button-1 search-button']";
	public static final String DATA_EMPTY_ERROR_MESSAGE = "//div[@class='warning']";
	public static final String DATA_NO_EXIST_ERROR_MESSAGE = "//div[@class='no-result']";
	public static final String SEARCH_TEXTBOX = "//div[@class='inputs']/input";
	public static final String RESULT_SEARCH_PRODUCTS = "//h2[@class='product-title']/a";
	
	public static final String ADVANCED_SEACH_CHECKBOX = "//input[@id='adv']";
	public static final String CATEGORY_DROPDOWN = "//select[@id='cid']";
	public static final String SUB_CATEGORY_COMPUTER_DROPDOWN = "//select[@id='cid']//option[text()='Computers']";
	public static final String AUTOMATICALLY_SEARCH_CHECKBOX = "//input[@id='isc']";
	public static final String MANUFACTURER_DROPDOWN = "//select[@id='mid']";
	public static final String SUB_MANUFACTURER_APPLE_DROPDOWN = "//select[@id='mid']/option[text()='Apple']";
	public static final String SUB_MANUFACTURER_HP_DROPDOWN = "//select[@id='mid']/option[text()='HP']";
	
	public static final String PRICE_FROM_TEXTBOX = "//input[@class='price-from']";
	public static final String PRICE_TO_TEXTBOX = "//input[@class='price-to']";
	public static final String RESULT_PRICE_PRODUCTS = "//div[@class='product-item']//div[@class='details']//span[@class='price actual-price']";
	
	
}
