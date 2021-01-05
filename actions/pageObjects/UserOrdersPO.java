package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCheckOutPageUI;
import pageUIs.UserOrderPageUI;

public class UserOrdersPO extends AbstractPage {
	WebDriver driver;

	public UserOrdersPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean compareOrderNumber(String orderNumber) {
		if (getNumberOrder(getElementText(driver, UserOrderPageUI.ORDER_NUMBER).trim()).equalsIgnoreCase(orderNumber)) {
			return true;
		} else {
			return false;
		}
	}

	public UserOrderDetailPO clickToDetail() {
		clickToElement(driver, UserOrderPageUI.DETAIL_LINK);
		return PageGeneratorManager.getUserOrderDetailPage(driver);
	}
	public String getNumberOrder(String texta) {
		return texta.substring(texta.length()-4);
	}
	

}
