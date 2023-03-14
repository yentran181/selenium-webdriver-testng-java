package JavaBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import net.bytebuddy.agent.builder.AgentBuilder.Transformer.ForAdvice;

public class Topic_09_P2_Loop_Statement_For_Each {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	
	public void TC_01_demo() {
	//Java generic
	List<WebElement> links = driver.findElements(By.xpath("")) ;
	
	//Dùng foreach để duyệt qua tất cả element 
	//Xử lý dữ liệu: get text/ value/ css/ attribute
	//Không dùng để thao tác với element như click để chuyển page -> dẫ đến refresh DOM/HTML, các element đã find sẽ không còn tồn tại, testcase FAIL: StaleElementException
	for (WebElement link : links) {
		link.getText();
	}
	
	}
	
	
	
	public void TC_02() {
		System.out.println("Nhap a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap b: ");
		int b = scanner.nextInt();
		if (a>=b) 
			System.out.println("Khong the in ra day so tu a den b vi a lon hon hoac bang b");
		 else for (int i = a; i <= b; i++) {
			 System.out.print(i + " "); 
		 }
		}
	

	public void TC_03() {
		int sum = 0;
		System.out.print("Day so chan tu 1 den 10: ");
		for(int i = 1; i<=10;i++)
			if (i % 2 == 0) {
				sum = sum + i;
				System.out.print( i + " ");
			}
		System.out.println("\nTong cac so chan tu 1 den 10 = " + sum);
		 
	 }
	

	public void TC_04() {
		System.out.println("Nhap a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap b: ");
		int b = scanner.nextInt();
		int sum = 0;
		if (a<b) {
			System.out.print("Day so tu a den b: ");
			for (int i = a; i <= b; i++) {
			System.out.print(i + " ");
			sum = sum + i;
			}
			System.out.println("\nTong day so tu a den b = " + sum);
		}
		 else
			 System.out.println("Khong the in ra day so tu a den b vi a lon hon hoac bang b");
		

	}
	

	public void TC_05() {
		
		System.out.println("Nhap n");
		int n = scanner.nextInt();
		int sum = 0;
		System.out.print("Day so le tu 0 den n: ");
		for(int i = 0; i<=n; i++)
			if (i % 2 == 1) {
				System.out.print(i + " ");
				sum = sum + i;
			
			}
			System.out.println("\nTong cac so le du 0 den n: " + sum);
	}
	

	public void TC_06() {
		System.out.println("Nhap a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap b: ");
		int b = scanner.nextInt();
		if (a<b) {
			System.out.print("Day so chia het cho 3 tu a den b: ");
			for (int i = a; i <= b; i++) {
				if (i % 3 == 0) {
					System.out.print(i + " ");
				}
			}
		}
		 else
			 System.out.println("Khong the in ra day so tu a den b vi a lon hon hoac bang b");
	}
	
	@Test
	public void TC_07() {
		
		System.out.print("Nhap n: ");
		int n = scanner.nextInt();
		int giaithua = 1;
		for(int i = 1; i<=n; i++)
			giaithua = giaithua * i;
		
		System.out.println(n+"! = " + giaithua);
	
	}
}
