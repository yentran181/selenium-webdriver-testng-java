package JavaBasic;

public class Topic_12_P2_Array_Exercise {

	public static void main0 (String[] args) {
		int arr[]= {2,7,16,8,9};
		int max = arr[0];
		for (int i : arr) {
			if (i > max) {
				max = i;
			} else 
				continue;			
		}
		System.out.println("So lon nhat trong mang: " + max);
	}
	public static void main1 (String[] args) {
		int arr[]= {2,7,16,8,9};
		int sum = arr[0] + arr[arr.length-1];
		System.out.println("Tong phan tu dau tien va cuoi cung trong mang = " + sum);
	}
	
	public static void main2 (String[] args) {
		int arr[]= {2,7,16,8,9,4,3,6,19};
		System.out.print("Cac phan tu la so chan trong mang: ");
		for (int i : arr) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			} else 
				continue;			
		}
	}
	
	public static void main3 (String[] args) {
		int arr[]= {2,7,16,-8,9,4,-3,6,19};
		int sum = 0;
		for (int i : arr) {
			if (i > 0 && i % 2 == 1) {
				sum +=i;
			} else 
				continue;			
		}
		System.out.println("Tong cac phan tu la so le và lon hon 0 = " + sum);
	}
	
	public static void main4 (String[] args) {
		int arr[]= {2,7,16,-8,9,4,-3,6,19};
		System.out.print("Cac phan tu >=0 va <=10 trong mang: ");
		for (int i : arr) {
			if (i >= 0 && i <= 10) {
				System.out.print(i + " ");
			} else 
				continue;			
		}
	}
	
	public static void main (String[] args) {
		int arr[]= {1,4};
		float sum = 0;
		float avg = 0;
		for (int i : arr) {
			sum +=i;
			avg = sum/arr.length;
		}
		System.out.println("Tong = " + sum);
		System.out.println("Trung binh cong = " + avg);
	}
}
