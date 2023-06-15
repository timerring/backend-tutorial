package com.hspedu.map_;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        //演示map接口常用方法

        Map map = new HashMap();
        map.put("fh", new Book("", 100));//OK
        map.put("fh", "bnd");//替换-> 一会分析源码
        map.put("fgd", "mr");//OK
        map.put("sgfh", "mr");//OK
        map.put("vcbhhd", null);//OK
        map.put(null, "dfhdfg");//OK
        map.put("lh", "gct");//OK
        map.put("hsp", "hspd");

        System.out.println("map=" + map);

//        remove:根据键删除映射关系
        map.remove(null);
        System.out.println("map=" + map);
//        get：根据键获取值
        Object val = map.get("lh");
        System.out.println("val=" + val);
//        size:获取元素个数
        System.out.println("k-v=" + map.size());
//        isEmpty:判断个数是否为0
        System.out.println(map.isEmpty());//F
//        clear:清除k-v
        //map.clear();
        System.out.println("map=" + map);
//        containsKey:查找键是否存在
        System.out.println("结果=" + map.containsKey("hsp"));//T


    }
}

class Book {
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
