package com.hspedu.static_;

public class StaticMethodDetail {
    public static void main(String[] args) {

        D.hi();//ok
        //非静态方法，不能通过类名调用
        //D.say();, 错误，需要先创建对象，再调用
        new D().say();//可以
    }
}
class D {

    private int n1 = 100;
    private static  int n2 = 200;
    public void say() {//非静态方法,普通方法

    }

    public static  void hi() {//静态方法,类方法
        // 类方法中不允许使用和对象有关的关键字，
        // 比如this和super。普通方法(成员方法)可以。
        // System.out.println(this.n1);
    }

    // 类方法(静态方法)中 只能访问 静态变量 或静态方法
    // 口诀:静态方法只能访问静态成员.
    public static void hello() {
        System.out.println(n2);
        System.out.println(D.n2);
        //System.out.println(this.n2);不能使用
        hi();//OK
        //say();//错误
    }
    // 普通成员方法，既可以访问  非静态成员，也可以访问静态成员
    // 小结: 非静态方法可以访问 静态成员和非静态成员
    public void ok() {
        //非静态成员
        System.out.println(n1);
        say();
        //静态成员
        System.out.println(n2);
        hello();

    }
}
