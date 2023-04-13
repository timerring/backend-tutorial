package com.hspedu.override_;

public class Dog extends Animal{
    //老韩解读
    //1. 因为Dog 是 Animal子类
    //2. Dog的 cry方法和 Animal的 cry定义形式一样(名称、返回类型、参数)
    //3. 这时我们就说 Dog的cry方法，重写了Animal的cry方法
    public void cry() {
        System.out.println("小狗汪汪叫..");
    }

    //细节: 子类方法的返回类型和父类方法返回类型一样，
    //      或者是父类返回类型的子类比如 父类 返回类型是 Object ,
    //      子类方法返回类型是String
    public String m1() {
        return null;
    }
    //这里Object 不是 String的子类，因此编译错误
//    public Object m2() {
//        return null;
//    }

//    public BBB m3() {
//        return null;
//    }
    //细节: 子类方法不能缩小父类方法的访问权限 【演示】
    //public > protected > 默认>private
    public void eat() {

    }
}

class AAA {

}

class BBB extends AAA  {

}
