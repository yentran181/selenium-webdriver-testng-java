package Eclipse_Tips;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Debug {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@Test
	public void TC_01(){
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("https://econtractapp.efy.com.vn/");
		String titleText = driver.findElement(By.xpath("//div[contains(@class,'main-name')]/span")).getText();
		Assert.assertEquals(titleText, "HỢP ĐỒNG ĐIỆN TỬ");
		
		boolean loginStatus = driver.findElement(By.cssSelector("button#login")).isDisplayed();
		assertTrue(loginStatus);
	}
}
