package JavaTester;

import java.util.Random;

public class Topic_04_Random_Number {
	
	public static void main(String[] args) {
		Random random = new Random();
		//Khai báo biến random chạy bắt đầu từ số nguyên nhỏ hơn 111111
		random.nextInt(111111);
		System.out.println(random.nextInt(111111));
		System.out.println(random.nextInt(111111));
		System.out.println(random.nextInt(111111));
		System.out.println(random.nextInt(111111));
		
	}

}
