package JavaBasic;

import java.time.Month;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_07_P2_Condition_Statement_If_Else_Exercise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	

	public void TC_01_Bai_1_BT_tam_nguyen() {
	System.out.println("Nhap so bat ky: ");
	int number = scanner.nextInt();
	
	String result = (number % 2 == 0) ? number + " là số chẵn": number + " là số lẻ";
	System.out.println(result);
			
	}
	

	public void TC_02_Bai_1_If_Else() {
	System.out.println("Nhap so bat ky: ");
	int iNumber = scanner.nextInt();
	
	if (iNumber % 2 == 0) {
		System.out.println(iNumber + " là số chẵn");
		
	} else
		System.out.println(iNumber + " là số lẻ");			
	}
	

	public void TC_03_Bai_2_If_Else() {
	System.out.println("Nhap a: ");
	int a = scanner.nextInt();
	
	System.out.println("Nhap b: ");
	int b = scanner.nextInt();
	
	if (a>b) {
		System.out.println("a lớn hơn b");
		
	} else if (a<b) {
		System.out.println("a nhỏ hơn b");
	} else if (a==b)
		System.out.println("a bằng b");			
	}
	

	public void TC_04_Bai_3_If_Else() {
	System.out.println("Nhap ten nguoi thu nhat: ");
	String firstName = scanner.nextLine();
	
	System.out.println("Nhap ten nguoi thu hai: ");
	String secondName = scanner.nextLine();
	
	if (firstName.equalsIgnoreCase(secondName)) {
		System.out.println("2 người cùng tên");
		
	} else 
		System.out.println("2 người khác tên");	
	}
	
	public void TC_05_Bai_4_If_Else() {
	System.out.println("Nhap i1: ");
	int i1 = scanner.nextInt();
	
	System.out.println("Nhap i2: ");
	int i2 = scanner.nextInt();
	
	System.out.println("Nhap i3: ");
	int i3 = scanner.nextInt();
	int max =i1;
	if (max < i2) {
		max = i2;	
	}
	if (max < i3) 
		max = i3;	
	System.out.println("So lon nhat = " + max);
	}
	
	
	public void TC_06_Bai_5_If_Else() {
		System.out.println("Nhap a: ");
		int a = scanner.nextInt();
		if (a>=10 && a<=100) {
			System.out.println(a + " nằm trong khoảng 10 đến 100.");
		} else
			System.out.println(a + " nằm ngoài khoảng 10 đến 100.");	
	}
	
	@Test
	public void TC_07_Bai_6_If_Else() {
		System.out.println("Nhập điểm của sinh viên: ");
		float diem = scanner.nextFloat();
		if (diem >= 8.5 && diem <= 10) {
			System.out.println("Điểm A");
		} else if (diem >= 7.5 && diem < 8.5) {
			System.out.println("Điểm B");
		} else if (diem >=5 && diem < 7.5) {
			System.out.println("Điểm C");
		} else if (diem >= 0 && diem < 5) {
			System.out.println("Điểm D");
		} else 
			throw new RuntimeException("Please fill the correct score! ");
	}
	
	@Test
	public void TC_08_Bai_7_If_Else() {
		System.out.println("Nhập tháng trong năm: ");
		int diem = scanner.nextInt();
		if (diem >= 8.5 && diem <= 10) {
			System.out.println("Điểm A");
		} else if (diem >= 7.5 && diem < 8.5) {
			System.out.println("Điểm B");
		} else if (diem >=5 && diem < 7.5) {
			System.out.println("Điểm C");
		} else if (diem >= 0 && diem < 5) {
			System.out.println("Điểm D");
		} else 
			throw new RuntimeException("Please fill the correct score! ");
	}

}
