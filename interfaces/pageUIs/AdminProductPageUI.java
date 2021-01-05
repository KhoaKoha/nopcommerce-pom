package pageUIs;

public class AdminProductPageUI {
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String PROUCTS_NAME_LIST_IN_TABLE = "//table[@id='products-grid']/tbody/tr/td[3]";
	public static final String CATEGORY_DROP_DOWN = "//select[@id='SearchCategoryId']";
	public static final String NO_DATA_MESSAGE = "//td[@class='dataTables_empty']";
	public static final String SUB_CATEGORIES_CHECKBOX = "//input[@id='SearchIncludeSubCategories']";
	public static final String MANUFACTURER_DROPDOWN = "//select[@id='SearchManufacturerId']";
	public static final String SKU_TEXTBOX = "//input[@id='GoDirectlyToSku']";
	public static final String GO_SKU_BUTTON = "//button[@id='go-to-product-by-sku']";

	public static final String PAGING_AT_TABLE_BY_INDEX = "//li[@class='paginate_button ']/a[text()='%s']";
	public static final String PAGING_AT_TABLE_ACTIVE_BY_INDEX = "//li[@class='paginate_button active']/a[text()='%s']";

	public static final String CHECKBOX_SELECT_ALL = "//th/input[@id='mastercheckbox']";

	public static final String ALL_CHECKBOX = "//tbody//input[@name='checkbox_products']";
	public static final String CHECKBOX_AT_PER_PRODUCTS = "//td[text()='%s']/preceding-sibling::td/input";

	public static final String PRODUCT_DETAIL_IN_TABLE = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[contains(@class,'%s-icon')]";

}
