package com.hspedu.extend_;

import java.util.Arrays;

//输入ctrl + H 可以看到类的继承关系
public class Sub extends Base { //子类

    public Sub(String name, int age) {
        //1. 老师要调用父类的无参构造器, 如下或者 什么都不写,默认就是调用super()
        //super();//父类的无参构造器
        //2. 老师要调用父类的 Base(String name) 构造器
        //super("hsp");
        //3. 老师要调用父类的 Base(String name, int age) 构造器
        super("king", 20);

        //细节： super在使用时，必须放在构造器第一行
        //细节: super() 和 this() 都只能放在构造器第一行，因此这两个方法不能共存在一个构造器
        //this() 不能再使用了
        System.out.println("子类Sub(String name, int age)构造器被调用....");


    }

    public Sub() {//无参构造器
        //super(); //默认调用父类的无参构造器
        super("smith", 10);
        System.out.println("子类Sub()构造器被调用....");
    }
    //当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器
    public Sub(String name) {
        super("tom", 30);
        //do nothing...
        System.out.println("子类Sub(String name)构造器被调用....");
    }

    public void sayOk() {//子类方法
        //非私有的属性和方法可以在子类直接访问
        //但是私有属性和方法不能在子类直接访问
        System.out.println(n1 + " " + n2 + " " + n3);
        test100();
        test200();
        test300();
        //test400();错误
        //要通过父类提供公共的方法去访问
        System.out.println("n4=" + getN4());
        callTest400();//
    }

}
