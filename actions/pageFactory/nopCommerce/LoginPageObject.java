package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstnameTextbox;
	
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement lasttnameTextbox;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']//li")
	private WebElement existingEmailErrorMessage;
	
	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement loginUnsuccessMessage;
	
	public void clickToLoginButton() {
		waitForElemetClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}
	
	public void inputToEmailTextbox(String emailAddess) {
		waitForElemetVisible(driver,emailTextbox);
		sendKeyToElement(driver, emailTextbox, emailAddess);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElemetVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElemetVisible(driver, emailErrorMessage);
		return getTextElement(driver, emailErrorMessage);
	}

	public String getLoginUnsuccessErrorMessage() {
		waitForElemetVisible(driver, loginUnsuccessMessage);
		return getTextElement(driver, loginUnsuccessMessage);
	}

}
