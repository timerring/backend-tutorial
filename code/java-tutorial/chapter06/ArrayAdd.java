
public class ArrayAdd { 

	//编写一个main方法
	public static void main(String[] args) {
		/*
		要求：实现动态的给数组添加元素效果，实现对数组扩容。ArrayAdd.java
		1.原始数组使用静态分配 int[] arr = {1,2,3}
		2.增加的元素4，直接放在数组的最后 arr = {1,2,3,4}
		3.用户可以通过如下方法来决定是否继续添加，添加成功，是否继续？y/n
		
		思路分析
		1. 定义初始数组 int[] arr = {1,2,3}//下标0-2
		2. 定义一个新的数组 int[] arrNew = new int[arr.length+1];
		3. 遍历 arr 数组，依次将arr的元素拷贝到 arrNew数组
		4. 将 4 赋给 arrNew[arrNew.length - 1] = 4;把4赋给arrNew最后一个元素
		5. 让 arr 指向 arrNew ;  arr = arrNew; 那么 原来arr数组就被销毁
		 */
		int[] arr = {1,2,3};
		int[] arrNew = new int[arr.length + 1];
		//遍历 arr 数组，依次将arr的元素拷贝到 arrNew数组
		for(int i = 0; i < arr.length; i++) {
			arrNew[i] = arr[i];
		}
		//把4赋给arrNew最后一个元素
		arrNew[arrNew.length - 1] = 4;
		//让 arr 指向 arrNew, 
		arr = arrNew;
		//输出arr 看看效果
		System.out.println("====arr扩容后元素情况====");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}



	}
}



