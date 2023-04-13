package com.hspedu.encap;

public class Encapsulation01 {

    public static void main(String[] args) {
        //如果要使用快捷键alt+r, 需要先配置主类
        //第一次，我们使用鼠标点击形式运算程序，后面就可以用
        Person person = new Person();
        person.setName("韩顺平");
        person.setAge(30);
        person.setSalary(30000);
        System.out.println(person.info());
        System.out.println(person.getSalary());

        //如果我们自己使用构造器指定属性
        Person smith = new Person("smith", 80, 50000);
        System.out.println("====smith的信息======");
        System.out.println(smith.info());


    }
}
/*
那么在java中如何实现这种类似的控制呢?
请大家看一个小程序(com.hspedu.encap: Encapsulation01.java),
不能随便查看人的年龄,工资等隐私，并对设置的年龄进行合理的验证。年龄合理就设置，否则给默认
年龄, 必须在 1-120, 年龄， 工资不能直接查看 ， name的长度在 2-6字符 之间

 */
class Person {
    public  String name; //名字公开
    private int age; //age 私有化
    private double salary; //..

    public void say(int n,String name) {

    }
    //构造器 alt+insert
    public Person() {
    }
    //有三个属性的构造器
    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        //我们可以将set方法写在构造器中，这样仍然可以验证
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    // 自己写setXxx 和 getXxx 太慢，我们使用快捷键 Generate --> Getter and Setter
    // 然后根据要求来完善我们的代码.
    public String getName() {
        return name;
    }
    public void setName(String name) {
        // 加入对数据的校验,相当于增加了业务逻辑
        if(name.length() >= 2 && name.length() <=6 ) {
            this.name = name;
        }else {
            System.out.println("名字的长度不对，需要(2-6)个字符，默认名字");
            this.name = "无名人";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //判断
        if(age >= 1 && age <= 120) {//如果是合理范围
            this.age = age;
        } else {
            System.out.println("你设置年龄不对，需要在 (1-120), 给默认年龄18 ");
            this.age = 18;//给一个默认年龄
        }
    }

    public double getSalary() {
        //可以这里增加对当前对象的权限判断
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    //写一个方法，返回属性信息
    public String info() {
        return "信息为 name=" + name  + " age=" + age + " 薪水=" + salary;
    }
}
