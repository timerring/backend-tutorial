package com.hspedu.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        /**
         *(1) 在判断 e 盘下是否有文件夹mytemp ,如果没有就创建mytemp
         *(2) 在e:\\mytemp 目录下, 创建文件 hello.txt
         *(3) 如果hello.txt 已经存在，提示该文件已经存在，就不要再重复创建了
         *(4) 并且在hello.txt 文件中，写入 hello,world~
         */

        String directoryPath = "e:\\mytemp";
        File file = new File(directoryPath);
        if(!file.exists()) {
            //创建
            if(file.mkdirs()) {
                System.out.println("创建 " + directoryPath + " 创建成功" );
            }else {
                System.out.println("创建 " + directoryPath + " 创建失败");
            }
        }

        String filePath  = directoryPath + "\\hello.txt";// e:\mytemp\hello.txt
        file = new File(filePath);
        if(!file.exists()) {
            //创建文件
            if(file.createNewFile()) {
                System.out.println(filePath + " 创建成功~");

                //如果文件存在，我们就使用BufferedWriter 字符输入流写入内容
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("hello, world~~ 教育");
                bufferedWriter.close();

            } else {
                System.out.println(filePath + " 创建失败~");
            }
        } else {
            //如果文件已经存在，给出提示信息
            System.out.println(filePath + " 已经存在，不在重复创建...");
        }
    }
}
