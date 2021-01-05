package pageUIs;

public class DemoTablePageUI {
	public static final String ROW_NUMBER = "//td[@id='tblAppendGrid_$rowNum_%s']"; 
	public static final String COMPANY_TEXTBOX = "//input[@id='tblAppendGrid_company_%s']"; 
	public static final String CONTACT_PERSON_TEXTBOX = "//input[@id='tblAppendGrid_name_%s']"; 
	public static final String COUNTRY_DROPDOWN = "//select[@id='tblAppendGrid_country_%s']"; 
	public static final String NPO_CHECKBOX = "//input[@id='tblAppendGrid_isNPO_%s']"; 
	public static final String ORDER_PLACED_TEXTBOX = "//input[@id='tblAppendGrid_orderPlaced_%s']"; 
	public static final String MEMBER_SINCE_TEXTBOX = "//input[@id='tblAppendGrid_memberSince_%s']"; 
	
	public static final String ROWS_AT_TABLE = "//tbody/tr"; 
	public static final String COLUMNS_NAME_AT_TABLE = "//thead//th[contains(text(), '%s')]/preceding-sibling::th"; 
	
	public static final String CELL_TEXTBOX_AT_TABLE = "//tbody/tr[%s]/td[%s]/input"; 
	public static final String CELL_SELECT_AT_TABLE = "//tbody/tr[%s]/td[%s]//select"; 
	public static final String CELL_CHECKBOX_AT_TABLE = "//tbody/tr[%s]/td[%s]//label[@class='checkbox']/input"; 
	
	
	
	
}
