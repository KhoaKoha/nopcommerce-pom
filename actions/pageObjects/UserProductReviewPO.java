package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserProductReviewPageUI;

public class UserProductReviewPO extends AbstractPage{
	WebDriver driver;

	public UserProductReviewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTitleReview(String titleReview) {
		sendKeyToElement(driver, UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX, titleReview);
		
	}

	public void inputToTextReview(String textReview) {
		sendKeyToElement(driver, UserProductReviewPageUI.REVIEW_TEXT_TEXTBOX, textReview);
		
	}

	public void clickToRating() {
		waitForElementClickable(driver, UserProductReviewPageUI.RATING_RADIO);
		clickToElement(driver, UserProductReviewPageUI.RATING_RADIO);
		
	}

	public void clickToSubmitReview() {
		waitForElementClickable(driver, UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}
	
	public String getResultMessage() {
		return getElementText(driver, UserProductReviewPageUI.RESULT_MESSAGE);
	}

	public UserCustomerInforPO clickToMyAccountLink() {
		waitForElementClickable(driver, UserProductReviewPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserProductReviewPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

}
