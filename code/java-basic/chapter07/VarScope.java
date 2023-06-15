
public class VarScope { 

	//编写一个main方法
	public static void main(String[] args) {
	}
}
class Cat {
	//全局变量：也就是属性，作用域为整个类体 Cat类：cry eat 等方法使用属性
	//属性在定义时，可以直接赋值
	int age = 10; //指定的值是 10

	//全局变量(属性)可以不赋值，直接使用，因为有默认值，
	double weight;  //默认值是0.0

	public void hi() {
		//局部变量必须赋值后，才能使用，因为没有默认值
		int num = 1;
		String address = "北京的猫";
		System.out.println("num=" + num);
		System.out.println("address=" + address);
		System.out.println("weight=" + weight);//属性
	}
	
	public void cry() {
		//1. 局部变量一般是指在成员方法中定义的变量
		//2. n 和  name 就是局部变量
		//3. n 和 name的作用域在 cry方法中
		int n = 10;
		String name = "jack";
		System.out.println("在cry中使用属性 age=" + age);
	}

	public void eat() {

		System.out.println("在eat中使用属性 age=" + age);
		

		//System.out.println("在eat中使用 cry的变量 name=" + name);//错误
	}
}