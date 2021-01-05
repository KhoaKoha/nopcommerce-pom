package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	// để static: truy cập trực tiếp thông qua tên class mà hong cần khởi tạo đối tượng
	
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	
	public static UserCustomerInforPO getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInforPO(driver);
	}
	
	public static UserAddressesPO getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	
	public static UserMyProductReviewPO getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPO(driver);
	}
	
	public static UserOrdersPO getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	
	public static UserSearchPO getUserSearchPage(WebDriver driver) {
		return new UserSearchPO(driver);
	}
	
	public static UserShippingAndReturnPO getUserShippingAndReturnPage(WebDriver driver) {
		return new UserShippingAndReturnPO(driver);
	}
	
	public static UserMyAccountInFooterPO getUserMyAccountInFooterPage(WebDriver driver) {
		return new UserMyAccountInFooterPO(driver);
	}
	
	public static UserSiteMapPO getUserSitemapPage(WebDriver driver) {
		return new UserSiteMapPO(driver);
	}
	
	public static UserWishListInHeaderPO getUserWishlistInHeaderPage(WebDriver driver) {
		return new UserWishListInHeaderPO(driver);
	}
	
	public static UserChangePasswordPO getUserChangePasswordpPage(WebDriver driver) {
		return new UserChangePasswordPO(driver);
	}
	
	public static UserProductDetailPO getUserProductDetailPage(WebDriver driver) {
		return new UserProductDetailPO(driver);
	}
	
	public static UserProductPO getUserProductPage(WebDriver driver) {
		return new UserProductPO(driver);
	}
	
	public static UserProductReviewPO getUserProductReviewPage(WebDriver driver) {
		return new UserProductReviewPO(driver);
	}
	
	public static UserCartPO getUserCartPage(WebDriver driver) {
		return new UserCartPO(driver);
	}

	public static UserComparePO getUserComparePage(WebDriver driver) {
		return new UserComparePO(driver);
	}
	
	public static UserRecentlyViewedPO getUserRecentlyViewedProductPage(WebDriver driver) {
		return new UserRecentlyViewedPO(driver);
	}
	
	public static UserCheckoutPO getUserCheckouttPage(WebDriver driver) {
		return new UserCheckoutPO(driver);
	}
	
	public static UserOrderDetailPO getUserOrderDetailPage(WebDriver driver) {
		return new UserOrderDetailPO(driver);
	}
	
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminProductPO getAdminProductPage(WebDriver driver) {
		return new AdminProductPO(driver);
	}
	
	public static AdminCustomerPO getAdminCustomerPage(WebDriver driver) {
		return new AdminCustomerPO(driver);
	}
	
	public static AdminProductDetailPO getAdminProductDetailPage(WebDriver driver) {
		return new AdminProductDetailPO(driver);
	}
}
