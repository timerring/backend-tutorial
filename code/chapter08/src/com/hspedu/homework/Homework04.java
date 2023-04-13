package com.hspedu.homework;

public class Homework04 {
    public static void main(String[] args) {
        Manager manage = new Manager("刘备", 100, 20, 1.2);
        //设置奖金
        manage.setBonus(3000);
        //打印经理的工资情况
        manage.printSal();

        Worker worker = new Worker("关羽",50, 10, 1.0);
        worker.printSal();

    }
}
