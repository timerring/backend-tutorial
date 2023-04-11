import java.util.Scanner;
public class BreakExercise02 { 

	//编写一个main方法
	public static void main(String[] args) {

		//实现登录验证，有3次机会，如果用户名为"丁真" ,密码"666"提示登录成功，
		//否则提示还有几次机会，请使用for+break完成
		//
		// 思路分析
		// 1. 创建Scanner对象接收用户输入  
		// 2. 定义 String name ; String passwd; 保存用户名和密码
		// 3. 最多循环3次[登录3次]，如果 满足条件就提前退出
		// 4. 定义一般变量 int chance 记录还有几次登录机会
		// 
		// 代码实现
		
		Scanner myScanner  = new Scanner(System.in);
		String name = "";
		String passwd = "";
		int chance = 3; //登录一次 ，就减少一次
		for( int i = 1; i <= 3; i++) {//3次登录机会
			System.out.println("请输入名字");
			name = myScanner.next();
			System.out.println("请输入密码");
			passwd = myScanner.next();
			//比较输入的名字和密码是否正确
			//补充说明字符串 的内容 比较 使用的 方法 equals
			if("丁真".equals(name) && "666".equals(passwd)) {
				System.out.println("恭喜你，登录成功~");
				break;
			}

			//登录的机会就减少一次
			chance--;
			System.out.println("你还有" + chance + "次登录机会");

		}


	}
}