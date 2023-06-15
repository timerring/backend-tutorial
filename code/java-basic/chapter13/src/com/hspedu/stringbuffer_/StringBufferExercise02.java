package com.hspedu.stringbuffer_;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        /*
        输入商品名称和商品价格，要求打印效果示例, 使用前面学习的方法完成：
        商品名	商品价格
        手机	123,564.59  //比如 价格 3,456,789.88
        要求：价格的小数点前面每三位用逗号隔开, 在输出。
        思路分析
        1. 定义一个Scanner 对象，接收用户输入的 价格(String)
        2. 希望使用到 StringBuffer的 insert ，需要将 String 转成 StringBuffer
        3. 然后使用相关方法进行字符串的处理
         */

        //new Scanner(System.in)
        String price = "8123564.59";
        StringBuffer sb = new StringBuffer(price);
        //先完成一个最简单的实现123,564.59
        //找到小数点的索引，然后在该位置的前3位，插入,即可
//        int i = sb.lastIndexOf(".");
//        sb = sb.insert(i - 3, ",");

        //上面的两步需要做一个循环处理,才是正确的
        for (int i = sb.lastIndexOf(".") - 3; i > 0; i -= 3) {
            sb = sb.insert(i, ",");
        }
        System.out.println(sb);//8,123,564.59
    }
}
