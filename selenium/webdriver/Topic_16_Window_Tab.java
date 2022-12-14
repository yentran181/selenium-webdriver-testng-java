package webdriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Window_Tab {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Alert alert;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
	
	@Test
	public void TC_01_() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Muốn switch qua window/tab  cần phải có id của windows/tab đó - GUID - Global Unique Identifier
		//Check driver đang active ở đâu
		//Gọi hàm lấy ra ID của window/tab đang active
			String parentPageWindowID = driver.getWindowHandle();
			System.out.println("ParentPageID = " + parentPageWindowID);
			
			driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
			sleepInSecond(2);
			
			switchToWindowbyID(parentPageWindowID);
			driver.findElement(By.xpath("//input[@title='Tìm kiếm']")).sendKeys("Selenium");
			
			switchToWindowByPageTitle("SELENIUM WEBDRIVER FORM DEMO");
			Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
			driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
			sleepInSecond(2);
			
			switchToWindowByPageTitle("Facebook – log in or sign up");
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
			driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
			driver.findElement(By.cssSelector("input#pass")).sendKeys("12345678");
			sleepInSecond(2);
			
			switchToWindowByPageTitle("SELENIUM WEBDRIVER FORM DEMO");
			Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
			driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
			sleepInSecond(2);
			switchToWindowbyID(parentPageWindowID);
			driver.findElement(By.xpath("//input[@title='Tìm kiếm']")).sendKeys("Automation Testing");
		
	}

	@Test
	public void TC_02_techpanda() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		sleepInSecond(1);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/mobile.html");
		
		driver.findElement(By.xpath("//a[@title='Xperia']//following-sibling::div//a[text()='Add to Compare']")).click();
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='The product Sony Xperia has been added to comparison list.']")).isDisplayed());
		
		driver.findElement(By.xpath("//a[@title='Samsung Galaxy']//following-sibling::div//a[text()='Add to Compare']")).click();
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='The product Samsung Galaxy has been added to comparison list.']")).isDisplayed());
		
		driver.findElement(By.xpath("//div[@class='col-right sidebar']//button[@title='Compare']")).click();
		sleepInSecond(2);
		
		switchToWindowByPageTitle("Products Comparison List - Magento Commerce");
		
		Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
		
		driver.close();
		
		switchToWindowByPageTitle("Mobile");
		
		driver.findElement(By.xpath("//div[@class='col-right sidebar']//a[text()='Clear All']")).click();
		
		alert = driver.switchTo().alert();
		alert.accept();
		sleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='The comparison list was cleared.']")).isDisplayed());
		
	}

	@Test
	public void TC_03_Cambridge() {
		driver.get("https://dictionary.cambridge.org/vi/");
		driver.findElement(By.xpath("//header//span[text()='Đăng nhập']")).click();
		sleepInSecond(3);
		
		switchToWindowByPageTitle("Login");
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.xpath("//input[@name='username']//following-sibling::span[text()='This field is required']")).isDisplayed();
		driver.findElement(By.xpath("//input[@name='password']//following-sibling::span[text()='This field is required']")).isDisplayed();
		
		sleepInSecond(5);
		
		
	}
	
	//Hàm switch dùng có 2 ID
	public void switchToWindowbyID(String parentPageWindowID) {	
	//Gọi làm lấy ra tất cả ID của window/tab
	//Dùng Set vì danh sách không cho lưu trùng, mỗi ID của 1 window là duy nhất nên sẽ ưu tiên dùng set,  nếu dùng List sẽ cho phép lưu trùng/null
	Set<String> allwindowIDs=driver.getWindowHandles();
		for (String id : allwindowIDs) {
			if (!id.equals(parentPageWindowID)) {
					driver.switchTo().window(id);
					break;
				}
			}
	} 
	
	//Hàm switch dùng khi >2 ID
	public void switchToWindowByPageTitle(String expectedPagetitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualPageTitle = driver.getTitle();
			if (actualPageTitle.equals(expectedPagetitle)) {
				sleepInSecond(5);
				break;
			}
		}
		
	}
	
	public void closeAllWithoutParentPage(String parentPageID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentPageID)) {
				driver.switchTo().window(id);
				driver.close();
				sleepInSecond(2);
			}
		}
		driver.switchTo().window(parentPageID);	
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