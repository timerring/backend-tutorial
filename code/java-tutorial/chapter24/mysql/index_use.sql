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


-- 修改索引 ， 先删除，在添加新的索引

-- 查询索引
-- 1. 方式
SHOW INDEX FROM t25
-- 2. 方式
SHOW INDEXES FROM t25
-- 3. 方式
SHOW KEYS FROM t25
-- 4 方式
DESC t25





