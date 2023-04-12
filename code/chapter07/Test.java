
public class Test {   //公有类
    int count = 9; //属性
    public void count1() { //Test类的成员方法
 			count=10;//这个count就是属性  改成 10
        	System.out.println("count1=" + count); //10  
    }
    public void count2() {  //Test类的成员方法
        System.out.println("count1=" + count++);
    } 
   
   	//这是Test类的main方法, 任何一个类，都可有main
    public static void main(String args[]) {
       //老韩解读
       //1.  new Test()	是匿名对象， 匿名对象使用后，就不能使用
       //2.  new Test().count1() 创建好匿名对象后, 就调用count1()
       new Test().count1(); 
      
       Test t1= new Test();
       t1.count2();
       t1.count2();
    }
}
