package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.UserRecentlyViewedProductPageUI;

public class UserRecentlyViewedPO extends AbstractPage {
	WebDriver driver;

	public UserRecentlyViewedPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplay3FinalItems() {
		String valueExpected[] = { getElementText(driver, UserRecentlyViewedProductPageUI.HP_LINK), getElementText(driver, UserRecentlyViewedProductPageUI.LENOVO_LINK), getElementText(driver, UserRecentlyViewedProductPageUI.SAMSUNG_LINK) };
		return checkDisplay3Items(valueExpected, UserRecentlyViewedProductPageUI.NAME_PRODUCTS, 3);
	}

	public boolean checkDisplay3Items(String[] valueExpected, String parentLocatorValueActual, int numberOfItemsDisplay) {
		boolean check1 = false;
		int check2 = 0;
		List<WebElement> listItems = getElements(driver, parentLocatorValueActual);
		List<String> stringItems = new ArrayList<String>();
		for (WebElement e : listItems) {
			stringItems.add(e.getText());
		}
		String[] listToArray = stringItems.toArray(new String[stringItems.size()]);

		for (int i = 0; i < listToArray.length; i++) {
			for (int j = 0; j < valueExpected.length; j++) {
				if (listToArray[i].equals(valueExpected[j])) {
					check2 ++;
				}
			}
		}
		
		if (check2 == numberOfItemsDisplay ) {
			check1 = true;
		}
		else {
			check1 = false;
		}
		return check1;
		
	}

}
