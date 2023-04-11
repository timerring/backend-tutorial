
public class ArrayReverse02 { 

	//编写一个main方法
	public static void main(String[] args) {

		//定义数组
		int[] arr = {11, 22, 33, 44, 55, 66};
		//使用逆序赋值方式 
		//老韩思路
		//1. 先创建一个新的数组 arr2 ,大小 arr.length
		//2. 逆序遍历 arr ,将 每个元素拷贝到 arr2的元素中(顺序拷贝)
		//3. 建议增加一个循环变量 j -> 0 -> 5
		int[] arr2 = new int[arr.length];
		//逆序遍历 arr
		for(int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
			arr2[j] = arr[i];
		}
		//4. 当for循环结束，arr2就是一个逆序的数组 {66, 55, 44,33, 22, 11} 
		//5. 让 arr 指向 arr2数据空间, 此时 arr原来的数据空间就没有变量引用
		//   会被当做垃圾，销毁
		arr = arr2;
		System.out.println("====arr的元素情况=====");
		//6. 输出 arr 看看
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

	}
}