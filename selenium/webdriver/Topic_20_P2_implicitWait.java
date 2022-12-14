package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_P2_implicitWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		}
// 0. ImplicitWait: wait ngầm định, không apply cho 1 emlement cụ thể hay trạng thái/ điều kiện cụ thể nào
// 1 - Hàm implicitWait ảnh hưởng trực tiếp tới 2 hàm findElement và findElements
// 2 - Ngoại lệ:
	// Hàm implicitWait được đặt ở đâu sẽ apply từ vị trí đó trở xuống
	// Nếu được gán lại sẽ dùng giá trị mới nhất, không dùng giá trị cũ
	@Test
	public void TC_01_Not_Enough_Time_2s() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		//Click vào Start button
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		//Get text và verify
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	
			
	}

	@Test
	public void TC_02_Enough_Time_5s() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		//Click vào Start button
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		//Get text và verify
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
		
	}

	@Test
	public void TC_03_Excess_Time_10s() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		//Click vào Start button
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		//Get text và verify
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
		
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