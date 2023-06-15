package com.hspedu.encap;

/**
 * 创建程序,在其中定义两个类：Account和AccountTest类体会Java的封装性。
 * Account类要求具有属性：姓名（长度为2位3位或4位）、余额(必须>20)、
 * 密码（必须是六位）, 如果不满足，则给出提示信息，并给默认值(程序员自己定)
 * 通过setXxx的方法给Account 的属性赋值。
 * 在AccountTest中测试
 */
public class Account {
    //为了封装，将3个属性设置为private
    private String name;
    private double balance;
    private String pwd;

    //提供两个构造器
    public Account() {
    }

    public Account(String name, double balance, String pwd) {
        this.setName(name);
        this.setBalance(balance);
        this.setPwd(pwd);
    }

    public String getName() {
        return name;
    }

    //姓名（长度为2位3位或4位）
    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("姓名要求（长度为2位3位或4位），默认值 无名");
            this.name = "无名";
        }
    }

    public double getBalance() {
        return balance;
    }

    //余额(必须>20)
    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("余额(必须>20) 默认为0");
        }
    }

    public String getPwd() {
        return pwd;
    }

    //密码（必须是六位）
    public void setPwd(String pwd) {
        if (pwd.length() == 6) {
            this.pwd = pwd;
        } else {
            System.out.println("密码（必须是六位）默认密码为 000000");
            this.pwd = "000000";
        }
    }
    //显示账号信息
    public void showInfo() {
        //可以增加权限的校验
        System.out.println("账号信息 name=" + name + " 余额=" + balance + " 密码" + pwd);
//        if() {
//            System.out.println("账号信息 name=" + name + " 余额=" + balance + " 密码");
//        }else{
//            System.out.println("你无权查看...");
//        }
    }
}
