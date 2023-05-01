package com.hspedu.generic;

import java.util.*;

@SuppressWarnings({"all"})
public class GenericExercise {
    public static void main(String[] args) {
        // 使用泛型方式给HashSet 放入3个学生对象
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("jack", 18));
        students.add(new Student("tom", 28));
        students.add(new Student("mary", 19));

        // 遍历
        for (Student student : students) {
            System.out.println(student);
        }

        // 使用泛型方式给HashMap 放入3个学生对象
        // K -> String V->Student
        HashMap<String, Student> hm = new HashMap<String, Student>();
        /*
            public class HashMap<K,V>  {}
         */
        hm.put("milan", new Student("milan", 38));
        hm.put("smith", new Student("smith", 48));
        hm.put("hsp", new Student("hsp", 28));

        //迭代器 EntrySet
        /*
        public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> es;
            return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
        }
         */
        Set<Map.Entry<String, Student>> entries = hm.entrySet();
        /*
            public final Iterator<Map.Entry<K,V>> iterator() {
                return new EntryIterator();
            }
         */
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        System.out.println("==============================");
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }
    }
}
/**
 * 创建 3 个学生对象
 * 放入到 HashSet 中学生对象, 使用.
 * 放入到  HashMap中，要求 Key 是 String name, Value 就是 学生对象
 * 使用两种方式遍历
 */
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
