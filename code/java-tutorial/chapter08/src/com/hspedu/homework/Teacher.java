package com.hspedu.homework;


/*
(1) 要求有属性“姓名name”，“年龄age”，“职称post”，“基本工资salary”
(2) 编写业务方法， introduce（），实现输出一个教师的信息。

 */
public class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;
    //这里我们在增加一个工资级别
    private double grade;

    public Teacher(String name, int age, String post, double salary, double grade) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    public void introduce() {
        System.out.println("name: " + name + " age: " + age
                + " post: " + post + " salary:" + salary + " grade:" + grade);
    }
}
