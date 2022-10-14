package webdriver;

import java.util.List;
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

public class Topic_10_Default_Radio_Checkbox {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	



	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1920,1080));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		}

	@Test
	public void TC_01_JotForm() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		//Chọn checkbox
		checkToCheckboxorRadio("//input[@value='Cancer']");
		checkToCheckboxorRadio("//input[@value='Heart Attack']");
		checkToCheckboxorRadio("//input[@value='Emphysema']");
		
		//Verify chọn thành công
		Assert.assertTrue(isElementSelected("//input[@value='Cancer']"));
		Assert.assertTrue(isElementSelected("//input[@value='Heart Attack']"));
		Assert.assertTrue(isElementSelected("//input[@value='Emphysema']"));
		
		//Chọn radio button
		checkToCheckboxorRadio("//input[@value='5+ days']");
		checkToCheckboxorRadio("//input[@value='I have a loose diet']");
		checkToCheckboxorRadio("//input[@value='1-2 cups/day']");
		
		//Verify chọn thành công
		
		Assert.assertTrue(isElementSelected("//input[@value='5+ days']"));
		Assert.assertTrue(isElementSelected("//input[@value='I have a loose diet']"));
		Assert.assertTrue(isElementSelected("//input[@value='1-2 cups/day']"));
	
		
		//Bỏ chọn checkbox  (Click vào 1 lần nữa là bỏ chọn)
		uncheckToCheckbox("//input[@value='Cancer']");
		uncheckToCheckbox("//input[@value='Heart Attack']");
		uncheckToCheckbox("//input[@value='Emphysema']");

		//Verify bỏ chọn thành công
		Assert.assertFalse(isElementSelected("//input[@value='Cancer']"));
		Assert.assertFalse(isElementSelected("//input[@value='Heart Attack']"));
		Assert.assertFalse(isElementSelected("//input[@value='Emphysema']"));
		
		//Bỏ chọn radio button 
		
		
		//Verify bỏ chọn thành công		
	
			
	}
	
	public void checkToCheckboxorRadio(String xpathLocator) {
		//Kiểm tra đối tượng đã được chọn hay chưa
		//Nếu chọn rồi thì bỏ qua không chọn nữa
		//Nếu chưa chọn thì click chọn
		if(!driver.findElement(By.xpath(xpathLocator)).isSelected()) { //Thêm dấu ! vào trước điều kiện if hoặc ==false vào cuối điều kiện để phủ định điều kiện
			driver.findElement(By.xpath(xpathLocator)).click();	
		}
	}
	
	public void checkToCheckboxorRadio(WebElement element) {
		if (!element.isSelected()&&element.isEnabled()) {
			System.out.println("Click to element" +element);
			element.click();
			Assert.assertTrue(isElementSelected(element));
		}
		
	}
		
	public void uncheckToCheckbox(String xpathLocator) {
		//Kiểm tra đối tượng đã được chọn hay chưa
		//Nếu chưa chọn thì bỏ qua
		//Nếu chọn rồi thì click chọn 1 lần nữa để bỏ chọn
		if(driver.findElement(By.xpath(xpathLocator)).isSelected()) { //Thêm dấu ! vào trước điều kiện if hoặc ==false vào cuối điều kiện để phủ định điều kiện
			driver.findElement(By.xpath(xpathLocator)).click();	
		}
	}
	
	public void uncheckToCheckbox(WebElement element) {
		if(element.isSelected()&&element.isEnabled()) { //Thêm dấu ! vào trước điều kiện if hoặc ==false vào cuối điều kiện để phủ định điều kiện
			element.click();
			Assert.assertFalse(isElementSelected(element));
		}
	}
	
	public boolean isElementSelected(String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator)).isSelected();
	}
	
	public boolean isElementSelected (WebElement element) {
		return element.isSelected();
	}


	@Test
	public void TC_02_Jotform_Select_All() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		List<WebElement> allchecboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		//Dùng vòng lặp để duyệt qua và chọn 
		for (WebElement checkbox : allchecboxes) {
			checkToCheckboxorRadio(checkbox);
			//sleepInSecond(1);
		}
		
		//Dùng vòng lặp đẻ duyệt qua và kiểm tra
		for (WebElement checkbox : allchecboxes) {
			isElementSelected(checkbox);
		}
		
		//Bỏ chọn all
		for (WebElement checkbox : allchecboxes) {
			uncheckToCheckbox(checkbox);
		}
		
	}

	@Test
	public void TC_03_Select_All_Telerik() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		sleepInSecond(5);
		
		//scrollToElement("div.demo-section h4");
		//sleepInSecond(3);
		
		List<WebElement> allcheckboxes = driver.findElements(By.xpath("//div[@class='demo-section']//input[@type='checkbox']"));
		for (WebElement checkbox : allcheckboxes) {
			checkToCheckboxorRadio(checkbox);
		}
		for (WebElement checkbox : allcheckboxes) {
			uncheckToCheckbox(checkbox);
		}
	}
	
	@Test
	public void TC_04_Telerik() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		//Click checkbox Dual-zone air conditioning và kiểm tra đã chọn
		checkToCheckboxorRadio("//label[text()='Dual-zone air conditioning']//preceding-sibling::input");
		Assert.assertTrue(isElementSelected("//label[text()='Dual-zone air conditioning']//preceding-sibling::input"));
		
		//Bỏ chọn check box Dual-zone air conditioning và kiểm tra bỏ chọn
		uncheckToCheckbox("//label[text()='Dual-zone air conditioning']//preceding-sibling::input");
		Assert.assertFalse(isElementSelected("//label[text()='Dual-zone air conditioning']//preceding-sibling::input"));
		
		
		//Click radio button 2.0 Petrol, 147kW' và kiểm tra đã chọn
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		checkToCheckboxorRadio("//label[text()='2.0 Petrol, 147kW']//preceding-sibling::input");
		Assert.assertTrue(isElementSelected("//label[text()='2.0 Petrol, 147kW']//preceding-sibling::input"));
		
		
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
	
	//public void scrollToElement(String cssLocator) {
		//jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(cssLocator)));
	//}
}