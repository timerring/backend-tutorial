package com.hspedu.homework.homework5;

public class Homework05 {
    public static void main(String[] args) {
        Worker jack = new Worker("jack", 10000);
        jack.setSalMonth(15);//灵活额修改带薪月份
        jack.printSal();

        Peasant smith = new Peasant("smith", 20000);
        smith.printSal();

        //老师测试
        Teacher teacher = new Teacher("顺平", 2000);
        //老师有课时费
        teacher.setClassDays(360);
        teacher.setClassSal(1000);
        teacher.printSal();

        //科学家
        Scientist scientist = new Scientist("钟南山", 20000);
        scientist.setBonus(2000000);
        scientist.printSal();
    }
}
