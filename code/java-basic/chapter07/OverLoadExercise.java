
public class OverLoadExercise { 

	//编写一个main方法
	public static void main(String[] args) {

		//在主类的main ()方法中分别用参数区别调用三个方法
		Methods method = new Methods();
		method.m(10);//100
		method.m(10, 20);//200
		method.m("韩顺平教育 hello");//字符串信息

		//测试
		System.out.println(method.max(10, 24)); // 24
		System.out.println(method.max(10.0, 21.4)); // 21.4
		System.out.println(method.max(10.0, 1.4, 30.0)); // 30.0
	}
}

/*
编写程序，类Methods中定义三个重载方法并调用。方法名为m。
三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，
相乘并输出结果，输出字符串信息。在主类的main ()方法中分别用参数区别调用三个方法


定义三个重载方法max()，第一个方法，返回两个int值中的最大值，
第二个方法，返回两个double值中的最大值，第三个方法，
返回三个double值中的最大值，并分别调用三个方法
 */
class Methods {

	//分析
	//1 方法名 max
	//2 形参 (int,int) 
	//3.int
	public int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}

	//分析
	//1 方法名 max
	//2 形参 (double,double) 
	//3.double
	public double max(double n1, double n2) {
		return n1 > n2 ? n1 : n2;
	}

	//分析
	//1 方法名 max
	//2 形参 (double,double,double) 
	//3.double
	public double max(double n1, double n2, double n3) {
		
		System.out.println("max(double n1, double n2, double n3)");
		//求出n1 和  n2的最大值
		double max1 = n1 > n2 ? n1 : n2;
		return max1 > n3 ? max1 : n3;
	}

	public double max(double n1, double n2, int n3) {
		
		System.out.println("max(double n1, double n2, int n3)");
		//求出n1 和  n2的最大值
		double max1 = n1 > n2 ? n1 : n2;
		return max1 > n3 ? max1 : n3;
	}
	

	//分析
	//1 方法名 m
	//2 形参 (int) 
	//3.void
	public void m(int n) {
		System.out.println("平方=" + (n * n));
	} 

	//1 方法名 m
	//2 形参 (int, int) 
	//3.void
	public void m(int n1, int n2) {
		System.out.println("相乘=" + (n1 * n2));
	}

	//1 方法名 m
	//2 形参 (String) 
	//3.void
	public void m(String str) {
		System.out.println("传入的str=" + str);
	}
}