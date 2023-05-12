-- 演示sql 注入
-- 创建一张表
CREATE TABLE  admin ( -- 管理员表
NAME VARCHAR(32) NOT NULL UNIQUE,
pwd VARCHAR(32) NOT NULL DEFAULT '') CHARACTER SET utf8;

-- 添加数据
INSERT INTO admin VALUES('tom', '123');

-- 查找某个管理是否存在

SELECT * 
	FROM admin
	WHERE NAME = 'tom' AND pwd = '123'
	
-- SQL 
-- 输入用户名 为  1' or 
-- 输入万能密码 为 or '1'= '1 
SELECT * 
	FROM admin
	WHERE NAME = '1' OR' AND pwd = 'OR '1'= '1'
SELECT * FROM admin
