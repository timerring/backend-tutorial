//三元运算符细节

public class TernaryOperatorDetail { 

	//编写一个main方法
	public static void main(String[] args) {
		//表达式1和表达式2要为可以赋给接收变量的类型
		//(或可以自动转换/或者强制转换)
		int a = 3;
		int b = 8;
		int c = a > b ? (int)1.1 : (int)3.4;//可以的
		double d = a > b ? a : b + 3;//可以的，满足 int -> double
	}
}