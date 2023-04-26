package com.hspedu.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        //完成代码
        Map hashMap = new HashMap();
        //添加对象
        hashMap.put(1, new Emp("jack", 300000, 1));
        hashMap.put(2, new Emp("tom", 21000, 2));
        hashMap.put(3, new Emp("milan", 12000, 3));


        //遍历2种方式
        //并遍历显示工资>18000的员工(遍历方式最少两种)
        //1. 使用keySet  -> 增强for
        Set keySet = hashMap.keySet();
        System.out.println("====第一种遍历方式====");
        for (Object key : keySet) {
            //先获取value
            Emp emp = (Emp) hashMap.get(key);
            if(emp.getSal() >18000) {
                System.out.println(emp);
            }
        }

        //2. 使用EntrySet -> 迭代器
        Set entrySet = hashMap.entrySet();
        System.out.println("======迭代器======");
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            // 真正的运行类型是Node，可以getClass看一下
            Map.Entry entry =  (Map.Entry)iterator.next();
            //通过entry 取得key 和 value
            Emp emp = (Emp) entry.getValue();
            if(emp.getSal() > 18000) {
                System.out.println(emp);
            }
        }
    }
}

/**
 * 使用HashMap添加3个员工对象，要求
 * 键：员工id
 * 值：员工对象
 * 并遍历显示工资>18000的员工(遍历方式最少两种)
 * 员工类：姓名、工资、员工id
 */
class Emp {
    private String name;
    private double sal;
    private int id;

    public Emp(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
