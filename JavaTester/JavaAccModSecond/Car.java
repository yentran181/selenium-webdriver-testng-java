package JavaAccModSecond;

import JavaAccModFirst.Animal;
import JavaAccModFirst.Dog;

	Access Final chỉ cho phép khởi tạo đối tượng mới, không cho kế thừa (extends)
public final class Car {
	//Khác package cần phải import thư viện Dog/Animal
	Dog dog = new Dog(); 
	Animal cat = new Animal();
	
}
