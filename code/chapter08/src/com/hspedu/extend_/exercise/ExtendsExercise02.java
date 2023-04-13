package com.hspedu.extend_.exercise;

public class ExtendsExercise02 {
    public static void main(String[] args) {
        C c = new C();
    }
}

class A {//A类

    public A() {
        System.out.println("我是A类");
    }
}

class B extends A { //B类,继承A类		//main方法中： C c =new C(); 输出么内容? 3min
    public B() {
        System.out.println("我是B类的无参构造");
    }

    public B(String name) {
        System.out.println(name + "我是B类的有参构造");
    }
}

class C extends B {   //C类，继承 B类
    public C() {
        this("hello");
        System.out.println("我是c类的无参构造");
    }

    public C(String name) {
        super("hahah");
        System.out.println("我是c类的有参构造");
    }
}

