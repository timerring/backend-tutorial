
public class Test { 

	//编写一个main方法
	public static void main(String[] args) {

		// String name = "林黛玉";
		// System.out.println(name.equals("林黛玉"));//T
		// System.out.println("林黛玉".equals(name));//T [推荐, 可以避免空指针]


		char[] arr1={'a','z','b','c'};
		char[] arr2=arr1;
		arr1[2]='韩';

		for(int i=0;i<arr2.length; i++){
			System.out.println(arr1[i]+","+ arr2[i]); 
		}


	}
}