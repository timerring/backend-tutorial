package com.hspedu.regexp;

public class StringReg {

    public static void main(String[] args) {
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其" +
                "获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发" +
                "布。" +
                "2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升";

        //使用正则表达式方式，将 JDK1.3 和 JDK1.4 替换成JDK
        content = content.replaceAll("JDK1\\.3|JDK1\\.4", "JDK");
        System.out.println(content);

        //要求 验证一个 手机号， 要求必须是以 138 139 开头的
        content = "13888889999";
        if (content.matches("1(38|39)\\d{8}")) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }

        //要求按照 # 或者 - 或者 ~ 或者 数字 来分割
        System.out.println("===================");
        content = "hello#abc-jack12smith~北京";
        String[] split = content.split("#|-|~|\\d+");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
