package JavaBasic;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Topic_03_Data_Type {

//		public static void main(String[] args) {
//		// Thông tin của 1 nhân viên
//		// Tên/ Tuổi/ Ngày sinh/ Giới tính/ Quê quán/ Lương...
//		// Ánh xạ thông tin này trong lập trình
//			
//		// Lập trình Java bao gồm 2 kiểu dữ liệu
//			// Kiểu dữ liệu nguyên thủy - Primitive (8 loại)
//				// Số nguyên: byte/ short/ int/ long
//				// Só thực: float/ double
//					// Với kiểu float và double thì giá trị sẽ có f hoặc d liền sau, 
//					float salary = 1.5f; 
//					double point = 9.8d;
//				// Ký tự: char
//					// Với kiểu char, giá trị nằm tron dấu nháy đơn ' ' và chỉ chứa duy nhất 1 ký tự
//					char a = 'a';
//				// Logic: boolean
//					// Kiểu boolean chỉ chứa 2 giá trị Đúng và Sai
//					boolean marriedStatus = true;
//					marriedStatus = false; 
//			
//			//Kiểu dữ liệu tham chiếu - Reference
//				// Chuối: string
//					//Với kiểu string, dữ liệu nằm trong dấu nháy đôi " " và có thể chứa chữ, số, ký tự đặc biệt
//					String adddress = "Hà Nội";
//					String email = "yentt@efy.com.vn";
//	//Cách xem source code của thư viên Selenium:
//		//Mục đích: - Hiểu được kiến trúc thư viện
//		//			- Cách dùng thư viện
//		//			- Add file source vào libraries nhưng không cần add Build Path
//				// Class/ Interface
//					Date date = new Date();
//				// Object
//					Object student; 
//				// Array - khai báo số lượng dữ liệu trước
//					int numbers[] = {1, 2, 3};
//					String address[] = {"DaNang", "HaNoi", "HCM"};
//				// List/ Set/ Queue (Collection) - Động
//					List<Integer> studentNumber = new ArrayList<Integer>();
//					List<String> studentAddress = new ArrayList<String>();
//					
//					Set<String> studentCity = new LinkedHashSet<String>();
//		// Khai báo biến: Kiểu dữ liệu biến/ Tên biến/ Giá trị của biến
//		// Cách 1: Vừa khai báo vừa gán giá trị
//			// VD: String name = "Tran Thi Yen";
//		
//		// Cách 2: Khai báo trước, gán giá trị sau
//			// String name;
//			// name = "Tran Thi Yen";
//		}
//		
	public static void main(String[] args) {
	//Bai 1:
		int a = 6;
		int b = 2;
		int P1 = a + b;
		int P2 = a - b;
		int P3 = a * b;
		int P4 = a / b;
		System.out.println("Bai 1:");
		System.out.println("P1 = " + P1);
		System.out.println("P2 = " + P2);
		System.out.println("P3 = " + P3);
		System.out.println("P4 = " + P4);
		
	//Bai 2:
		float d = 7.5f;
		float r = 3.8f;
		float P = d*r;
		System.out.println("\nBai 2:");
		System.out.println("Dien tich HCN P = " + P);
		
	//Bai 3:		
		String name = "Automation Testing";
		System.out.println("\nBai3:");
		System.out.println("Hello " + name);

	}


}
