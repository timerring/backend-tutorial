package com.hspedu.customexception_;

public class CustomException {
    public static void main(String[] args) /*throws AgeException*/ {

        int age = 180;
        //要求范围在 18 – 120 之间，否则抛出一个自定义异常
        if(!(age >= 18 && age <= 120)) {
            //这里我们可以通过构造器，设置信息
            throw new AgeException("年龄需要在 18~120之间");
        }
        System.out.println("你的年龄范围正确.");
    }
}
// 自定义一个异常
// 1. 一般情况下，我们自定义异常是继承 RuntimeException
// 2. 即把自定义异常做成 运行时异常，好处是我们可以使用默认的处理机制
class AgeException extends RuntimeException {
    public AgeException(String message) {//构造器
        super(message); // 调用父构造器，可以进入源码逐级查看。
    }
}
