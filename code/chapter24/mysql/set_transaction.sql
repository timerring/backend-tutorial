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

	