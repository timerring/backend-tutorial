package com.hspedu.homework;

//子类
public class Professor extends Teacher {

    //特有属性...
    public Professor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    @Override
    public void introduce() {
        System.out.println(" 这是教授的信息 ");
        super.introduce();
    }
}
