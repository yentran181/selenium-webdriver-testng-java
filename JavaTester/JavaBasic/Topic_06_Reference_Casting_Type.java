package JavaBasic;

public class Topic_06_Reference_Casting_Type {
	public String studentName;
	
	public void setStudentName (String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void showStudentName() {
		System.out.println("Student Name: " + studentName);
	}
	
	public static void main(String[] args) {
		Topic_06_Reference_Casting_Type student1 = new Topic_06_Reference_Casting_Type();
		Topic_06_Reference_Casting_Type student2 = new Topic_06_Reference_Casting_Type();
		
		student1.setStudentName("Nguyen Van A");
		student2.setStudentName("Nguyen Van B");
		
		student1.showStudentName();
		student2.showStudentName();
		
		//Reference Casting
		student1 = student2;
		
		student1.showStudentName();
		student2.showStudentName();

		student2.setStudentName("Tran Thi Yen");
		
		student1.showStudentName();
		student2.showStudentName();
	}

}
