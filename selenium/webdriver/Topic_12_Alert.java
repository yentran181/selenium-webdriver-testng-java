package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Alert {
	WebDriver driver;
	Alert alert;
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
//Phân biệt Alert/Popup/Windows
//	Alert và Window phải Switch mới bắt được
//	Popip có thể inspect được ngay trên trình duyệt
//Phân biệt Alert / Popup-Dialog-Form / Window
//	1. Alert
	// Alert là của Browser, không thuộc Elemet (WebElemet) -> Không inspect được
	// Có 4 loại Alert: 
		//Accept Alert : là alert chi được phép accept/OK để đóng, không cancel được
		//Confirm Alert: là alert có thể OK hoặc Cancel
		//Prompt Alert: là alert cần nhập dữ liệu và có thể OK hoặc Cancel
		//Authentication Alert : là alert cần phải nhập username/password để đăng nhập
	
//	2. 	Popup-Dialog-Form (là 1)
	// Là element nên inspect được
	// Có thể xuất hiện theo mong đợi hoặc ramdon
	
//	3. Window
	// Là cửa số mới mới page mới
	@Test
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		sleepInSecond(1);
		
		//Verify alert title
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		
		//Accerp to alert
		alert.accept();
		
		//Verify accept alert thành công
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked an alert successfully");	
	}

	@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		sleepInSecond(1);
		
		//Verify alert title
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		
		//Cancel to alert
		alert.dismiss();
		
		//Verify cancel alert thành công
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");
		
		
	}

	@Test
	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		alert.sendKeys("yentt");
		alert.accept();
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: yentt");
		sleepInSecond(2);
		
	}
	
	@Test
	public void TC_04_Accept_Alert_Login() {
		driver.get("https://demo.guru99.com/v4/index.php");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		sleepInSecond(1);
		
		//Verify alert title
		Assert.assertEquals(alert.getText(), "User or Password is not valid");
		
		//Accerp to alert
		alert.accept();
		
		//Verify url
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/v4/index.php");
	}

	
	@Test
	public void TC_05_Authentication_Alert() {
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
		
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}