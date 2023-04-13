package com.hspedu.homework;

import java.sql.SQLOutput;

public class Employee {

    //属性
    //员工属性：姓名，单日工资，工作天数
    private String name;
    private double daySal;
    private int workDays;
    //分析出还有一个属性等级
    private double grade;

    //方法[构造器，getter 和 setter]
    //打印工资方法
    //方法 void printSal() {}
    public void printSal() {
        System.out.println(name + " 工资=" + daySal * workDays * grade);
    }

    public Employee(String name, double daySal, int workDays, double grade) {
        this.name = name;
        this.daySal = daySal;
        this.workDays = workDays;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySal() {
        return daySal;
    }

    public void setDaySal(double daySal) {
        this.daySal = daySal;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
