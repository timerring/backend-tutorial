package com.hspedu.static_;

public class StaticExercise01 {
}

class Test {
    static int count = 9;
    public void count() {
        System.out.println("count=" + (count++));
    }
    public static void main(String args[]) {
        new Test().count(); //9
        new Test().count(); //10
        System.out.println(Test.count);	//11
    }
}