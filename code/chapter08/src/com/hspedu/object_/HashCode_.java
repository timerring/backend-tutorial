package com.hspedu.object_;

public class HashCode_ {
    public static void main(String[] args) {

        AA aa = new AA();
        AA aa2 = new AA();
        AA aa3 = aa;
        System.out.println("aa.hashCode()=" + aa.hashCode());
        System.out.println("aa2.hashCode()=" + aa2.hashCode());
        System.out.println("aa3.hashCode()=" + aa3.hashCode());


    }
}
class AA {}
