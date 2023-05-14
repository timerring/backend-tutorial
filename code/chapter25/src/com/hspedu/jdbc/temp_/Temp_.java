package com.hspedu.jdbc.temp_;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class Temp_ {

    @Test
    public void m1() {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) { //操作数据库5k
            Connection connection = JDBCUtils.getConnection();
            //System.out.println("do something..");
            JDBCUtils.close(null,null,connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("连接5k次mysql 耗时=" + (end - start));


    }
}
