package JavaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_08_P1_Condition_Statement_Switch_Case {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browser")
	public void TC_01_(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println(browserName);
		driver.quit();
//		switch (browserName) {
//		case "chrome":
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//			break;
//
//		case "firefox":
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//			break;
//			
//		case "edge":
//			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
//			driver = new EdgeDriver();
//			break;
//
//		default:
//			new RuntimeException("Please input the correct browser name!");
//			break;
//		}
//		System.out.println(browserName);
//		System.out.println(driver.toString());
//		driver.quit();
	}
	

	public void TC_02_() {
		System.out.println("Nhap thang trong nam: ");
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Thang " + month + " co 31 ngay");		
			break;
		case 2:
			System.out.println("Thang " + month + " co 28 ngay");		
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Thang " + month + " co 30 ngay");		
			break;
		default:
			new RuntimeException("Pleae input the correct month of year");
			break;
		}
		
	}
	

	public void TC_03_() {
		System.out.println("Nhap so tu 1 den 10: ");
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("One");		
			break;

		case 2:
			System.out.println("Two");			
			break;

		case 3:
			System.out.println("Three");		
			break;

		case 4:
			System.out.println("Four");		
			break;

		case 5:
			System.out.println("Five");		
			break;

		case 6:
			System.out.println("Six");		
			break;

		case 7:
			System.out.println("Seven");		
			break;
		case 8:
			System.out.println("Eight");		
			break;

		case 9:
			System.out.println("Nine");		
			break;

		case 10:
			System.out.println("Ten");		
			break;

		}
	}
	
	@Test
	public void TC_04_() {
		System.out.println("Nhap a");
		int numbera = scanner.nextInt();
		System.out.println("Nhap b");
		int numberb = scanner.nextInt();
		System.out.println("Nhap phep toan");
		String operator = scanner.nextLine();
		
		switch (operator) {
		case "+":
			System.out.println("a + b = " + (numbera + numberb));
			break;
			
		case "-":
			System.out.println("a - b = " + (numbera - numberb));
			break;
			
		case "*":
			System.out.println("a * b = " + (numbera * numberb));
			break;
			
		case "/":
			System.out.println("a / b = " + (numbera / numberb));
			break;
			
		case "%":
			System.out.println("a / b = " + (numbera % numberb));
			break;

		default:
			System.out.println("Please input the correct operator");
			break;
		}
		
	}
	
	public WebDriver getBrowserDriver(String browserName) {
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

		default:
			new RuntimeException("Please input the correct browser name!");
			break;
		}
		return driver;
	}

}
