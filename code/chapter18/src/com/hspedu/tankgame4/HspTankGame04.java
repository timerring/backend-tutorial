package com.hspedu.tankgame4;

import javax.swing.*;

public class HspTankGame04 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {

        HspTankGame04 hspTankGame01 = new HspTankGame04();
    }

    public HspTankGame04() {
        mp = new MyPanel();
        //将mp 放入到Thread ,并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);//把面板(就是游戏的绘图区域)

        this.setSize(1200, 950);
        this.addKeyListener(mp);//让JFrame 监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
