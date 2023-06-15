package com.hspedu.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 这是第一个Jdbc 程序，完成简单的操作
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {

        //前置工作： 在项目下创建一个文件夹比如 libs
        // 将 mysql.jar 拷贝到该目录下，点击 add to project ..加入到项目中
        //1. 注册驱动
        Driver driver = new Driver(); //创建driver对象

        //2. 得到连接
        //(1) jdbc:mysql:// 规定好表示协议，通过jdbc的方式连接mysql
        //(2) localhost 主机，可以是ip地址
        //(3) 3306 表示mysql监听的端口
        //(4) hsp_db02 连接到mysql dbms 的哪个数据库
        //(5) mysql的连接本质就是前面学过的socket连接
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将 用户名和密码放入到Properties 对象
        Properties properties = new Properties();
        //说明 user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user", "root");// 用户
        properties.setProperty("password", "hsp"); //密码
        Connection connect = driver.connect(url, properties);

        //3. 执行sql
        //String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '110')";
        //String sql = "update actor set name='周星驰' where id = 1";
        String sql = "delete from actor where id = 1";
        //statement 用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); // 如果是 dml 语句，返回的就是影响行数

        System.out.println(rows > 0 ? "成功" : "失败");

        //4. 关闭连接资源
        statement.close();
        connect.close();
    }
}
