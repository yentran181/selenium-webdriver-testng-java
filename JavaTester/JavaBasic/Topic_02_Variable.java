package JavaBasic;

public class Topic_02_Variable {

}
1. Lưu ý khi đặt tên biến không trùng các từ khóa trong Java:
	
	- Kiểu dữ liệu nguyên thủy: boolean, byte, char, double, float, short, int, long
	- Kiểu dữ liệu của hàm: void (hàm k cần trả về)
	- Vòng lặp: while, for, do
	- Thoát vòng lặp: break
	- Biểu thức điều kiện: switch-case default, if, else
	- Bỏ qua case nào đó (thường dùng cho switch case)
	- Xử lý ngoại lệ: try - catch - throw, finally
	- Khai báo: class, abstract (class, method) (với abstract class thì chỉ cho phép kế thừa, không thể khởi tạo new)
	- Kế thừa giữa 2 class: extends
	- Class kế thừa 1 interface: implements (không có chiều ngược lại)
	- Kế thừa giữa 2 interface: extends
	- Biến/hàm/class/method không cho phép overwrite giá trị: final
	- Import thư viện: import
	- public, private, protected, default
	- new: khởi tạo mới 1 biến/class
	- instanceof: kiểm tra biến có thuộc kiểu nào đó hay k
	- interface
	- native, transient, volatile
	- package
	- return : trả về dữ liệu (với hàm kiểu void sẽ k thể dùng return được)
	- static: hàm/biến tĩnh
	- super: gọi đến constractor của class cha
	- synchronized: lquan quản lý luồng dữ liệu
	- this: truy cập đến biến toàn cục (biến trong class cha)
	
2. Các loại biến:
	
	- Biến cục bộ (local) - màu xám
		- Được khai báo trong testcase, hàm
		- Chỉ sử dụng trong phạm vi của testcase, hàm
		- Biến local không có giá trị mặc định, nên khi sử dụng cần phải gán 1 giá trị cho biến
	- Biến toàn cục (global, instance) - màu xanh
		- Không được khai báo trong hàm, khối lệnh hay từ khóa static hoặc hàm khởi tạo (là hàm k có kiểu trả về (public) có cùng tên vs tên class)
		- Dùng được cho tất cả các hàm, khối lệnh trong class
		- Được sử dụng "access modifier"- (private, public, protected) khi khai báo biến, mặc định là default
		- Chu kỳ: được sinh ra khi đối tượng được khởi tạo, và mất đi khi đối tượng bị hủy
		- Được truy cập thông qua đối tượng (tendoituong.tenbien)
	- Biến tĩnh (stactic) - màu xanh in nghiêng
		- Là biến class đi kèm từ khóa static 
		- Được truy cập thông qua class (tenclass.tenbien) (có thể truy cập qua đối tượng nhưng sẽ bị warning)
		- Chu kỳ: Được sinh ra khi chạy 1 chương trình, mất đi khi chương trình không còn tồn tại => dài hơn biến global
		
	- Biến hằng số - constant (final) - màu xanh in đậm
		- Không thể gán lại giá trị biến final
		
3. Comment
 
	- 
		