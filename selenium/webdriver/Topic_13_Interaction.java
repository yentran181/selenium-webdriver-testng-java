package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Interaction {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Actions action;
	JavascriptExecutor jSExecutor;
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		jSExecutor = (JavascriptExecutor) driver;
		
		driver.manage().window().setSize(new Dimension(1920,1080));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}

	@Test
	public void TC_01_Hover_Tooltip() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");

			
	}

	@Test
	public void TC_02_Hover2_Menu_myntra() {
		driver.get("https://www.myntra.com/");
		action.moveToElement(driver.findElement(By.xpath("//a[@data-group='kids']"))).perform();
		sleepInSecond(5);
		action.click(driver.findElement(By.xpath("//a[text()='Home & Bath']"))).perform();
		//driver.findElement(By.xpath("//a[text()='Home & Bath']")).click();
		sleepInSecond(5);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.myntra.com/kids-home-bath");
	}

	@Test
	public void TC_03_Hover_Menu_() {

		
	}
	
	@Test
	public void TC_04_Hover_ClickandHold_Block() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		//Cần thao tác với tất cả element -> Lưu vào 1 list
		List<WebElement> listNumbers = driver.findElements(By.cssSelector("ol#selectable li"));
		System.out.println("Tổng số lượng number =" +listNumbers.size());
		//Click vào số bắt đầu và giữ chuột trái, di chuột đến số kết thúc, nhả chuột

		

		action.clickAndHold(listNumbers.get(0)).moveToElement(listNumbers.get(3)).release().perform();
		//Verify số lượng element đã chọn
		List<WebElement> listNumberSelected1 = driver.findElements(By.cssSelector("ol#selectable>li[class='ui-state-default ui-selectee ui-selected']"));
		Assert.assertEquals(listNumberSelected1.size(),4);
		
		action.clickAndHold(listNumbers.get(0)).moveToElement(listNumbers.get(11)).release().perform();
		List<WebElement> listNumberSelected2 = driver.findElements(By.cssSelector("ol#selectable>li[class='ui-state-default ui-selectee ui-selected']"));
		Assert.assertEquals(listNumberSelected2.size(),12);
		
		
	}
	
	@Test
	public void TC_05_ClickandHold_Random() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		//Cần thao tác với tất cả element -> Lưu vào 1 list
		List<WebElement> listNumbers = driver.findElements(By.cssSelector("ol#selectable li"));
		System.out.println("Tổng số lượng number =" +listNumbers.size());
		//Click vào số bắt đầu và giữ chuột trái, di chuột đến số kết thúc, nhả chuột

		action.keyDown(Keys.CONTROL).perform();
		action.click(listNumbers.get(0)).perform();
		action.click(listNumbers.get(4)).perform();
		action.click(listNumbers.get(9)).perform();
		action.click(listNumbers.get(11)).perform();

		List<WebElement> listNumberRandomSelected = driver.findElements(By.cssSelector("ol#selectable>li[class='ui-state-default ui-selectee ui-selected']"));
		Assert.assertEquals(listNumberRandomSelected.size(),4);	
		
	}
	

	@Test
	public void TC_06_Double_Click() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Scroll đến đúng element cần thao tác để cho nó hiện trên viewport (Firefox) 
		//jSExecutor.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//button[text()='Double click me']")));
		sleepInSecond(2);
		
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
		
	}
	
	@Test
	public void TC_06_Right_Click() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		//Click chuột phải
		action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"))).perform();
		sleepInSecond(2);
		
		//Hover Paste
		action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
		sleepInSecond(2);
		
		//Verify hover thành công vào Paste
		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste.context-menu-hover.context-menu-visible")).isDisplayed());
		
		action.click(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
		
		//Handle alert
		driver.switchTo().alert().accept();
		sleepInSecond(1);
		
		//Verify bỏ hover Paste
		Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());

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