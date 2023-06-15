package com.hspedu.wrapper;

public class WrapperExercise02 {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);  //False
        //所以，这里主要是看范围 -128 ~ 127 就是直接返回
        /*
        老韩解读
        //1. 如果i 在 IntegerCache.low(-128)~IntegerCache.high(127),就直接从数组返回
        //2. 如果不在 -128~127,就直接 new Integer(i)
         public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }
         */
        Integer m = 1; //底层 Integer.valueOf(1); -> 阅读源码
        Integer n = 1;//底层 Integer.valueOf(1);
        System.out.println(m == n); //T
        //所以，这里主要是看范围 -128 ~ 127 就是直接返回
        //，否则，就new Integer(xx);
        Integer x = 128;//底层Integer.valueOf(1);
        Integer y = 128;//底层Integer.valueOf(1);
        System.out.println(x == y);//False

    }
}
