package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.GetTitle;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Javascript_Executor {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
// Nếu 1 interface kế thừa 1 interface thì là extends
// Nếu 1 class kế thừa 1 interface thì là implements
	@Test
	public void TC_01_Guru_Khongdungham() {
		jsExecutor.executeScript("window.location = 'http://live.techpanda.org/'");
		sleepInSecond(3);
		
		String domain = (String) jsExecutor.executeScript("return document.domain");
		System.out.println("Domain: "+domain);
		Assert.assertEquals(domain, "live.techpanda.org");
		
		String url = (String) jsExecutor.executeScript("return document.URL");
		System.out.println("URL: "+url);
		Assert.assertEquals(url, "http://live.techpanda.org/");
		
		WebElement mobileMenu = driver.findElement(By.xpath("//a[text()='Mobile']"));
		jsExecutor.executeScript("arguments[0].click();", mobileMenu);
		sleepInSecond(5);
		
		//WebElement addtocartBt = driver.findElement(By.xpath("//a[@title='Samsung Galaxy']//following-sibling::div//button[@title='Add to Cart']"));
		
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Samsung Galaxy']//following-sibling::div//button[@title='Add to Cart']")) );
		sleepInSecond(5);
	
		Assert.assertEquals(jsExecutor.executeScript("return document.documentElement.innerText.match('Samsung Galaxy was added to your shopping cart.')[0]"), "Samsung Galaxy was added to your shopping cart.");
		
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Customer Service']")));
		sleepInSecond(2);
		
		Assert.assertEquals(jsExecutor.executeScript("return document.title"), "Customer Service");
		
	}

	@Test
	public void TC_02_Guru_Codungham() {
		navigateToUrlByJS("http://live.techpanda.org/");
		sleepInSecond(3);
		
		Assert.assertEquals(getDomainName(), "live.techpanda.org");
		Assert.assertEquals(executeForBrowser("return document.URL;"), "http://live.techpanda.org/");
		
		hightlightElement("//a[text()='Mobile']");
		clickToElementByJS("//a[text()='Mobile']");
		sleepInSecond(3);
		
		hightlightElement("//a[@title='Samsung Galaxy']//following-sibling::div//button[@title='Add to Cart']");
		clickToElementByJS("//a[@title='Samsung Galaxy']//following-sibling::div//button[@title='Add to Cart']");
		sleepInSecond(3);
		
		Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));
		
		scrollToElementOnDown("//a[text()='Customer Service']");
		hightlightElement("//a[text()='Customer Service']");
		sleepInSecond(2);
		clickToElementByJS("//a[text()='Customer Service']");
		sleepInSecond(3);
		
		scrollToElementOnDown("//input[@id='newsletter']");
		hightlightElement("//input[@id='newsletter']");
		sleepInSecond(2);
		
		sendkeyToElementByJS("//input[@id='newsletter']",getRandomEmail());
		hightlightElement("//button[@title='Subscribe']");
		clickToElementByJS("//button[@title='Subscribe']");
		sleepInSecond(3);
		
		Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
		
	}

	@Test
	public void TC_03_validationMessale_ubuntu() {
		
		navigateToUrlByJS("https://login.ubuntu.com/");
		sleepInSecond(5);
		
		String createButton = "//div[@class='create-form show-no-js']//button[@type='submit']";
		String emailTextbox = "//form[@name='newaccountform']//input[@type='email']";
		String fullNameTextbox = "//form[@name='newaccountform']//input[@id='id_displayname']";
		String userNameTextbox = "//form[@name='newaccountform']//input[@id='id_username']";
		String passwordTextbox = "//form[@name='newaccountform']//input[@id='id_password']";
		String confirmPasswordTextbox = "//form[@name='newaccountform']//input[@id='id_passwordconfirm']";
		String acceptCheckbox = "//form[@name='newaccountform']//input[@id='id_accept_tos']";
		
		clickToElementByJS("//button[text()='Accept all and visit site']");
		sleepInSecond(2);
		
		clickToElementByJS("//input[@id='id_new_user']");
		
		clickToElementByJS(createButton);
		sleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(emailTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(emailTextbox, getRandomEmail());
		clickToElementByJS(createButton);
		sleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(fullNameTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(fullNameTextbox, "Tran Thi Yen");
		//clickToElementByJS(createButton);
		//sleepInSecond(2);
		//Assert.assertEquals(getElementValidationMessage(userNameTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(userNameTextbox, "yentt01");
		clickToElementByJS(createButton);
		sleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(passwordTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(passwordTextbox, "Yentran18197");
		clickToElementByJS(createButton);
		sleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(confirmPasswordTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(confirmPasswordTextbox, "Yentran18197");
		clickToElementByJS(createButton);
		sleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(acceptCheckbox), "Please check this box if you want to proceed.");
		
		clickToElementByJS(acceptCheckbox);
	}
	
	@Test
	public void TC_04_validationMessage_sieuthimaymocthietbi() {
		
		navigateToUrlByJS("https://sieuthimaymocthietbi.com/account/register");
		sleepInSecond(5);
		
		String registerButton = "//button[@value='Đăng ký']";
		String lastNameButton = "//input[@id='lastName']";
		String firstNameButton = "//input[@id='firstName']";
		String emailTextbox = "//input[@id='email']";
		String passwordTextbox ="//input[@id='password']";
		
		
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(lastNameButton), "Please fill out this field.");
		
		sendkeyToElementByJS(lastNameButton, "Yen");
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(firstNameButton), "Please fill out this field.");
		
		sendkeyToElementByJS(firstNameButton, "Tran");
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(emailTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(emailTextbox, getRandomEmail());
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(passwordTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(passwordTextbox, "Yentran18197");
	}	
	
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}
	
	public String getDomainName() {
		return (String) jsExecutor.executeScript("return document.domain");
		
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(locator));
		return status;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	public String getRandomEmail() {
		
		Random random = new Random();
		return "yentran"+random.nextInt(99999)+"@gmail.com";
		
	}

	//Sleep cứng (Static wait)
		public void sleepInSecond(long timeInSecond) {
			try {
			Thread.sleep(timeInSecond*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}