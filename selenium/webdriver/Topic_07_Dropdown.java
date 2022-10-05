package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
	Random random;
	String firstName, lastName, day, month, year, email, password, comfirmPassword;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		random = new Random();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		firstName = "Yen";
		lastName = "Tran";
		day = "1";
		month = "May";
		year = "1980";
		email = "yentran"+random.nextInt(999999)+".@gmail.net";
		password = "12345678";
		comfirmPassword = "12345678";
		
		}

	@Test
	public void TC_01_Default_Dropdown() {
		//Step 01
		driver.get("https://demo.nopcommerce.com");
		
		//Step 02: Mở form Register
		driver.findElement(By.cssSelector("div.header-links a.ico-register")).click();
		
		//Input thông tin vào form
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(comfirmPassword);
		
		//Khởi tạo select để thao tác với Day Dropdown
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText(day);//Chọn Day = 1
		
		//Khởi tạo select để thao tác với Month Dropdown
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText(month); //Chọn month = May
		
		//Khởi tạo select để thao tác với Year Dropdown
		select = new Select (driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText(year);
		
		//Verify đã chọn giá trị 1 thành công
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"1");
		
		Assert.assertFalse(select.isMultiple());
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		
		//Verrify text dang ky thanh con
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		
		driver.findElement(By.cssSelector("a.ico-account")).click();
		
		Assert.assertEquals(driver.findElement(null), false)
		
//		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
//		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);		
//		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
//		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);		
//		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
//		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
		
		
		
		
			
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