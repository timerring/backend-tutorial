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



