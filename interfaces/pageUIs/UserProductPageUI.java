package pageUIs;

public class UserProductPageUI {
	public static final String APPLE_MACBOOK_LINK = "//h2[@class='product-title']//a[text()='Apple MacBook Pro 13-inch']";
	public static final String ASUS_LINK = "//h2[@class='product-title']//a[text()='Asus N551JK-XO076H Laptop']";
	public static final String HP_LINK = "//h2[@class='product-title']//a[text()='HP Envy 6-1180ca 15.6-Inch Sleekbook']";
	public static final String LENOVO_LINK = "//h2[@class='product-title']//a[text()='Lenovo Thinkpad X1 Carbon Laptop']";
	public static final String SAMSUNG_LINK = "//h2[@class='product-title']//a[text()='Samsung Series 9 NP900X4C Premium Ultrabook']";

	public static final String NAME_PRODUCT_DYNAMIC = "//h2[@class='product-title']/a[text()='%s']";
	
	
	// Sort By 
		public static final String SORT_BY_DROPDOWN = "//select[@id='products-orderby']";
		public static final String NAME_A_TO_Z = "//select[@id='products-orderby']//option[text()='Name: A to Z']";
		public static final String NAME_Z_TO_A = "//select[@id='products-orderby']//option[text()='Name: Z to A']";
		public static final String PRICE_LOW_TO_HIGH = "//select[@id='products-orderby']//option[text()='Price: Low to High']";
		public static final String PRICE_HIGH_TO_LOW = "//select[@id='products-orderby']//option[text()='Price: High to Low']";
		
		
		// Result Sort By
		public static final String LIST_PRODUCTS_NAME_AFTER_SORT = "//h2[@class='product-title']/a";
		public static final String LIST_PRODUCTS_PRICE_AFTER_SORT = "//span[@class='price actual-price']";
		
		// Display Dropdown 
		public static final String DISPLAY_DROPDOWN = "//select[@id='products-pagesize']";
		public static final String DISPLAY_3_ITEMS_DROPDOWN = "//select[@id='products-pagesize']//option[text()='3']";
		public static final String DISPLAY_6_ITEMS_DROPDOWN = "//select[@id='products-pagesize']//option[text()='6']";
		public static final String DISPLAY_9_ITEMS_DROPDOWN = "//select[@id='products-pagesize']//option[text()='9']";
		public static final String LIST_PRODUCTS_DISPLAY = "//h2[@class='product-title']/a";
		
		// Paging 
		public static final String CURRENT_PAGE = "//li[@class='current-page']/span";
		public static final String PAGE_2 = "//li[@class='individual-page']/a";
		public static final String NEXT_PAGE = "//li[@class='next-page']/a";
		public static final String PREVIOUS_PAGE = "//li[@class='previous-page']/a";
		public static final String PAGING = "//div[@class='pager']";
}
