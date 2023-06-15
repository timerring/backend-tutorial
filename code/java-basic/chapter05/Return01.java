
public class Return01 { 

	//编写一个main方法
	public static void main(String[] args) {

		for(int i=1;i<=5;i++){

			if(i==3) {
		        System.out.println("韩顺平教育 "+i);
				return; //当return用在方法时，表示跳出方法，如果使用在main,表示退出程序
				
			}
			System.out.println("Hello World!");
		}
		System.out.println("go on..");

	}
}