//演示关系运算符的使用
//

public class RelationalOperator { 

	//编写一个main方法
	public static void main(String[] args) {

		int a = 9;  //老韩提示:  开发中，不可以使用  a, b 
		int b = 8;
		System.out.println(a > b); //T 
		System.out.println(a >= b);  //T
		System.out.println(a <= b); //F
		System.out.println(a < b);//F
		System.out.println(a == b); //F
		System.out.println(a != b); //T
		boolean flag = a > b; //T
		System.out.println("flag=" + flag);
	}
}