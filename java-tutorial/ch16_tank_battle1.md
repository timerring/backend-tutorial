- [第16章 坦克大战1](#第16章-坦克大战1)
  - [java 绘图坐标体系](#java-绘图坐标体系)
    - [坐标体系-介绍](#坐标体系-介绍)
    - [坐标体系-像素](#坐标体系-像素)
    - [介绍-快速入门](#介绍-快速入门)
    - [绘图原理](#绘图原理)
    - [Graphics 类](#graphics-类)
    - [绘出坦克](#绘出坦克)
  - [java 事件处理机制](#java-事件处理机制)
    - [基本说明](#基本说明)
    - [示意图](#示意图)
    - [事件处理机制深入理解](#事件处理机制深入理解)
    - [坦克动起来](#坦克动起来)
    - [本章作业](#本章作业)


# 第16章 坦克大战1

## java 绘图坐标体系

### 坐标体系-介绍

下图说明了Java坐标系。坐标原点位于左上角，以像素为单位。在Java坐标系中,第一个是x坐标,表示当前位置为水平方向，距离坐标原点x个像素;第二个是y坐标，表示当前位置为垂直方向，距离坐标原点y个像素。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230501200800076.png)

### 坐标体系-像素

绘图还必须要搞清一个非常重要的概念-像素一个像素等于多少厘米?

计算机在屏幕上显示的内容都是由屏幕上的每一个像素组成的。例如，计算机显示器的分辨率是800×600，表示计算机屏幕上的每一行由800个点组成，共有600行,整个计算机屏幕共有480 000个像素。**像素是一个密度单位,而厘米是长度单位,两者无法比较**。

### 介绍-快速入门

### 绘图原理



在面板上画一个小圆。

Component类提供了两个和绘图相关最重要的方法:1. paint(Graphics g)绘制组件的外观

repaint()刷新组件的外观。

当组件第一次在屏幕显示的时候,程序会自动的调用paint()方法来绘制组件。在以下情况paint(将会被调用:

1.窗口最小化.再最大化

2.窗口的大小发生变化

3.repaint方法被调用

### Graphics 类

Graphics类你可以理解就是画笔,为我们提供了各种绘制图形的方法:[参考jdk帮助文档]

1.画直线 `drawLine(int x1,int y1,int x2,int y2)`

2.画矩形边框 `drawRect(int x, int y, int width, int height)`

3.画椭圆边框 `drawOval(int x, int y, int width, int height)`

4.填充矩形 `fillRect(int x, int y, int width, int height)`

5.填充椭圆 `fillOval(int x, int y, int width, int height)`

6.画图片 `drawlmage(Image img, int x, int y. ..)`

7.画字符串 `drawString(String str, int x, int y)` 这里是以左下角为参考系的。

8.设置画笔的字体 `setFont(Font font)`

9.设置画笔的颜色 `setColor(Color c)`

```java
package com.hspedu.draw;

import javax.swing.*;
import java.awt.*;
@SuppressWarnings({"all"})
public class DrawCircle extends JFrame { //JFrame对应窗口,可以理解成是一个画框

    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
        System.out.println("退出程序~");
    }

    public DrawCircle() {//构造器
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口(画框)
        this.add(mp);
        //设置窗口的大小
        this.setSize(400, 300);
        //当点击窗口的小×，程序完全退出.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示
    }
}

//1.先定义一个MyPanel, 继承JPanel类， 画图形，就在面板上画
class MyPanel extends JPanel {


    //说明:
    //1. MyPanel 对象就是一个画板
    //2. Graphics g 把 g 理解成一支画笔
    //3. Graphics 提供了很多绘图的方法
    //Graphics g
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g); //调用父类的方法完成初始化.
        System.out.println("paint 方法被调用了~");
        //画出一个圆形.
        //g.drawOval(10, 10, 100, 100);


        //演示绘制不同的图形..
        //画直线 drawLine(int x1,int y1,int x2,int y2)
        //g.drawLine(10, 10, 100, 100);
        //画矩形边框 drawRect(int x, int y, int width, int height)
        //g.drawRect(10, 10, 100, 100);
        //画椭圆边框 drawOval(int x, int y, int width, int height)
        //填充矩形 fillRect(int x, int y, int width, int height)
        //设置画笔的颜色
//        g.setColor(Color.blue);
//        g.fillRect(10, 10, 100, 100);

        //填充椭圆 fillOval(int x, int y, int width, int height)
//        g.setColor(Color.red);
//        g.fillOval(10, 10, 100, 100);

        //画图片 drawImage(Image img, int x, int y, ..)
        //1. 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
//        g.drawImage(image, 10, 10, 175, 221, this);
        //画字符串 drawString(String str, int x, int y)//写字
        //给画笔设置颜色和字体
        g.setColor(Color.red);
        g.setFont(new Font("隶书", Font.BOLD, 50));
        //这里设置的 100， 100， 是 "北京你好"左下角
        g.drawString("北京你好", 100, 100);
        //设置画笔的字体 setFont(Font font)
        //设置画笔的颜色 setColor(Color c)
    }
}
```

### 绘出坦克

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230501203305072.png)

## java 事件处理机制

### 基本说明

java事件处理是采取"委派事件模型"。当事件发生时,产生事件的对象,会把此"信息”传递给"事件的监听者"处理，这里所说的“信息"实际上就是java.awt.event事件类库里某个类所创建的对象，把它称为"事件的对象"。

### 示意图

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230501215544141.png)

### 事件处理机制深入理解

1. 前面我们提到几个重要的概念事件源，事件，事件监听器我们下面来全面的介绍它们.
2. 事件源:事件源是一个产生事件的对象，比如按钮，窗口等。
3. 事件:事件就是承载事件源状态改变时的对象，比如当键盘事件、鼠标事件、窗口事件等等，会生成一个事件对象，该对象保存着当前事件很多信息，比如KeyEvent对象有含有被按下键的Code值。 java.awt.event包和javax.swing.event包中定义了各种事件类型

4. 事件类型:查阅jdk文档

   ![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230501222649694.png)

5. 事件监听器接口:
   (1)当事件源产生一个事件,可以传送给事件监听者处理
   (2)事件监听者实际上就是一个类,该类实现了某个事件监听器接口比如前面我们案例中的MyPanle就是一个类,它实现了KeyListener接口，它就可以作为一个事件监听者，对接受到的事件进行处理。
   (3)事件监听器接口有多种，不同的事件监听器接口可以监听不同的事件,一个类可以实现多个监听接口
   (4)这些接口在java.awt.event包和javax.swing.event包中定义。列出常用的事件监听器接口,查看jdk文档。

### 坦克动起来

现在我们学习java事件处理机制和java绘图技术,请试试看如何让你的坦克可以通过按键控制上右下左(wdsa表示)的移动。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230501223622230.png)

```java
package com.hspedu.tankgame2;

/**
 * 敌人的坦克
 */
public class EnemyTank extends Tank {
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
```

```java
package com.hspedu.tankgame2;

public class Hero extends Tank {
    public Hero(int x, int y) {
        super(x, y);
    }
}
```

```java
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
```

```java
package com.hspedu.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 坦克大战的绘图区域
 */

//为了监听 键盘事件， 实现KeyListener
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己坦克
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //设置方向
            enemyTank.setDirect(2);
            //加入
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色

        //画出自己坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        //画出敌人的坦克, 遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
        }


    }

    //编写方法，画出坦克

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0: //敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //我的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制对应形状坦克
        //direct 表示方向(0: 向上 1 向右 2 向下 3 向左 )
        //
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wdsa 键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_W) {//按下W键
            //改变坦克的方向
            hero.setDirect(0);//
            //修改坦克的坐标 y -= 1
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//D键, 向右
            hero.setDirect(1);
            hero.moveRight();

        } else if (e.getKeyCode() == KeyEvent.VK_S) {//S键
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//A键
            hero.setDirect(3);
            hero.moveLeft();
        }
        //让面板重绘，如果不重绘的话，则不会有改变
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
```

```java
package com.hspedu.tankgame2;

public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct = 0;//坦克方向 0 上1 右 2下 3左
    private int speed = 1;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //上右下左移动方法
    public void moveUp() {
        y -= speed;
    }
    public void moveRight() {
        x += speed;
    }
    public void moveDown() {
        y += speed;
    }
    public void moveLeft() {
        x -= speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
```

### 本章作业

画出三辆敌人的坦克,注意颜色。如图所示分析:

1. 因为敌人的坦克，是在MyPanel上所以我们的代码在MyPanel
2. 因为敌人的坦克，后面有自己特殊的属性和方法，可以单开一个EnemyTank
3. 敌人坦克数量多，可以放入到集合Vector ，因为考虑多线程问题 

代码同上。