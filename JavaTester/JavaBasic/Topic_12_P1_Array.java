package JavaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_12_P1_Array {

	public void main (String [] args) {
		//Các cách khai báo mảng dữ liệu tĩnh
		String studentNames[] = {"Nam", "Hoa", "Long", "Linh"};
		//Khai báo số lượng phần tử của mảng
		//int a[] = new int[5];
		//Duyệt dữ liệu bằng vòng lặp for
		for (int i = 0; i< studentNames.length; i++) {
			System.out.println(studentNames[i]);
		}
		//Duyệt dữ liệu bằng vòng lặp foreach- không kết hợp được vs index
		for (String std : studentNames) {
			System.out.println(std);
		}
		
		//Mảng ArrayList: dữ liệu mảng động đc add vào thông qua chạy loop for-> khi chạy code mới adđ
		ArrayList<String> stdNames = new ArrayList<String>();
		for (String std : stdNames) {
			stdNames.add(std);
			
		//Phương thức của mảng:
		//Chuyển từ array -> list
		List<String> names = Arrays.asList("Tom", "Jerry", "Donald");
		for (String name : names) {
			System.out.println("Name: " + name);
		
		//So sánh 2 mảng
		int[] a = {1,2,4,6};
		int[] b = {1,2,4,7};	
		System.out.println(Arrays.equals(a, b));
		
		//Gán cùng giá trị cho tất cả phần tử trong mảng
		Arrays.fill(a, 100); //gám toàn bộ giá trị trong mảng = 100
		
		//Sort mảng
		Arrays.sort(b);
		
		//Chuyển array -> string
		String aString = Arrays.toString(a);
		}
		
		
		}
	}
}
