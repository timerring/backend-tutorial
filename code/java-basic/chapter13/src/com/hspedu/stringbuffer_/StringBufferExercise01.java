package com.hspedu.stringbuffer_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;// ok
        StringBuffer sb = new StringBuffer(); //ok
        sb.append(str);// 需要看源码 , 底层调用的是 AbstractStringBuilder 的 appendNull, 转为了一个字符数组。
        System.out.println(sb.length());// 4

        System.out.println(sb);// null 是一个字符数组
        //下面的构造器，会抛出NullpointerException
        StringBuffer sb1 = new StringBuffer(str);// 看底层源码 super(str.length() + 16); 会抛出空指针异常
        System.out.println(sb1);
    }
}
