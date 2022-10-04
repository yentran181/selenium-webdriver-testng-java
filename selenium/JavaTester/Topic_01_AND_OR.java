package JavaTester;

public class Topic_01_AND_OR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// Đề bài: Có 2 điều kiện, kết hợp AND (&&) hoặc OR (||) giữa 2 điều kiện này  để ra kết quả TRUE/FALSE
		
		//Khai báo các biến:
		boolean firstCondition;
		boolean secondCondition;
		
	//Toán tử AND: Chỉ đúng khi cả 2 điều kiện đều đúng, nếu 1 trong 2 điều kiên sai thi kết quả sai
		firstCondition = true;
		secondCondition = false;
		System.out.println(firstCondition&&secondCondition);
		
		firstCondition = false;
		secondCondition = true;
		System.out.println(firstCondition&&secondCondition);
		
		firstCondition = false;
		secondCondition = false;
		System.out.println(firstCondition&&secondCondition);
		
		firstCondition = true;
		secondCondition = true;
		System.out.println(firstCondition&&secondCondition);
		
	//Toán tử OR: Kết quả đúng khi 1 trong 2 điều kiện đúng
		firstCondition = true;
		secondCondition = false;
		System.out.println(firstCondition||secondCondition);
		
		firstCondition = false;
		secondCondition = true;
		System.out.println(firstCondition||secondCondition);
		
		firstCondition = false;
		secondCondition = false;
		System.out.println(firstCondition||secondCondition);
		
		firstCondition = true;
		secondCondition = true;
		System.out.println(firstCondition||secondCondition);
	}
	
	

}
