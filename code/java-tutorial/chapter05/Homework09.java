
public class Homework09 { 

	//编写一个main方法
	public static void main(String[] args) {
		//求(1)+（1+2）+（1+2+3）+（1+2+3+4）+...+(1+2+3+..+100)的结果
		//
		//思路分析
		//1. 一共有100项相加
		//2. 每一项的数字在逐渐增加
		//3. 很像一个双层循环
		//i 可以表示是第几项,同时也是当前项的最后一个数
		//4. 使用 sum 进行累计即可
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			for(int j = 1;j <= i; j++) {//内层对1-i进行循环
				sum += j;
			}
		}
		System.out.println("sum=" + sum);  
	}
}