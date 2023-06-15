
public class OverLoad01 { 

	//编写一个main方法
	public static void main(String[] args) {

		// System.out.println(100);
		// System.out.println("hello,world");
		// System.out.println('h');
		// System.out.println(1.1);
		// System.out.println(true);
		// 
		MyCalculator mc = new MyCalculator();
		System.out.println(mc.calculate(1, 2));
		System.out.println(mc.calculate(1.1, 2));
		System.out.println(mc.calculate(1, 2.1));
	}
}

class MyCalculator  {

	//下面的四个 calculate方法构成了重载
	//两个整数的和
	public int calculate(int n1, int n2)  {
		System.out.println("calculate(int n1, int n2) 被调用");
		return n1 + n2;
	}

	//没有构成方法重载, 仍然是错误的，因为是方法的重复定义
	// public void calculate(int n1, int n2)  {
	// 	System.out.println("calculate(int n1, int n2) 被调用");
	// 	int res =  n1 + n2;
	// } 

	//看看下面是否构成重载, 没有构成，而是方法的重复定义,就错了
	// public int calculate(int a1, int a2)  {
	// 	System.out.println("calculate(int n1, int n2) 被调用");
	// 	return a1 + a2;
	// } 

	//一个整数，一个double的和
	public double calculate(int n1, double n2) {
		return n1 + n2;
	}
	//一个double ,一个Int和 
	public double calculate(double n1, int n2) {
		System.out.println("calculate(double n1, int n2) 被调用..");
		return n1 + n2;
	}
	//三个int的和
	public int calculate(int n1, int n2,int n3) {
		return n1 + n2 + n2;
	}

}