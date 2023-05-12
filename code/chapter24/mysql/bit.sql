#演示bit类型使用
#说明
#1. bit(m) m 在 1-64
#2. 添加数据 范围 按照你给的位数来确定，比如m = 8 表示一个字节 0~255
#3. 显示按照bit 
#4. 查询时，仍然可以按照数来查询
CREATE TABLE t05 (num BIT(8));
INSERT INTO t05 VALUES(255); 
SELECT * FROM t05;
SELECT * FROM t05 WHERE num = 1;