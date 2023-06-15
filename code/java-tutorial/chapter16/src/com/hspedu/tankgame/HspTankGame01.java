package com.hspedu.tankgame;

import javax.swing.*;

public class HspTankGame01 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {

        HspTankGame01 hspTankGame01 = new HspTankGame01();
    }

    public HspTankGame01() {
        mp = new MyPanel();
        this.add(mp);//把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
