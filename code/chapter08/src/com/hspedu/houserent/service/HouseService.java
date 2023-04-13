package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;

/**
 * HouseService.java<=>类 [业务层]
 * //定义House[] ,保存House对象
 * 1. 响应HouseView的调用
 * 2. 完成对房屋信息的各种操作(增删改查c[create]r[read]u[update]d[delete])
 */
public class HouseService {

    private House[] houses; //保存House对象
    private int houseNums = 1; //记录当前有多少个房屋信息
    private int idCounter = 1; //记录当前的id增长到哪个值
    //构造器
    public HouseService(int size) {
        //new houses
        houses = new House[size];//当创建HouseService对象，指定数组大小
        //为了配合测试列表信息，老韩这里初始化一个House对象
        houses[0] = new House(1,"jack","112", "海淀区", 2000, "未出租");
    }

    //findById方法,返回House对象或者null
    public House findById(int findId) {

        //遍历数组
        for(int i = 0; i < houseNums; i++) {
            if(findId == houses[i].getId()) {
                return houses[i];
            }
        }

        return null;

    }

    //del方法，删除一个房屋信息
    public boolean del(int delId) {

        //应当先找到要删除的房屋信息对应的下标
        //老韩强调，一定要搞清楚 下标和房屋的编号不是一回事
        int index = -1;
        for(int i = 0; i < houseNums; i++) {
            if(delId == houses[i].getId()) {//要删除的房屋(id),是数组下标为i的元素
                index = i;//就使用index记录i
            }
        }

        if(index == -1) {//说明delId在数组中不存在(有点绕..)
            return false;
        }
        //如果找到, 这里需要小伙伴动脑筋,有点难.
        //老师思路分析:
        for(int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];
        }
        //把当有存在的房屋信息的最后一个 设置null
        houses[--houseNums] = null;
        return true;

    }

    //add方法，添加新对象,返回boolean
    public boolean add(House newHouse) {
        //判断是否还可以继续添加(我们暂时不考虑数组扩容的问题) => 能否自己加入数组扩容机制(~~)
        if(houseNums == houses.length) {//不能再添加
            System.out.println("数组已满，不能再添加了...");
            return false;
        }
        //把newHouse对象加入到，新增加了一个房屋
        houses[houseNums++] = newHouse;
        //我们程序员需要设计一个id自增长的机制, 然后更新newHouse的id
        newHouse.setId(++idCounter);
        return true;
    }

    //list方法，返回houses
    public House[] list() {
        return houses;
    }
}
