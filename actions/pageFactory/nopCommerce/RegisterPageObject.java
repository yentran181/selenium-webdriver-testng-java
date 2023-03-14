package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstnameTextbox;
	
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement lastnameTextbox;
	
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

	
	public void clickToRegisterButton() {
		waitForElemetClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElemetVisible(driver, firstNameErrorMessage);
		return getTextElement(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLasttnameTextbox() {
		waitForElemetVisible(driver, lastNameErrorMessage);
		return getTextElement(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElemetVisible(driver, emailErrorMessage);
		return getTextElement(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElemetVisible(driver, passwordErrorMessage);
		return getTextElement(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElemetVisible(driver, confirmPasswordErrorMessage);
		return getTextElement(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstnameTextbox(String firstname) {
		waitForElemetVisible(driver, firstnameTextbox);
		sendKeyToElement(driver,firstnameTextbox, firstname);
		
	}

	public void inputToLastnameTextbox(String lastname) {
		waitForElemetVisible(driver, lastnameTextbox);
		sendKeyToElement(driver,lastnameTextbox, lastname);

	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElemetVisible(driver, emailTextbox);
		sendKeyToElement(driver,emailTextbox, emailAddress);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElemetVisible(driver, passwordTextbox);
		sendKeyToElement(driver,passwordTextbox, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElemetVisible(driver, confirmPasswordTextbox);
		sendKeyToElement(driver,confirmPasswordTextbox, confirmPassword);
		
	}

	public String getRegisterSuccessMessage() {
		waitForElemetVisible(driver, registerSuccessMessage);
		return getTextElement(driver, registerSuccessMessage);
	}

	public String getErrorExistingEmailMessage() {
		waitForElemetVisible(driver, existingEmailErrorMessage);
		return getTextElement(driver, existingEmailErrorMessage);
	}

	public void clickToLogoutButton() {
		waitForElemetClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

}
