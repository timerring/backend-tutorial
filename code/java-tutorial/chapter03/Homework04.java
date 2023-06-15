
public class Homework04 { 

	//编写一个main方法
	public static void main(String[] args) {
		/*
		 姓名	年龄	成绩	性别	爱好
     	xx		xx	xx	xx	xx

		要求：
		1) 用变量将姓名、年龄、成绩、性别、爱好存储
		2) 使用+
		3) 添加适当的注释
		4) 添加转义字符, 使用一条语句输出

		 */
		//姓名
		String name = "jack";
		int age = 20;
		double score = 80.9;
		char gender = '男';
		String hobby = "打篮球";
		//输出了信息, 可以使用换行
		System.out.println("姓名\t年龄\t成绩\t性别\t爱好\n" + name + "\t" 
			+ age + "\t" + score + "\t" + gender + "\t" + hobby);
	}
}