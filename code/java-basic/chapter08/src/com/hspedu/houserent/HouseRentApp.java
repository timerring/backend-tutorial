package com.hspedu.houserent;

import com.hspedu.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {

        byte b1 = 123;
        b1 += 100000; //如果 b1 = b1 + 100000;//编译都不能过
        System.out.println(b1);

        byte b2 = 123;
        b2 = (byte)(b2 + 100000);
        System.out.println(b2);

        //创建HouseView对象,并且显示主菜单，是整个程序的入口
        new HouseView().mainMenu();
        System.out.println("===你退出房屋出租系统==");
    }
}
