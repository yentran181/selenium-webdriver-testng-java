package com.jquery.datatable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.nopCommerce.user.PageGeneraterManager;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptionsPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointsPageObject;
import pageUIs.jQuery.HomePageUI;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	String pageNumber;

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = new HomePageObject(driver);
		pageNumber = "11";

	}
	
	@Test
	public void Table_01_PaginationByPageNumber() {
		homePage.paginationByPageNumber("11");
		homePage.isPageSelected("11");
	}
	@Test
	public void Table_01_Edit_Row() {
		homePage.clickDeleteOrEditIconByCountryName("Afghanistan", "remove");
		homePage.clickDeleteOrEditIconByCountryName("Afghanistan", "edit");

	}
	
	@Test
	public void Table_03_Total_Value() {
		System.out.println(homePage.getTotalValueByCountryName("Argentina"));

	}
	
	@Test
	public void Table_04_Sendkey_To_Textbox() {
		homePage.sendkeyToDynamicTextboxByRowNumber();
	}
	
}
