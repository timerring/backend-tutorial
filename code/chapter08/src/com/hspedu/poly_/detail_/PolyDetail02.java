package com.hspedu.poly_.detail_;

public class PolyDetail02 {
    public static void main(String[] args) {
        //属性没有重写之说！属性的值看编译类型
        Base base = new Sub();//向上转型
        System.out.println(base.count);// ？ 看编译类型 10
        Sub sub = new Sub();
        System.out.println(sub.count);//?  20
    }
}

class Base { //父类
    int count = 10;//属性
}
class Sub extends Base {//子类
    int count = 20;//属性
}
