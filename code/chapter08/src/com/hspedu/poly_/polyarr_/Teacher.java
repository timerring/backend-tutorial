package com.hspedu.poly_.polyarr_;

public class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    //写重写父类的say方法

    @Override
    public String say() {
        return "老师 " + super.say() + " salary=" + salary;
    }
    //特有方法
    public void teach() {
        System.out.println("老师 " + getName() + " 正在讲java课程...");
    }
}
