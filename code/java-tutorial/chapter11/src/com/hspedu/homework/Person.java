package com.hspedu.homework;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class Person {
    private String name;
    private Vehicles vehicles;

    //在创建人对象时，事先给他分配一个交通工具
    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    //实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
    //这里涉及到一个编程思路，就是可以把具体的要求，封装成方法-> 这里就是编程思想
    //思考一个问题，如何不浪费，在构建对象时，传入的交通工具对象->动脑筋
    public void passRiver() {
        //先得到船
        //判断一下，当前的 vehicles 属性是null, 就获取一艘船
//        Boat boat = VehiclesFactory.getBoat();
//        boat.work();
        //如何防止始终使用的是传入的马 instanceOf
        //if (vehicles == null) {
        //vehicles instanceof Boat 是判断 当前的 vehicles是不是Boat
        //(1) vehicles = null  : vehicles instanceof Boat  => false
        //(2) vehicles = 马对象 ：vehicles instanceof Boat  => false
        //(3) vehicles = 船对象 ：vehicles instanceof Boat  => true
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    public void common() {
        //得到马儿
        //判断一下，当前的 vehicles 属性是null, 就获取一匹马
        //if (vehicles == null) {
        if (!(vehicles instanceof Horse)) {
            //这里使用的是多态
            vehicles = VehiclesFactory.getHorse();
        }
        //这里体现使用接口调用
        vehicles.work();
    }
    //过火焰山
    public void passFireHill() {
        if (!(vehicles instanceof Plane)) {
            //这里使用的是多态
            vehicles = VehiclesFactory.getPlane();
        }
        //这里体现使用接口调用
        vehicles.work();

    }
}

//有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
