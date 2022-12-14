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

public class Topic_20_P4_explicitWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;
	
	String meoFileName = "meo.jpg";
	String meo1FileName = "meo1.jpg"; 
	String meo2FileName = "meo2.jpg";
	
	String meoFilePath =  projectPath+"\\Uploaded Files\\"+ meoFileName;
	String meo1FilePath = projectPath+"\\Uploaded Files\\"+ meo1FileName;
	String meo2FilePath = projectPath+"\\Uploaded Files\\"+ meo2FileName;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		


		}
	
	
// 0. ExplicitWait (WebDriverWait): hàm wait tường minh apply cho trạng thái/ điều kiện cụ thể của element

	@Test
	public void TC_01_Visibility() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		//Khởi tạo biến explicitWait 10s cho các điều kiện/ trạng thái cụ thể của element
		explicitWait = new WebDriverWait(driver,10);
		//Click vào Start button
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		//Wait cho element của step sau visible
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
		
		//Get text và verify
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
		
	}
	
	@Test
	public void TC_02_Invisibility() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		//Khởi tạo biến explicitWait 10s cho các điều kiện/ trạng thái cụ thể của element
		explicitWait = new WebDriverWait(driver,10);
		//Click vào Start button
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		// Wait cho element của step trước invisible / không xuất hiện trên UI nữa
		// Wait cho loading icon invisible
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
		
		//Get text và verify
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
		
	}
	
	@Test
	public void TC_03_Ajax_Loading() {
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		//Khởi tạo biến explicitWait 15s cho các điều kiện/ trạng thái cụ thể của element
		explicitWait = new WebDriverWait(driver,15);
		// Wait cho Date Picker được hiển thị
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.RadCalendar")));
		
		//Wait cho element được phép click
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='7']")));
		
		//Verify chưa chọn ngày
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='datesContainer']//span")).getText(), "No Selected Dates to display.");
		
		//Click và ngày hiện tại
		driver.findElement(By.xpath("//a[text()='7']")).click();
		
		//Wait cho icon loading biến mất
		// id* là lấy ra content
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1'] div.raDiv")));
		
		// Wait cho ngày được chọn được phép click trở lại
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='rcSelected']//a[text()='7']")));
		
		// Verify ngày hiển thị
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='datesContainer']//span")).getText(), "Wednesday, December 7, 2022");
		
	}
	
	@Test
	public void TC_04_Upload_files() {
		explicitWait = new WebDriverWait(driver,10);
		
		driver.get("https://gofile.io/uploadFiles");
		
		//Wait cho đến khi Add Files button có thể click được
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#rowUploadButton button.uploadButton")));
		
		//Upload 3 files
		driver.findElement(By.xpath("//input[@type='file'][@id='uploadFile-Input']")).sendKeys(meoFilePath + "\n" + meo1FilePath);
		
		//Wait cho loading icon của từng file visible
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#rowUploadProgress-list div.progress")));
		
		//Wait cho loading icon của từng file ininvisible
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div#rowUploadProgress-list div.progress"))));
		
		//Wait cho upload success message được visible
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//h5[text()='Your files have been successfully uploaded']")));
		
		//Verify upload success message được hiển thị
		Assert.assertTrue((driver.findElement(By.xpath("//h5[text()='Your files have been successfully uploaded']")).isDisplayed()));
		
		//Wait +click cho Show file button đươc có thể click được và click
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#rowUploadSuccess-showFiles"))).click();
		
		//Wait + Verify fileName vs button download hiển thị
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='meo.jpg']/parent::a/parent::div/parent::div//button[@id='contentId-download']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='meo1.jpg']/parent::a/parent::div/parent::div//button[@id='contentId-download']"))).isDisplayed());		

		//Wait + Verify fileName vs button play hiển thị
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='meo.jpg']/parent::a/parent::div/parent::div//button[contains(@class,'contentPlay')]"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='meo1.jpg']/parent::a/parent::div/parent::div//button[contains(@class,'contentPlay')]"))).isDisplayed());

		
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