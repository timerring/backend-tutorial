package com.hspedu.set_;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class HashSetIncrement {
    public static void main(String[] args) {
        /*
        HashSet底层是HashMap, 第一次添加时，table 数组扩容到 16，
        临界值(threshold)是 16*加载因子(loadFactor)是0.75 = 12
        如果table 数组使用到了临界值 12,就会扩容到 16 * 2 = 32,
        新的临界值就是 32*0.75 = 24, 依次类推

         */
        HashSet hashSet = new HashSet();
//        for(int i = 1; i <= 100; i++) {
//            hashSet.add(i);//1,2,3,4,5...100
//        }
        /*
        在Java8中, 如果一条链表的元素个数到达 TREEIFY_THRESHOLD(默认是 8 )，
        并且table的大小 >= MIN_TREEIFY_CAPACITY(默认64),就会进行树化(红黑树),
        否则仍然采用数组扩容机制

         */

//        for(int i = 1; i <= 12; i++) {
//            hashSet.add(new A(i));//
//        }


        /*
            当我们向hashset增加一个元素，-> Node -> 加入table , 就算是增加了一个size++

         */

        for(int i = 1; i <= 7; i++) {//在table的某一条链表上添加了 7个A对象
            hashSet.add(new A(i));//
        }

        for(int i = 1; i <= 7; i++) {//在table的另外一条链表上添加了 7个B对象
            hashSet.add(new B(i));//
        }



    }
}

class B {
    private int n;

    public B(int n) {
        this.n = n;
    }
    @Override
    public int hashCode() {
        return 200;
    }
}

class A {
    private int n;

    public A(int n) {
        this.n = n;
    }
    @Override
    public int hashCode() {
        return 100;
    }
}