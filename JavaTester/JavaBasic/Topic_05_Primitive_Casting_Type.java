package JavaBasic;

public class Topic_05_Primitive_Casting_Type {
	public static void main(String[] args) {
		
		//Ép kiểu ngầm định: không mất dữ liệu mà chỉ tạo ra biến mới có dữ liệu kiểu mới
		
//		byte bNumber = 126;
//		System.out.println(bNumber);
//		
//		short sNumber = bNumber;
//		System.out.println(sNumber);
//
//		int iNumber = sNumber;
//		System.out.println(iNumber);
//
//		long lNumber = iNumber;
//		System.out.println(lNumber);
//
//		float fNumber = lNumber;
//		System.out.println(fNumber);
//
//		double dNumber = fNumber;
//		System.out.println(dNumber);
		
		//Ép kiểu tường minh: cast
		
		double dNumber = 987654333333333445d;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) fNumber;	
		System.out.println(lNumber);
		
		int iNumber = (int) lNumber;
		System.out.println(iNumber);
		
		short sNumber = (short) iNumber;
		System.out.println(sNumber);
		
		byte bNumber = (byte) sNumber;
		System.out.println(bNumber);
		

	}
}
