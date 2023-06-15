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

