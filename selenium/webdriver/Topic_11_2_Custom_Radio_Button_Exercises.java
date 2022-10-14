package webdriver;

import java.awt.desktop.ScreenSleepEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_2_Custom_Radio_Button_Exercises {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920,1080));
		//driver.manage().window().maximize();
		}

	@Test
	public void TC_01_Radio_button() {
		driver.get("https://material.angular.io/components/radio/examples");
		By summerRadio = By.xpath("//input[@value='Summer']");
		checkToCheckboxOrRadio(summerRadio);
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(summerRadio).isSelected());
			
	}
	
	public void checkToCheckboxOrRadio (By byXpath) {
		if (!(driver.findElement(byXpath)).isSelected()) {
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(byXpath));
		}
	}
	
	public void uncheckToCheckbox (By byXpath ) {
		if (driver.findElement(byXpath).isSelected()) {
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(byXpath));
		}
	}
	
	public boolean isSelectedElement (By byXpath) {
		return driver.findElement(byXpath).isSelected();
	}

	@Test
	public void TC_02_Checkbox() {
		driver.get("https://material.angular.io/components/checkbox/examples");
		By checkedCheckbox = By.xpath("//span[text()='Checked']//preceding-sibling::span/input");
		checkToCheckboxOrRadio(checkedCheckbox);
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());
		
		By indeterminateCheckbox = By.xpath("//span[text()='Indeterminate']//preceding-sibling::span/input");
		checkToCheckboxOrRadio(indeterminateCheckbox);
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(indeterminateCheckbox).isSelected());
		
		uncheckToCheckbox(checkedCheckbox);
		uncheckToCheckbox(indeterminateCheckbox);
		
		Assert.assertFalse(isSelectedElement(checkedCheckbox));
		Assert.assertFalse(isSelectedElement(indeterminateCheckbox));
		
	}

	@Test
	public void TC_03_Google() {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		By canThoradio = By.xpath("//div[@data-value='Cần Thơ']");
		Assert.assertFalse(isSelectedGGElement(canThoradio));
		checkToGGCheckboxorRadio(canThoradio);
		Assert.assertTrue(isSelectedGGElement(canThoradio));
		
		By miQuangCheckbox = By.xpath("//div[@data-answer-value='Mì Quảng']");
		Assert.assertFalse(isSelectedGGElement(miQuangCheckbox));
		checkToGGCheckboxorRadio(miQuangCheckbox);
		Assert.assertTrue(isSelectedGGElement(miQuangCheckbox));
		
		sleepInSecond(5);
		
	}
	
	public void checkToGGCheckboxorRadio (By byXpath) {
		WebElement element = driver.findElement(byXpath);
		if (element.getAttribute("aria-checked").equals("false")) {
			element.click();
		}
	}
	
	public void unchecktoCheckboxorRadio (By byXpath) {
		WebElement element = driver.findElement(byXpath);
		if (element.getAttribute("aria-checked").equals("true")) {
			element.click();
		}
	}
	
	public boolean isSelectedGGElement (By byXpath) {
		return driver.findElement(byXpath).getAttribute("aria-checked").equals("true");
	}

	public boolean isDeselectedGGElement (By byXpath) {
		return driver.findElement(byXpath).getAttribute("aria-checked").equals("false");
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