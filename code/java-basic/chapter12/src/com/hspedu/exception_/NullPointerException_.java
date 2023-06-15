package com.hspedu.exception_;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class NullPointerException_ {
    public static void main(String[] args) {

        String name = null; // 空指针出现异常
        System.out.println(name.length());
    }
}
