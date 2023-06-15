package com.hspedu.homework;

import java.util.Scanner;


public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);//一定要注意.
        a.start();
        b.start();
    }
}

//创建A线程类
class A extends Thread {
    private boolean loop = true;

    @Override
    public void run() {
        //输出1-100数字
        while (loop) {
            System.out.println((int)(Math.random() * 100 + 1));
            //休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a线程退出...");

    }

    public void setLoop(boolean loop) {//可以修改loop变量
        this.loop = loop;
    }
}

//直到第2个线程从键盘读取了“Q”命令
class B extends Thread {
    private A a;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {//构造器中，直接传入A类对象
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            //接收到用户的输入
            System.out.println("请输入你指令(Q)表示退出:");
            char key = scanner.next().toUpperCase().charAt(0);
            if(key == 'Q') {
                //以通知的方式结束a线程
                a.setLoop(false);
                System.out.println("b线程退出.");
                break;
            }
        }
    }
}
