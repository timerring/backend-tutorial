package com.hspedu.standard;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        //System 类 的 public final static InputStream in = null;
        // System.in 编译类型   InputStream
        // System.in 运行类型   BufferedInputStream
        // 表示的是标准输入 键盘
        System.out.println(System.in.getClass());

        //1. System.out public final static PrintStream out = null;
        //2. 编译类型 PrintStream
        //3. 运行类型 PrintStream
        //4. 表示标准输出 显示器
        System.out.println(System.out.getClass());

        System.out.println("hello, 教育");

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容");
        String next = scanner.next();
        System.out.println("next=" + next);

        
    }
}
