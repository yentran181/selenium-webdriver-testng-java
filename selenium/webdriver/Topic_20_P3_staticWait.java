package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_P3_staticWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		}
	
// Bài cũ: Flexible time: 
	// Nếu thỏa mãn điều kiện thì không cần chờ hết timeout
	// Nếu chưa thỏa mãn điều kiện thì có cơ chế tìm lại cho đến khi thấy /  không tìm thấy mà hết timeout thì throw về lỗi NoSuchElement hoặc empty list

// Static Wait (Thread.sleep - là 1 hàm của Java Thread: chỉ sử dụng cho những case đặc thù
	// Chạy script trên browser là IE / Edge
	// Switch window (không có hàm wait cụ thể)
	// Apply for implement testcase - thử nghiệm, không dùng bừa bãi
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