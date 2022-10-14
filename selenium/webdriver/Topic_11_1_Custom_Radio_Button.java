package webdriver;
//Với Custom checkbox/radio button, thẻ input bị ẩn và không thể click được nếu dùng hàm Click của thư viện Selenium, nhưng muốn verify được checkbox/radio button cần phải dùng thẻ input
//Có thể dùng cách dùng thẻ khác đại diện cho checkbox/radio để click và dùng thẻ input để verify => dùng 2 locator cho 1 element -> dễ gây nhầm lẫn, khó hiểu
//Tối ưu nhất sẽ dùng hàm Click của thư viện JavascriptExcutor để click, hàm này không quan tâm thẻ element có bị ẩn hay không. Khai báo -> Khởi tạo

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_1_Custom_Radio_Button {
	WebDriver driver;
	JavascriptExecutor jsExcutor; // Khai báo
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExcutor = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}

	@Test
	public void TC_01_Custom_Checkbox() {
		driver.get("https://material.angular.io/components/checkbox/examples");
		sleepInSecond(3);
		
		//Cách 1: Dùng thẻ input để click và verify => Không click được do thẻ input bị ẩn
		//driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span//input")).click();
		//Verify
		//Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span//input")).isSelected());
	
		//Cách 2: Dùng thẻ đại diện cho element khác input để click và verify => Click được nhưng không verify được do hàm isSlected chỉ check được với thẻ input, các thẻ khác sẽ đều trả về false
		//driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span")).click();
		//Verify
		//Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span")).isSelected());	

		//Cách 3: Dùng thẻ đại diện cho element khác input để click và dùng thẻ input verify => phải dùng 2 locator để define cho 1 element sẽ gây khó hiểu cho người mới, tốn bộ nhớ....
		//driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span")).click();
		//Verify
		//Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span//input")).isSelected());	
		
		//Cách 4: Dùng hàm click của thư viện JavascriptExcutor, hàm này không quan tâm element có bị ẩn hay không
		By checkedCheckbox = By.xpath("//span[text()='Checked']//preceding-sibling::span//input"); //Khai báo và gán giá trị cho biến checkedCheckbox đại diện cho value của hàm findElement
		jsExcutor.executeScript("arguments[0].click();", driver.findElement(checkedCheckbox));
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());
		
	}
	

	@Test
	public void TC_02_Custom_Radio() {
		driver.get("https://material.angular.io/components/radio/examples");
		By winterRadio = By.xpath("//span[contains(text(),'Winter')]/preceding-sibling::span/input"); //Khai báo và gán giá trị cho biến winterRadio đại diện cho value của hàm findElement
		jsExcutor.executeScript("arguments[0].click();", driver.findElement(winterRadio));
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(winterRadio).isSelected());
	}

	@Test
	public void TC_03_Google() { //Checkbox/Radio không có thẻ input do Google tự design được
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		By canThoRadio = By.xpath("//div[@data-value='Cần Thơ']");
		By quangNinhCheckbox = By.xpath("//div[@data-answer-value='Quảng Ninh']");

		//Verify trước khi click
		Assert.assertEquals(driver.findElement(quangNinhCheckbox).getAttribute("aria-checked"),"false");
		
		//Click
		checkToCheckbox("//div[@data-answer-value='Quảng Ninh']");
		checkToCheckbox("//div[@data-value='Cần Thơ']");
		sleepInSecond(1);
		
		//Verify sau khi click
		Assert.assertEquals(driver.findElement(quangNinhCheckbox).getAttribute("aria-checked"),"true");	
		
		uncheckToCheckbox("//div[@data-answer-value='Quảng Ninh']");
		checkToCheckbox("//div[@data-value='Hà Nội']");
		
	}
	
	public void checkToCheckbox(String xpathLocator) {
		WebElement element = driver.findElement(By.xpath(xpathLocator));
		if (element.getAttribute("aria-checked").equals("false")) {
			element.click();	
		}
	}
	
	public void uncheckToCheckbox(String xpathLocator) {
		WebElement element = driver.findElement(By.xpath(xpathLocator));
		if (element.getAttribute("aria-checked").equals("true")) {
			element.click();	
		}
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