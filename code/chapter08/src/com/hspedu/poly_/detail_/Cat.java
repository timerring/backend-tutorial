package com.hspedu.poly_.detail_;

public class Cat extends Animal {
    public void eat(){//方法重写
        System.out.println("猫吃鱼");
    }
    public void catchMouse(){//Cat特有方法
        System.out.println("猫抓老鼠");
    }
}
