package com.hspedu.smallchange.oop;

/**
 * 这里我们直接调用SmallChangeSysOOP 对象，显示主菜单即可
 */
public class SmallChangeSysApp {

    public static void main(String[] args) {
        System.out.println("====hello公司====");
        new SmallChangeSysOOP().mainMenu();
    }
}
