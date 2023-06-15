package com.hspedu.interface_;

public class InterfaceDetail01 {
    public static void main(String[] args) {
        //new IA();
    }
}

//1.接口不能被实例化
//2.接口中所有的方法是 public方法,  接口中抽象方法，可以不用abstract 修饰
//3.一个普通类实现接口,就必须将该接口的所有方法都实现,可以使用alt+enter来解决
//4.抽象类去实现接口时，可以不实现接口的抽象方法
interface IA {
    void say();//修饰符 public protected 默认 private
    void hi();
}
class Cat implements IA{
    @Override
    public void say() {

    }

    @Override
    public void hi() {

    }
}
abstract class Tiger implements  IA {

}
