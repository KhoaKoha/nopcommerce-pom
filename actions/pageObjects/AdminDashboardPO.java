package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminDashboardPageUI;

public class AdminDashboardPO extends AbstractPage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}



	public AbstractPage clickToSubNavMenu(String nav, String subNav) {
		waitForElementClickable(driver, AdminDashboardPageUI.DYNAMIC_NAV_MENU, nav);
		clickToElement(driver, AdminDashboardPageUI.DYNAMIC_NAV_MENU, nav);
		clickToElement(driver, AdminDashboardPageUI.DYNAMIC_SUB_NAV_MENU, nav, subNav);
		
		switch (subNav) {
		case "Products":
			return PageGeneratorManager.getAdminProductPage(driver);
		default:
			return  PageGeneratorManager.getAdminCustomerPage(driver);
		}
	}

}
