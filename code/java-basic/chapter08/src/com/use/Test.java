package com.use;

import com.xiaoqiang.Dog;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {

        Dog dog = new Dog();
        System.out.println(dog);//com.xiaoqiang.Dog@1540e19d

        com.xiaoming.Dog dog1 = new com.xiaoming.Dog();
        System.out.println(dog1);//com.xiaoming.Dog@677327b6


        System.out.println(Math.abs(-1));
    }
}
