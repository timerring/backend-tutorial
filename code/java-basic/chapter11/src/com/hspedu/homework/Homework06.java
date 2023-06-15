package com.hspedu.homework;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class Homework06 {
    public static void main(String[] args) {
        Person tang = new Person("唐僧", new Horse());
        tang.common();//一般情况下
        tang.passRiver();//过河
        tang.common();//一般情况下
        tang.passRiver();//过河
        tang.passRiver();//过河
        tang.passRiver();//过河
        //过火焰山
        tang.passFireHill();

    }
}
/*
1.有一个交通工具接口类Vehicles，有work接口
2.有Horse类和Boat类分别实现Vehicles
3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
5.实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
6.增加一个情况，如果唐僧过火焰山, 使用 飞机 ==> 程序扩展性, 我们前面的程序结构就非常好扩展 10min
使用代码实现上面的要求
编程 需求---->理解---->代码-->优化
 */

