package com.hspedu.abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        //测试
        Manager jack = new Manager("jack", 999, 50000);
        jack.setBonus(8000);
        jack.work();

        CommonEmployee tom = new CommonEmployee("tom", 888, 20000);
        tom.work();
    }
}
