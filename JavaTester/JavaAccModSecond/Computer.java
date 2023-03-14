package JavaAccModSecond;

//Access abstract chỉ cho phép kế thừa (extends), không cho khởi tạo đối tượng mới
//public abstract class Computer {}
public class Computer {
	//Property
	private int ssdSize; //biến toàn cục
	//Mehthod
	private void setssdSize(int ssdSize) {
		this.ssdSize = ssdSize; //dùng this để gọi biến ssdSize toàn cục, nếu k dùng thì sẽ hiểu là lấy biến cục bộ. TH này có thể đặt tên biến khác nhau để k cần dùng this mà vẫn gọi đc biến toàn cục
		
	}
	
	public static void main (String[] args) {
		Computer comp = new Computer();
		int value = comp.ssdSize = 500;
		System.out.println(value);
		comp.setssdSize(600);
		System.out.println(comp.ssdSize);
		
	}
	
}
