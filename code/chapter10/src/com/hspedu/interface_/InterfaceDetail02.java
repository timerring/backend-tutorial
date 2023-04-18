package com.hspedu.interface_;

public class InterfaceDetail02 {
    public static void main(String[] args) {
        //老韩证明 接口中的属性,是 public static final
        System.out.println(IB.n1);//说明n1 就是static
        //IB.n1 = 30; 说明n1 是 final
    }
}
interface IB {
    //接口中的属性,只能是final的，而且是 public static final 修饰符
    int n1 = 10; //等价 public static final int n1 = 10;
    void hi();
}
interface IC {
    void say();
}
//接口不能继承其它的类,但是可以继承多个别的接口
interface ID extends IB,IC {
}
//接口的修饰符 只能是 public 和默认，这点和类的修饰符是一样的
interface IE{}

//一个类同时可以实现多个接口
class Pig implements IB,IC {
    @Override
    public void hi() {
    }
    @Override
    public void say() {
    }
}
