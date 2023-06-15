package com.hspedu.properties_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Properties01 {
    public static void main(String[] args) throws IOException {


        //读取mysql.properties 文件，并得到ip, user 和 pwd
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null) { //循环读取
            String[] split = line.split("=");
            //如果我们要求指定的ip值
            if("ip".equals(split[0])) {
                System.out.println(split[0] + "值是: " + split[1]);
            }
        }
        br.close();
    }
}
