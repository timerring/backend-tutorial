package com.hspedu.extend_.exercise;

//编写Computer类，包含CPU、内存、硬盘等属性，getDetails方法用于返回Computer的详细信息
public class Computer {
    private String cpu;
    private int memory;
    private int disk;
    public Computer(String cpu, int memory, int disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }
    //返回Computer信息
    public String getDetails() {
        return "cpu=" + cpu + " memory=" + memory + " disk=" + disk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }
}
