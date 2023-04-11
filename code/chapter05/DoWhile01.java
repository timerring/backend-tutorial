

public class DoWhile01 { 

	//编写一个main方法
	public static void main(String[] args) {


		//输出10句 你好,韩顺平教育
		int i = 1; //循环变量初始化
		do {
			//循环执行语句
			System.out.println("你好，韩顺平教育" + i);
			//循环变量迭代
			i++;

		}while(i <= 10);

		System.out.println("退出 do..while 继续执行.." + i);//11
	}
}