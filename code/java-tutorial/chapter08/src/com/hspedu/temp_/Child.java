package com.hspedu.temp_;

public class Child {
    private String name;

    public Child(String name) {
        this.name = name;
    }
    public void join() {
        System.out.println(name + " 加入了游戏 ");
    }

    public static void main(String[] args) {
        int totalNum = 0;
        Child child1 = new Child("白骨精");
        child1.join();
        totalNum++;

        Child child2 = new Child("狐狸精");
        child2.join();
        totalNum++;

        Child child3 = new Child("犀牛精");
        child3.join();
        totalNum++;

        System.out.println("共" + totalNum + "加入了游戏..");
    }
}
