package com.hspedu.abstract_;

public class AbstractDetail02 {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
//抽象方法不能使用private、final 和 static来修饰，因为这些关键字都是和重写相违背的
abstract class H {
    public   abstract void hi();//抽象方法
}

//如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类
abstract class E {
    public abstract void hi();
}
abstract class F extends E {

}
class G extends E {
    @Override
    public void hi() { //这里相等于G子类实现了父类E的抽象方法，所谓实现方法，就是有方法体

    }
}

//抽象类的本质还是类，所以可以有类的各种成员
abstract class D {
    public int n1 = 10;
    public static  String name = "韩顺平教育";
    public void hi() {
        System.out.println("hi");
    }
    public abstract void hello();
    public static void ok() {
        System.out.println("ok");
    }
}
