package com.hspedu.qqcommon;

import java.io.Serializable;

/**
 * 表示一个用户/客户信息
 */
public class User implements Serializable {
    // 如果一个对象需要通过对象流的方式读取，则该对象对应的类需要序列化。（IO讲的）!!!!

    // 保证兼容性
    private static final long serialVersionUID = 1L;
    private String userId;//用户Id/用户名
    private String passwd;//用户密码

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
