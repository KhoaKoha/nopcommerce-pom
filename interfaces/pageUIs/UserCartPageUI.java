package pageUIs;

public class UserCartPageUI {
	public static final String SHOPPING_CART_TITLE_PAGE = "//div[@class='page shopping-cart-page']//h1";
	public static final String NAME_PRODUC_IN_CART = "//td[@class='product']/a[@class='product-name']";
	
	public static final String QUALITY_IN_WISHLIST_ICON = "//a[@class='ico-wishlist']//span[@class='wishlist-qty']";
	
	
	public static final String EDIT_LINK = "//div[@class='edit-item']//a";

	public static final String REMOVE_CHECKBOX = "//input[@name='removefromcart']";
	public static final String UPDATE_CART_BUTTON = "//input[@value='Update shopping cart']";
	public static final String EMPTY_CART_MESSAGE = "//div[@class='no-data']";
	
	public static final String PRODUCTS_NAME_IN_CART = "//table[@class='cart']//a[@class='product-name']";
	public static final String QUALITY_TEXBOX = "//input[@class='qty-input']";
	public static final String TOTLA_PRICE_PER_ITEMS = "//td[@class='subtotal']/span";
	
	
	public static final String GIFT_WRAPPING_DROPDOWN = "//select[@id='checkout_attribute_1']";
	public static final String TERMS_CHECKBOX = "//input[@id='termsofservice']";
	public static final String CHECK_OUT_BUTTON = "//button[@id='checkout']";
	
}
