package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserMyProductReviewPageUI;

public class UserMyProductReviewPO extends AbstractPage{
	WebDriver driver;

	public UserMyProductReviewPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean getTitleReviewed() {
		return isElementDisplayed(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
	}

}
