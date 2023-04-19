package com.hspedu.exception_;

public class NumberFormatException_ {
    public static void main(String[] args) {
        String name = "timerring";
        //将String 转成 int
        int num = Integer.parseInt(name); // 抛出NumberFormatException
        System.out.println(num);
    }
}
