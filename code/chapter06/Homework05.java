
public class Homework05 { 

	//编写一个main方法
	public static void main(String[] args) {
		
		/*
		随机生成10个整数(1_100的范围)保存到数组，
		并倒序打印以及求平均值、求最大值和最大值的下标、
		并查找里面是否有 8  Homework05.java
		 */
		
		int[] arr = new int[10]; 
		//(int)(Math.random() * 100) + 1 生产 随机数 1-100
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}

		System.out.println("====arr的元素情况=====");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

		System.out.println("\n====arr的元素情况(倒序)=====");
		for(int i = arr.length -1; i >= 0; i--) {
			System.out.print(arr[i] + "\t");
		}

		//平均值、求最大值和最大值的下标
		//我们这里将需要一起完成
		//
		double sum = arr[0];
		int max = arr[0];
		int maxIndex = 0;
		for(int i = 1; i < arr.length; i++ ) {

			sum += arr[i]; //累积和

			if( max < arr[i]) {//说明max不是最大值，就变化
				max = arr[i];
				maxIndex = i;
			}
		}

		System.out.println("\nmax=" + max + " maxIndex=" + maxIndex);
		System.out.println("\n平均值=" + (sum / arr.length));


		//查找数组中是否有8->使用顺序查找
		int findNum = 8;
		int index = -1; //如果找到，就把下标记录到 index
		for(int i = 0; i < arr.length; i++) {
			if(findNum == arr[i]) {
				System.out.println("找到数" + findNum + " 下标=" + i);
				index = i;
				break;
			}
		}

		if(index == -1) {
			System.out.println("没有找到数" + findNum );
		}


		

	}
}