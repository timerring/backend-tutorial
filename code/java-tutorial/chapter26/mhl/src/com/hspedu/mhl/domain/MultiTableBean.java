package com.hspedu.mhl.domain;

import java.util.Date;

/**
 * 这是一个javabean 可以和多张表进行对应
 */
public class MultiTableBean {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer diningTableId;
    private Date billDate;
    private String state;
    //增加一个来自menu表的列 name
    //思考 这里的属性名是否一定要和表的列名保持一致.
    //答: 可以不一致，但是需要sql做相应的修改, 规范需要保持一致（例如 SELECT Name AS name2  他会调用对应的setName2构造方法）.
    private String name;
    //增加来自menu表的列 price
    private Double price;//默认值 nulll

    // 实际上是调用无参构造器，进行反射调用，然后通过setter和getter方法进行调用的：
    public MultiTableBean() {
        System.out.println("反射调用....");
    }

//    public MultiTableBean(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer diningTableId, Date billDate, String state, String name, Double price) {
//        this.id = id;
//        this.billId = billId;
//        this.menuId = menuId;
//        this.nums = nums;
//        this.money = money;
//        this.diningTableId = diningTableId;
//        this.billDate = billDate;
//        this.state = state;
//        this.name = name;
//        this.price = price;
//    }

    //给price生成setter 和 getter

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    //给name生成setter 和 getter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + menuId +
                "\t\t\t" + nums +
                "\t\t\t" + money +
                "\t" + diningTableId +
                "\t\t" + billDate +
                "\t\t" + state +
                "\t\t" + name +
                "\t\t" + price;
    }
}
