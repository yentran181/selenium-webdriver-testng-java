package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Textbox_TextArea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName, middleName, lastName, employeeID, editfirstName, editmiddleName, editlastName;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		firstName = "TTran";
		middleName = "Thi";
		lastName = "Yenn";
		editfirstName = "Pham";
		editmiddleName = "Duy";
		editlastName = "Phuong";
		}

	@Test
	public void TC_01_() {
	
			
	}

	@Test
	public void TC_02_Textbox_TextArea() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Login vào TK Admin/admin123
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		sleepInSecond(5);
		
		//Mở màn Add Employee
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		
		//Nhập dữ liệu 
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys(middleName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		
		//Lấy giá trị employee ID và gán vào biến employeeID
		employeeID = driver.findElement(By.xpath("//div[@class='orangehrm-employee-form']//input[@class='oxd-input oxd-input--active']")).getAttribute("_value");
		
		//Click Save
		driver.findElement(By.xpath("//div[@class='oxd-form-actions']//button[@type='submit']")).click();
		sleepInSecond(10);
		
		//Verify actual value as exxpected value
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='middleName']")).getAttribute("value"), middleName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[string()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
		
		//Edit value
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(editfirstName);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(editmiddleName);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(editlastName);
		
		//Verify fields are enabled
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='firstName']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='middleName']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='lastName']")).isEnabled());
		
		//Click Save edited fields
		driver.findElement(By.xpath("//p[string()=' * Required']/following-sibling::button[@type='submit']")).click();
		
		//Verify actual value as exxpected value
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), editfirstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='middleName']")).getAttribute("value"), editmiddleName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), editfirstName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[string()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
		
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