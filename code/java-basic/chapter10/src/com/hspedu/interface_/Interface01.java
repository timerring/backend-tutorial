package com.hspedu.interface_;

public class Interface01 {
    public static void main(String[] args) {
        //创建手机，相机对象
        //Camera 实现了 UsbInterface
        Camera camera = new Camera();
        //Phone 实现了 UsbInterface
        Phone phone = new Phone();
        //创建计算机
        Computer computer = new Computer();
        computer.work(phone);//把手机接入到计算机
        System.out.println("===============");
        computer.work(camera);//把相机接入到计算机

    }
}
