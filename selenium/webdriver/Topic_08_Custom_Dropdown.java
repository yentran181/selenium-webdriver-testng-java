package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Custom_Dropdown {
	
	//Khai báo
	WebDriver driver;
	WebDriverWait explicitWait;
	List<WebElement> allItems;
	JavascriptExecutor jsExecutor;

	Select select;
	String province, registration ;
	//Vừa khai báo vừa khởi tạo
	String projectPath = System.getProperty("user.dir");
  

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		
		//Khởi tạo driver
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().window().setSize(new Dimension(1368,768));
		//Khởi tạo explicitWait
		explicitWait = new WebDriverWait(driver, 30);
		
		province = "Hà Nội";
		registration = "Khu vực I";
		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		}
	

	@Test
	public void TC_01_Page_jQueryUI() {

		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html"); 
		//Cách hanle với custom dropdown
		//1. Click vào 1 phần tử dropdown để xổ ra danh sách giá trị
		driver.findElement(By.cssSelector("span#number-button")).click();
		//2. Chờ cho tất cả giá trị trong dropdown được load xong
			//Không dùng sleep cứng mà dùng hàm wait để linh động (không cần chờ hết time mà chỉ cần tìm được sẽ next bước tiếp theo luôn)
			//presenceOfAllElementsLocatedBy: Chờ cho tất cả element được load ra thành công trong cây HTML/DOM
			//visibilityOfAllElements: Chờ cho tất cả element được load ra thành công trong cây HTML/DOM và phải có trên giao diện
			//Bắt được 1 locator để lấy được all item
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
			
		//3.1 Nếu item cần chọn đang hiển thị
		//3.2 Nếu item cần chọn không hiển thị thì cần scroll down
		//4. Kiểm tra text của item, đúng với giá trị cần thì click vào
			//Viết code để kiểm tra từng item theo điều kiện duyệt
			//Để duyệt được cần lưu trữ all items
		List<WebElement> allItemsNumber = driver.findElements(By.cssSelector("ul#number-menu div"));
		//Duyệt item -getText và kiểm tra có phải text mong muốn thì click. Duyệt thì dùng vòng lặp for
		for (WebElement item : allItemsNumber) {
			String itemText = item.getText();
			if (itemText.equals("4")) {
				item.click();
			}
			
		}
		

		selectItemInCustomDropdown("span#number-button","ul#number-menu div","4");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "4");
		
		//Chọn số 3
		selectItemInCustomDropdown("span#number-button","ul#number-menu div","2");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "2");
		
		//Chọn speed = Medium
		selectItemInCustomDropdown("span#speed-button","ul#speed-menu div","Medium");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Medium");
		
		//Chọn speed = Fast
		selectItemInCustomDropdown("span#speed-button","ul#speed-menu div","Fast");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Fast");
		
		//Chọn title = Other
		selectItemInCustomDropdown("span#salutation-button", "ul#salutation-menu div", "Other");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Other");
		
		//Chọn title = Mrs.
		selectItemInCustomDropdown("span#salutation-button", "ul#salutation-menu div", "Mrs.");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Mrs.");
				
		
	}
	

	@Test
	public void TC_02_Page_Honda() {
		driver.get("https://www.honda.com.vn/o-to/du-toan-chi-phi");
		scrollToElement("img.image-background");
		sleepInSecond(3);
		
		selectItemInCustomDropdown("button#selectize-input", "div.dropdown-menu.show a", "CITY L");
		Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).getText(), "CITY L");
		
		scrollToElement("img.img-dtcp.d-block");
		sleepInSecond(3);

		select = new Select(driver.findElement(By.cssSelector("select#province")));
		select.selectByVisibleText(province);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), province);
		
		select = new Select(driver.findElement(By.cssSelector("select#registration_fee")));
		select.selectByVisibleText(registration);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), registration);
		
		driver.findElement(By.cssSelector("input.btn-cost-estimates")).click();
		
		
		
		
	}

	@Test
	public void TC_03_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		selectItemInCustomDropdown("div.dropdown", "div.item span.text", "Jenny Hess");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(),"Jenny Hess");
		
		
		selectItemInCustomDropdown("div.dropdown", "div.item span.text", "Christian");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(),"Christian");
		
		selectItemInCustomDropdown("div.dropdown", "div.item span.text", "Justen Kitsune");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(),"Justen Kitsune");
		
		
	}
	
	@Test
	public void TC_04_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		selectItemInCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu li a", "First Option");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");
		
		
		selectItemInCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu li a", "Second Option");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");
		
		selectItemInCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu li a", "Third Option");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");
		
		
	}
	
	@Test
	public void TC_05_Editable_Dropdown() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		
		enterItemInCustomDropdown("input.search", "div.item span.text", "Afghanistan");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(),"Afghanistan");
		
		enterItemInCustomDropdown("input.search", "div.item span.text", "Antigua");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(),"Antigua");
		
		enterItemInCustomDropdown("input.search", "div.item span.text", "Benin");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(),"Benin");
		
	}
	
	//Sleep cứng (Static wait)
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
	
	public void scrollToElement(String cssLocator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(cssLocator)));
		
	}
	
	public void selectItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem) {
		driver.findElement(By.cssSelector(parentLocator)).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		allItems = driver.findElements(By.cssSelector(childLocator));
		for (WebElement item : allItems) {
			String textActualItem = item.getText();
			if(textActualItem.equals(textExpectedItem)) {
			item.click();
			break; //khi đã tìm thấy rồi thì break vòng lặp luôn không tìm nữa
		}
			
		}

	}

	public void enterItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem) {
		driver.findElement(By.cssSelector(parentLocator)).sendKeys(textExpectedItem);
		sleepInSecond(1);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		allItems = driver.findElements(By.cssSelector(childLocator));
		for (WebElement item : allItems) {
			String textActualItem = item.getText();
			if(textActualItem.equals(textExpectedItem)) {
			item.click();
			break; //khi đã tìm thấy rồi thì break vòng lặp luôn không tìm nữa
		}
			
		}

	}
}