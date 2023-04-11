

public class BreakDetail { 

	//编写一个main方法
	public static void main(String[] args) {

		abc1:
		for(int j = 0; j < 4; j++){//外层for
		abc2:
			for(int i = 0; i < 10; i++){//内层for
				if(i == 2){
					//break  ;//等价 break abc2
					break abc1 ;
				}
				System.out.println("i = " + i);
			}
		}

	}
}