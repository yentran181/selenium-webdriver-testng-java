package JavaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_11_Break_Continue {
	
	//Break: Thoát luôn khỏi vòng lặp
	//Continue: trừ 1 hay vài TH sẽ không chạy, vẫn chạy các case còn lại 
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@Parameters ("browser")
	@Test
	public void TC_03_If_Else_If(String browserName) {
		
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":		
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "coccoc":
			throw new RuntimeException("Please input correct browser name!");
		}
		driver.quit();
		
//		if  (browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//		} else if (browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		} else if (browserName.equalsIgnoreCase("edge")) {
//			break;
//		} else //Safari/Opera/Coccoc...
//			throw new RuntimeException("Please input correct browser name!");
//		
//		System.out.println(browserName);
//		System.out.println(driver.toString());
	}

}
