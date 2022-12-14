package webdriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_P6_FluentWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;
	FluentWait<WebDriver> fluentDriver;
	FluentWait<WebElement> fluentElement;
	long timeout = 15; //second
	long pollingTime = 1000; //milisecond

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// Set cả 2 loại Wait đều không ảnh hưởng
		//ImplicitWait chỉ apply cho findElemet / findElements
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//ExplicitWait: wait cho các điều kiện / trạng thái của element
		//explicitWait = new WebDriverWait (driver, 10);
		
		//Explicit custom (timeout (s) = 10, polling (ms) = 500ms = 0.5s)
		//explicitWait = new WebDriverWait(driver, 10, 500);
		
		driver.manage().window().maximize();
		}
	// Khác biệt của Fluent Wait: có tần số và chu ký nhất định, có thể thak đổi tần số chứ không cố định như implicit hay explicit
	// Implicit/Explicit cứ 0.5s tìm lại 1 lần nếu chưa tìm thấy element cho đến hết timeout
	// Explicit (custom)/ Fluent có thể custom lại được time tìm lại element (đơn vị có thể là s, ms)
	// Nếu Fluent không ignore exception trong quá trình xử lý sẽ đánh fail ngay từ lần không tìm thấy đầu tiên mà không tìm cho đến hết timeout như implicit/explicit
	// Imlicit/Explicit default ignore exception cho đến hết timeout mới fail
	@Test
	public void TC_01_Fluent() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		// Dùng FluentWait để findElement và click vào element
		findElement("//div[@id='start']//button").click();
		Assert.assertEquals(findElement("//div[@id='finish']/h4").getText(), "Hello World!");
		
	}
	//Hàm findElement dùng FluentWait
	public WebElement findElement(String xpathLocator) {
	// Dùng FluentWait:	
		fluentDriver = new FluentWait<WebDriver>(driver);	
	//Set timeout và tần số
		fluentDriver.withTimeout(Duration.ofSeconds(timeout))
		//0.5s check 1 lần
		.pollingEvery(Duration.ofMillis(pollingTime))
		//ignore exception của class selenium, không chọn exception của java.util
		.ignoring(NoSuchElementException.class);
		
	//Apply điều kiện: wait cho tới khi start button xuất hiện
		return fluentDriver.until(new com.google.common.base.Function<WebDriver, WebElement>() 
		{

			@Override
			public WebElement apply(WebDriver element) {
				return driver.findElement(By.xpath(xpathLocator));
			}
		});	
		

	}

	@Test
	public void TC_02_Fluent_Countdown() {
		driver.get("https://automationfc.github.io/fluent-wait/");
		WebElement countdowntTime = findElement("//div[@id='javascript_countdown_time']");
		
		fluentElement = new FluentWait<WebElement>(countdowntTime);
		
		fluentElement.withTimeout(Duration.ofSeconds(timeout))
		.pollingEvery(Duration.ofMillis(pollingTime))
		.ignoring(NoSuchElementException.class);
		
		fluentElement.until(new com.google.common.base.Function<WebElement, Boolean>() {

			@Override
			public Boolean apply(WebElement element) {
				String text = element.getText();
				System.out.println(text);
				return text.endsWith("00");
			}
		});
		
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