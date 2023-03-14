package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGINATION_BY_PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page-link']//a[text()='%s']";
	public static final String SELECTED_PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page-link active']//a[text()='%s']";
	public static final String ACTION_ICON = "//td[@data-key='country' and text()='%s']//preceding-sibling::td[@class='qgrd-actions']//button[contains(@class,'%s')]";
	public static final String TOTAL_VALUE = "//td[@data-key='country' and text()='%s']//following-sibling::td[@data-key='total']";
}
