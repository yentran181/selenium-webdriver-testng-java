package JavaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_P1_Loop_Statement_For {

	Scanner scanner = new Scanner(System.in);
	

	public void TC_01_1() {
		 
		System.out.println("Nhap n");
		int n = scanner.nextInt();
		for (int i = 1; i<=n; i++)
			System.out.print(i + " ");
	 }
	
	

	public void TC_01_2() {
		 
		System.out.println("\nNhap n");
		int n = scanner.nextInt();
		int i = 1;
		for (;i<=n;) {
			System.out.print(i + " ");
			i++;
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
