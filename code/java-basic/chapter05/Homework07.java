

public class Homework07 { 

	//编写一个main方法
	public static void main(String[] args) {

		//输出小写的a-z以及大写的Z-A
		//考察我们对 a-z编码和 for的综合使用
		//思路分析
		//1. 'b' = 'a' + 1 c = 'a' + 2
		//2. 使用for搞定
		
		for(char c1 = 'a'; c1 <= 'z'; c1++) {
			System.out.print(c1 +" ");
		} 
		System.out.println("============");
		//灵活的使用，编程..
		for(char c1 = 'Z'; c1 >= 'A'; c1--) {
			System.out.print(c1 +" ");
		}
		
	}
}