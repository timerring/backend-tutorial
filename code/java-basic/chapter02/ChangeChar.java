//演示转义字符的使用
public class ChangeChar {

	//编写一个main方法
	public static void main(String[] args) {
		
		//\t  ：一个制表位，实现对齐的功能
		System.out.println("北京\t天津\t上海");
		// \n  ：换行符
		System.out.println("jack\nsmith\nmary");
		// \\  ：一个\  \\
		System.out.println("C:\\Windows\\System32\\cmd.exe");
		// \"  :一个"
		System.out.println("timerring说:\"要好好学习java,有前途\"");
		// \'  ：一个'
		System.out.println("timerring说:\'要好好学习java,有前途\'");
		
		// \r  :一个回车  System.out.println("timerring\r北京");
		// 解读
		// 1. 输出  timerring
		// 2. \r表示回车 
		System.out.println("timerring\r北京");
	}

}
