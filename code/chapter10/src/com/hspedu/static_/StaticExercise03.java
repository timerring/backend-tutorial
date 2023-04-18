package com.hspedu.static_;

public class StaticExercise03 {
}

class Person { //StaticExercise03.java 2min 看
    private int id;
    private static int total = 0;
    public static void setTotalPerson(int total){
        // this.total = total;//错误，因为在static方法中，不可以使用this 关键字

        Person.total = total;
    }
    public Person() {//构造器
        total++;
        id = total;
    }
    //编写一个方法，输出total的值
    public static void m() {
        System.out.println("total的值=" + total);
    }
}
class TestPerson {
    public static void main(String[] args) {

        Person.setTotalPerson(3);
        new Person(); //最后 total的值就是4
        Person.m();//看看输出的是不是4
    }
}