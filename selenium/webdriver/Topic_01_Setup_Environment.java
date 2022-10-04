package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Setup_Environment {
	//Khai báo 1 biến để đại diện cho thư viên Selenium Webdriver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	// Change

	@BeforeClass
	public void beforeClass() {
		//Bước 1: Mở browser
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		//Bấm cho maximize browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://econtractapp.efy.com.vn/login");
	}

	@Test
	public void TC_01_() {
		// Bước 2: Nhập URL
		driver.get("https://econtractapp.efy.com.vn/login");
		
		//Bước 3: Click My Account để mở trang login
		//Cấu trún 1 Element:
//		<input _ngcontent-c0="" 
//		class="form-control auth-input input-login border-left-hide ng-pristine ng-invalid ng-touched" 
//		formcontrolname="tax_code" name="tataxCodexCode" required="" type="text" placeholder="Mã số thuế ">
		
		//Tagname (tên thẻ): input
		//Attribute name (tên thuộc tính): _ngcontent-c0 class formcontrolname   required type placeholder
		//Attribute value (giá trị thuộc tính): tax_code tataxCodexCode text Mã số thuế ...
		
		//Cấu trúc Xpath: //tagname[@attribute-name='attribute-value']
		
		//Cấu trúc CSS: tagname[attribute-name='attribute-value']
		
		//ID: 
		//driver.findElement(By.id("aa"));
		
		//Class: 
		
	//  Giá trị không chứa khoảng trắng -> Lấy hết
	//	Giá trị có chứa khoảng trắng -> Lấy 1 phần
		//driver.findElement(By.className("aaa"));
		
		//Name
		driver.findElements(By.name("tataxCodexCode"));
		
		//Tagname: Tìm xem có bao nhiêu Element
		//driver.findElement(By.tagName("a"));
		
		//Linktext - text tuyệt đối 100%
		//driver.findElement(By.linkText("Search terms"));
		
		//Partial linktext - text tương đối/tuyệt đối (<=100%)
		//driver.findElement(By.partialLinkText("Search terms"));
		//driver.findElement(By.partialLinkText("Search"));
		//driver.findElement(By.partialLinkText("terms"));
		
		//CSS: Cover được hết cả 6 loại trên
		driver.findElement(By.cssSelector("input[name='tataxCodexCode']"));
		//driver.findElement(By.cssSelector("input[placeholder='Mã số thuế']"));
		
		//Xpath
		driver.findElement(By.xpath("//input[@name='tataxCodexCode']"));
		//driver.findElement(By.xpath("//input[@placeholder='Mã số thuế']"));
		
		//Tìm nhiều Element
		//driver.findElements(null)
	}

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_() {

	}

	@AfterClass
	public void afterClass() {
		//Bước 6: Đóng browser
		driver.quit();
	}

}