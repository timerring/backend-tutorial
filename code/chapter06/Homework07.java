
public class Homework07 { 

	//编写一个main方法
	public static void main(String[] args) {

		//冒泡排序
		//要求从小到大
		int[] arr = {20, -1, 89, 2, 890, 7};

		int temp = 0; //辅助交换
		for(int i = 0; i < arr.length -1 ; i++) {//外层循环(轮)
			for(int j = 0; j < arr.length - 1 - i; j++) {//每轮的比较次数
				//如果是从小到大，条件是 arr[j] > arr[j+1]
				//如果是从大到小，条件是 arr[j] < arr[j+1]
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		//搞定
		System.out.println("\n==== 排序后====");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}