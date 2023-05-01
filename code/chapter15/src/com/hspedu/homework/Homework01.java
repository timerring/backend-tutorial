package com.hspedu.homework;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Homework01 {
    public static void main(String[] args) {

    }

    @Test
    public void testList() {
        //说明
        //这里我们给T 指定类型是User
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1,10,"jack"));
        dao.save("002", new User(2,18,"king"));
        dao.save("003", new User(3,38,"smith"));

        List<User> list = dao.list();

        System.out.println("list=" + list);

        dao.update("003", new User(3, 58, "milan"));
        dao.delete("001");//删除
        System.out.println("===修改后====");
        list = dao.list();
        System.out.println("list=" + list);

        System.out.println("id=003 " + dao.get("003"));//milan

    }
}
/**
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 *
 * 分别创建以下方法：
 * (1) public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 * (2) public T get(String id)：从 map 中获取 id 对应的对象
 * (3) public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 * (4) public List<T> list()：返回 map 中存放的所有 T 对象
 * (5) public void delete(String id)：删除指定 id 对象
 *
 * 定义一个 User 类：
 * 该类包含：private成员变量（int类型） id，age；（String 类型）name。
 *
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 *
 * 思路分析
 * 1. 定义User类
 * 2. 定义Dao<T>泛型类
 */
