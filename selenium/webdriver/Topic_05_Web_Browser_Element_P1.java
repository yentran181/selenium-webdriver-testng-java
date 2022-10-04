package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_Element_P1 {
	//Khai báo
	WebDriver driver;
	WebElement element;
	
	//Khai báo + Khởi tạo
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		//Khởi tạo
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
// Cấu trúc hàm: Tên hàm(Tham số truyền vào hàm): Kiểu dữ liệu trả về (void: không có dữ liệu trả về; <>void: có dữ liệu trả về) - Hậu tố hàm (VD: WebDriver)
	@Test
// Tips: 
	// Với Action (click, select, close, open,refresh, back, foward,...) -> void
	// Với Verify: lấy dữ liệu URL, Title, Text, thuộc tính -> <>void
	// Hàm có tiền tố là get -> Verify
	// Hàm có tiền tố không phải get -> Action (trừ hàm get(URL)
	public void TC_01_Browser() {
		//Các hàm tương tác với Browser thông qua các biến driver
		//Hàm đóng tab/window đang active
		driver.close();
		
		//Hàm đóng browser
		driver.quit();
		
		//Tìm ra 1 element (single)
		WebElement loginButton = driver.findElement(By.cssSelector(""));
		
		//Tìm ra nhiều element (multiple)
		List<WebElement> links = driver.findElements(By.cssSelector(""));
		
		//Mở URL truyền vào
		driver.get("http://servertest.econtractapp.efy.com.vn/login");
		
		//Trả về URL tại page đang active
		String currentURL = driver.getCurrentUrl();
		
		//Trả về title page đang đứng
		String pageTitle = driver.getTitle();
		
		//Trả về source code của page đang active
		String sourceCode = driver.getPageSource();
		
		//Lấy ra ID của Tab/ Window đang active
		driver.getWindowHandle();
		
		//Lấy ra ID của tất cả Tab/ Window đang active
		driver.getWindowHandles();
		
		//Trả về Cookies (Framework)
		driver.manage().getCookies();
		
		//Trả về Logs (Framework)
		driver.manage().logs().getAvailableLogTypes();
		
		//Mở fullscreen
		driver.manage().window().fullscreen();
		
		//Mở full trình duyệt
		driver.manage().window().maximize();
		
		//Test GUI (Graphic User Interface)
		// Font/ Size/ Color/ Position
		//Ưu tiên làm chức năng trước, UI sau
		
		//Chờ cho element được tìm thấy trong khoảng n (s)
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Chờ cho page được load thành công sau n(s)
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		//Chờ cho script được inject thành công vào browser/element sau n(s) (JavascriptExcutor)
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		//Quay lại trang trước đó
		driver.navigate().back();
		
		//Đến trang tiếp theo
		driver.navigate().forward();
		
		//Load lại trang
		driver.navigate().refresh();
		
		//Đến URL mới
		driver.navigate().to("http://servertest.econtractapp.efy.com.vn/login");
		
		//Alert/ Frame (IFrame)/ Window (Tab)
		driver.switchTo().alert();
		
		driver.switchTo().frame(0);
		
		driver.switchTo().window("");
	}

	@Test
	public void TC_02_Element() {
		driver.get("http://servertest.econtractapp.efy.com.vn/login");
		//Các hàm tương tác với Elements sẽ thông qua class WebElement (biến nào đó)
	//	1. Khai báo biến và dùng lại
		
		//Khai báo biến với kiểu dữ liệu trả về của hàm findElement
		WebElement emailAddressTextbox = driver.findElement(By.id("email"));
		emailAddressTextbox.clear();
		emailAddressTextbox.sendKeys("abc@gmail.com");
		
	//	2. Dùng trực tiếp 
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
	//Khai thác:	
		//Tip:
		//1. Các hàm bắt đầu bằng tiền tố get -> trả về dữ liệu (có nhiều kiểu dữ liệu)
		//2. Các hàm có kiểu trả về là void -> Action lên browser/element
		//3. Các hàm bắt đầu bằng tiền tố is -> trả  về kiểu dữ liệu là boolean
		
		//Xóa dữ liệu trong 1 field dang editable (có thể nhập): Textbox, Text Area, Editable Dropdown
		element.clear();
		//Nhập dữ liệu vào field dạng editable
		element.sendKeys("");
		//Truyền dữ liệu dạng 1 keys từ bàn phím (VD: Enter)
		element.sendKeys(Keys.ENTER);
		//Click và elemment: button/ link/ checkbox/ radio/ Image/ ..
		element.click();
		
		//Trả về giá trị nằm trong attribute của element
			//Lấy giá trị placeholder của 1 field dạng editable
			element.getAttribute("placeholder");
		
		//Trả về thuộc tính CSS của element: Font/ Size/ Color/...
			//Trả về màu nền của element
			element.getCssValue("background-color");
			//Trả về font size của element
			element.getCssValue("font-size");
			//Point/ Rectangle/ Size (Visualize Testing)
			element.getLocation();
			element.getRect(); 
			element.getSize();
			
			//Chụp hình và attach vào file HTML Report
			element.getScreenshotAs(OutputType.FILE);
			
			//Trả về thẻ HTML của element (RẤT ÍT DÙNG)
			WebElement emailAddressTextbox1 = driver.findElement(By.xpath("//input[@id = 'email']"));
			WebElement emailAddressTextbox2 = driver.findElement(By.cssSelector("input[id = 'email']"));
			emailAddressTextbox1.getTagName();
			emailAddressTextbox2.getTagName();
			
			//Trả về text của 1 element (Link, Header, Message error, Message success,...)
			element.getText();
			
			//Trả về giá trị đúng hoặc sai của 1 element có hiển thị hay không
			element.isDisplayed();
			
			//Trả về giá trị đúng hoặc sai của 1 element có tương tác được hay không
			element.isEnabled();
			
			//Trả về giá trị đúng hoặc sai của 1 element có được chọn hay không (Checkbox/ Radio/ Dropdownlist/ Selectbox/..)
			element.isSelected();
			
			//
			//Chỉ làm việc với thẻ form (Login form, Register form, Search form,...)
			//Submit = ENTER  ở 1 field nào đó
			//Submit vào 1 field nào đó trong form
			element.submit();
			
			
			
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}