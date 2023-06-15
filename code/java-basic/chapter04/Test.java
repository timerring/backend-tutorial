//验证

public class Test { 

	//编写一个main方法
	public static void main(String[] args) {

		// int x = 5;
		// int y=5;
		// if(x++==6 & ++y==6){ //逻辑与
		// 	x = 11;
		// }
		// System.out.println("x="+x+",y="+y);
		// //6, 6
		// int x = 5,y = 5;

		// if(x++==6 && ++y==6){
		// 	x = 11;
		// }
		// System.out.println("x="+x+",y="+y);
		// //6, 5
		// 
		// int x = 5,y = 5;
		// if(x++==5 | ++y==5){
		// 	x =11;
		// }
		// System.out.println("x="+x+",y="+y);
		//11, 6
		//
		// int x = 5,y = 5;
		// if(x++==5 || ++y==5){
		// 	x =11;
		// }
		// System.out.println("x="+x+",y="+y);
		//11, 5
		//
		//
		boolean x=true;
		boolean y=false;
		short z=46;
		if( (z++==46)&& (y=true) )   z++;  
		if((x=false) || (++z==49))  z++; 
		System. out.println("z="+z); //50 

	}
}