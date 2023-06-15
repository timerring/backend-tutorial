package com.hspedu.homework;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class Homework07 {
    public static void main(String[] args) {
        //实例化不同的car对象
        Car2 car2 = new Car2(60);
        car2.getAir().flow();
        Car2 car21 = new Car2(-1);
        car21.getAir().flow();
        Car2 car22 = new Car2(20);
        car22.getAir().flow();
    }
}
/*
有一个Car2类，有属性temperature（温度），车内有Air（空调）类，有吹风的功能flow，
Air会监视车内的温度，如果温度超过40度则吹冷气。如果温度低于0度则吹暖气，
如果在这之间则关掉空调。实例化具有不同温度的Car对象，调用空调的flow方法，
测试空调吹的风是否正确 . //体现 类与类的包含关系的案例 类(内部类【成员内部类】)

 */
class Car2 {

   private double temperature;

    public Car2(double temperature) {
        this.temperature = temperature;
    }

    //Air 成员内部类
   class Air {
       public void flow() {
           if(temperature > 40) {
               System.out.println("温度大于40 空调吹冷气..");
           } else if(temperature < 0) {
               System.out.println("温度小于0 空调吹暖气..");
           } else {
               System.out.println("温度正常，关闭空调..");
           }
       }
   }
   //返回一个Air对象
    public Air getAir() {
       return new Air();
    }
}
