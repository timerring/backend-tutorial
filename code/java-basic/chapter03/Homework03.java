
public class Homework03 { 

	//编写一个main方法
	public static void main(String[] args) {
		//编程，保存两本书名，用+拼接，看效果。保存两个性别，
		//用加号拼接，看效果。保存两本书价格，用加号拼接，看效果
		
		String book1 = "天龙八部";
		String book2 = "笑傲江湖";
		System.out.println(book1 + book2);//天龙八部笑傲江湖

		//性别应该使用char保存
		char c1 = '男';
		char c2 = '女';
		System.out.println(c1 + c2);//得到  男 字符码值 + 女 字符码值

		//保存两本书价格
		double price1 = 123.56;
		double price2 = 100.11;
		System.out.println(price1 + price2);//就是 123.56+100.11
	}
}