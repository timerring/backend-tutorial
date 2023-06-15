
public class Homework04 { 

	//编写一个main方法
	public static void main(String[] args) {

		/*
		已知有个升序的数组，要求插入一个元素，该数组顺序依然是升序, 比如:  
		[10， 12， 45， 90],  添加23 后, 数组为 [10， 12，23， 45， 90]


		思路 本质数组扩容 + 定位
		1. 我们先确定 添加数应该插入到哪个索引
		2. 然后扩容
		 */
		
		//先定义原数组
		int[] arr = {10, 12, 45, 90};
		int insertNum = 111;
		int index = -1; //index就是要插入的位置

		//遍历 arr数组， 如果发现 insertNum<=arr[i], 说明 i 就是要插入的位置
		//使用 index 保留 index = i;
		//如果遍历完后，没有发现 insertNum<=arr[i]， 说明 index = arr.length
		//即：添加到arr的最后
		
		for(int i = 0; i < arr.length; i++) {
			if(insertNum <= arr[i]) {
				index = i;
				break; //找到位置后，就退出
			}
		}

		//判断index 的值
		if(index == -1) { //说明没有还没有找到位置
			index = arr.length;
		}

		//扩容
		//先创建一个新的数组，大小 arr.length + 1
		int[] arrNew = new int[arr.length + 1];
		//下面老师准备将arr的元素拷贝到 arrNew ,并且要跳过 index位置
		/*
		分析:
		int[] arr = {10, 12, 45, 90};
		arrNew = {              }
		*/
		//i 控制arrNew的下标  , j用来控制arr数组的下标
		for(int i = 0, j = 0; i < arrNew.length; i++) {

			if( i != index ) { //说明可以把 arr的元素拷贝到 arrNew
				arrNew[i] = arr[j];
				j++;
			} else { //i这个位置就是要插入的数
				arrNew[i] = insertNum;
			}
		}

		//让arr 指向 arrNew , 原来的数组，就成为垃圾，被销毁
		arr = arrNew;

		System.out.println("======插入后，arr数组的元素情况======");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}