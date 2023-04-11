//单分支和双分支的练习
//
public class IfExercise01 { 

	//编写一个main方法
	public static void main(String[] args) {

		//编写程序，声明2个double型变量并赋值。
		//判断第一个数大于10.0，且第2个数小于20.0，打印两数之和
		
		//思路分析
		
		double d1 = 33.5;
		double d2 = 2.6;
		if(d1 > 10.0 && d2 < 20.0) {
			System.out.println("两个数和=" + (d1 + d2));
		}

		//【课后自己练】定义两个变量int，判断二者的和，
		//是否能被3又能被5整除，打印提示信息
		//
		//思路分析
		//1. 定义两个变量int num1, num2
		//2. 定义一个变量 int sum = num1 + num2;
		//3. sum % 3 , 5 后 等于0 说明可以整除
		//4. 使用 if - else 来提示对应信息
		//走代码
		int num1 = 10;
		int num2 = 1;
		int sum = num1 + num2;
		if(sum % 3 == 0 && sum % 5 == 0) {
			System.out.println("和可以被3又能被5整除");
		} else {
			System.out.println("和不能被3和5整除..");
		}

		//判断一个年份是否是闰年，闰年的条件是符合下面二者之一：
		//(1)年份能被4整除，但不能被100整除；(2)能被400整除
		//
		//思路分析
		//1. 定义 int year 保存年
		//2. 年份能被4整除，但不能被100整除, 
		//   => year % 4 == 0 && year % 100 != 0 
		//3. 能被400整除 => year % 400 == 0
		//4. 上面的 2 和  3 是 或的关系 
		//代码实现
		int year = 2028;
		if( (year % 4 == 0 && year % 100 != 0) ||  year % 400 == 0 ) {
			System.out.println(year + " 是 闰年");
		} else {
			System.out.println(year + " 不是 闰年");
		}
	}
}