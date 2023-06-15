- [第17章 多线程基础](#第17章-多线程基础)
  - [线程相关概念](#线程相关概念)
    - [程序(program)](#程序program)
    - [进程](#进程)
    - [线程](#线程)
    - [其他相关概念](#其他相关概念)
  - [线程基本使用](#线程基本使用)
    - [创建线程的两种方式](#创建线程的两种方式)
    - [线程应用案例1-继承Thread 类](#线程应用案例1-继承thread-类)
    - [线程应用案例2-实现Runnable 接口](#线程应用案例2-实现runnable-接口)
    - [线程使用应用案例-多线程执行](#线程使用应用案例-多线程执行)
    - [线程如何理解](#线程如何理解)
  - [继承Thread vs 实现Runnable 的区别](#继承thread-vs-实现runnable-的区别)
  - [线程终止](#线程终止)
    - [基本说明](#基本说明)
    - [应用案例](#应用案例)
  - [线程常用方法](#线程常用方法)
    - [常用方法第一组](#常用方法第一组)
    - [注意事项和细节](#注意事项和细节)
    - [常用方法第二组](#常用方法第二组)
    - [课堂练习](#课堂练习)
    - [用户线程和守护线程](#用户线程和守护线程)
    - [应用案例](#应用案例-1)
  - [线程的生命周期](#线程的生命周期)
    - [线程的几种状态](#线程的几种状态)
    - [线程状态转换图!!!!](#线程状态转换图)
  - [Synchronized](#synchronized)
    - [线程同步机制](#线程同步机制)
    - [同步具体方法-Synchronized](#同步具体方法-synchronized)
      - [方法一同步代码块](#方法一同步代码块)
      - [方法二方法声明](#方法二方法声明)
  - [分析同步原理](#分析同步原理)
  - [互斥锁](#互斥锁)
    - [基本介绍](#基本介绍)
    - [注意事项和细节](#注意事项和细节-1)
  - [线程的死锁](#线程的死锁)
    - [基本介绍](#基本介绍-1)
    - [应用案例](#应用案例-2)
  - [释放锁](#释放锁)
    - [下面操作会释放锁](#下面操作会释放锁)
    - [下面操作不会释放锁](#下面操作不会释放锁)
  - [本章作业](#本章作业)


# 第17章 多线程基础

## 线程相关概念

### 程序(program)

是为完成特定任务、用某种语言编写的一组指令的集合。简单的说:就是我们写的代码。

### 进程

1. 进程是指运行中的程序，比如我们使用QQ，就启动了一个进程，操作系统就会为该进程分配内存空间。当我们使用迅雷，又启动了一个进程，操作系统将为迅雷分配新的内存空间。
2. 进程是程序的一次执行过程，或是正在运行的一个程序。是动态过程:有它自身的产生、存在和消亡的过程

### 线程

1. 线程由进程创建的，是进程的一个实体

2. 一个进程可以拥有多个线程,如下图

   ![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502103158365.png)

### 其他相关概念

1. 单线程:同一个时刻,只允许执行一个线程。
2. 多线程:同一个时刻,可以执行多个线程，比如:一个qq进程，可以同时打
   开多个聊天窗口,一个迅雷进程,可以同时下载多个文件。

3. 并发:同一个时刻，多个任务交替执行，造成一种“貌似同时”的错觉，简单的说单核cpu实现的多任务就是并发。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502103319867.png)

4. 并行:同一个时刻，多个任务同时执行。多核cpu可以实现并行。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502103342717.png)

获取cpu的数量/核心数

```java
package com.hspedu;


public class CpuNum {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑的cpu数量/核心数
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前有cpu 个数=" + cpuNums);
    }
}
```

## 线程基本使用

### 创建线程的两种方式

在java中线程来使用有两种方法。

1.继承Thread类，重写run方法

2.实现Runnable接口,重写run方法

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502103456334.png)

### 线程应用案例1-继承Thread 类

运行程序时就相当启动了一个进程，进入main时就开启了一个main线程，

1)请编写程序,开启一个线程，该线程每隔1秒。在控制台输出“哺瞄。我是小猫咪

2)对上题改进:当输出80次啪瞄,我是小猫咪,结束该线程

3)使用JConsole 监控线程执行情况,并画出程序示意图!

> 在进程运行时直接在控制台输入JConsole即可。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502105712960.png)

主线程挂了但是子线程还在继续执行，这并不会导致应用程序的结束。说明: 当main线程启动一个子线程 Thread-0, 主线程不会阻塞, 会继续执行（不会等执行完毕后再往下执行），这时 主线程和子线程是交替执行。

```java
package com.hspedu.threaduse;

/**
 * 演示通过继承 Thread 类创建线程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {

        //创建Cat对象，可以当做线程使用
        Cat cat = new Cat();

        // 读源码
        /*
            (1)
            public synchronized void start() {
                start0();
            }
            (2)
            //start0() 是本地方法，是JVM调用, 底层是c/c++实现
            //真正实现多线程的效果， 是start0(), 而不是 run
            private native void start0();

         */

        cat.start();// 启动线程-> 最终会执行cat的run方法



        //cat.run();//run方法就是一个普通的方法, 没有真正的启动一个线程，就会把run方法执行完毕，才向下执行，因此要真正实现多线程，还是应该使用start方法。
        //说明: 当main线程启动一个子线程 Thread-0, 主线程不会阻塞, 会继续执行（不会等执行完毕后再往下执行），这时 主线程和子线程是交替执行。
        System.out.println("主线程继续执行" + Thread.currentThread().getName());//名字main
        for(int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}

// 说明
//1. 当一个类继承了 Thread 类， 该类就可以当做线程使用
//2. 我们会重写 run方法，写上自己的业务代码
//3. run Thread 类 实现了 Runnable 接口的run方法，如下

/*
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
 */



class Cat extends Thread {

    int times = 0;
    @Override
    public void run() {//重写run方法，写上自己的业务逻辑

        while (true) {
            //该线程每隔1秒。在控制台输出 “喵喵, 我是小猫咪”
            System.out.println("喵喵, 我是小猫咪" + (++times) + " 线程名=" + Thread.currentThread().getName());
            //让该线程休眠1秒 ctrl+alt+t
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 80) {
                break;//当times 到80, 退出while, 这时线程也就退出..
            }
        }
    }
}
```

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502133227747.png)

start()方法调用start0()方法后，该线程并不一定会立马执行，只是将线程变成了可运行状态。具体什么时候执行，取决于CPU，由CPU统一调度。

### 线程应用案例2-实现Runnable 接口

1. **java是单继承的，在某些情况下一个类可能已经继承了某个父类,这时在用继承Thread类方法来创建线程显然不可能了。**
2. java设计者们提供了另外一个方式创建线程，就是通过实现Runnable接口来创建线程

应用案例

请编写程序,该程序可以每隔1秒。在控制台输出“hi!”,当输出10次后，自动退出。请使用实现Runnable接口的方式实现。

这里底层使用了设计模式[代理模式]=>代码模拟实现Runnable接口开发线程的机制

```java
package com.hspedu.threaduse;

/**
 * 通过实现接口Runnable 来开发线程
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start(); 这里不能调用start
        //创建了Thread对象，把 dog对象(实现Runnable),放入Thread
        Thread thread = new Thread(dog);
        thread.start();

//        Tiger tiger = new Tiger();//实现了 Runnable
          // 1.
//        ThreadProxy threadProxy = new ThreadProxy(tiger);
          // 2.
//        threadProxy.start();
    }
}

class Animal {
}

class Tiger extends Animal implements Runnable {
    // 6.
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫....");
    }
}

//线程代理类 , 模拟了一个极简的Thread类
class ThreadProxy implements Runnable {//你可以把Proxy类当做 ThreadProxy

    private Runnable target = null;//属性，类型是 Runnable
    // 5.
    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定（运行类型Tiger）
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    // 3.
    public void start() {
        start0();//这个方法时真正实现多线程方法
    }
    // 4.
    public void start0() {
        run();
    }
}


class Dog implements Runnable { //通过实现Runnable接口，开发线程

    int count = 0;

    @Override
    public void run() { //普通方法
        while (true) {
            System.out.println("小狗汪汪叫..hi" + (++count) + Thread.currentThread().getName());

            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10) {
                break;
            }
        }
    }
}
```

### 线程使用应用案例-多线程执行

请编写一个程序,创建两个线程,一个线程每隔1秒输出“hello,world”,输出10次，退出, 一个线程每隔1秒输出“hi”，输出5次退出。

```java
package com.hspedu.threaduse;

/**
 * main线程启动两个子线程
 */
public class Thread03 {
    public static void main(String[] args) {

        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();//启动第1个线程
        thread2.start();//启动第2个线程
    }
}

class T1 implements Runnable {

    int count = 0;

    @Override
    public void run() {
        while (true) {
            //每隔1秒输出 “hello,world”,输出10次
            System.out.println("hello,world " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 60) {
                break;
            }
        }
    }
}

class T2 implements Runnable {

    int count = 0;

    @Override
    public void run() {
        //每隔1秒输出 “hi”,输出5次
        while (true) {
            System.out.println("hi " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 50) {
                break;
            }
        }
    }
}
```

### 线程如何理解

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502135349669.png)

## 继承Thread vs 实现Runnable 的区别

1. 从java的设计来看，通过继承Thread或者实现Runnable接口来创建线程本质上没有区别,从jdk帮助文档我们可以看到Thread类本身就实现了
   Runnable接口。

2. 实现Runnable接口方式更加适合多个线程共享一个资源的情况，并且避免了单继承的限制,建议使用Runnable。
3. [售票系统]，编程模拟三个售票窗口售票100,分别使用继承 Thread和实现 Runnable方式,并分析有什么问题? 均会出现超卖的问题。

```java
package com.hspedu.ticket;

/**
 * 使用多线程，模拟三个窗口同时售票100张
 */
public class SellTicket {
    public static void main(String[] args) {

        //测试
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        //这里我们会出现超卖..
//        sellTicket01.start();//启动售票线程
//        sellTicket02.start();//启动售票线程
//        sellTicket03.start();//启动售票线程


        System.out.println("===使用实现接口方式来售票=====");
        SellTicket02 sellTicket02 = new SellTicket02();

        new Thread(sellTicket02).start();//第1个线程-窗口
        new Thread(sellTicket02).start();//第2个线程-窗口
        new Thread(sellTicket02).start();//第3个线程-窗口


    }
}

//使用Thread方式

class SellTicket01 extends Thread {

    private static int ticketNum = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));

        }
    }
}



//实现接口方式
class SellTicket02 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));//1 - 0 - -1  - -2

        }
    }
}
```

## 线程终止

### 基本说明

1. 当线程完成任务后，会自动退出。
2. 还可以通过使用变量来控制run方法退出的方式停止线程，即通知方式。

### 应用案例

需求:启动一个线程t，要求在main线程中去停止线程t,请编程实现。

```java
package com.hspedu.exit_;

public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();

        // 如果希望 main 线程去控制 t1 线程的终止, 必须可以修改 loop
        // 让 t1 退出 run 方法，从而终止 t1 线程 -> 通知方式
        // 让主线程休眠 10 秒，再通知 t1 线程退出
        System.out.println("main线程休眠10s...");
        Thread.sleep(10 * 1000);
        t1.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    // 设置一个控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {

            try {
                Thread.sleep(50);// 让当前线程休眠50ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中...." + (++count));
        }
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
```

## 线程常用方法

### 常用方法第一组

1. setName A //设置线程名称，使之与参数name相同

2. getName //返回该线程的名称

3. startM //使该线程开始执行;Java虚拟机底层调用该线程的start0方
4. run //调用线程对象 run方法;
5. setPriority //更改线程的优先级
6. getPriority //获取线程的优先级
7. sleep //在指定的毫秒数内让当前正在执行的线程休眠(暂停执行)
8. interrupt //中断线程

### 注意事项和细节

1. start底层会创建新的线程，调用run, run 就是一个简单的方法调用，不会启动新线程。
2. 线程优先级的范围。

3. interrupt，中断线程，但并没有真正的结束线程。所以一般用于中断正在休眠线程。
3. sleep:线程的静态方法，使当前线程休眠。

```java
package com.hspedu.method;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        //测试相关的方法
        T t = new T();
        t.setName("timerring");
        t.setPriority(Thread.MIN_PRIORITY);//1
        t.start();//启动子线程


        //主线程打印5 hi ,然后我就中断 子线程的休眠
        for(int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        System.out.println(t.getName() + " 线程的优先级 =" + t.getPriority());//1
        t.interrupt();//当执行到这里，就会中断 t线程的休眠.
    }
}

class T extends Thread { // 自定义的线程类
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                // Thread.currentThread().getName() 获取当前线程的名称
                System.out.println(Thread.currentThread().getName() + "  吃包子~~~~" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
                Thread.sleep(20000);//20秒
            } catch (InterruptedException e) {
                // 当该线程执行到一个interrupt 方法时，就会catch 一个 异常, 可以加入自己的业务代码
                // InterruptedException 是捕获到一个中断异常.
                System.out.println(Thread.currentThread().getName() + "被 interrupt了");
            }
        }
    }
}
```

### 常用方法第二组

1. yield：线程的礼让。让出cpu,让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功
2. join：线程的插队。插队的线程一旦插队成功，则肯定先执行完插入的线程所有的任务。

案例:main线程创建一个子线程，每隔1s输出hello,输出20次,主线程每隔1秒, 输出hi，输出20次。要求:两个线程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程再继续。

```java
package com.hspedu.method;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {

        T2 t2 = new T2();
        t2.start();

        for(int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程(小弟) 吃了 " + i  + " 包子");
            if(i == 5) {
                System.out.println("主线程(小弟) 让 子线程(老大) 先吃");
                //join, 线程插队
                //t2.join();// 这里相当于让t2 线程先执行完毕
                Thread.yield();//礼让，不一定成功.
                System.out.println("线程(老大) 吃完了 主线程(小弟) 接着吃..");
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);//休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程(老大) 吃了 " + i +  " 包子");
        }
    }
}
```

### 课堂练习

1. 主线程每隔1s，输出hi,一共10次
2. 当输出到hi5时，启动一个子线程(要求实现Runnable)，每隔1s输出hello,等该线程输出10次 hello后，退出
3. 主线程继续输出hi，直到主线程退出.
4. 如图,完成代码其实线程插队

```java
package com.hspedu.method;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Thread t3 = new Thread(new T3());//创建子线程
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi " + i);
            if(i == 5) {//说明主线程输出了5次 hi
                t3.start();//启动子线程 输出 hello...
                t3.join();//立即将t3子线程，插入到main线程，让t3先执行
            }
            Thread.sleep(1000);//输出一次 hi, 让main线程也休眠1s
        }
    }
}

class T3 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}
```

### 用户线程和守护线程

1. 用户线程: 也叫工作线程，当线程的任务执行完或通知方式结束。
2. 守护线程: 一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束。
3. **常见的守护线程: 垃圾回收机制**。

### 应用案例

下面我们测试如何将一个线程设置成守护线程。

只需要将 `myDaemonThread.setDaemon(true);` 设置为 `true` 即可。

```java
package com.hspedu.method;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果我们希望当main线程结束后，子线程自动结束，只需将子线程设为守护线程即可
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();

        for( int i = 1; i <= 10; i++) {//main线程
            System.out.println("工作...");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread {
    public void run() {
        for (; ; ) {//无限循环
            try {
                Thread.sleep(1000);//休眠1000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("聊天");
        }
    }
}
```

## 线程的生命周期

### 线程的几种状态

JDK 中用Thread.State 枚举表示了线程的几种状态

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502152148079.png)

### 线程状态转换图!!!!

有些书中说一共有7个状态，实际上就是将Runnable状态中Ready和Running分开了。到底是否运行还是取决于内核态的调度情况。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502152329060.png)

```java
package com.hspedu.state_;

public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + " 状态 " + t.getState());
        t.start();

        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + " 状态 " + t.getState());
            Thread.sleep(500);
        }

        System.out.println(t.getName() + " 状态 " + t.getState());

    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
```

## Synchronized

### 线程同步机制

1. 在多线程编程，一些敏感数据不允许被多个线程同时访问，此时就使用同步访问技术，保证数据在任何同一时刻，最多有一个线程访问，以保证数据的完整性。
2. 也可以这里理解：**线程同步，即当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作，直到该线程完成操作，其他线程才能对该内存地址进行操作。**

### 同步具体方法-Synchronized

#### 方法一同步代码块

```java
synchronized (对象){ // 得到对象的锁，才能操作同步代码
	// 需要被同步代码;
}
```

#### 方法二方法声明

synchronized 还可以放在方法声明中，表示整个方法-为同步方法

```java
public synchronized void m (String name){
	//需要被同步的代码
}
```

## 分析同步原理

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502160544405.png)

## 互斥锁

### 基本介绍

1. Java语言中，引入了对象互斥锁的概念，来保证共享数据操作的完整性。
2. **每个对象都对应于一个可称为“互斥锁”的标记，这个标记用来保证在任一时刻，只能有一个线程访问该对象。**
3. 关键字synchronized来与对象的互斥锁联系。当某个对象用synchronized修饰时,表明该对象在任一时刻只能由一个线程访问。
4. 同步的局限性:导致程序的执行效率要降低。
5. 同步方法**(非静态的)的锁可以是this,也可以是其他对象(要求是同一个对象)。**
6. **同步方法(静态的)的锁为当前类本身**。即类.class

```java
package com.hspedu.syn;

/**
 * 使用多线程，模拟三个窗口同时售票100张
 */
public class SellTicket {
    public static void main(String[] args) {

        //测试
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        //这里我们会出现超卖..
//        sellTicket01.start();//启动售票线程
//        sellTicket02.start();//启动售票线程
//        sellTicket03.start();//启动售票线程


//        System.out.println("===使用实现接口方式来售票=====");
//        SellTicket02 sellTicket02 = new SellTicket02();
//
//        new Thread(sellTicket02).start();//第1个线程-窗口
//        new Thread(sellTicket02).start();//第2个线程-窗口
//        new Thread(sellTicket02).start();//第3个线程-窗口

        //测试一把
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//第1个线程-窗口
        new Thread(sellTicket03).start();//第2个线程-窗口
        new Thread(sellTicket03).start();//第3个线程-窗口

    }
}


//实现接口方式, 使用synchronized实现线程同步
class SellTicket03 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum
    private boolean loop = true;//控制run方法变量
    Object object = new Object();


    //同步方法（静态的）的锁为当前类本身
    //1. public synchronized static void m1() {} 锁是加在 SellTicket03.class 上
    //2. 如果在静态方法中，实现一个同步代码块.
    /*
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
     */
    public synchronized static void m1() {

    }
    public static  void m2() {
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    }

    //1. public synchronized void sell() {} 就是一个同步方法
    //2. 这时锁在 this对象
    //3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在this对象
    public /*synchronized*/ void sell() { //同步方法, 在同一时刻， 只能有一个线程来执行sell方法

        synchronized (/*this*/ object) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));//1 - 0 - -1  - -2
        }
    }

    @Override
    public void run() {
        while (loop) {

            sell();//sell方法是一共同步方法
        }
    }
}

//使用Thread方式
// new SellTicket01().start()
// new SellTicket01().start(); 对象不是同一个，锁不住m1()

class SellTicket01 extends Thread {

    private static int ticketNum = 100;//让多个线程共享 ticketNum

    // 以下写法没用，因为每次对象都不是同一个，锁不住
//    public void m1() {
//        synchronized (this) {
//            System.out.println("hello");
//        }
//    }

    @Override
    public void run() {


        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));

        }
    }
}


//实现接口方式
class SellTicket02 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));//1 - 0 - -1  - -2

        }
    }
}

```

### 注意事项和细节

1. 同步方法如果没有使用static修饰:默认锁对象为this
2. 如果方法使用static修饰，默认锁对象:当前类.class
3. 实现的落地步骤:
   + 需要先分析上锁的代码
   + 选择**同步代码块**或同步方法（同步的范围越小，当然效率也就越高）
   + 要求多个线程的锁对象为同一个即可!

## 线程的死锁

### 基本介绍

多个线程都占用了对方的锁资源，但不肯相让，导致了死锁,在编程是一定要避免死锁的发生。

### 应用案例

```java
package com.hspedu.syn;

/**
 * 模拟线程死锁
 */
public class DeadLock_ {
    public static void main(String[] args) {
        //模拟死锁现象
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A线程");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B线程");
        A.start();
        B.start();
    }
}


//线程
class DeadLockDemo extends Thread {
    static Object o1 = new Object();// 保证多线程，共享一个对象,这里使用static
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {//构造器
        this.flag = flag;
    }

    @Override
    public void run() {

        //下面业务逻辑的分析
        //1. 如果flag 为 T, 线程A 就会先得到/持有 o1 对象锁, 然后尝试去获取 o2 对象锁
        //2. 如果线程A 得不到 o2 对象锁，就会Blocked
        //3. 如果flag 为 F, 线程B 就会先得到/持有 o2 对象锁, 然后尝试去获取 o1 对象锁
        //4. 如果线程B 得不到 o1 对象锁，就会Blocked
        if (flag) {
            synchronized (o1) { //对象互斥锁, 下面就是同步代码
                System.out.println(Thread.currentThread().getName() + " 进入1");
                synchronized (o2) { // 这里获得li对象的监视权
                    System.out.println(Thread.currentThread().getName() + " 进入2");
                }
                
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入3");
                synchronized (o1) { // 这里获得li对象的监视权
                    System.out.println(Thread.currentThread().getName() + " 进入4");
                }
            }
        }
    }
}
```

## 释放锁

### 下面操作会释放锁

1. 当前线程的同步方法、同步代码块执行结束。
2. 当前线程在同步代码块、同步方法中遇到break、return。
3. 当前线程在同步代码块、同步方法中出现了未处理的Error或Exception,导致异常结束。
4. 当前线程在同步代码块、同步方法中执行了线程对象的wait()方法，当前线程暂停，并释放锁。

### 下面操作不会释放锁

1. 线程执行同步代码块或同步方法时，程序调用Thread.sleep()、Thread.yield()方法暂停当前线程的执行,不会释放锁
2. 线程执行同步代码块时，其他线程调用了该线程的suspend()方法将该线程挂起，该线程不会释放锁。提示:应尽量避免使用suspend()和resume()来控制线程，方法不再推荐使用

## 本章作业

1. 编程题

   (1)在main方法中启动两个线程

   (2)第1个线程循环随机打印100以内的整数

   (3)直到第2个线程从键盘读取了“Q”命令。

   ```java
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
   ```

2. 编程题

   (1)有2个用户分别从同一个卡上取钱(总额:10000)

   (2)每次都取1000,当余额不足时,就不能取款了

   (3)不能出现超取现象=》线程同步问题.

   ![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230502164815915.png)

   ```java
   package com.hspedu.homework;
   
   public class Homework02 {
       public static void main(String[] args) {
           T t = new T();
           Thread thread1 = new Thread(t);
           thread1.setName("t1");
           Thread thread2 = new Thread(t);
           thread2.setName("t2");
           thread1.start();
           thread2.start();
       }
   }
   
   //1.因为这里涉及到多个线程共享资源，所以我们使用实现Runnable方式
   //2. 每次取出 1000
   class T implements  Runnable {
       private int money = 10000;
   
       @Override
       public void run() {
           while (true) {
   
               //解读
               //1. 这里使用 synchronized 实现了线程同步
               //2. 当多个线程执行到这里时，就会去争夺 this对象锁
               //3. 哪个线程争夺到(获取)this对象锁，就执行 synchronized 代码块, 执行完后，会释放this对象锁
               //4. 争夺不到this对象锁，就blocked ，准备继续争夺
               //5. this对象锁是非公平锁.
   
               synchronized (this) {//
                   //判断余额是否够
                   if (money < 1000) {
                       System.out.println("余额不足");
                       break;
                   }
   
                   money -= 1000;
                   System.out.println(Thread.currentThread().getName() + " 取出了1000 当前余额=" + money);
               }
   
               //休眠1s
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   }
   ```