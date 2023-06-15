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
