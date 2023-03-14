package JavaAccModSecond;

public class Laptop {
	//Computer laptop = new Computer();
	public static void main (String[] args) {
		Computer comp = new Computer();
		int value = comp.ssdSize = 500;
		System.out.println(value);
		comp.setssdSize(600);
		System.out.println(comp.ssdSize);
		
	}
}
