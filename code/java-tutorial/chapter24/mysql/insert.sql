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
	