package com.hspedu.regexp;

public class Homework02 {

    public static void main(String[] args) {
        //要求验证是不是整数或者小数
        //提示： 这个题要考虑正数和负数
        //比如： 123 -345 34.89 -87.9 -0.01 0.45 等
        /**
         * 老师的思路
         * 1. 先写出简单的正则表达式
         * 2. 在逐步的完善[根据各种情况来完善]
         */
        String content = "-0.89"; //
        // 要特别注意00023.1 以及 0.5 等等特殊情况
        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";

        if(content.matches(regStr)) {
            System.out.println("匹配成功 是整数或者小数");
        } else {
            System.out.println("匹配失败");
        }
    }
}
