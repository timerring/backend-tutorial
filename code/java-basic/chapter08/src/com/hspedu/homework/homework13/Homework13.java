package com.hspedu.homework.homework13;

public class Homework13 {
    public static void main(String[] args) {

        //测试老师
        Teacher teacher = new Teacher("张飞", '男', 30, 5);

        teacher.printInfo();

        //测试
        Student student = new Student("小明", '男', 15, "00023102");
        System.out.println("-----------------------------------");
        student.printInfo();//封装


        //定义多态数组，里面保存2个学生和2个教师，要求按年龄从高到低排序
        Person[] persons = new Person[4];
        persons[0] = new Student("jack", '男', 10, "0001");
        persons[1] = new Student("mary", '女', 20, "0002");
        persons[2] = new Teacher("smith", '男', 36, 5);
        persons[3] = new Teacher("scott", '男', 26, 1);

        //创建对象
        Homework13 homework13 = new Homework13();
        homework13.bubbleSort(persons);

        //输出排序后的数组
        System.out.println("---排序后的数组-----");
        for(int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        //遍历数组，调用test方法
        System.out.println("=======================");
        for (int i = 0; i < persons.length; i++) {//遍历多态数组
            homework13.test(persons[i]);
        }

    }

    //定义方法，形参为Person类型，功能：调用学生的study或教师的teach方法
    //分析这里会使用到向下转型和类型判断
    public void test(Person p) {
        if(p instanceof Student) {//p 的运行类型如果是Student
            ((Student) p).study();
        } else if(p instanceof  Teacher) {
            ((Teacher) p).teach();
        } else {
            System.out.println("do nothing...");
        }
    }

    //方法,完成年龄从高到底排序
    public void bubbleSort(Person[] persons) {
        Person temp = null;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                //判断条件, 注意这里的条件可以根据需要，变化
                if(persons[j].getAge() < persons[j+1].getAge()) {
                    temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }

}
