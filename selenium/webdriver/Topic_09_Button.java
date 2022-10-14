package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Button {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}

	@Test
	public void TC_01_() {
		driver.get("https://www.fahasa.com/customer/account/create");
		sleepInSecond(3);
		
		driver.findElement(By.cssSelector("button#moe-dontallow_button")).click();
		
		driver.switchTo().frame("moe-onsite-campaign-6343d7a04a393aeaf7259ff2");
		
		driver.findElement(By.cssSelector("img#NC_IMAGE1")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
		
		Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-login")).isEnabled());
		
		driver.findElement(By.cssSelector("input#login_username")).sendKeys("yentran181@gmail.com");
		driver.findElement(By.cssSelector("input#login_password")).sendKeys("12345678");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("button.fhs-btn-login")).isEnabled());
		String rgbColor = driver.findElement(By.cssSelector("button.fhs-btn-login")).getCssValue("background-color");
		System.out.println(rgbColor);
		
		//Convert rgbcolor to Hexa color
		String hexaColor = Color.fromString(rgbColor).asHex().toUpperCase();
		
		
		

		
		
		

			
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
		//driver.quit();
	}

}