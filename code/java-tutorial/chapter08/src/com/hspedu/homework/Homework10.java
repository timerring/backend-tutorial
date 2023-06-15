package com.hspedu.homework;

public class Homework10 {
    public static void main(String[] args) {
        //测试
        Doctor doctor1 = new Doctor("jack", 20, "牙科医生", '男', 20000);
        Doctor doctor2 = new Doctor("jack", 21, "牙科医生", '男', 20000);
        
        System.out.println(doctor1.equals(doctor2));//T
    }
}
