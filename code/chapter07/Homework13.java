
public class Homework13 { 

	//编写一个main方法
	public static void main(String[] args) {

		Circle c = new Circle();
		PassObject po = new PassObject();
		po.printAreas(c, 5);
	}
}

/*
题目要求：
(1) 定义一个Circle类，包含一个double型的radius属性代表圆的半径，findArea()方法返回圆的面积。
(2) 定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下：
     public void printAreas(Circle c, int times) 	//方法签名/声明
(3) 在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积。
(4) 在main方法中调用printAreas()方法，调用完毕后输出当前半径值。程序运行结果如图所示

 */
class Circle { //类
	double radius;//半径
	public Circle() { //无参构造器

	}
	public Circle(double radius) {
		this.radius = radius;
	}
	public double findArea() {//返回面积
		return Math.PI * radius * radius;
	}
	//添加方法setRadius, 修改对象的半径值
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
class PassObject {
	public void printAreas(Circle c, int times) {
		System.out.println("radius\tarea");
		for(int i = 1; i <= times; i++) {//输出1到times之间的每个整数半径值
			c.setRadius(i) ; //修改c 对象的半径值
			System.out.println((double)i + "\t" + c.findArea());
		}
	}
}
