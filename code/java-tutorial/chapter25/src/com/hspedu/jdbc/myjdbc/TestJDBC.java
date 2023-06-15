package com.hspedu.jdbc.myjdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
public class TestJDBC {
    public static void main(String[] args) throws Exception {
        //完成对mysql的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        jdbcInterface.getConnection(); //通过接口来调用实现类[动态绑定]
        jdbcInterface.crud();
        jdbcInterface.close();


        //完成对oracle的操作
        System.out.println("==============================");
        jdbcInterface = new OracleJdbcImpl();
        jdbcInterface.getConnection(); //通过接口来调用实现类[动态绑定]
        jdbcInterface.crud();
        jdbcInterface.close();

    }

}
