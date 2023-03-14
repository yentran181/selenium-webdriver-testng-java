package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.PageGeneraterManager;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptionsPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserRewardPointsPageObject;
import pageUIs.nopCommerce.user.BasePageUI;

public class BasePage {
	
	protected static BasePage getBasePage() {
		return new BasePage();
	}

 	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl); 
	}
	
	protected String getTitlePage(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	//Tối ưu ở Level_07_Switch_Page
	public UserCustomerInforPageObject openCustomerInforPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFOR_LINK);
		return PageGeneraterManager.getUserCustomerInfoPage(driver);
	}
	
	public UserCustomerAddressesPageObject openCustomerAddressesPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.ADĐRESES_LINK);
		clickToElement(driver, BasePageUI.ADĐRESES_LINK);
		return PageGeneraterManager.getUserAddressesPage(driver);
	}

	protected UserOrdersPageObject openOrdersPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.ORDERS_LINK);
		clickToElement(driver, BasePageUI.ORDERS_LINK);
		return PageGeneraterManager.getUserOrdersPageObject(driver);
	}
	
	protected UserDownloadableProductsPageObject openDownloadableProductsPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
		clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
		return PageGeneraterManager.getUserDownloadableProductsPage(driver);
	}
	
	protected UserBackInStockSubscriptionsPageObject openBackInStockSubscriptionsPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
		clickToElement(driver, BasePageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
		return PageGeneraterManager.getUserBackInStockSubscriptionsPage(driver);
	}
	
	protected UserRewardPointsPageObject openRewardPointsPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.REWARD_POINTS_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINTS_LINK);
		return PageGeneraterManager.getUserRewardPointsPage(driver);
	}
	
	protected UserChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		return PageGeneraterManager.getUserChangePasswordPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneraterManager.getUserMyProductReviewPage(driver);
	}
	
	//Tối ưu bài Level_09_Dynamic_Locator
	public BasePage openPageAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElemetClickable(driver, BasePageUI.PAGE_AT_MY_ACCOUNT_DYNAMIC_LINK, pageName);
		clickToElement(driver, BasePageUI.PAGE_AT_MY_ACCOUNT_DYNAMIC_LINK, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneraterManager.getUserCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneraterManager.getUserAddressesPage(driver);
		case "Orders":
			return PageGeneraterManager.getUserOrdersPageObject(driver);
		case "Downloadable products":
			return PageGeneraterManager.getUserDownloadableProductsPage(driver);
		case "Back in stock subscriptions":
			return PageGeneraterManager.getUserBackInStockSubscriptionsPage(driver);
		case "Reward points":
			return PageGeneraterManager.getUserRewardPointsPage(driver);
		case "Change password":
			return PageGeneraterManager.getUserChangePasswordPage(driver);
		case "My product reviews":
			return PageGeneraterManager.getUserMyProductReviewPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My account area!");
		}
	}
	
	//Tối ưu ở Level_08_Switch_Role
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		return PageGeneraterManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneraterManager.getAdminLoginPage(driver);
	}
	
	private Alert waitForAlertPresent(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresent(driver).accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresent(driver).dismiss();
	}

	protected String getTextAlert(WebDriver driver) {
		return waitForAlertPresent(driver).getText();
	}

	protected void senkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresent(driver).sendKeys(textValue);
	}
		
	protected void switchToWindowByID(WebDriver driver, String parentPageWindowID) {
		Set <String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentPageWindowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	protected void switchToWindowbyTitle(WebDriver driver, String windowTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(windowTitle)) {
				break;
			}
		}
	}

	protected void closeAllWindowsWithoutParent(WebDriver driver, String parentPageWindowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentPageWindowID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentPageWindowID);
		}
	}
	
	private By getByLocator(String locatorType) {
		By by = null;
		System.out.println("Locator type: " + locatorType);
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else
			throw new RuntimeException("Locator type is not supported!");
		return by;
	}
	
	private WebElement getWebElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return driver.findElement(getByLocator(castRestParameter(dynamicLocator, dynamicValues)));
	}
	
	private List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	
	public String castRestParameter(String dynamicLocator, String... dynamicValues) {
		dynamicLocator = String.format(dynamicLocator,(Object[])dynamicValues);
		return dynamicLocator;
	}

	protected void clickToElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).click();
	}
	
	protected void sendKeyToElement(WebDriver driver, String inputValue, String dynamicLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		element.clear();
		element.sendKeys(inputValue);
	}
	
	protected String getTextElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).getText();
	}
	
	protected void selectItemInDefaultDropdown(WebDriver driver, String textItem, String dynamicLocator, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
		select.selectByValue(textItem);
	}

	protected String getSelectedItemInDefaultDropdown(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
		return select.getFirstSelectedOption().getText();
	}

	protected boolean isDropdownMultiple(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
		return select.isMultiple();
	}
	
	protected void selectItemInCustomDropdown(WebDriver driver, String expectedTextItem, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).click();
		sleepInSecond(1);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedTextItem)) {
				jsExecutor.executeScript("arguments[0].scrollInToView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	protected String getAttributeValue(WebDriver driver, String attributeName, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).getAttribute(attributeName);
	}

	protected String getCSSValue(WebDriver driver, String propertyName, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).getCssValue(propertyName);
	}
	
	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	protected int getElementSize(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return getListWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).size();
	}

	protected void checkToCheckboxOrRadio (WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckToCheckboxOrRadio (WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).isDisplayed();
	}
	
	protected boolean isElementSelected(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).isSelected();
	}

	protected boolean isElementEnabled(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues )).isEnabled();
	}

	protected void switchToFrameIframe(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		driver.switchTo().frame(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues )));
	}
	
	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues))).perform();	
	}
	
	protected void pressKeyToElement(WebDriver driver, String dynamicLocator, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)),key).perform();	 
	}
	
	protected void doubleClickToElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues ))).perform();
		
	}
	
	protected void rightClickToElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.contextClick(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues))).perform();
		
	}

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
	}

	protected void scrollToElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
	}

	protected void removeAttributeInDOM(WebDriver driver, String attributeRemove, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
	}

	protected boolean isImageLoaded(WebDriver driver, String dynamicLocator, String dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void waitForElemetVisible(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
	}
	
	protected void waitForAllElemetsVisible(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
	}
	
	protected void waitForElemetInvisible(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
	}
	
	protected void waitForAllElemetsInvisible(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, castRestParameter(dynamicLocator, dynamicValues))));
	}

	protected void waitForElemetClickable(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
	}
	
	protected void sleepInSecond(long timeInSecond) {
		try {
		Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}

	private long longTimeout = GlobalConstants.LONG_TIMEOUT;

}
