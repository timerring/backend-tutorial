
//演示char的基本使用

public class Char01 { 

	//编写一个main方法
	public static void main(String[] args) {
		char c1 = 'a';
		char c2 = '\t';
		char c3 = '韩';

		char c4 = 97; //说明: 字符类型可以直接存放一个数字
		//修改快捷键 
		//删除当前行的快捷键使用 ctrl+shif+k => ctrl+ k
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);//当输出c4时候，会输出97表示的字符 => 编码的概念

	}
}