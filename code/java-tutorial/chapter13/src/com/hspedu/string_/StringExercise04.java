package com.hspedu.string_;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class StringExercise04 {
    public static void main(String[] args) {
        String s1 = "hspedu"; //指向常量池”hspedu”
        String s2 = "java"; //指向常量池”java”
        String s4 = "java";//指向常量池”java”
        String s3 = new String("java");//指向堆中对象
        System.out.println(s2 == s3); // F
        System.out.println(s2 == s4);  //T
        System.out.println(s2.equals(s3));//T
        System.out.println(s1 == s2);  //F

    }
}
