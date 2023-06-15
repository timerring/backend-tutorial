- [第26章 满汉楼](#第26章-满汉楼)
  - [程序框架图](#程序框架图)
  - [代码实现](#代码实现)
    - [数据库](#数据库)
    - [Java](#java)
    - [多表查询思路](#多表查询思路)


# 第26章 满汉楼

## 程序框架图

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230515085601606.png)

## 代码实现

### 数据库

```sql
-- 创建满汉楼的数据库
CREATE DATABASE mhl
-- 创建表 employee 表 (主键id, empId, name, pwd, job, 如果需要可以自己加字段等)
#用户表
CREATE TABLE employee (
	id INT PRIMARY KEY AUTO_INCREMENT, #自增
	empId VARCHAR(50) UNIQUE NOT NULL DEFAULT '',#员工号
	pwd CHAR(32) NOT NULL DEFAULT '',#密码md5
	NAME VARCHAR(50) NOT NULL DEFAULT '',#姓名
	job VARCHAR(50) NOT NULL DEFAULT '' #岗位
)CHARSET=utf8; 

DROP TABLE employee
#添加测试数据
INSERT INTO employee VALUES(NULL, '6668612', MD5('123456'), '张三丰', '经理');
INSERT INTO employee VALUES(NULL, '6668622', MD5('123456'),'小龙女', '服务员');
INSERT INTO employee VALUES(NULL, '6668633', MD5('123456'), '张无忌', '收银员');
INSERT INTO employee VALUES(NULL, '666666', MD5('123456'), '老韩', '经理');

SELECT * FROM employee;

SELECT * FROM employee WHERE empId='666666' AND pwd=MD5('123456')

-- 创建diningTable 表(id, state , orderName, orderTel ....)

CREATE TABLE diningTable (
	id INT PRIMARY KEY AUTO_INCREMENT, #自增, 表示餐桌编号
	state VARCHAR(20) NOT NULL DEFAULT '',#餐桌的状态
	orderName VARCHAR(50) NOT NULL DEFAULT '',#预订人的名字
	orderTel VARCHAR(20) NOT NULL DEFAULT ''
)CHARSET=utf8; 
#测试数据
INSERT INTO diningTable VALUES(NULL, '空','','');
INSERT INTO diningTable VALUES(NULL, '空','','');
INSERT INTO diningTable VALUES(NULL, '空','','');
SELECT * FROM diningTable

SELECT * FROM diningTable

SELECT * FROM diningTable WHERE id = 1

UPDATE diningTable SET state='空', orderName='', orderTel='' WHERE id=1

-- 创建menu表(id, name, type, price)
#菜谱
CREATE TABLE menu (
	id INT PRIMARY KEY AUTO_INCREMENT, #自增主键，作为菜谱编号(唯一)
	NAME VARCHAR(50) NOT NULL DEFAULT '',#菜品名称
	TYPE VARCHAR(50) NOT NULL DEFAULT '', #菜品种类
	price DOUBLE NOT NULL DEFAULT 0#价格
)CHARSET=utf8; 
#测试数据
INSERT INTO menu VALUES(NULL, '八宝饭', '主食', 10);
INSERT INTO menu VALUES(NULL, '叉烧包', '主食', 20);
INSERT INTO menu VALUES(NULL, '宫保鸡丁', '热菜', 30);
INSERT INTO menu VALUES(NULL, '山药拨鱼', '凉菜', 14);
INSERT INTO menu VALUES(NULL, '银丝卷', '甜食', 9);
INSERT INTO menu VALUES(NULL, '水煮鱼', '热菜', 26);
INSERT INTO menu VALUES(NULL, '甲鱼汤', '汤类', 100);
INSERT INTO menu VALUES(NULL, '鸡蛋汤', '汤类', 16);

SELECT * FROM menu;
#同学们可以单独创建一张表，表示菜品的类别

#增加表 bill 账单表(id, billId, menuId, nums, billDate, money, state, diningTableId )
#账单流水, 考虑可以分开结账, 并考虑将来分别统计各个不同菜品的销售情况
CREATE TABLE bill (
	id INT PRIMARY KEY AUTO_INCREMENT, #自增主键
	billId VARCHAR(50) NOT NULL DEFAULT '',#账单号可以按照自己规则生成 UUID
	menuId INT NOT NULL DEFAULT 0,#菜品的编号, 也可以使用外键
	nums INT NOT NULL DEFAULT 0,#份数
	money DOUBLE NOT NULL DEFAULT 0, #金额
	diningTableId INT NOT NULL DEFAULT 0, #餐桌
	billDate DATETIME NOT NULL ,#订单日期
	state VARCHAR(50) NOT NULL DEFAULT '' # 状态 '未结账' , '已经结账', '挂单','现金','支付宝','坏账'
)CHARSET=utf8;

SELECT * FROM bill;
select * from bill


SELECT * FROM menu WHERE id = 1

UPDATE diningTable SET state=? WHERE id=?

SELECT * FROM diningTable


-- 查出某个餐桌是否有未结账的账单
select * from bill where diningTableId=1 and state = '未结账' limit 0, 1
```

### Java

```
`-- src
    |-- com
    |   `-- hspedu
    |       `-- mhl
    |           |-- dao
    |           |   |-- BasicDAO.java
    |           |   |-- BillDAO.java
    |           |   |-- DiningTableDAO.java
    |           |   |-- EmployeeDAO.java
    |           |   |-- MenuDAO.java
    |           |   `-- MultiTableDAO.java
    |           |-- domain
    |           |   |-- Bill.java
    |           |   |-- DiningTable.java
    |           |   |-- Employee.java
    |           |   |-- Menu.java
    |           |   `-- MultiTableBean.java
    |           |-- service
    |           |   |-- BillService.java
    |           |   |-- DiningTableService.java
    |           |   |-- EmployeeService.java
    |           |   `-- MenuService.java
    |           |-- utils
    |           |   |-- JDBCUtilsByDruid.java
    |           |   `-- Utility.java
    |           `-- view
    |               `-- MHLView.java
    `-- druid.properties
```

src/com/hspedu/mhl/dao/BasicDAO.java

```java
package com.hspedu.mhl.dao;


import com.hspedu.mhl.utils.JDBCUtilsByDruid;
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

src/com/hspedu/mhl/dao/BillDAO.java

```java
package com.hspedu.mhl.dao;

import com.hspedu.mhl.domain.Bill;
public class BillDAO extends BasicDAO<Bill> {
}
```

src/com/hspedu/mhl/dao/DiningTableDAO.java

```java
package com.hspedu.mhl.dao;

import com.hspedu.mhl.domain.DiningTable;

public class DiningTableDAO extends BasicDAO<DiningTable> {
    //如果有特别的操作，可以写在 DiningTableDAO
}
```

src/com/hspedu/mhl/dao/EmployeeDAO.java

```java
package com.hspedu.mhl.dao;

import com.hspedu.mhl.domain.Employee;

public class EmployeeDAO extends BasicDAO<Employee> {
    //这里还可以写特有的操作.
}
```

src/com/hspedu/mhl/dao/MenuDAO.java

```java
package com.hspedu.mhl.dao;

import com.hspedu.mhl.domain.Menu;

public class MenuDAO extends BasicDAO<Menu> {
}
```

src/com/hspedu/mhl/dao/MultiTableDAO.java

```java
package com.hspedu.mhl.dao;

import com.hspedu.mhl.domain.MultiTableBean;

public class MultiTableDAO extends BasicDAO<MultiTableBean> {
}
```

src/com/hspedu/mhl/domain/Bill.java

```java
package com.hspedu.mhl.domain;

import java.util.Date;

/**
 * Bill 是javabean 和 bill对应
 * id int primary key auto_increment, #自增主键
 *     billId varchar(50) not null default '',#账单号可以按照自己规则生成 UUID
 *     menuId int not null default 0,#菜品的编号, 也可以使用外键
 *     nums int not null default 0,#份数
 *     money double not null default 0, #金额
 *     diningTableId int not null default 0, #餐桌
 *     billDate datetime not null ,#订单日期
 *     state varchar(50) not null default '' # 状态 '未结账' , '已经结账', '挂单'
 */
public class Bill {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer diningTableId;
    private Date billDate;
    private String state;

    public Bill() {
    }

    public Bill(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer diningTableId, Date billDate, String state) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + menuId +
                "\t\t\t" + nums +
                "\t\t\t" + money +
                "\t" + diningTableId +
                "\t\t" + billDate +
                "\t\t" + state ;
    }
}
```

src/com/hspedu/mhl/domain/DiningTable.java

```java
package com.hspedu.mhl.domain;

/**
 * 这是一个javabean 和 diningTable 表对应
 *     id int primary key auto_increment, #自增, 表示餐桌编号
 *     state varchar(20) not null default '',#餐桌的状态
 *     orderName varchar(50) not null default '',#预订人的名字
 *     orderTel varchar(20) not null default ''
 */
public class DiningTable {
    private Integer id;
    private String state;
    private String orderName;
    private String orderTel;

    public DiningTable() {
    }

    public DiningTable(Integer id, String state, String orderName, String orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" + state;
    }
}
```

src/com/hspedu/mhl/domain/Employee.java

```java
package com.hspedu.mhl.domain;

/**
 * 这是一个javabean 和 employee对应
 * id int primary key auto_increment, #自增
 *     empId varchar(50) not null default '',#员工号
 *     pwd char(32) not null default '',#密码md5
 *     name varchar(50) not null default '',#姓名
 *     job varchar(50) not null default '' #岗位
 */
public class Employee {
    private Integer id;
    private String empId;
    private String pwd;
    private String name;
    private String job;

    public Employee() { //无参构造器，底层apache-dbutils反射需要
    }

    public Employee(Integer id, String empId, String pwd, String name, String job) {
        this.id = id;
        this.empId = empId;
        this.pwd = pwd;
        this.name = name;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
```

src/com/hspedu/mhl/domain/Menu.java

```java
package com.hspedu.mhl.domain;

/**
 * 该类(javabean)和 menu 表对应
 * id int primary key auto_increment, #自增主键，作为菜谱编号(唯一)
 * name varchar(50) not null default '',#菜品名称
 * type varchar(50) not null default '', #菜品种类
 * price double not null default 0#价格
 */
public class Menu {
    private Integer id;
    private String name;
    private String type;
    private Double price;

    public Menu() {//无参构造器
    }

    public Menu(Integer id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" + name + "\t\t" + type + "\t\t" + price;
    }
}
```

src/com/hspedu/mhl/domain/MultiTableBean.java

```java
package com.hspedu.mhl.domain;

import java.util.Date;

/**
 * 这是一个javabean 可以和多张表进行对应
 */
public class MultiTableBean {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer diningTableId;
    private Date billDate;
    private String state;
    //增加一个来自menu表的列 name
    //思考 这里的属性名是否一定要和表的列名保持一致.
    //答: 可以不一致，但是需要sql做相应的修改, 规范需要保持一致（例如 SELECT Name AS name2  他会调用对应的setName2构造方法）.
    private String name;
    //增加来自menu表的列 price
    private Double price;//默认值 nulll

    // 实际上是调用无参构造器，进行反射调用，然后通过setter和getter方法进行调用的：
    public MultiTableBean() {
        System.out.println("反射调用....");
    }

//    public MultiTableBean(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer diningTableId, Date billDate, String state, String name, Double price) {
//        this.id = id;
//        this.billId = billId;
//        this.menuId = menuId;
//        this.nums = nums;
//        this.money = money;
//        this.diningTableId = diningTableId;
//        this.billDate = billDate;
//        this.state = state;
//        this.name = name;
//        this.price = price;
//    }

    //给price生成setter 和 getter

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    //给name生成setter 和 getter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + menuId +
                "\t\t\t" + nums +
                "\t\t\t" + money +
                "\t" + diningTableId +
                "\t\t" + billDate +
                "\t\t" + state +
                "\t\t" + name +
                "\t\t" + price;
    }
}
```

src/com/hspedu/mhl/service/BillService.java

```java
package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.BillDAO;
import com.hspedu.mhl.dao.MultiTableDAO;
import com.hspedu.mhl.domain.Bill;
import com.hspedu.mhl.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * 处理和账单相关的业务逻辑
 */
public class BillService {
    //定义BillDAO属性
    private BillDAO billDAO = new BillDAO();
    //定义MenuService 属性
    private MenuService menuService = new MenuService();
    //定义DiningTableService属性
    private DiningTableService diningTableService = new DiningTableService();

    private MultiTableDAO multiTableDAO = new MultiTableDAO();

    //思考
    //编写点餐的方法
    //1. 生成账单
    //2. 需要更新对应餐桌的状态
    //3. 如果成功返回true, 否则返回false
    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        //生成一个账单号,UUID
        String billID = UUID.randomUUID().toString();

        //将账单生成到bill表, 要求直接计算账单金额
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billID, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);

        if (update <= 0) {
            return false;
        }

        //需要更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");

    }

    //返回所有的账单， 提供给View调用
    public List<Bill> list() {
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    //返回所有的账单并带有菜品名,价格， 提供给View调用
    public List<MultiTableBean> list2() {
        return multiTableDAO.queryMulti("SELECT bill.*, NAME " +
                "FROM bill, menu " +
                "WHERE bill.menuId = menu.id", MultiTableBean.class);
    }


    //查看某个餐桌是否有未结账的账单
    public boolean hasPayBillByDiningTableId(int diningTableId) {

        Bill bill =
                billDAO.querySingle("SELECT * FROM bill WHERE diningTableId=? AND state = '未结账' LIMIT 0, 1", Bill.class, diningTableId);
        return bill != null;
    }

    //完成结账[如果餐桌存在，并且该餐桌有未结账的账单]
    //如果成功，返回true, 失败返回 false
    public boolean payBill(int diningTableId, String payMode) {

        //如果这里使用事务的话，需要用ThreadLocal来解决 , 框架中比如mybatis 提供了事务支持
        //1. 修改bill表
        int update = billDAO.update("update bill set state=? where diningTableId=? and state='未结账'", payMode, diningTableId);

        if(update <= 0) { //如果更新没有成功，则表示失败...
            return false;
        }
        //2. 修改diningTable表
        //注意：不要直接在这里操作，而应该调用DiningTableService 方法,完成更新，体现各司其职

        if(!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
            return false;
        }
        return true;
    }
}
```

src/com/hspedu/mhl/service/DiningTableService.java

```java
package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.DiningTableDAO;
import com.hspedu.mhl.domain.DiningTable;

import java.util.List;

public class DiningTableService { //业务层
    //定义一个DiningTableDAO对象
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //返回所有餐桌的信息
    public List<DiningTable> list() {

        return diningTableDAO.queryMulti("select id, state from diningTable", DiningTable.class);
    }

    //根据id , 查询对应的餐桌DiningTable 对象
    //,如果返回null , 表示id编号对应的餐桌不存在
    public DiningTable getDiningTableById(int id) {

        //小技巧：把sql语句放在查询分析器去测试一下.
        return diningTableDAO.querySingle("select * from diningTable where id = ?", DiningTable.class, id);
    }

    //如果餐桌可以预定，调用方法，对其状态进行更新(包括预定人的名字和电话)
    public boolean orderDiningTable(int id, String orderName, String orderTel) {

        int update =
                diningTableDAO.update("update diningTable set state='已经预定', orderName=?, orderTel=? where id=?", orderName, orderTel, id);

        return  update > 0;
    }

    //需要提供一个更新 餐桌状态的方法
    public boolean updateDiningTableState(int id, String state) {

        int update = diningTableDAO.update("update diningTable set state=? where id=?", state, id);
        return update > 0;
    }

    //提供方法，将指定的餐桌设置为空闲状态
    public boolean updateDiningTableToFree(int id, String state) {

        int update = diningTableDAO.update("update diningTable set state=?,orderName='',orderTel='' where id=?", state, id);
        return update > 0;
    }

}
```

src/com/hspedu/mhl/service/EmployeeService.java

```java
package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.EmployeeDAO;
import com.hspedu.mhl.domain.Employee;

/**
 * 该类完成对employee表的各种操作(通过调用EmployeeDAO对象完成)
 */
public class EmployeeService {

    //定义一个 EmployeeDAO 属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //方法，根据empId 和 pwd 返回一个Employee对象
    //如果查询不到，就返回null
    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {

        return employeeDAO.querySingle("select * from employee where empId=? and pwd=md5(?)", Employee.class, empId, pwd);

    }
}
```

src/com/hspedu/mhl/service/MenuService.java

```java
package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.MenuDAO;
import com.hspedu.mhl.domain.Menu;

import java.util.List;

/**
 * 完成对menu表的各种操作(通过调用MenuDAO)
 */
public class MenuService {

    //定义MenuDAO 属性
    private MenuDAO menuDAO = new MenuDAO();

    //返回所有的菜品, 返回给界面使用
    public List<Menu> list() {
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    //需要方法，根据id, 返回Menu对象
    public Menu getMenuById(int id) {
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
    }
}
```

src/com/hspedu/mhl/utils/JDBCUtilsByDruid.java

```java
package com.hspedu.mhl.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
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
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

src/com/hspedu/mhl/utils/Utility.java

```java
package com.hspedu.mhl.utils;


/**
   工具类的作用:
   处理各种情况的用户输入，并且能够按照程序员的需求，得到用户的控制台输入。
*/

import java.util.*;
/**

   
*/
public class Utility {
   //静态属性。。。
    private static Scanner scanner = new Scanner(System.in);

    
    /**
     * 功能：读取键盘输入的一个菜单选项，值：1——5的范围
     * @return 1——5
     */
   public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);//包含一个字符的字符串
            c = str.charAt(0);//将字符串转换成字符char类型
            if (c != '1' && c != '2' && 
                c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

   /**
    * 功能：读取键盘输入的一个字符
    * @return 一个字符
    */
    public static char readChar() {
        String str = readKeyBoard(1, false);//就是一个字符
        return str.charAt(0);
    }
    /**
     * 功能：读取键盘输入的一个字符，如果直接按回车，则返回指定的默认值；否则返回输入的那个字符
     * @param defaultValue 指定的默认值
     * @return 默认值或输入的字符
     */
    
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);//要么是空字符串，要么是一个字符
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }
   
    /**
     * 功能：读取键盘输入的整型，长度小于2位
     * @return 整数
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);//一个整数，长度<=2位
            try {
                n = Integer.parseInt(str);//将字符串转换成整数
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    /**
     * 功能：读取键盘输入的 整数或默认值，如果直接回车，则返回默认值，否则返回输入的整数
     * @param defaultValue 指定的默认值
     * @return 整数或默认值
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, true);
            if (str.equals("")) {
                return defaultValue;
            }
         
         //异常处理...
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 功能：读取键盘输入的指定长度的字符串
     * @param limit 限制的长度
     * @return 指定长度的字符串
     */

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 功能：读取键盘输入的指定长度的字符串或默认值，如果直接回车，返回默认值，否则返回字符串
     * @param limit 限制的长度
     * @param defaultValue 指定的默认值
     * @return 指定长度的字符串
     */
   
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }


   /**
    * 功能：读取键盘输入的确认选项，Y或N
    * 将小的功能，封装到一个方法中.
    * @return Y或N
    */
    public static char readConfirmSelection() {
        System.out.print("确认是否预订(Y/N): ");
        char c;
        for (; ; ) {//无限循环
           //在这里，将接受到字符，转成了大写字母
           //y => Y n=>N
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    /**
     * 功能： 读取一个字符串
     * @param limit 读取的长度
     * @param blankReturn 如果为true ,表示 可以读空字符串。 
     *                   如果为false表示 不能读空字符串。
     *           
    * 如果输入为空，或者输入大于limit的长度，就会提示重新输入。
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        
      //定义了字符串
      String line = "";

      //scanner.hasNextLine() 判断有没有下一行
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();//读取这一行
           
         //如果line.length=0, 即用户没有输入任何内容，直接回车
         if (line.length() == 0) {
                if (blankReturn) return line;//如果blankReturn=true,可以返回空串
                else continue; //如果blankReturn=false,不接受空串，必须输入内容
            }

         //如果用户输入的内容大于了 limit，就提示重写输入  
         //如果用户如的内容 >0 <= limit ,我就接受
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不能大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
}
```

src/com/hspedu/mhl/view/MHLView.java

```java
package com.hspedu.mhl.view;

import com.hspedu.mhl.domain.*;
import com.hspedu.mhl.service.BillService;
import com.hspedu.mhl.service.DiningTableService;
import com.hspedu.mhl.service.EmployeeService;
import com.hspedu.mhl.service.MenuService;
import com.hspedu.mhl.utils.Utility;

import java.util.List;
import java.util.UUID;

/**
 * 这是主界面
 */
public class MHLView {

    //控制是否退出菜单
    private boolean loop = true;
    private String key = ""; //接收用户的选择
    //定义EmployeeService 属性
    private EmployeeService employeeService = new EmployeeService();
    //定义DiningTableService的属性
    private DiningTableService diningTableService = new DiningTableService();
    //定义MenuService属性
    private MenuService menuService = new MenuService();
    //定义BillService属性
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    //完成结账
    public void payBill() {
        System.out.println("==============结账服务============");
        System.out.print("请选择要结账的餐桌编号(-1退出): ");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1) {
            System.out.println("=============取消结账============");
            return;
        }
        //验证餐桌是否存在
        DiningTable diningTable = diningTableService.getDiningTableById(diningTableId);
        if (diningTable == null) {
            System.out.println("=============结账的餐桌不存在============");
            return;
        }
        //验证餐桌是否有需要结账的账单
        if (!billService.hasPayBillByDiningTableId(diningTableId)) {
            System.out.println("=============该餐位没有未结账账单============");
            return;
        }
        System.out.print("结账方式(现金/支付宝/微信)回车表示退出: ");
        String payMode = Utility.readString(20, "");//说明如果回车，就是返回 ""
        if ("".equals(payMode)) {
            System.out.println("=============取消结账============");
            return;
        }
        char key = Utility.readConfirmSelection();
        if (key == 'Y') { //结账

            //调用我们写的方法
            if (billService.payBill(diningTableId, payMode)) {
                System.out.println("=============完成结账============");
            } else {
                System.out.println("=============结账失败============");
            }

        } else {
            System.out.println("=============取消结账============");
        }
    }

    //显示账单信息
    public void listBill() {
//        List<Bill> bills = billService.list();
//        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
//        for (Bill bill : bills) {
//            System.out.println(bill);
//        }
//        System.out.println("==============显示完毕============");

        List<MultiTableBean> multiTableBeans = billService.list2();
        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态\t\t菜品名\t\t价格");
        for (MultiTableBean bill : multiTableBeans) {
            System.out.println(bill);
        }
        System.out.println("==============显示完毕============");
    }

    //完成点餐
    public void orderMenu() {
        System.out.println("==============点餐服务============");
        System.out.print("请输入点餐的桌号(-1退出): ");
        int orderDiningTableId = Utility.readInt();
        if (orderDiningTableId == -1) {
            System.out.println("==============取消点餐============");
            return;
        }
        System.out.print("请输入点餐的菜品号(-1退出): ");
        int orderMenuId = Utility.readInt();
        if (orderMenuId == -1) {
            System.out.println("==============取消点餐============");
            return;
        }
        System.out.print("请输入点餐的菜品量(-1退出): ");
        int orderNums = Utility.readInt();
        if (orderNums == -1) {
            System.out.println("==============取消点餐============");
            return;
        }

        //验证餐桌号是否存在.
        DiningTable diningTable = diningTableService.getDiningTableById(orderDiningTableId);
        if (diningTable == null) {
            System.out.println("==============餐桌号不存在============");
            return;
        }
        //验证菜品编号
        Menu menu = menuService.getMenuById(orderMenuId);
        if (menu == null) {
            System.out.println("==============菜品号不存在============");
            return;
        }

        //点餐
        if (billService.orderMenu(orderMenuId, orderNums, orderDiningTableId)) {
            System.out.println("==============点餐成功============");
        } else {
            System.out.println("==============点餐失败============");
        }
    }

    //显示所有菜品
    public void listMenu() {
        List<Menu> list = menuService.list();
        System.out.println("\n菜品编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu : list) {
            System.out.println(menu);
        }
        System.out.println("==============显示完毕============");
    }

    //完成订座
    public void orderDiningTable() {
        System.out.println("==============预定餐桌============");
        System.out.print("请选择要预定的餐桌编号(-1退出): ");
        int orderId = Utility.readInt();
        if (orderId == -1) {
            System.out.println("==============取消预订餐桌============");
            return;
        }
        //该方法得到的是 Y 或者 N
        char key = Utility.readConfirmSelection();
        if (key == 'Y') {//要预定

            //根据orderId 返回 对应DiningTable对象, 如果为null, 说明该对象不存在
            DiningTable diningTable = diningTableService.getDiningTableById(orderId);
            if (diningTable == null) {//
                System.out.println("==============预订餐桌不存在============");
                return;
            }
            //判断该餐桌的状态是否 "空"
            if (!("空".equals(diningTable.getState()))) {//说明当前这个餐桌不是 "空" 状态
                System.out.println("==============该餐桌已经预定或者就餐中============");
                return;
            }

            //接收预定信息
            System.out.print("预定人的名字: ");
            String orderName = Utility.readString(50);
            System.out.print("预定人的电话: ");
            String orderTel = Utility.readString(50);

            //更新餐桌状态
            if (diningTableService.orderDiningTable(orderId, orderName, orderTel)) {
                System.out.println("==============预订餐桌成功============");
            } else {
                System.out.println("==============预订餐桌失败============");
            }

        } else {
            System.out.println("==============取消预订餐桌============");
        }

    }

    //显示所有餐桌状态
    public void listDiningTable() {
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
        System.out.println("==============显示完毕============");
    }

    //显示主菜单
    public void mainMenu() {

        while (loop) {

            System.out.println("\n===============满汉楼================");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.print("请输入你的选择: ");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("输入员工号: ");
                    String empId = Utility.readString(50);
                    System.out.print("输入密  码: ");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    if (employee != null) { //说明存在该用户
                        System.out.println("===============登录成功[" + employee.getName() + "]================\n");
                        //显示二级菜单, 这里二级菜单是循环操作，所以做成while
                        while (loop) {
                            System.out.println("\n===============满汉楼(二级菜单)================");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出满汉楼");
                            System.out.print("请输入你的选择: ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    listDiningTable();//显示餐桌状态
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    listMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    listBill();//显示所有账单
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("你的输入有误，请重新输入");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("===============登录失败================");
                    }
                    break;
                case "2":
                    loop = false;//
                    break;
                default:
                    System.out.println("你输入有误，请重新输入.");
            }
        }
        System.out.println("你退出了满汉楼系统~");
    }

}
```

src/druid.properties

```properties
#key=value
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/mhl?rewriteBatchedStatements=true
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

mhl.iml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<module type="JAVA_MODULE" version="4">
  <component name="NewModuleRootManager" inherit-compiler-output="true">
    <exclude-output />
    <content url="file://$MODULE_DIR$">
      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
    </content>
    <orderEntry type="inheritedJdk" />
    <orderEntry type="sourceFolder" forTests="false" />
    <orderEntry type="library" name="commons-dbutils-1.3" level="project" />
  </component>
</module>
```

### 多表查询思路

可以用MapListHandler实现：

https://www.pianshen.com/article/48341042440/

也可以另写MultiTabBean类，映射多个表，如上所示。