package com.hspedu.wrapper;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class WrapperExercise01 {
    public static void main(String[] args) {
        Double d = 100d; //ok, 自动装箱 Double.valueOf(100d);
        Float f = 1.5f; //ok, 自动装箱 Float.valueOf(1.5f);

        Object obj1 = true? new Integer(1) : new Double(2.0);//三元运算符【是一个整体】 一真大师
        System.out.println(obj1);// 什么? 1.0

        Object obj2;
        if(true)
            obj2 = new Integer(1);
        else
            obj2 = new Double(2.0);
        System.out.println(obj2);//1
        //输出什么 ? 1， 分别计算

    }
}
