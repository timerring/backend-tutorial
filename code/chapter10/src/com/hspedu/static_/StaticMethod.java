package com.hspedu.static_;

public class StaticMethod {
    public static void main(String[] args) {
        //创建2个学生对象，叫学费
        Stu tom = new Stu("tom");
        //tom.payFee(100);
        Stu.payFee(100);//对不对?对

        Stu mary = new Stu("mary");
        //mary.payFee(200);
        Stu.payFee(200);//对


        //输出当前收到的总学费
        Stu.showFee();//300

        //如果我们希望不创建实例，也可以调用某个方法(即当做工具来使用)
        //这时，把方法做成静态方法时非常合适
        System.out.println("9开平方的结果是=" + Math.sqrt(9));


        System.out.println(MyTools.calSum(10, 30));
    }
}
//开发自己的工具类时，可以将方法做成静态的，方便调用
class MyTools  {
    //求出两个数的和
    public static double calSum(double n1, double n2) {
        return  n1 + n2;
    }
    //可以写出很多这样的工具方法...a
}
class Stu {
    private String name;//普通成员
    //定义一个静态变量，来累积学生的学费
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }
    //说明
    //1. 当方法使用了static修饰后，该方法就是静态方法
    //2. 静态方法就可以访问静态属性/变量
    public static void payFee(double fee) {
        Stu.fee += fee;//累积到
    }
    public static void showFee() {
        System.out.println("总学费有:" + Stu.fee);
    }
}
