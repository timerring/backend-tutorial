package com.hspedu.map_;

import java.util.HashMap;
import java.util.Objects;

@SuppressWarnings({"all"})
public class HashMapSource2 {
    public static void main(String[] args) {


        HashMap hashMap = new HashMap();
        for(int i = 1; i <= 12; i++) {
            hashMap.put(i, "hello");
        }

        hashMap.put("aaa", "bbb");

        System.out.println("hashMap=" + hashMap);//12个 k-v

        //布置一个任务，自己设计代码去验证，table 的扩容
        //0 -> 16(12) -> 32(24) -> 64(64*0.75=48)-> 128 (96) ->
        //自己设计程序，验证-》 增强自己阅读源码能力. 看别人代码.
    }
}

class A  {
    private int num;

    public A(int num) {
        this.num = num;
    }

    //所有的A对象的hashCode都是100
//    @Override
//    public int hashCode() {
//        return 100;
//    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}
