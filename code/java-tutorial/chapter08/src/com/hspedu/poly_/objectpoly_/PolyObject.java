package com.hspedu.poly_.objectpoly_;

public class PolyObject {
    public static void main(String[] args) {
        //体验对象多态特点
        //animal 编译类型就是 Animal , 运行类型 Dog
        Animal animal = new Dog();
        //因为运行时 , 执行到改行时，animal运行类型是Dog,所以cry就是Dog的cry
        animal.cry(); //小狗汪汪叫

        //animal 编译类型 Animal,运行类型就是 Cat
        animal = new Cat();
        animal.cry(); //小猫喵喵叫
    }
}
