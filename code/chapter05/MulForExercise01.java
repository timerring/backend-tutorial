
import java.util.Scanner;
public class MulForExercise01 { 

	//编写一个main方法
	public static void main(String[] args) {
		//统计3个班成绩情况，每个班有5名同学，
		//求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。
		//统计三个班及格人数，每个班有5名同学。
		//
		//思路分析:
		//化繁为简
		//(1) 先计算一个班 , 5个学生的成绩和平均分 , 使用for
		//1.1 创建 Scanner 对象然后，接收用户输入
		//1.2 得到该班级的平均分 , 定义一个 doubel sum 把该班级5个学生的成绩累积 
		
		//(2) 统计3个班(每个班5个学生) 平均分
		//(3) 所有班级的平均分
		//3.1 定义一个变量，double totalScore 累积所有学生的成绩
		//3.2 当多重循环结束后，totalScore / (3 * 5) 
		//(4) 统计三个班及格人数
		//4.1 定义变量 int passNum = 0; 当有一个学生成绩>=60, passNum++
		//4.2 如果 >= 60 passNum++
		//(5) 可以优化[效率，可读性, 结构]
		
		//创建 Scanner 对象
		Scanner myScanner = new Scanner(System.in);
		double totalScore = 0; //累积所有学生的成绩
		int passNum = 0;//累积 及格人数
		int classNum = 3; //班级个数
		int stuNum = 5;//学生个数
		for( int i = 1; i <= classNum; i++) {//i 表示班级

			double sum = 0; //一个班级的总分
			for( int j = 1; j <= stuNum; j++) {//j 表示学生
				System.out.println("请数第"+i+"个班的第"+j+"个学生的成绩");
				double score = myScanner.nextDouble();
				//当有一个学生成绩>=60, passNum++
				if(score >= 60) {
					passNum++;
				}
				sum += score; //累积
				System.out.println("成绩为" + score);
			}
			//因为sum 是 5个学生的总成绩
			System.out.println("sum=" + sum + " 平均分=" + (sum / stuNum));
			//把 sum 累积到 totalScore
			totalScore += sum;

		}
		System.out.println("三个班总分="+ totalScore 
			+ " 平均分=" + totalScore / (classNum*stuNum));
		System.out.println("及格人数=" + passNum);

	}
}