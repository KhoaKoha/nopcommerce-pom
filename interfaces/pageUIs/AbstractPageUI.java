package pageUIs;

public class AbstractPageUI {
	public static final String CUSTOMER_INFOR_LINK = "//div[@class='listbox']//a[text()='Customer info']";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static final String ORDERS_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static final String MY_PRODUCT_REVIEW_LINK = "//div[@class='listbox']//a[text()='My product reviews']";
	public static final String SEARCH_LINK = "//div[@class='footer']//a[text()='Search']";
	public static final String SITE_MAP_LINK = "//div[@class='footer']//a[text()='Sitemap']";
	public static final String RECENTLY_VIEWS_LINK = "//div[@class='footer']//a[text()='Recently viewed products']";
	public static final String WISHLIST_IN_HEADER_LINK = "//a[@class='ico-wishlist']";
	public static final String MY_ACCOUNT_IN_FOOTER_LINK = "//div[@class='footer']//a[text()='My account']";
	public static final String SHIPPING_AND_RETURN_LINK = "//div[@class='footer']//a[text()='Shipping & returns']";
	public static final String HOME_PAGE_LINK = "//div[@class='header-logo']//a";
	public static final String CHANGE_PASSWORD_LINK = "//div[@class='listbox']//a[text()='Change password']";
	public static final String CART_LINK = "//li[@id='topcartlink']";
	public static final String CART_LINK_IN_FOOTER = "//div[@class='footer-block my-account']//a[text()='Shopping cart']";
	
	public static final String DYNAMIC_LINK = "//div[@class='listbox']//a[text()='%s']";
	
	
	// Menu Navigation
	public static final String COMPUTER_MENU = "//ul[@class='top-menu notmobile']//a[text()='Computers ']";
	public static final String NOTEBOOKS_SUBMENU = "//ul[@class='top-menu notmobile']//a[text()='Notebooks ']";
	
	// Icon in header
	public static final String QUALITY_ITEMS_AT_CART_ICON = "//li[@id='topcartlink']//span[@class='cart-qty']";

	//NAV
	public static final String MENU_IN_NAV_LINK = "//ul[@class='top-menu notmobile']/li/a[contains(string(),'%s')]";
	public static final String SUB_MENU_IN_NAV_LINK = "//ul[@class='top-menu notmobile']//ul[@class='sublist first-level']//a[contains(string(),'%s')]";


	public static final String LOADING_ICON_AJAX = "//div[@id='ajaxBusy']/span";
}
