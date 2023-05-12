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