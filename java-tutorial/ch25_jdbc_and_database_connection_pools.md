- [第25章 JDBC 和数据库连接池](#第25章-jdbc-和数据库连接池)
  - [JDBC 概述](#jdbc-概述)
    - [基本介绍](#基本介绍)
    - [模拟JDBC](#模拟jdbc)
    - [JDBC 带来的好处](#jdbc-带来的好处)
  - [JDBC 快速入门](#jdbc-快速入门)
    - [JDBC 程序编写步骤](#jdbc-程序编写步骤)
    - [JDBC 第一个程序](#jdbc-第一个程序)
  - [获取数据库连接5种方式](#获取数据库连接5种方式)
    - [方式1](#方式1)
    - [方式2](#方式2)
    - [方式3](#方式3)
    - [方式4](#方式4)
    - [方式5](#方式5)
  - [ResultSet\[结果集\]](#resultset结果集)
    - [基本介绍](#基本介绍-1)
    - [应用实例](#应用实例)
  - [Statement](#statement)
    - [基本介绍](#基本介绍-2)
  - [PreparedStatement](#preparedstatement)
    - [基本介绍](#基本介绍-3)
    - [预处理好处](#预处理好处)
    - [应用案例](#应用案例)
  - [JDBC 的相关 API 小结](#jdbc-的相关-api-小结)
  - [封装JDBCUtils](#封装jdbcutils)
    - [说明](#说明)
    - [代码实现](#代码实现)
  - [事务](#事务)
    - [基本介绍](#基本介绍-4)
    - [应用实例](#应用实例-1)
  - [批处理](#批处理)
    - [基本介绍](#基本介绍-5)
  - [数据库连接池](#数据库连接池)
    - [5k 次连接数据库问题](#5k-次连接数据库问题)
    - [传统获取Connection 问题分析](#传统获取connection-问题分析)
    - [数据库连接池种类](#数据库连接池种类)
    - [C3P0 应用实例](#c3p0-应用实例)
    - [Druid(德鲁伊)应用实例](#druid德鲁伊应用实例)
    - [将JDBCUtils 工具类改成Druid(德鲁伊)实现](#将jdbcutils-工具类改成druid德鲁伊实现)
  - [Apache—DBUtils](#apachedbutils)
    - [先分析一个问题](#先分析一个问题)
    - [自定义方法解决](#自定义方法解决)
    - [基本介绍](#基本介绍-6)
    - [应用实例](#应用实例-2)
    - [表 和 JavaBean 的类型映射关系](#表-和-javabean-的类型映射关系)
  - [DAO 和增删改查通用方法-BasicDao](#dao-和增删改查通用方法-basicdao)
    - [先分析一个问题](#先分析一个问题-1)
    - [基本说明](#基本说明)
    - [BasicDAO 应用实例](#basicdao-应用实例)


# 第25章 JDBC 和数据库连接池

## JDBC 概述

### 基本介绍

1. JDBC为访问不同的数据库提供了统一的接口，为使用者屏蔽了细节问题。

2. Java程序员使用JDBC,可以连接任何提供了JDBC驱动程序的数据库系统，从而完成对数据库的各种操作。
3. JDBC的基本原理图[重要!]

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512223056882.png)

### 模拟JDBC

```java
package com.hspedu.jdbc.myjdbc;

/**
 * 我们规定的jdbc接口(方法)
 */
public interface JdbcInterface {

    //连接
    public Object getConnection() ;
    //crud
    public void crud();
    //关闭连接
    public void close();
}
```

```java
package com.hspedu.jdbc.myjdbc;

/**
 * mysql 数据库实现了jdbc接口 [模拟] 【mysql厂商开发】
 */
public class MysqlJdbcImpl implements  JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("得到 mysql 的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 mysql 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 mysql 的连接");
    }
}
```

```java
package com.hspedu.jdbc.myjdbc;

/**
 * @author 韩顺平
 * @version 1.0
 * 模拟oracle数据库实现 jdbc
 */
public class OracleJdbcImpl implements  JdbcInterface {
    @Override
    public Object getConnection() {
        System.out.println("得到 oracle的连接 升级");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 对oracle的增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 oracle的连接");
    }
}
```

```java
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
```

### JDBC 带来的好处

如果Java直接访问数据库(示意图)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230513110411325.png)

JDBC带来的好处(示意图)

说明：JDBC是Java提供一套用于数据库操作的接口APl, Java程序员只需要面向这套接口编程即可。不同的数据库厂商,需要针对这套接口,提供不同实现。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230513110440069.png)

JDBC API是一系列的接口，它统一和规范了应用程序与数据库的连接、执行SQL语句，并到得到返回结果等各类操作,相关类和接口在java.sql与javax.sql包中

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230513110627844.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230513110701734.png)

## JDBC 快速入门

### JDBC 程序编写步骤

1. 注册驱动–加载Driver类
2. 获取连接–得到Connection（java程序和数据库之间的连接）
3. 执行增删改查–发送SQL给mysql执行
4. 释放资源–关闭相关连接

### JDBC 第一个程序

通过jdbc对表actor 进行添加，删除和修改操作

```java
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
```

## 获取数据库连接5种方式

### 方式1

```java
    //方式1
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver(); //创建driver对象
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将 用户名和密码放入到Properties 对象
        Properties properties = new Properties();
        //说明 user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user", "root");// 用户
        properties.setProperty("password", "hsp"); //密码
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }
```

### 方式2

```java
    //方式2
    @Test
    public void connect02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //使用反射加载Driver类 , 动态加载，更加的灵活，减少依赖性（把forName后的信息放在配置文件上更加方便）
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将 用户名和密码放入到Properties 对象
        Properties properties = new Properties();
        //说明 user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user", "root");// 用户
        properties.setProperty("password", "hsp"); //密码

        Connection connect = driver.connect(url, properties);
        System.out.println("方式2=" + connect);
    }
```

### 方式3

使用DriverManager 替代 driver 进行统一管理

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230513113641650.png)

```java
//方式3 使用DriverManager 替代 driver 进行统一管理
@Test
public void connect03() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {

    //使用反射加载Driver
    Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
    Driver driver = (Driver) aClass.newInstance();

    //创建url 和 user 和 password
    String url = "jdbc:mysql://localhost:3306/hsp_db02";
    String user = "root";
    String password = "hsp";

    DriverManager.registerDriver(driver);//注册Driver驱动

    Connection connection = DriverManager.getConnection(url, user, password);
    System.out.println("第三种方式=" + connection);
}
```

### 方式4

```java
//方式4: 使用Class.forName 自动完成注册驱动，简化代码
//这种方式获取连接是使用的最多，推荐使用
@Test
public void connect04() throws ClassNotFoundException, SQLException {
    //使用反射加载了 Driver类
    //在加载 Driver类时，完成注册
    /*
        源码: 1. 静态代码块，在类加载时，会执行一次.
        2. DriverManager.registerDriver(new Driver());
        3. 因此注册driver的工作已经完成
        static {
            try {
                DriverManager.registerDriver(new Driver());
            } catch (SQLException var1) {
                throw new RuntimeException("Can't register driver!");
            }
        }
     */
    Class.forName("com.mysql.jdbc.Driver");

    //创建url 和 user 和 password
    String url = "jdbc:mysql://localhost:3306/hsp_db02";
    String user = "root";
    String password = "hsp";
    Connection connection = DriverManager.getConnection(url, user, password);

    System.out.println("第4种方式~ " + connection);

}
```

1. mysqL驱动5.1.6 **可以无需** CLass . forName("com.mysql.jdbc.Driver");
2. 从jdk1.5以后使用了jdbc4,不再需要显示调用class.forName()注册驱动而是自动调用驱动jar包下`META-INF\servicesViava.sql.Driver`文本中的类名称去注册
3. 建议还是写上 CLass . forName("com.mysql.jdbc.Driver"),更加明确

### 方式5

```java
//方式5 , 在方式4的基础上改进，增加配置文件，让连接mysql更加灵活
@Test
public void connect05() throws IOException, ClassNotFoundException, SQLException {

    //通过Properties对象获取配置文件的信息
    Properties properties = new Properties();
    properties.load(new FileInputStream("src\\mysql.properties"));
    //获取相关的值
    String user = properties.getProperty("user");
    String password = properties.getProperty("password");
    String driver = properties.getProperty("driver");
    String url = properties.getProperty("url");

    Class.forName(driver);//建议写上

    Connection connection = DriverManager.getConnection(url, user, password);

    System.out.println("方式5 " + connection);
}
```

## ResultSet[结果集]

### 基本介绍

1. 表示数据库结果集的数据表,通常通过执行查询数据库的语句生成
2. ResultSet对象保持一个光标指向其当前的数据行。最初，光标位于第一行之前
3. next方法将光标移动到下一行，并且由于在ResultSet对象中没有更多行时返回false，因此可以在while循环中使用循环来遍历结果集

### 应用实例

```sql
package com.hspedu.jdbc.resultset_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 演示select 语句返回 ResultSet ,并取出结果
 */
@SuppressWarnings({"all"})
public class ResultSet_ {
    public static void main(String[] args) throws Exception {

        //通过Properties对象获取配置文件的信息


        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1. 注册驱动
        Class.forName(driver);//建议写上

        //2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3. 得到Statement
        Statement statement = connection.createStatement();
        //4. 组织SqL
        String sql = "select id, name , sex, borndate from actor";
        //执行给定的SQL语句，该语句返回单个 ResultSet对象
        /*
        +----+-----------+-----+---------------------+
        | id | name      | sex | borndate            |
        +----+-----------+-----+---------------------+-------+
        |  4 | 刘德华    | 男  | 1970-12-12 00:00:00 |
        |  5 | jack      | 男  | 1990-11-11 00:00:00 |
        +----+-----------+-----+---------------------+-------+
         */
        /*
            阅读debug 代码 resultSet 对象的结构


         */
        ResultSet resultSet = statement.executeQuery(sql);
        // 初始时类似与指向表头
        //5. 使用while取出数据
        while (resultSet.next()) { // 让光标向后移动，如果没有更多行，则返回false
            int id  = resultSet.getInt(1); //获取该行的第1列
            //int id1 = resultSet.getInt("id"); 通过列名来获取值, 推荐
            String name = resultSet.getString(2);//获取该行的第2列
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);

            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }

        //6. 关闭连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
```

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230513134840305.png)

## Statement

### 基本介绍

1. Statement对象用于执行静态SQL语句并返回其生成的结果的对象

2. 在连接建立后,需要对数据库进行访问，执行命名或是SQL语句，可以通过

  + Statement[存在SQL注入]
  + **PreparedStatement**[预处理]
  + CallableStatement[存储过程]

3. Statement对象执行SQL语句,存在**SQL注入风险**。

  ![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230514133425053.png)

4. SQL注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的SQL语句段或命令,恶意攻击数据库。

5. 要防范SQL注入，只要用 PreparedStatement(从Statement扩展而来)取代Statement就可以了。

```java
package com.hspedu.jdbc.statement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示statement 的注入问题
 */
@SuppressWarnings({"all"})
public class Statement_ {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名和密码
        System.out.print("请输入管理员的名字: ");  //next(): 当接收到 空格或者 '就是表示结束
        String admin_name = scanner.nextLine(); // 老师说明，如果希望看到SQL注入，这里需要用nextLine 直到回车才结束
        System.out.print("请输入管理员的密码: ");
        String admin_pwd = scanner.nextLine();

        //通过Properties对象获取配置文件的信息


        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1. 注册驱动
        Class.forName(driver);//建议写上

        //2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3. 得到Statement
        Statement statement = connection.createStatement();
        //4. 组织SqL
        String sql = "select name , pwd  from admin where name ='"
                + admin_name + "' and pwd = '" + admin_pwd + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) { //如果查询到一条记录，则说明该管理存在
            System.out.println("恭喜， 登录成功");
        } else {
            System.out.println("对不起，登录失败");
        }

        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
```

## PreparedStatement

### 基本介绍

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230514134306777.png)

```java
String sql ="SELECT COUNT(*) FROM admin WHERE username =? AND PASSWORD=?";
```

1. PreparedStatement 执行的SQL语句中的参数用问号(?)来表示，调用
   PreparedStatement对象的setXxx()方法来设置这些参数. setXxx()方法有两个参数，第一个参数是要设置的SQL语句中的参数的索引(从1开始)，第二个是设置的SQL语句中的参数的值
2. 调用executeQuery0)，返回ResultSet 对象
3. 调用executeUpdate():执行更新，包括增、删、修改

### 预处理好处

1. 不再使用+拼接sql语句，减少语法错误
2. 有效的解决了sql注入问题!
3. 大大减少了编译次数,效率较高

### 应用案例

```java
package com.hspedu.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示PreparedStatement使用
 */
@SuppressWarnings({"all"})
public class PreparedStatement_ {
    public static void main(String[] args) throws Exception {

        //看 PreparedStatement类图

        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名和密码
        System.out.print("请输入管理员的名字: ");  //next(): 当接收到 空格或者 '就是表示结束
        String admin_name = scanner.nextLine(); // 老师说明，如果希望看到SQL注入，这里需要用nextLine
        System.out.print("请输入管理员的密码: ");
        String admin_pwd = scanner.nextLine();

        //通过Properties对象获取配置文件的信息

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1. 注册驱动
        Class.forName(driver);//建议写上

        //2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3. 得到PreparedStatement
        //3.1 组织SqL , Sql 语句的 ? 就相当于占位符
        String sql = "select name , pwd  from admin where name =? and pwd = ?";
        //3.2 preparedStatement 对象实现了 PreparedStatement 接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 给 ? 赋值
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_pwd);

        //4. 执行 select 语句使用  executeQuery
        //   如果执行的是 dml(update, insert ,delete) executeUpdate()
        //   这里执行 executeQuery ,不要再写 sql

        ResultSet resultSet = preparedStatement.executeQuery(sql);
        if (resultSet.next()) { //如果查询到一条记录，则说明该管理存在
            System.out.println("恭喜， 登录成功");
        } else {
            System.out.println("对不起，登录失败");
        }

        //关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();


    }
}
```

操作DML语句

```java
package com.hspedu.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示PreparedStatement使用 dml语句
 */
@SuppressWarnings({"all"})
public class PreparedStatementDML_ {
    public static void main(String[] args) throws Exception {

        //看 PreparedStatement类图

        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名和密码
        System.out.print("请输删除管理员的名字: ");  //next(): 当接收到 空格或者 '就是表示结束
        String admin_name = scanner.nextLine(); // 老师说明，如果希望看到SQL注入，这里需要用nextLine
//        System.out.print("请输入管理员的新密码: ");
//        String admin_pwd = scanner.nextLine();

        //通过Properties对象获取配置文件的信息

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1. 注册驱动
        Class.forName(driver);//建议写上

        //2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3. 得到PreparedStatement
        //3.1 组织SqL , Sql 语句的 ? 就相当于占位符
        //添加记录
        //String sql = "insert into admin values(?, ?)";
        //String sql = "update admin set pwd = ? where name = ?";
        String sql = "delete from  admin where name = ?";
        //3.2 preparedStatement 对象实现了 PreparedStatement 接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 给 ? 赋值
        preparedStatement.setString(1, admin_name);

        //preparedStatement.setString(2, admin_name);

        //4. 执行 dml 语句使用  executeUpdate
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "执行成功" : "执行失败");
        //关闭连接
        preparedStatement.close();
        connection.close();
    }
}
```

## JDBC 的相关 API 小结

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230514135247608.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230514135304293.png)

## 封装JDBCUtils

### 说明

在jdbc操作中，获取连接和释放资源是经常使用到,可以将其封装DBC连接的工真类JDBCUtils。

### 代码实现

```java
package com.hspedu.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 这是一个工具类，完成 mysql的连接和关闭资源
 */
public class JDBCUtils {
    //定义相关的属性(4个), 因为只需要一份，因此，我们做成static
    private static String user; //用户名
    private static String password; //密码
    private static String url; //url
    private static String driver; //驱动名

    //在static代码块去初始化
    static {

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            //读取相关的属性值
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中，我们可以这样处理
            //1. 将编译异常转成 运行异常
            //2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便.
            throw new RuntimeException(e);

        }
    }

    //连接数据库, 返回Connection
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //1. 将编译异常转成 运行异常
            //2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便.
            throw new RuntimeException(e);
        }
    }

    //关闭相关资源
    /*
        1. ResultSet 结果集
        2. Statement 或者 PreparedStatement
        3. Connection
        4. 如果需要关闭资源，就传入对象，否则传入 null
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {

        //判断是否为null
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            //将编译异常转成运行异常抛出
            throw new RuntimeException(e);
        }
    }
}

```

测试

```java
package com.hspedu.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * 该类演示如何使用JDBCUtils工具类，完成dml 和 select
 */
public class JDBCUtils_Use {


    @Test
    public void testSelect() {
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "select * from actor where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection();
            System.out.println(connection.getClass()); //com.mysql.jdbc.JDBC4Connection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 5);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(set, preparedStatement, connection);
        }
    }

    @Test
    public void testDML() {//insert , update, delete

        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "update actor set name = ? where id = ?";
        // 测试 delete 和 insert ,自己玩.
        PreparedStatement preparedStatement = null;
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1, "周星驰");
            preparedStatement.setInt(2, 4);
            //执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // 打印出错信息
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
```

## 事务

### 基本介绍

1. JDBC程序中当一个Connection对象创建时，默认情况下是自动提交事务:每次执行一个SQL语句时，如果执行成功，就会向数据库自动提交，而不能回滚。
2. JDBC程序中为了让多个SQL语句作为一个整体执行，需要使用事务
3. 调用Connection的setAutoCommit(false)可以取消自动提交事务
4. 在所有的SQL语句都成功执行后，调用Connection的commit();方法提交事务
5. 在其中某个操作失败或出现异常时，调用Connection的rollback();方法回滚事务

### 应用实例

```java
package com.hspedu.jdbc.transaction_;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 演示jdbc 中如何使用事务
 */
public class Transaction_ {

    //没有使用事务.
    @Test
    public void noTransaction() {

        //操作转账的业务
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection(); // 在默认情况下，connection是默认自动提交
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第1条sql

            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第3条sql


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    //事务来解决
    @Test
    public void useTransaction() {

        //操作转账的业务
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection(); // 在默认情况下，connection是默认自动提交
            //将 connection 设置为不自动提交
            connection.setAutoCommit(false); // 相当于开启了事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第1条sql

            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第3条sql

            //这里提交事务
            connection.commit();

        } catch (SQLException e) {
            //这里我们可以进行回滚，即撤销执行的SQL
            //默认回滚到事务开始的状态.
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
```

## 批处理

### 基本介绍

1. 当需要成批插入或者更新记录时。可以采用Java的批量更新机制，这一机制允许多条语句一次性提交给数据库批量处理。通常情况下比单独提交处理更有效率。
2. JDBC的批量处理语句包括下面方法:
   + `addBatch()`:添加需要批量处理的SQL语句或参数
   + `executeBatch()`:执行批量处理语句;
   + `clearBatch()`:清空批处理包的语句
3. JDBC连接MySQL时，如果要使用批处理功能，请在url中加参数`?rewriteBatchedStatements = true`
4. 批处理往往和PreparedStatement一起搭配使用，可以既减少编译次数，又减小运行次数，效率大大提高。

```java
package com.hspedu.jdbc.batch_;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 演示java的批处理
 */
public class Batch_ {

    //传统方法，添加5000条数据到admin2

    @Test
    public void noBatch() throws Exception {

        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();// 开始时间
        for (int i = 0; i < 5000; i++) {// 5000执行
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统的方式 耗时=" + (end - start));//传统的方式 耗时=10702
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }

    //使用批量方式添加数据
    @Test
    public void batch() throws Exception {

        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {//5000执行
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            //将sql 语句加入到批处理包中 -> 看源码
            /*
            //1. //第一就创建 ArrayList - elementData => Object[]
            //2. elementData => Object[] 就会存放我们预处理的sql语句
            //3. 当elementData满后,就按照1.5扩容
            //4. 当添加到指定的值后，就executeBatch
            //5. 批量处理会减少我们发送sql语句的网络开销，而且减少编译次数，因此效率提高
            public void addBatch() throws SQLException {
                synchronized(this.checkClosed().getConnectionMutex()) {
                    if (this.batchedArgs == null) {

                        this.batchedArgs = new ArrayList();
                    }

                    for(int i = 0; i < this.parameterValues.length; ++i) {
                        this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
                    }

                    this.batchedArgs.add(new PreparedStatement.BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                }
            }

             */
            preparedStatement.addBatch();
            //当有1000条记录时，在批量执行
            if((i + 1) % 1000 == 0) {//满1000条sql
                preparedStatement.executeBatch();
                //清空一把
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批量方式 耗时=" + (end - start));//批量方式 耗时=108
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
```

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230514211301050.png)

## 数据库连接池

### 5k 次连接数据库问题

```java
package com.hspedu.jdbc.datasource;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConQuestion {

    //代码 连接mysql 5000次
    @Test
    public void testCon() {

        //看看连接-关闭 connection 会耗用多久
        long start = System.currentTimeMillis();
        System.out.println("开始连接.....");
        for (int i = 0; i < 5000; i++) {
            //使用传统的jdbc方式，得到连接
            Connection connection = JDBCUtils.getConnection();
            //做一些工作，比如得到PreparedStatement ，发送sql
            //..........
            //关闭
            JDBCUtils.close(null, null, connection);

        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式5000次 耗时=" + (end - start));//传统方式5000次 耗时=7099
    }
}
```

### 传统获取Connection 问题分析

1. 传统的JDBC数据库连接使用 DriverManager 来获取，每次向数据库建立连接的时候都要将 Connection 加载到内存中，再验证IP地址，用户名和密码(0.05s~1s时间)。需要数据库连接的时候,就向数据库要求一个,频繁的进行数据库连接操作将占用很多的系统资源，容易造成服务器崩溃。
2. 每一次数据库连接，使用完后都得断开,如果程序出现异常而未能关闭，将导致**数据库内存泄漏**，最终将导致重启数据库。
3. 传统获取连接的方式,不能控制创建的连接数量，如连接过多，也可能导致**内存泄漏**，MySQL崩溃。
4. 解决传统开发中的数据库连接问题,可以采用**数据库连接池技术**
   (connection pool)。

### 数据库连接池种类

1. JDBC 的数据库连接池使用javax.sqI.DataSource来表示，**DataSource 只是一个接口,该接口通常由第三方提供实现[提供.jar]**
2. **C3P0**数据库连接池,速度相对较慢，稳定性不错(hibernate, spring)
3. DBCP数据库连接池,速度相对c3p0较快,但不稳定
4. Proxool数据库连接池，有监控连接池状态的功能，稳定性较c3p0差一点
5. BoneCP数据库连接池,速度快
6. **Druid(德鲁伊)**是阿里提供的数据库连接池，集DBCP、C3P0、Proxool优点于一身的数据库连接池

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230514212128144.png)

### C3P0 应用实例

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230514212448647.png)

两种连接方式：

```java
package com.hspedu.jdbc.datasource;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 演示c3p0的使用
 */
public class C3P0_ {

    //方式1： 相关参数，在程序中指定user, url , password等
    @Test
    public void testC3P0_01() throws Exception {

        //1. 创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2. 通过配置文件mysql.properties 获取相关连接的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //读取相关的属性值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源 comboPooledDataSource 设置相关的参数
        //注意：连接管理是由 comboPooledDataSource 来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //测试连接池的效率, 测试对mysql 5000次操作
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection(); //这个方法就是从 DataSource 接口实现的
            //System.out.println("连接OK");
            connection.close();
        }
        long end = System.currentTimeMillis();
        //c3p0 5000连接mysql 耗时=391
        System.out.println("c3p0 5000连接mysql 耗时=" + (end - start));

    }

    //第二种方式 使用配置文件模板来完成

    //1. 将c3p0 提供的 c3p0.config.xml 拷贝到 src目录下（配置文件名字不能乱写，要按照规定）
    //2. 该文件指定了连接数据库和连接池的相关参数
    @Test
    public void testC3P0_02() throws SQLException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hsp_edu");

        //测试5000次连接mysql
        long start = System.currentTimeMillis();
        System.out.println("开始执行....");
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            //System.out.println("连接OK~");
            connection.close();
        }
        long end = System.currentTimeMillis();
        //c3p0的第二种方式 耗时=413
        System.out.println("c3p0的第二种方式(500000) 耗时=" + (end - start));//1917
    }
}
```

```xml
<c3p0-config>
    <!-- 数据源名称代表连接池 -->
  <named-config name="hsp_edu">
<!-- 驱动类 -->
  <property name="driverClass">com.mysql.jdbc.Driver</property>
  <!-- url-->
   <property name="jdbcUrl">jdbc:mysql://127.0.0.1:3306/hsp_db02</property>
  <!-- 用户名 -->
      <property name="user">root</property>
      <!-- 密码 -->
   <property name="password">hsp</property>
   <!-- 每次增长的连接数-->
    <property name="acquireIncrement">5</property>
    <!-- 初始的连接数 -->
    <property name="initialPoolSize">10</property>
    <!-- 最小连接数 -->
    <property name="minPoolSize">5</property>
   <!-- 最大连接数 -->
    <property name="maxPoolSize">50</property>

   <!-- 可连接的最多的命令对象数 -->
    <property name="maxStatements">5</property> 
    
    <!-- 每个连接对象可连接的最多的命令对象数 -->
    <property name="maxStatementsPerConnection">2</property>
  </named-config>
</c3p0-config>
```

### Druid(德鲁伊)应用实例

```properties
#key=value
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/hsp_db02?rewriteBatchedStatements=true
username=root
password=hsp
#initial connection Size
initialSize=10
#min idle connecton size
minIdle=5
#max active connection size
maxActive=50
#max wait time (5000 mil seconds)
maxWait=5000
```

```java
package com.hspedu.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * 测试druid的使用
 */
public class Druid_ {

    @Test
    public void testDruid() throws Exception {
        //1. 加入 Druid jar包
        //2. 加入 配置文件 druid.properties , 将该文件拷贝项目的src目录
        //3. 创建Properties对象, 读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        //4. 创建一个指定参数的数据库连接池, Druid连接池
        DataSource dataSource =
                DruidDataSourceFactory.createDataSource(properties);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(connection.getClass());
            //System.out.println("连接成功!");
            connection.close();
        }
        long end = System.currentTimeMillis();
        //druid连接池 操作5000 耗时=412
        System.out.println("druid连接池 操作500000 耗时=" + (end - start));//539
    }
}
```

### 将JDBCUtils 工具类改成Druid(德鲁伊)实现

通过德鲁伊数据库连接池获取连接对象

```java
package com.hspedu.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 基于druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {

    private static DataSource ds;

    //在静态代码块完成 ds初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //编写getConnection方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //关闭连接, 老师再次强调： 在数据库连接池技术中，close 不是真的断掉连接
    //而是把使用的Connection对象放回连接池
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                // 特别注意：这里close方法与元生的close方法不一样，这里仅是放回连接池。
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

```java
package com.hspedu.jdbc.datasource;


import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings({"all"})
public class JDBCUtilsByDruid_USE {

    @Test
    public void testSelect() {

        System.out.println("使用 druid方式完成");
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());//运行类型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();

            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");//getName()
                String sex = set.getString("sex");//getSex()
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }
}
```

## Apache—DBUtils

### 先分析一个问题

1. 关闭connection后，resultSet结果集无法使用
2. resultSet不利于数据的管理
3. 示意图

这种java类叫做JavaBean，PoJo或者Domain。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230514215005588.png)

### 自定义方法解决

```java
package com.hspedu.jdbc.datasource;

import java.util.Date;

/**
 * Actor 对象和 actor表的记录对应
 */
public class Actor { //Javabean, POJO, Domain对象

    private Integer id;
    private String name;
    private String sex;
    private Date borndate;
    private String phone;

    public Actor() { //一定要给一个无参构造器[反射需要]
    }

    public Actor(Integer id, String name, String sex, Date borndate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = borndate;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nActor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", borndate=" + borndate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
```

```java
    //使用老师的土方法来解决ResultSet =封装=> Arraylist
    @Test
    public ArrayList<Actor> testSelectToArrayList() {

        System.out.println("使用 druid方式完成");
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Actor> list = new ArrayList<>();//创建ArrayList对象,存放actor对象
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());//运行类型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();

            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");//getName()
                String sex = set.getString("sex");//getSex()
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                //把得到的resultset 的记录，封装到 Actor对象，放入到list集合
                list.add(new Actor(id, name, sex, borndate, phone));
            }

            System.out.println("list集合数据=" + list);
            for(Actor actor : list) {
                System.out.println("id=" + actor.getId() + "\t" + actor.getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
        //因为ArrayList 和 connection 没有任何关联，所以该集合可以复用.
        return  list;
    }
```

### 基本介绍

commons-dbutils是 Apache组织提供的一个开源JDBC工具类库，它是对JDBC的封装，使用dbutils能极大简化jdbc编码的工作量。

1. DbUtils类：
2. QueryRunner类:该类封装了SQL的执行，是线程安全的。可以实现增、删、改、查、批处理。
3. 使用QueryRunner类实现查询。
4. ResultSetHandler接口：该接口用于处理java.sql.ResultSet，将数据按要求转换为另一种形式。
  + ArrayHandler:把结果集中的第一行数据转成对象数组。
  + ArrayListHandler:把结果集中的每一行数据都转成一个数组，再存放到List中。
  + BeanHandler:将结果集中的第一行数据封装到一个对应的JavaBean实例中。
  + BeanListHandler: 将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
  + ColumnListHandler:将结果集中某一列的数据存放到List中。
  + KeyedHandler(name):将结果集中的每行数据都封装到Map里，再把这些map再存到一个map里，其key为指定的key。
  + MapHandler: 将结果集中的第一行数据封装到一个Map里，key是列名,value就是对应的值。
  + MapListHandler:将结果集中的每一行数据都封装到一个Map里，然后再存放到List。

### 应用实例

使用DBUtils+数据连接池(德鲁伊)方式，完成对表actor的crud

```java
package com.hspedu.jdbc.datasource;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class DBUtils_USE {

    // 使用apache-DBUtils 工具类 + druid 完成对表的crud操作
    @Test
    public void testQueryMany() throws SQLException { //返回结果是多行的情况

        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入DBUtils 相关的jar , 加入到本Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回ArrayList 结果集
        //String sql = "select * from actor where id >= ?";
        //   注意: sql 语句也可以查询部分列
        String sql = "select id, name from actor where id >= ?";
        //(1) query 方法就是执行sql 语句，得到resultset ---封装到 --> ArrayList 集合中
        //(2) 返回集合
        //(3) connection: 连接
        //(4) sql : 执行的sql语句
        //(5) new BeanListHandler<>(Actor.class): 在将resultset -> Actor 对象 -> 封装到 ArrayList
        //    底层使用反射机制 去获取Actor 类的属性，然后进行封装
        //(6) 1 就是给 sql 语句中的? 赋值，可以有多个值，因为是可变参数Object... params
        //(7) 底层得到的resultset ,会在query 关闭, 并且关闭PreparedStatment，所以只需要传入connection就可以。
        /**
         * 分析 queryRunner.query方法:
         * public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
         *         PreparedStatement stmt = null;//定义PreparedStatement
         *         ResultSet rs = null;//接收返回的 ResultSet
         *         Object result = null;//返回ArrayList
         *
         *         try {
         *             stmt = this.prepareStatement(conn, sql);//创建PreparedStatement
         *             this.fillStatement(stmt, params);//对sql 进行 ? 赋值
         *             rs = this.wrap(stmt.executeQuery());//执行sql,返回resultset
         *             result = rsh.handle(rs);//返回的resultset --> arrayList[result] [使用到反射，对传入class对象处理]
         *         } catch (SQLException var33) {
         *             this.rethrow(var33, sql, params);
         *         } finally {
         *             try {
         *                 this.close(rs);//关闭resultset
         *             } finally {
         *                 this.close((Statement)stmt);//关闭preparedstatement对象
         *             }
         *         }
         *
         *         return result;
         *     }
         */
        List<Actor> list =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合的信息");
        for (Actor actor : list) {
            System.out.print(actor);
        }


        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);

    }

    //演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException {

        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入DBUtils 相关的jar , 加入到本Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回单个对象
        String sql = "select * from actor where id = ?";
        // 因为我们返回的单行记录<--->单个对象 , 使用的Hander 是 BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 10);
        System.out.println(actor);

        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);

    }

    //演示apache-dbutils + druid 完成查询结果是单行单列-返回的就是object
    @Test
    public void testScalar() throws SQLException {

        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入DBUtils 相关的jar , 加入到本Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //4. 就可以执行相关的方法，返回单行单列 , 返回的就是Object
        String sql = "select name from actor where id = ?";
        //老师解读： 因为返回的是一个对象, 使用的handler 就是 ScalarHandler
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 4);
        System.out.println(obj);

        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示apache-dbutils + druid 完成 dml (update, insert ,delete)
    @Test
    public void testDML() throws SQLException {

        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入DBUtils 相关的jar , 加入到本Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //4. 这里组织sql 完成 update, insert delete
        //String sql = "update actor set name = ? where id = ?";
        //String sql = "insert into actor values(null, ?, ?, ?, ?)";
        String sql = "delete from actor where id = ?";

        //(1) 执行dml 操作是 queryRunner.update()
        //(2) 返回的值是受影响的行数 (affected: 受影响)
        //int affectedRow = queryRunner.update(connection, sql, "林青霞", "女", "1966-10-10", "116");
        int affectedRow = queryRunner.update(connection, sql, 1000 );
        System.out.println(affectedRow > 0 ? "执行成功" : "执行没有影响到表");

        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);

    }
}
```

### 表 和 JavaBean 的类型映射关系

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230514221838385.png)

## DAO 和增删改查通用方法-BasicDao

### 先分析一个问题

apache-dbutils+ Druid简化了JDBC开发,但还有不足:
1. SQL语句是固定，不能通过参数传入，通用性不好，需要进行改进，更方便执行增删改查
2. 对于select 操作，如果有返回值，返回类型不能固定，需要使用泛型
3. 将来的表很多，业务需求复杂,不可能只靠一个Java类完成
4. 引出=》 BasicDAO画出示意图，看看在实际开发中，应该如何处理

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230514223248542.png)

### 基本说明

1. DAO : data access object数据访问对象
2. 这样的通用类，称为 BasicDao，是专门和数据库交互的，即完成对数据库(表)的crud操作。
3. 在BaiscDao的基础上，实现一张表对应一个Dao，更好的完成功能，比如 Customer表-Customer.java类(javabean)-CustomerDao.java

### BasicDAO 应用实例

完成一个简单设计`com.hspedu.dao_`
1. `com.hspedu.dao _.utils` //工具类
2. `com.hspedu.dao_.domain` // javabean
3. `com.hspedu.dao_.dao`//存放XxxDAO和BasicDAO_
3. `com.hspedu.dao_.test` //写测试类

com/hspedu/dao_/domain/Actor.java

```java
package com.hspedu.dao_.domain;

import java.util.Date;

/**
 * Actor 对象和 actor表的记录对应
 */
public class Actor { //Javabean, POJO, Domain对象

    private Integer id;
    private String name;
    private String sex;
    private Date borndate;
    private String phone;

    public Actor() { //一定要给一个无参构造器[反射需要]
    }

    public Actor(Integer id, String name, String sex, Date borndate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = borndate;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nActor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", borndate=" + borndate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
```

com/hspedu/dao_/utils/JDBCUtilsByDruid.java

```java
package com.hspedu.dao_.domain;

import java.util.Date;

/**
 * Actor 对象和 actor表的记录对应
 */
public class Actor { //Javabean, POJO, Domain对象

    private Integer id;
    private String name;
    private String sex;
    private Date borndate;
    private String phone;

    public Actor() { //一定要给一个无参构造器[反射需要]
    }

    public Actor(Integer id, String name, String sex, Date borndate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = borndate;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nActor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", borndate=" + borndate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
```

com/hspedu/dao_/dao/BasicDAO.java

```java
package com.hspedu.dao_.dao;

import com.hspedu.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 开发BasicDAO , 是其他DAO的父类
 */
public class BasicDAO<T> { //泛型指定具体类型

    private QueryRunner qr =  new QueryRunner();

    //开发通用的dml方法, 针对任意的表
    public int update(String sql, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return  update;
        } catch (SQLException e) {
           throw  new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //返回多个对象(即查询的结果是多行), 针对任意表

    /**
     *
     * @param sql sql 语句，可以有 ?
     * @param clazz 传入一个类的Class对象 比如 Actor.class
     * @param parameters 传入 ? 的具体的值，可以是多个
     * @return 根据Actor.class 返回对应的 ArrayList 集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);

        } catch (SQLException e) {
            throw  new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }

    //查询单行结果 的通用方法
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return  qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);

        } catch (SQLException e) {
            throw  new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //查询单行单列的方法,即返回单值的方法

    public Object queryScalar(String sql, Object... parameters) {

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return  qr.query(connection, sql, new ScalarHandler(), parameters);

        } catch (SQLException e) {
            throw  new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
```

com/hspedu/dao_/dao/ActorDAO.java

```java
package com.hspedu.dao_.dao;

import com.hspedu.dao_.domain.Actor;

public class ActorDAO extends BasicDAO<Actor> {
    //1. 就有 BasicDAO 的方法
    //2. 根据业务需求，可以编写特有的方法.
}
```

com/hspedu/dao_/test/TestDAO.java

```java
package com.hspedu.dao_.test;

import com.hspedu.dao_.dao.ActorDAO;
import com.hspedu.dao_.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDAO {

    //测试ActorDAO 对actor表crud操作
    @Test
    public void testActorDAO() {

        ActorDAO actorDAO = new ActorDAO();
        //1. 查询
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("===查询结果===");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        //2. 查询单行记录
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 6);
        System.out.println("====查询单行结果====");
        System.out.println(actor);

        //3. 查询单行单列
        Object o = actorDAO.queryScalar("select name from actor where id = ?", 6);
        System.out.println("====查询单行单列值===");
        System.out.println(o);

        //4. dml操作  insert ,update, delete
        int update = actorDAO.update("insert into actor values(null, ?, ?, ?, ?)", "张无忌", "男", "2000-11-11", "999");

        System.out.println(update > 0 ? "执行成功" : "执行没有影响表");
    }
}
```
