package com.hspedu.tankgame2;

import javax.swing.*;
import java.awt.event.KeyListener;

public class HspTankGame02 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {

        HspTankGame02 hspTankGame01 = new HspTankGame02();
    }

    public HspTankGame02() {
        mp = new MyPanel();
        this.add(mp);//把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);
        // 一个接口的引用可以指向实现该接口的对象(mp实现了该接口) this.addKeyListener(KeyListener I);
        this.addKeyListener(mp); //让JFrame 监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
