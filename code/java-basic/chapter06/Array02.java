import java.util.Scanner;
public class Array02 { 

	//编写一个main方法
	public static void main(String[] args) {
		//演示 数据类型 数组名[]=new 数据类型[大小]
		//循环输入5个成绩，保存到double数组,并输出
		
		//步骤
		//1. 创建一个 double 数组，大小 5
		
		//(1) 第一种动态分配方式
		//double scores[] = new double[5];
		//(2) 第2种动态分配方式， 先声明数组，再 new 分配空间
		double scores[] ; //声明数组， 这时 scores 是 null
		scores = new double[5]; // 分配内存空间，可以存放数据
		

		//2. 循环输入
		//   scores.length 表示数组的大小/长度
		//   
		Scanner myScanner = new Scanner(System.in);
		for( int i = 0; i < scores.length; i++) {
			System.out.println("请输入第"+ (i+1) +"个元素的值");
			scores[i] = myScanner.nextDouble();
		}

		//输出，遍历数组
		System.out.println("==数组的元素/值的情况如下:===");
		for( int i = 0; i < scores.length; i++) {
			System.out.println("第"+ (i+1) +"个元素的值=" + scores[i]);
		}
	}
}