//while循环的案例
//
public class While01 { 

	//编写一个main方法
	public static void main(String[] args) {

		//输出10句 你好,韩顺平教育
		
		int i = 1; //循环变量初始化
		while( i <= 10 ) {//循环条件
			System.out.println("你好，韩顺平教育" + i);//执行语句
			i++;//循环变量迭代
		}

		System.out.println("退出while ，继续.." + i); // 11
	}
}