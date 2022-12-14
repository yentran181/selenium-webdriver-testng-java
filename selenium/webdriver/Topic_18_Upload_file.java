package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Upload_file {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	String IDcardFileName = "VMEC-ID Nguyễn Xuân Hưng_2022_TTUDYHTT&CNC.pdf";
	String listUserFileName = "Thong tin user ERP.xlsx";
	String txtFileName = "n.txt";
	String contractFileName = "2022.09.13_HD mua ban cac san pham con lai_VM-KH.docx";

	String IDcardFilePath = projectPath+"\\Uploaded Files\\"+IDcardFileName;
	String listUserFilePath = projectPath+"\\Uploaded Files\\"+listUserFileName;
	String txtFilePath = projectPath+"\\Uploaded Files\\"+txtFileName;
	String contractFilePath = projectPath+"\\Uploaded Files\\"+contractFileName;

// Lấy đường dẫn file: Right click vào tên file/thư mục -> Properties -> mục Location	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//		Tùy vào dự án đang làm sẽ chấp nhận những loại file gì
//		- Document: .doc, .docx, .xlsx, .xlsm, .pptx, .pdf, .driver.close();...
//		- Image: .jpg, .jpeg, .png, .pdf
//		- Các TH test:
//			- Đúng loại file
//			- Không đúng loại file
//			- Vượt quá kích thước cho phép
//			- Có cho phép upload nhiều file cùng lúc hay không

		
//		Có 4 cách upload file với Selenium:
		// 1. Selenium Senkeys method: đơn giản,dễ dùng, tiết kiêm time nhất, support nhiều trình duyệt, nhiều hệ điều hành, upload 1/n files cùng lúc 
		// 2. AutoIT: only for Windows OS, không support cho MAC OS và Linux OS
		// 3. Java Robot class: support nhiều OS, nhưng trên MAC và Linux không có chỗ paste được đường link của file => only for Windows
		// 4. Sikuli là thư viên thao tác với hình ảnh, nếu độ phân giải màn hình thay đổi, kích thước ảnh cũng bị thay đổi theo dẫn đến kết quả test không chính xác.
	// => 3 cách sau có thể sử dụng nhưng không mang lại nhiều value, khó apply, không support nhiều bằng sendKeys	
		
//		Nên tạo folder chứa file cần upload ở bên trong Source Code để tránh TH chạy ở trên các máy khác nhau nếu link ở trên các thư mục ngoài source code sẽ không tìm được do khác thiết bị
		
	}

	@Test
	public void TC_01_Upload_1_file() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.xpath("//form[@id='fileupload']//input[@type='file']")).sendKeys(IDcardFilePath);
		sleepInSecond(5);
			
	}

	@Test
	public void TC_02_() {
		
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
		driver.quit();
	}

}