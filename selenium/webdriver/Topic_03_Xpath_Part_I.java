package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Part_I {
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
	public void Register_01_Empty_Data() {
		driver.get("https://www.facebook.com/");
		//HTML format
		/*<input class="text form-control"
		 * id="txtEmail" name="txtEmail"
		 * placeholder="Địa chỉ email"
		 * type="email" value="">
		 */
		//input[@class='text form-control']
		//input[@id='txtEmail'] 
		//input[@name='txtEmail']
		//input[@placeholder='Địa chỉ email']
		//input[@type='email']
		//input[@value='']
		
		//1 - < hoặc <>
		//2 - tên thẻ (tagname): imput/html/head/body/form/label/span/p/...
		//3 - thuộc tính (attribute name): class/id/name/placeholder/type/value
		//4 - giá trị thuộc tính (attribute value):text form-control/txtEmail/txtEmail/...
		//5 - > hoặc </>
		
		//=> Tập trung Tagname - Attribute name - Attribute value
		
//		Xpath format basic
//		Absolute Xpath: /html/body/...
//		Relative Xpath: //tagname[@attribute name='attribute value']
						//tagname[@attribute name="attribute value]

//		CSS format basic
//		tagname[attribute name='attribute value']
//		tagname[attribute name="attribute value"]
			
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		// Login Page title

		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up.");
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		// Login form displayed
		Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}