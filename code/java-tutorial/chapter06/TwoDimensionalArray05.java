
public class TwoDimensionalArray05 { 

	//编写一个main方法
	public static void main(String[] args) {

		/*
		int arr[][]={{4,6},{1,4,5,7},{-2}}; 遍历该二维数组，并得到和 
		
		思路
		1. 遍历二维数组，并将各个值累计到 int sum
		 */
		int arr[][]= {{4,6},{1,4,5,7},{-2}};
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			//遍历每个一维数组
			for(int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println("sum=" + sum);
	}
}