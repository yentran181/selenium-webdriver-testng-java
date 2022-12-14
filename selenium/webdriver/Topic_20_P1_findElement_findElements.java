package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_P1_findElement_findElements {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		//apply 15s cho việc tìm element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		}

	@Test
	public void TC_01_findElement() {
	
	//Tìm thấy only 1 element/node
	//Tìm thấy và thao tác trên 1 element đã tìm thấy
	//Tìm thấy và thao tác luôn mà không cần chờ hết 15s timeout
		driver.findElement(By.cssSelector("input#email"));
		
	//Tìm thấy >1 element/node 
	//Tìm thấy và thao tác với node đầu tiên
	//Không quan tâm các node còn lại
		driver.findElement(By.cssSelector("input#email")).sendKeys("yentran@gmail.com");
		
	//Không tìm được element/node nào
	//Có cơ chế tìm lại = 0.5s tìm lại 1 lần cho đến hết timeout
	//Nếu trong tgian tìm lại mà thấy element thì thỏa mãn điều kiện -> Pass
	//Hết timeout vẫn không thấy thì:
		// Đánh fail testcase + Không chạy step tiếp theo
		// Throw ra 1 ngoại lệ: NoSuchElementException
		//driver.findElement(By.cssSelector("input[type='check']"));

			
	}

	@Test
	public void TC_02_findElements() {
	
	//Tìm thấy only 1 element/node và lưu vào list = 1 element
	//Không cần chờ hết timeout mà next step luôn
		List<WebElement> elements = driver.findElements(By.cssSelector("input#email"));
		System.out.println("List element number =" + elements.size());
		
	//Tìm thấy >1 element/node
	// Tìm thấy và lưu vào list = element tìm được
		elements = driver.findElements(By.cssSelector("input#email"));
		System.out.println("List element number =" + elements.size());
		
	//Không tìm được element/node nào
	//Có cơ chế tìm lại = 0.5s tìm lại 1 lần cho đến hết timeout
	//Nếu trong tgian tìm lại mà thấy element thì thỏa mãn điều kiện -> Pass
	//Hết timeout vẫn không thấy thì:
		// Không đánh fail testcase + vẫn chạy step tiếp theo
		// Trả về list rỗng (empty) = 0
		elements = driver.findElements(By.cssSelector("input[type='check']"));
		System.out.println("List element number =" + elements.size());
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