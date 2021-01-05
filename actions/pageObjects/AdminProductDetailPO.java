package pageObjects;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminProductDetailPageUI;
import pageUIs.UserProductDetailPageUI;

public class AdminProductDetailPO extends AbstractPage {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	
	public AdminProductDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductNameField() {
		return getElementAttribute(driver, AdminProductDetailPageUI.PRODUCT_NAME, "value");
	}



	




	

}
