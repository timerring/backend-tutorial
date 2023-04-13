package com.hspedu.override_;


//编写一个Student类，继承Person类，增加id、score属性/private，以及构造器，定义say方法(返回自我介绍的信息)。
public class Student extends Person{
    private int id;
    private double score;

    public Student(String name, int age, int id, double score) {
        super(name, age);//这里会调用父类构造器
        this.id = id;
        this.score = score;
    }
    //say
    public String say() { //这里体现super的一个好处，代码复用.
        return super.say() + " id=" + id + " score=" + score;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
