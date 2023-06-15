package com.hspedu.qqframe;

import com.hspedu.qqserver.service.QQServer;

/**
 * 该类创建QQServer ,启动后台的服务
 */
public class QQFrame {
    public static void main(String[] args)  {
        new QQServer();
    }
}
