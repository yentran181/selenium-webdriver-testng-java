package JavaBasic;

public class Topic_04_Operator {

	public static void main(String[] args) {
	//Bai 1:
		String name = "Yen";
		int realAge =  26;
		System.out.println("Bai 1:");
		System.out.println("After 15 years, age of " + name + " will be " + (realAge + 15) );
	
	//Bai 2:
		System.out.println("\nBai 2:");
		int a = 1;
		int b = 2;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);

	//Bai 3:
		System.out.println("\nBai 3:");
		int n = 3;
		int m = 2;
		boolean result = (n>m)? true : false;
		System.out.println("Ket qua: " + result);
	}
	
}
