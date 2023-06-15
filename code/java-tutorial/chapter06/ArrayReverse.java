
public class ArrayReverse { 

	//编写一个main方法
	public static void main(String[] args) {

		//定义数组
		int[] arr = {11, 22, 33, 44, 55, 66};
		//老韩思路
		//规律
		//1. 把 arr[0] 和 arr[5] 进行交换 {66,22,33,44,55,11}
		//2. 把 arr[1] 和 arr[4] 进行交换 {66,55,33,44,22,11}
		//3. 把 arr[2] 和 arr[3] 进行交换 {66,55,44,33,22,11}
		//4. 一共要交换 3 次 = arr.length / 2
		//5. 每次交换时，对应的下标 是 arr[i] 和 arr[arr.length - 1 -i]
		//代码
		//优化
		int temp = 0;
		int len = arr.length; //计算数组的长度
		for( int i = 0; i < len / 2; i++) {
			temp = arr[len - 1 - i];//保存
			arr[len - 1 - i] = arr[i];
			arr[i] = temp; 
		}

		System.out.println("===翻转后数组===");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");//66,55,44,33,22,11
		}
	}
}