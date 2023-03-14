package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	//PageUI
	@CacheLookup //sau khi tìm đc element sẽ lưu cache và sử dụng cho lần sau mà k cần tìm lại element (DOM không bị change, rrefresh lại)
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	
	//Actions
	public void clickToRegisterLink() {
		waitForElemetClickable(driver, registerLink);
		clickToElement(driver, registerLink );
	}
	public void clickToLoginLink() {
		waitForElemetClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElemetVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}
}
