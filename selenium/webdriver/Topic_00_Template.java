package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// Set cả 2 loại Wait đều không ảnh hưởng
		//ImplicitWait chỉ apply cho findElemet / findElements
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//ExplicitWait: wait cho các điều kiện / trạng thái của element
		explicitWait = new WebDriverWait (driver, 10);
		
		driver.manage().window().maximize();
		}

	@Test
	public void TC_01_() {
		driver.get("");
	
			
	}

	@Test
	public void TC_02_() {
		
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
		driver.quit();
	}

}