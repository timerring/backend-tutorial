package com.hspedu.homework;

public class Homework08 {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(1000);
//        checkingAccount.deposit(10);// 1010 - 1 = 1009
//        checkingAccount.withdraw(9);//1009 - 9 = 1000 -1= 999
//        System.out.println(checkingAccount.getBalance());

        //测试SavingsAccount
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());//1300
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());//1400-1=1399

        //月初，定时器自动调用一下 earnMonthlyInterest
        savingsAccount.earnMonthlyInterest();//统计利息
        System.out.println(savingsAccount.getBalance());//1399 + 13.99 =1412.99
        savingsAccount.withdraw(100);//免手续
        System.out.println(savingsAccount.getBalance());//1412.99 -100 =1312.99
        savingsAccount.withdraw(100);//免手续
        savingsAccount.withdraw(100);//免手续
        System.out.println(savingsAccount.getBalance());//1412.99 -200 =1112.99
        savingsAccount.deposit(100);//扣手续费
        System.out.println(savingsAccount.getBalance());//1112.99 + 100 = 1212.99 - 1 = 1211.99

    }
}

