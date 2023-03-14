package JavaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_10_Loop_Statement_While_DoWhile {
	
	Scanner scanner = new Scanner(System.in);
	
	
	public void TC_01() {
		System.out.println("Nhap n: ");
		int n = scanner.nextInt();
		if (n < 0 || n > 100) {
			throw new RuntimeException("Please input the correct number in 1 to 100");
		} else {
			System.out.print("Day so chia het cho 2 tu n den 100: ");
		while (n <= 100) {
			if (n % 2 == 0) {
				System.out.print(n  + " ");

			} 
			n++;
		}
	}
	}
	

	public void TC_02() {
		System.out.println("Nhap a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap b: ");
		int b = scanner.nextInt();
		if (b<a) {
			throw new RuntimeException("A number must be less than B number");
		} else {
			System.out.print("Day so tu a den b chia het cho 3 va 5: ");
			int i = a;
			while (i<=b) {
				if (i % 3 == 0 && i % 5 == 0) {
					System.out.print(i  + " ");

			}
				i++;
		}
	}
	}
	

	public void TC_03() {
		System.out.println("Nhap n: ");
		int n = scanner.nextInt();

		if (n < 0) {
			throw new RuntimeException("Please input n greater than 0");
		} else {
			System.out.print("Day so le tu 0 den n: ");
			int sum = 0;
			int i = 0;
			
			do {	
				if (i % 2 == 1) {
					System.out.print(i  + " ");
					sum = sum + i;
				} i++;
			} while (i <= n);
			System.out.println("\nTong cac so le tu 0 den n: " + sum);
		}
			
	}
	

	public void TC_04() {
		System.out.println("Nhap a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap b: ");
		int b = scanner.nextInt();

		if (a > b) {
			throw new RuntimeException("Please input a less than b");
		} else {
			System.out.print("Day so chia het cho 3 tu a den b: ");
			int i = a;
			
			do {	
				if (i % 2 == 1) {
					System.out.print(i  + " ");
				} i++;
			} while (i <= b);
		}
			
	} 
	

	public void TC_05() {
		System.out.println("Nhap n: ");
		int n = scanner.nextInt();

		if (n < 0) {
			throw new RuntimeException("Please input n greater than 0");
		} else {
			int giaithua = 1;
			int i = 1;
			
			do {
				giaithua = giaithua * i;
				i++;
			} while (i <= n);
			System.out.println("n! = " + giaithua);
		}
			
	}
	
	@Test
	public void TC_06() {
		int number[] = {1,2,3,4,5,6,7,8,9,10};
		int sum = 0;
		System.out.print("Day so chan: ");
		for (int i : number) {
			while (i % 2 == 0) {
				System.out.print(i + " ");
				sum = sum + i;
				i++;
				
			}
		}	
		System.out.println("\nTong so chan = " + sum);
	}
}

