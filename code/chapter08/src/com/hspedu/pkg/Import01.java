package com.hspedu.pkg;

import java.util.Arrays;

//注意:
//老韩建议：我们需要使用到哪个类，就导入哪个类即可，不建议使用 *导入
//import java.util.Scanner; //表示只会引入java.util 包下的 Scanner
//import java.util.*;//表示将java.util 包下的所有类都引入(导入)
public class Import01 {

    public static void main(String[] args) {

        //使用系统提供 Arrays 完成 数组排序
        int[] arr = {-1, 20, 2, 13, 3};
        //比如对其进行排序
        //传统方法是，自己编写排序(冒泡)
        //系统是提供了相关的类，可以方便完成 Arrays
        Arrays.sort(arr);
        //输出排序结果
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
