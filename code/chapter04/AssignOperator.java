//演示赋值运算符的使用

public class AssignOperator { 

	//编写一个main方法
	public static void main(String[] args) {

		int n1 = 10;
		n1 += 4;// n1 = n1 + 4;
		System.out.println(n1); // 14
		n1 /= 3;// n1 = n1 / 3;//4
		System.out.println(n1); // 4

		//复合赋值运算符会进行类型转换
		byte b = 3;
		b += 2; // 等价 b = (byte)(b + 2);
		b++; // b = (byte)(b+1);

		
	}
}