package com.hspedu.extend_;

public class Base extends TopBase { //父类
    //4个属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base() { //无参构造器
        System.out.println("父类Base()构造器被调用....");
    }
    public Base(String name, int age) {//有参构造器
        //默认super()
        System.out.println("父类Base(String name, int age)构造器被调用....");
    }
    public Base(String name) {//有参构造器
        System.out.println("父类Base(String name)构造器被调用....");
    }
    //父类提供一个public的方法,返回了n4
    public int getN4() {
        return n4;
    }
    public void test100() {
        System.out.println("test100");
    }
    protected void test200() {
        System.out.println("test200");
    }
    void test300() {
        System.out.println("test300");
    }
    private void test400() {
        System.out.println("test400");
    }
    //call
    public void callTest400() {
        test400();
    }
}

