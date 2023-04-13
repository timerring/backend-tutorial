package com.hspedu.homework;

public class Homework15 {
    public static void main(String[] args) {
        AAA obj = new BBB();//向上转型
        AAA b1 = obj;
        System.out.println("obj的运行类型=" + obj.getClass());//BBB
        obj = new CCC();//向上转型

        System.out.println("obj的运行类型=" + obj.getClass());//CCC
        obj = b1;

        System.out.println("obj的运行类型=" + obj.getClass());//BBB
    }
}

class AAA {//超类

}
class BBB extends AAA {//父类

}
class CCC extends BBB {//子类

}