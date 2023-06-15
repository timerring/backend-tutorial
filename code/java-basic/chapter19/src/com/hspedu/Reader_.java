package com.hspedu;

public abstract class Reader_ { //抽象类
    public void readFile() {
    }
    public void readString() {
    }

    //在Reader_ 抽象类，使用read方法统一管理.
    //后面在调用时，利于对象动态绑定机制， 绑定到对应的实现子类即可.
    //public abstract void read();
}


