- [第24章 零基础学MySQL](#第24章-零基础学mysql)
	- [解决之道](#解决之道)
		- [文件、数据库](#文件数据库)
		- [MySQL 数据库的安装和配置](#mysql-数据库的安装和配置)
		- [使用命令行窗口连接MYSQL 数据库](#使用命令行窗口连接mysql-数据库)
		- [操作示意图](#操作示意图)
	- [数据库三层结构](#数据库三层结构)
	- [数据在数据库中的存储方式](#数据在数据库中的存储方式)
	- [SQL 语句分类](#sql-语句分类)
	- [创建数据库](#创建数据库)
	- [查看、删除数据库](#查看删除数据库)
	- [备份恢复数据库](#备份恢复数据库)
	- [备份恢复数据库的表](#备份恢复数据库的表)
	- [创建表](#创建表)
	- [Mysql 常用数据类型(列类型)](#mysql-常用数据类型列类型)
		- [数值型(整数)的基本使用](#数值型整数的基本使用)
		- [定义一个无符号的整数](#定义一个无符号的整数)
		- [数值型(bit)的使用](#数值型bit的使用)
		- [数值型(小数)的基本使用](#数值型小数的基本使用)
		- [字符串的基本使用](#字符串的基本使用)
		- [字符串使用细节](#字符串使用细节)
		- [日期类型的基本使用](#日期类型的基本使用)
	- [创建表练习](#创建表练习)
	- [修改表-基本介绍](#修改表-基本介绍)
	- [修改表-课堂练习](#修改表-课堂练习)
	- [数据库C[create]R[read]U[update]D[delete]语句](#数据库ccreaterreaduupdateddelete语句)
	- [Insert 语句](#insert-语句)
		- [使用INSERT 语句向表中插入数据。](#使用insert-语句向表中插入数据)
		- [细节说明](#细节说明)
	- [update 语句](#update-语句)
		- [使用 update 语句修改表中数据](#使用-update-语句修改表中数据)
		- [基本使用](#基本使用)
		- [使用细节](#使用细节)
	- [delete 语句](#delete-语句)
		- [使用delete 语句删除表中数据](#使用delete-语句删除表中数据)
		- [使用细节](#使用细节-1)
	- [select 语句](#select-语句)
		- [基本语法](#基本语法)
		- [注意事项(创建测试表学生表)](#注意事项创建测试表学生表)
		- [练习](#练习)
		- [使用表达式对查询的列进行运算](#使用表达式对查询的列进行运算)
		- [在select 语句中可使用as 语句](#在select-语句中可使用as-语句)
		- [练习](#练习-1)
		- [在where 子句中经常使用的运算符](#在where-子句中经常使用的运算符)
		- [使用where 子句，进行过滤查询](#使用where-子句进行过滤查询)
		- [使用order by 子句排序查询结果](#使用order-by-子句排序查询结果)
	- [合计/统计函数](#合计统计函数)
		- [count](#count)
		- [sum](#sum)
		- [avg](#avg)
		- [max/min](#maxmin)
		- [使用group by 子句对列进行分组](#使用group-by-子句对列进行分组)
		- [使用having 子句对分组后的结果进行过滤](#使用having-子句对分组后的结果进行过滤)
	- [字符串相关函数](#字符串相关函数)
	- [数学相关函数](#数学相关函数)
	- [时间日期相关函数](#时间日期相关函数)
	- [加密和系统函数](#加密和系统函数)
	- [流程控制函数](#流程控制函数)
	- [mysql 表查询--加强](#mysql-表查询--加强)
		- [介绍](#介绍)
		- [分页查询](#分页查询)
		- [使用分组函数和分组子句](#使用分组函数和分组子句)
		- [数据分组的总结](#数据分组的总结)
	- [mysql 多表查询](#mysql-多表查询)
		- [多表查询练习](#多表查询练习)
		- [自连接](#自连接)
	- [mysql 表子查询](#mysql-表子查询)
		- [什么是子查询](#什么是子查询)
		- [单行子查询](#单行子查询)
		- [多行子查询](#多行子查询)
		- [子查询当做临时表使用](#子查询当做临时表使用)
		- [在多行子查询中使用 all 操作符](#在多行子查询中使用-all-操作符)
		- [在多行子查询中使用 any 操作符](#在多行子查询中使用-any-操作符)
		- [多列子查询](#多列子查询)
		- [在from 子句中使用子查询](#在from-子句中使用子查询)
	- [表复制](#表复制)
		- [自我复制数据(蠕虫复制)](#自我复制数据蠕虫复制)
	- [合并查询](#合并查询)
		- [介绍](#介绍-1)
	- [mysql 表外连接](#mysql-表外连接)
		- [外连接](#外连接)
	- [mysql 约束](#mysql-约束)
		- [基本介绍](#基本介绍)
		- [primary key(主键)](#primary-key主键)
		- [not null(非空)](#not-null非空)
		- [unique(唯一)](#unique唯一)
		- [foreign key(外键)](#foreign-key外键)
		- [check](#check)
		- [商店售货系统表设计案例](#商店售货系统表设计案例)
	- [自增长](#自增长)
		- [自增长基本介绍](#自增长基本介绍)
		- [自增长使用细节](#自增长使用细节)
	- [mysql 索引](#mysql-索引)
		- [索引快速入门](#索引快速入门)
		- [索引的原理](#索引的原理)
		- [索引的类](#索引的类)
		- [索引使用](#索引使用)
		- [哪些列上适合使用索引](#哪些列上适合使用索引)
	- [mysql 事务](#mysql-事务)
		- [什么是事务](#什么是事务)
		- [事务和锁](#事务和锁)
		- [回退事务](#回退事务)
		- [提交事务](#提交事务)
		- [事务细节讨论](#事务细节讨论)
	- [mysql 事务隔离级别](#mysql-事务隔离级别)
		- [事务隔离级别介绍](#事务隔离级别介绍)
		- [查看事务隔离级别](#查看事务隔离级别)
		- [事务隔离级别](#事务隔离级别)
		- [mysql 的事务隔离级--案例](#mysql-的事务隔离级--案例)
		- [设置事务隔离级别](#设置事务隔离级别)
	- [mysql 事务ACID](#mysql-事务acid)
		- [事务的acid 特性](#事务的acid-特性)
	- [mysql 表类型和存储引擎](#mysql-表类型和存储引擎)
		- [基本介绍](#基本介绍-1)
		- [主要的存储引擎/表类型特点](#主要的存储引擎表类型特点)
		- [细节说明](#细节说明-1)
		- [三种存储引擎表使用案例](#三种存储引擎表使用案例)
		- [如何选择表的存储引擎](#如何选择表的存储引擎)
		- [修改存储引擎](#修改存储引擎)
	- [视图(view)](#视图view)
		- [看一个需求](#看一个需求)
		- [基本概念](#基本概念)
		- [视图的基本使用](#视图的基本使用)
		- [视图细节讨论](#视图细节讨论)
		- [视图最佳实践](#视图最佳实践)
		- [视图课堂练习](#视图课堂练习)
	- [Mysql 管理](#mysql-管理)
		- [Mysql 用户](#mysql-用户)
		- [创建用户](#创建用户)
		- [删除用户](#删除用户)
		- [用户修改密码](#用户修改密码)
		- [mysql 中的权限](#mysql-中的权限)
		- [给用户授权](#给用户授权)
		- [回收用户授权](#回收用户授权)
		- [权限生效指令](#权限生效指令)
		- [课堂练习题](#课堂练习题)
		- [细节说明](#细节说明-2)
	- [本章作业](#本章作业)


# 第24章 零基础学MySQL

## 解决之道

### 文件、数据库

为了解决上述问题,使用更加利于管理数据的东东-数据库，它能更有效的管理数据。

举一个生活化的案例说明：如果说图书馆是保存书籍的,那么数据库就是保存数据的。

### MySQL 数据库的安装和配置

mysql5.5 mysql5.6 mysqI5.7(稳定) mysql8 更高版本

### 使用命令行窗口连接MYSQL 数据库

1. mysql -h主机名-P端口-u用户名-p密码

2. 登录前，保证服务启动

   `net stop mysql服务名`

   `net start mysql服务名`

### 操作示意图

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510145557744.png)

+ Navicat

介绍: 图形化MySQL 管理软件

+ SQLyog

## 数据库三层结构

1. 所谓安装Mysql数据库，就是在主机安装一个数据库管理系统(DBMS)，这个管理程序可以管理多个数据库。DBMS(database manage system)。
2. 一个数据库中可以创建多个表,以保存数据(信息)。
3. 数据库管理系统(DBMS)、数据库和表的关系如图所示;示意图。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510152615349.png)

## 数据在数据库中的存储方式

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510152633583.png)

## SQL 语句分类

DDL:数据定义语句[create表，库...]

DML:数据操作语句[增加insert，修改update，删除 delete]

DQL:数据查询语句[select ]

DCL:数据控制语句[管理数据库: 比如用户权限 grant revoke ]

## 创建数据库

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510154330331.png)

1. CHARACTER SET:指定数据库采用的字符集，如果不指定字符集，默认utf8
1. COLLATE:指定数据库字符集的校对规则(常用的utf8 bin[区分大小写]
utf8_general_ci[不区分大小写] 注意默认是 utf8 general_ci )

```sql
# 演示数据库的操作
#创建一个名称为db01的数据库。[图形化和指令 演示]

#使用指令创建数据库
CREATE DATABASE db01;
#删除数据库指令
DROP DATABASE db01
#创建一个使用utf8字符集的hsp_db02数据库
CREATE DATABASE db02 CHARACTER SET utf8
#创建一个使用utf8字符集，并带校对规则的hsp_db03数据库
CREATE DATABASE db03 CHARACTER SET utf8 COLLATE utf8_bin
#校对规则 utf8_bin 区分大小 默认utf8_general_ci 不区分大小写

#下面是一条查询的sql , select 查询 * 表示所有字段 FROM 从哪个表
#WHERE 从哪个字段 NAME = 'tom' 查询名字是tom
SELECT *  
	FROM t1 
	WHERE NAME = 'tom'
```

## 查看、删除数据库

显示数据库语句:

```sql
SHOW DATABASES
```

显示数据库创建语句:

```sql
SHOW CREATE DATABASE db_name
```

数据库删除语句[一定要慎用]:

```sql
DROP DATABASE [IF EXISTS] db_ name
```

```sql
#演示删除和查询数据库
#查看当前数据库服务器中的所有数据库
SHOW DATABASES
#查看前面创建的hsp_db01数据库的定义信息
SHOW CREATE DATABASE `hsp_db01`
#在创建数据库,表的时候，为了规避关键字，可以使用反引号解决，比如有数据库的名称就叫做CREATE，那么就需要使用` `解决。

#删除前面创建的hsp_db01数据库
DROP DATABASE hsp_db01
```

## 备份恢复数据库

备份数据库(注意:在DOS执行)命令行

```sql
mysqldump -u 用户名 -p -B 数据库1 数据库2 数据库n >文件名.sql
```

恢复数据库(注意:进入Mysql命令行再执行)

```sql
Source 文件名.sql
```

```sql
#练习 : database03.sql 备份db02 和 db03 库中的数据，并恢复

#备份, 要在Dos下执行mysqldump指令其实在mysql安装目录\bin
#这个备份的文件，就是对应的sql语句
mysqldump -u root -p -B db02 db03 > d:\\bak.sql

DROP DATABASE ecshop;

#恢复数据库(注意：进入Mysql命令行再执行)
source d:\\bak.sql
#第二个恢复方法， 直接将bak.sql的内容放到查询编辑器中，执行，相当于重新执行了一遍
```

## 备份恢复数据库的表

备份库的表

```sql
mysqldump -u 用户名 -p密码 数据库 表1 表2 表n > d:\\文件名.sql
```

## 创建表

```sql
CREATE TABLE table_name
(
	field1 datatype,
    field2 datatype,
    field3 datatype
)character set 字符集 collate 校对规则 engine 存储引擎
```

+ field:指定列名 datatype:指定列类型(字段类型)
+ character set:如不指定则为所在数据库字符集
+ collate:如不指定则为所在数据库校对规则
+ engine:引擎(这个涉及内容较多)

```sql
#指令创建表
#注意：db02创建表时，要根据需保存的数据创建相应的列，并根据数据的类型定义相应的列类型。例：user表 (快速入门案例 create_tab01.sql)
#id        	整形               [图形化，指令]                
#name 		字符串
#password 	字符串
#birthday 	日期
CREATE TABLE `user` (
	id INT, 
	`name` VARCHAR(255),
	`password` VARCHAR(255), 
	`birthday` DATE)
	CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB;
```

## Mysql 常用数据类型(列类型)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510161256415.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510161237452.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510160526290.png)

### 数值型(整数)的基本使用

```sql
#演示整型的是一个
#使用tinyint 来演示范围 有符号 -128 ~ 127  如果没有符号 0-255
#说明： 表的字符集，校验规则, 存储引擎，老师使用默认
#1. 如果没有指定 unsinged , 则TINYINT就是有符号
#2. 如果指定 unsinged , 则TINYINT就是无符号 0-255
CREATE TABLE t3 (
	id TINYINT);
CREATE TABLE t4 (
	id TINYINT UNSIGNED);
	
INSERT INTO t3 VALUES(127); #这是非常简单的添加语句
SELECT * FROM t3

INSERT INTO t4 VALUES(255);
SELECT * FROM t4;
```

### 定义一个无符号的整数

```sql
create table t10 (id tinyint );//默认是有符号的
create table t11 (id tinyint unsigned);//无符号的 （后加unsigned就行）
```

### 数值型(bit)的使用

1.基本使用

```sql
mysql > create table t05 (num bit(8));
mysql > insert into t05 (1, 3);
mysql > insert into t05 values(2, 65);
```

2.细节说明bit.sql

+ bit字段显示时，按照位的方式显示.
+ 查询的时候仍然可以用使用添加的数值
+ 如果一个值只有0，1可以考虑使用bit(1), 可以节约空间
+ 位类型。M指定位数，默认值1，范围1-64

```sql
#演示bit类型使用
#说明
#1. bit(m) m 在 1-64
#2. 添加数据 范围 按照你给的位数来确定，比如 m = 8 表示一个字节 0~255
#3. 显示按照bit 
#4. 查询时，仍然可以按照数来查询
CREATE TABLE t05 (num BIT(8));
INSERT INTO t05 VALUES(255); # 按位显示 255 就是全1 （b'11111111'）
SELECT * FROM t05;
SELECT * FROM t05 WHERE num = 1;
```

### 数值型(小数)的基本使用

1. FLOAT/**DOUBLE** [UNSIGNED]

   Float单精度精度，Double双精度.

2. **DECIMAL**[M,D] [UNSIGNED]

+ 可以支持更加精确的小数位。M是小数位数(精度)的总数，D是小数点(标度)后面的位数。
+ 如果D是0，则值没有小数点或分数部分。M最大65。D最大是30。如果D被省略,默认是0。如果M被省略,默认是10。
+ 建议:如果希望小数的精度高，推荐使用decimal

```sql
#演示decimal类型、float、double使用

#创建表
CREATE TABLE t06 (
	num1 FLOAT,
	num2 DOUBLE,
	num3 DECIMAL(30,20));
#添加数据
INSERT INTO t06 VALUES(88.12345678912345, 88.12345678912345,88.12345678912345);
SELECT * FROM t06;

#decimal可以存放很大的数
CREATE TABLE t07 (
	num DECIMAL(65));
INSERT INTO t07 VALUES(8999999933338388388383838838383009338388383838383838383);

SELECT * FROM t07;
CREATE TABLE t08(
	num BIGINT UNSIGNED)
INSERT INTO t08 VALUES(8999999933338388388383838838383009338388383838383838383);
SELECT * FROM t08;
```

### 字符串的基本使用

CHAR(size)

固定长度字符串最大255**字符**

VARCHAR(size)0~65535

可变长度字符串最大65532**字节**【utf8编码最大21844字符（（65535-3） / 3）其中1-3个字节用于记录大小】

```sql
#演示字符串类型使用char varchar
#注释的快捷键 shift+ctrl+c , 注销注释 shift+ctrl+r
-- CHAR(size)
-- 固定长度字符串 最大255 字符 
-- VARCHAR(size)    0~65535字节
-- 可变长度字符串 最大65532字节  【utf8编码最大21844字符 1-3个字节用于记录大小】
-- 如果表的编码是 utf8 varchar(size) size = (65535-3) / 3 = 21844
-- 如果表的编码是 gbk varchar(size) size = (65535-3) / 2 = 32766
CREATE TABLE t09 (
	`name` CHAR(255));

CREATE TABLE t10 (
	`name` VARCHAR(32766)) CHARSET gbk;

DROP TABLE t10;
```

### 字符串使用细节

1.细节1

+ char(4) //这个4表示字符数(最大255)，不是字节数,不管是中文还是字母都是放四个,按字符计算.
+ varchar(4) //这个4表示字符数，不管是字母还是中文都以定义好的表的编码来存放数据
+ 不管是中文还是英文字母，都是最多存放4个，是按照字符来存放的.

2.细节2

+ char(4)是定长(固定的大小)，就是说，即使你插入'aa'，也会占用分配的4个字符的空间.
+ varchar(4)是变长(变化的大小)，就是说，如果你插入了'aa',实际占用空间大小并不是4个字符，而是按照实际占用空间来分配(说明:varchar本身还需要占用1-3个字节来记录存放内容长度)    `L(实际数据大小)+(1-3)字节`

3.细节3

什么时候使用char，什么时候使用varchar

1. 如果数据是定长,推荐使用char,比如md5的密码,邮编,手机号,身份证号码等. char(32)
2. 如果一个字段的长度是不确定,我们使用varchar ,比如留言,文章
   查询速度: char > varchar

4.细节4

在存放文本时，也可以使用Text数据类型。可以将TEXT列视为VARCHAR列，注意Text 不能有默认值。大小0-2^16字节。如果希望存放更多字符，可以选择
MEDIUMTEXT 0O-2^24 或者LONGTEXT 0~2^32

```sql
#演示字符串类型的使用细节
#char(4) 和 varchar(4) 这个4表示的是字符，而不是字节, 不区分字符是汉字还是字母
CREATE TABLE t11(
	`name` CHAR(4));
INSERT INTO t11 VALUES('你好你好');

SELECT * FROM t11;

CREATE TABLE t12(
	`name` VARCHAR(4));
INSERT INTO t12 VALUES('你好你好');
INSERT INTO t12 VALUES('ab北京');
SELECT * FROM t12;

#如果varchar 不够用，可以考试使用mediumtext 或者longtext, 
#如果想简单点，可以使用直接使用text
CREATE TABLE t13( content TEXT, content2 MEDIUMTEXT , content3 LONGTEXT);
INSERT INTO t13 VALUES('你好你教育', '你好你教育100', '你好你教育1000~~');
SELECT * FROM t13;
```

### 日期类型的基本使用

```sql
CREATE TABLE birthday6( t1 DATE, t2 DATETIME,
t3 TIMESTAMP NOT NULL DEFAULTCURRENT TIMESTAMP ON UPDATE
CURRENT TIMESTAMP ); timestamp时间戳
# NOT NULL DEFAULTCURRENT TIMESTAMP ON UPDATE CURRENT TIMESTAMP 意思是没有默认值的话会根据当前时间自动更新
```

```sql
mysql> INSERT INTO birthday (t1,t2)
VALUES('2022-11-11',2022-11-11 10:10:10');
```

日期类型的细节说明

TimeStamp在Insert和update时，自动更新。

```sql
#演示时间相关的类型
#创建一张表, date , datetime , timestamp
CREATE TABLE t14 (
	birthday DATE , -- 生日
	job_time DATETIME, -- 记录年月日 时分秒
	login_time TIMESTAMP 
		NOT NULL DEFAULT CURRENT_TIMESTAMP 
		ON UPDATE CURRENT_TIMESTAMP); -- 登录时间, 如果希望login_time列自动更新, 需要配置
		
SELECT * FROM t14;
INSERT INTO t14(birthday, job_time) 
	VALUES('2022-11-11','2022-11-11 10:10:10');
-- 如果我们更新 t14 表的某条记录，login_time列会自动的以当前时间进行更新
```

## 创建表练习

```sql
#创建表的课堂练习
-- 字段	属性
-- Id	整形
-- name	字符型
-- sex	字符型
-- brithday	日期型（date）
-- entry_date	日期型   (date)
-- job	字符型
-- Salary	小数型
-- resume	文本型
-- 自己一定要练习一把
CREATE TABLE `emp` (
	id INT,
	`name` VARCHAR(32),
	sex CHAR(1), 
	brithday DATE,
	entry_date DATETIME,
	job VARCHAR(32),
	salary DOUBLE,
	`resume` TEXT) CHARSET utf8 COLLATE utf8_bin ENGINE INNODB;
-- 添加一条
INSERT INTO `emp`
	VALUES(100, '小妖怪', '男', '2000-11-11', 
		'2010-11-10 11:11:11', '巡山的', 3000, '大王叫我来巡山');
		
SELECT * FROM `emp`;
```

## 修改表-基本介绍

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510181117973.png)

## 修改表-课堂练习

`NOT NULL DEFAULT ''` 不允许为空NULL，默认是一个空的' '字符。

```sql
#修改表的操作练习
--  员工表emp的上增加一个image列，varchar类型(要求在resume后面)。
ALTER TABLE emp 
	ADD image VARCHAR(32) NOT NULL DEFAULT '' 
	AFTER RESUME
DESC employee -- 显示表结构，可以查看表的所有列
--  修改job列，使其长度为60。
ALTER TABLE emp
	MODIFY job VARCHAR(60) NOT NULL DEFAULT ''
--  删除sex列。
ALTER TABLE emp
	DROP sex
--  表名改为employee。
RENAME TABLE emp TO employee
--  修改表的字符集为utf8 
ALTER TABLE employee CHARACTER SET utf8
--  列名name修改为us	er_name
ALTER TABLE employee 
	CHANGE `name` `user_name` VARCHAR(64) NOT NULL DEFAULT ''
DESC employee
```

## 数据库C[create]R[read]U[update]D[delete]语句

1. Insert语句 (添加数据)
2. Update语句 (更新数据）
3. Delete语句 (删除数据)
4. Select语句 (查找数据)

## Insert 语句

### 使用INSERT 语句向表中插入数据。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510182710186.png)

```sql
#练习insert 语句
-- 创建一张商品表goods (id  int , goods_name varchar(10), price double );
-- 添加2条记录
CREATE TABLE `goods` (
	id INT ,
	goods_name VARCHAR(10), -- 长度10
	price DOUBLE NOT NULL DEFAULT 100 );
-- 添加数据
INSERT INTO `goods` (id, goods_name, price) 
	VALUES(10, '华为手机', 2000);
INSERT INTO `goods` (id, goods_name, price) 
	VALUES(20, '苹果手机', 3000);
SELECT * FROM goods;

CREATE TABLE `goods2` (
	id INT ,
	goods_name VARCHAR(10), -- 长度10
	price DOUBLE NOT NULL DEFAULT 100 );
```

### 细节说明

```sql
#说明insert 语句的细节
-- 1.插入的数据应与字段的数据类型相同。
--       比如 把 'abc' 添加到 int 类型会错误
INSERT INTO `goods` (id, goods_name, price) 
	VALUES('abc', '小米手机', 2000);
-- 2. 数据的长度应在列的规定范围内，例如：不能将一个长度为80的字符串加入到长度为40的列中。
INSERT INTO `goods` (id, goods_name, price) 
	VALUES(40, 'vovo手机vovo手机vovo手机vovo手机vovo手机', 3000);
-- 3. 在values中列出的数据位置必须与被加入的列的排列位置相对应。
INSERT INTO `goods` (id, goods_name, price)  -- 不对
	VALUES('vovo手机',40, 2000);
-- 4. 字符和日期型数据应包含在单引号中。
INSERT INTO `goods` (id, goods_name, price) 
	VALUES(40, vovo手机, 3000); -- 错误的 vovo手机 应该 'vovo手机'
-- 5. 列可以插入空值[前提是该字段允许为空（如果指定 not null 则不可以）]，insert into table value(null)
INSERT INTO `goods` (id, goods_name, price) 
	VALUES(40, 'vovo手机', NULL);
-- 6. insert into tab_name (列名..)  values (),(),()  形式添加多条记录
INSERT INTO `goods` (id, goods_name, price) 
	VALUES(50, '三星手机', 2300),(60, '海尔手机', 1800);
-- 7. 如果是给表中的所有字段添加数据，可以不写前面的字段名称
INSERT INTO `goods`   
	VALUES(70, 'IBM手机', 5000);
-- 8. 默认值的使用，当不给某个字段值时，如果有默认值就会添加默认值，否则报错
      -- 如果某个列 没有指定 not null ,那么当添加数据时，没有给定值，则会默认给null
      -- 如果我们希望指定某个列的默认值，可以在创建表时指定
INSERT INTO `goods` (id, goods_name)   
	VALUES(80, '格力手机');

SELECT * FROM goods;

INSERT INTO `goods2` (id, goods_name)   
	VALUES(10, '顺平手机');
SELECT * FROM goods2;
```

## update 语句

### 使用 update 语句修改表中数据

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510183440814.png)

### 基本使用

```sql
-- 演示update语句
-- 要求: 在上面创建的employee表中修改表中的纪录
-- 1. 将所有员工薪水修改为5000元。[如果没有带where 条件，会修改所有的记录，因此要小心]
UPDATE employee SET salary = 5000 
-- 2. 将姓名为 小妖怪 的员工薪水修改为3000元。
UPDATE employee 
	SET salary = 3000 
	WHERE user_name = '小妖怪' 
-- 3. 将 老妖怪 的薪水在原有基础上增加1000元
INSERT INTO employee 
	VALUES(200, '老妖怪', '1990-11-11', '2000-11-11 10:10:10', '捶背的', 5000, '给大王捶背', 'd:\\a.jpg');

UPDATE employee 
	SET salary = salary + 1000 
	WHERE user_name = '老妖怪' 

-- 可以修改多个列的值
UPDATE employee 
	SET salary = salary + 1000 , job = '出主意的'
	WHERE user_name = '老妖怪' 
SELECT * FROM employee;
```

### 使用细节

1. WHERE子句指定应更新哪些行。如没有WHERE子句，则更新所有的行(记录)。
2. 如果需要修改多个字段，可以通过 `set 字段1=值1,字段2=值2...`

## delete 语句

### 使用delete 语句删除表中数据

删除只能按照行删除，不能按照列删除。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510183939705.png)

```sql
-- delete 语句演示

--  删除表中名称为’老妖怪’的记录。
DELETE FROM employee 
	WHERE user_name = '老妖怪';
--  删除表中所有记录, 老师提醒，一定要小心
DELETE FROM employee;

-- Delete语句不能删除某一列的值（可使用update 设为 null 或者 ''）
UPDATE employee SET job = '' WHERE user_name = '老妖怪';

SELECT * FROM employee

-- 要删除这个表
DROP TABLE employee;
```

### 使用细节

+ 如果不使用where子句，将删除表中所有数据。
+ Delete语句不能删除某一列的值(可使用update设为null 或者"")
+ 使用delete语句删除记录,不删除表本身。如要删除表，使用droptable语句。`drop table 表名`;

## select 语句

### 基本语法

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510184317107.png)

### 注意事项(创建测试表学生表)

1. Select 指定查询哪些列的数据。
2. column指定列名。
3. *号代表查询所有列。
4. From指定查询哪张表。
5. DISTINCT可选, 指显示结果时，是否去掉重复数据。

### 练习

```sql
-- select 语句【重点 难点】
CREATE TABLE student(
	id INT NOT NULL DEFAULT 1,
	NAME VARCHAR(20) NOT NULL DEFAULT '',
	chinese FLOAT NOT NULL DEFAULT 0.0,
	english FLOAT NOT NULL DEFAULT 0.0,
	math FLOAT NOT NULL DEFAULT 0.0
);

INSERT INTO student(id,NAME,chinese,english,math) VALUES(1,'韩顺平',89,78,90);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(2,'张飞',67,98,56);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(3,'宋江',87,78,77);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(4,'关羽',88,98,90);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(5,'赵云',82,84,67);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(6,'欧阳锋',55,85,45);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(7,'黄蓉',75,65,30);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(8,'韩信',45,65,99);

SELECT * FROM student;

-- 查询表中所有学生的信息。
SELECT * FROM student;
-- 查询表中所有学生的姓名和对应的英语成绩。
SELECT `name`,english FROM student;
-- 过滤表中重复数据 distinct 。
SELECT DISTINCT english FROM student;
-- 要查询的记录，每个字段都相同，才会去重
SELECT DISTINCT `name`, english FROM student;
```

### 使用表达式对查询的列进行运算

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510184735007.png)

### 在select 语句中可使用as 语句

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510184752011.png)

### 练习

```sql
-- select 语句的使用

-- 统计每个学生的总分
SELECT `name`, (chinese+english+math) FROM student;
-- 在所有学生总分加10分的情况
SELECT `name`, (chinese + english + math + 10) FROM student;
-- 使用别名表示学生分数。
SELECT `name` AS '名字', (chinese + english + math + 10) AS total_score 
	FROM student;
```

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230510184934313.png)

### 在where 子句中经常使用的运算符

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511095419843.png)

其中的BETWEEN ... AND 是闭区间。

### 使用where 子句，进行过滤查询

+ `_`：匹配任意一个字符；
+ `%`：匹配0个或多个字符；
+ `[ ]`：匹配[ ]中的任意一个字符(若要比较的字符是连续的，则可以用连字符“-”表 达 )；
+ `[^ ]`：不匹配[ ]中的任意一个字符。

```sql
-- select 语句
-- 查询姓名为赵云的学生成绩
SELECT * FROM student 
	WHERE `name` = '赵云'
-- 查询英语成绩大于90分的同学
SELECT * FROM student 
	WHERE english > 90
-- 查询总分大于200分的所有同学

SELECT * FROM student 
	WHERE (chinese + english + math) > 200
	
-- 查询math大于60 并且(and) id大于4的学生成绩
SELECT * FROM student
	WHERE math >60 AND id > 4
-- 查询英语成绩大于语文成绩的同学
SELECT * FROM student
	WHERE english > chinese
-- 查询总分大于200分 并且 数学成绩小于语文成绩,的姓赵的学生.
-- 赵% 表示 名字以赵开头的就可以
SELECT * FROM student
	WHERE (chinese + english + math) > 200 AND 
		math < chinese AND `name` LIKE '赵%'
-- 查询英语分数在 80－90之间的同学。
SELECT * FROM student
	WHERE english >= 80 AND english <= 90;
SELECT * FROM student
	WHERE english BETWEEN 80 AND 90; -- between .. and .. 是 闭区间
-- 查询数学分数为89,90,91的同学。
SELECT * FROM student 
	WHERE math = 89 OR math = 90 OR math = 91;
SELECT * FROM student 
	WHERE math IN (89, 90, 91);
-- 查询所有姓李的学生成绩。
SELECT * FROM student 
	WHERE `name` LIKE '韩%'
-- 查询数学分>80，语文分>80的同学
```

### 使用order by 子句排序查询结果

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511100957298.png)

1. Order by 指定排序的列，排序的列既可以是表中的列名，也可以是select
语句后指定的列名。
2. Asc升序[默认]、Desc降序
3. ORDER BY子句应位于SELECT语句的结尾。

```sql
-- 演示order by使用
-- 对数学成绩排序后输出【升序】。
SELECT * FROM student 
	ORDER BY math;
-- 对总分按从高到低的顺序输出 [降序] -- 使用别名排序
SELECT `name` , (chinese + english + math) AS total_score FROM student 
	ORDER BY total_score DESC;
-- 对姓韩的学生成绩[总分]排序输出(升序) where + order by
SELECT `name`, (chinese + english + math) AS total_score FROM student
	WHERE `name` LIKE '韩%'
	ORDER BY total_score;
```

## 合计/统计函数

### count

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511112333116.png)

```sql
-- 演示mysql的统计函数的使用
-- 统计一个班级共有多少学生？
SELECT COUNT(*) FROM student;
-- 统计数学成绩大于90的学生有多少个？
SELECT COUNT(*) FROM student
	WHERE math > 90
-- 统计总分大于250的人数有多少？
SELECT COUNT(*) FROM student
	WHERE (math + english + chinese) > 250
-- count(*) 和 count(列) 的区别 
-- 解释 :count(*) 返回满足条件的记录的行数
-- count(列): 统计满足条件的某列有多少个，但是会排除 为null的情况
CREATE TABLE t15 (
	`name` VARCHAR(20));
INSERT INTO t15 VALUES('tom');
INSERT INTO t15 VALUES('jack');
INSERT INTO t15 VALUES('mary');
INSERT INTO t15 VALUES(NULL);
SELECT * FROM t15;

SELECT COUNT(*) FROM t15; -- 4
SELECT COUNT(`name`) FROM t15;-- 3


-- 演示sum函数的使用
-- 统计一个班级数学总成绩？
SELECT SUM(math) FROM student;
-- 统计一个班级语文、英语、数学各科的总成绩
SELECT SUM(math) AS math_total_score,SUM(english),SUM(chinese) FROM student;
-- 统计一个班级语文、英语、数学的成绩总和
SELECT SUM(math + english + chinese) FROM student;
-- 统计一个班级语文成绩平均分
SELECT SUM(chinese)/ COUNT(*)  FROM student;
SELECT SUM(`name`) FROM student;

-- 演示avg的使用
-- 练习：
-- 求一个班级数学平均分？
SELECT AVG(math) FROM student;
-- 求一个班级总分平均分
SELECT AVG(math + english + chinese) FROM student;

-- 演示max 和 min的使用
-- 求班级最高分和最低分（数值范围在统计中特别有用）
SELECT MAX(math + english + chinese), MIN(math + english + chinese) 
	FROM student;

-- 求出班级数学最高分和最低分
SELECT MAX(math) AS math_high_socre, MIN(math)  AS math_low_socre
	FROM student;
```

### sum

Sum函数返回满足where条件的行的和 一般使用在数值列。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511113225150.png)

### avg

AVG函数返回满足where条件的一列的平均值

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511113429717.png)

### max/min

Max/min函数返回满足where条件的一列的最大/最小值

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511113454286.png)

### 使用group by 子句对列进行分组

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511113541638.png)

### 使用having 子句对分组后的结果进行过滤

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511113602047.png)

group by 用于对查询的结果分组统计,(示意图)

having 子句用于限制分组显示结果

```sql
CREATE TABLE dept( /*部门表*/
deptno MEDIUMINT   UNSIGNED  NOT NULL  DEFAULT 0, 
dname VARCHAR(20)  NOT NULL  DEFAULT "",
loc VARCHAR(13) NOT NULL DEFAULT ""
);

INSERT INTO dept VALUES(10, 'ACCOUNTING', 'NEW YORK'), 
(20, 'RESEARCH', 'DALLAS'), 
(30, 'SALES', 'CHICAGO'), 
(40, 'OPERATIONS', 'BOSTON');

SELECT * FROM dept;

-- 员工表

CREATE TABLE emp
(empno  MEDIUMINT UNSIGNED  NOT NULL  DEFAULT 0, /*编号*/
ename VARCHAR(20) NOT NULL DEFAULT "", /*名字*/
job VARCHAR(9) NOT NULL DEFAULT "",/*工作*/
mgr MEDIUMINT UNSIGNED ,/*上级编号*/
hiredate DATE NOT NULL,/*入职时间*/
sal DECIMAL(7,2)  NOT NULL,/*薪水*/
comm DECIMAL(7,2) ,/*红利 奖金*/
deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0 /*部门编号*/
);

-- 添加测试数据
 INSERT INTO emp VALUES(7369, 'SMITH', 'CLERK', 7902, '1990-12-17', 800.00,NULL , 20), 
(7499, 'ALLEN', 'SALESMAN', 7698, '1991-2-20', 1600.00, 300.00, 30),  
(7521, 'WARD', 'SALESMAN', 7698, '1991-2-22', 1250.00, 500.00, 30),  
(7566, 'JONES', 'MANAGER', 7839, '1991-4-2', 2975.00,NULL,20),  
(7654, 'MARTIN', 'SALESMAN', 7698, '1991-9-28',1250.00,1400.00,30),  
(7698, 'BLAKE','MANAGER', 7839,'1991-5-1', 2850.00,NULL,30),  
(7782, 'CLARK','MANAGER', 7839, '1991-6-9',2450.00,NULL,10),  
(7788, 'SCOTT','ANALYST',7566, '1997-4-19',3000.00,NULL,20),  
(7839, 'KING','PRESIDENT',NULL,'1991-11-17',5000.00,NULL,10),  
(7844, 'TURNER', 'SALESMAN',7698, '1991-9-8', 1500.00, NULL,30),  
(7900, 'JAMES','CLERK',7698, '1991-12-3',950.00,NULL,30),  
(7902, 'FORD', 'ANALYST',7566,'1991-12-3',3000.00, NULL,20),  
(7934,'MILLER','CLERK',7782,'1992-1-23', 1300.00, NULL,10);

SELECT * FROM emp;

-- 工资级别
#工资级别表
CREATE TABLE salgrade
(
grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0, /*工资级别*/ 
losal DECIMAL(17,2)  NOT NULL, /* 该级别的最低工资 */
hisal DECIMAL(17,2)  NOT NULL /* 该级别的最高工资*/
);

INSERT INTO salgrade VALUES (1,700,1200);
INSERT INTO salgrade VALUES (2,1201,1400);
INSERT INTO salgrade VALUES (3,1401,2000);
INSERT INTO salgrade VALUES (4,2001,3000);
INSERT INTO salgrade VALUES (5,3001,9999);

SELECT * FROM salgrade;
SELECT * FROM dept;
SELECT * FROM emp;

# 演示group by + having
GROUP by用于对查询的结果分组统计, (示意图)
-- having子句用于限制分组显示结果.
-- ?如何显示每个部门的平均工资和最高工资
-- 老韩分析: avg(sal) max(sal)
-- 按照部分来分组查询
SELECT AVG(sal), MAX(sal) , deptno 
	FROM  emp GROUP BY deptno; 
-- 使用数学方法，对小数点进行处理
SELECT FORMAT(AVG(sal),2), MAX(sal) , deptno 
	FROM  emp GROUP BY deptno; 

-- ?显示每个部门的每种岗位的平均工资和最低工资
-- 老师分析 1. 显示每个部门的平均工资和最低工资
--          2. 显示每个部门的每种岗位的平均工资和最低工资
SELECT AVG(sal), MIN(sal) , deptno, job 
	FROM  emp GROUP BY deptno, job; 

-- ?显示平均工资低于2000的部门号和它的平均工资 // 别名

-- 老师分析 [写sql语句的思路是化繁为简,各个击破]
-- 1. 显示各个部门的平均工资和部门号
-- 2. 在1的结果基础上，进行过滤，保留 AVG(sal) < 2000
-- 3. 使用别名进行过滤 

SELECT AVG(sal), deptno 
	FROM emp GROUP BY deptno
		HAVING AVG(sal) < 2000;
-- 使用别名		
SELECT AVG(sal) AS avg_sal, deptno 
	FROM emp GROUP BY deptno
		HAVING avg_sal < 2000;	
```

## 字符串相关函数

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511115506366.png)

```sql
-- 演示字符串相关函数的使用  ， 使用emp表来演示
-- CHARSET(str)	返回字串字符集
SELECT CHARSET(ename) FROM emp;
-- CONCAT (string2  [,... ])	连接字串, 将多个列拼接成一列
SELECT CONCAT(ename, ' 工作是 ', job) FROM emp;

-- INSTR (string ,substring )	返回substring在string中出现的位置,没有返回0
-- dual 亚元表, 系统表 可以作为测试表使用
SELECT INSTR('hanshunping', 'ping') FROM DUAL; 

-- UCASE (string2 )	转换成大写
SELECT UCASE(ename) FROM emp;

-- LCASE (string2 )	转换成小写

SELECT LCASE(ename) FROM emp;
-- LEFT (string2 ,length )	从string2中的左边起取length个字符
-- RIGHT (string2 ,length )	从string2中的右边起取length个字符
SELECT LEFT(ename, 2) FROM emp;

-- LENGTH (string )	string长度[按照字节]
SELECT LENGTH(ename) FROM emp;
-- REPLACE (str ,search_str ,replace_str ) 	
-- 在str中用 replace_str 替换 search_str
-- 如果是 manager 就替换成 经理
SELECT ename, REPLACE(job,'MANAGER', '经理')  FROM emp;

-- STRCMP (string1 ,string2 )	逐字符比较两字串大小
SELECT STRCMP('hsp', 'hsp') FROM DUAL;
-- SUBSTRING (str , position  [,length ])	
-- 从str的position开始【从1开始计算】,取length个字符
-- 从ename 列的第一个位置开始取出2个字符
SELECT SUBSTRING(ename, 1, 2) FROM emp;

-- LTRIM (string2 ) RTRIM (string2 )  TRIM(string)
-- 去除前端空格或后端空格
SELECT LTRIM('  韩顺平教育') FROM DUAL;
SELECT RTRIM('韩顺平教育   ') FROM DUAL;
SELECT TRIM('    韩顺平教育   ') FROM DUAL;

-- 练习: 以首字母小写的方式显示所有员工emp表的姓名
-- 方法1 
-- 思路先取出ename 的第一个字符，转成小写的
-- 把他和后面的字符串进行拼接输出即可

SELECT CONCAT(LCASE(SUBSTRING(ename,1,1)),  SUBSTRING(ename,2)) AS new_name
	FROM emp;  

SELECT CONCAT(LCASE(LEFT(ename,1)),  SUBSTRING(ename,2)) AS new_name
	FROM emp; 
```

## 数学相关函数

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511165033825.png)

`rand()` 返回一个随机浮点值v,范围在0到1之间(即,其范围为0<=v<=1.0)。若已指定一个整数参数N, 则它被用作种子值,用来产生重复序列。

```sql
-- 演示数学相关函数

-- ABS(num)	绝对值
SELECT ABS(-10) FROM DUAL;
-- BIN (decimal_number )十进制转二进制
SELECT BIN(10) FROM DUAL;
-- CEILING (number2 )	向上取整, 得到比num2 大的最小整数
SELECT CEILING(-1.1) FROM DUAL;

-- CONV(number2,from_base,to_base)	进制转换
-- 下面的含义是 8 是十进制的8, 转成 2进制输出
SELECT CONV(8, 10, 2) FROM DUAL;
-- 下面的含义是 8 是16进制的8, 转成 2进制输出
SELECT CONV(16, 16, 10) FROM DUAL;

-- FLOOR (number2)	向下取整,得到比 num2 小的最大整数
SELECT FLOOR(-1.1) FROM DUAL;

-- FORMAT (number,decimal_places )	保留小数位数(四舍五入)
SELECT FORMAT(78.125458,2) FROM DUAL;

-- HEX (DecimalNumber )	转十六进制

-- LEAST (number , number2  [,..])	求最小值
SELECT LEAST(0,1, -10, 4) FROM DUAL;
-- MOD (numerator ,denominator )	求余
SELECT MOD(10, 3) FROM DUAL;

-- RAND([seed])	RAND([seed]) 返回随机数 其范围为 0 ≤ v ≤ 1.0
-- 1. 如果使用 rand() 每次返回不同的随机数 ，在 0 ≤ v ≤ 1.0
-- 2. 如果使用 rand(seed) 返回随机数, 范围 0 ≤ v ≤ 1.0, 如果seed不变，该随机数也不变了
SELECT RAND() FROM DUAL;

SELECT CURRENT_TIMESTAMP() FROM DUAL;
```

## 时间日期相关函数

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511205337746.png)

```sql
-- 日期时间相关函数

-- CURRENT_DATE (  )	当前日期
SELECT CURRENT_DATE() FROM DUAL;
-- CURRENT_TIME (  )	当前时间
SELECT CURRENT_TIME()  FROM DUAL;
-- CURRENT_TIMESTAMP (  ) 当前时间戳
SELECT CURRENT_TIMESTAMP()  FROM DUAL;

-- 创建测试表 信息表
CREATE TABLE mes(
	id INT , 
	content VARCHAR(30), 
	send_time DATETIME);
	
	
-- 添加一条记录
INSERT INTO mes 
	VALUES(1, '北京新闻', CURRENT_TIMESTAMP()); 
INSERT INTO mes VALUES(2, '上海新闻', NOW());
INSERT INTO mes VALUES(3, '广州新闻', NOW());

SELECT * FROM mes;
SELECT NOW() FROM DUAL;

-- 上应用实例
-- 显示所有新闻信息，发布日期只显示 日期，不用显示时间.
SELECT id, content, DATE(send_time) 
	FROM mes;
-- 请查询在10分钟内发布的新闻, 思路一定要梳理一下.
SELECT * 
	FROM mes
	WHERE DATE_ADD(send_time, INTERVAL 10 MINUTE) >= NOW()

SELECT * 
	FROM mes
	WHERE send_time >= DATE_SUB(NOW(), INTERVAL 10 MINUTE) 

-- 请在mysql 的sql语句中求出 2011-11-11 和 1990-1-1 相差多少天
SELECT DATEDIFF('2011-11-11', '1990-01-01') FROM DUAL;
-- 请用mysql 的sql语句求出你活了多少天? [练习] 1986-11-11 出生
SELECT DATEDIFF(NOW(), '1986-11-11') FROM DUAL;
-- 如果你能活80岁，求出你还能活多少天.[练习] 1986-11-11 出生
-- 先求出活80岁 时, 是什么日期 X
-- 然后在使用 datediff(x, now()); 1986-11-11->datetime
-- INTERVAL 80 YEAR ： YEAR 可以是 年月日，时分秒
-- '1986-11-11' 可以date,datetime timestamp 
SELECT DATEDIFF(DATE_ADD('1986-11-11', INTERVAL 80 YEAR), NOW()) 
	FROM DUAL;
	
SELECT TIMEDIFF('10:11:11', '06:10:10') FROM DUAL;

-- YEAR|Month|DAY|DATE (datetime)
SELECT YEAR(NOW()) FROM DUAL;
SELECT MONTH(NOW()) FROM DUAL;
SELECT DAY(NOW()) FROM DUAL;
SELECT MONTH('2013-11-10') FROM DUAL;
-- unix_timestamp() : 返回的是1970-1-1 到现在的秒数
SELECT UNIX_TIMESTAMP() FROM DUAL;
-- FROM_UNIXTIME() : 可以把一个unix_timestamp 秒数[时间戳]，转成指定格式的日期
-- %Y-%m-%d 格式是规定好的，表示年月日
-- 意义：在开发中，可以存放一个整数，然后表示时间，通过FROM_UNIXTIME转换
--   
SELECT FROM_UNIXTIME(1618483484, '%Y-%m-%d') FROM DUAL;
SELECT FROM_UNIXTIME(1618483100, '%Y-%m-%d %H:%i:%s') FROM DUAL;

SELECT * FROM mysql.user \G 
```

## 加密和系统函数

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511213738467.png)

```sql
-- 演示加密函数和系统函数

-- USER()	查询用户
-- 可以查看登录到mysql的有哪些用户，以及登录的IP
SELECT USER() FROM DUAL; -- 返回 用户@IP地址
-- DATABASE()	查询当前使用数据库名称
SELECT DATABASE();

-- MD5(str)	为字符串算出一个 MD5 32的字符串，常用(用户密码)加密
-- root 密码是 timerring -> 加密md5 -> 在数据库中存放的是加密后的密码
SELECT MD5('timerring') FROM DUAL;
SELECT LENGTH(MD5('timerring')) FROM DUAL;

-- 演示用户表，存放密码时，是md5
CREATE TABLE timerring_user
	(id INT , 
	`name` VARCHAR(32) NOT NULL DEFAULT '', 
	pwd CHAR(32) NOT NULL DEFAULT '');
INSERT INTO timerring_user 
	VALUES(100, '谈莫瑞', MD5('timerring'));
SELECT * FROM timerring_user;

SELECT * FROM timerring_user  -- SQL注入问题
	WHERE `name`='谈莫瑞' AND pwd = MD5('timerring')  


-- PASSWORD(str) -- 加密函数, MySQL数据库的用户密码就是 PASSWORD函数加密

SELECT PASSWORD('timerring') FROM DUAL; -- 数据库的 *81220D972A52D4C51BB1C37518A2613706220DAC


-- select * from mysql.user \G 	从原文密码str 计算并返回密码字符串
-- 通常用于对mysql数据库的用户密码加密
-- mysql.user 表示 数据库.表 
SELECT * FROM mysql.user
```

## 流程控制函数

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511213446566.png)

```sql
# 演示流程控制语句

# IF(expr1,expr2,expr3)	如果expr1为True ,则返回 expr2 否则返回 expr3
SELECT IF(TRUE, '北京', '上海') FROM DUAL;
# IFNULL(expr1,expr2)	如果expr1不为空NULL,则返回expr1,否则返回expr2
SELECT IFNULL( NULL, '教育') FROM DUAL;
# SELECT CASE WHEN expr1 THEN expr2 WHEN expr3 THEN expr4 ELSE expr5 END; [类似多重分支.]
# 如果expr1 为TRUE,则返回expr2,如果expr2 为t, 返回 expr4, 否则返回 expr5

SELECT CASE 
	WHEN TRUE THEN 'jack'  -- jack
	WHEN FALSE THEN 'tom' 
	ELSE 'mary' END

-- 1. 查询emp 表, 如果 comm 是null , 则显示0.0
--    老师说明，判断是否为null 要使用 is null, 判断不为空 使用 is not
SELECT ename, IF(comm IS NULL , 0.0, comm)
	FROM emp;
SELECT ename, IFNULL(comm, 0.0)
	FROM emp;
-- 2. 如果emp 表的 job 是 CLERK 则显示 职员， 如果是 MANAGER 则显示经理
--     如果是 SALESMAN 则显示 销售人员，其它正常显示

SELECT ename, (SELECT CASE 
		WHEN job = 'CLERK' THEN '职员' 
		WHEN job = 'MANAGER' THEN '经理'
		WHEN job = 'SALESMAN' THEN '销售人员' 
		ELSE job END) AS 'job'
	FROM emp; 

SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM salgrade;
```

## mysql 表查询--加强

### 介绍

```sql
-- 查询加强
-- ■ 使用where子句
-- 	?如何查找1992.1.1后入职的员工
-- 老师说明： 在mysql中,日期类型可以直接比较, 需要注意格式
SELECT * FROM emp
	WHERE hiredate > '1992-01-01'
-- ■ 如何使用like操作符(模糊)
-- 	%: 表示0到多个任意字符 _: 表示单个任意字符
-- 	?如何显示首字符为S的员工姓名和工资
SELECT ename, sal FROM emp
	WHERE ename LIKE 'S%'
-- 	?如何显示第三个字符为大写O的所有员工的姓名和工资
SELECT ename, sal FROM emp
	WHERE ename LIKE '__O%'

-- ■ 如何显示没有上级的雇员的情况
SELECT * FROM emp
	WHERE mgr IS NULL;
-- ■ 查询表结构 
DESC emp 

-- 使用order by子句
--   ?如何按照工资的从低到高的顺序[升序]，显示雇员的信息
SELECT * FROM emp
	ORDER BY sal 
--   ?按照部门号升序而雇员的工资降序排列 , 显示雇员信息

SELECT * FROM emp
	ORDER BY deptno ASC , sal DESC;
```

### 分页查询

基本语法: `select.... limit start, rows`
表示从`start+1`行开始取,取出`rows`行,  `start` 从0开始计算

```sql
-- 分页查询
-- 按雇员的id号升序取出， 每页显示3条记录，请分别显示 第1页，第2页，第3页

-- 第1页
SELECT * FROM emp 
	ORDER BY empno 
	LIMIT 0, 3;
-- 第2页
SELECT * FROM emp 
	ORDER BY empno 
	LIMIT 3, 3;
-- 第3页
SELECT * FROM emp 
	ORDER BY empno 
	LIMIT 6, 3;
-- 推导一个公式 
SELECT * FROM emp
	ORDER BY empno 
	LIMIT 每页显示记录数 * (第几页-1) , 每页显示记录数
	
-- 测试
SELECT job, COUNT(*) FROM emp GROUP BY job;
-- 显示雇员总数，以及获得补助的雇员数
SELECT COUNT(*) FROM emp  WHERE mgr IS NOT NULL;
SELECT MAX(sal) - MIN(sal) FROM emp;
```

### 使用分组函数和分组子句

```sql
-- 增强group by 的使用

-- (1) 显示每种岗位的雇员总数、平均工资。
SELECT COUNT(*), AVG(sal), job 
	FROM emp 
	GROUP BY job; 
-- (2) 显示雇员总数，以及获得补助的雇员数。
--  思路: 获得补助的雇员数 就是 comm 列为非null, 就是count(列)，如果该列的值为null, 是不会统计 , SQL 非常灵活，需要我们动脑筋.
SELECT COUNT(*), COUNT(comm)
	FROM emp 

--  老师的扩展要求：统计没有获得补助的雇员数
SELECT COUNT(*), COUNT(IF(comm IS NULL, 1, NULL))
	FROM emp 

SELECT COUNT(*), COUNT(*) - COUNT(comm)
	FROM emp 

-- (3) 显示管理者的总人数。小技巧:尝试写->修改->尝试[正确的]
SELECT COUNT(DISTINCT mgr) 
	FROM emp; 

-- (4) 显示雇员工资的最大差额。
-- 思路： max(sal) - min(sal)
SELECT MAX(sal) - MIN(sal) 
	FROM emp;

SELECT * FROM e
mp;
select * from dept;



-- 应用案例：请统计各个部门group by 的平均工资 avg，
-- 并且是大于1000的 having，并且按照平均工资从高到低排序， order by
-- 取出前两行记录 limit 0, 2

SELECT deptno, AVG(sal) AS avg_sal
	FROM emp
	GROUP BY deptno
	HAVING  avg_sal > 1000
	ORDER BY avg_sal DESC
	LIMIT 0,2 
```

### 数据分组的总结

如果select语句同时包含有group by ,having , limitorder by那么他们的顺序是`group by , having , orderby, limit`

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511215948687.png)

## mysql 多表查询

### 多表查询练习

在默认情况下:当两个表查询时，规则

1. 从第一张表中，取出一行和第二张表的每一行进行组合,返回结果[含有两张表的所有列].
2. 一共返回的记录数第一张表行数*第二张表的行数（**笛卡尔积**）

```sql
-- 多表查询
-- ?显示雇员名,雇员工资及所在部门的名字 【笛卡尔集】
/*
	1. 雇员名,雇员工资 来自 emp表
	2. 部门的名字 来自 dept表
	3. 需求对 emp 和 dept查询  ename,sal,dname,deptno
	4. 当我们需要指定显示某个表的列是，需要 表.列表
*/
SELECT ename,sal,dname,emp.deptno
	FROM emp, dept 
	WHERE emp.deptno = dept.deptno
	
select * from emp;
select * from dept;
select * from salgrade;
-- 小技巧：多表查询的条件不能少于 表的个数-1, 否则会出现笛卡尔集
-- ?如何显示部门号为10的部门名、员工名和工资 
-- 重复的deptno要标清是哪个表的
SELECT ename,sal,dname,emp.deptno
	FROM emp, dept 
	WHERE emp.deptno = dept.deptno and emp.deptno = 10

-- ?显示各个员工的姓名，工资，及其工资的级别

-- 思路 姓名，工资 来自 emp 13
--      工资级别 salgrade 5
-- 写sql , 先写一个简单，然后加入过滤条件...
select ename, sal, grade 
	from emp , salgrade
	where sal between losal and hisal; 
```

### 自连接

自连接是指在同一张表的连接查询[将同一张表看做两张表]。

```sql
-- 多表查询的 自连接

-- 思考题: 显示公司员工名字和他的上级的名字

-- 老韩分析： 员工名字 在emp, 上级的名字的名字 emp
-- 员工和上级是通过 emp 表的 mgr 列关联
-- 这里老师小结：
-- 自连接的特点 1. 把同一张表当做两张表使用
--             2. 需要给表取别名 表名  表别名 
-- 3. 列名不明确，可以指定列的别名 列名 as 列的别名		
SELECT worker.ename AS '职员名' ,  boss.ename AS '上级名'
	FROM emp worker, emp boss -- 同一张表用不同的别名
	WHERE worker.mgr = boss.empno;
SELECT * FROM emp;
```

## mysql 表子查询

### 什么是子查询

子查询是指嵌入在其它 sql 语句中的select 语句,也叫嵌套查询

### 单行子查询

单行子查询是指只返回一行数据的子查询语句

### 多行子查询

多行子查询指返回多行数据的子查询    使用关键字`in`

```sql
-- 子查询的演示
-- 请思考：如何显示与SMITH同一部门的所有员工?
/*
	1. 先查询到 SMITH的部门号得到
	2. 把上面的select 语句当做一个子查询来使用
*/
SELECT deptno 
	FROM emp 
	WHERE ename = 'SMITH'

-- 下面的答案.	
SELECT * 
	FROM emp
	WHERE deptno = (
		SELECT deptno 
		FROM emp 
		WHERE ename = 'SMITH'
	)

-- 课堂练习:如何查询和部门10的工作相同的雇员的
-- 名字、岗位、工资、部门号, 但是不含10号部门自己的雇员.

/*
	1. 查询到10号部门有哪些工作
	2. 把上面查询的结果当做子查询使用
*/
select distinct job 
	from emp 
	where deptno = 10;
	
--  下面语句完整

select ename, job, sal, deptno
	from emp
	where job in (
		SELECT DISTINCT job 
		FROM emp 
		WHERE deptno = 10
	) and deptno <> 10 
```

### 子查询当做临时表使用

可以将子查询当做一张临时表使用

```sql
-- 子查询练习

-- 请思考：查找每个部门工资高于本部门平均工资的人的资料
-- 这里要用到数据查询的小技巧，把一个子查询当作一个临时表使用

-- 1. 先得到每个部门的 部门号和 对应的平均工资

SELECT deptno, AVG(sal) AS avg_sal
	FROM emp GROUP BY deptno
	
-- 2. 把上面的结果当做子查询，作为temp表, 和 emp 进行多表查询    
SELECT ename, sal, temp.avg_sal, emp.deptno
	FROM emp, (
		SELECT deptno, AVG(sal) AS avg_sal
		FROM emp 
		GROUP BY deptno
	) temp 
	where emp.deptno = temp.deptno and emp.sal > temp.avg_sal
	
-- 查找每个部门工资最高的人的详细资料

SELECT ename, sal, temp.max_sal, emp.deptno
	FROM emp, (
		SELECT deptno, max(sal) AS max_sal
		FROM emp 
		GROUP BY deptno
	) temp 
	WHERE emp.deptno = temp.deptno AND emp.sal = temp.max_sal
	

-- 查询每个部门的信息(包括：部门名,编号,地址)和人员数量,我们一起完成。

-- 1. 部门名,编号,地址 来自 dept表
-- 2. 各个部门的人员数量 -》 构建一个临时表

select count(*), deptno 
	from emp
	group by deptno;
	

select dname, dept.deptno, loc , tmp.per_num as '人数'
	from dept, (
		SELECT COUNT(*) as per_num, deptno 
		FROM emp
		GROUP BY deptno
	) tmp 
	where tmp.deptno = dept.deptno

-- 还有一种写法 表.* 表示将该表所有列都显示出来, 可以简化sql语句
-- 在多表查询中，当多个表的列不重复时，才可以直接写列名

SELECT tmp.* , dname, loc
	FROM dept, (
		SELECT COUNT(*) AS per_num, deptno 
		FROM emp
		GROUP BY deptno
	) tmp 
	WHERE tmp.deptno = dept.deptno
```

### 在多行子查询中使用 all 操作符

### 在多行子查询中使用 any 操作符

```sql
-- all 和 any的使用

-- 请思考:显示工资比部门30的所有员工的工资高的员工的姓名、工资和部门号

SELECT ename, sal, deptno
	FROM emp
	WHERE sal > ALL(
		SELECT sal 
			FROM emp
			WHERE deptno = 30
		) 
-- 可以这样写
SELECT ename, sal, deptno
	FROM emp
	WHERE sal > (
		SELECT MAX(sal) 
			FROM emp
			WHERE deptno = 30
		) 

-- 请思考:如何显示工资比部门30的其中一个员工的工资高的员工的姓名、工资和部门号

SELECT ename, sal, deptno
	FROM emp
	WHERE sal > any(
		SELECT sal 
			FROM emp
			WHERE deptno = 30
		)

 SELECT ename, sal, deptno
	FROM emp
	WHERE sal > (
		SELECT min(sal) 
			FROM emp
			WHERE deptno = 30
		)


-- 查询ecshop中各个类别中，价格最高的商品

-- 查询 商品表
-- 先得到 各个类别中，价格最高的商品 max + group by cat_id, 当做临时表
-- 把子查询当做一张临时表可以解决很多很多复杂的查询

select cat_id , max(shop_price) 
	from ecs_goods
	group by cat_id
	
	
-- 这个最后答案	
select goods_id, ecs_goods.cat_id, goods_name, shop_price 
	from (
		SELECT cat_id , MAX(shop_price) as max_price
		FROM ecs_goods
		GROUP BY cat_id
	) temp , ecs_goods
	where  temp.cat_id = ecs_goods.cat_id 
	and temp.max_price = ecs_goods.shop_price 
```

### 多列子查询

多列子查序则是指查询返回多个列数据的子查询语句

```sql
-- 多列子查询

-- 请思考如何查询与allen的部门和岗位完全相同的所有雇员(并且不含allen本人)
-- (字段1， 字段2 ...) = (select 字段 1，字段2 from 。。。。)

-- 分析: 1. 得到smith的部门和岗位

SELECT deptno , job
	FROM emp 
	WHERE ename = 'ALLEN'
	
-- 分析: 2  把上面的查询当做子查询来使用，并且使用多列子查询的语法进行匹配
SELECT * 
	FROM emp
	WHERE (deptno , job) = (
		SELECT deptno , job
		FROM emp 
		WHERE ename = 'ALLEN'
	) AND ename != 'ALLEN'



-- 请查询 和宋江数学，英语，语文   
-- 成绩 完全相同的学生
SELECT * 
	FROM student
	WHERE (math, english, chinese) = (
		SELECT math, english, chinese
		FROM student
		WHERE `name` = '宋江'
	)

SELECT * FROM student;
```

### 在from 子句中使用子查询

```sql
-- 子查询练习

-- 请思考：查找每个部门工资高于本部门平均工资的人的资料
-- 这里要用到数据查询的小技巧，把一个子查询当作一个临时表使用

-- 1. 先得到每个部门的 部门号和 对应的平均工资

SELECT deptno, AVG(sal) AS avg_sal
	FROM emp GROUP BY deptno
	
-- 2. 把上面的结果当做子查询, 和 emp 进行多表查询
--    
SELECT ename, sal, temp.avg_sal, emp.deptno
	FROM emp, (
		SELECT deptno, AVG(sal) AS avg_sal
		FROM emp 
		GROUP BY deptno
	) temp 
	where emp.deptno = temp.deptno and emp.sal > temp.avg_sal
	
-- 查找每个部门工资最高的人的详细资料

SELECT ename, sal, temp.max_sal, emp.deptno
	FROM emp, (
		SELECT deptno, max(sal) AS max_sal
		FROM emp 
		GROUP BY deptno
	) temp 
	WHERE emp.deptno = temp.deptno AND emp.sal = temp.max_sal
	

-- 查询每个部门的信息(包括：部门名,编号,地址)和人员数量,我们一起完成。

-- 1. 部门名,编号,地址 来自 dept表
-- 2. 各个部门的人员数量 -》 构建一个临时表

select count(*), deptno 
	from emp
	group by deptno;
	

select dname, dept.deptno, loc , tmp.per_num as '人数'
	from dept, (
		SELECT COUNT(*) as per_num, deptno 
		FROM emp
		GROUP BY deptno
	) tmp 
	where tmp.deptno = dept.deptno

-- 还有一种写法 表.* 表示将该表所有列都显示出来, 可以简化sql语句
-- 在多表查询中，当多个表的列不重复时，才可以直接写列名

SELECT tmp.* , dname, loc
	FROM dept, (
		SELECT COUNT(*) AS per_num, deptno 
		FROM emp
		GROUP BY deptno
	) tmp 
	WHERE tmp.deptno = dept.deptno
```

## 表复制

### 自我复制数据(蠕虫复制)

有时，为了对某个sql语句进行效率测试，我们需要海量数据时，可以使用此法为表创建海量数据。

```sql
-- 表的复制
-- 为了对某个sql语句进行效率测试，我们需要海量数据时，可以使用此法为表创建海量数据

CREATE TABLE my_tab01 
	( id INT,
	  `name` VARCHAR(32),
	  sal DOUBLE,
	  job VARCHAR(32),
	  deptno INT);
DESC my_tab01
SELECT * FROM my_tab01;

-- 演示如何自我复制
-- 1. 先把emp 表的记录复制到 my_tab01
INSERT INTO my_tab01 
	(id, `name`, sal, job,deptno)
	SELECT empno, ename, sal, job, deptno FROM emp;
-- 2. 自我复制
INSERT INTO my_tab01
	SELECT * FROM my_tab01;
SELECT COUNT(*) FROM my_tab01;

-- 如何删除掉一张表重复记录
-- 1. 先创建一张表 my_tab02, 
-- 2. 让 my_tab02 有重复的记录

CREATE TABLE my_tab02 LIKE emp; -- 这个语句 把emp表的结构(列)，复制到my_tab02

desc my_tab02;

insert into my_tab02
	select * from emp;
select * from my_tab02;
-- 3. 考虑去重 my_tab02的记录
/*
	思路 
	(1) 先创建一张临时表 my_tmp , 该表的结构和 my_tab02一样
	(2) 把my_tmp 的记录 通过 distinct 关键字 处理后 把记录复制到 my_tmp
	(3) 清除掉 my_tab02 记录
	(4) 把 my_tmp 表的记录复制到 my_tab02
	(5) drop 掉 临时表my_tmp
*/
-- (1) 先创建一张临时表 my_tmp , 该表的结构和 my_tab02一样

create table my_tmp like my_tab02
-- (2) 把my_tmp 的记录 通过 distinct 关键字 处理后 把记录复制到 my_tmp
insert into my_tmp 
	select distinct * from my_tab02;

-- (3) 清除掉 my_tab02 记录
delete from my_tab02;
-- (4) 把 my_tmp 表的记录复制到 my_tab02
insert into my_tab02
	select * from my_tmp;
-- (5) drop 掉 临时表my_tmp
drop table my_tmp;

select * from my_tab02;
```

## 合并查询

### 介绍

有时在实际应用中，为了合并多个 `select` 语句的结果，可以使用集合操作符号 `union` , `union all`。

+ union all：该操作符用于取得两个结果集的并集。当使用该操作符时，不会取消重复行。
+ union：该操作赋与union all相似,但是会自动去掉结果集中重复行

```sql
-- 合并查询
SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
SELECT ename,sal,job FROM emp WHERE job='MANAGER' -- 3

-- union all 就是将两个查询结果合并，不会去重
SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
UNION ALL
SELECT ename,sal,job FROM emp WHERE job='MANAGER' -- 3

-- union  就是将两个查询结果合并，会去重
SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
UNION 
SELECT ename,sal,job FROM emp WHERE job='MANAGER' -- 3
```

## mysql 表外连接

前面我们学习的查询，是利用where子句对两张表或者多张表，形成的笛卡尔积进行筛选,根据关联条件，显示所有匹配的记录，匹配不上的，不显示。比如:列出部门名称和这些部门的员工名称和工作，同时要求显示出那些没有员工的部门。

### 外连接

1. 左外连接(如果左侧的表完全显示我们就说是左外连接)

2. 右外连接(如果右侧的表完全显示我们就说是右外连接)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511224810092.png)

+ 使用左连接(显示所有人的成绩，如果没有成绩，也要显示该人的姓名和id号,成绩显示为空)select .. from表1 left join表2 on条件[表1:就是左表表2:就是右表]。
+ 使用右外连接(显示所有成绩,如果没有名字匹配,显示空)
  select .. from 表1 right join表2 on条件[表1:就是左表表2:就是右表]

```sql
-- 外连接

-- 比如：列出部门名称和这些部门的员工名称和工作，
-- 同时要求 显示出那些没有员工的部门。

-- 使用我们学习过的多表查询的SQL， 看看效果如何?

SELECT dname, ename, job 
	FROM emp, dept
	WHERE emp.deptno = dept.deptno
	ORDER BY dname
SELECT * FROM dept;

SELECT * FROM emp;


-- 创建 stu
/*
id  name   
1   Jack
2   Tom
3   Kity
4   nono
*/
CREATE TABLE stu (
	id INT,
	`name` VARCHAR(32));
INSERT INTO stu VALUES(1, 'jack'),(2,'tom'),(3, 'kity'),(4, 'nono');
SELECT * FROM stu;
-- 创建 exam
/*
id   grade
1    56
2    76
11   8

*/
CREATE TABLE exam(
	id INT,
	grade INT);
INSERT INTO exam VALUES(1, 56),(2,76),(11, 8);
SELECT * FROM exam;

-- 使用左连接
-- （显示所有人的成绩，如果没有成绩，也要显示该人的姓名和id号,成绩显示为空）

SELECT `name`, stu.id, grade
	FROM stu, exam
	WHERE stu.id = exam.id;
	
-- 改成左外连接
SELECT `name`, stu.id, grade
	FROM stu LEFT JOIN exam
	ON stu.id = exam.id;
	
	
-- 使用右外连接（显示所有成绩，如果没有名字匹配，显示空)
-- 即：右边的表(exam) 和左表没有匹配的记录，也会把右表的记录显示出来
SELECT `name`, stu.id, grade
	FROM stu RIGHT JOIN exam
	ON stu.id = exam.id;

-- 列出部门名称和这些部门的员工信息(名字和工作)，
-- 同时列出那些没有员工的部门名。5min
-- 使用左外连接实现
SELECT dname, ename, job
	FROM dept LEFT JOIN emp
	ON dept.deptno = emp.deptno
	
-- 使用右外连接实现

SELECT dname, ename, job
	FROM emp RIGHT JOIN dept
	ON dept.deptno = emp.deptno
```

## mysql 约束

### 基本介绍

**约束**用于确保数据库的数据满足特定的商业规则。在mysql中，约束包括: not null、unique, primary key, foreign key, 和 check 五种.

### primary key(主键)

字段名  字段类型  primary key  （表示该字段为主键）

用于唯一的标示表行的数据,当定义主键约束后，**该列不能重复**

+ primary key不能重复而且不能为null.
+ 一张表最多只能有一个主键,但可以是复合主键
+ 主键的指定方式有两种
  + 直接在字段名后指定:字段名primakry key
  + 在表定义最后写primary key(列名);
+ 使用 **desc 表名**，可以看到primary key的情况。
+ 在实际开发中，每个表往往都会设计一个主键。

```sql
-- 主键使用

-- id	name 	email
CREATE TABLE t17
	(id INT PRIMARY KEY, -- 表示id列是主键 
	`name` VARCHAR(32),
	email VARCHAR(32));
	
-- 主键列的值是不可以重复
INSERT INTO t17
	VALUES(1, 'jack', 'jack@sohu.com');
INSERT INTO t17
	VALUES(2, 'tom', 'tom@sohu.com');

INSERT INTO t17
	VALUES(1, 'hsp', 'hsp@sohu.com'); -- 报错
	
SELECT * FROM t17;

-- 主键使用的细节讨论
-- primary key不能重复而且不能为 null。
INSERT INTO t17
	VALUES(NULL, 'hsp', 'hsp@sohu.com');
-- 一张表最多只能有一个主键, 但可以是复合主键(比如 id+name)
CREATE TABLE t18
	(id INT PRIMARY KEY, -- 表示id列是主键 
	`name` VARCHAR(32), PRIMARY KEY -- 错误的
	email VARCHAR(32));
-- 演示复合主键 (id 和 name 做成复合主键)
CREATE TABLE t18
	(id INT , 
	`name` VARCHAR(32), 
	email VARCHAR(32),
	PRIMARY KEY (id, `name`) -- 这里就是复合主键
	);

INSERT INTO t18
	VALUES(1, 'tom', 'tom@sohu.com');
INSERT INTO t18
	VALUES(1, 'jack', 'jack@sohu.com');
INSERT INTO t18
	VALUES(1, 'tom', 'xx@sohu.com'); -- 这里就违反了复合主键
SELECT * FROM t18;

-- 主键的指定方式 有两种 
-- 1. 直接在字段名后指定：字段名  primakry key
-- 2. 在表定义最后写 primary key(列名); 
CREATE TABLE t19
	(id INT , 
	`name` VARCHAR(32) PRIMARY KEY, 
	email VARCHAR(32)
	);

CREATE TABLE t20
	(id INT , 
	`name` VARCHAR(32) , 
	email VARCHAR(32),
	PRIMARY KEY(`name`) -- 在表定义最后写 primary key(列名)
	);
 
-- 使用desc 表名，可以看到primary key的情况

DESC t20 -- 查看 t20表的结果，显示约束的情况
DESC t18
```

### not null(非空)

如果在列上定义了not null, 那么当插入数据时，必须为列提供数据。

`字段名 字段类型 not null`

### unique(唯一)

当定义了唯一约束后，该列值是不能重复的。

`字段名 字段类型 unique`

1. 如果没有指定not null，则unique字段**可以有多个null**
2. 一张表可以有多个unique字段

```sql
-- unique的使用

CREATE TABLE t21
	(id INT UNIQUE ,  -- 表示 id 列是不可以重复的.
	`name` VARCHAR(32) , 
	email VARCHAR(32)
	);
	
INSERT INTO t21
	VALUES(1, 'jack', 'jack@sohu.com');

INSERT INTO t21
	VALUES(1, 'tom', 'tom@sohu.com');
	
-- unqiue使用细节
-- 1. 如果没有指定 not null , 则 unique 字段可以有多个null
-- 如果一个列(字段)， 是 unique not null 使用效果类似 primary key
INSERT INTO t21
	VALUES(NULL, 'tom', 'tom@sohu.com');
SELECT * FROM t21;
-- 2. 一张表可以有多个unique字段

CREATE TABLE t22
	(id INT UNIQUE ,  -- 表示 id 列是不可以重复的.
	`name` VARCHAR(32) UNIQUE , -- 表示name不可以重复 
	email VARCHAR(32)
	);
DESC t22
```

### foreign key(外键)

用于定义主表和从表之间的关系: 

+ 外键约束要定义在从表上，主表则必须具有主键约束或是unique约束,
+ 当定义外键约束后，要求外键列数据必须在主表的主键列存在或是为null(学生/班级图示)。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511231307720.png)

```sql
-- 外键演示

-- 创建 主表 my_class
CREATE TABLE my_class (
	id INT PRIMARY KEY , -- 班级编号
	`name` VARCHAR(32) NOT NULL DEFAULT '');

-- 创建 从表 my_stu
CREATE TABLE my_stu (
	id INT PRIMARY KEY , -- 学生编号
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	class_id INT , -- 学生所在班级的编号
	-- 下面指定外键关系
	FOREIGN KEY (class_id) REFERENCES my_class(id))
-- 测试数据
INSERT INTO my_class 
	VALUES(100, 'java'), (200, 'web');
INSERT INTO my_class 
	VALUES(300, 'php');
	
SELECT * FROM my_class;
INSERT INTO my_stu 
	VALUES(1, 'tom', 100);
INSERT INTO my_stu 
	VALUES(2, 'jack', 200);
INSERT INTO my_stu 
	VALUES(3, 'hsp', 300);
INSERT INTO my_stu 
	VALUES(4, 'mary', 400); -- 这里会失败...因为400班级不存在

INSERT INTO my_stu 
	VALUES(5, 'king', NULL); -- 可以, 外键 没有写 not null
SELECT * FROM my_class;

-- 一旦建立主外键的关系，数据不能随意删除了
DELETE FROM my_class
	WHERE id = 100; 
```

### check

用于强制行数据必须满足的条件,假定在sal列上定义了check约束,并要求sal列值在1000 \~2000之间，如果不在1000\~2000之间就会提示出错。

提示:oracle和 sql server 均支持check ,但是mysql5.7目前还不支持check ,只做语法校验，但不会生效。

```sql
-- 演示check的使用
-- mysql5.7目前还不支持check ,只做语法校验，但不会生效
-- 了解 
-- 学习 oracle, sql server, 这两个数据库是真的生效.

-- 测试
CREATE TABLE t23 (
	id INT PRIMARY KEY,
	`name` VARCHAR(32) ,
	sex VARCHAR(6) CHECK (sex IN('man','woman')),
	sal DOUBLE CHECK ( sal > 1000 AND sal < 2000)
	);
	
-- 添加数据
INSERT INTO t23 
	VALUES(1, 'jack', 'mid', 1);
SELECT * FROM t23;
```

### 商店售货系统表设计案例

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230511231908815.png)

```sql
-- 使用约束的课堂练习

CREATE DATABASE shop_db;

-- 现有一个商店的数据库shop_db，记录客户及其购物情况，由下面三个表组成：
-- 商品goods（商品号goods_id，商品名goods_name，单价unitprice，商品类别category，供应商provider);
-- 客户customer（客户号customer_id,姓名name,住址address,电邮email性别sex,身份证card_Id);
-- 购买purchase（购买订单号order_id，客户号customer_id,商品号goods_id,购买数量nums);
-- 1 建表，在定义中要求声明 [进行合理设计]：
-- (1)每个表的主外键；
-- (2)客户的姓名不能为空值；
-- (3)电邮不能够重复;
-- (4)客户的性别[男|女] check 枚举..
-- (5)单价unitprice 在 1.0 - 9999.99 之间 check

-- 商品goods
CREATE TABLE goods (
	goods_id INT PRIMARY KEY,
	goods_name VARCHAR(64) NOT NULL DEFAULT '',
	unitprice DECIMAL(10,2) NOT NULL DEFAULT 0 
		CHECK (unitprice >= 1.0 AND unitprice <= 9999.99),
	category INT NOT NULL DEFAULT 0,
	provider VARCHAR(64) NOT NULL DEFAULT '');
	
-- 客户customer（客户号customer_id,姓名name,住址address,电邮email性别sex,
-- 身份证card_Id);
CREATE TABLE customer(
	customer_id CHAR(8) PRIMARY KEY, -- 程序员自己决定
	`name` VARCHAR(64) NOT NULL DEFAULT '',
	address VARCHAR(64) NOT NULL DEFAULT '',
	email VARCHAR(64) UNIQUE NOT NULL,
	sex ENUM('男','女') NOT NULL ,  -- 这里老师使用的枚举类型, 是生效
	card_Id CHAR(18)); 
	
-- 购买purchase（购买订单号order_id，客户号customer_id,商品号goods_id,
-- 购买数量nums);
CREATE TABLE purchase(
	order_id INT UNSIGNED PRIMARY KEY,
	customer_id CHAR(8) NOT NULL DEFAULT '', -- 外键约束在后
	goods_id INT NOT NULL DEFAULT 0 , -- 外键约束在后
	nums INT NOT NULL DEFAULT 0,
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	FOREIGN KEY (goods_id) REFERENCES goods(goods_id));
DESC goods;
DESC customer;
DESC purchase;
```

## 自增长

### 自增长基本介绍

在某张表中，存在一个id列(整数),我们希望在添加记录的时候.该列从1开始,自动的增长，怎么处理? 

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512150332955.png)

### 自增长使用细节

1. 一般来说自增长是和primary key配合使用的
2. 自增长也可以单独使用[但是需要配合一个unique]
3. 自增长修饰的字段为整数型的(虽然小数也可以但是非常非常少这样使用)
4. 自增长默认从1开始，你也可以通过如下命令修改`alter table 表名auto_increment = 新的开始值;`
5. 如果你添加数据时，给自增长字段(列)指定的有值，则以指定的值为准,**如果指定了自增长，一般来说，就按照自增长的规则（从指定的值开始，再自增长）**来添加数据

```sql
-- 演示自增长的使用
-- 创建表
CREATE TABLE t24
	(id INT PRIMARY KEY AUTO_INCREMENT,
	 email VARCHAR(32)NOT NULL DEFAULT '',
	 `name` VARCHAR(32)NOT NULL DEFAULT ''); 
DESC t24
-- 测试自增长的使用
INSERT INTO t24
	VALUES(NULL, 'tom@qq.com', 'tom'); -- 没有给值，自动维护，id自增长

INSERT INTO t24
	(email, `name`) VALUES('hsp@sohu.com', 'hsp');

SELECT * FROM t24;

-- 修改默认的自增长开始值
ALTER TABLE t25 AUTO_INCREMENT = 100
CREATE TABLE t25
	(id INT PRIMARY KEY AUTO_INCREMENT,
	 email VARCHAR(32)NOT NULL DEFAULT '',
	 `name` VARCHAR(32)NOT NULL DEFAULT ''); 
INSERT INTO t25
	VALUES(NULL, 'mary@qq.com', 'mary');
INSERT INTO t25
	VALUES(666, 'hsp@qq.com', 'hsp');
SELECT * FROM t25;

CREATE DATABASE tmp;
CREATE TABLE dept( /*部门表*/
deptno MEDIUMINT   UNSIGNED  NOT NULL  DEFAULT 0,
dname VARCHAR(20)  NOT NULL  DEFAULT "",
loc VARCHAR(13) NOT NULL DEFAULT ""
) ;

#创建表EMP雇员
CREATE TABLE emp
(empno  MEDIUMINT UNSIGNED  NOT NULL  DEFAULT 0, /*编号*/
ename VARCHAR(20) NOT NULL DEFAULT "", /*名字*/
job VARCHAR(9) NOT NULL DEFAULT "",/*工作*/
mgr MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,/*上级编号*/
hiredate DATE NOT NULL,/*入职时间*/
sal DECIMAL(7,2)  NOT NULL,/*薪水*/
comm DECIMAL(7,2) NOT NULL,/*红利*/
deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0 /*部门编号*/
) ;

#工资级别表
CREATE TABLE salgrade
(
grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
losal DECIMAL(17,2)  NOT NULL,
hisal DECIMAL(17,2)  NOT NULL
);

#测试数据
INSERT INTO salgrade VALUES (1,700,1200);
INSERT INTO salgrade VALUES (2,1201,1400);
INSERT INTO salgrade VALUES (3,1401,2000);
INSERT INTO salgrade VALUES (4,2001,3000);
INSERT INTO salgrade VALUES (5,3001,9999);	
```

## mysql 索引

### 索引快速入门

提高数据库性能，索引是最物美价廉的东西了。不用加**内存**，不用改程序，不用调sql，查询速度就可能提高百倍干倍。

```sql
CREATE INDEX ename_index ON emp (ename) -- 在 ename 上创建索引
```

```sql
-- 创建测试数据库 tmp
CREATE DATABASE tmp;

CREATE TABLE dept( /*部门表*/
deptno MEDIUMINT   UNSIGNED  NOT NULL  DEFAULT 0,
dname VARCHAR(20)  NOT NULL  DEFAULT "",
loc VARCHAR(13) NOT NULL DEFAULT ""
) ;

#创建表EMP雇员
CREATE TABLE emp
(empno  MEDIUMINT UNSIGNED  NOT NULL  DEFAULT 0, /*编号*/
ename VARCHAR(20) NOT NULL DEFAULT "", /*名字*/
job VARCHAR(9) NOT NULL DEFAULT "",/*工作*/
mgr MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,/*上级编号*/
hiredate DATE NOT NULL,/*入职时间*/
sal DECIMAL(7,2)  NOT NULL,/*薪水*/
comm DECIMAL(7,2) NOT NULL,/*红利*/
deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0 /*部门编号*/
) ;

#工资级别表
CREATE TABLE salgrade
(
grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
losal DECIMAL(17,2)  NOT NULL,
hisal DECIMAL(17,2)  NOT NULL
);

#测试数据
INSERT INTO salgrade VALUES (1,700,1200);
INSERT INTO salgrade VALUES (2,1201,1400);
INSERT INTO salgrade VALUES (3,1401,2000);
INSERT INTO salgrade VALUES (4,2001,3000);
INSERT INTO salgrade VALUES (5,3001,9999);

DELIMITER $$

#创建一个函数，名字 rand_string，可以随机返回我指定的个数字符串
CREATE FUNCTION rand_string(n INT)
RETURNS VARCHAR(255) #该函数会返回一个字符串
BEGIN
#定义了一个变量 chars_str， 类型  varchar(100)
#默认给 chars_str 初始值   'abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ'
 DECLARE chars_str VARCHAR(100) DEFAULT
   'abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ'; 
 DECLARE return_str VARCHAR(255) DEFAULT '';
 DECLARE i INT DEFAULT 0; 
 WHILE i < n DO
    # concat 函数 : 连接函数mysql函数
   SET return_str =CONCAT(return_str,SUBSTRING(chars_str,FLOOR(1+RAND()*52),1));
   SET i = i + 1;
   END WHILE;
  RETURN return_str;
  END $$


 #这里我们又自定了一个函数,返回一个随机的部门号
CREATE FUNCTION rand_num( )
RETURNS INT(5)
BEGIN
DECLARE i INT DEFAULT 0;
SET i = FLOOR(10+RAND()*500);
RETURN i;
END $$

 #创建一个存储过程， 可以添加雇员
CREATE PROCEDURE insert_emp(IN START INT(10),IN max_num INT(10))
BEGIN
DECLARE i INT DEFAULT 0;
#set autocommit =0 把autocommit设置成0
 #autocommit = 0 含义: 不要自动提交
 SET autocommit = 0; #默认不提交sql语句
 REPEAT
 SET i = i + 1;
 #通过前面写的函数随机产生字符串和部门编号，然后加入到emp表
 INSERT INTO emp VALUES ((START+i) ,rand_string(6),'SALESMAN',0001,CURDATE(),2000,400,rand_num());
  UNTIL i = max_num
 END REPEAT;
 #commit整体提交所有sql语句，提高效率
   COMMIT;
 END $$

 #添加8000000数据
CALL insert_emp(100001,8000000)$$

#命令结束符，再重新设置为;
DELIMITER ;

SELECT COUNT(*) FROM emp;

-- 在没有创建索引时，我们的查询一条记录
SELECT * 
	FROM emp 
	WHERE empno = 1234567 
-- 使用索引来优化一下， 体验索引的牛

-- 在没有创建索引前 , emp.ibd 文件大小 是 524m
-- 创建索引后 emp.ibd 文件大小 是 655m [索引本身也会占用空间.]
-- 创建ename列索引,emp.ibd 文件大小 是 827m

-- empno_index 索引名称 
-- ON emp (empno) : 表示在 emp表的 empno列创建索引
CREATE INDEX empno_index ON emp (empno)

-- 创建索引后， 查询的速度如何

SELECT * 
	FROM emp 
	WHERE empno = 1234578 -- 0.003s 原来是4.5s


-- 创建索引后，只对创建了索引的列有效 
SELECT * 
	FROM emp 
	WHERE ename = 'PjDlwy' -- 没有在ename创建索引时，时间4.7s

CREATE INDEX ename_index ON emp (ename) -- 在ename上创建索引
```

### 索引的原理

没有索引为什么会慢?因为全表扫描.

使用索引为什么会快?形成一个索引的数据结构，比如二叉树索引（有代价 如下）

+ 磁盘占用
+ 对dml(update delete insert)语句的效率影响 删除或者插入将会对数据结构造成影响，可能会重构。

### 索引的类

1. 主键索引，主键自动的为主索引 (类型Primary key)
2. 唯一索引(UNIQUE)
3. 普通索引(INDEX)
4. 全文索引(FULLTEXT)[适用于MyISAM]

一般开发，不使用mysql自带的全文索引,，而是使用: 全文搜索的框架：Solr 和 ElasticSearch ( ES )

```sql
create table t1(
id int primary key, -- 主键，同时也是索引，称为主键索引.
    name varchar(32));
create table t2(
id int unique, -- id是唯一的，同时也是索引，称为unique索引.
```

### 索引使用

1.添加索引( 建小表测试id , name ) 

```sql
create [UNIQUE] index index_name on tbl_name (col_ name [(length)][ASC | DESC],......);
alter table table_name ADD INDEX [index_namel (index_col_name,..)
```

2.添加主键(索引) 

```sql
ALTER TABLE 表名 ADD PRIMARY KEY(列名...);
```

3.删除索引

```sql
DROP INDEX index_name ON tbl_name,
alter table table_name drop index index_name;
```

4.删除主键索引比较特别: 

```sql
alter table t_b drop primary key;
```

5.查询索引(三种方式)

```sql
show index(es) from table_name;
show keys from table_name;
desc table_Name;
```

```sql
-- 演示mysql的索引的使用
-- 创建索引
CREATE TABLE t25 (
	id INT ,
	`name` VARCHAR(32));
	
-- 查询表是否有索引
SHOW INDEXES FROM t25;
-- 添加索引
-- 添加唯一索引 
CREATE UNIQUE INDEX id_index ON t25 (id);
-- 添加普通索引方式1
CREATE INDEX id_index ON t25 (id);
-- 如何选择 
-- 1. 如果某列的值，是不会重复的，则优先考虑使用unique索引, 否则使用普通索引
-- 添加普通索引方式2
ALTER TABLE t25 ADD INDEX id_index (id)

-- 添加主键索引
CREATE TABLE t26 (
	id INT ,
	`name` VARCHAR(32));
ALTER TABLE t26 ADD PRIMARY KEY (id)

SHOW INDEX FROM t25

-- 删除索引
DROP INDEX id_index ON t25
-- 删除主键索引
ALTER TABLE t26 DROP PRIMARY KEY


-- 修改索引 ，先删除，在添加新的索引

-- 查询索引
-- 1. 方式
SHOW INDEX FROM t25
-- 2. 方式
SHOW INDEXES FROM t25
-- 3. 方式
SHOW KEYS FROM t25
-- 4 方式
DESC t25
```

### 哪些列上适合使用索引

1. 较频繁的作为查询条件字段应该创建索引

   ```sql
   select * from emp where empno = 1
   ```

2. 唯一性太差的字段不适合单独创建索引，即使频繁作为查询条件

   ```sql
   select * from emp where sex =‘男‘
   ```

3. 更新非常频繁的字段不适合创建索引

   ```sql
   select* from emp where logincount = 1
   ```

4. 不会出现在WHERE子句中字段不该创建索引

## mysql 事务

### 什么是事务

事务用于保证数据的一致性,它由一组相关的dml（数据操作语言 增删改）语句组成,该组的dml语句要么全部成功，要么全部失败。如: 转账就要用事务来处理,用以保证数据的一致性。

示意图：

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512160929009.png)

```sql
-- 事务的一个重要的概念和具体操作
-- 演示
-- 1. 创建一张测试表
CREATE TABLE t27
	( id INT,
	  `name` VARCHAR(32));
-- 2. 开始事务
START TRANSACTION 
-- 3. 设置保存点
SAVEPOINT a
-- 执行dml 操作
INSERT INTO t27 VALUES(100, 'tom');
SELECT * FROM t27;

SAVEPOINT b
-- 执行dml操作
INSERT INTO t27 VALUES(200, 'jack');

-- 回退到 b
ROLLBACK TO b
-- 继续回退 a
ROLLBACK TO a
-- 如果这样, 表示直接回退到事务开始的状态.
ROLLBACK 
COMMIT
```

### 事务和锁

当执行事务操作时(dml语句), mysql会在表上加锁, 防止其它用户改表的数据，这对用户来讲是非常重要的。

mysql数据厍控制台事务的几个重要操作

1. `start transaction` --开始一个事务
2. `savepoint` 保存点名--设置保存点
3. `rollback to` 保存点名--回退事务
4. `rollback` --回退全部事务
5. `commit` -- 提交事务,所有的操作生效,不能回退

### 回退事务

在介绍回退事务前，先介绍一下保存点(savepoint)，保存点是事务中的点，用于取消部分事务，当结束事务时(commit)，会自动的删除该事务所定义的所有保存点当执行回退事务时，通过指定保存点可以回退到指定的点。

### 提交事务

使用commit语句可以提交事务.当执行了commit语句子后,会确认事务的变化、结束事务、删除保存点、释放锁，数据生效。当使用commit语句结束事务后,其它会话[**其他连接**]将可以查着到事务变化后的新数据[所有数据就正式生效.]

### 事务细节讨论

1. 如果不开始事务，默认情况下，dml操作是自动提交的，不能回滚。
2. 如果开始一个事务，你没有创建保存点.你可以执行 rollback,默认就是回退到你事务开始的状态。
3. 你也可以在这个事务中(还没有提交时),创建多个保存点.比如: savepoint
   aaa;执行dml , savepoint bbb;
4. 你可以在事务没有提交前,选择回退到哪个保存点。
5. mysql的事务机制需要**innodb的存储引擎才可以使用，myisam不好使**。
6. 开始一个事务start transaction 或者可以写 set autocommit=off;

```sql
-- 讨论 事务细节
-- 1. 如果不开始事务，默认情况下，dml操作是自动提交的，不能回滚
INSERT INTO t27 VALUES(300, 'milan'); -- 自动提交 commit

SELECT * FROM t27

-- 2. 如果开始一个事务，你没有创建保存点. 你可以执行 rollback，
-- 默认就是回退到你事务开始的状态
START TRANSACTION 
INSERT INTO t27 VALUES(400, 'king');
INSERT INTO t27 VALUES(500, 'scott');
ROLLBACK -- 表示直接回退到事务开始的的状态
COMMIT;

-- 3. 你也可以在这个事务中(还没有提交时), 创建多个保存点.比如: savepoint 	aaa;    
-- 执行 dml , savepoint  bbb

-- 4. 你可以在事务没有提交前，选择回退到哪个保存点
-- 5. InnoDB 存储引擎支持事务 , MyISAM 不支持
-- 6. 开始一个事务 start  transaction 或者可以写 set autocommit=off;
```

## mysql 事务隔离级别

### 事务隔离级别介绍

1. 多个连接开启各自事务操作数据库中数据时，数据库系统要负责隔离操作，以保证各个连接在获取数据时的准确性。(通俗解释：每一个事务看到同一张表的数据不一样)

2. 如果不考虑隔离性,可能会引发如下问题:

+ 脏读
+ 不可重复读
+ 幻读

### 查看事务隔离级别

+ 脏读(dirty read):当一个事务读取另一个事务尚未提交的改变(update,insert,delete)时,产生脏读。（未commit）
+ 不可重复读(nonrepeatable read):同一查询在同一事务中多次进行，由于其他提交事务所做的修改或删除,每次返回不同的结果集，此时发生不可重复读。（已commit）
+ 幻读(phantom read):同一查询在同一事务中多次进行，由于其他提交事务所做的插入操作，每次返回不同的结果集，此时发生幻读。（已commit）

### 事务隔离级别

概念: Mysql隔离级别定义了事务与事务之间的隔离程度。

**加锁**会在其他线程操作数据库时，不操作数据库，自己卡住，等待其他线程commit后才进入数据库。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512162256512.png)

### mysql 的事务隔离级--案例

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512162506968.png)

```sql
-- 演示mysql的事务隔离级别

-- 1. 开了两个mysql的控制台
-- 2. 查看当前mysql的隔离级别
SELECT @@tx_isolation;

-- mysql> SELECT @@tx_isolation;
-- +-----------------+
-- | @@tx_isolation  |
-- +-----------------+
-- | REPEATABLE-READ |
-- +-----------------+

-- 3.把其中一个控制台的隔离级别设置 Read uncommitted

SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED

-- 4. 创建表
CREATE TABLE `account`(
	id INT,
	`name` VARCHAR(32),
	money INT);
	

-- 查看当前会话隔离级别 
SELECT @@tx_isolation
-- 查看系统当前隔离级别
SELECT @@global.tx_isolation
-- 设置当前会话隔离级别
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
-- 设置系统当前隔离级别
SET GLOBAL TRANSACTION ISOLATION LEVEL [你设置的级别]
```

### 设置事务隔离级别

1. 查看当前会话隔离级别

   ```sql
   select @@tx_isolation;
   ```

2. 查看系统当前隔离级别

   ```sql
   select @@global.tx_isolation;
   ```

3. 设置当前会话隔离级别

   ```sql
   set session transaction isolation level repeatable read;
   ```

4. 设置系统当前隔离级别

   ```sql
   set global transaction isolation level repeatable read;
   ```

5. mysql默认的事务隔离级别是 `repeatable read`，一般情况下，没有特殊
   要求,没有必要修改(因为该级别可以满足绝大部分项目需求)

如果想要修改默认隔离级别，可以全局修改，修改`my.ini`配置文件，在最后加上

```ini
#可选参数有:READ-UNCOMMITTED, READ-COMMITTED, REPEATABLE-READ,SERIALIZABLE.
[mysqld]
transaction-isolation = REPEATABLE-READ
```

## mysql 事务ACID

### 事务的acid 特性

1. 原子性(Atomicity)
   原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。
2. 一致性(Consistency)
   事务必须使数据库从一个二致性状态变换到另外一个一致性状态
3. 隔离性(lsolation)
   事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。
4. 持久性(Durability)
   持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发生故障也不应该对其有任何影响。

## mysql 表类型和存储引擎

### 基本介绍

1. **MySQL的表类型由存储引擎(Storage Engines）决定**，主要包括MylSAM、innoDB、Memory等。

2. MySQL 数据表主要支持六种类型，分别是: CSV.Memory、ARCHIVE.
MRG MYISAM、MYISAM、InnoBDB。
3. 这六种又分为两类
  + 一类是”事务安全型”(transaction-safe) 支持事务，比如: InnoDB;
  + 其余都属于第二类，称为”非事务安全型”(non-transaction-safe) 不支持事务 [mysiam和memory].

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512164743675.png)

### 主要的存储引擎/表类型特点

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512164827538.png)

### 细节说明

重点介绍三种: MyISAM、InnoDB、MEMORY

1. MylSAM不支持事务、也不支持外键，但其访问速度快，对事务完整性没有要求
1. InnoDB存储引擎提供了具有提交、回滚和崩溃恢复能力的事务安全。但是比起
MylSAM存储引擎，InnoDB写的处理效率差一些并且会占用更多的磁盘空间以保留数据和索引。
3. MEMORY存储引擎使用存在内存中的内容来创建表。每个MEMORY表只实际对应
个磁盘文件。MEMORY类型的表访问非常得快，因为它的数据是放在内存中的，并且默认使用HASH索引。但是**一旦MySQL服务关闭，表中的数据就会丢失掉**, 表的结构还在。

### 三种存储引擎表使用案例

```sql
-- 表类型和存储引擎

-- 查看所有的存储引擎
SHOW ENGINES
-- innodb 存储引擎，是前面使用过.
-- 1. 支持事务 2. 支持外键 3. 支持行级锁

-- myisam 存储引擎
CREATE TABLE t28 (
	id INT,
	`name` VARCHAR(32)) ENGINE MYISAM
-- 1. 添加速度快 2. 不支持外键和事务 3. 支持表级锁

START TRANSACTION;
SAVEPOINT t1
INSERT INTO t28 VALUES(1, 'jack');
SELECT * FROM t28;
ROLLBACK TO t1

-- memory 存储引擎
-- 1. 数据存储在内存中[关闭了Mysql服务，数据丢失, 但是表结构还在] 
-- 2. 执行速度很快(没有IO读写) 3. 默认支持索引(hash表)

CREATE TABLE t29 (
	id INT,
	`name` VARCHAR(32)) ENGINE MEMORY
DESC t29 -- 表结构还在
INSERT INTO t29
	VALUES(1,'tom'), (2,'jack'), (3, 'hsp');
SELECT * FROM t29

-- 指令修改存储引擎
ALTER TABLE `t29` ENGINE = INNODB
```

### 如何选择表的存储引擎

1. 如果你的应用不需要事务，处理的只是基本的CRUD操作，那么MylSAM
   是不二选择,速度快
2. 如果需要支持事务,选择lnnoDB。

3. Memory存储引擎就是将数据存储在内存中，由于没有磁盘I/O的等待, 速度极快。但由于是内存存储引擎，所做的任何修改在服务器重启后都将消失。(经典用法用户的在线状态()

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512165749727.png)

### 修改存储引擎

```sql
ALTER TABLE `表名` ENGINE = 储存引擎;
```

## 视图(view)

### 看一个需求

emp表的列信息很多，有些信息是个人重要信息(比如sal, comm,mgr, hiredate)，如果我们希望某个用户只能查询emp表的(empno,ename, job和deptno)信息，有什么办法?=>视图

### 基本概念

1. 视图是一个虚拟表，其内容由查询定义。同真实的表一样，视图包含列，其数据来自**对应的真实表(基表)**

2. 视图和基表关系的示意图：

   ![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512194118735.png)

### 视图的基本使用

1. create view 视图名 as select语句
2. alter view 视图名 as select语句 --更新成新的视图
2. SHOW CREATE VIEW 视图名
4. drop view 视图名1,视图名2

```sql
-- 视图的使用
-- 创建一个视图emp_view01，只能查询emp表的(empno、ename, job 和 deptno ) 信息

-- 创建视图
CREATE VIEW emp_view01
	AS
	SELECT empno, ename, job, deptno FROM emp; 

-- 查看视图
DESC emp_view01

SELECT * FROM emp_view01;
SELECT empno, job  FROM emp_view01;

-- 查看创建视图的指令
SHOW CREATE VIEW emp_view01
-- 删除视图
DROP VIEW emp_view01;


-- 视图的细节

-- 1. 创建视图后，到数据库去看，对应视图只有一个视图结构文件(形式: 视图名.frm) 
-- 2. 视图的数据变化会影响到基表，基表的数据变化也会影响到视图[insert update delete ]

-- 修改视图 会影响到基表

UPDATE emp_view01 
	SET job = 'MANAGER' 
	WHERE empno = 7369
	
SELECT * FROM emp; -- 查询基表


SELECT * FROM emp_view01

-- 修改基本表， 会影响到视图

UPDATE emp 
	SET job = 'SALESMAN' 
	WHERE empno = 7369

-- 3. 视图中可以再使用视图 , 比如从emp_view01 视图中，选出empno,和ename做出新视图
DESC emp_view01

CREATE VIEW emp_view02
	AS
	SELECT empno, ename FROM emp_view01
	
SELECT * FROM emp_view02
```

### 视图细节讨论

1. 创建视图后，到数据库去看，对应视图只有一个视图结构文件(形式:视图名.frm)
2. 视图的数据变化会影响到基表，基表的数据变化也会影响到视图[insert update delete ]
3. 视图中可以再使用视图，数据仍然来自基表.

### 视图最佳实践

1. 安全。一些数据表有着重要的信息。有些字段是保密的，不能让用户直接看到。这时就可以创建一个视图，在这张视图中只保留一部分字段。这样，用户就可以查询自己需要的字段,不能查看保密的字段。
2. 性能。关系数据库的数据常常会分表存储，使用外键建立这些表的之间关系。这时,数据库查询通常会用到连接(**JOIN**)。这样做不但麻烦，效率相对也比较低。如果建立一个视图，将相关的表和字段组合在一起，就可以避免使用**JOIN**查询数据。
3. 灵活。如果系统中有一张旧的表，这张表由于设计的问题，即将被废弃。然而，很多应用都是基于这张表，不易修改。这时就可以建立一张视图，视图中的数据直接映射到**新建**的表。这样，就可以少做很多改动，也达到了升级数据表的目的。

### 视图课堂练习

```sql
-- 视图的课堂练习
-- 针对 emp，dept , 和 salgrade 张三表.创建一个视图 emp_view03，
-- 可以显示雇员编号，雇员名，雇员部门名称和 薪水级别[即使用三张表，构建一个视图]
/*
	分析: 使用三表联合查询，得到结果
	将得到的结果，构建成视图
*/
CREATE VIEW emp_view03
	AS
	SELECT empno, ename, dname, grade
	FROM emp, dept, salgrade
	WHERE emp.deptno = dept.deptno AND 
	(sal BETWEEN losal AND hisal) 

DESC emp_view03
SELECT * FROM emp_view03
```

## Mysql 管理

### Mysql 用户

mysql中的用户，都存储在系数据库`mysql`中`user`表中

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512200635976.png)

其中user表的重要字段说明:
1. host: 允许登录的“位置”，localhost表示该用户只允许本机登录，也可以指定ip地址，比如:192.168.1.100
2. user:用户名;
3. authentication string:密码，是通过mysql的password()函数加密之后
的密码。

### 创建用户

```sql
create user '用户名'@'允许登录位置' identified by '密码'
```

说明:创建用户，同时指定密码

### 删除用户

```sql
drop user '用户名'@'允许登录位置';
```

### 用户修改密码

修改自己的密码:

```sql
set password = password('密码');
```

修改他人的密码(需要有修改用户密码权限):

```sql
set password for '用户名'@'登录位置'=password('密码');
```

### mysql 中的权限

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512200614120.png)

### 给用户授权

基本语法:

```sql
grant 权限列表 on 库.对象名 to '用户名'@'登录位置'【identified  by '密码'】
```

说明:

1. 权限列表，多个权限用逗号分开

   grant select on .....

   grant select,delete,create on ......

   grant all [privileges] on .... //表示赋予该用户在该对象上的所有权限

2. 特别说明
   `*.*`:代表本系统中的所有数据库的所有对象(表，视图，存储过程)

   `库.*`:表示某个数据库中的所有数据对象(表，视图，存储过程等)

3. identified by可以省略，也可以写出.

   (1)如果用户存在，就是同时修改该用户的密码。

   (2)如果该用户不存在，就是创建该用户!

### 回收用户授权

基本语法:

```sql
revoke 权限列表 on 库.对象名 from '用户名'@'登录位置';
```

### 权限生效指令

如果权限没有生效，可以执行下面命令，基本语法:

```sql
FLUSH PRIVILEGES;
```

```sql
-- Mysql用户的管理
-- 原因：当我们做项目开发时，可以根据不同的开发人员，赋给他相应的Mysql操作权限
-- 所以，Mysql数据库管理人员(root), 根据需要创建不同的用户，赋给相应的权限，供人员使用

-- 1. 创建新的用户
-- 解读 (1) 'hsp_edu'@'localhost' 表示用户的完整信息 'hsp_edu' 用户名 'localhost' 登录的IP
-- (2) 123456 密码, 但是注意 存放到 mysql.user表时，是password('123456') 加密后的密码
--     *6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9
CREATE USER 'hsp_edu'@'localhost' IDENTIFIED BY '123456'

SELECT `host`, `user`, authentication_string  
	FROM mysql.user

-- 2. 删除用户
DROP USER 'hsp_edu'@'localhost'

-- 3. 登录

-- root 用户修改 hsp_edu@localhost 密码, 是可以成功.
SET PASSWORD FOR 'hsp_edu'@'localhost' = PASSWORD('123456')
```

### 课堂练习题

用户管理练习题

1. 创建一个用户(你的名字，拼音)，密码123，并且只可以从本地登录，不让远程登录mysql
2. 创建库和表testdb下的news表,要求:使用root用户创建
3. 给用户分配查看news表和添加数据的权限
4. 测试看看用户是否只有这几个权限
5. 修改密码为abc ,要求:使用root用户完成
6. 重新登录
7. 使用root 用户删除你的用户

```sql
-- 演示 用户权限的管理

-- 创建用户 shunping  密码 123 , 从本地登录
CREATE USER 'shunping'@'localhost' IDENTIFIED BY '123'

-- 使用root 用户创建 testdb  ,表 news
CREATE DATABASE testdb
CREATE TABLE news (
	id INT ,
	content VARCHAR(32));
-- 添加一条测试数据
INSERT INTO news VALUES(100, '北京新闻');
SELECT * FROM news;

-- 给 shunping 分配查看 news 表和 添加news的权限
GRANT SELECT , INSERT 
	ON testdb.news
	TO 'shunping'@'localhost'
	
-- 可以增加update权限
GRANT UPDATE  
	ON testdb.news
	TO 'shunping'@'localhost'
	
	
-- 修改 shunping的密码为 abc
SET PASSWORD FOR 'shunping'@'localhost' = PASSWORD('abc');

-- 回收 shunping 用户在 testdb.news 表的所有权限
REVOKE SELECT , UPDATE, INSERT ON testdb.news FROM 'shunping'@'localhost'
REVOKE ALL ON testdb.news FROM 'shunping'@'localhost'

-- 删除 shunping
DROP USER 'shunping'@'localhost'
```

### 细节说明

1. 在创建用户的时候，如果不指定Host,则为%，**%表示表示所有IP都有连接权限**

   ```
   create user XX;
   ```

2. 你也可以这样指定
   `create user 'xxx'@'192.168.1.%' `表示xx用户在 `192.168.1.*` 的ip可以登录mysql

3. 在删除用户的时候，如果 host 不是%, 需要明确指定‘用户'@'host值'

```sql
-- 说明 用户管理的细节
-- 在创建用户的时候，如果不指定Host, 则为% , %表示表示所有IP都有连接权限 
-- create user  xxx;

CREATE USER jack

SELECT `host`, `user` FROM mysql.user

-- 你也可以这样指定 
-- create user  'xxx'@'192.168.1.%'  表示 xxx用户在 192.168.1.*的ip可以登录mysql

CREATE USER 'smith'@'192.168.1.%'

-- 在删除用户的时候，如果 host 不是 %, 需要明确指定  '用户'@'host值'

DROP USER jack -- 默认就是 DROP USER 'jack'@'%'

DROP USER 'smith'@'192.168.1.%'
```

## 本章作业

1.选择题

(1).以下哪条语句是错误的?[D]

```sql
A.SELECT empno,ename name,sal salary FROM emp;
B.SELECT empno,ename name,sal AS salary FROM emp;
C.SELECT ename,sal*12 AS "Annual Salary" FROM emp;
D.SELECT ename,sal*12 Annual Salary FROM emp; -- 有空格最好引起来
```

(2).某用户希望显示补助非空的所有雇员信息，应该使用哪条语句?[B]

```sql
A.SELECT ename.sal,comm FROM emp WHERE comm<>null;
B.SELECT ename,sal,comm FROM emp WHERE comm IS NOT null;
C.SELECT ename,sal,comm FROM emp WHERE comm<>0;
```

(3).以下哪条语句是错误的?[C]

```sql
A.SELECT ename,sal salary FROM emp ORDER BY sal;
B.SELECT ename,sal salary FROM emp ORDER BY salary；
C. SELECT ename,sal salary FROM emp ORDER BY 3;
```

2.写础查看DEPT表和EMP表的结构的sql语句

```sql
-- 2. 写出 查看DEPT表和EMP表的结构 的sql语句
-- 
	DESC dept
	DESC emp
```

3.使用简单查询语句完成:

(1)显示所有部门名称。

(2)显示所有雇员名及其全年收入13月(工资+补助),并指定列别名"年收入”

```sql
-- 3. 使用简单查询语句完成:
-- (1) 显示所有部门名称。
SELECT dname 
	FROM dept;
-- (2) 显示所有雇员名及其全年收入 13月(工资+补助),并指定列别名"年收入"
SELECT ename, (sal + IFNULL(comm,0)) * 13 AS "年收入"
	FROM emp 
SELECT * FROM emp;
```

4.限制查询数据。
(1)显示工资超过2850的雇员姓名和工资。

(2)显示工资不在1500到2850之间的所有雇员名及工资。

(3)显示编号为7566的雇员姓名及所在部门编号。

(4)显示部门10和30中工资超过1500的雇员名及工资。

(5)显示无管理者的雇员名及岗位。

```sql
-- 4.限制查询数据。
-- (1) 显示工资超过2850的雇员姓名和工资。
SELECT ename, sal
	FROM emp 
	WHERE sal > 2850
-- (2) 显示工资不在1500到2850之间的所有雇员名及工资。
SELECT ename, sal
	FROM emp 
	WHERE sal < 1500 OR sal > 2850
	
SELECT ename, sal
	FROM emp 
	WHERE NOT (sal >= 1500 AND sal <= 2850)
-- (3) 显示编号为7566的雇员姓名及所在部门编号。
SELECT ename, deptno
	FROM emp 
	WHERE empno = 7566
-- (4) 显示部门10和30中工资超过1500的雇员名及工资。
SELECT ename, job
	FROM emp 
	WHERE (deptno = 10 OR deptno = 30) AND sal > 1500
-- (5) 显示无管理者的雇员名及岗位。
SELECT ename, job 
	FROM emp
	WHERE mgr IS NULL;
```

5.排序数据。

1)显示在1991年2月1日到1991年5月1日之间雇用的雇员名,岗位及雇佣日期,并以雇佣日期进行排序[默认]。

2)显示获得补助的所有雇员名,工资及补助,并以工资降序排序

```sql
-- 5.排序数据。
-- (1) 显示在1991年2月1日到1991年5月1日之间雇用的雇员名,岗位及雇佣日期, 
-- 并以雇佣日期进行排序[默认]。
-- 思路 1. 先查询到对应结果 2. 考虑排序
SELECT ename, job, hiredate
	FROM emp
	WHERE hiredate >= '1991-02-01' AND hiredate <= '1991-05-01'
	ORDER BY hiredate

-- (2) 显示获得补助的所有雇员名,工资及补助,并以工资降序排序
SELECT ename, sal, comm
	FROM emp
	ORDER BY sal DESC
```

6.根据:emp员工表写出正确SQL

--1.选择部门30中的所有员工.

--2.列出所有办事员(CLERK)的姓名，编号和部门编号

--3.找出佣金高于薪金的员工.

--4.找出佣金高于薪金60%的员工.

--5.找出部门10中所有经理(MANAGER)和部门20中所有办事员(CLERK)的详细资料.

--6.找出部门10中所有经理(MANAGER),部门20中所有办事员(CLERK),还有既不是经理又不是办事员但其薪金大于或等于2000的所有员工的详细资料.

--7.找出收取佣金的员工的不同工作.

--8.找出不收取佣金或收取的佣金低于100的员工.--9.找出各月倒数第3天受雇的所有员工.

--10.找出早于12年前受雇的员工.

--11.以首字母小写的方式显示所有员工的姓名.

--12.显示正好为5个字符的员工的姓名.

--13.显示不带有"R"的员工的姓名.

--14.显示所有员工姓名的前三个字符.

--15.显示所有员工的姓名,用a替换所有"A"

--16.显示满10年服务年限的员工的姓名和受雇日期.

--17.显示员工的详细资料,按姓名排序.

--18.显示员工的姓名和受雇日期,根据其服务年限,将最老的员工排在最前面.

--19.显示所有员工的姓名、工作和薪金,按工作降序排序,若工作相同则按薪金排序.

--20.显示所有员工的姓名、加入公司的年份和月份,按受雇日期所在月排序,若月份相同则将最早年份的员工排在最前面.

--21.显示在一个月为30天的情况所有员工的日薪金,忽略余数.

--22.找出在(任何年份的)2月受聘的所有员工。

--23.对于每个员工,显示其加入公司的天数.

--24.显示姓名字段的任何位置包含"A"的所有员工的姓名.

--25.以年月日的方式显示所有员工的服务年限.(大概)

```sql
-- homework03

-- ------1.选择部门30中的所有员工.
SELECT * FROM 
	emp
	WHERE deptno = 30
-- ------2.列出所有办事员(CLERK)的姓名，编号和部门编号. 
SELECT ename, empno, deptno, job FROM 
	emp
	WHERE job = 'CLERK'
-- ------3.找出佣金高于薪金的员工.
SELECT * FROM 
	emp
	WHERE IFNULL(comm, 0) > sal
-- ------4.找出佣金高于薪金60%的员工.
SELECT * FROM 
	emp
	WHERE IFNULL(comm, 0) > sal * 0.6
-- ------5.找出部门10中所有经理(MANAGER)和部门20中所有办事员(CLERK)的详细资料.
-- 
SELECT * FROM
	emp
	WHERE (deptno = 10 AND job = 'MANAGER') 
	OR (deptno = 20 AND job = 'CLERK')
-- ------6.找出部门10中所有经理(MANAGER),部门20中所有办事员(CLERK), 
 -- 还有既不是经理又不是办事员但其薪金大于或等于2000的所有员工的详细资料.
SELECT * FROM
	emp
	WHERE (deptno = 10 AND job = 'MANAGER') 
	OR (deptno = 20 AND job = 'CLERK')
	OR (job != 'MANAGER' AND job != 'CLERK' AND sal >= 2000 )
-- ------7.找出收取佣金的员工的不同工作.
SELECT DISTINCT job
	FROM emp
	WHERE comm IS NOT NULL

-- ------8.找出不收取佣金或收取的佣金低于100的员工.
SELECT *
	FROM emp
	WHERE comm IS  NULL OR IFNULL(comm, 0) < 100
-- ------9.找出各月倒数第3天受雇的所有员工.
-- 提示: last_day(日期)， 可以返回该日期所在月份的最后一天
-- last_day(日期) - 2 得到日期所有月份的倒数第3天
SELECT * 
	FROM emp
	WHERE LAST_DAY(hiredate) - 2  =  hiredate

-- ------10.找出早于12年前受雇的员工.（即 入职时间超过12年）
SELECT * 
	FROM emp
	WHERE DATE_ADD(hiredate, INTERVAL 12 YEAR) < NOW() 

-- 
-- ------11.以首字母小写的方式显示所有员工的姓名.
SELECT CONCAT(LCASE(SUBSTRING(ename,1,1)), SUBSTRING(ename,2))
	FROM emp;
-- ------12.显示正好为5个字符的员工的姓名.

SELECT * 
	FROM emp
	WHERE LENGTH(ename) = 5

-- ------13.显示不带有"R"的员工的姓名.
SELECT * 
	FROM emp
	WHERE ename NOT LIKE '%R%'
-- ------14.显示所有员工姓名的前三个字符.
SELECT LEFT(ename,3)
	FROM emp
-- ------15.显示所有员工的姓名,用a替换所有"A"
SELECT REPLACE(ename, 'A', 'a') 
	FROM emp
-- ------16.显示满10年服务年限的员工的姓名和受雇日期.
SELECT ename, hiredate
	FROM emp
	WHERE DATE_ADD(hiredate, INTERVAL 10 YEAR) <= NOW()
-- ------17.显示员工的详细资料,按姓名排序.

-- ------18.显示员工的姓名和受雇日期,根据其服务年限,将最老的员工排在最前面.
-- 
SELECT ename, hiredate
	FROM emp
	ORDER BY hiredate 
-- ------19.显示所有员工的姓名、工作和薪金,按工作降序排序,若工作相同则按薪金排序.
SELECT ename, job, sal
	FROM emp
	ORDER BY job DESC, sal 
-- ------20.显示所有员工的姓名、加入公司的年份和月份,按受雇日期所在月排序,
-- 若月份相同则将最早年份的员工排在最前面.
SELECT ename, CONCAT(YEAR(hiredate),'-', MONTH(hiredate))
	FROM emp
	ORDER BY MONTH(hiredate), YEAR(hiredate)

-- ------21.显示在一个月为30天的情况所有员工的日薪金,忽略余数.
SELECT ename, FLOOR(sal / 30), sal / 30 
	FROM emp; 
-- ------22.找出在(任何年份的)2月受聘的所有员工。
SELECT * 
	FROM emp
	WHERE MONTH(hiredate) = 2
-- ------23.对于每个员工,显示其加入公司的天数.
-- 
SELECT ename, DATEDIFF(NOW(), hiredate) 
	FROM emp
-- ------24.显示姓名字段的任何位置包含"A"的所有员工的姓名.
SELECT *
	FROM emp
	WHERE ename LIKE '%A%'
-- ------25.以年月日的方式显示所有员工的服务年限.   (大概)

-- 思路 1. 先求出 工作了多少天 
SELECT ename, FLOOR(DATEDIFF(NOW(), hiredate) / 365) AS " 工作年 ", 
	FLOOR((DATEDIFF(NOW(), hiredate) % 365) / 31) AS " 工作月 ",
	DATEDIFF(NOW(), hiredate) % 31 AS " 工作天"
	FROM emp;
```

7.根据:emp员工表，dept部门表，工资=薪金sal＋佣金comm 写出正确SQL

(1)列出至少有一个员工的所有部门

(2)列出薪金比“SMITH”多的所有员工。

(3)列出受雇日期晚于其直接上级的所有员工。

(4)列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门

(5)列出所有“CLERK”(办事员)的姓名及其部门名称。

(6)列出最低薪金大于1500的各种工作。

(7)列出在部门“SALES”(销售部)工作的员工的姓名。

(8)列出薪金高于公司平均薪金的所有员工。

(9)列出与“SCOTT”从事相同工作的所有员工。

(10)列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金

(11)列出在每个部门工作的员工数量、平均工资和平均服务期限。

(12)列出所有员工的姓名、部门名称和工资。

(13)列出所有部门的详细信息和部门人数。

(14)列出各种工作的最低工资。

(15)列出MANAGER(经理)的最低薪金。

(16)列出所有员工的年工资,按年薪从低到高排序。

```sql
-- 
-- (1)．列出至少有一个员工的所有部门

/*
	先查出各个部门有多少人
	使用 having 子句过滤
*/
SELECT COUNT(*) AS c, deptno
	FROM emp 
	GROUP BY deptno 
	HAVING c > 1
-- (2)．列出薪金比“SMITH”多的所有员工。
/*
	先查出 smith 的 sal => 作为子查询
	然后其他员工 sal 大于 smith 即可
*/
SELECT * 
	FROM emp
	WHERE sal > (
		SELECT sal 
			FROM emp 
			WHERE ename = 'SMITH'
	)
-- (3)．列出受雇日期晚于其直接上级的所有员工。
/*
	先把 emp 表 当做两张表 worker , leader
	条件 1. worker.hiredate > leader.hiredate
	     2. worker.mgr = leader.empno
*/

SELECT worker.ename AS '员工名', worker.hiredate AS '员工入职时间',
	leader.ename  AS '上级名', leader.hiredate AS '上级入职时间' 
	FROM emp worker , emp leader
	WHERE worker.hiredate > leader.hiredate 
	AND worker.mgr = leader.empno;

-- (4)．列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。

/*
	这里因为需要显示所有部门，因此考虑使用外连接，(左外连接)
	如果没有印象了，去看看老师讲的外连接.
*/
SELECT dname, emp.*
	FROM dept 
	LEFT JOIN emp ON dept.deptno = emp.deptno 

-- (5)．列出所有“CLERK”（办事员）的姓名及其部门名称。

SELECT ename, dname , job
	FROM emp, dept
	WHERE job = 'CLERK' AND emp.deptno = dept.deptno

-- (6)．列出最低薪金大于1500的各种工作。

/*
	查询各个部门的最低工资
	使用having 子句进行过滤
*/
SELECT MIN(sal) AS min_sal , job
	FROM emp
	GROUP BY job
	HAVING min_sal > 1500
-- (7)．列出在部门“SALES”（销售部）工作的员工的姓名。

SELECT ename, dname
	FROM emp , dept
	WHERE emp.deptno = dept.deptno AND dname = 'SALES'

-- (8)．列出薪金高于公司平均薪金的所有员工。

SELECT *
	FROM emp
	WHERE sal > (
		SELECT AVG(sal) 
			FROM emp
	)

-- (9)．列出与“SCOTT”从事相同工作的所有员工。

SELECT * 
	FROM emp
	WHERE job = (
		SELECT job 
			FROM emp
			WHERE ename = 'SCOTT'
	) AND ename != 'SCOTT'

-- (10)．列出薪金高于所在部门30的工作的所有员工的薪金的员工姓名和薪金。


-- 先查询出30部门的最高工资
SELECT ename, sal 
	FROM emp 
	WHERE sal > (
		SELECT MAX(sal) 
			FROM emp
			WHERE deptno = 30
	) 
-- (11)．列出在每个部门工作的员工数量、平均工资和平均服务期限(时间单位)。
-- 老师建议 ， 写sql 也是一步一步完成的
SELECT COUNT(*) AS "部门员工数量", deptno , AVG(sal) AS "部门平均工资" , 
	FORMAT(AVG(DATEDIFF(NOW(), hiredate) / 365 ),2) AS " 平均服务期限(年)"
	FROM emp 
	GROUP BY deptno

-- (12)．列出所有员工的姓名、部门名称和工资。

-- 就是 emp 和 dept 联合查询 ，连接条件就是 emp.deptno = dept.deptno

-- (13)．列出所有部门的详细信息和部门人数。

-- 1. 先得到各个部门人数 , 把下面的结果看成临时表 和 dept表联合查询
SELECT COUNT(*) AS c , deptno 
	FROM emp
	GROUP BY deptno

-- 2. 
SELECT dept.*, tmp.c AS "部门人数"
	FROM dept, (
		SELECT COUNT(*) AS c , deptno 
		FROM emp
		GROUP BY deptno
	) tmp 
	WHERE dept.deptno = tmp.deptno

-- (14)．列出各种工作的最低工资。

SELECT MIN(sal), job
	FROM emp
	GROUP BY job
-- (15)．列出MANAGER（经理）的最低薪金。

SELECT MIN(sal), job
	FROM emp
	WHERE job = 'MANAGER'
-- (16)．列出所有员工的年工资,按年薪从低到高排序。

-- 1. 先得到员工的年工资
SELECT ename, (sal + IFNULL(comm, 0)) * 12 year_sal
	FROM emp
	ORDER BY year_sal 
```

8.设学校环境如下:一个系有若干个专业，每个专业一年只招一个班，每个班有若干个学生.现要建立关于系、学生、班级的数据库，关系模式为:

+ 班CLASS (班号classid，专业名subject，系名deptname，入学年份enrolltime，人数num)
+ 学生STUDENT(学号studentid，姓名name，年龄age，班号classid)
+ 系DEPARTMENT (系号departmentid，系名deptname)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512204037587.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230512204047760.png)

试用SQL语言完成以下功能:

(1)建表，在定义中要求声明:
	(1)每个表的主外码。

​	(2) deptname是唯一约束。

​	(3)学生姓名不能为空。

(2)插入如下数据

DEPARTMENT (001，数学; 002，计算机; 003,化学;004,中文;005，经济;)

(3)完成以下查询功能

​	3.1找出所有姓李的学生。

​	3.2列出所有开设超过1个专业的系的名字

​	3.3列出人数大于等于30的系的编号和名字。

(4)学校又新增加了一个物理系,编号为006

(5)学生张三退学，请更新相关的表

```sql
-- 完成最后一个综合的练习

-- 8. 设学校环境如下:一个系有若干个专业，每个专业一年只招一个班，每个班有若干个学生。
-- 现要建立关于系、学生、班级的数据库，关系模式为：
-- 班CLASS （班号classid，专业名subject，系名deptname，入学年份enrolltime，人数num）
-- 学生STUDENT （学号studentid，姓名name，年龄age，班号classid）
-- 系 DEPARTMENT （系号departmentid，系名deptname）
-- 试用SQL语言完成以下功能：  homework05.sql 10min 
-- 
-- (1) 建表，在定义中要求声明：
--     （1）每个表的主外码。
--     （2）deptname是唯一约束。
--     （3）学生姓名不能为空。

-- 创建表 系 DEPARTMENT （系号departmentid，系名deptname）
CREATE TABLE DEPARTMENT (
	departmentid VARCHAR(32) PRIMARY KEY,
	deptname VARCHAR(32) UNIQUE NOT NULL);
	
-- 班CLASS （班号classid，专业名subject，系名deptname，入学年份enrolltime，人数num）
CREATE TABLE `class` (
	classid INT PRIMARY KEY,
	`subject` VARCHAR(32) NOT NULL DEFAULT '',
	deptname VARCHAR(32) , -- 外键字段，在表定义后指定
	enrolltime INT NOT NULL DEFAULT 2000,
	num INT NOT NULL DEFAULT 0,
	FOREIGN KEY (deptname) REFERENCES  DEPARTMENT(deptname));
	
-- 学生STUDENT （学号studentid，姓名name，年龄age，班号classid）
CREATE TABLE hsp_student (
	studentid INT PRIMARY KEY,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	age INT NOT NULL DEFAULT 0,
	classid INT, -- 外键
	FOREIGN KEY (classid) REFERENCES  `class`(classid));
	
-- 添加测试数据

INSERT INTO department VALUES('001','数学');
INSERT INTO department VALUES('002','计算机');
INSERT INTO department VALUES('003','化学');
INSERT INTO department VALUES('004','中文');
INSERT INTO department VALUES('005','经济');

INSERT INTO class VALUES(101,'软件','计算机',1995,20);
INSERT INTO class VALUES(102,'微电子','计算机',1996,30);
INSERT INTO class VALUES(111,'无机化学','化学',1995,29);
INSERT INTO class VALUES(112,'高分子化学','化学',1996,25);
INSERT INTO class VALUES(121,'统计数学','数学',1995,20);
INSERT INTO class VALUES(131,'现代语言','中文',1996,20);
INSERT INTO class VALUES(141,'国际贸易','经济',1997,30);
INSERT INTO class VALUES(142,'国际金融','经济',1996,14);

INSERT INTO hsp_student VALUES(8101,'张三',18,101);
INSERT INTO hsp_student VALUES(8102,'钱四',16,121);
INSERT INTO hsp_student VALUES(8103,'王玲',17,131);
INSERT INTO hsp_student VALUES(8105,'李飞',19,102);
INSERT INTO hsp_student VALUES(8109,'赵四',18,141);
INSERT INTO hsp_student VALUES(8110,'李可',20,142);
INSERT INTO hsp_student VALUES(8201,'张飞',18,111);
INSERT INTO hsp_student VALUES(8302,'周瑜',16,112);
INSERT INTO hsp_student VALUES(8203,'王亮',17,111);
INSERT INTO hsp_student VALUES(8305,'董庆',19,102);
INSERT INTO hsp_student VALUES(8409,'赵龙',18,101);

SELECT * FROM department
SELECT * FROM class
SELECT * FROM hsp_student

-- (3) 完成以下查询功能
--   3.1 找出所有姓李的学生。
-- 查表 hsp_student , like
SELECT * 
	FROM hsp_student
	WHERE `name` LIKE '李%' 
--   3.2 列出所有开设超过1个专业的系的名字。

-- 1. 先查询各个系有多少个专业
SELECT COUNT(*) AS nums, deptname 
	FROM class
	GROUP BY deptname HAVING nums > 1
--   3.3 列出人数大于等于30的系的编号和名字。
-- 1. 先查出各个系有多少人, 并得到 >= 30 的系

SELECT SUM(num) AS nums, deptname  
	FROM class 
	GROUP BY  deptname 
	HAVING nums >= 30
	
-- 2. 将上面的结果看成一个临时表 和 department 联合查询即可

SELECT  tmp.*, department.departmentid
	FROM department , (
		SELECT SUM(num) AS nums, deptname  
		FROM class 
		GROUP BY  deptname 
		HAVING nums >= 30
	) tmp 
	WHERE department.deptname = tmp.deptname;
	


-- (4) 学校又新增加了一个物理系，编号为006
-- 添加一条数据
INSERT INTO department VALUES('006','物理系');
-- (5) 学生张三退学，请更新相关的表

-- 分析：1. 张三所在班级的人数-1 2. 将张三从学生表删除  3. 需要使用事务控制

-- 开启事务
START TRANSACTION;
-- 张三所在班级的人数-1 
UPDATE class SET num = num - 1
	WHERE classid = (
		SELECT classid 
			FROM hsp_student 
			WHERE NAME = '张三'
	);

DELETE 
	FROM hsp_student
	WHERE NAME = '张三';
	
-- 提交事务
COMMIT;

SELECT * FROM hsp_student;
SELECT * FROM class
```

