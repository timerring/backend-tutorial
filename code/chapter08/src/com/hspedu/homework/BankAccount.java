package com.hspedu.homework;

public class BankAccount {//父类
    private double balance ;//余额
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    //存款
    public void deposit(double amount)  {
        balance += amount;
    }
    //取款
    public void withdraw(double amount)  {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
