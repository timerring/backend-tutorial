-- 创建测试表 演员表

CREATE TABLE  actor ( -- 演员表
 id INT PRIMARY KEY AUTO_INCREMENT,
 NAME VARCHAR(32) NOT NULL DEFAULT '',
 sex CHAR(1) NOT NULL DEFAULT '女',
 borndate DATETIME ,
 phone VARCHAR(12));
 
SELECT * FROM actor

-- 增加2条记录，用于测试ResultSet
INSERT INTO actor 
	VALUES (NULL, 'jack', '男', '1990-11-11', '112');
	
	
CREATE TABLE  ACCOUNT(
  	id INT PRIMARY KEY AUTO_INCREMENT,
  	name varchar(32) not null default '',
  	balance double not null default 0) character set utf8;

insert into account values(null, '马云', 3000); 
insert into account values(null, '马化腾', 10000);

select * from goods
desc goods;

select * from account

-- 创建测试表
create table admin2
(id int primary key auto_increment , 
username varchar(32) not null , 
password varchar(32) not null);

select count(*) from admin2

drop table admin2



