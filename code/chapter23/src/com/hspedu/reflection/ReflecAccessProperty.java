package com.hspedu.reflection;

import java.lang.reflect.Field;

/**
 * 演示反射操作属性
 */
public class ReflecAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        //1. 得到Student类对应的 Class对象
        Class<?> stuClass = Class.forName("com.hspedu.reflection.Student");
        //2. 创建对象
        Object o = stuClass.newInstance();//o 的运行类型就是Student
        System.out.println(o.getClass());//Student
        //3. 使用反射得到 age 属性对象
        Field age = stuClass.getField("age");
        age.set(o, 88);//通过反射来操作属性
        System.out.println(o);//
        System.out.println(age.get(o));//返回age属性的值

        //4. 使用反射操作name 属性
        Field name = stuClass.getDeclaredField("name");
        //对name 进行暴破, 可以操作private 属性
        name.setAccessible(true);
        //name.set(o, "老");
        name.set(null, "老~");// 因为name是static属性，在类加载的时候就已经有了，因此 o 也可以写出null
        System.out.println(o);
        System.out.println(name.get(o)); // 获取属性值
        System.out.println(name.get(null));// 获取属性值, 必须要求name是static
    }
}

class Student {//类
    public int age;
    private static String name;

    public Student() {//构造器
    }
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}

