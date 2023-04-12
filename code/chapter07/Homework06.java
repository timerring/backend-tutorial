
public class Homework06 { 

	//编写一个main方法
	public static void main(String[] args) {
		Cale cale = new Cale(2, 10);
		System.out.println("和=" + cale.sum());
		System.out.println("差=" + cale.minus());
		System.out.println("乘=" + cale.mul());
		Double divRes = cale.div();
		if(divRes != null) {
			System.out.println("除=" + divRes);
		} 
	}
}

/*
 编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，
 定义四个方法实现求和、差、乘、商(要求除数为0的话，要提示) 并创建两个对象，分别测试 
 */

class Cale {
	double num1;
	double num2;
	public Cale(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	//和
	public double sum() {
		return num1 + num2;
	}
	//差
	public double minus() {
		return num1 - num2;
	}
	//乘积
	public double mul() {
		return num1 * num2;
	}
	//除法
	//
	public Double div() {
		//判断
		if(num2 == 0) {
			System.out.println("num2 不能为0");
			return null;
		} else {
			return num1 / num2;
		}
	}
}