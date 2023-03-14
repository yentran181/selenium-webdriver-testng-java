package JavaBasic;

import java.util.Iterator;
import java.util.Scanner;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Topic_13_String {
	WebDriver driver;
	//String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	

	public void TC_00_(){
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		String schoolName = "Automation Testing";
		String SchoolAddress = "Ho Chi Minh City";
		String courseName = "AUTOMATION TESTING";
		
		//Lấy độ dài của chu
		schoolName.length();
		
		//Lấy ký tự từ index
		schoolName.charAt(0);
		
		//Nối 2 chuỗi: dùng phép + hoặc hàm concat
		schoolName.concat(SchoolAddress);
		System.out.println(schoolName + SchoolAddress);
		
		//So sánh tuyệt đối 2 chuỗi bằng nhau có phân biệt hoa thường
		System.out.println(schoolName.equals(SchoolAddress));
		
		//So sánh tương đối không phân biệt hoa thường
		System.out.println(schoolName.equalsIgnoreCase(courseName));
		
		//Check ký tự đầu, cuối, giữa: startsWith - endsWith - contains
		schoolName.startsWith("A");
		schoolName.endsWith("G");
		schoolName.contains("Automation");
		
		//Lấy index của từ trong chuối:
		schoolName.indexOf("Testing"); //Lấy index của từ Testing trong chuỗi
		
		//Lấy chuỗi con, tách chuỗi: split/substring
		schoolName.substring(0, 10);
		schoolName.substring(7);
		
		//Replace ký tự bằng ký tự khác
		schoolName.replace("T", "t");
		
		//Sắp xếp: sort data ASC, DESC cần phải convert từ chuỗi -> số 
//		Float schoolNameF = Float.parseFloat(schoolName);
//		schoolName = String.valueOf(schoolNameF);
		
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		// => Windows 10 -> cần chuyển về lowkey để check
		if (osName.toLowerCase().contains("window")) {
			Keys key = Keys.CONTROL;
		} else {
			Keys key = Keys.COMMAND;
		}
		
		String driverInstanceName = driver.toString();
		System.out.println(driverInstanceName);
		// => ChromeDriver: chrome on WINDOWS (d177008b82986d82cf8320bb541f2029)
		
		
		//Trimspace: cắt bỏ khoảng trắng ở đầu và cuối chuỗi
		schoolName.trim();
		
		//Format: dùng cho Dynamic locator
		String dynamicButtonXpath = "//button[@id='%s']"; //truyền tham số string  vào %s
		System.out.println("Click to Login button = " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));
		System.out.println("Click to Login button = " + dynamicButtonXpath.format(dynamicButtonXpath, "search"));

	}
	

	public void TC_01_() {
		System.out.println("Nhap chuoi: ");
		String className = scanner.nextLine();
		char classNameArray[] = className.toCharArray();
		int countUpper = 0;
		int countLower = 0;
		int countNumber = 0;
		
		for (char c : classNameArray) {
			//Uppercase
			if (c >= 'A' && c <= 'Z') { //phép so sánh này cần p chuyển dữ liệu string -> char 
				countUpper +=1;
			} 
			//Lowercase
			if (c >= 'a' && c <= 'z') { //phép so sánh này cần p chuyển dữ liệu string -> char 
				countLower +=1;
			}
			
			//Number
			if (c >= '0' && c <= '9') { //phép so sánh này cần p chuyển dữ liệu string -> char 
				countNumber +=1;
			}
		}
		System.out.println("Sum of uppercase = " + countUpper);
		System.out.println("Sum of uppercase = " + countLower);
		System.out.println("Sum of uppercase = " + countNumber);
	}
	

	public void TC_02_() {
		String string = "Automation Testing 345 Tutorials Online 789";
		char stringArray[] = string.toCharArray();
		int counta = 0;
		int countNum = 0;
		for (char character : stringArray) {
			//count a
			if (character == 'a') {
				counta +=1;
			}
			//count number
			if (character >= '0' && character <= '9') {
				countNum +=1;
			}
		}
		System.out.println("Sum of a = " + counta);
		System.out.println("Contain Testing: " + string.contains("Testing"));
		System.out.println("Starts with Automation: " + string.startsWith("Automation"));
		System.out.println("Ends with Online: " + string.endsWith("Online"));
		System.out.println("Index of Tutorials " + string.indexOf("Tutorials"));
		System.out.println("Replace Online by Offline " + string.replace("Online", "Offline"));
		System.out.println("Sum of number = " + countNum);
		
	}
	
	@Test
	public void TC_03_() {
		
		String string = "Blue";
		char stringArray[] = string.toCharArray();
		for (int i = stringArray.length - 1; i >= 0; i--) {
			System.out.print(stringArray[i]);
		}
	}
	


}
