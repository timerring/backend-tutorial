package com.hspedu.test;

public class Sub extends Base {

    public Sub() {
        System.out.println("sub()....");
    }
    public void sayOk() {
        //我们发现 父类的非private属性和方法都可以访问
    }
}
class GrandPa {
    String name = "大头爷爷";
    String hobby = "旅游";
}

