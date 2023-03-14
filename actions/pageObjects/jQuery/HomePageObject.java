package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject (WebDriver driver) {
		this.driver = driver; 
	}

	public void paginationByPageNumber(String pageNumber) {
		waitForElemetClickable(driver, HomePageUI.PAGINATION_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_BY_PAGE_NUMBER, pageNumber);
	}

	public boolean isPageSelected(String pageNumber) {
		waitForAllElemetsVisible(driver, HomePageUI.SELECTED_PAGE_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.SELECTED_PAGE_NUMBER, pageNumber);
	}

	public void clickDeleteOrEditIconByCountryName(String countryName, String actionName) {
		waitForElemetClickable(driver, HomePageUI.ACTION_ICON, countryName, actionName);
		clickToElement(driver, HomePageUI.ACTION_ICON, countryName, actionName);
		sleepInSecond(3);
	}

	public String getTotalValueByCountryName(String countryName) {
		waitForElemetVisible(driver, HomePageUI.TOTAL_VALUE, countryName);
		return getTextElement(driver, HomePageUI.TOTAL_VALUE, countryName);
	}

	public void sendkeyToDynamicTextboxByRowNumber(String columnName, String rowNumber, String value) {
		//Get index from column
		
		
	}
}
