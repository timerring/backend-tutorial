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