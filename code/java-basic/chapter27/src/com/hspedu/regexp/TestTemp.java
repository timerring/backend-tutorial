package com.hspedu.regexp;


import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class TestTemp {
    private static int X = 6; // 棋盘有多少列
    private static int Y = 6; // 棋盘有多少行
    private static int[][] chessBorad = new int[Y][X];
    private static boolean[] visited = new boolean[Y * X]; //记录该点是否访问过
    private static boolean finish = false; // 标识是否遍历结束

    public static void main(String[] args) {
        // 测试 2, 2 容易看到问题
        int row = 2; // 马儿初始位置行
        int col = 2; // 马儿初始位置列
        long start = System.currentTimeMillis();
        traversalChessBoard(chessBorad, row - 1, col - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("耗时=" + (end - start));
        // 输出
        for (int[] rows : chessBorad) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    public static void traversalChessBoard(int[][] chessBoard, int row, int col, int step) {

        // 先把当前位置设为为step
        chessBoard[row][col] = step;
        // 当前这个位置，顺序来编号
        visited[row * X + col] = true;

        // 获取当前点的所有下一个可以走的位置的点的集合,小心位置
        ArrayList<Point> ps = next(new Point(col, row));
        //sort(ps);//贪心算法进行优化
        // 可以取出ps的各个点，进行递归的访问
        while (!ps.isEmpty()) {
            // 顺序取出
            Point p = ps.remove(0);

            // 判断该点是否可以访问
            if (!visited[p.y * X + p.x]) {
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }
        }

        // 退出while，看看是否成功了(是否遍历完了),如果没有完成，就对相应的值重置，准备回溯
        if (step < X * Y && !finish) {
            // 将当前位置置0
            chessBoard[row][col] = 0;
            // 重新设置为 false
            visited[row * X + col] = false;
        } else {
            finish = true;
        }
    }

    public static void sort(ArrayList<Point> ps) { //进行递增排序
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                // 先写出原生态的, 再优化
				/*
				//获取到o1的下一步的所有位置个数
				int count1 = next(o1).size();
				//获取到o2的下一步的所有位置个数
				int count2 = next(o2).size();
				if(count1 < count2) {
					return -1;
				} else if (count1 == count2) {
					return 0;
				} else {
					return 1;
				}*/
                return next(o1).size() - next(o2).size();
            }
        });
    }

    //根据当前位置(Point) 来得到，下一步马儿可以走的位置Point,并存放到集合ArrayList<Point>
    public static ArrayList<Point> next(Point curPoint) {

        // 1.创建一个新的集合
        ArrayList<Point> ps = new ArrayList<Point>();

        // 2.创建新的Point
        Point p1 = new Point();
        // 判断是否可以走5这个位置,如果可以就创建一个新的point 对象，并放入到ArrayList
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }

        // 判断是否可以走6这个位置,如果可以就创建一个新的point 对象，并放入到ArrayList
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }

        // 判断是否可以走7这个位置,如果可以就创建一个新的point 对象，并放入到ArrayList
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }

        // 判断是否可以走0这个位置,如果可以就创建一个新的point 对象，并放入到ArrayList

        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }

        // 判断是否可以走1这个位置,如果可以就创建一个新的point 对象，并放入到ArrayList
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }

        // 判断是否可以走2这个位置,如果可以就创建一个新的point 对象，并放入到ArrayList
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }

        // 判断是否可以走3这个位置,如果可以就创建一个新的point 对象，并放入到ArrayList
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        // 判断是否可以走4这个位置,如果可以就创建一个新的point 对象，并放入到ArrayList
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }

        return ps;
    }
}

