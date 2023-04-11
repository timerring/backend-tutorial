import java.util.Scanner;//表示把java.util下的Scanner类导入 
public class Input { 

	//编写一个main方法
	public static void main(String[] args) {
		//演示接受用户的输入
		//步骤
		//Scanner类 表示 简单文本扫描器，在java.util 包
		//1. 引入/导入 Scanner类所在的包
		//2. 创建 Scanner 对象 , new 创建一个对象,体会
		//   myScanner 就是 Scanner类的对象
		Scanner myScanner = new Scanner(System.in);
		//3. 接收用户输入了， 使用 相关的方法
		System.out.println("请输入名字");

		//当程序执行到 next 方法时，会等待用户输入~~~
		String name = myScanner.next(); //接收用户输入字符串
		System.out.println("请输入年龄");
		int age = myScanner.nextInt(); //接收用户输入int
		System.out.println("请输入薪水");
		double sal = myScanner.nextDouble(); //接收用户输入double
		System.out.println("人的信息如下:");
		System.out.println("名字=" + name 
			+ " 年龄=" + age + " 薪水=" + sal);

	}
}