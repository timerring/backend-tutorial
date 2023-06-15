package com.hspedu.javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author 韩顺平
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class JavaMysql {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //这里老韩给大家演示一下 java 程序如何操作Mysql

        //加载类，得到mysql连接
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hsp_db02", "root", "hsp");

        //创建一个商品hsp_goods表, 选用适当的数据类型
        //添加2条数据
        //删除表goods

        //这里可以编写sql 【create , select , insert , update ,delete ...】
        //String sql = "create table hsp_goods ( id int, name varchar(32), price double, introduce text)" ;
        //String sql = "insert into hsp_goods values(1, '华为手机', 2000, '这是不错的一款手机')" ;
        String sql = "drop table hsp_goods" ;

        //得到statement对象，把sql 语法发送给mysql执行
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        //关闭连接
        statement.close();
        connection.close();
        System.out.println("成功~");

    }
}
