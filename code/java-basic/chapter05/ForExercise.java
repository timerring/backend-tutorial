

public class ForExercise { 

	//编写一个main方法
	public static void main(String[] args) {
		//打印1~100之间所有是9的倍数的整数，统计个数  及 总和.[化繁为简,先死后活]
		//老韩的两个编程思想(技巧)
		//1. 化繁为简 : 即将复杂的需求，拆解成简单的需求，逐步完成
		//2. 先死后活 : 先考虑固定的值，然后转成可以灵活变化的值
		//
		//思路分析
		//打印1~100之间所有是9的倍数的整数，统计个数  及 总和
		//化繁为简
		//(1) 完成 输出 1-100的值
		//(2) 在输出的过程中，进行过滤，只输出9的倍数  i % 9 ==0
		//(3) 统计个数 定义一个变量 int count = 0; 当 条件满足时 count++;
		//(4) 总和 , 定义一个变量 int sum = 0; 当条件满足时累积 sum += i;
		//先死后活
		//(1) 为了适应更好的需求，把范围的开始的值和结束的值，做出变量
		//(2) 还可以更进一步 9 倍数也做成变量 int t = 9;

		int count = 0; //统计9的倍数个数 变量
		int sum = 0; //总和
		int start = 10;
		int end = 200;
		int t = 5; // 倍数
		for(int i = start; i <= end; i++) {
			if( i % t == 0) {
				System.out.println("i=" + i);
				count++;
				sum += i;//累积
			}
		}

		System.out.println("count=" + count);
		System.out.println("sum=" + sum);

	}
}