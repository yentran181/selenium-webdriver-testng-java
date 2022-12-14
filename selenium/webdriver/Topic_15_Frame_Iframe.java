package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Frame_Iframe {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Alert alert;
	FirefoxOptions firefoxOptions;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		firefoxOptions =new FirefoxOptions();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}

	@Test
	public void TC_00_() {
		driver.get("");
//	Để handle được iframe cần switch vào đúng thẻ iframe chứ element cần tương tác
// Cách 1: dùng index của thẻ iframe
		driver.switchTo().frame(1);
// Cách 2: dùng name/id của thẻ iframe
		driver.switchTo().frame("");
// Cách 3: dùng element của iframe (recommend)
		driver.switchTo().frame("");
// Lỗi NoSuchElementException xảy ra ở 1 trong 3 trường hợp sau:
		//1. Từ main page lại thao tác với element thuộc iframe -> cần switch qua iframe
		//2. Từ iframe thao tác với element thuộc iframe khác -> cần switch to main page -> switch iframe khác
		//3. Từ ifamre thao tác với element thuộc main page -> cần switch về main page

			
	}
	
	@Test
	public void TC_01_dehieu() {
		driver.get("https://dehieu.vn/");
		sleepInSecond(10);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[data-testid='dialog_iframe']")));
		driver.findElement(By.cssSelector("div[class='_a2zm'][role='button']")).click();
		sleepInSecond(1);
		driver.findElement(By.cssSelector("div[class='_a2zk'][role='button']")).click();
		sleepInSecond(1);
		firefoxOptions.addArguments("disable-notifications");

		driver.findElement(By.cssSelector("input[class='_58al'][placeholder='Bạn hỏi gì đi...']")).sendKeys("SeleniumJava");
		sleepInSecond(3);
		//driver.switchTo().defaultContent();

	}


	@Test
	public void TC_03_() {
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
		//driver.quit();
	}

}