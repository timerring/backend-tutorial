- [第28章 骑士周游问题](#第28章-骑士周游问题)
  - [算法优化意义](#算法优化意义)
  - [经典算法面试题-骑士周游问题](#经典算法面试题-骑士周游问题)
    - [马踏棋盘算法介绍](#马踏棋盘算法介绍)
  - [骑士周游问题的解决步骤和思路分析](#骑士周游问题的解决步骤和思路分析)


# 第28章 骑士周游问题

## 算法优化意义

1. 算法是程序的灵魂，为什么有些程序可以在海量数据计算时，依然保
   持高速计算?

2. 编程中算法很多，比如八大排序算法(冒泡、选择、插入、快排、归并.
   希尔、基数、堆排序)、查找算法、分治算法、动态规划算法、KMP算法、贪心算法、普里姆算法、克鲁斯卡尔算法、迪杰斯特拉算法、弗洛伊德算法。

## 经典算法面试题-骑士周游问题

### 马踏棋盘算法介绍

1. 马踏棋盘算法也被称为骑士周游问题
2. 将马随机放在国际象棋的8×8棋盘`Board[0 ~7][0~7]`的某个方格中，马按走棋规则(马走日字)进行移动。要求每个方格只进入一次，走遍棋盘上全部64个方格。
3. 游戏演示:
   https://u.ali213.net/games/horsesun/index.html?game_code=403
4. 会使用到图的遍历算法(DFS)+贪心算法优化

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230515221734876.png)

1. 马踏棋盘问题(骑士周游问题)实际上是图的深度优先搜索(DFS)的应用。
2. 如果使用回溯(就是深度优先搜索)来解决,假如马儿踏了53个点，如图:走到了第53个,坐标(1,0)，发现已经走到尽头, 没办法，那就只能回退了，查看其他的路径，就在棋盘上不停的回溯.....，思路分析+代码实现。
3. 先用基本方式来解决，然后使用贪心算法(greedyalgorithm)进行优化。解决马踏棋盘问题,体会到不同的算法对程序效率的影响。
4. 使用前面的游戏来验证算法是否正确。

## 骑士周游问题的解决步骤和思路分析

1. 创建棋盘`chessBoard`,是二维数组
2. 将当前位置设置为已经访问,然后根据当前位置，计算马儿还能走哪些位置，并放入到一个集合中(ArrayList), 最多有8个，每走一步，使用step + 1。
3. 遍历ArrayList中存放的所有位置，看看那个可以走，如果可以走通，就继续，走不通，就回溯。
4. 判断马儿是否完成了任务，使用step和应该走的步数比较，如果没有达到数量，则表示没有完成任务，将整个棋盘设置为0。

注意:马儿走的策略不同，则得到的结果也不一样，效率也不一样。

对代码使用**贪心算法**，进行优化，提高速度：

分析

1. 我们现在走的下一个位置，是按照我们的顺时针来挑选位置，因此选择的这个点的下一个可以走的位置的个数是不确定的.
2. 优化思路是:我们应该选择下一个的下一个可以走的位置较少的点，开始走，这样可以减少回溯。
3. 代码:对我们的ps集合按照可以走的下一个位置的次数进行排序，升序排序。

```java
package com.hspedu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
public class HorseChessBoard {

    //定义属性
    private static int X = 6; // 表示col
    private static int Y = 6; // 表示row
    private static int[][] chessBoard = new int[Y][X]; //棋盘
    private static boolean[] visited = new boolean[X * Y];//记录某个位置是否走过
    private static boolean finished = false; //记录马儿是否遍历完棋盘.

    public static void main(String[] args) {

        int row = 2;
        int col = 2;

        //测试一把
        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard, row - 1, col - 1, 1);
        long end = System.currentTimeMillis();

        System.out.println("遍历耗时=" + (end - start));
        //输出当前这个棋盘的情况
        for (int[] rows : chessBoard) {
            for (int step : rows) {//step 表示 该位置是马儿应该走的第几步
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    //写一个方法，对ps的各个位置，可以走的下一个位置的次数进行排序, 把可能走的下一个位置从小到大排序
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }

    //编写最核心的算法，遍历棋盘，如果遍历成功，就把 finished 设置为true ,
    //并且，将马儿走的每一步step，记录到 chessBoard
    public static void traversalChessBoard(int[][] chessBoard, int row, int col, int step) {

        //先把step 记录到 chessBoard
        chessBoard[row][col] = step;
        //把这个位置，设置为已经访问
        visited[row * X + col] = true;
        //获取当前这个位置可以走的下一个位置有哪些
        ArrayList<Point> ps = next(new Point(col, row)); // 注意这里的处理： col - X , row - Y
        sort(ps);// 排序：我们应该选择下一个的下一个可以走的位置较少的点，开始走，这样可以减少回溯
        //遍历
        while (!ps.isEmpty()) {
            //取出当前这个 ps 第一个位置(点)
            Point p = ps.remove(0);
            //判断该位置是否走过，如果没有走过，我们就递归遍历
            if (!visited[p.y * X + p.x]) {
                //递归遍历
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }
        }

        //当退出while，看看是否遍历成功, 如果没有成功，就重置相应的值，然后进行回溯
        if (step < X * Y && !finished) {
            //重置
            chessBoard[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }

    }

    //编写方法，可以获取当前位置，可以走的下一步的所有位置(Point表示 x,y)
    public static ArrayList<Point> next(Point curPoint) {

        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<>();

        //创建一个Point对象(点/位置), 准备放入到 ps
        Point p1 = new Point();

        //判断在 curPoint 是否可以走如下位置，如果可以走，就将该点(Point) 放入到ps

        //判断是否可以走5位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走6位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走7位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走0位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走1位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走2位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走3位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        //判断是否可以走4位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1)); //这里一定要new Point
        }
        return ps;
    }
}
```