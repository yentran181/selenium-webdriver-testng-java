package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Popup {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	Select select;
	List<WebElement> allItems;
	JavascriptExecutor jsExecutor;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 30);
		//driver.manage().window().setSize(new Dimension(1920,1080));
		driver.manage().window().maximize();
		}
	//Cách xử lý Popup trong Selenium
	// 1. Có hiển thị trong HTML khi Popup chưa được mở/bị đóng
		// findElement-> isDisplayed để kiểm tra -> true -> Close
		// findElements -> check số lượng element > 0 -> true -> Close
	// 2. Không hiểm thị trong HTML khi Popup chưa được mở/bị đóng 
		// findElement -> isDisplayed để kiểm tra -> false -> next step
		// findElements -> check số lượng element > 0 -> true -> next step
	@Test
	public void TC_01_() {
		driver.get("https://ngoaingu24h.vn/");
		By loginPopup = By.xpath("//div[@id='modal-login-v1'][1]");
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
		driver.findElement(By.cssSelector("button.login_.icon-before")).click();
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
		driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#account-input")).sendKeys("yentran");
		driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#password-input")).sendKeys("12345678");
		driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button[data-text='Đăng nhập']")).click();
		sleepInSecond(1);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.row.error-login-panel")).getText(),"Tài khoản không tồn tại!");
	
			
	}

	@Test
	public void TC_02_Zingpoll_Login() {
		driver.get("https://zingpoll.com/");
		By loginPopup1 = By.cssSelector("div[id='Login'] div.modal-content");
		Assert.assertFalse(driver.findElement(loginPopup1).isDisplayed());
		driver.findElement(By.cssSelector("a#Loginform")).click();
		Assert.assertTrue(driver.findElement(loginPopup1).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("input#existUser")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input#newUser")).isSelected());
		
		driver.findElement(By.cssSelector("button#button-login")).click();
		sleepInSecond(5);
		Assert.assertEquals(driver.findElement(By.cssSelector("small[data-bv-for='email'][data-bv-validator='notEmpty']")).getText(), "Please enter your email.");
		Assert.assertEquals(driver.findElement(By.cssSelector("small[data-bv-for='password'][data-bv-validator='notEmpty']")).getText(), "Please enter your password");
		
		
		driver.findElement(By.cssSelector("input#loginEmail")).sendKeys("yentran181978@gmail.com");
		driver.findElement(By.cssSelector("input#loginPassword")).sendKeys("1234abcd");
		driver.findElement(By.cssSelector("button#button-login")).click();
		driver.findElement(By.cssSelector("button#button-login")).click();
		sleepInSecond(2);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("small#loginMessage")).getText(), "This email is not registered.");
		
		driver.findElement(By.cssSelector("button[class='close'][onclick]")).click();
		
		Assert.assertFalse(driver.findElement(loginPopup1).isDisplayed());
		
		
	}
	
	@Test
	public void TC_03_Facebook_Register() {
		driver.get("https://www.facebook.com/");
		By loginPopup1 = By.xpath("//div[text()='Sign Up']/parent::div/parent::div");
		Assert.assertEquals(driver.findElements(loginPopup1).size(),0);
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Assert.assertTrue(driver.findElement(loginPopup1).isDisplayed());
		sleepInSecond(1);
		
		//Click x
		driver.findElement(By.cssSelector("img._8idr.img")).click();
		sleepInSecond(1);
		
		Assert.assertEquals(driver.findElements(loginPopup1).size(),0);
		
	}

	@Test
	public void TC_04_Javacodegeeks() {
		driver.get("https://www.javacodegeeks.com/");
		sleepInSecond(10);
		WebElement radomPopup= driver.findElement(By.cssSelector("div[data-type='rectangle'][style]"));
		if (radomPopup.isDisplayed()) {
			System.out.println("Có xuất hiện popup");
			driver.findElement(By.xpath("//div[@data-type='rectangle'and@style]//following-sibling::div//input[@type='email']")).sendKeys(getRandomEmail());
			driver.findElement(By.xpath("//div[@data-type='rectangle'and@style]//following-sibling::div//a[@data-label='Get the Books']")).click();
			Assert.assertTrue(radomPopup.isDisplayed());
		} 
		driver.findElement(By.cssSelector("input#s")).sendKeys("selenium");
		sleepInSecond(2);
		driver.findElement(By.cssSelector("button.search-button")).click();
		sleepInSecond(10);
			
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='post-listing ']//article[@class='item-list item_1']//a[contains(text(),'Selenium')]")).isDisplayed());
		sleepInSecond(1);
		
	}
	
	@Test
	public void TC_05_vnkedu() {
		driver.get("https://vnk.edu.vn/");
		sleepInSecond(15);
		WebElement radomPopup1= driver.findElement(By.cssSelector("div.tve-page-section-in.tve_empty_dropzone>div.thrv_wrapper.thrv-columns "));
		if (radomPopup1.isDisplayed()) {
			System.out.println("Có xuất hiện popup");
			driver.findElement(By.cssSelector("div.tve-page-section-in.tve_empty_dropzone>div[data-float='1']")).click();
			Assert.assertFalse(radomPopup1.isDisplayed());
		} 
		System.out.println("Không xuất hiện popup");
		Assert.assertFalse(radomPopup1.isDisplayed());
		
		sleepInSecond(1);
		
	}
	
	@Test
	public void TC_06_dehieu() {
		driver.get("https://dehieu.vn/");
		sleepInSecond(10);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[data-testid='dialog_iframe']")));
		driver.findElement(By.cssSelector("div._9q4i div._a3x9 div[role=button]")).click();
		driver.switchTo().defaultContent();
		//driver.findElement(By.cssSelector("div._9q4i div._a3x9 div[role=button]")).click();
		int radomPopup2= driver.findElements(By.cssSelector("div.popup-content")).size();
		if (radomPopup2 == 1) {
			System.out.println("Có hiển thị popup");
			driver.findElement(By.cssSelector("input#popup-name")).sendKeys("Yen Tran");
			driver.findElement(By.cssSelector("input#popup-email")).sendKeys(getRandomEmail());
			driver.findElement(By.cssSelector("input#popup-phone")).sendKeys("0987654321");
			//driver.findElement(By.xpath("//button[contains(text(),'ĐĂNG KÝ NHẬN MÃ GIẢM GIÁ')]")).click();
			driver.findElement(By.cssSelector("button#close-popup")).click();
			
		} else {
			System.out.println("Không hiển thị popup");
		} 
		
		//driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Tất cả khóa học']")).click();
		sleepInSecond(10);
		//jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("div._9q4i div._a3x9 div[role=button]")));
		Assert.assertEquals(driver.getCurrentUrl(), "https://dehieu.vn/khoa-hoc");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[data-testid='dialog_iframe']")));
		driver.findElement(By.cssSelector("div._9q4i div._a3x9 div[role=button]")).click();
		driver.switchTo().defaultContent();
		selectItemInCustomDropdown("select[name='author_id']", "select[name='author_id'] option", "Ninh Việt Tú");
		sleepInSecond(1);
		
	}
	
	@Test
	public void TC_07_kmplayer() {
		driver.get("https://kmplayer.com/home");
		sleepInSecond(5);
		WebElement popup3 =driver.findElement(By.cssSelector("img#support-home"));
		if (popup3.isDisplayed()) {
			System.out.println("Popup có xuất hiện");
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//img[@id='support-home']//following::input")));
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("area#btn-r")));
		}
		
		select = new Select (driver.findElement(By.cssSelector("select#selectLang")));
		select.selectByVisibleText("한국어");
		sleepInSecond(2);
		select = new Select (driver.findElement(By.cssSelector("select#selectLang")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "한국어");
		sleepInSecond(5);
	

		select.selectByVisibleText("English");
		select = new Select (driver.findElement(By.cssSelector("select#selectLang")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "English");
		sleepInSecond(5);

	}
	//Sleep cứng (Static wait)
	public void sleepInSecond(long timeInSecond) {
			try {
			Thread.sleep(timeInSecond*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		
	public String getRandomEmail() {
		
		Random random = new Random();
		return "yentran"+random.nextInt(99999)+"@gmail.com";
		
	}
		
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	public void selectItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem) {
		driver.findElement(By.cssSelector(parentLocator)).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		allItems = driver.findElements(By.cssSelector(childLocator));
		for (WebElement item : allItems) {
			String textActualItem = item.getText();
			if(textActualItem.equals(textExpectedItem)) {
			item.click();
			break; //khi đã tìm thấy rồi thì break vòng lặp luôn không tìm nữa
		}
			
		}

	}

}