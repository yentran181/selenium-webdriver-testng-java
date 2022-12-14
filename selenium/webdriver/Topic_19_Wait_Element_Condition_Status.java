package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Wait_Element_Condition_Status {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//Khởi tạo biến wait chờ 10s
		explicitWait = new WebDriverWait(driver,10);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
// Trạng thái 1: Element hiển thị (Visible/Displayed/Invisibility)
	//1 Có trong UI (bắt buộc) - Nhìn được, thao tác được, có kích thước cụ thể (rộng x cao)
	//2. Có trong HTML (bắt buộc)

// Trạng thái 2: Element không hiển thị (Invisible/Undisplayed/Invisibility)
	//1. Không có trên UI (bắt buộc)
	//2. Có trong HTML
	
	//1. Không có trên UI (bắt buộc)
	//2. Không có trong HTML
	
// Trạng thái 3: Element có trong HTML (Presence)
	//1. Có trên UI
	//2. Có trong HTML (bắt buộc)
	
	//1. Không có trên UI
	//2. Có trong HTML (bắt buộc)
	
// Trạng thái 4: Element staleness
	//1. Không có trong HTML (bắt buộc) 
	@Test
	public void TC_01_Visible_Displayed_Invisibility() {
		driver.get("https://www.facebook.com/");
// Trạng thái 1: Element hiển thị (Visible/Displayed/Invisibility)
	//1 Có trong UI (bắt buộc) - Nhìn được, thao tác được, có kích thước cụ thể (rộng x cao)
	//2. Có trong HTML (bắt buộc)	
		// Chờ cho email textbox hiển thị trong vòng 10s
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
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