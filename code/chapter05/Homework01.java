
public class Homework01 { 

	//编写一个main方法
	public static void main(String[] args) {
		/*
		某人有100,000元,每经过一次路口，需要交费,规则如下:
		1) 当现金>50000时,每次交5%
		2) 当现金<=50000时,每次交1000
		编程计算该人可以经过多少次路口, 要求: 使用 while + break方式完成

		思路分析
		1. 定义 double money 保存 100000
		2. 根据题的要求，我们分析出来有三种情况 
			money > 50000 
			money >=1000 && money <= 50000
			money < 1000 
		3. 使用多分支 if-elseif-else 
		4. while+break[money < 1000], 同时使用一个变量count来保存通过路口
		代码实现
		 */
		double money = 100000;//还有多少钱
		int count = 0; //累积过的路口
		while(true) { //无限循环
			if(money > 50000) { //过路口
				//money = money -  money * 0.05;
				money *= 0.95; //过了这个路口后，还有这么多钱
				count++;
			} else if(money >=1000) {
				money -= 1000;
				count++;
			} else { //钱不够1000
				break;
			}
		}
		System.out.println("100000 可以过 " + count + " 路口..");
	}
}