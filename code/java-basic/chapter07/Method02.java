
public class Method02 { 

	//编写一个main方法
	public static void main(String[] args) {

		//请遍历一个数组 , 输出数组的各个元素值
		int [][] map =  {{0,0,1},{1,1,1},{1,1,3}};

		//使用方法完成输出, 创建MyTools对象 
		MyTools tool = new MyTools();

		//遍历map数组
		//传统的解决方式就是直接遍历
		// for(int i = 0; i < map.length; i++) {
		// 	for(int j = 0; j < map[i].length; j++) {
		// 		System.out.print(map[i][j] + "\t");
		// 	}
		// 	System.out.println();
		// }
		//使用方法
		tool.printArr(map);

		//....
		//
		//要求再次遍历map数组
		// for(int i = 0; i < map.length; i++) {
		// 	for(int j = 0; j < map[i].length; j++) {
		// 		System.out.print(map[i][j] + "\t");
		// 	}
		// 	System.out.println();
		// }
		tool.printArr(map);


		//...再次遍历
		//
		// for(int i = 0; i < map.length; i++) {
		// 	for(int j = 0; j < map[i].length; j++) {
		// 		System.out.print(map[i][j] + "\t");
		// 	}
		// 	System.out.println();
		// }
		tool.printArr(map);

	}
}

//把输出的功能，写到一个类的方法中,然后调用该方法即可
class MyTools {
	//方法，接收一个二维数组
	
	public void printArr(int[][] map) {
		System.out.println("=======");
		//对传入的map数组进行遍历输出
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "_");
			}
			System.out.println();
		}
	}
}