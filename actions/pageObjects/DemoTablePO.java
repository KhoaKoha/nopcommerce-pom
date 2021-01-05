package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DemoTablePageUI;

public class DemoTablePO extends AbstractPage {
	WebDriver driver;

	public DemoTablePO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputDataAtRow(String rowNumber, String company, String contactPerson, String country, String NPO, String orderPlaced, String memberSince) {
		sendKeyToElement(driver, company, DemoTablePageUI.COMPANY_TEXTBOX, rowNumber);
		sendKeyToElement(driver, contactPerson, DemoTablePageUI.CONTACT_PERSON_TEXTBOX, rowNumber);
		selectItemByVisible(driver, country, DemoTablePageUI.COUNTRY_DROPDOWN, rowNumber);
		if (NPO.equals("true")) {
			checkToCheckBox(driver, DemoTablePageUI.NPO_CHECKBOX, rowNumber);
		}
		sendKeyToElement(driver, orderPlaced, DemoTablePageUI.ORDER_PLACED_TEXTBOX, rowNumber);

		sendKeyToElement(driver, memberSince, DemoTablePageUI.MEMBER_SINCE_TEXTBOX, rowNumber);

	}

	public void inputToDynamicTextboxByRowNumber(String columnName, String rowIndex, String textData) {
		String column = String.valueOf(getSizeElements(driver, DemoTablePageUI.COLUMNS_NAME_AT_TABLE, columnName) + 1);
		String cell = castToParameter(DemoTablePageUI.CELL_TEXTBOX_AT_TABLE, rowIndex, column);
		sendKeyToElement(driver, cell, textData);
	}

	
	public void checkToCheckboxByRowNumber(String columnName, String rowIndex, String textData) {
		String column = String.valueOf(getSizeElements(driver, DemoTablePageUI.COLUMNS_NAME_AT_TABLE, columnName) + 1);
		String cell = castToParameter(DemoTablePageUI.CELL_CHECKBOX_AT_TABLE, rowIndex, column);
		if (textData.equals("true")) {
			checkToCheckBox(driver, cell);
		}
	}

	
	public void selectInDrodownByRowNumber(String columnName, String rowIndex, String textData) {
		String column = String.valueOf(getSizeElements(driver, DemoTablePageUI.COLUMNS_NAME_AT_TABLE, columnName) + 1);
		String cell = castToParameter(DemoTablePageUI.CELL_SELECT_AT_TABLE, rowIndex, column);
		selectItemByVisible(driver, textData, cell);
	}

}
