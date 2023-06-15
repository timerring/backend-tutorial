
public class Constructor01 { 

	//编写一个main方法
	public static void main(String[] args) {
		//当我们new 一个对象时，直接通过构造器指定名字和年龄
		Person p1 = new Person("smith", 80);
		System.out.println("p1的信息如下");
		System.out.println("p1对象name=" + p1.name);//smith
		System.out.println("p1对象age=" + p1.age);//80
	}
}

//在创建人类的对象时，就直接指定这个对象的年龄和姓名
//
class Person {
	String name;
	int age;
	//构造器
	//老韩解读
	//1. 构造器没有返回值, 也不能写void
	//2. 构造器的名称和类Person一样
	//3. (String pName, int pAge) 是构造器形参列表，规则和成员方法一样
	public  Person(String pName, int pAge) {
		System.out.println("构造器被调用~~ 完成对象的属性初始化");
		name = pName;
		age = pAge;
	}
}