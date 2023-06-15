package com.hspedu.modifier;

public class A {

    //四个属性,分别使用不同的访问修饰符来修饰
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;
    public void m1() {
        //在同一类中，可以访问public protected 默认 private 修饰属性和方法
        System.out.println("n1=" + n1 + " n2=" + n2 + " n3=" + n3 + " n4=" + n4);
    }
    protected void m2() { }
    void m3() { }
    private void m4() { }
    public void hi() {
        //在同一类中，可以访问public protected 默认 private 修饰属性和方法
        m1();
        m2();
        m3();
        m4();
    }
}
