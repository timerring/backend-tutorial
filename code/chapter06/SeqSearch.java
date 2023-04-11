import java.util.Scanner;
public class SeqSearch { 

	//编写一个main方法
	public static void main(String[] args) {
		/*
		有一个数列：白眉鹰王、金毛狮王、紫衫龙王、青翼蝠王猜数游戏：
		从键盘中任意输入一个名称，判断数列中是否包含此名称【顺序查找】 
		要求: 如果找到了，就提示找到，并给出下标值

		思路分析
		1. 定义一个字符串数组
		2. 接收用户输入, 遍历数组，逐一比较，如果有，则提示信息，并退出
		 */
		
		//定义一个字符串数组
		String[] names = {"白眉鹰王", "金毛狮王", "紫衫龙王", "青翼蝠王"};
		Scanner myScanner = new Scanner(System.in); 

		System.out.println("请输入名字");
		String findName = myScanner.next();

		//遍历数组，逐一比较，如果有，则提示信息，并退出
		//这里老师给大家一个编程思想/技巧, 一个经典的方法
		int index = -1;
		for(int i = 0; i < names.length; i++) {
			//比较 字符串比较 equals, 如果要找到名字就是当前元素
			if(findName.equals(names[i])) {
				System.out.println("恭喜你找到 " + findName);
				System.out.println("下标为= " + i);
				//把i 保存到 index
				index = i;
				break;//退出 
			} 
		}

		if(index == -1) { //没有找到
			System.out.println("sorry ,没有找到 " + findName);
		}

	}
}