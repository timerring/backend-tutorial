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






	
	

